package kata.ex01.model.discount.weekday;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;

class WeekdayDrivingTimeDiscountTest {

    private WeekdayDrivingTimeDiscount discount = new WeekdayDrivingTimeDiscount();
    
    @Nested
    class 平日 {
        @Test
        void 早朝_to_朝_true() {
            assertThat(discount.matches(weekday("05:30"), weekday("06:00"))).isTrue();
        }
        
        @Test
        void 朝_to_朝_true() {
            assertThat(discount.matches(weekday("06:00"), weekday("06:30"))).isTrue();
        }

        @Test
        void 朝_to_昼_true() {
            assertThat(discount.matches(weekday("06:00"), weekday("09:01"))).isTrue();
        }

        @Test
        void 早朝_to_昼_false() {
            assertThat(discount.matches(weekday("05:59"), weekday("09:01"))).isFalse();
        }

        @Test
        void 昼_to_昼_false() {
            assertThat(discount.matches(weekday("09:01"), weekday("16:59"))).isFalse();
        }

        @Test
        void 昼_to_夕_true() {
            assertThat(discount.matches(weekday("16:30"), weekday("17:00"))).isTrue();
        }

        @Test
        void 夕_to_夕_true() {
            assertThat(discount.matches(weekday("17:00"), weekday("20:00"))).isTrue();
        }

        @Test
        void 夕_to_夜_true() {
            assertThat(discount.matches(weekday("20:00"), weekday("20:30"))).isTrue();
        }

        @Test
        void 昼_to_夜_false() {
            assertThat(discount.matches(weekday("16:59"), weekday("20:01"))).isFalse();
        }
    }

    @Nested
    class 土曜日 {
        @Test
        void 金曜夕_to_土曜夜_true() {
            assertThat(discount.matches(dateTime("2019-05-24 20:00"), dateTime("2019-05-25 01:00"))).isTrue();
        }
        
        @Test
        void 金曜夜_to_土曜朝_false() {
            assertThat(discount.matches(dateTime("2019-05-24 23:30"), dateTime("2019-05-25 06:30"))).isFalse();
        }
        
        @Test
        void 朝_to_朝_false() {
            assertThat(discount.matches(saturday("06:30"), saturday("07:00"))).isFalse();
        }

        @Test
        void 夕_to_夕_false() {
            assertThat(discount.matches(saturday("17:30"), saturday("18:00"))).isFalse();
        }
    }

    @Nested
    class 日曜日 {

        @Test
        void 朝_to_朝_false() {
            assertThat(discount.matches(sunday("06:30"), sunday("07:00"))).isFalse();
        }

        @Test
        void 夕_to_夕_false() {
            assertThat(discount.matches(sunday("17:30"), sunday("18:00"))).isFalse();
        }

        @Test
        void 日曜夕_to_月曜夜_false() {
            assertThat(discount.matches(dateTime("2019-05-26 20:00"), dateTime("2019-05-27 01:00"))).isFalse();
        }

        @Test
        void 日曜夜_to_月曜朝_true() {
            assertThat(discount.matches(dateTime("2019-05-26 23:50"), dateTime("2019-05-27 06:00"))).isTrue();
        }
    }

    @Nested
    class 祝日 {

        @Test
        void 平日夕_to_祝日夜_true() {
            assertThat(discount.matches(dateTime("2019-03-20 19:00"), dateTime("2019-03-22 01:00"))).isTrue();
        }

        @Test
        void 平日夜_to_祝日朝_false() {
            assertThat(discount.matches(dateTime("2019-03-20 23:30"), dateTime("2019-03-21 06:30"))).isFalse();
        }
        
        @Test
        void 朝_to_朝_false() {
            assertThat(discount.matches(holiday("06:30"), holiday("07:00"))).isFalse();
        }

        @Test
        void 夕_to_夕_false() {
            assertThat(discount.matches(holiday("17:30"), holiday("18:00"))).isFalse();
        }

        @Test
        void 祝日夕_to_平日夜_false() {
            assertThat(discount.matches(dateTime("2019-03-21 19:30"), dateTime("2019-03-22 01:00"))).isFalse();
        }

        @Test
        void 祝日夜_to_平日朝_true() {
            assertThat(discount.matches(dateTime("2019-03-21 23:30"), dateTime("2019-03-22 08:00"))).isTrue();
        }
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
    
    private LocalDateTime weekday(String time) {
        return LocalDateTime.parse("2019-05-24 " + time, formatter);
    }
    
    private LocalDateTime saturday(String time) {
        return LocalDateTime.parse("2019-05-25 " + time, formatter);
    }

    private LocalDateTime sunday(String time) {
        return LocalDateTime.parse("2019-05-26 " + time, formatter);
    }

    private LocalDateTime holiday(String time) {
        return LocalDateTime.parse("2019-05-06 " + time, formatter);
    }

    private LocalDateTime dateTime(String time) {
        return LocalDateTime.parse(time, formatter);
    }
}