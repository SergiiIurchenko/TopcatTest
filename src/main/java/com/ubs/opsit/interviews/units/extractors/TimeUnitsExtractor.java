package com.ubs.opsit.interviews.units.extractors;

import com.ubs.opsit.interviews.time.container.TimeContainer;

/**
 * Extracts specific time units representations from entire time
 */
public interface TimeUnitsExtractor {

    /**
     * @param time time units container
     * @return text block of corresponding time units representation
     */
    String get(TimeContainer time);
}
