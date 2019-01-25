package com.ubs.opsit.interviews.time.converter;

abstract class DoubleRowsTimeUnitsConverter implements TimeUnitsConverter {

    BerlinLampsSequencesBuilder lampsSequencesBuilder;
    private String lineSeparator;

    @Override
    public String get(int timeUnits) {
        return getTopRow(timeUnits) + lineSeparator + getBottomRow(timeUnits);
    }

    abstract String getTopRow(int timeUnits);

    abstract String getBottomRow(int timeUnits);

    void setLampsSequencesBuilder(BerlinLampsSequencesBuilder lampsSequencesAppender) {
        this.lampsSequencesBuilder = lampsSequencesAppender;
    }

    void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }
}
