package cn.sast.dataflow.infoflow.manager;

import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.jimple.Stmt;
import soot.jimple.infoflow.InfoflowManager;
import soot.jimple.infoflow.data.AccessPath;
import soot.jimple.infoflow.sourcesSinks.manager.ISourceSinkManager;
import soot.jimple.infoflow.sourcesSinks.manager.SinkInfo;
import soot.jimple.infoflow.sourcesSinks.manager.SourceInfo;

public final class GrabSourceSinkManager implements ISourceSinkManager {
    @NotNull
    private final ISourceSinkManager delegate;

    public GrabSourceSinkManager(@NotNull ISourceSinkManager delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("delegate cannot be null");
        }
        this.delegate = delegate;
    }

    @NotNull
    public ISourceSinkManager getDelegate() {
        return this.delegate;
    }

    @Override
    public void initialize() {
        if (!Scene.v().hasCallGraph()) {
            throw new IllegalArgumentException("have no call graph");
        }
        this.delegate.initialize();
    }

    @Override
    public SourceInfo getSourceInfo(Stmt p0, InfoflowManager p1) {
        return this.delegate.getSourceInfo(p0, p1);
    }

    @Override
    public SinkInfo getSinkInfo(Stmt p0, InfoflowManager p1, AccessPath p2) {
        return this.delegate.getSinkInfo(p0, p1, p2);
    }
}