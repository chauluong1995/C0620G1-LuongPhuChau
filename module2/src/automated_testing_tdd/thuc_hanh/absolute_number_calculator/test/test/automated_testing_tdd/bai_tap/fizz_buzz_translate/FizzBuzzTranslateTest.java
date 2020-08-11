package automated_testing_tdd.bai_tap.fizz_buzz_translate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @Test
    void translate0() {
        int number = 15;
        String expected = "FizzBuzz";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void translate1() {
        int number = 33;
        String expected = "Fizz";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void translate2() {
        int number = 35;
        String expected = "Buzz";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void translate3() {
        int number = 53;
        String expected = "BuzzFizz Năm Mươi Ba";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void translate4() {
        int number = 31;
        String expected = "Fizz Ba Mươi Mốt";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void translate5() {
        int number = 59;
        String expected = "Buzz Năm Mươi Chín";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void translate6() {
        int number = 2;
        String expected = "Hai";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }

    @Test
    void translate7() {
        int number = 26;
        String expected = "Hai Mươi Sáu";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(expected, result);
    }
}