package kata.ex01.model.discount.weekday;

import kata.ex01.model.discount.AbstractEtcDiscount;

/**
 * 平日朝夕割引.
 */
public class WeekdayDiscount extends AbstractEtcDiscount {
     public WeekdayDiscount() {
        super(
            new WeekdayRouteTypeDiscount(),
            new WeekdayVehicleFamilyDiscount(),
            new WeekdayDrivingTimeDiscount(),
            new WeekdayDiscountRate()
        );
    }
}
