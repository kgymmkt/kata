package kata.ex01.model.discount;

import kata.ex01.model.HighwayDrive;

/**
 * ETC 割引.
 */
public interface EtcDiscount {

    /**
     * 指定した走行記録が、この ETC 割引の対象となるか判定する.
     * @param highwayDrive 走行記録
     * @return 割引の対象となる場合は true
     */
    boolean matches(HighwayDrive highwayDrive);

    /**
     * 指定した走行記録に対してこの割引を適用した場合の割引率を計算する.
     * @param highwayDrive 走行記録
     * @return 割引率（割引の対象とならない場合は 0 を返す）
     */
    long calc(HighwayDrive highwayDrive);
}
