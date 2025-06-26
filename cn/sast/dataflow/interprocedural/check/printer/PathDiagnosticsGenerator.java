/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.BugPathEvent
 *  cn.sast.api.report.ClassResInfo
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.dataflow.interprocedural.check.ExitInvoke
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.InvokeEdgePath
 *  cn.sast.dataflow.interprocedural.check.ModelBind
 *  cn.sast.dataflow.interprocedural.check.printer.EventPrinter
 *  cn.sast.dataflow.interprocedural.check.printer.PathDiagnosticsGenerator
 *  cn.sast.dataflow.interprocedural.check.printer.PathDiagnosticsGenerator$inlineAssignment$g$1
 *  cn.sast.idfa.analysis.InterproceduralCFG
 *  com.feysh.corax.cache.analysis.SootInfoCache
 *  com.feysh.corax.config.api.Language
 *  com.feysh.corax.config.api.report.Region
 *  kotlin.Metadata
 *  kotlin.collections.ArrayDeque
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlin.text.StringsKt
 *  kotlinx.collections.immutable.PersistentList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SootMethodRef
 *  soot.Unit
 *  soot.jimple.InvokeExpr
 *  soot.jimple.Stmt
 *  soot.tagkit.AbstractHost
 *  soot.tagkit.Host
 */
package cn.sast.dataflow.interprocedural.check.printer;

import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.IBugResInfo;
import cn.sast.dataflow.interprocedural.check.ExitInvoke;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.InvokeEdgePath;
import cn.sast.dataflow.interprocedural.check.ModelBind;
import cn.sast.dataflow.interprocedural.check.printer.EventPrinter;
import cn.sast.dataflow.interprocedural.check.printer.PathDiagnosticsGenerator;
import cn.sast.idfa.analysis.InterproceduralCFG;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000\u00a2\u0006\u0002\b\u001cJ4\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u0018\u001a\u00020\u001d2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010!J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\"\u001a\u00020#2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000\u00a2\u0006\u0002\b\u001cJ4\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\"\u001a\u00020#2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010!J@\u0010$\u001a\u00020\u001d2\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190&0\u00172\u0006\u0010'\u001a\u00020\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)2\u000e\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190+J8\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190&0\u00172\u0006\u0010'\u001a\u00020\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)H\u0002J\u0014\u0010-\u001a\u00020.2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017J\u001a\u0010,\u001a\u00020.2\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190&0\u0017J\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000100R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2={"Lcn/sast/dataflow/interprocedural/check/printer/PathDiagnosticsGenerator;", "", "info", "Lcom/feysh/corax/cache/analysis/SootInfoCache;", "icfg", "Lcn/sast/idfa/analysis/InterproceduralCFG;", "deep", "", "<init>", "(Lcom/feysh/corax/cache/analysis/SootInfoCache;Lcn/sast/idfa/analysis/InterproceduralCFG;I)V", "getInfo", "()Lcom/feysh/corax/cache/analysis/SootInfoCache;", "getIcfg", "()Lcn/sast/idfa/analysis/InterproceduralCFG;", "getDeep", "()I", "result", "Lkotlin/collections/ArrayDeque;", "Lcn/sast/api/report/BugPathEvent;", "prefix", "", "calleePrefix", "emit", "", "node", "Lcn/sast/dataflow/interprocedural/check/IPath;", "message", "Lcn/sast/dataflow/interprocedural/check/printer/EventPrinter;", "emit$corax_data_flow", "Lsoot/Unit;", "", "Lcom/feysh/corax/config/api/Language;", "region", "Lcom/feysh/corax/config/api/report/Region;", "method", "Lsoot/SootMethod;", "inlineAssignment", "pathEvents", "Lkotlin/collections/IndexedValue;", "index", "inlined", "", "type", "Lkotlin/reflect/KClass;", "inlinePathEvents", "inlineBugPathEvents", "", "inlineEvents", "Lkotlinx/collections/immutable/PersistentList;", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPathDiagnosticsGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathDiagnosticsGenerator.kt\ncn/sast/dataflow/interprocedural/check/printer/PathDiagnosticsGenerator\n+ 2 SootUtils.kt\ncn/sast/api/util/SootUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Region.kt\ncom/feysh/corax/config/api/report/Region\n*L\n1#1,211:1\n303#2:212\n1#3:213\n1#3:214\n1#3:216\n59#4:215\n57#4:217\n*S KotlinDebug\n*F\n+ 1 PathDiagnosticsGenerator.kt\ncn/sast/dataflow/interprocedural/check/printer/PathDiagnosticsGenerator\n*L\n40#1:212\n40#1:213\n85#1:216\n85#1:215\n85#1:217\n*E\n"})
public final class PathDiagnosticsGenerator {
    @Nullable
    private final SootInfoCache info;
    @NotNull
    private final InterproceduralCFG icfg;
    private final int deep;
    @NotNull
    private final ArrayDeque<BugPathEvent> result;
    @NotNull
    private final String prefix;
    @NotNull
    private final String calleePrefix;

