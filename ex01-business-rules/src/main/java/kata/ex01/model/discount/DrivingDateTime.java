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
}
