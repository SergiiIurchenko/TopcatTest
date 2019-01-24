package com.ubs.opsit.interviews.time.container;

import java.util.concurrent.TimeUnit;

/**
 * Time container to supports both '00:00:00' and '24:00:00' midnight formats. Doesn't validate inputs
 */
class DoubleMidnightTime implements TimeContainer {
    private final int hours;
    private final int minutes;
    private final int seconds;

    DoubleMidnightTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public int get(TimeUnit timeUnit) {
        switch (timeUnit) {
            case HOURS:
                return hours;
            case MINUTES:
                return minutes;
            case SECONDS:
                return seconds;
            default:
                return 0;
        }
    }
}
