package com.ubs.opsit.interviews.time.converter;

/**
 * Encapsulates logic of lighted and unlighted lamps sequences creation in 'Berlin Clock'
 */
class BerlinLampsSequencesBuilder {

    String getRegularRow(int lightedLamps, int lampsInRow, String lightedBerlinColor) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lightedLamps; i++) {
            result.append(lightedBerlinColor);
        }
        return result.append(getUnlightedSequence(lightedLamps, lampsInRow)).toString();
    }

    String getMinutesLightedSequence(int lightedLamps, int lampsInRow, int sectionSize) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lightedLamps; i++) {
            if ((i + 1) % sectionSize == 0) {
                result.append(BerlinColor.R);
            } else {
                result.append(BerlinColor.Y);
            }
        }
        return result.append(getUnlightedSequence(lightedLamps, lampsInRow)).toString();
    }

    private String getUnlightedSequence(int lightedLamps, int lampsInRow) {
        StringBuilder result = new StringBuilder();
        for (int i = lightedLamps; i < lampsInRow; i++) {
            result.append(BerlinColor.O);
        }
        return result.toString();
    }
}
