package cn.sast.framework.result;

import cn.sast.framework.result.IFlowDroidResultCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

public final class FlowDroidResultCollector implements IFlowDroidResultCollector {
    @NotNull
    private final InfoflowResults result = new InfoflowResults();

    @NotNull
    public InfoflowResults getResult() {
        return result;
    }

    @Override
    public void onResultsAvailable(@Nullable IInfoflowCFG cfg, @Nullable InfoflowResults results) {
        if (results != null) {
            result.addAll(results);
        }
    }

    @Override
    public boolean onResultAvailable(@NotNull IInfoflowCFG cfg, @Nullable AbstractionAtSink abs) {
        return true;
    }

    @Override
    @Nullable
    public Object flush() {
        return null;
    }
}