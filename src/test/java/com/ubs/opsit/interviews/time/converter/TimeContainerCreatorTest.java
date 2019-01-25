package com.ubs.opsit.interviews.time.converter;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TimeContainerCreatorTest {

    @Test
    public void testGetDoubleMidnightTimeForRegularInput() {
        int[] expected = new int[]{23, 59, 59};

        TimeUnitsContainer timeContainer = new TimeContainerCreator().getTimeUnitsContainer("23:59:59");
        assertArrayEquals(expected,
                new int[]{timeContainer.getHours(), timeContainer.getMinutes(), timeContainer.getSeconds()});
    }

    @Test
    public void testGetDoubleMidnightTimeFor0MidnightInput() {
        int[] expected = new int[]{0, 0, 0};

        TimeUnitsContainer timeContainer = new TimeContainerCreator().getTimeUnitsContainer("00:00:00");
        assertArrayEquals(expected,
                new int[]{timeContainer.getHours(), timeContainer.getMinutes(), timeContainer.getSeconds()});
    }

    @Test
    public void testGetDoubleMidnightTimeFor24MidnightInput() {
        int[] expected = new int[]{24, 0, 0};

        TimeUnitsContainer timeContainer = new TimeContainerCreator().getTimeUnitsContainer("24:00:00");
        assertArrayEquals(expected,
                new int[]{timeContainer.getHours(), timeContainer.getMinutes(), timeContainer.getSeconds()});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoubleMidnightTimeForInvalidHoursInput() {
        new TimeContainerCreator().getTimeUnitsContainer("25:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoubleMidnightTimeForInvalidMinutesInput() {
        new TimeContainerCreator().getTimeUnitsContainer("00:60:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoubleMidnightTimeForInvalidSecondsInput() {
        new TimeContainerCreator().getTimeUnitsContainer("00:59:1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDoubleMidnightTimeForInvalidLogicalInput() {
        new TimeContainerCreator().getTimeUnitsContainer("24:00:01");
    }
}