package kata.ex01.model.discount.midnight;

import kata.ex01.model.discount.DrivingTimeDiscount;

import java.time.LocalDateTime;

/**
 * 深夜割引対象日時.
 */
public class MidnightDrivingTimeDiscount implements DrivingTimeDiscount {
    @Override
    public boolean matches(LocalDateTime enteredAt, LocalDateTime exitedAt) {
        return false;
    }
}
