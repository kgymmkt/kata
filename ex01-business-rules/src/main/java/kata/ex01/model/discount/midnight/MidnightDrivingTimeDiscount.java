package kata.ex01.model.discount.midnight;

import kata.ex01.model.discount.DrivingDateTime;
import kata.ex01.model.discount.DrivingTimeDiscount;

/**
 * 深夜割引対象日時.
 */
public class MidnightDrivingTimeDiscount implements DrivingTimeDiscount {
    @Override
    public boolean matches(DrivingDateTime enteredAt, DrivingDateTime exitedAt) {
        return false;
    }
}
