package kata.ex01.model.discount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DiscountTestUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");

    public static DrivingDateTime weekday(String time) {
        return new DrivingDateTime(LocalDateTime.parse("2019-05-24 " + time, formatter));
    }

    public static DrivingDateTime saturday(String time) {
        return new DrivingDateTime(LocalDateTime.parse("2019-05-25 " + time, formatter));
    }

    public static DrivingDateTime sunday(String time) {
        return new DrivingDateTime(LocalDateTime.parse("2019-05-26 " + time, formatter));
    }

    public static DrivingDateTime holiday(String time) {
        return new DrivingDateTime(LocalDateTime.parse("2019-05-06 " + time, formatter));
    }

    public static DrivingDateTime dateTime(String time) {
        return new DrivingDateTime(LocalDateTime.parse(time, formatter));
    }
    
    private DiscountTestUtils() {}
}
