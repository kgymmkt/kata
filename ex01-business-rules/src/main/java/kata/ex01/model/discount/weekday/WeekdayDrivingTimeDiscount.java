package kata.ex01.model.discount.weekday;

import kata.ex01.model.discount.DrivingDateTime;
import kata.ex01.model.discount.DrivingTimeDiscount;

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
    public boolean matches(DrivingDateTime enteredAt, DrivingDateTime exitedAt) {
        return this.isWeekdayMorning(enteredAt) || this.isWeekdayEvening(enteredAt)
                || this.isWeekdayMorning(exitedAt) || this.isWeekdayEvening(exitedAt);
    }
    
    private boolean isWeekdayMorning(DrivingDateTime dateTime) {
        return this.isWeekday(dateTime) && dateTime.isIn(MORNING_START_TIME, MORNING_END_TIME);
    }
    
    private boolean isWeekdayEvening(DrivingDateTime dateTime) {
        return this.isWeekday(dateTime) && dateTime.isIn(EVENING_START_TIME, EVENING_END_TIME);
    }
    
    private boolean isWeekday(DrivingDateTime dateTime) {
        return !dateTime.isSaturday()
                && !dateTime.isSunday()
                && !dateTime.isHoliday();
    }
}
