package kata.ex01.model.discount.midnight;

import kata.ex01.model.discount.AbstractEtcDiscount;

/**
 * 深夜割引.
 */
public class MidnightDiscount extends AbstractEtcDiscount {
    public MidnightDiscount() {
        super(
            new MidnightRouteTypeDiscount(),
            new MidnightVehicleFamilyDiscount(),
            new MidnightDrivingTimeDiscount(),
            new MidnightDiscountRate()
        );
    }
}
