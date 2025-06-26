/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResFile
 *  cn.sast.common.ResourceKt
 *  cn.sast.framework.report.AbstractFileIndexer
 *  cn.sast.framework.report.FileIndexer
 *  cn.sast.framework.report.FileIndexerBuilder
 *  cn.sast.framework.report.coverage.SourceCoverage
 *  cn.sast.framework.report.coverage.SourceCoverage$Companion
 *  cn.sast.framework.report.coverage.SourceCoverage$JavaSourceCoverage
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.StringsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jacoco.core.internal.analysis.CounterImpl
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report.coverage;

import cn.sast.common.IResFile;
import cn.sast.common.ResourceKt;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.FileIndexer;
import cn.sast.framework.report.FileIndexerBuilder;
import cn.sast.framework.report.coverage.SourceCoverage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jacoco.core.internal.analysis.CounterImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2={"Lcn/sast/framework/report/coverage/SourceCoverage;", "", "sourceCoverage", "", "", "Lcn/sast/framework/report/coverage/SourceCoverage$JavaSourceCoverage;", "<init>", "(Ljava/util/Map;)V", "getSourceCoverage", "()Ljava/util/Map;", "calculateCoveredRatio", "Lorg/jacoco/core/internal/analysis/CounterImpl;", "targetSources", "", "Lcn/sast/common/IResFile;", "Companion", "JavaSourceCoverage", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nCoverage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Coverage.kt\ncn/sast/framework/report/coverage/SourceCoverage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,490:1\n1863#2,2:491\n1279#2,2:493\n1293#2,4:495\n*S KotlinDebug\n*F\n+ 1 Coverage.kt\ncn/sast/framework/report/coverage/SourceCoverage\n*L\n59#1:491,2\n63#1:493,2\n63#1:495,4\n*E\n"})
public final class SourceCoverage {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Map<String, JavaSourceCoverage> sourceCoverage;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(SourceCoverage::logger$lambda$1);

    public SourceCoverage(@NotNull Map<String, JavaSourceCoverage> sourceCoverage) {
        Intrinsics.checkNotNullParameter(sourceCoverage, (String)"sourceCoverage");
        this.sourceCoverage = sourceCoverage;
    }

    @NotNull
    public final Map<String, JavaSourceCoverage> getSourceCoverage() {
        return this.sourceCoverage;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final CounterImpl calculateCoveredRatio(@NotNull Set<? extends IResFile> targetSources) {
        Intrinsics.checkNotNullParameter(targetSources, (String)"targetSources");
        int allLineCount = 0;
        int missedCount = 0;
        FileIndexerBuilder fileIndexerBuilder = new FileIndexerBuilder();
        Iterable $this$forEach$iv = targetSources;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IResFile p0 = (IResFile)element$iv;
            boolean $i$f$calculateCoveredRatio$stub_for_inlining = false;
            boolean bl = false;
            fileIndexerBuilder.addIndexMap(p0);
        }
        FileIndexer fileIndexer = fileIndexerBuilder.build();
        Object $this$associateWith$iv = MapsKt.toList((Map)this.sourceCoverage);
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
            void it;
            Pair pair = (Pair)element$iv$iv;
            Object t = element$iv$iv;
            Map map = result$iv;
            boolean bl = false;
            String[] stringArray = new String[]{"/", "\\"};
            IResFile iResFile = (IResFile)SequencesKt.firstOrNull((Sequence)fileIndexer.findFromFileIndexMap(StringsKt.split$default((CharSequence)((CharSequence)it.getFirst()), (String[])stringArray, (boolean)false, (int)0, (int)6, null), AbstractFileIndexer.Companion.getDefaultClassCompareMode()));
            map.put(t, iResFile);
        }
        Map sourceMap = result$iv;
        $this$associateWith$iv = sourceMap.entrySet().iterator();
        while ($this$associateWith$iv.hasNext()) {
            Pair coveragePair = (Pair)((Map.Entry)$this$associateWith$iv.next()).getKey();
            JavaSourceCoverage coverage = (JavaSourceCoverage)coveragePair.component2();
            allLineCount += coverage.getLineCount();
            int missed = coverage.getSourceCoverage().getLineCounter().getMissedCount();
            missedCount += missed <= coverage.getLineCount() ? missed : coverage.getLineCount();
        }
        Set missSource = SetsKt.minus(targetSources, (Iterable)CollectionsKt.toSet((Iterable)CollectionsKt.filterNotNull((Iterable)sourceMap.values())));
        for (IResFile source : missSource) {
            int n;
            try {
                n = SequencesKt.count((Sequence)StringsKt.lineSequence((CharSequence)ResourceKt.readText$default((IResFile)source, null, (int)1, null)));
            }
            catch (Exception e) {
                logger.error("File " + source + " cannot be read!", (Throwable)e);
                n = 0;
            }
            int lineCount = n;
            allLineCount += lineCount;
            missedCount += lineCount;
        }
        CounterImpl counterImpl = CounterImpl.getInstance((int)missedCount, (int)(allLineCount - missedCount));
        Intrinsics.checkNotNullExpressionValue((Object)counterImpl, (String)"getInstance(...)");
        return counterImpl;
    }

    private static final Unit logger$lambda$1() {
        return Unit.INSTANCE;
    }
}

