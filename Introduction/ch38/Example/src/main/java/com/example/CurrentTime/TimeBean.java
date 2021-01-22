package com.example.CurrentTime;

import java.text.DateFormat;
import java.util.*;

public class TimeBean {
    private Locale[] allLocale = Locale.getAvailableLocales();
    private String[] allTimeZone = TimeZone.getAvailableIDs();
    private int localeIndex;
    private int timeZoneIndex;

    public TimeBean() {
        Arrays.sort(allTimeZone);
    }

    public Locale[] getAllLocale() {
        return allLocale;
    }

    public String[] getAllTimeZone() {
        return allTimeZone;
    }

    public int getLocaleIndex() {
        return localeIndex;
    }

    public int getTimeZoneIndex() {
        return timeZoneIndex;
    }

    public void setAllLocale(Locale[] allLocale) {
        this.allLocale = allLocale;
    }

    public void setAllTimeZone(String[] allTimeZone) {
        this.allTimeZone = allTimeZone;
    }

    public void setLocaleIndex(int localeIndex) {
        this.localeIndex = localeIndex;
    }

    public void setTimeZoneIndex(int timeZoneIndex) {
        this.timeZoneIndex = timeZoneIndex;
    }

    public String currentTimeString(int localeIndex,
                                    int timeZoneIndex) {
        Calendar calendar = new GregorianCalendar(allLocale[localeIndex]);
        TimeZone timeZone =
                TimeZone.getTimeZone(allTimeZone[timeZoneIndex]);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.FULL, DateFormat.FULL, allLocale[localeIndex]
        );
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(calendar.getTime());
    }

}
