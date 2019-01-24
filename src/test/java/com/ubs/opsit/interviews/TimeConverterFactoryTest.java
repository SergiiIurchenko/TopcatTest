package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeConverterFactoryTest {

    @Test
    public void testBerlinClockTimeConverterCreation() {
        assertNotNull(TimeConverterFactory.getBerlinClockTimeConverter());
    }

    @Test
    public void testBerlinClockTimeConverterIsSingleton() {
        TimeConverter converter1 = TimeConverterFactory.getBerlinClockTimeConverter();
        TimeConverter converter2 = TimeConverterFactory.getBerlinClockTimeConverter();
        assertSame(converter1, converter2);
    }
}