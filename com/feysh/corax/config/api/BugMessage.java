/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.Unit
 *  soot.jimple.InvokeExpr
 *  soot.tagkit.Host
 */
package com.feysh.corax.config.api;

import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import java.nio.file.Path;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B \u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u00c6\u0003J$\u0010\f\u001a\u00020\u00002\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\"\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2={"Lcom/feysh/corax/config/api/BugMessage;", "", "msg", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/BugMessage$Env;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getMsg", "()Lkotlin/jvm/functions/Function1;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Env", "corax-config-api"})
public final class BugMessage {
    @NotNull
    private final Function1<Env, String> msg;

    public BugMessage(@NotNull Function1<? super Env, String> msg) {
        Intrinsics.checkNotNullParameter(msg, (String)"msg");
        this.msg = msg;
    }

    @NotNull
    public final Function1<Env, String> getMsg() {
        return this.msg;
    }

    @NotNull
    public final Function1<Env, String> component1() {
        return this.msg;
    }

    @NotNull
    public final BugMessage copy(@NotNull Function1<? super Env, String> msg) {
        Intrinsics.checkNotNullParameter(msg, (String)"msg");
        return new BugMessage(msg);
    }

    public static /* synthetic */ BugMessage copy$default(BugMessage bugMessage, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = bugMessage.msg;
        }
        return bugMessage.copy(function1);
    }

    @NotNull
    public String toString() {
        return "BugMessage(msg=" + this.msg + ")";
    }

    public int hashCode() {
        return this.msg.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BugMessage)) {
            return false;
        }
        BugMessage bugMessage = (BugMessage)other;
        return Intrinsics.areEqual(this.msg, bugMessage.msg);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020'092\u0006\u0010;\u001a\u00020<2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010=H&J,\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020'092\u0006\u0010;\u001a\u00020>2\u0006\u0010,\u001a\u00020=H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\u001a\u0010 \u001a\u0004\u0018\u00010!X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u0004\u0018\u00010'X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010,\u001a\u00020-X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000103X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u00a8\u0006?"}, d2={"Lcom/feysh/corax/config/api/BugMessage$Env;", "", "container", "Lsoot/SootMethod;", "getContainer", "()Lsoot/SootMethod;", "setContainer", "(Lsoot/SootMethod;)V", "callSite", "Lsoot/Unit;", "getCallSite", "()Lsoot/Unit;", "setCallSite", "(Lsoot/Unit;)V", "invokeExpr", "Lsoot/jimple/InvokeExpr;", "getInvokeExpr", "()Lsoot/jimple/InvokeExpr;", "setInvokeExpr", "(Lsoot/jimple/InvokeExpr;)V", "callee", "getCallee", "setCallee", "clazz", "Lsoot/SootClass;", "getClazz", "()Lsoot/SootClass;", "setClazz", "(Lsoot/SootClass;)V", "method", "getMethod", "setMethod", "field", "Lsoot/SootField;", "getField", "()Lsoot/SootField;", "setField", "(Lsoot/SootField;)V", "fileName", "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "region", "Lcom/feysh/corax/config/api/report/Region$Mutable;", "getRegion", "()Lcom/feysh/corax/config/api/report/Region$Mutable;", "setRegion", "(Lcom/feysh/corax/config/api/report/Region$Mutable;)V", "args", "", "getArgs", "()Ljava/util/Map;", "appendPathEvent", "", "message", "", "Lcom/feysh/corax/config/api/Language;", "loc", "Lsoot/tagkit/Host;", "Lcom/feysh/corax/config/api/report/Region;", "Ljava/nio/file/Path;", "corax-config-api"})
    public static interface Env {
        @Nullable
        public SootMethod getContainer();

        public void setContainer(@Nullable SootMethod var1);

        @Nullable
        public Unit getCallSite();

        public void setCallSite(@Nullable Unit var1);

        @Nullable
        public InvokeExpr getInvokeExpr();

        public void setInvokeExpr(@Nullable InvokeExpr var1);

        @Nullable
        public SootMethod getCallee();

        public void setCallee(@Nullable SootMethod var1);

        @Nullable
        public SootClass getClazz();

        public void setClazz(@Nullable SootClass var1);

        @Nullable
        public SootMethod getMethod();

        public void setMethod(@Nullable SootMethod var1);

        @Nullable
        public SootField getField();

        public void setField(@Nullable SootField var1);

        @Nullable
        public String getFileName();

        public void setFileName(@Nullable String var1);

        @NotNull
        public Region.Mutable getRegion();

        public void setRegion(@NotNull Region.Mutable var1);

        @NotNull
        public Map<Object, Object> getArgs();

        public void appendPathEvent(@NotNull Map<Language, String> var1, @NotNull Host var2, @Nullable Region var3);

        public void appendPathEvent(@NotNull Map<Language, String> var1, @NotNull Path var2, @NotNull Region var3);

        @Metadata(mv={2, 0, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            public static /* synthetic */ void appendPathEvent$default(Env env, Map map, Host host, Region region, int n, Object object) {
                if (object != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendPathEvent");
                }
                if ((n & 4) != 0) {
                    region = null;
                }
                env.appendPathEvent((Map<Language, String>)map, host, region);
            }
        }
    }
}

