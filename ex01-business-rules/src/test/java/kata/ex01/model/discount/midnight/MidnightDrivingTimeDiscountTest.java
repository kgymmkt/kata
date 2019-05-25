package kata.ex01.model.discount.midnight;

import org.junit.jupiter.api.Test;

import static kata.ex01.model.discount.DiscountTestUtils.*;
import static org.assertj.core.api.Assertions.*;

class MidnightDrivingTimeDiscountTest {
    
    private MidnightDrivingTimeDiscount discount = new MidnightDrivingTimeDiscount();

    @Test
    void _０時前_to_０時前_false() {
        assertThat(discount.matches(dateTime("2019-05-23 23:58"), dateTime("2019-05-23 23:59"))).isFalse();
    }

    @Test
    void _０時前_to_０時_true() {
        assertThat(discount.matches(dateTime("2019-05-23 23:59"), dateTime("2019-05-24 00:00"))).isTrue();
    }

    @Test
    void _０時前_to_０時過ぎ_true() {
        assertThat(discount.matches(dateTime("2019-05-23 23:59"), dateTime("2019-05-24 00:01"))).isTrue();
    }

    @Test
    void _０時前_to_４時前_true() {
        assertThat(discount.matches(dateTime("2019-05-23 23:59"), dateTime("2019-05-24 03:59"))).isTrue();
    }

    @Test
    void _０時前_to_４時_true() {
        assertThat(discount.matches(dateTime("2019-05-23 23:59"), dateTime("2019-05-24 04:00"))).isTrue();
    }
    
    

    @Test
    void _０時_to_０時過ぎ_true() {
        assertThat(discount.matches(dateTime("2019-05-24 00:00"), dateTime("2019-05-24 00:01"))).isTrue();
    }

    @Test
    void _０時_to_４時前_true() {
        assertThat(discount.matches(dateTime("2019-05-24 00:00"), dateTime("2019-05-24 03:59"))).isTrue();
    }

    @Test
    void _０時_to_４時_true() {
        assertThat(discount.matches(dateTime("2019-05-24 00:00"), dateTime("2019-05-24 04:00"))).isTrue();
    }

    

    @Test
    void _４時前_to_４時_true() {
        assertThat(discount.matches(dateTime("2019-05-24 03:59"), dateTime("2019-05-24 04:00"))).isTrue();
    }

    @Test
    void _４時前_to_４時過ぎ_true() {
        assertThat(discount.matches(dateTime("2019-05-24 03:59"), dateTime("2019-05-24 04:01"))).isTrue();
    }

    @Test
    void _４時_to_４時過ぎ_false() {
        assertThat(discount.matches(dateTime("2019-05-24 04:00"), dateTime("2019-05-24 04:01"))).isFalse();
    }
}