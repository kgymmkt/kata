package kata.ex01.model.discount.holiday;

import kata.ex01.model.VehicleFamily;
import kata.ex01.model.discount.VehicleFamilyDiscount;

/**
 * 休日割引対象車種.
 */
public class HolidayVehicleFamilyDiscount implements VehicleFamilyDiscount {
    @Override
    public boolean matches(VehicleFamily vehicleFamily) {
        return vehicleFamily == VehicleFamily.STANDARD
                || vehicleFamily == VehicleFamily.MINI
                || vehicleFamily == VehicleFamily.MOTORCYCLE;
    }
}