    public PathDiagnosticsGenerator(@Nullable SootInfoCache info2, @NotNull InterproceduralCFG icfg, int deep) {
        Intrinsics.checkNotNullParameter((Object)icfg, (String)"icfg");
        this.info = info2;
        this.icfg = icfg;
        this.deep = deep;
        this.result = new ArrayDeque();
        this.prefix = "[" + this.deep + "]";
        this.calleePrefix = "[" + (this.deep + 1) + "]";
    }

    @Nullable
    public final SootInfoCache getInfo() {
        return this.info;
    }

    @NotNull
    public final InterproceduralCFG getIcfg() {
        return this.icfg;
    }

    public final int getDeep() {
        return this.deep;
    }

    @NotNull
    public final List<BugPathEvent> emit$corax_data_flow(@NotNull IPath node, @NotNull EventPrinter message) {
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        return this.emit(node.getNode(), message.getMessage(), message.getRegion());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<BugPathEvent> emit(@NotNull Unit node, @Nullable Map<Language, String> message, @Nullable Region region) {
        SootMethodRef methodRef;
        InvokeExpr invokeExpr;
        Stmt it$iv;
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        if (message == null) {
            return CollectionsKt.emptyList();
        }
        SootClass clazz = this.icfg.getMethodOf(node).getDeclaringClass();
        Unit $this$invokeExprOrNull$iv = node;
        boolean $i$f$getInvokeExprOrNull = false;
        Stmt stmt = $this$invokeExprOrNull$iv instanceof Stmt ? (Stmt)$this$invokeExprOrNull$iv : null;
        if (stmt != null) {
            it$iv = stmt;
            boolean bl = false;
            invokeExpr = ((Stmt)$this$invokeExprOrNull$iv).containsInvokeExpr() ? ((Stmt)$this$invokeExprOrNull$iv).getInvokeExpr() : null;
        } else {
            invokeExpr = null;
        }
        Object object = methodRef = invokeExpr != null ? invokeExpr.getMethodRef() : null;
        if (methodRef != null && (!(methodRef instanceof SootMethod) || ((SootMethod)methodRef).isDeclared()) && Intrinsics.areEqual((Object)methodRef.getDeclaringClass().getName(), (Object)"java.lang.String")) {
            String string = methodRef.getName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
            if (StringsKt.contains((CharSequence)string, (CharSequence)"equals", (boolean)true)) {
                return CollectionsKt.emptyList();
            }
        }
        if (clazz.isJavaLibraryClass()) {
            return CollectionsKt.emptyList();
        }
        Map<Language, String> map = message;
        Intrinsics.checkNotNull((Object)clazz);
        IBugResInfo iBugResInfo = (IBugResInfo)ClassResInfo.Companion.of(clazz);
        Region region2 = region;
        if (region2 == null) {
            Region region3;
            SootInfoCache sootInfoCache = this.info;
            if (sootInfoCache != null) {
                void it;
                it$iv = sootInfoCache;
                IBugResInfo iBugResInfo2 = iBugResInfo;
                Map<Language, String> map2 = map;
                boolean bl = false;
                Region region4 = Region.Companion.invoke((SootInfoCache)it, (Host)node);
                map = map2;
                iBugResInfo = iBugResInfo2;
                region3 = region4;
            } else {
                region3 = region2 = null;
            }
            if (region3 == null && (region2 = Region.Companion.invoke(node)) == null) {
                region2 = Region.Companion.getERROR();
            }
        }
        Integer n = this.deep;
        Region region5 = region2;
        IBugResInfo iBugResInfo3 = iBugResInfo;
        Map<Language, String> map3 = map;
        return CollectionsKt.listOf((Object)new BugPathEvent(map3, iBugResInfo3, region5, n));
    }

    @NotNull
    public final List<BugPathEvent> emit$corax_data_flow(@NotNull SootMethod method, @Nullable EventPrinter message) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        if (message == null) {
            return CollectionsKt.emptyList();
        }
        return this.emit(method, message.getMessage(), message.getRegion());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<BugPathEvent> emit(@NotNull SootMethod method, @Nullable Map<Language, String> message, @Nullable Region region) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        if (message == null) {
            return CollectionsKt.emptyList();
        }
        SootClass clazz = method.getDeclaringClass();
        if (method.isDeclared() && Intrinsics.areEqual((Object)method.getDeclaringClass().getName(), (Object)"java.lang.String")) {
            String string = method.getName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
            if (StringsKt.contains((CharSequence)string, (CharSequence)"equals", (boolean)true)) {
                return CollectionsKt.emptyList();
            }
        }
        if (clazz.isJavaLibraryClass()) {
            return CollectionsKt.emptyList();
        }
        Map<Language, String> map = message;
        Intrinsics.checkNotNull((Object)clazz);
        IBugResInfo iBugResInfo = (IBugResInfo)ClassResInfo.Companion.of(clazz);
        Region region2 = region;
        if (region2 == null) {
            Region region3;
            SootInfoCache sootInfoCache = this.info;
            if (sootInfoCache != null) {
                void it;
                SootInfoCache sootInfoCache2 = sootInfoCache;
                IBugResInfo iBugResInfo2 = iBugResInfo;
                Map<Language, String> map2 = map;
                boolean bl = false;
                Region region4 = Region.Companion.invoke((SootInfoCache)it, (AbstractHost)method);
                map = map2;
                iBugResInfo = iBugResInfo2;
                region3 = region4;
            } else {
                region3 = region2 = null;
            }
            if (region3 == null) {
                Region region5;
                Region this_$iv = new Region(method.getJavaSourceStartLineNumber(), method.getJavaSourceStartColumnNumber(), -1, -1);
                boolean $i$f$getTakeIfValid = false;
                Region it$iv = region5 = this_$iv;
                boolean bl = false;
                Region this_$iv$iv = this_$iv;
                boolean $i$f$getValid = false;
                Object object = this_$iv$iv.startLine >= 0 ? region5 : null;
                region2 = object;
                if (object == null) {
                    region2 = Region.Companion.getERROR();
                }
            }
        }
        Integer n = this.deep;
        Region region6 = region2;
        IBugResInfo iBugResInfo3 = iBugResInfo;
        Map<Language, String> map3 = map;
        return CollectionsKt.listOf((Object)new BugPathEvent(map3, iBugResInfo3, region6, n));
    }

