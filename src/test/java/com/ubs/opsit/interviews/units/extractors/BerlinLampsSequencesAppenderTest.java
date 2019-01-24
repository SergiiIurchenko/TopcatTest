package com.ubs.opsit.interviews.units.extractors;

import org.junit.Test;

import static com.ubs.opsit.interviews.units.extractors.LampsRowTestHelper.*;
import static org.junit.Assert.*;

public class BerlinLampsSequencesAppenderTest {

    @Test
    public void testAppendRegularRowWithAllLampsLighted() {
        String expected = getSameLampsRow(4, BerlinColor.R);

        StringBuilder result = new StringBuilder();
        new BerlinLampsSequencesAppender().appendRegularRow(result, 4, 4, BerlinColor.R);

        assertEquals(expected, result.toString());
    }

    @Test
    public void testAppendRegularRowWithAllLampsOff() {
        String expected = getSameLampsRow(4, BerlinColor.O);

        StringBuilder result = new StringBuilder();
        new BerlinLampsSequencesAppender().appendRegularRow(result, 0, 4, BerlinColor.O);

        assertEquals(expected, result.toString());
    }

    @Test
    public void testAppendRegularRowWithHalfLampsLighted() {
        String expected = getSameLampsRow(2, BerlinColor.Y) + getSameLampsRow(2, BerlinColor.O);

        StringBuilder result = new StringBuilder();
        new BerlinLampsSequencesAppender().appendRegularRow(result, 2, 4, BerlinColor.Y);

        assertEquals(expected, result.toString());
    }

    @Test
    public void testAppendLightedBySectionsForAllLampsLighted() {
        String expected = getFullyLightedMinutesTopRow();

        StringBuilder result = new StringBuilder();
        new BerlinLampsSequencesAppender().appendLightedBySections(result, 11, 11, 3);

        assertEquals(expected, result.toString());
    }

    @Test
    public void testAppendLightedBySectionsForAllLampsOff() {
        String expected = getSameLampsRow(11, BerlinColor.O);

        StringBuilder result = new StringBuilder();
        new BerlinLampsSequencesAppender().appendLightedBySections(result, 0, 11, 3);

        assertEquals(expected, result.toString());
    }

    @Test
    public void testAppendLightedBySectionsForAHalfLampsLighted() {
        String expected = getMinutesLightedSection() + getMinutesLightedSection() + getSameLampsRow(5, BerlinColor.O);

        StringBuilder result = new StringBuilder();
        new BerlinLampsSequencesAppender().appendLightedBySections(result, 6, 11, 3);

        assertEquals(expected, result.toString());
    }
}