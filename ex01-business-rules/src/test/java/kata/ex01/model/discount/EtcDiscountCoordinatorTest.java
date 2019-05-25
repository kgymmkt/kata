package kata.ex01.model.discount;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.discount.holiday.HolidayDiscount;
import kata.ex01.model.discount.midnight.MidnightDiscount;
import kata.ex01.model.discount.weekday.WeekdayDiscount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class EtcDiscountCoordinatorTest {

    @Test
    void どの割引も対象とならなかった場合は割引なしを採用() {
        EtcDiscountCoordinator coordinator = new EtcDiscountCoordinator(
                weekday(false),
                holiday(false),
                midnight(false)
        );

        EtcDiscount discount = coordinator.decideDiscount(new HighwayDrive());

        assertThat(discount).isInstanceOf(NoDiscount.class);
    }

    @Test
    void 平日朝夕割引のみが対象となった場合は_平日朝夕割引を採用() {
        EtcDiscountCoordinator coordinator = new EtcDiscountCoordinator(
                weekday(true),
                holiday(false),
                midnight(false)
        );

        EtcDiscount discount = coordinator.decideDiscount(new HighwayDrive());

        assertThat(discount).isInstanceOf(WeekdayDiscount.class);
    }

    @Test
    void 休日割引のみが対象となった場合は_休日割引を採用() {
        EtcDiscountCoordinator coordinator = new EtcDiscountCoordinator(
                weekday(false),
                holiday(true),
                midnight(false)
        );

        EtcDiscount discount = coordinator.decideDiscount(new HighwayDrive());

        assertThat(discount).isInstanceOf(HolidayDiscount.class);
    }

    @Test
    void 深夜割引のみが対象となった場合は_深夜割引を採用() {
        EtcDiscountCoordinator coordinator = new EtcDiscountCoordinator(
                weekday(false),
                holiday(false),
                midnight(true)
        );

        EtcDiscount discount = coordinator.decideDiscount(new HighwayDrive());

        assertThat(discount).isInstanceOf(MidnightDiscount.class);
    }

    @Test
    void 平日朝夕割引と休日割引が対象となった場合は_休日割引を採用() {
        EtcDiscountCoordinator coordinator = new EtcDiscountCoordinator(
                weekday(true),
                holiday(true),
                midnight(false)
        );

        EtcDiscount discount = coordinator.decideDiscount(new HighwayDrive());

        assertThat(discount).isInstanceOf(HolidayDiscount.class);
    }

    @Test
    void 平日朝夕割引と深夜割引が対象となった場合は_深夜割引を採用() {
        EtcDiscountCoordinator coordinator = new EtcDiscountCoordinator(
                weekday(true),
                holiday(false),
                midnight(true)
        );

        EtcDiscount discount = coordinator.decideDiscount(new HighwayDrive());

        assertThat(discount).isInstanceOf(MidnightDiscount.class);
    }

    @Test
    void 休日割引と深夜割引が対象となった場合は_休日割引を採用() {
        EtcDiscountCoordinator coordinator = new EtcDiscountCoordinator(
                weekday(false),
                holiday(true),
                midnight(true)
        );

        EtcDiscount discount = coordinator.decideDiscount(new HighwayDrive());

        assertThat(discount).isInstanceOf(HolidayDiscount.class);
    }

    @Test
    void すべての割引が対象となった場合は休日割引を採用() {
        EtcDiscountCoordinator coordinator = new EtcDiscountCoordinator(
            weekday(true),
            holiday(true),
            midnight(true)
        );
        
        EtcDiscount discount = coordinator.decideDiscount(new HighwayDrive());
        
        assertThat(discount).isInstanceOf(HolidayDiscount.class);
    }
    
    private WeekdayDiscount weekday(boolean match) {
        WeekdayDiscount mock = mock(WeekdayDiscount.class);
        when(mock.matches(any())).thenReturn(match);
        return mock;
    }
    
    private HolidayDiscount holiday(boolean match) {
        HolidayDiscount mock = mock(HolidayDiscount.class);
        when(mock.matches(any())).thenReturn(match);
        return mock;
    }
    
    private MidnightDiscount midnight(boolean match) {
        MidnightDiscount mock = mock(MidnightDiscount.class);
        when(mock.matches(any())).thenReturn(match);
        return mock;
    }
}