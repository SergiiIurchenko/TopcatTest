package com.ubs.opsit.interviews.time.converter;

/**
 * Converts specific time units representations
 */
interface TimeUnitsConverter {

    /**
     * @param timeUnits time units [hours/minutes/seconds etc]
     * @return text block of corresponding time units representation
     */
    String get(int timeUnits);
}
