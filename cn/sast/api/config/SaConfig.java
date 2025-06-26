/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.BuiltinAnalysisConfig
 *  cn.sast.api.config.PreAnalysisConfig
 *  cn.sast.api.config.SaConfig
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.CheckerUnit
 *  com.feysh.corax.config.api.ISootInitializeHandler
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.BuiltinAnalysisConfig;
import cn.sast.api.config.PreAnalysisConfig;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.CheckerUnit;
import com.feysh.corax.config.api.ISootInitializeHandler;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\nH\u00c6\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007H\u00c6\u0003JI\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020&H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006'"}, d2={"Lcn/sast/api/config/SaConfig;", "", "builtinAnalysisConfig", "Lcn/sast/api/config/BuiltinAnalysisConfig;", "preAnalysisConfig", "Lcn/sast/api/config/PreAnalysisConfig;", "checkers", "", "Lcom/feysh/corax/config/api/CheckerUnit;", "sootConfig", "Lcom/feysh/corax/config/api/ISootInitializeHandler;", "enableCheckTypes", "Lcom/feysh/corax/config/api/CheckType;", "<init>", "(Lcn/sast/api/config/BuiltinAnalysisConfig;Lcn/sast/api/config/PreAnalysisConfig;Ljava/util/Set;Lcom/feysh/corax/config/api/ISootInitializeHandler;Ljava/util/Set;)V", "getBuiltinAnalysisConfig", "()Lcn/sast/api/config/BuiltinAnalysisConfig;", "getPreAnalysisConfig", "()Lcn/sast/api/config/PreAnalysisConfig;", "getCheckers", "()Ljava/util/Set;", "getSootConfig", "()Lcom/feysh/corax/config/api/ISootInitializeHandler;", "getEnableCheckTypes", "isEnable", "", "checkType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "corax-api"})
public final class SaConfig {
    @NotNull
    private final BuiltinAnalysisConfig builtinAnalysisConfig;
    @NotNull
    private final PreAnalysisConfig preAnalysisConfig;
    @NotNull
    private final Set<CheckerUnit> checkers;
    @NotNull
    private final ISootInitializeHandler sootConfig;
    @Nullable
    private final Set<CheckType> enableCheckTypes;

    public SaConfig(@NotNull BuiltinAnalysisConfig builtinAnalysisConfig, @NotNull PreAnalysisConfig preAnalysisConfig, @NotNull Set<? extends CheckerUnit> checkers, @NotNull ISootInitializeHandler sootConfig, @Nullable Set<? extends CheckType> enableCheckTypes) {
        Intrinsics.checkNotNullParameter((Object)builtinAnalysisConfig, (String)"builtinAnalysisConfig");
        Intrinsics.checkNotNullParameter((Object)preAnalysisConfig, (String)"preAnalysisConfig");
        Intrinsics.checkNotNullParameter(checkers, (String)"checkers");
        Intrinsics.checkNotNullParameter((Object)sootConfig, (String)"sootConfig");
        this.builtinAnalysisConfig = builtinAnalysisConfig;
        this.preAnalysisConfig = preAnalysisConfig;
        this.checkers = checkers;
        this.sootConfig = sootConfig;
        this.enableCheckTypes = enableCheckTypes;
    }

