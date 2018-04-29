package br.com.welson.ejb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterestCalculatorRemoteTest {

    private InterestCalculatorRemote interestCalculatorRemote;

    @BeforeEach
    void setUp() {
        interestCalculatorRemote = new InterestCalculator();
    }

    @Test
    void calculatePercentageWithNegativeValue() {
        assertEquals(90, interestCalculatorRemote.calculatePercentage(100, -10));
    }

    @Test
    void calculatePercentageWithPositiveValue() {
        assertEquals(110, interestCalculatorRemote.calculatePercentage(100, 10));
    }
}