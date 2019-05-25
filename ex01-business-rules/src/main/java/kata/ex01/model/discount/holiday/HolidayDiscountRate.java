package kata.ex01.model.discount.holiday;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.discount.DiscountRate;

/**
 * 休日割引率.
 */
public class HolidayDiscountRate implements DiscountRate {
    
    @Override
    public long decideDiscountRate(HighwayDrive highwayDrive) {
        return 30;
    }
}