    public /* synthetic */ SaConfig(BuiltinAnalysisConfig builtinAnalysisConfig, PreAnalysisConfig preAnalysisConfig, Set set, ISootInitializeHandler iSootInitializeHandler, Set set2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            builtinAnalysisConfig = new BuiltinAnalysisConfig(null, null, 0, 0, 15, null);
        }
        if ((n & 2) != 0) {
            preAnalysisConfig = new PreAnalysisConfig(0, 0, 0, null, 0, 31, null);
        }
        this(builtinAnalysisConfig, preAnalysisConfig, set, iSootInitializeHandler, set2);
    }

    @NotNull
    public final BuiltinAnalysisConfig getBuiltinAnalysisConfig() {
        return this.builtinAnalysisConfig;
    }

    @NotNull
    public final PreAnalysisConfig getPreAnalysisConfig() {
        return this.preAnalysisConfig;
    }

    @NotNull
    public final Set<CheckerUnit> getCheckers() {
        return this.checkers;
    }

    @NotNull
    public final ISootInitializeHandler getSootConfig() {
        return this.sootConfig;
    }

    @Nullable
    public final Set<CheckType> getEnableCheckTypes() {
        return this.enableCheckTypes;
    }

    public final boolean isEnable(@NotNull CheckType checkType) {
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Set set = this.enableCheckTypes;
        return set != null ? set.contains(checkType) : true;
    }

    @NotNull
    public final BuiltinAnalysisConfig component1() {
        return this.builtinAnalysisConfig;
    }

    @NotNull
    public final PreAnalysisConfig component2() {
        return this.preAnalysisConfig;
    }

    @NotNull
    public final Set<CheckerUnit> component3() {
        return this.checkers;
    }

    @NotNull
    public final ISootInitializeHandler component4() {
        return this.sootConfig;
    }

    @Nullable
    public final Set<CheckType> component5() {
        return this.enableCheckTypes;
    }

    @NotNull
    public final SaConfig copy(@NotNull BuiltinAnalysisConfig builtinAnalysisConfig, @NotNull PreAnalysisConfig preAnalysisConfig, @NotNull Set<? extends CheckerUnit> checkers, @NotNull ISootInitializeHandler sootConfig, @Nullable Set<? extends CheckType> enableCheckTypes) {
        Intrinsics.checkNotNullParameter((Object)builtinAnalysisConfig, (String)"builtinAnalysisConfig");
        Intrinsics.checkNotNullParameter((Object)preAnalysisConfig, (String)"preAnalysisConfig");
        Intrinsics.checkNotNullParameter(checkers, (String)"checkers");
        Intrinsics.checkNotNullParameter((Object)sootConfig, (String)"sootConfig");
        return new SaConfig(builtinAnalysisConfig, preAnalysisConfig, checkers, sootConfig, enableCheckTypes);
    }

    public static /* synthetic */ SaConfig copy$default(SaConfig saConfig, BuiltinAnalysisConfig builtinAnalysisConfig, PreAnalysisConfig preAnalysisConfig, Set set, ISootInitializeHandler iSootInitializeHandler, Set set2, int n, Object object) {
        if ((n & 1) != 0) {
            builtinAnalysisConfig = saConfig.builtinAnalysisConfig;
        }
        if ((n & 2) != 0) {
            preAnalysisConfig = saConfig.preAnalysisConfig;
        }
        if ((n & 4) != 0) {
            set = saConfig.checkers;
        }
        if ((n & 8) != 0) {
            iSootInitializeHandler = saConfig.sootConfig;
        }
        if ((n & 0x10) != 0) {
            set2 = saConfig.enableCheckTypes;
        }
        return saConfig.copy(builtinAnalysisConfig, preAnalysisConfig, set, iSootInitializeHandler, set2);
    }

    @NotNull
    public String toString() {
        return "SaConfig(builtinAnalysisConfig=" + this.builtinAnalysisConfig + ", preAnalysisConfig=" + this.preAnalysisConfig + ", checkers=" + this.checkers + ", sootConfig=" + this.sootConfig + ", enableCheckTypes=" + this.enableCheckTypes + ")";
    }

    public int hashCode() {
        int result = this.builtinAnalysisConfig.hashCode();
        result = result * 31 + this.preAnalysisConfig.hashCode();
        result = result * 31 + ((Object)this.checkers).hashCode();
        result = result * 31 + this.sootConfig.hashCode();
        result = result * 31 + (this.enableCheckTypes == null ? 0 : ((Object)this.enableCheckTypes).hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaConfig)) {
            return false;
        }
        SaConfig saConfig = (SaConfig)other;
        if (!Intrinsics.areEqual((Object)this.builtinAnalysisConfig, (Object)saConfig.builtinAnalysisConfig)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.preAnalysisConfig, (Object)saConfig.preAnalysisConfig)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.checkers, (Object)saConfig.checkers)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.sootConfig, (Object)saConfig.sootConfig)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.enableCheckTypes, (Object)saConfig.enableCheckTypes);
    }
}

