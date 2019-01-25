package com.ubs.opsit.interviews.time.converter;

class LampsRowTestHelper {

    static String getSameLampsRow(int size, String color) {
        StringBuilder lampsRow = new StringBuilder();
        for (int i = 0; i < size; i++) {
            lampsRow.append(color);
        }
        return lampsRow.toString();
    }

    static String getFullyLightedMinutesTopRow() {
        return getMinutesLightedSection() + getMinutesLightedSection() + getMinutesLightedSection() + BerlinColor.Y + BerlinColor.Y;
    }

    static String getMinutesLightedSection() {
        return BerlinColor.Y + BerlinColor.Y + BerlinColor.R;
    }
}
