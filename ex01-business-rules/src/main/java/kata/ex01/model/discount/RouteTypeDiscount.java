package kata.ex01.model.discount;

import kata.ex01.model.RouteType;

/**
 * 割引対象道路.
 */
public interface RouteTypeDiscount {

    /**
     * 指定した道路種別が割引対象かどうかを判定する.
     * @param routeType 道路種別
     * @return 割引対象の場合は true
     */
    boolean matches(RouteType routeType);
}
