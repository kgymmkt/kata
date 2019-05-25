package kata.ex01.model.discount.holiday;

import kata.ex01.model.RouteType;
import kata.ex01.model.discount.RouteTypeDiscount;

/**
 * 休日割引対象道路.
 */
public class HolidayRouteTypeDiscount implements RouteTypeDiscount {
    @Override
    public boolean matches(RouteType routeType) {
        return routeType == RouteType.URBAN;
    }
}
