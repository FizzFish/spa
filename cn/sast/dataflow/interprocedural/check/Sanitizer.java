package cn.sast.dataflow.interprocedural.check;

import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.data.Abstraction;
import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

public final class Sanitizer {
    @NotNull
    private final IInfoflowCFG cfg;
    @NotNull
    private final AbstractionAtSink absAndSink;

    public Sanitizer(@NotNull IInfoflowCFG cfg, @NotNull AbstractionAtSink absAndSink) {
        if (cfg == null) {
            throw new IllegalArgumentException("cfg cannot be null");
        }
        if (absAndSink == null) {
            throw new IllegalArgumentException("absAndSink cannot be null");
        }
        this.cfg = cfg;
        this.absAndSink = absAndSink;
    }

    @NotNull
    public IInfoflowCFG getCfg() {
        return cfg;
    }

    @NotNull
    public AbstractionAtSink getAbsAndSink() {
        return absAndSink;
    }

    public void doAnalysis() {
        Abstraction abstraction = absAndSink.getAbstraction();
        if (abstraction == null) {
            throw new IllegalStateException("Abstraction cannot be null");
        }
        DefaultAbstractionGraph ag = new DefaultAbstractionGraph(abstraction);
    }
}