    @NotNull
    public final Unit inlineAssignment(@NotNull List<? extends IndexedValue<? extends IPath>> pathEvents, int index, @NotNull Set<Integer> inlined2, @NotNull KClass<? extends IPath> type) {
        Intrinsics.checkNotNullParameter(pathEvents, (String)"pathEvents");
        Intrinsics.checkNotNullParameter(inlined2, (String)"inlined");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        IPath pathEvent = (IPath)pathEvents.get(index).getValue();
        inlineAssignment.g.1 g2 = new /* Unavailable Anonymous Inner Class!! */;
        return g2.inline(pathEvent.getNode());
    }

    private final List<BugPathEvent> inlinePathEvents(List<? extends IndexedValue<? extends IPath>> pathEvents, int index, Set<Integer> inlined2) {
        List list;
        IndexedValue<? extends IPath> pathEventI = pathEvents.get(index);
        IPath pathEvent = (IPath)pathEventI.getValue();
        Unit lineUnit = this.inlineAssignment(pathEvents, index, inlined2, Reflection.getOrCreateKotlinClass(pathEvent.getClass()));
        SootMethod sootMethod = this.icfg.getMethodOf(pathEvent.getNode());
        if (pathEvent instanceof ModelBind) {
            list = this.emit$corax_data_flow(pathEvent, new EventPrinter(this.prefix).printModeling((ModelBind)pathEvent, lineUnit, sootMethod));
        } else {
            List n = this.emit$corax_data_flow(pathEvent, new EventPrinter(this.prefix).normalPrint(pathEventI, lineUnit, sootMethod));
            list = pathEvent instanceof InvokeEdgePath ? CollectionsKt.plus((Collection)n, (Iterable)this.emit$corax_data_flow(((InvokeEdgePath)pathEvent).getCallee(), new EventPrinter(this.calleePrefix).calleeBeginPrint((InvokeEdgePath)pathEvent))) : n;
        }
        return list;
    }

