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
        return this.isSaturday(enteredAt) || this.isSaturday(exitedAt)
                || this.isSunday(enteredAt) || this.isSunday(exitedAt)
                || this.isJanuarySecond(enteredAt) || this.isJanuarySecond(exitedAt)
                || this.isJanuaryThird(enteredAt) || this.isJanuaryThird(exitedAt)
                || this.isHoliday(enteredAt) || this.isHoliday(exitedAt);
    }
    
    private boolean isSunday(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
    
    private boolean isSaturday(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek() == DayOfWeek.SATURDAY;
    }
    
    private boolean isHoliday(LocalDateTime dateTime) {
        return HolidayUtils.isHoliday(dateTime.toLocalDate());
    }
    
    private boolean isJanuarySecond(LocalDateTime dateTime) {
        return MonthDay.from(dateTime).equals(JANUARY_SECOND);
    }
    
    private boolean isJanuaryThird(LocalDateTime dateTime) {
        return MonthDay.from(dateTime).equals(JANUARY_THIRD);
    }
}
