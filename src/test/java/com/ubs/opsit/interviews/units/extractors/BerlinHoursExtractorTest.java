package com.ubs.opsit.interviews.units.extractors;

import com.ubs.opsit.interviews.time.container.TimeContainerCreator;
import org.junit.Test;

import static com.ubs.opsit.interviews.units.extractors.LampsRowTestHelper.getSameLampsRow;
import static org.junit.Assert.*;

public class BerlinHoursExtractorTest {

    @Test
    public void testGetZero() {
        StringBuilder expected = new StringBuilder();
        expected.append(getSameLampsRow(4, BerlinColor.O));
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(4, BerlinColor.O));

        assertEquals(expected.toString(), new BerlinHoursExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("00:00:00")));
    }

    @Test
    public void testGet24Hours() {
        StringBuilder expected = new StringBuilder();
        expected.append(getSameLampsRow(4, BerlinColor.R));
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(4, BerlinColor.R));

        assertEquals(expected.toString(), new BerlinHoursExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("24:00:00")));
    }

    @Test
    public void testGet4Hours() {
        StringBuilder expected = new StringBuilder();
        expected.append(getSameLampsRow(4, BerlinColor.O));
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(4, BerlinColor.R));

        assertEquals(expected.toString(), new BerlinHoursExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("04:00:00")));
    }

    @Test
    public void testGet20Hours() {
        StringBuilder expected = new StringBuilder();
        expected.append(getSameLampsRow(4, BerlinColor.R));
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(4, BerlinColor.O));

        assertEquals(expected.toString(), new BerlinHoursExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("20:00:00")));
    }

    @Test
    public void testGet17Hours() {
        StringBuilder expected = new StringBuilder();
        expected.append(getSameLampsRow(3, BerlinColor.R)).append(BerlinColor.O);
        expected.append(System.lineSeparator());
        expected.append(getSameLampsRow(2, BerlinColor.R)).append(getSameLampsRow(2, BerlinColor.O));

        assertEquals(expected.toString(), new BerlinHoursExtractor().get(new TimeContainerCreator().getDoubleMidnightTime("17:00:00")));
    }
}