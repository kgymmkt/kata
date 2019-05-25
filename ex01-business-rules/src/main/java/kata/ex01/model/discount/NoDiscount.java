package kata.ex01.model.discount;

import kata.ex01.model.HighwayDrive;

/**
 * 割引なし.
 */
public class NoDiscount implements EtcDiscount {
    @Override
    public boolean matches(HighwayDrive highwayDrive) {
        return true;
    }

    @Override
    public long calc(HighwayDrive highwayDrive) {
        return 0L;
    }
}
