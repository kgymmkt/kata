package kata.ex01.model.discount;

import java.time.LocalDateTime;

/**
 * 割引対象日時.
 */
public interface DrivingTimeDiscount {

    /**
     * 指定した走行時間が割引対象となるか判定する.
     * @param enteredAt 入時間
     * @param exitedAt 出時間
     * @return 割引対象となる場合は true
     */
    boolean matches(LocalDateTime enteredAt, LocalDateTime exitedAt);
}
