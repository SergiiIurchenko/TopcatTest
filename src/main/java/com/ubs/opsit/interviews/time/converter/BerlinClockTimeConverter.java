package com.ubs.opsit.interviews.time.converter;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 'The Berlin Clock' style time converter
 */
class BerlinClockTimeConverter implements TimeConverter {
    private final String TIME_PATTERN_DOUBLE_MIDNIGHT = "(0[0-9]|1[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]";
    private final Pattern validationPattern = Pattern.compile(TIME_PATTERN_DOUBLE_MIDNIGHT);

    private TimeUnitsConverter secondsConverter;
    private TimeUnitsConverter hoursConverter;
    private TimeUnitsConverter minutesConverter;
    private String lineSeparator;

    void setSecondsConverter(TimeUnitsConverter secondsConverter) {
        this.secondsConverter = secondsConverter;
    }

    void setHoursConverter(TimeUnitsConverter hoursConverter) {
        this.hoursConverter = hoursConverter;
    }

    void setMinutesConverter(TimeUnitsConverter minutesConverter) {
        this.minutesConverter = minutesConverter;
    }

    void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
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

        TimeUnitsContainer timeContainer = new TimeContainerCreator().getTimeUnitsContainer(time);
        return secondsConverter.get(timeContainer.getSeconds()) + lineSeparator
                + hoursConverter.get(timeContainer.getHours()) + lineSeparator
                + minutesConverter.get(timeContainer.getMinutes());
    }

    private boolean validate(String aTime) {
        if (StringUtils.isBlank(aTime)) {
            return false;
        }
        Matcher matcher = validationPattern.matcher(aTime);
        return matcher.matches();
    }
}
