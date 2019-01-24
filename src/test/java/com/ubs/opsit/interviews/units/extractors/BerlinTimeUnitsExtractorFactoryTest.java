package com.ubs.opsit.interviews.units.extractors;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class BerlinTimeUnitsExtractorFactoryTest {

    @Test
    public void testGetBerlinSecondsExtractor() {
        assertNotNull(BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.SECONDS));
    }

    @Test
    public void testBerlinSecondsExtractorIsSingleton() {
        TimeUnitsExtractor extractor1 = BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.SECONDS);
        TimeUnitsExtractor extractor2 = BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.SECONDS);
        assertSame(extractor1, extractor2);
    }

    @Test
    public void testGetBerlinHoursExtractor() {
        assertNotNull(BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.HOURS));
    }

    @Test
    public void testBerlinHoursExtractorIsSingleton() {
        TimeUnitsExtractor extractor1 = BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.HOURS);
        TimeUnitsExtractor extractor2 = BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.HOURS);
        assertSame(extractor1, extractor2);
    }

    @Test
    public void testGetBerlinMinutesExtractor() {
        assertNotNull(BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.MINUTES));
    }

    @Test
    public void testBerlinMinutesExtractorIsSingleton() {
        TimeUnitsExtractor extractor1 = BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.MINUTES);
        TimeUnitsExtractor extractor2 = BerlinTimeUnitsExtractorFactory.getTimeUnitsExtractor(TimeUnit.MINUTES);
        assertSame(extractor1, extractor2);
    }
}