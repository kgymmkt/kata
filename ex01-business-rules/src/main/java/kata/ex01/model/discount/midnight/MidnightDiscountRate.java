package kata.ex01.model.discount.midnight;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.discount.DiscountRate;

/**
 * 深夜割引率.
 */
public class MidnightDiscountRate implements DiscountRate {
    @Override
    public long decideDiscountRate(HighwayDrive highwayDrive) {
        return 30;
    }
}
