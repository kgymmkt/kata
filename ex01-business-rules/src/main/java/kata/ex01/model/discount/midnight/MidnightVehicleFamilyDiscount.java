package kata.ex01.model.discount.midnight;

import kata.ex01.model.VehicleFamily;
import kata.ex01.model.discount.VehicleFamilyDiscount;

/**
 * 深夜割引対象車種.
 */
public class MidnightVehicleFamilyDiscount implements VehicleFamilyDiscount {
    @Override
    public boolean matches(VehicleFamily vehicleFamily) {
        return true; // 全車種対象
    }
}
