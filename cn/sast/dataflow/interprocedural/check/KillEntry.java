package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

public final class KillEntry {
    @NotNull
    private final SootMethod method;
    @NotNull
    private final HeapValuesEnv env;
    @NotNull
    private final Set<EntryPath> entries;
    @NotNull
    private final IReNew<IValue> factory;

    public KillEntry(@NotNull SootMethod method, @NotNull HeapValuesEnv env) {
        if (method == null) {
            throw new IllegalArgumentException("method cannot be null");
        }
        if (env == null) {
            throw new IllegalArgumentException("env cannot be null");
        }
        this.method = method;
        this.env = env;
        this.entries = new LinkedHashSet<>();
        this.factory = new EntryReplace(this);
    }

    @NotNull
    public SootMethod getMethod() {
        return method;
    }

    @NotNull
    public HeapValuesEnv getEnv() {
        return env;
    }

    @NotNull
    public Set<EntryPath> getEntries() {
        return entries;
    }

    @NotNull
    public IReNew<IValue> getFactory() {
        return factory;
    }

    public static final class EntryReplace implements IReNew<IValue> {
        private final KillEntry killEntry;

        public EntryReplace(KillEntry killEntry) {
            this.killEntry = killEntry;
        }

        @Override
        public IValue reNew(IValue value) {
            // Implementation would go here
            return null;
        }
    }
}