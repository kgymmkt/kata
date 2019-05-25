package kata.ex01.model.discount;

import kata.ex01.model.VehicleFamily;

/**
 * 割引対象車種.
 */
public interface VehicleFamilyDiscount {

    /**
     * 指定した車種が割引対象の車種か判定する.
     * @param vehicleFamily 検証対象の車種
     * @return 割引対象の場合は true
     */
    boolean matches(VehicleFamily vehicleFamily);
}
