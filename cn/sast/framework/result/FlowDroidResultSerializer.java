/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResource
 *  cn.sast.framework.result.FlowDroidResultSerializer
 *  cn.sast.framework.result.IFlowDroidResultCollector
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.jimple.infoflow.InfoflowConfiguration
 *  soot.jimple.infoflow.android.results.xml.InfoflowResultsSerializer
 *  soot.jimple.infoflow.data.AbstractionAtSink
 *  soot.jimple.infoflow.results.InfoflowResults
 *  soot.jimple.infoflow.solver.cfg.IInfoflowCFG
 */
package cn.sast.framework.result;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResource;
import cn.sast.framework.result.IFlowDroidResultCollector;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.android.results.xml.InfoflowResultsSerializer;
import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0019"}, d2={"Lcn/sast/framework/result/FlowDroidResultSerializer;", "Lcn/sast/framework/result/IFlowDroidResultCollector;", "outputDir", "Lcn/sast/common/IResDirectory;", "enableLineNumbers", "", "<init>", "(Lcn/sast/common/IResDirectory;Z)V", "getOutputDir", "()Lcn/sast/common/IResDirectory;", "getEnableLineNumbers", "()Z", "serializeResults", "", "results", "Lsoot/jimple/infoflow/results/InfoflowResults;", "cfg", "Lsoot/jimple/infoflow/solver/cfg/IInfoflowCFG;", "onResultsAvailable", "onResultAvailable", "icfg", "abs", "Lsoot/jimple/infoflow/data/AbstractionAtSink;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "corax-framework"})
public class FlowDroidResultSerializer
implements IFlowDroidResultCollector {
    @NotNull
    private final IResDirectory outputDir;
    private final boolean enableLineNumbers;

    public FlowDroidResultSerializer(@NotNull IResDirectory outputDir, boolean enableLineNumbers) {
        Intrinsics.checkNotNullParameter((Object)outputDir, (String)"outputDir");
        this.outputDir = outputDir;
        this.enableLineNumbers = enableLineNumbers;
    }

    public /* synthetic */ FlowDroidResultSerializer(IResDirectory iResDirectory, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = true;
        }
        this(iResDirectory, bl);
    }

    @NotNull
    public final IResDirectory getOutputDir() {
        return this.outputDir;
    }

    public final boolean getEnableLineNumbers() {
        return this.enableLineNumbers;
    }

    public final void serializeResults(@NotNull InfoflowResults results, @Nullable IInfoflowCFG cfg) {
        Intrinsics.checkNotNullParameter((Object)results, (String)"results");
        if (results.size() > 0) {
            IResource resultsFile = this.outputDir.resolve("infoflow-result.txt");
            InfoflowConfiguration config = new InfoflowConfiguration();
            config.setEnableLineNumbers(this.enableLineNumbers);
            InfoflowResultsSerializer serializer2 = new InfoflowResultsSerializer(cfg, config);
            try {
                serializer2.serialize(results, resultsFile.toString());
            }
            catch (IOException ex) {
                System.err.println("Could not write data flow results to file: " + ex.getMessage());
                ex.printStackTrace();
            }
            catch (XMLStreamException ex) {
                System.err.println("Could not write data flow results to file: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public void onResultsAvailable(@NotNull IInfoflowCFG cfg, @NotNull InfoflowResults results) {
        Intrinsics.checkNotNullParameter((Object)cfg, (String)"cfg");
        Intrinsics.checkNotNullParameter((Object)results, (String)"results");
        this.serializeResults(results, cfg);
    }

    public boolean onResultAvailable(@Nullable IInfoflowCFG icfg, @Nullable AbstractionAtSink abs) {
        return true;
    }

    @Nullable
    public Object flush(@NotNull Continuation<? super Unit> $completion) {
        return FlowDroidResultSerializer.flush$suspendImpl((FlowDroidResultSerializer)this, $completion);
    }

    static /* synthetic */ Object flush$suspendImpl(FlowDroidResultSerializer $this, Continuation<? super Unit> $completion) {
        return Unit.INSTANCE;
    }
}

