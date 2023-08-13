package com.toolRental.util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
public class DateUtil {
    public static SimpleDateFormat getDateFormat(){
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        return sdf;
    }
    public static boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
    public static boolean isHoliday(final LocalDate checkDate) {
        LocalDate date = LocalDate.of(checkDate.getYear(), Month.SEPTEMBER, 1);
        TemporalAdjuster laborDay =
                TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        LocalDate observedIndependenceDay = getObservedIndependenceDay(checkDate.getYear());
        return checkDate.isEqual(date.with(laborDay)) || checkDate.isEqual(observedIndependenceDay);
    }
    private static LocalDate getObservedIndependenceDay(final int year) {
        LocalDate observedIndependenceDay = LocalDate.of(year, 7, 4);
        DayOfWeek day = DayOfWeek.of(observedIndependenceDay.get(ChronoField.DAY_OF_WEEK));
        if (day == DayOfWeek.SATURDAY)
            return observedIndependenceDay.minusDays(1);
        if (day == DayOfWeek.SUNDAY)
            return observedIndependenceDay.plusDays(1);
        return observedIndependenceDay;
    }




}
