/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.BugPathEvent
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.DefaultEnv
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.api.report.Report
 *  cn.sast.api.report.Report$Companion
 *  cn.sast.dataflow.infoflow.provider.BugTypeProvider
 *  cn.sast.framework.engine.PreAnalysisReportEnv
 *  cn.sast.framework.result.ResultConverter
 *  cn.sast.framework.result.ResultConverter$Companion
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.config.api.BugMessage$Env
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.Language
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootMethod
 *  soot.Unit
 *  soot.jimple.InvokeExpr
 *  soot.jimple.Stmt
 *  soot.jimple.infoflow.data.AccessPath
 *  soot.jimple.infoflow.data.AccessPathFragment
 *  soot.jimple.infoflow.results.DataFlowResult
 *  soot.jimple.infoflow.results.ResultSinkInfo
 *  soot.jimple.infoflow.results.ResultSourceInfo
 *  soot.jimple.infoflow.solver.cfg.IInfoflowCFG
 *  soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinition
 *  soot.jimple.infoflow.sourcesSinks.definitions.MethodSourceSinkDefinition
 *  soot.tagkit.AbstractHost
 */
package cn.sast.framework.result;

import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.Report;
import cn.sast.dataflow.infoflow.provider.BugTypeProvider;
import cn.sast.framework.engine.PreAnalysisReportEnv;
import cn.sast.framework.result.ResultConverter;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.infoflow.data.AccessPath;
import soot.jimple.infoflow.data.AccessPathFragment;
import soot.jimple.infoflow.results.DataFlowResult;
import soot.jimple.infoflow.results.ResultSinkInfo;
import soot.jimple.infoflow.results.ResultSourceInfo;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinition;
import soot.jimple.infoflow.sourcesSinks.definitions.MethodSourceSinkDefinition;
import soot.tagkit.AbstractHost;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001d"}, d2={"Lcn/sast/framework/result/ResultConverter;", "", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "<init>", "(Lcom/feysh/corax/cache/analysis/SootInfoCache;)V", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "writeAccessPath", "", "accessPath", "Lsoot/jimple/infoflow/data/AccessPath;", "simple", "", "getReport", "Lcn/sast/api/report/Report;", "checkType", "Lcom/feysh/corax/config/api/CheckType;", "env", "Lcn/sast/framework/engine/PreAnalysisReportEnv;", "", "icfg", "Lsoot/jimple/infoflow/solver/cfg/IInfoflowCFG;", "result", "Lsoot/jimple/infoflow/results/DataFlowResult;", "bugTypeProvider", "Lcn/sast/dataflow/infoflow/provider/BugTypeProvider;", "serializeTaintPath", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nResultConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResultConverter.kt\ncn/sast/framework/result/ResultConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1557#2:111\n1628#2,2:112\n1630#2:115\n1557#2:116\n1628#2,3:117\n1#3:114\n*S KotlinDebug\n*F\n+ 1 ResultConverter.kt\ncn/sast/framework/result/ResultConverter\n*L\n78#1:111\n78#1:112,2\n78#1:115\n106#1:116\n106#1:117,3\n*E\n"})
public final class ResultConverter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final SootInfoCache info;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(ResultConverter::logger$lambda$9);

    public ResultConverter(@Nullable SootInfoCache info2) {
        this.info = info2;
    }

    @Nullable
    public final SootInfoCache getInfo() {
        return this.info;
    }

    private final String writeAccessPath(AccessPath accessPath, boolean simple) {
        if (!simple) {
            String string = accessPath.toString();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
            return string;
        }
        StringBuilder b = new StringBuilder();
        if (accessPath.getPlainValue() != null) {
            b.append(accessPath.getPlainValue().toString());
        }
        if (accessPath.getBaseType() != null) {
            b.append(accessPath.getBaseType().toString());
        }
        if (accessPath.getFragmentCount() > 0) {
            int n = accessPath.getFragmentCount();
            for (int i = 0; i < n; ++i) {
                AccessPathFragment fragment = accessPath.getFragments()[i];
                b.append(".").append(fragment.getField().toString());
            }
        }
        b.append(accessPath.getTaintSubFields() ? "*" : "");
        String string = b.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    static /* synthetic */ String writeAccessPath$default(ResultConverter resultConverter, AccessPath accessPath, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return resultConverter.writeAccessPath(accessPath, bl);
    }

    @NotNull
    public final Report getReport(@NotNull CheckType checkType, @NotNull PreAnalysisReportEnv env) {
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        return Report.Companion.of$default((Report.Companion)Report.Companion, (SootInfoCache)this.info, (IBugResInfo)env.getFile(), (Region)env.getEnv().getRegion().getImmutable(), (CheckType)checkType, (BugMessage.Env)env.getEnv(), null, (int)32, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<Report> getReport(@NotNull IInfoflowCFG icfg, @NotNull DataFlowResult result, @NotNull BugTypeProvider bugTypeProvider, boolean serializeTaintPath) {
        void $this$mapTo$iv$iv;
        Stmt it3;
        List list;
        SootMethod sm;
        Collection collection;
        Collection destination$iv$iv;
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        Intrinsics.checkNotNullParameter((Object)bugTypeProvider, (String)"bugTypeProvider");
        ResultSinkInfo sink = result.getSink();
        Stmt stmt = sink.getStmt();
        SootMethod method = (SootMethod)icfg.getMethodOf((Object)sink.getStmt());
        ISourceSinkDefinition definition = sink.getDefinition();
        if (!(definition instanceof MethodSourceSinkDefinition)) {
            logger.warn(() -> ResultConverter.getReport$lambda$0(definition));
            return CollectionsKt.emptyList();
        }
        SootMethod sinkMethod = Scene.v().grabMethod(((MethodSourceSinkDefinition)definition).getMethod().getSignature());
        if (sinkMethod == null) {
            logger.warn(() -> ResultConverter.getReport$lambda$1(definition));
            return CollectionsKt.emptyList();
        }
        ResultSourceInfo source = result.getSource();
        if (serializeTaintPath && source.getPath() != null) {
            void $this$mapTo$iv$iv2;
            Stmt[] stmtArray = source.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)stmtArray, (String)"getPath(...)");
            Iterable $this$map$iv = (Iterable)ArraysKt.getIndices((Object[])stmtArray);
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            Iterator iterator2 = $this$mapTo$iv$iv2.iterator();
            while (iterator2.hasNext()) {
                AccessPath curAP;
                Stmt curStmt;
                void i;
                int item$iv$iv;
                int n = item$iv$iv = ((IntIterator)iterator2).nextInt();
                collection = destination$iv$iv;
                boolean bl = false;
                Intrinsics.checkNotNullExpressionValue((Object)source.getPath()[i], (String)"get(...)");
                sm = (SootMethod)icfg.getMethodOf((Object)curStmt);
                Intrinsics.checkNotNullExpressionValue((Object)source.getPathAccessPaths()[i], (String)"get(...)");
                String ap = ResultConverter.writeAccessPath$default((ResultConverter)this, (AccessPath)curAP, (boolean)false, (int)2, null);
                Region region = Region.Companion.invoke((Unit)curStmt);
                if (region == null) {
                    Region region2;
                    if (this.info != null) {
                        SootInfoCache it2;
                        boolean bl2 = false;
                        Intrinsics.checkNotNull((Object)sm);
                        region2 = Region.Companion.invoke(it2, (AbstractHost)sm);
                    } else {
                        region2 = region = null;
                    }
                    if (region2 == null) {
                        region = Region.Companion.getERROR();
                    }
                }
                Region region3 = region;
                Map map = MapsKt.mapOf((Pair)TuplesKt.to((Object)Language.EN, (Object)("`" + ap + "` is tainted after `" + curStmt + "`")));
                Intrinsics.checkNotNull((Object)sm);
                collection.add(new BugPathEvent(map, (IBugResInfo)ClassResInfo.Companion.of(sm), region3, null, 8, null));
            }
            list = (List)destination$iv$iv;
        } else {
            list = CollectionsKt.emptyList();
        }
        List events = list;
        Set checkTypes = bugTypeProvider.lookUpCheckType(sinkMethod);
        if (checkTypes.isEmpty()) {
            logger.warn(() -> ResultConverter.getReport$lambda$4(sinkMethod));
        }
        Intrinsics.checkNotNull((Object)stmt);
        Region region = Region.Companion.invoke((Unit)stmt);
        if (region == null) {
            Region region4;
            SootInfoCache sootInfoCache = this.info;
            if (sootInfoCache != null) {
                SootInfoCache it3 = sootInfoCache;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)method);
                region4 = Region.Companion.invoke(it3, (AbstractHost)method);
            } else {
                region4 = region = null;
            }
            if (region4 == null) {
                region = Region.Companion.getERROR();
            }
        }
        Region region5 = region;
        Collection it4 = destination$iv$iv = new DefaultEnv(region5.getMutable(), null, null, null, null, null, null, null, null, 510, null);
        boolean $i$a$-also-ResultConverter$getReport$env$22 = false;
        it4.setCallSite((Unit)stmt);
        it4.setClazz(method.getDeclaringClass());
        it4.setContainer(method);
        it4.setCallee(sinkMethod);
        it4.setMethod(sinkMethod);
        Stmt bl = it3 = stmt;
        Collection collection2 = it4;
        boolean bl3 = false;
        Object object = Boolean.valueOf(stmt.containsInvokeExpr()) != false ? it3 : null;
        collection2.setInvokeExpr((InvokeExpr)(object != null ? object.getInvokeExpr() : null));
        Collection env = destination$iv$iv;
        Iterable $this$map$iv = checkTypes;
        boolean $i$f$map = false;
        Iterable $i$a$-also-ResultConverter$getReport$env$22 = $this$map$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void type;
            sm = (CheckType)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl4 = false;
            Intrinsics.checkNotNull((Object)method);
            collection.add(Report.Companion.of(this.info, (IBugResInfo)ClassResInfo.Companion.of(method), region5, (CheckType)type, (BugMessage.Env)env, events));
        }
        return (List)destination$iv$iv2;
    }

    public static /* synthetic */ List getReport$default(ResultConverter resultConverter, IInfoflowCFG iInfoflowCFG, DataFlowResult dataFlowResult, BugTypeProvider bugTypeProvider, boolean bl, int n, Object object) {
        if ((n & 8) != 0) {
            bl = true;
        }
        return resultConverter.getReport(iInfoflowCFG, dataFlowResult, bugTypeProvider, bl);
    }

    private static final Object getReport$lambda$0(ISourceSinkDefinition $definition) {
        return "Definition: " + $definition + " is not a MethodSourceSinkDefinition.";
    }

    private static final Object getReport$lambda$1(ISourceSinkDefinition $definition) {
        return "Soot can not find method: " + $definition;
    }

    private static final Object getReport$lambda$4(SootMethod $sinkMethod) {
        return "could not find any checkTypes from bugTypeProvider at sink method: " + $sinkMethod;
    }

    private static final kotlin.Unit logger$lambda$9() {
        return kotlin.Unit.INSTANCE;
    }
}

