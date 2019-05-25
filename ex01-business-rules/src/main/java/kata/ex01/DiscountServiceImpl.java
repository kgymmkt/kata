package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.discount.EtcDiscount;
import kata.ex01.model.discount.EtcDiscountCoordinator;
import kata.ex01.model.discount.holiday.HolidayDiscount;
import kata.ex01.model.discount.midnight.MidnightDiscount;
import kata.ex01.model.discount.weekday.WeekdayDiscount;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {
    @Override
    public long calc(HighwayDrive drive) {
        EtcDiscountCoordinator coordinator = new EtcDiscountCoordinator(new WeekdayDiscount(), new HolidayDiscount(), new MidnightDiscount());
        EtcDiscount discount = coordinator.decideDiscount(drive);
        return discount.calc(drive);
    }
}
