package com.cbt.tests.day10_log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class Log4JExamples {

    private static final Logger logger = LogManager.getLogger(Log4JExamples.class);
    @Test
    public void testLogger(){
        System.out.println("wooden spoon");
        logger.info("wooden spoon");
        logger.info("hello world");
    }
}
