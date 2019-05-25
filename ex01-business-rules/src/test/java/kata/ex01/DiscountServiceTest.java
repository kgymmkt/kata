package kata.ex01;

import kata.ex01.model.Driver;
import kata.ex01.model.HighwayDrive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static kata.ex01.model.RouteType.RURAL;
import static kata.ex01.model.VehicleFamily.STANDARD;
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
    void test平日朝夕割引() {
        HighwayDrive drive = new HighwayDrive();
        
        drive.setEnteredAt(dateTime("2016-03-31 23:00"));
        drive.setExitedAt(dateTime("2016-04-01 06:30"));
        drive.setDriver(driver(10));
        drive.setVehicleFamily(STANDARD);
        drive.setRouteType(RURAL);

        assertThat(discountService.calc(drive)).isEqualTo(50);
    }

    @Test
    void test休日朝夕は休日割が適用される() {
        HighwayDrive drive = new HighwayDrive();
        
        drive.setEnteredAt(dateTime("2016-04-01 23:00"));
        drive.setExitedAt(dateTime("2016-04-02 06:30"));
        drive.setDriver(driver(10));
        drive.setVehicleFamily(STANDARD);
        drive.setRouteType(RURAL);

        assertThat(discountService.calc(drive)).isEqualTo(30);
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
