package dev.aj.junit5testing.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.stream.Stream;

@DisplayName(value = "Test Calculator")
@Slf4j
class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @AfterAll
    static void afterAll() {
        calculator = null;
    }

    private static Stream<Arguments> testIntegerSubtraction() {
        return Stream.of(
                Arguments.of(4, 3, 1),
                Arguments.of(3, 4, 1),
                Arguments.of(4, 4, 0)
        );
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Test 4/2 = 2")
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        int division = calculator.integerDivision(4, 2);
        Assertions.assertEquals(2, division);
    }

    @Test
    void testDivisionByZero() {
        ArithmeticException arithmeticException = Assertions.assertThrows(ArithmeticException.class,
                                                                          () -> calculator.integerDivision(4, 0));
        log.info("Arithmetic Exception thrown with a message '{}'", arithmeticException.getMessage());
    }

    @Test
    void integerMultiplication() {

        int multiplication = calculator.integerMultiplication(4, 2);

        Assertions.assertEquals(8, multiplication);
    }

    @Test
    void testAddition() {
        int addition = calculator.addition(4, 2);
        Assertions.assertEquals(6, addition);
    }

    @Test
    void testSubtraction() {
        int subtractionOfSmallerNumber = calculator.subtraction(4, 2);
        int subtractionOfLargerNumber = calculator.subtraction(2, 4);
        int subtractionOfEqualNumber = calculator.subtraction(4, 4);

        Assertions.assertAll("Test subtractions of various combinations",
                             () -> Assertions.assertEquals(2, subtractionOfSmallerNumber),
                             () -> Assertions.assertEquals(2, subtractionOfLargerNumber),
                             () -> Assertions.assertEquals(0, subtractionOfEqualNumber));
    }

    @ParameterizedTest
    @MethodSource
    void testIntegerSubtraction(int minuend, int subtrahend, int expectedResult) {
        int actualResult = calculator.subtraction(minuend, subtrahend);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "3, 5, 2",
            "5, 5, 0"
    })
    void testingSubtraction(int minuend, int subtrahend, int expectedResult) {
        int actualResult = calculator.subtraction(minuend, subtrahend);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "apple, mango",
            "apple, ''",
            "apple,"
    })
    void testingStringValue(String firstString, String secondString) {
        if (Objects.isNull(firstString) || Objects.isNull(secondString)) {
            System.out.println("One of the string arguments is null");
        } else if (firstString.isBlank() || secondString.isBlank()) {
            System.out.println("One of the string arguments is blank");
        } else {
            Assertions.assertEquals(firstString.length(), secondString.length());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "2011-12-03T06:15:30+05:30, 03/12/2011"
    })
    void testDateConversion(String dateText, String expectedDateTime) {
        OffsetDateTime date = OffsetDateTime.parse(dateText, DateTimeFormatter.ISO_DATE_TIME);
        Assertions.assertNotEquals(expectedDateTime, date);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Amarjit", "Bhandal", "", "''", "' '"})
    void valueSourceAssessment(String firstName) {
        if (Objects.isNull(firstName)) {
            log.info("We have null here.");
        } else if (firstName.isBlank()) {
            log.info("{} is blank or empty = ", firstName);
        } else {
            Assertions.assertNotNull(firstName);
        }
    }
}