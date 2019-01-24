package com.ubs.opsit.interviews.units.extractors;

import com.ubs.opsit.interviews.time.container.TimeContainer;

import java.util.concurrent.TimeUnit;

class BerlinSecondsExtractor implements TimeUnitsExtractor {

    @Override
    public String get(TimeContainer time) {
        return time.get(TimeUnit.SECONDS) % 2 == 0 ? BerlinColor.Y : BerlinColor.O;
    }
}
