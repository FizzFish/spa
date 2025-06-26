/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.ApplicationKt
 *  cn.sast.cli.command.FySastCli
 *  cn.sast.common.OS
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.cli;

import cn.sast.cli.command.FySastCli;
import cn.sast.common.OS;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0019\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u00a2\u0006\u0002\u0010\n\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"getVersion", "", "logger", "Lmu/KLogger;", "lastResort", "", "main", "", "args", "", "([Ljava/lang/String;)V", "corax-cli"})
public final class ApplicationKt {
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ApplicationKt::logger$lambda$1);
    @Nullable
    private static byte[] lastResort = new byte[0x1400000];

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final String getVersion() {
        Properties prop = new Properties();
        Closeable closeable = Thread.currentThread().getContextClassLoader().getResourceAsStream("version.properties");
        Throwable throwable = null;
        try {
            InputStream stream = (InputStream)closeable;
            boolean bl = false;
            prop.load(stream);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        String string = prop.getProperty("version");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getProperty(...)");
        return string;
    }

    public static final void main(@NotNull String[] args) {
        Intrinsics.checkNotNullParameter((Object)args, (String)"args");
        OS.INSTANCE.setArgs(args);
        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new /* Unavailable Anonymous Inner Class!! */);
        try {
            new FySastCli().main(args);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        catch (Throwable t) {
            logger.error(t, () -> ApplicationKt.main$lambda$2(t));
            System.exit(1);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    private static final Unit logger$lambda$1() {
        return Unit.INSTANCE;
    }

    private static final Object main$lambda$2(Throwable $t) {
        return "An error occurred: " + $t;
    }

    public static final /* synthetic */ void access$setLastResort$p(byte[] byArray) {
        lastResort = byArray;
    }
}

