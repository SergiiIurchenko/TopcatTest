package com.ubs.opsit.interviews.time.converter;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

class TimeContainerCreator {
    private static final String MIDNIGHT_24_TIME = "24:00:00";

    TimeUnitsContainer getTimeUnitsContainer(String time) {
        return MIDNIGHT_24_TIME.equals(time)
                ? new TimeUnitsContainer(24, 0, 0)
                : getFromLocalTime(time);
    }

    private TimeUnitsContainer getFromLocalTime(String time) {
        LocalTime localTime;
        try {
            localTime = LocalTime.parse(time);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid input time: " + time, e);
        }
        return new TimeUnitsContainer(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }
}
