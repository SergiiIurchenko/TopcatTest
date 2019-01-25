package com.ubs.opsit.interviews.time.converter;

class BerlinHoursConverter extends DoubleRowsTimeUnitsConverter {
    private static final int HOURS_PER_TOP_LAMP = 5;
    private static final int LAMPS_IN_ROW = 4;

    @Override
    String getTopRow(int hours) {
        return lampsSequencesBuilder.getRegularRow(hours / HOURS_PER_TOP_LAMP, LAMPS_IN_ROW, BerlinColor.R);
    }

    @Override
    String getBottomRow(int hours) {
        return lampsSequencesBuilder.getRegularRow(hours % HOURS_PER_TOP_LAMP, LAMPS_IN_ROW, BerlinColor.R);
    }
}
