package com.ubs.opsit.interviews.units.extractors;

import com.ubs.opsit.interviews.time.container.TimeContainerCreator;
import org.junit.Test;

import static com.ubs.opsit.interviews.units.extractors.LampsRowTestHelper.*;
import static org.junit.Assert.*;

public class BerlinMinutesExtractorTest {

    @Test
    public void testGetZero() {
        StringBuilder expected = new StringBuilder();
        expected.append(getSameLampsRow(11, BerlinColor.O));
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(4, BerlinColor.O));

        assertEquals(expected.toString(), new BerlinMinutesExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("00:00:00")));
    }

    @Test
    public void testGet59Minutes() {
        StringBuilder expected = new StringBuilder();
        expected.append(getFullyLightedMinutesTopRow());
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(4, BerlinColor.Y));

        assertEquals(expected.toString(), new BerlinMinutesExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("00:59:00")));
    }

    @Test
    public void testGet55Minutes() {
        StringBuilder expected = new StringBuilder();
        expected.append(getFullyLightedMinutesTopRow());
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(4, BerlinColor.O));

        assertEquals(expected.toString(), new BerlinMinutesExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("00:55:00")));
    }

    @Test
    public void testGet4Minutes() {
        StringBuilder expected = new StringBuilder();
        expected.append(getSameLampsRow(11, BerlinColor.O));
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(4, BerlinColor.Y));

        assertEquals(expected.toString(), new BerlinMinutesExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("00:04:00")));
    }

    @Test
    public void testGet33Minutes() {
        StringBuilder expected = new StringBuilder();
        expected.append(getMinutesLightedSection()).append(getMinutesLightedSection()).append(getSameLampsRow(5, BerlinColor.O));
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(3, BerlinColor.Y)).append(BerlinColor.O);

        assertEquals(expected.toString(), new BerlinMinutesExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("00:33:00")));
    }
}