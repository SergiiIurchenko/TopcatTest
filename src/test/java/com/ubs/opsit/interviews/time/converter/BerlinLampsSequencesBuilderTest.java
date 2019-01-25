package com.ubs.opsit.interviews.time.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class BerlinLampsSequencesBuilderTest {

    @Test
    public void testAppendRegularRowWithAllLampsLighted() {
        String expected = LampsRowTestHelper.getSameLampsRow(4, BerlinColor.R);
        String result = new BerlinLampsSequencesBuilder().getRegularRow(4, 4, BerlinColor.R);
        assertEquals(expected, result);
    }

    @Test
    public void testAppendRegularRowWithAllLampsOff() {
        String expected = LampsRowTestHelper.getSameLampsRow(4, BerlinColor.O);
        String result = new BerlinLampsSequencesBuilder().getRegularRow(0, 4, BerlinColor.O);
        assertEquals(expected, result);
    }

    @Test
    public void testAppendRegularRowWithHalfLampsLighted() {
        String expected = LampsRowTestHelper.getSameLampsRow(2, BerlinColor.Y) + LampsRowTestHelper.getSameLampsRow(2, BerlinColor.O);
        String result = new BerlinLampsSequencesBuilder().getRegularRow(2, 4, BerlinColor.Y);
        assertEquals(expected, result);
    }

    @Test
    public void testAppendLightedBySectionsForAllLampsLighted() {
        String expected = LampsRowTestHelper.getFullyLightedMinutesTopRow();
        String result = new BerlinLampsSequencesBuilder().getMinutesLightedSequence(11, 11, 3);
        assertEquals(expected, result);
    }

    @Test
    public void testAppendLightedBySectionsForAllLampsOff() {
        String expected = LampsRowTestHelper.getSameLampsRow(11, BerlinColor.O);
        String result = new BerlinLampsSequencesBuilder().getMinutesLightedSequence(0, 11, 3);
        assertEquals(expected, result);
    }

    @Test
    public void testAppendLightedBySectionsForAHalfLampsLighted() {
        String expected = LampsRowTestHelper.getMinutesLightedSection() + LampsRowTestHelper.getMinutesLightedSection() + LampsRowTestHelper.getSameLampsRow(5, BerlinColor.O);
        String result = new BerlinLampsSequencesBuilder().getMinutesLightedSequence(6, 11, 3);
        assertEquals(expected, result);
    }
}