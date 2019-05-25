package kata.ex01.model.discount;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.discount.holiday.HolidayDiscount;
import kata.ex01.model.discount.midnight.MidnightDiscount;
import kata.ex01.model.discount.weekday.WeekdayDiscount;

import java.util.Objects;

/**
 * 最終的に採用する ETC 割引を決定する調停クラス.
 */
public class EtcDiscountCoordinator {
    private final WeekdayDiscount weekdayDiscount;
    private final HolidayDiscount holidayDiscount;
    private final MidnightDiscount midnightDiscount;
    private final NoDiscount noDiscount = new NoDiscount();

    public EtcDiscountCoordinator(WeekdayDiscount weekdayDiscount, HolidayDiscount holidayDiscount, MidnightDiscount midnightDiscount) {
        this.weekdayDiscount = Objects.requireNonNull(weekdayDiscount);
        this.holidayDiscount = Objects.requireNonNull(holidayDiscount);
        this.midnightDiscount = Objects.requireNonNull(midnightDiscount);
    }

    public EtcDiscount decideDiscount(HighwayDrive highwayDrive) {
        if (this.holidayDiscount.matches(highwayDrive)) {
            return this.holidayDiscount;
            
        } else if (this.midnightDiscount.matches(highwayDrive)) {
            return this.midnightDiscount;
            
        } else if (this.weekdayDiscount.matches(highwayDrive)) {
            return this.weekdayDiscount;
            
        } else {
            return this.noDiscount;
        }
    }
}
