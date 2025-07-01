package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Unit;

public final class CallStackContext {
    @Nullable
    private final CallStackContext caller;
    @NotNull
    private final Unit callSite;
    @NotNull
    private final SootMethod method;
    private final int deep;

    public CallStackContext(@Nullable CallStackContext caller, @NotNull Unit callSite, 
                           @NotNull SootMethod method, int deep) {
        if (callSite == null) throw new IllegalArgumentException("callSite cannot be null");
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        this.caller = caller;
        this.callSite = callSite;
        this.method = method;
        this.deep = deep;
    }

    @Nullable
    public CallStackContext getCaller() {
        return caller;
    }

    @NotNull
    public Unit getCallSite() {
        return callSite;
    }

    @NotNull
    public SootMethod getMethod() {
        return method;
    }

    public int getDeep() {
        return deep;
    }

    @Override
    @NotNull
    public String toString() {
        return "at " + (caller != null ? caller.method : null) + 
               " line: " + callSite.getJavaSourceStartLineNumber() + 
               ": " + callSite + " invoke -> " + method + "\n";
    }
}