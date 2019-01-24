package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.units.extractors.BerlinTimeUnitsExtractorFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Exposes external access for different time converter implementations
 */
public class TimeConverterFactory {

    /**
     * Returns classical 'Berlin Clock' style time converter with 5 lamp rows (top one for seconds and other pairs for hours and minutes)
     */
    public static TimeConverter getBerlinClockTimeConverter() {
        return BerlinClockTimeConverterLazyHolder.INSTANCE;
    }

    private static class BerlinClockTimeConverterLazyHolder {
        private static final BerlinClockTimeConverter INSTANCE = new BerlinClockTimeConverter(Arrays.asList(
                BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.SECONDS),
                BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.HOURS),
                BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.MINUTES)));
    }

    //implement other converters in similar way when needed
}
