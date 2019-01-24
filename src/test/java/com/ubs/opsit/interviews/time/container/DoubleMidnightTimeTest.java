package com.ubs.opsit.interviews.time.container;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class DoubleMidnightTimeTest {

    @Test
    public void testGetHours() {
        assertEquals(3, new DoubleMidnightTime(3, 2, 1).get(TimeUnit.HOURS));
    }

    @Test
    public void testGetMinutes() {
        assertEquals(2, new DoubleMidnightTime(3, 2, 1).get(TimeUnit.MINUTES));
    }

    @Test
    public void testGetSeconds() {
        assertEquals(1, new DoubleMidnightTime(3, 2, 1).get(TimeUnit.SECONDS));
    }
}