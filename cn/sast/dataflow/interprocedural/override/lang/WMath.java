package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import org.jetbrains.annotations.NotNull;

public final class WMath implements SummaryHandlePackage<IValue> {
    public static final WMath INSTANCE = new WMath();

    @Override
    public void register(@NotNull ACheckCallAnalysis analysis) {
        if (analysis == null) {
            throw new IllegalArgumentException("Analysis cannot be null");
        }
    }

    private WMath() {}
}