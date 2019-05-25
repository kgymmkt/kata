package kata.ex01;

import kata.ex01.model.Driver;
import kata.ex01.model.HighwayDrive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static kata.ex01.model.RouteType.*;
import static kata.ex01.model.VehicleFamily.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kawasima
 */
class DiscountServiceTest {
    private DiscountService discountService;

    @BeforeEach
    void setUp() {
        discountService = new DiscountServiceImpl();
    }

    @Test
    void test深夜割引() {
        HighwayDrive drive = new HighwayDrive();

        drive.setEnteredAt(dateTime("2016-03-31 23:00"));
        drive.setExitedAt(dateTime("2016-04-01 06:30"));
        drive.setDriver(driver(10));
        drive.setVehicleFamily(OTHER);
        drive.setRouteType(RURAL);

        assertThat(discountService.calc(drive)).isEqualTo(30);
    }

    @Test
    void test平日朝夕割引() {
        HighwayDrive drive = new HighwayDrive();
        
        drive.setEnteredAt(dateTime("2016-04-01 05:00"));
        drive.setExitedAt(dateTime("2016-04-01 06:30"));
        drive.setDriver(driver(10));
        drive.setVehicleFamily(STANDARD);
        drive.setRouteType(URBAN);

        assertThat(discountService.calc(drive)).isEqualTo(50);
    }

    @Test
    void test休日朝夕は休日割が適用される() {
        HighwayDrive drive = new HighwayDrive();
        
        drive.setEnteredAt(dateTime("2016-04-02 05:00"));
        drive.setExitedAt(dateTime("2016-04-02 06:30"));
        drive.setDriver(driver(10));
        drive.setVehicleFamily(STANDARD);
        drive.setRouteType(URBAN);

        assertThat(discountService.calc(drive)).isEqualTo(30);
    }

    @Test
    void test割引なし() {
        HighwayDrive drive = new HighwayDrive();

        drive.setEnteredAt(dateTime("2016-04-02 08:00"));
        drive.setExitedAt(dateTime("2016-04-02 13:00"));
        drive.setDriver(driver(8));
        drive.setVehicleFamily(STANDARD);
        drive.setRouteType(RURAL); // 地方道以外

        assertThat(discountService.calc(drive)).isEqualTo(0);
    }

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
    
    private static Driver driver(int usingCount) {
        Driver driver = new Driver();
        driver.setCountPerMonth(usingCount);
        return driver;
    }

    private static LocalDateTime dateTime(String time) {
        return LocalDateTime.parse(time, dateTimeFormatter);
    }
}
