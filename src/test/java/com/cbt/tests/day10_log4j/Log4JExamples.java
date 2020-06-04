package com.cbt.tests.day10_log4j;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class Log4JExamples {

    private static final Logger logger = LogManager.getLogger(Log4JExamples.class);

    @Test
    public void testLogger() {
        System.out.println("wooden spoon");
        logger.info("wooden spoon");
        logger.info("hello world");
    }


    @Test
    public void anotherOne() {
        logger.setLevel(Level.TRACE);

        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }

    // BREAK 7.43
}
