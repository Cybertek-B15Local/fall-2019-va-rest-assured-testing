package com.cbt.tests.office_hours;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTests {
    @Test
    public void addTests() {
        int actual = Calculator.add(1, 1);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyTests() {
        double ac = Calculator.multiply(1, 1);
        assertEquals(1, ac);

        assertEquals(-1, Calculator.multiply(-1, 1));
        assertEquals(1, Calculator.multiply(-1, -1));
//        assertEquals(0, Calculator.multiply(-1, 0));
    }

    @Test
    public void minusTest(){
        assertEquals(1, Calculator.minus(2,1));
    }

    @Test
    public void testDivide(){
        assertEquals(2, Calculator.divide(10,5));
        assertEquals(0, Calculator.divide(10,0));
        assertNotEquals(10, Calculator.divide(10,0));
    }

}
