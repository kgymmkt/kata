package kata.ex01.model.discount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DiscountTestUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");

    public static LocalDateTime weekday(String time) {
        return LocalDateTime.parse("2019-05-24 " + time, formatter);
    }

    public static LocalDateTime saturday(String time) {
        return LocalDateTime.parse("2019-05-25 " + time, formatter);
    }

    public static LocalDateTime sunday(String time) {
        return LocalDateTime.parse("2019-05-26 " + time, formatter);
    }

    public static LocalDateTime holiday(String time) {
        return LocalDateTime.parse("2019-05-06 " + time, formatter);
    }

    public static LocalDateTime dateTime(String time) {
        return LocalDateTime.parse(time, formatter);
    }
    
    private DiscountTestUtils() {}
}
