package kata.ex01.model.discount.holiday;

import kata.ex01.model.discount.DrivingTimeDiscount;
import kata.ex01.util.HolidayUtils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.MonthDay;

/**
 * 休日割引対象日時.
 */
public class HolidayDrivingTimeDiscount implements DrivingTimeDiscount {
    private static final MonthDay JANUARY_SECOND = MonthDay.of(1, 2);
    private static final MonthDay JANUARY_THIRD = MonthDay.of(1, 3);
    
    @Override
    public boolean matches(LocalDateTime enteredAt, LocalDateTime exitedAt) {
        return enteredAt.getDayOfWeek() == DayOfWeek.SUNDAY
                || exitedAt.getDayOfWeek() == DayOfWeek.SATURDAY
                || MonthDay.from(enteredAt).equals(JANUARY_SECOND)
                || MonthDay.from(enteredAt).equals(JANUARY_THIRD)
                || HolidayUtils.isHoliday(enteredAt.toLocalDate())
                || HolidayUtils.isHoliday(exitedAt.toLocalDate());
    }
}
