package com.ubs.opsit.interviews.units.extractors;


import java.util.concurrent.TimeUnit;

/**
 * Factory for external access to 'Berlin Clock' style time unit extractor implementations, which are essentially it's building blocks.
 * While being stateless they are returned as singletons in case different time converters want to reuse them.
 */
public class BerlinTimeUnitsExtractorFactory {

    /**
     * @param timeUnit time units type
     * @return time unit extractors implementations
     */
    public static TimeUnitsExtractor getTimeUnitsExtractor(TimeUnit timeUnit) {
        switch (timeUnit) {
            case SECONDS:
                return SecondsBerlinStyleExtractorLazyHolder.INSTANCE;
            case HOURS:
                return HoursBerlinStyleExtractorLazyHolder.INSTANCE;
            case MINUTES:
                return MinutesBerlinStyleExtractorLazyHolder.INSTANCE;
            default:
                return null;
        }
    }

    private static class SecondsBerlinStyleExtractorLazyHolder {
        private static final BerlinSecondsExtractor INSTANCE = new BerlinSecondsExtractor();
    }

    private static class HoursBerlinStyleExtractorLazyHolder {
        private static final BerlinHoursExtractor INSTANCE = new BerlinHoursExtractor();
    }

    private static class MinutesBerlinStyleExtractorLazyHolder {
        private static final BerlinMinutesExtractor INSTANCE = new BerlinMinutesExtractor();
    }
}
