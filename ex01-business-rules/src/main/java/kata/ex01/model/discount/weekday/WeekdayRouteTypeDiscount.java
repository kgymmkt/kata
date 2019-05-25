package kata.ex01.model.discount.weekday;

import kata.ex01.model.RouteType;
import kata.ex01.model.discount.RouteTypeDiscount;

/**
 * 平日割引対象道路.
 */
public class WeekdayRouteTypeDiscount implements RouteTypeDiscount {
    @Override
    public boolean matches(RouteType routeType) {
        return routeType == RouteType.URBAN;
    }
}
