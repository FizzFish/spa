package com.feysh.corax.commons;

import java.lang.reflect.Field;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.slf4j.Log4jLogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public final class LoggerUtils {
    private static Level toLog4jLevel(org.slf4j.event.Level level) {
        return Level.toLevel(level.name());
    }

    public static void setVerbosity(@NotNull org.slf4j.event.Level verbosity) {
        if (verbosity == null) {
            throw new IllegalArgumentException("verbosity cannot be null");
        }

        System.out.println("Log Level changed to [" + verbosity + "]");
        
        Logger rootLogger = LogManager.getRootLogger();
        Configurator.setAllLevels(rootLogger.getName(), toLog4jLevel(verbosity));
        
        System.out.printf("apache log4j2 root logger: isTraceEnabled: %b, isDebugEnabled: %b, isInfoEnabled: %b, isWarnEnabled: %b, isErrorEnabled: %b%n",
            rootLogger.isTraceEnabled(),
            rootLogger.isDebugEnabled(),
            rootLogger.isInfoEnabled(),
            rootLogger.isWarnEnabled(),
            rootLogger.isErrorEnabled());

        org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger("ROOT");
        Logger actualLogger = getActualLogger(slf4jLogger);

        if (!rootLogger.getClass().equals(actualLogger.getClass())) {
            System.out.printf("org.slf4j root logger: %s isTraceEnabled: %b, isDebugEnabled: %b, isInfoEnabled: %b, isWarnEnabled: %b, isErrorEnabled: %b%n",
                slf4jLogger.getClass().getSimpleName(),
                slf4jLogger.isTraceEnabled(),
                slf4jLogger.isDebugEnabled(),
                slf4jLogger.isInfoEnabled(),
                slf4jLogger.isWarnEnabled(),
                slf4jLogger.isErrorEnabled());

            throw new IllegalStateException("invalid logger: " + rootLogger.getClass() + 
                " != " + actualLogger + 
                ", 不使用 apache log4j2 可能会导致分析效率减少一倍");
        }
    }

    private static Logger getActualLogger(org.slf4j.Logger slf4jLogger) {
        try {
            Field loggerField = Log4jLogger.class.getDeclaredField("logger");
            loggerField.setAccessible(true);
            Object logger = loggerField.get(slf4jLogger);
            if (logger instanceof Logger) {
                return (Logger) logger;
            }
        } catch (NoSuchFieldException | IllegalAccessException ignore) {
        }
        return (Logger) slf4jLogger;
    }
}