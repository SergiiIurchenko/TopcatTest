package com.ubs.opsit.interviews.time.container;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertArrayEquals;

public class TimeContainerCreatorTest {

    @Test
    public void testGetDoubleMidnightTimeForRegularInput() {
        int[] expected = new int[]{23, 59, 59};

        TimeContainer timeContainer = new TimeContainerCreator().getDoubleMidnightTime("23:59:59");
        assertArrayEquals(expected,
                new int[]{timeContainer.get(TimeUnit.HOURS), timeContainer.get(TimeUnit.MINUTES), timeContainer.get(TimeUnit.SECONDS)});
    }

    @Test
    public void testGetDoubleMidnightTimeFor0MidnightInput() {
        int[] expected = new int[]{0, 0, 0};

        TimeContainer timeContainer = new TimeContainerCreator().getDoubleMidnightTime("00:00:00");
        assertArrayEquals(expected,
                new int[]{timeContainer.get(TimeUnit.HOURS), timeContainer.get(TimeUnit.MINUTES), timeContainer.get(TimeUnit.SECONDS)});
    }

    @Test
    public void testGetDoubleMidnightTimeFor24MidnightInput() {
        int[] expected = new int[]{24, 0, 0};

        TimeContainer timeContainer = new TimeContainerCreator().getDoubleMidnightTime("24:00:00");
        assertArrayEquals(expected,
                new int[]{timeContainer.get(TimeUnit.HOURS), timeContainer.get(TimeUnit.MINUTES), timeContainer.get(TimeUnit.SECONDS)});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoubleMidnightTimeForInvalidHoursInput() {
        new TimeContainerCreator().getDoubleMidnightTime("25:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoubleMidnightTimeForInvalidMinutesInput() {
        new TimeContainerCreator().getDoubleMidnightTime("00:60:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoubleMidnightTimeForInvalidSecondsInput() {
        new TimeContainerCreator().getDoubleMidnightTime("00:59:1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoubleMidnightTimeForInvalidLogicalInput() {
        new TimeContainerCreator().getDoubleMidnightTime("24:00:01");
    }
}