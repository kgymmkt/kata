package kata.ex01.model.discount.holiday;

import kata.ex01.model.discount.DrivingTimeDiscount;

import java.time.LocalDateTime;

/**
 * 休日割引対象日時.
 */
public class HolidayDrivingTimeDiscount implements DrivingTimeDiscount {
    @Override
    public boolean matches(LocalDateTime enteredAt, LocalDateTime exitedAt) {
        return false;
    }
}
