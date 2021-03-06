package kata.ex01.model.discount;

import kata.ex01.util.HolidayUtils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.util.Objects;

/**
 * 走行日時.
 */
public class DrivingDateTime {
    private final LocalDateTime dateTime;

    public DrivingDateTime(LocalDateTime dateTime) {
        this.dateTime = Objects.requireNonNull(dateTime);
    }

    /**
     * この日付が土曜日か確認する.
     * @return 土曜日の場合は true
     */
    public boolean isSunday() {
        return this.dateTime.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    /**
     * この日付が日曜日か確認する.
     * @return 日曜日の場合は true
     */
    public boolean isSaturday() {
        return this.dateTime.getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    /**
     * この日付が祝日か確認する.
     * @return 祝日の場合は true
     */
    public boolean isHoliday() {
        return HolidayUtils.isHoliday(this.dateTime.toLocalDate());
    }

    /**
     * この日付の「月日」が指定した「月日」と一致するか確認する.
     * @param monthDay 比較対象の「月日」
     * @return 一致する場合は true
     */
    public boolean is(MonthDay monthDay) {
        return MonthDay.from(this.dateTime).equals(monthDay);
    }

    /**
     * この日時が指定した日時と一致するか確認する.
     * @param dateTime 比較対象の日時
     * @return 一致する場合は true
     */
    public boolean is(LocalDateTime dateTime) {
        return this.dateTime.equals(dateTime);
    } 

    /**
     * この日時の「時間」が、指定した期間内に入るか確認する.
     * @param fromInclude 開始時間（この時刻を含む）
     * @param toExclude 終了時間（この時刻を含まない）
     * @return 指定した期間内に入る場合は true
     */
    public boolean isIn(LocalTime fromInclude, LocalTime toExclude) {
        LocalTime thisTime = this.dateTime.toLocalTime();
        return (fromInclude.isBefore(thisTime) || fromInclude.equals(thisTime))
                && thisTime.isBefore(toExclude);
    }

    /**
     * この日時が、指定した日時より前であることを確認する.
     * @param dateTime 比較対象の日時
     * @return 指定した日時より前の場合は true
     */
    public boolean isBefore(LocalDateTime dateTime) {
        return this.dateTime.isBefore(dateTime);
    }

    /**
     * この日時が、指定した日時より後であることを確認する.
     * @param dateTime 比較対象の日時
     * @return 指定した日時より後の場合は true
     */
    public boolean isAfter(LocalDateTime dateTime) {
        return this.dateTime.isAfter(dateTime);
    }

    /**
     * この日付に指定した時刻を設定した新しい日時を取得する.
     * @param time 新たに設定する時刻
     * @return 生成した日時
     */
    public LocalDateTime with(LocalTime time) {
        return this.dateTime.with(time);
    }
}
