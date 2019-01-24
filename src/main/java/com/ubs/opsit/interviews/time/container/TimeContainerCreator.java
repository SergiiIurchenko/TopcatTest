package com.ubs.opsit.interviews.time.container;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TimeContainerCreator {
    private static final String MIDNIGHT_24_TIME = "24:00:00";

    public TimeContainer getDoubleMidnightTime(String formattedTime) {
        if (MIDNIGHT_24_TIME.equals(formattedTime)) {
            return new DoubleMidnightTime(24, 0, 0);
        } else {
            LocalTime localTime;
            try {
                localTime = LocalTime.parse(formattedTime);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid input time: " + formattedTime, e);
            }
            return new DoubleMidnightTime(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        }
    }
}
