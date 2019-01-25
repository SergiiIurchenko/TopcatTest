package com.ubs.opsit.interviews.time.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class BerlinHoursConverterTest {

    @Test
    public void testGetZero() {
        String expected = LampsRowTestHelper.getSameLampsRow(4, BerlinColor.O)
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(4, BerlinColor.O);

        assertEquals(expected, getBerlinHoursConverter().get(0));
    }

    @Test
    public void testGet24Hours() {
        String expected = LampsRowTestHelper.getSameLampsRow(4, BerlinColor.R)
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(4, BerlinColor.R);

        assertEquals(expected, getBerlinHoursConverter().get(24));
    }

    @Test
    public void testGet4Hours() {
        String expected = LampsRowTestHelper.getSameLampsRow(4, BerlinColor.O)
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(4, BerlinColor.R);

        assertEquals(expected, getBerlinHoursConverter().get(4));
    }

    @Test
    public void testGet20Hours() {
        String expected = LampsRowTestHelper.getSameLampsRow(4, BerlinColor.R)
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(4, BerlinColor.O);

        assertEquals(expected, getBerlinHoursConverter().get(20));
    }

    @Test
    public void testGet17Hours() {
        String expected = LampsRowTestHelper.getSameLampsRow(3, BerlinColor.R) + BerlinColor.O
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(2, BerlinColor.R) + LampsRowTestHelper.getSameLampsRow(2, BerlinColor.O);

        assertEquals(expected, getBerlinHoursConverter().get(17));
    }

    private TimeUnitsConverter getBerlinHoursConverter() {
        BerlinHoursConverter berlinHoursConverter = new BerlinHoursConverter();
        berlinHoursConverter.setLampsSequencesBuilder(new BerlinLampsSequencesBuilder());
        berlinHoursConverter.setLineSeparator(System.lineSeparator());
        return berlinHoursConverter;
    }
}