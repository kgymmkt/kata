package kata.ex01.model.discount.weekday;

import kata.ex01.model.discount.DrivingTimeDiscount;
import kata.ex01.util.HolidayUtils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 平日朝夕割引対象日時.
 */
public class WeekdayDrivingTimeDiscount implements DrivingTimeDiscount {
    private static final LocalTime MORNING_START_TIME = LocalTime.of(6, 0);
    private static final LocalTime MORNING_END_TIME = LocalTime.of(9, 0);
    
    private static final LocalTime EVENING_START_TIME = LocalTime.of(17, 0);
    private static final LocalTime EVENING_END_TIME = LocalTime.of(20, 0);
    
    @Override
    public boolean matches(LocalDateTime enteredAt, LocalDateTime exitedAt) {
        return this.isWeekdayMorning(enteredAt) || this.isWeekdayEvening(enteredAt)
                || this.isWeekdayMorning(exitedAt) || this.isWeekdayEvening(exitedAt);
    }
    
    private boolean isWeekdayMorning(LocalDateTime dateTime) {
        return this.isWeekday(dateTime) && this.between(dateTime, MORNING_START_TIME, MORNING_END_TIME);
    }
    
    private boolean isWeekdayEvening(LocalDateTime dateTime) {
        return this.isWeekday(dateTime) && this.between(dateTime, EVENING_START_TIME, EVENING_END_TIME);
    }
    
    private boolean between(LocalDateTime dateTime, LocalTime start, LocalTime end) {
        LocalTime time = dateTime.toLocalTime();
        return (start.isBefore(time) || start.equals(time)) && time.isBefore(end);
    }
    
    private boolean isWeekday(LocalDateTime dateTime) {
        return !this.isSaturday(dateTime)
                && !this.isSunday(dateTime)
                && !HolidayUtils.isHoliday(dateTime.toLocalDate());
    }
    
    private boolean isSaturday(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek() == DayOfWeek.SATURDAY;
    }
    
    private boolean isSunday(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
