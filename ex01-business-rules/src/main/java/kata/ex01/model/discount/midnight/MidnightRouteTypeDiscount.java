package kata.ex01.model.discount.midnight;

import kata.ex01.model.RouteType;
import kata.ex01.model.discount.RouteTypeDiscount;

/**
 * 深夜割引対象道路.
 */
public class MidnightRouteTypeDiscount implements RouteTypeDiscount {
    @Override
    public boolean matches(RouteType routeType) {
        return true; // 全道路対象
    }
}
