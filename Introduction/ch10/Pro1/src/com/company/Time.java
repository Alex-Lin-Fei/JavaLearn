package com.company;

public class Time {
    private long hour;
    private long minute;
    private long second;



    public Time() {
        long totalSeconds = System.currentTimeMillis() / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;

        hour = currentHour;
        minute = currentMinute;
        second = currentSecond;

    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(long elapsetime) {
        long totalSeconds = elapsetime / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;

        hour = currentHour;
        minute = currentMinute;
        second = currentSecond;
    }

    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }

    public void setTime(long elapseTime) {
        long totalSeconds = elapseTime / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;

        hour = currentHour;
        minute = currentMinute;
        second = currentSecond;
    }
}
