package kata.ex01.model.discount.weekday;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.discount.DiscountRate;

/**
 * 平日朝夕割引率.
 */
public class WeekdayDiscountRate implements DiscountRate {
    
    @Override
    public long decideDiscountRate(HighwayDrive highwayDrive) {
        int countPerMonth = highwayDrive.getDriver().getCountPerMonth();
        
        if (countPerMonth < 5) {
            return 0;
        } else if (countPerMonth < 10) {
            return 30;
        } else {
            return 50;
        }
    }
}
