/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.apache.logging.log4j.core.config.Configurator
 *  org.apache.logging.slf4j.Log4jLogger
 *  org.jetbrains.annotations.NotNull
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.slf4j.event.Level
 */
package com.feysh.corax.commons;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.slf4j.Log4jLogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0000\u001a\u00020\u0003H\u0002\u00a2\u0006\u0002\u0010\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003\u00a8\u0006\b"}, d2={"level", "Lorg/apache/logging/log4j/Level;", "kotlin.jvm.PlatformType", "Lorg/slf4j/event/Level;", "(Lorg/slf4j/event/Level;)Lorg/apache/logging/log4j/Level;", "setVerbosity", "", "verbosity", "corax-config-api"})
public final class Logger_utilsKt {
    private static final Level level(org.slf4j.event.Level level) {
        return Level.toLevel((String)level.name());
    }

    public static final void setVerbosity(@NotNull org.slf4j.event.Level verbosity) {
        Field actualLogger;
        Field field;
        Field field2;
        org.apache.logging.log4j.Logger apacheLog4j;
        Intrinsics.checkNotNullParameter((Object)verbosity, (String)"verbosity");
        System.out.println((Object)("Log Level changed to [" + verbosity + "]"));
        org.apache.logging.log4j.Logger $this$setVerbosity_u24lambda_u240 = apacheLog4j = LogManager.getRootLogger();
        boolean bl = false;
        Configurator.setAllLevels((String)$this$setVerbosity_u24lambda_u240.getName(), (Level)Logger_utilsKt.level(verbosity));
        System.out.println((Object)("apache log4j2 root logger: isTraceEnabled: " + $this$setVerbosity_u24lambda_u240.isTraceEnabled() + ", isDebugEnabled: " + $this$setVerbosity_u24lambda_u240.isDebugEnabled() + ", isInfoEnabled: " + $this$setVerbosity_u24lambda_u240.isInfoEnabled() + ", isWarnEnabled: " + $this$setVerbosity_u24lambda_u240.isWarnEnabled() + ", isErrorEnabled: " + $this$setVerbosity_u24lambda_u240.isErrorEnabled()));
        Logger logger = LoggerFactory.getLogger((String)"ROOT");
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        Logger slf4jLogger = logger;
        try {
            field2 = Log4jLogger.class.getDeclaredField("logger");
            field2.setAccessible(true);
            Object object = field2.get(slf4jLogger);
            field2 = object instanceof org.apache.logging.log4j.Logger ? (org.apache.logging.log4j.Logger)object : null;
        }
        catch (NoSuchFieldException ignore) {
            field2 = null;
        }
        if ((field = field2) == null) {
            field = actualLogger = slf4jLogger;
        }
        if (!Intrinsics.areEqual(apacheLog4j.getClass(), actualLogger.getClass())) {
            Logger $this$setVerbosity_u24lambda_u241 = slf4jLogger;
            boolean bl2 = false;
            System.out.println((Object)("org.slf4j root logger:" + $this$setVerbosity_u24lambda_u241.getClass().getSimpleName() + " isTraceEnabled: " + $this$setVerbosity_u24lambda_u241.isTraceEnabled() + ", isDebugEnabled: " + $this$setVerbosity_u24lambda_u241.isDebugEnabled() + ", isInfoEnabled: " + $this$setVerbosity_u24lambda_u241.isInfoEnabled() + ", isWarnEnabled: " + $this$setVerbosity_u24lambda_u241.isWarnEnabled() + ", isErrorEnabled: " + $this$setVerbosity_u24lambda_u241.isErrorEnabled()));
            throw new IllegalStateException(("invalid logger: " + apacheLog4j.getClass() + " != " + actualLogger + ", \u4e0d\u4f7f\u7528 apache log4j2 \u53ef\u80fd\u4f1a\u5bfc\u81f4\u5206\u6790\u6548\u7387\u51cf\u5c11\u4e00\u500d").toString());
        }
    }
}

