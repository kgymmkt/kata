package kata.ex01.model.discount.weekday;

import kata.ex01.model.VehicleFamily;
import kata.ex01.model.discount.VehicleFamilyDiscount;

/**
 * 平日朝夕割引対象車種.
 */
public class WeekdayVehicleFamilyDiscount implements VehicleFamilyDiscount {
    
    @Override
    public boolean matches(VehicleFamily vehicleFamily) {
        return true; // 全車種対象
    }
}
