package com.ubs.opsit.interviews.time.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class BerlinMinutesConverterTest {

    @Test
    public void testGetZero() {
        String expected = LampsRowTestHelper.getSameLampsRow(11, BerlinColor.O)
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(4, BerlinColor.O);

        assertEquals(expected, getBerlinMinutesConverter().get(0));
    }

    @Test
    public void testGet59Minutes() {
        String expected = LampsRowTestHelper.getFullyLightedMinutesTopRow()
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(4, BerlinColor.Y);

        assertEquals(expected, getBerlinMinutesConverter().get(59));
    }

    @Test
    public void testGet55Minutes() {
        String expected = LampsRowTestHelper.getFullyLightedMinutesTopRow()
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(4, BerlinColor.O);

        assertEquals(expected, getBerlinMinutesConverter().get(55));
    }

    @Test
    public void testGet4Minutes() {
        String expected = LampsRowTestHelper.getSameLampsRow(11, BerlinColor.O)
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(4, BerlinColor.Y);

        assertEquals(expected, getBerlinMinutesConverter().get(4));
    }

    @Test
    public void testGet33Minutes() {
        String expected = LampsRowTestHelper.getMinutesLightedSection() + LampsRowTestHelper.getMinutesLightedSection()
                + LampsRowTestHelper.getSameLampsRow(5, BerlinColor.O)
                + System.lineSeparator()
                + LampsRowTestHelper.getSameLampsRow(3, BerlinColor.Y) + BerlinColor.O;

        assertEquals(expected, getBerlinMinutesConverter().get(33));
    }

    private TimeUnitsConverter getBerlinMinutesConverter() {
        BerlinMinutesConverter berlinMinutesConverter = new BerlinMinutesConverter();
        berlinMinutesConverter.setLampsSequencesBuilder(new BerlinLampsSequencesBuilder());
        berlinMinutesConverter.setLineSeparator(System.lineSeparator());
        return berlinMinutesConverter;
    }
}