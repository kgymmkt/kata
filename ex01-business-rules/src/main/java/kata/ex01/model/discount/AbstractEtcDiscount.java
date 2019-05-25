package kata.ex01.model.discount;

import kata.ex01.model.HighwayDrive;

import java.util.Objects;

/**
 * ETC 割引.
 */
public abstract class AbstractEtcDiscount implements EtcDiscount {
    private final RouteTypeDiscount routeTypeDiscount;
    private final VehicleFamilyDiscount vehicleFamilyDiscount;
    private final DrivingTimeDiscount drivingTimeDiscount;
    
    private final DiscountRate discountRate;

    protected AbstractEtcDiscount(
        RouteTypeDiscount routeTypeDiscount,
        VehicleFamilyDiscount vehicleFamilyDiscount,
        DrivingTimeDiscount drivingTimeDiscount,
        DiscountRate discountRate
    ) {
        this.routeTypeDiscount = Objects.requireNonNull(routeTypeDiscount);
        this.vehicleFamilyDiscount = Objects.requireNonNull(vehicleFamilyDiscount);
        this.drivingTimeDiscount = Objects.requireNonNull(drivingTimeDiscount);
        this.discountRate = Objects.requireNonNull(discountRate);
    }
    
    @Override
    public boolean matches(HighwayDrive highwayDrive) {
        DrivingDateTime enteredAt = new DrivingDateTime(highwayDrive.getEnteredAt());
        DrivingDateTime exitedAt = new DrivingDateTime(highwayDrive.getExitedAt());
        
        return this.routeTypeDiscount.matches(highwayDrive.getRouteType())
                && this.vehicleFamilyDiscount.matches(highwayDrive.getVehicleFamily())
                && this.drivingTimeDiscount.matches(enteredAt, exitedAt);
    }

    @Override
    public long calc(HighwayDrive highwayDrive) {
        return this.matches(highwayDrive) ? this.discountRate.decideDiscountRate(highwayDrive) : 0L;
    }
}
