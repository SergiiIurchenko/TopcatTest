package com.ubs.opsit.interviews.time.converter;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockTimeConverterTest {
    private static TimeConverter berlinClockTimeConverter;

    @BeforeClass
    public static void init() {
        berlinClockTimeConverter = TimeConverterFactory.getBerlinClockTimeConverter();
    }

    @Test
    public void testConvertTimeForRegularInput1() {
        String expected = "Y" + System.lineSeparator() +
                "ROOO" + System.lineSeparator() +
                "ROOO" + System.lineSeparator() +
                "YYRYOOOOOOO" + System.lineSeparator() +
                "YYYO";

        assertEquals(expected, berlinClockTimeConverter.convertTime("06:23:02"));
    }

    @Test
    public void testConvertTimeForRegularInput2() {
        String expected = "O" + System.lineSeparator() +
                "RRRO" + System.lineSeparator() +
                "RRRO" + System.lineSeparator() +
                "YYRYYRYOOOO" + System.lineSeparator() +
                "YOOO";

        assertEquals(expected, berlinClockTimeConverter.convertTime("18:36:05"));
    }

    @Test
    public void testConvertTimeForRegularInput3() {
        String expected = "O" + System.lineSeparator() +
                "RRRO" + System.lineSeparator() +
                "RRRO" + System.lineSeparator() +
                "YYRYYRYOOOO" + System.lineSeparator() +
                "YOOO";

        assertEquals(expected, berlinClockTimeConverter.convertTime(" 18:36:59 "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForInvalidFormatInput1() {
        berlinClockTimeConverter.convertTime("1:36:05");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForInvalidFormatInput2() {
        berlinClockTimeConverter.convertTime("36:05");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForInvalidFormatInput3() {
        berlinClockTimeConverter.convertTime("01-36-05");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForInvalidFormatInput4() {
        berlinClockTimeConverter.convertTime("OO:OO:OO");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForInvalidFormatInput5() {
        berlinClockTimeConverter.convertTime("00:00:00.99");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForInvalidTimeInput1() {
        berlinClockTimeConverter.convertTime("24:00:01");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForInvalidTimeInput2() {
        berlinClockTimeConverter.convertTime("23:59:60");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForBlankInput1() {
        berlinClockTimeConverter.convertTime("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForBlankInput2() {
        berlinClockTimeConverter.convertTime(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeForNullInput() {
        berlinClockTimeConverter.convertTime(null);
    }
}