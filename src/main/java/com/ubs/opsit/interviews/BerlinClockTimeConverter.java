package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.time.container.TimeContainer;
import com.ubs.opsit.interviews.time.container.TimeContainerCreator;
import com.ubs.opsit.interviews.units.extractors.TimeUnitsExtractor;
import org.apache.commons.lang.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 'The Berlin Clock' style time converter
 */
class BerlinClockTimeConverter implements TimeConverter {
    private static final String TIME_PATTERN_DOUBLE_MIDNIGHT = "(0[0-9]|1[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]";

    private final List<TimeUnitsExtractor> timeUnitsConvertersSequence;
    private final Pattern validationPattern;

    BerlinClockTimeConverter(List<TimeUnitsExtractor> timeUnitsConvertersSequence) {
        this.timeUnitsConvertersSequence = timeUnitsConvertersSequence;
        validationPattern = Pattern.compile(TIME_PATTERN_DOUBLE_MIDNIGHT);
    }

    /**
     * @param aTime in 'HH:mm:ss' format with support of '24:00:00'
     * @return time in fancy colorful 5-rows
     */
    @Override
    public String convertTime(String aTime) {
        String time = aTime != null ? aTime.trim() : null;
        if (!validate(time)) {
            throw new IllegalArgumentException("Invalid input time string. Should be in 'HH:mm:ss' format (24:00:00 is allowed also).");
        }

        TimeContainer timeContainer = new TimeContainerCreator().getDoubleMidnightTime(time);
        StringBuilder result = new StringBuilder();

        Iterator<TimeUnitsExtractor> extractorsIterator = timeUnitsConvertersSequence.iterator();
        while (extractorsIterator.hasNext()) {
            result.append(extractorsIterator.next().get(timeContainer));
            if (extractorsIterator.hasNext()) { //last part don't need separator
                result.append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    private boolean validate(String aTime) {
        if (StringUtils.isBlank(aTime)) {
            return false;
        }
        Matcher matcher = validationPattern.matcher(aTime);
        return matcher.matches();
    }
}
