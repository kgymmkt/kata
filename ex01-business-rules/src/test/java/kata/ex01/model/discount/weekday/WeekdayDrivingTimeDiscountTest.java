package kata.ex01.model.discount.weekday;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static kata.ex01.model.discount.DiscountTestUtils.*;
import static org.assertj.core.api.Assertions.*;

class WeekdayDrivingTimeDiscountTest {

    private WeekdayDrivingTimeDiscount discount = new WeekdayDrivingTimeDiscount();
    
    @Nested
    class 平日 {
        @Test
        void 早朝_to_朝_true() {
            assertThat(discount.matches(weekday("05:59"), weekday("06:00"))).isTrue();
        }
        
        @Test
        void 朝_to_朝_true() {
            assertThat(discount.matches(weekday("06:00"), weekday("08:59"))).isTrue();
        }

        @Test
        void 朝_to_昼_true() {
            assertThat(discount.matches(weekday("08:59"), weekday("09:00"))).isTrue();
        }

        @Test
        void 早朝_to_昼_false() {
            assertThat(discount.matches(weekday("05:59"), weekday("09:00"))).isFalse();
        }

        @Test
        void 昼_to_昼_false() {
            assertThat(discount.matches(weekday("09:00"), weekday("16:59"))).isFalse();
        }

        @Test
        void 昼_to_夕_true() {
            assertThat(discount.matches(weekday("16:59"), weekday("17:00"))).isTrue();
        }

        @Test
        void 夕_to_夕_true() {
            assertThat(discount.matches(weekday("17:00"), weekday("19:59"))).isTrue();
        }

        @Test
        void 夕_to_夜_true() {
            assertThat(discount.matches(weekday("19:59"), weekday("20:00"))).isTrue();
        }

        @Test
        void 昼_to_夜_false() {
            assertThat(discount.matches(weekday("16:59"), weekday("20:00"))).isFalse();
        }

        @Test
        void 夜_to_夜_false() {
            assertThat(discount.matches(weekday("20:00"), weekday("23:00"))).isFalse();
        }
    }

    @Nested
    class 土曜日 {
        @Test
        void 平日金曜夕_to_土曜夜_true() {
            assertThat(discount.matches(dateTime("2019-05-24 19:59"), dateTime("2019-05-25 01:00"))).isTrue();
        }
        
        @Test
        void 平日金曜夜_to_土曜朝_false() {
            assertThat(discount.matches(dateTime("2019-05-24 20:00"), dateTime("2019-05-25 06:00"))).isFalse();
        }
        
        @Test
        void 朝_to_朝_false() {
            assertThat(discount.matches(saturday("06:00"), saturday("08:59"))).isFalse();
        }

        @Test
        void 夕_to_夕_false() {
            assertThat(discount.matches(saturday("17:00"), saturday("19:59"))).isFalse();
        }
    }

    @Nested
    class 日曜日 {

        @Test
        void 朝_to_朝_false() {
            assertThat(discount.matches(sunday("06:00"), sunday("08:59"))).isFalse();
        }

        @Test
        void 夕_to_夕_false() {
            assertThat(discount.matches(sunday("17:00"), sunday("18:59"))).isFalse();
        }

        @Test
        void 日曜夕_to_平日月曜夜_false() {
            assertThat(discount.matches(dateTime("2019-05-26 19:59"), dateTime("2019-05-27 01:00"))).isFalse();
        }

        @Test
        void 日曜夜_to_平日月曜朝_true() {
            assertThat(discount.matches(dateTime("2019-05-26 20:00"), dateTime("2019-05-27 06:00"))).isTrue();
        }
    }

    @Nested
    class 祝日 {

        @Test
        void 平日夕_to_祝日夜_true() {
            assertThat(discount.matches(dateTime("2019-03-20 19:59"), dateTime("2019-03-22 01:00"))).isTrue();
        }

        @Test
        void 平日夜_to_祝日朝_false() {
            assertThat(discount.matches(dateTime("2019-03-20 20:00"), dateTime("2019-03-21 06:00"))).isFalse();
        }
        
        @Test
        void 朝_to_朝_false() {
            assertThat(discount.matches(holiday("06:00"), holiday("08:59"))).isFalse();
        }

        @Test
        void 夕_to_夕_false() {
            assertThat(discount.matches(holiday("17:00"), holiday("18:59"))).isFalse();
        }

        @Test
        void 祝日夕_to_平日夜_false() {
            assertThat(discount.matches(dateTime("2019-03-21 19:59"), dateTime("2019-03-22 01:00"))).isFalse();
        }

        @Test
        void 祝日夜_to_平日朝_true() {
            assertThat(discount.matches(dateTime("2019-03-21 20:00"), dateTime("2019-03-22 06:00"))).isTrue();
        }
    }
}