package com.ubs.opsit.interviews.time.converter;

class BerlinMinutesConverter extends DoubleRowsTimeUnitsConverter {
    private static final int MINUTES_PER_TOP_LAMP = 5;
    private static final int LAMPS_IN_TOP_ROW = 11;
    private static final int LAMPS_IN_BOTTOM_ROW = 4;
    private static final int TOP_ROW_SECTION_SIZE = 3;

    @Override
    String getTopRow(int minutes) {
        return lampsSequencesBuilder.getMinutesLightedSequence(minutes / MINUTES_PER_TOP_LAMP, LAMPS_IN_TOP_ROW, TOP_ROW_SECTION_SIZE);
    }

    @Override
    String getBottomRow(int minutes) {
        return lampsSequencesBuilder.getRegularRow(minutes % MINUTES_PER_TOP_LAMP, LAMPS_IN_BOTTOM_ROW, BerlinColor.Y);
    }
}
