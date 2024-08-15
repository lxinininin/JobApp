package com.linxin.SpringBootRest.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    public void logMethodCall() {
        LOGGER.info("Method called");
    }

}
