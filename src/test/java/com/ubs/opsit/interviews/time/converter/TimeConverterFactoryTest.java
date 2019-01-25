package com.ubs.opsit.interviews.time.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeConverterFactoryTest {

    @Test
    public void testBerlinClockTimeConverterCreation() {
        assertEquals(BerlinClockTimeConverter.class, TimeConverterFactory.getBerlinClockTimeConverter().getClass());
    }
}