package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import com.feysh.corax.config.api.utils.UtilsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

public final class Debug implements SummaryHandlePackage<IValue> {
    public static final class Companion {
        private Companion() {}
    }

    public static final Companion Companion = new Companion();

    @Override
    public void register(@NotNull ACheckCallAnalysis analysis) {
        if (analysis == null) {
            throw new IllegalArgumentException("Analysis cannot be null");
        }

        KLogger logger = KotlinLogging.INSTANCE.logger("Debug");
        
        analysis.evalCallAtCaller(
            UtilsKt.getSootSignature("debugBreak"), 
            evalCall -> {
                logger.debug("debug break");
                return null;
            }
        );
        
        analysis.evalCallAtCaller(
            UtilsKt.getSootSignature("debugPrint"), 
            evalCall -> {
                IHeapValues res = evalCall.arg(0);
                logger.debug(() -> "debug print(" + res + ")");
                return null;
            }
        );
    }
}