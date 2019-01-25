package com.ubs.opsit.interviews.time.converter;

/**
 * Exposes external access for different time converter implementations
 */
public class TimeConverterFactory {

    /**
     * Returns classical 'Berlin Clock' style time converter with 5 lamp rows (top one for seconds and other pairs for hours and minutes)
     */
    public static TimeConverter getBerlinClockTimeConverter() {
        BerlinClockTimeConverter timeConverter = new BerlinClockTimeConverter();
        timeConverter.setSecondsConverter(new BerlinSecondsConverter());
        BerlinLampsSequencesBuilder lampsSequencesAppender = new BerlinLampsSequencesBuilder();
        timeConverter.setHoursConverter(getBerlinHoursConverter(lampsSequencesAppender));
        timeConverter.setMinutesConverter(getBerlinMinutesConverter(lampsSequencesAppender));
        timeConverter.setLineSeparator(System.lineSeparator());
        return timeConverter;
    }

    private static TimeUnitsConverter getBerlinHoursConverter(BerlinLampsSequencesBuilder lampsSequencesAppender) {
        BerlinHoursConverter berlinHoursConverter = new BerlinHoursConverter();
        berlinHoursConverter.setLampsSequencesBuilder(lampsSequencesAppender);
        berlinHoursConverter.setLineSeparator(System.lineSeparator());
        return berlinHoursConverter;
    }

    private static TimeUnitsConverter getBerlinMinutesConverter(BerlinLampsSequencesBuilder lampsSequencesAppender) {
        BerlinMinutesConverter berlinMinutesConverter = new BerlinMinutesConverter();
        berlinMinutesConverter.setLampsSequencesBuilder(lampsSequencesAppender);
        berlinMinutesConverter.setLineSeparator(System.lineSeparator());
        return berlinMinutesConverter;
    }
}
