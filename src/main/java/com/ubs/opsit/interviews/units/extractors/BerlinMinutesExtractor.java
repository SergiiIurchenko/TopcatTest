package com.ubs.opsit.interviews.units.extractors;

import com.ubs.opsit.interviews.time.container.TimeContainer;

import java.util.concurrent.TimeUnit;

class BerlinMinutesExtractor implements TimeUnitsExtractor {
    private static final int MINUTES_PER_TOP_LAMP = 5;
    private static final int LAMPS_IN_TOP_ROW = 11;
    private static final int LAMPS_IN_BOTTOM_ROW = 4;
    private static final int TOP_ROW_SECTION_SIZE = 3;

    @Override
    public String get(TimeContainer time) {
        int minutes = time.get(TimeUnit.MINUTES);
        int topLightedLamps = minutes / MINUTES_PER_TOP_LAMP;
        int bottomLightedLamps = minutes % MINUTES_PER_TOP_LAMP;

        StringBuilder result = new StringBuilder();

        BerlinLampsSequencesAppender lampsSequencesAppender = new BerlinLampsSequencesAppender();
        lampsSequencesAppender.appendLightedBySections(result, topLightedLamps, LAMPS_IN_TOP_ROW, TOP_ROW_SECTION_SIZE);
        result.append(System.lineSeparator());
        lampsSequencesAppender.appendRegularRow(result, bottomLightedLamps, LAMPS_IN_BOTTOM_ROW, BerlinColor.Y);

        return result.toString();
    }
}
