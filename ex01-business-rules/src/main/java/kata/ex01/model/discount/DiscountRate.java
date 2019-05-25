package kata.ex01.model.discount;

import kata.ex01.model.HighwayDrive;

/**
 * 割引率.
 */
public interface DiscountRate {

    /**
     * 指定した走行記録から割引率を決定する.
     * <p>
     * 割引率の値は、パーセントを表す整数で表現されます.
     * 
     * @param highwayDrive 走行記録
     * @return 割引率
     */
    long decideDiscountRate(HighwayDrive highwayDrive);
}
