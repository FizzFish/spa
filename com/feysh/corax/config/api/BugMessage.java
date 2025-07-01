package com.feysh.corax.config.api;

import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import java.nio.file.Path;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.tagkit.Host;

public final class BugMessage {
    @NotNull
    private final Function1<Env, String> msg;

    public BugMessage(@NotNull Function1<? super Env, String> msg) {
        if (msg == null) {
            throw new IllegalArgumentException("msg cannot be null");
        }
        this.msg = msg;
    }

    @NotNull
    public Function1<Env, String> getMsg() {
        return msg;
    }

    @NotNull
    public Function1<Env, String> component1() {
        return msg;
    }

    @NotNull
    public BugMessage copy(@NotNull Function1<? super Env, String> msg) {
        if (msg == null) {
            throw new IllegalArgumentException("msg cannot be null");
        }
        return new BugMessage(msg);
    }

    @Override
    public String toString() {
        return "BugMessage(msg=" + msg + ")";
    }

    @Override
    public int hashCode() {
        return msg.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof BugMessage)) return false;
        BugMessage that = (BugMessage) other;
        return msg.equals(that.msg);
    }

    public interface Env {
        @Nullable SootMethod getContainer();
        void setContainer(@Nullable SootMethod container);

        @Nullable Unit getCallSite();
        void setCallSite(@Nullable Unit callSite);

        @Nullable InvokeExpr getInvokeExpr();
        void setInvokeExpr(@Nullable InvokeExpr invokeExpr);

        @Nullable SootMethod getCallee();
        void setCallee(@Nullable SootMethod callee);

        @Nullable SootClass getClazz();
        void setClazz(@Nullable SootClass clazz);

        @Nullable SootMethod getMethod();
        void setMethod(@Nullable SootMethod method);

        @Nullable SootField getField();
        void setField(@Nullable SootField field);

        @Nullable String getFileName();
        void setFileName(@Nullable String fileName);

        @NotNull Region.Mutable getRegion();
        void setRegion(@NotNull Region.Mutable region);

        @NotNull Map<Object, Object> getArgs();

        void appendPathEvent(@NotNull Map<Language, String> message, @NotNull Host loc, @Nullable Region region);
        void appendPathEvent(@NotNull Map<Language, String> message, @NotNull Path loc, @NotNull Region region);

        default void appendPathEvent(@NotNull Map<Language, String> message, @NotNull Host loc) {
            appendPathEvent(message, loc, null);
        }
    }
}