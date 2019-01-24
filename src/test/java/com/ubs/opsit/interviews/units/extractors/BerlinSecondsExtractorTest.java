package com.ubs.opsit.interviews.units.extractors;

import com.ubs.opsit.interviews.time.container.TimeContainerCreator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinSecondsExtractorTest {

    @Test
    public void testGetZero() {
        assertEquals(BerlinColor.Y, new BerlinSecondsExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("00:00:00")));
    }

    @Test
    public void testGetEven() {
        assertEquals(BerlinColor.Y, new BerlinSecondsExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("00:00:16")));
    }

    @Test
    public void testGetOdd() {
        assertEquals(BerlinColor.O, new BerlinSecondsExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("00:00:03")));
    }


}