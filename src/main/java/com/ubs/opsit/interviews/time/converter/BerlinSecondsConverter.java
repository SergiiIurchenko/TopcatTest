package com.ubs.opsit.interviews.time.converter;

class BerlinSecondsConverter implements TimeUnitsConverter {

    @Override
    public String get(int seconds) {
        return seconds % 2 == 0 ? BerlinColor.Y : BerlinColor.O;
    }
}
