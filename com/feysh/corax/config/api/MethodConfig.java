/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.config.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/config/api/MethodConfig;", "", "at", "Lcom/feysh/corax/config/api/MethodConfig$CheckCall;", "<init>", "(Lcom/feysh/corax/config/api/MethodConfig$CheckCall;)V", "getAt", "()Lcom/feysh/corax/config/api/MethodConfig$CheckCall;", "setAt", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CheckCall", "corax-config-api"})
public final class MethodConfig {
    @NotNull
    private CheckCall at;

    public MethodConfig(@NotNull CheckCall at) {
        Intrinsics.checkNotNullParameter((Object)((Object)at), (String)"at");
        this.at = at;
    }

    @NotNull
    public final CheckCall getAt() {
        return this.at;
    }

    public final void setAt(@NotNull CheckCall checkCall) {
        Intrinsics.checkNotNullParameter((Object)((Object)checkCall), (String)"<set-?>");
        this.at = checkCall;
    }

    @NotNull
    public final CheckCall component1() {
        return this.at;
    }

    @NotNull
    public final MethodConfig copy(@NotNull CheckCall at) {
        Intrinsics.checkNotNullParameter((Object)((Object)at), (String)"at");
        return new MethodConfig(at);
    }

    public static /* synthetic */ MethodConfig copy$default(MethodConfig methodConfig, CheckCall checkCall, int n, Object object) {
        if ((n & 1) != 0) {
            checkCall = methodConfig.at;
        }
        return methodConfig.copy(checkCall);
    }

    @NotNull
    public String toString() {
        return "MethodConfig(at=" + this.at + ")";
    }

    public int hashCode() {
        return this.at.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MethodConfig)) {
            return false;
        }
        MethodConfig methodConfig = (MethodConfig)other;
        return this.at == methodConfig.at;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/config/api/MethodConfig$CheckCall;", "", "<init>", "(Ljava/lang/String;I)V", "PrevCallInCaller", "EvalCallInCaller", "PrevCallInCallee", "EvalCallInCallee", "PostCallInCallee", "PostCallInCaller", "corax-config-api"})
    public static final class CheckCall
    extends Enum<CheckCall> {
        public static final /* enum */ CheckCall PrevCallInCaller = new CheckCall();
        public static final /* enum */ CheckCall EvalCallInCaller = new CheckCall();
        public static final /* enum */ CheckCall PrevCallInCallee = new CheckCall();
        public static final /* enum */ CheckCall EvalCallInCallee = new CheckCall();
        public static final /* enum */ CheckCall PostCallInCallee = new CheckCall();
        public static final /* enum */ CheckCall PostCallInCaller = new CheckCall();
        private static final /* synthetic */ CheckCall[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static CheckCall[] values() {
            return (CheckCall[])$VALUES.clone();
        }

        public static CheckCall valueOf(String value) {
            return Enum.valueOf(CheckCall.class, value);
        }

        @NotNull
        public static EnumEntries<CheckCall> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = checkCallArray = new CheckCall[]{CheckCall.PrevCallInCaller, CheckCall.EvalCallInCaller, CheckCall.PrevCallInCallee, CheckCall.EvalCallInCallee, CheckCall.PostCallInCallee, CheckCall.PostCallInCaller};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

