package kata.ex01.model.discount.holiday;

import kata.ex01.model.discount.DrivingDateTime;
import kata.ex01.model.discount.DrivingTimeDiscount;

import java.time.MonthDay;

/**
 * 休日割引対象日時.
 */
public class HolidayDrivingTimeDiscount implements DrivingTimeDiscount {
    private static final MonthDay JANUARY_SECOND = MonthDay.of(1, 2);
    private static final MonthDay JANUARY_THIRD = MonthDay.of(1, 3);
    
    @Override
    public boolean matches(DrivingDateTime enteredAt, DrivingDateTime exitedAt) {
        return enteredAt.isSaturday() || exitedAt.isSaturday()
                || enteredAt.isSunday() || exitedAt.isSunday()
                || enteredAt.is(JANUARY_SECOND) || exitedAt.is(JANUARY_SECOND)
                || enteredAt.is(JANUARY_THIRD) || exitedAt.is(JANUARY_THIRD)
                || enteredAt.isHoliday() || exitedAt.isHoliday();
    }
}
