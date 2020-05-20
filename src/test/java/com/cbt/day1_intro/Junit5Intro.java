package com.cbt.day1_intro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Junit5Intro {

    @BeforeAll
    public static void runBeforeEverythingInClass() {
        System.out.println("runs once before everything");
    }

    @BeforeEach
    public void runBeforeEachTest() {
        System.out.println("runs before every test");
    }

    @Test
    public void test1() {
        // in junit 5 assertions are inside the assertions class.
        Assertions.assertEquals(1, 1);
    }

    @Test
    public void test2() {
        Assertions.assertTrue(true);

        Assertions.assertAll(
                () -> Assertions.assertTrue(true),
                () -> Assertions.assertEquals(2, 1),
                () -> Assertions.assertTrue(true),
                () -> Assertions.assertEquals(33, 1)

        );
    }

}
