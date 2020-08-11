package automated_testing_tdd.bai_tap.next_day_calculator;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void findNextDay0() throws ParseException {
        String date = "01/01/2018";
        String expected = "02/01/2018";

        String result = NextDayCalculator.findNextDay(date);
        assertEquals(expected, result);
    }

    @Test
    void findNextDay1() throws ParseException {
        String date = "31/01/2018";
        String expected = "01/02/2018";

        String result = NextDayCalculator.findNextDay(date);
        assertEquals(expected, result);
    }

    @Test
    void findNextDay2() throws ParseException {
        String date = "30/04/2018";
        String expected = "01/05/2018";

        String result = NextDayCalculator.findNextDay(date);
        assertEquals(expected, result);
    }

    @Test
    void findNextDay3() throws ParseException {
        String date = "28/02/2018";
        String expected = "01/03/2018";

        String result = NextDayCalculator.findNextDay(date);
        assertEquals(expected, result);
    }

    @Test
    void findNextDay4() throws ParseException {
        String date = "29/02/2020";
        String expected = "01/03/2020";

        String result = NextDayCalculator.findNextDay(date);
        assertEquals(expected, result);
    }

    @Test
    void findNextDay5() throws ParseException {
        String date = "31/12/2018";
        String expected = "01/01/2019";

        String result = NextDayCalculator.findNextDay(date);
        assertEquals(expected, result);
    }
}