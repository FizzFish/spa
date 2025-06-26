/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.entries.IEntryPointProvider$AnalyzeTask
 *  cn.sast.framework.entries.IEntryPointProvider$DefaultImpls
 *  cn.sast.framework.entries.custom.CustomEntryProvider
 *  cn.sast.framework.entries.custom.CustomEntryProvider$Companion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 */
package cn.sast.framework.entries.custom;

import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.custom.CustomEntryProvider;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2={"Lcn/sast/framework/entries/custom/CustomEntryProvider;", "Lcn/sast/framework/entries/IEntryPointProvider;", "entries", "", "Lsoot/SootMethod;", "<init>", "(Ljava/util/Set;)V", "method", "getMethod", "()Ljava/util/Set;", "iterator", "Lkotlinx/coroutines/flow/Flow;", "Lcn/sast/framework/entries/IEntryPointProvider$AnalyzeTask;", "getIterator", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "corax-framework"})
public class CustomEntryProvider
implements IEntryPointProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Set<SootMethod> entries;
    @NotNull
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CustomEntryProvider::logger$lambda$1);

    public CustomEntryProvider(@NotNull Set<? extends SootMethod> entries) {
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        this.entries = entries;
        this.iterator = FlowKt.flow((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    @NotNull
    public final Set<SootMethod> getMethod() {
        if (this.entries.isEmpty()) {
            logger.warn("No entry points");
        }
        logger.info(() -> CustomEntryProvider._get_method_$lambda$0(this));
        return this.entries;
    }

    @NotNull
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return this.iterator;
    }

    public void startAnalyse() {
        IEntryPointProvider.DefaultImpls.startAnalyse((IEntryPointProvider)this);
    }

    public void endAnalyse() {
        IEntryPointProvider.DefaultImpls.endAnalyse((IEntryPointProvider)this);
    }

    private static final Object _get_method_$lambda$0(CustomEntryProvider this$0) {
        String string = "custom entry methods num :%d";
        Object[] objectArray = new Object[]{this$0.entries.size()};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
        return string2;
    }

    private static final Unit logger$lambda$1() {
        return Unit.INSTANCE;
    }
}

