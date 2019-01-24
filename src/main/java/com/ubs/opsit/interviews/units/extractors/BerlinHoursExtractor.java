package com.ubs.opsit.interviews.units.extractors;

import com.ubs.opsit.interviews.time.container.TimeContainer;

import java.util.concurrent.TimeUnit;

class BerlinHoursExtractor implements TimeUnitsExtractor {
    private static final int HOURS_PER_TOP_LAMP = 5;
    private static final int LAMPS_IN_ROW = 4;

    @Override
    public String get(TimeContainer time) {
        int hours = time.get(TimeUnit.HOURS);
        int topRedLamps = hours / HOURS_PER_TOP_LAMP;
        int bottomRedLamps = hours % HOURS_PER_TOP_LAMP;

        StringBuilder result = new StringBuilder();

        BerlinLampsSequencesAppender lampsSequencesAppender = new BerlinLampsSequencesAppender();
        lampsSequencesAppender.appendRegularRow(result, topRedLamps, LAMPS_IN_ROW, BerlinColor.R);
        result.append(System.lineSeparator());
        lampsSequencesAppender.appendRegularRow(result, bottomRedLamps, LAMPS_IN_ROW, BerlinColor.R);

        return result.toString();
    }
}
