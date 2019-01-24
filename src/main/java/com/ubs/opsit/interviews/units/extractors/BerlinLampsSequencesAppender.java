package com.ubs.opsit.interviews.units.extractors;

/**
 * Encapsulates logic of lighted and unlighted lamps sequences creation in 'Berlin Clock'
 */
class BerlinLampsSequencesAppender {

    void appendRegularRow(StringBuilder result, int lightedLamps, int lampsInRow, String lightedBerlinColor) {
        for (int i = 0; i < lightedLamps; i++) {
            result.append(lightedBerlinColor);
        }
        appendUnlighted(result, lightedLamps, lampsInRow);
    }

    void appendLightedBySections(StringBuilder result, int lightedLamps, int lampsInRow, int sectionSize) {
        for (int i = 0; i < lightedLamps; i++) {
            if ((i + 1) % sectionSize == 0) {
                result.append(BerlinColor.R);
            } else {
                result.append(BerlinColor.Y);
            }
        }
        appendUnlighted(result, lightedLamps, lampsInRow);
    }

    private void appendUnlighted(StringBuilder result, int lightedLamps, int lampsInRow) {
        for (int i = lightedLamps; i < lampsInRow; i++) {
            result.append(BerlinColor.O);
        }
    }
}
