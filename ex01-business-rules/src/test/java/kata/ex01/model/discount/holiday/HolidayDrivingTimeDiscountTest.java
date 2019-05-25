package kata.ex01.model.discount.holiday;

import org.junit.jupiter.api.Test;

import static kata.ex01.model.discount.DiscountTestUtils.*;
import static org.assertj.core.api.Assertions.*;

class HolidayDrivingTimeDiscountTest {

    private HolidayDrivingTimeDiscount discount = new HolidayDrivingTimeDiscount();

    @Test
    void 平日金曜_to_土曜_true() {
        assertThat(discount.matches(dateTime("2019-05-24 23:59"), dateTime("2019-05-25 00:00"))).isTrue();
    }

    @Test
    void 土曜_to_土曜_true() {
        assertThat(discount.matches(saturday("00:00"), saturday("23:59"))).isTrue();
    }

    @Test
    void 土曜_to_日曜_true() {
        assertThat(discount.matches(dateTime("2019-05-25 23:59"), dateTime("2019-05-26 00:00"))).isTrue();
    }

    @Test
    void 日曜_to_日曜_true() {
        assertThat(discount.matches(sunday("00:00"), sunday("23:59"))).isTrue();
    }

    @Test
    void 日曜_to_平日月曜_true() {
        assertThat(discount.matches(dateTime("2019-05-26 23:59"), dateTime("2019-05-27 00:00"))).isTrue();
    }

    @Test
    void 平日_to_平日_false() {
        assertThat(discount.matches(weekday("00:00"), weekday("23:59"))).isFalse();
    }

    @Test
    void 平日_to_祝日_true() {
        assertThat(discount.matches(dateTime("2019-03-20 23:59"), dateTime("2019-03-21 00:00"))).isTrue();
    }

    @Test
    void 祝日_to_祝日_true() {
        assertThat(discount.matches(dateTime("2019-03-21 00:00"), dateTime("2019-03-21 23:59"))).isTrue();
    }

    @Test
    void 祝日_to_平日_true() {
        assertThat(discount.matches(dateTime("2019-03-21 23:59"), dateTime("2019-03-22 00:00"))).isTrue();
    }

    @Test
    void 平日の１月２日_to_平日の１月２日_true() {
        assertThat(discount.matches(dateTime("2019-01-02 00:00"), dateTime("2019-01-02 23:59"))).isTrue();
    }

    @Test
    void 平日の１月３日_to_平日の１月４日_true() {
        assertThat(discount.matches(dateTime("2019-01-03 23:59"), dateTime("2019-01-04 00:00"))).isTrue();
    }

    @Test
    void 平日の１月４日_to_平日の１月４日_false() {
        assertThat(discount.matches(dateTime("2019-01-04 00:00"), dateTime("2019-01-04 23:59"))).isFalse();
    }
    
}