/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.command.tools.UtilsCli
 *  cn.sast.cli.command.tools.UtilsCliKt
 *  cn.sast.common.OS
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.cli.command.tools;

import cn.sast.cli.command.tools.UtilsCli;
import cn.sast.common.OS;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"main", "", "args", "", "", "([Ljava/lang/String;)V", "corax-cli"})
public final class UtilsCliKt {
    public static final void main(@NotNull String[] args) {
        Intrinsics.checkNotNullParameter((Object)args, (String)"args");
        KLogger logger = KotlinLogging.INSTANCE.logger(UtilsCliKt::main$lambda$0);
        OS.INSTANCE.setArgs(args);
        try {
            new UtilsCli().main(args);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        catch (Throwable t) {
            logger.error(t, () -> UtilsCliKt.main$lambda$1(t));
            System.exit(1);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    private static final Unit main$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Object main$lambda$1(Throwable $t) {
        return "An error occurred: " + $t;
    }
}

