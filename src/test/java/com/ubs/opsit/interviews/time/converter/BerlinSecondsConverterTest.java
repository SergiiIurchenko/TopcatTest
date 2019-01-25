package com.ubs.opsit.interviews.time.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinSecondsConverterTest {

    @Test
    public void testGetZero() {
        assertEquals(BerlinColor.Y, new BerlinSecondsConverter().get(0));
    }

    @Test
    public void testGetEven() {
        assertEquals(BerlinColor.Y, new BerlinSecondsConverter().get(16));
    }

    @Test
    public void testGetOdd() {
        assertEquals(BerlinColor.O, new BerlinSecondsConverter().get(3));
    }


}