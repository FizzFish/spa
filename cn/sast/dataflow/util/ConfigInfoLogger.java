/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.util.ConfigInfoLogger
 *  cn.sast.dataflow.util.ConfigInfoLogger$Companion
 *  com.feysh.corax.config.api.AIAnalysisApi$Error
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.dataflow.util;

import cn.sast.dataflow.util.ConfigInfoLogger;
import com.feysh.corax.config.api.AIAnalysisApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2={"Lcn/sast/dataflow/util/ConfigInfoLogger;", "Lcom/feysh/corax/config/api/AIAnalysisApi$Error;", "<init>", "()V", "errors", "", "", "getErrors", "()Ljava/util/List;", "warnings", "getWarnings", "error", "", "msg", "warning", "logger", "Lmu/KLogger;", "getLogger", "()Lmu/KLogger;", "Companion", "corax-data-flow"})
public final class ConfigInfoLogger
implements AIAnalysisApi.Error {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<String> errors = new ArrayList();
    @NotNull
    private final List<String> warnings = new ArrayList();
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ConfigInfoLogger::logger$lambda$2);

    @NotNull
    public final List<String> getErrors() {
        return this.errors;
    }

    @NotNull
    public final List<String> getWarnings() {
        return this.warnings;
    }

    public void error(@NotNull String msg) {
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        this.getLogger().error(() -> ConfigInfoLogger.error$lambda$0(msg));
        this.errors.add(msg);
    }

    public void warning(@NotNull String msg) {
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        this.getLogger().warn(() -> ConfigInfoLogger.warning$lambda$1(msg));
        this.warnings.add(msg);
    }

    @NotNull
    public KLogger getLogger() {
        return logger;
    }

    private static final Object error$lambda$0(String $msg) {
        return $msg;
    }

    private static final Object warning$lambda$1(String $msg) {
        return $msg;
    }

    private static final Unit logger$lambda$2() {
        return Unit.INSTANCE;
    }
}

