package com.ubs.opsit.interviews.time.converter;

/**
 * Time units container
 */
class TimeUnitsContainer {
    private final int hours;
    private final int minutes;
    private final int seconds;

    TimeUnitsContainer(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    int getSeconds() {
        return seconds;
    }
}
