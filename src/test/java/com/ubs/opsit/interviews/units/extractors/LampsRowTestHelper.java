package com.ubs.opsit.interviews.units.extractors;

class LampsRowTestHelper {

    static String getSameLampsRow(int size, String color) {
        StringBuilder lampsRow = new StringBuilder();
        for (int i = 0; i < size; i++) {
            lampsRow.append(color);
        }
        return lampsRow.toString();
    }

    static String getFullyLightedMinutesTopRow() {
        return new StringBuilder().append(getMinutesLightedSection()).append(getMinutesLightedSection()).append(getMinutesLightedSection())
                .append(BerlinColor.Y).append(BerlinColor.Y).toString();
    }

    static String getMinutesLightedSection() {
        return new StringBuilder().append(BerlinColor.Y).append(BerlinColor.Y).append(BerlinColor.R).toString();
    }
}