    public final void inlineBugPathEvents(@NotNull List<BugPathEvent> pathEvents) {
        Intrinsics.checkNotNullParameter(pathEvents, (String)"pathEvents");
        CollectionsKt.addAll((Collection)((Collection)this.result), (Iterable)pathEvents);
    }

    public final void inlinePathEvents(@NotNull List<? extends IndexedValue<? extends IPath>> pathEvents) {
        Intrinsics.checkNotNullParameter(pathEvents, (String)"pathEvents");
        Set inlined2 = new LinkedHashSet();
        int insertIndex = this.result.size();
        int index = pathEvents.size();
        while (--index >= 0) {
            if (inlined2.contains(index)) continue;
            this.result.addAll(insertIndex, (Collection)this.inlinePathEvents(pathEvents, index, inlined2));
        }
    }

    @NotNull
    public final List<BugPathEvent> inlineEvents(@NotNull PersistentList<? extends Object> pathEvents) {
        Intrinsics.checkNotNullParameter(pathEvents, (String)"pathEvents");
        List curEvents = new ArrayList();
        List curPathEvents = new ArrayList();
        int i = 0;
        for (Object event : pathEvents) {
            if (event instanceof BugPathEvent) {
                if (!((Collection)curPathEvents).isEmpty()) {
                    this.inlinePathEvents(curPathEvents);
                    curPathEvents.clear();
                }
                curEvents.add(event);
            } else if (event instanceof IPath) {
                if (!((Collection)curEvents).isEmpty()) {
                    this.inlineBugPathEvents(curEvents);
                    curEvents.clear();
                }
                curPathEvents.add(new IndexedValue(i, event));
            } else if (event instanceof ExitInvoke) {
                if (!((Collection)curPathEvents).isEmpty()) {
                    this.inlinePathEvents(curPathEvents);
                    curPathEvents.clear();
                }
                if (!((Collection)curEvents).isEmpty()) {
                    this.inlineBugPathEvents(curEvents);
                    curEvents.clear();
                }
                EventPrinter printer = new EventPrinter(this.prefix);
                CollectionsKt.addAll((Collection)((Collection)this.result), (Iterable)this.emit$corax_data_flow((IPath)((ExitInvoke)event).getInvoke(), printer.normalPrint((ExitInvoke)event)));
            } else {
                throw new IllegalStateException("internal error".toString());
            }
            ++i;
        }
        if (!((Collection)curEvents).isEmpty()) {
            this.inlineBugPathEvents(curEvents);
        }
        if (!((Collection)curPathEvents).isEmpty()) {
            this.inlinePathEvents(curPathEvents);
        }
        return (List)this.result;
    }
}

