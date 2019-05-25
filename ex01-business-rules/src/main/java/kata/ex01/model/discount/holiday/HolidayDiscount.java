package kata.ex01.model.discount.holiday;

import kata.ex01.model.discount.AbstractEtcDiscount;

/**
 * 休日割引.
 */
public class HolidayDiscount extends AbstractEtcDiscount {

    public HolidayDiscount() {
        super(
            new HolidayRouteTypeDiscount(),
            new HolidayVehicleFamilyDiscount(),
            new HolidayDrivingTimeDiscount(),
            new HolidayDiscountRate()
        );
    }
}
