package com.luv2code.tdd;

import com.luv2code.junitdemo.tdd.FizzBuZZ;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 class FizzBuZZTest {

    @Test
    @DisplayName("Divisible by three")
    @Order(1)
    void testForDivisibleBythree(){

     String expected = "Fizz";
     assertEquals(expected, FizzBuZZ.compute(3),"should return Fizz");
    }
    @Test
    @DisplayName("Divisible by 5")
    @Order(2)
    void testForDivisibleByFive(){

        String expected = "Buzz";
        assertEquals(expected,FizzBuZZ.compute(5),"should return Buzz");
    }
    @Test
    @DisplayName("Divisible by 3 and 5")
    @Order(3)
    void testForDivisibleByThreeAndFive(){

        String expected = "FizzBuzz";
        assertEquals(expected,FizzBuZZ.compute(15),"should return FizzBuzz");
    }
    @Test
    @DisplayName(" not Divisible by 3 and 5")
    @Order(4)
    void testFornotDivisibleByThreeandFive(){

        String expected = "1";
        assertEquals(expected,FizzBuZZ.compute(1),"should return Fizz");
    }

    @DisplayName("testing with small data file")
    @Order(5)
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    void testSmallDataFile(int value, String expected){
        assertEquals(expected,FizzBuZZ.compute(value));
    }
    @DisplayName("testing with medium data file")
    @Order(5)
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    void testMediumDataFile(int value, String expected) {
        assertEquals(expected, FizzBuZZ.compute(value));
    }
    @DisplayName("testing with large data file")
    @Order(5)
    @ParameterizedTest(name = "value={0},expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    void testLargeDataFile(int value, String expected){
        assertEquals(expected,FizzBuZZ.compute(value));
    }
}
