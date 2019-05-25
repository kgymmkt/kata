package kata.ex01.model.discount.midnight;

import kata.ex01.model.discount.DrivingDateTime;
import kata.ex01.model.discount.DrivingTimeDiscount;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 深夜割引対象日時.
 */
public class MidnightDrivingTimeDiscount implements DrivingTimeDiscount {
    private static final LocalTime MIDNIGHT_START_TIME = LocalTime.of(0, 0);
    private static final LocalTime MIDNIGHT_END_TIME = LocalTime.of(4, 0);
    
    @Override
    public boolean matches(DrivingDateTime enteredAt, DrivingDateTime exitedAt) {
        LocalDateTime startDateTime = exitedAt.with(MIDNIGHT_START_TIME);
        LocalDateTime endDateTime = exitedAt.with(MIDNIGHT_END_TIME);

        return enteredAt.isIn(MIDNIGHT_START_TIME, MIDNIGHT_END_TIME)
                || exitedAt.isIn(MIDNIGHT_START_TIME, MIDNIGHT_END_TIME)
                || (enteredAt.isBefore(startDateTime) && (exitedAt.isAfter(endDateTime) || exitedAt.is(endDateTime)));
    }
}
