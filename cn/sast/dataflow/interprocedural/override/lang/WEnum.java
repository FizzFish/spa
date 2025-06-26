/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JSootFieldType
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.override.lang.WEnum
 *  cn.sast.dataflow.interprocedural.override.lang.WEnum$Companion
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Triple
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.UnitPatchingChain
 *  soot.Value
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.IntConstant
 *  soot.jimple.InvokeStmt
 *  soot.jimple.Jimple
 *  soot.jimple.NewExpr
 *  soot.jimple.StringConstant
 *  soot.util.Chain
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.check.callback.CallerSiteCBImpl;
import cn.sast.dataflow.interprocedural.override.lang.WEnum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.jimple.AnyNewExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.StringConstant;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0016\u001a\u00020\u0017*\u00100\u0018j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u0019H\u0016RU\u0010\u0006\u001a<\u0012\u0018\u0012\u0016\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\u0004\u0012\u00020\u000b0\b\u0012\u001e\u0012\u001c\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\f0\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/WEnum;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "invokeEnumInitExpr", "", "Lkotlin/Pair;", "Lsoot/SootClass;", "kotlin.jvm.PlatformType", "", "Lkotlin/Triple;", "", "getInvokeEnumInitExpr", "()Ljava/util/Map;", "invokeEnumInitExpr$delegate", "Lkotlin/Lazy;", "nameField", "Lsoot/SootField;", "getNameField", "()Lsoot/SootField;", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nWEnum.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WEnum.kt\ncn/sast/dataflow/interprocedural/override/lang/WEnum\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n*L\n1#1,87:1\n1368#2:88\n1454#2,5:89\n774#2:94\n865#2,2:95\n1454#2,2:97\n1611#2,9:99\n1863#2:108\n1864#2:110\n1620#2:111\n1456#2,3:112\n1202#2,2:115\n1230#2,4:117\n1#3:109\n44#4:121\n*S KotlinDebug\n*F\n+ 1 WEnum.kt\ncn/sast/dataflow/interprocedural/override/lang/WEnum\n*L\n25#1:88\n25#1:89,5\n25#1:94\n25#1:95,2\n25#1:97,2\n26#1:99,9\n26#1:108\n26#1:110\n26#1:111\n25#1:112,3\n39#1:115,2\n39#1:117,4\n26#1:109\n62#1:121\n*E\n"})
public final class WEnum
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Lazy invokeEnumInitExpr$delegate = LazyKt.lazy(WEnum::invokeEnumInitExpr_delegate$lambda$5);
    @Nullable
    private final SootField nameField = Scene.v().grabField("<java.lang.Enum: java.lang.String name>");
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(WEnum::logger$lambda$9);

    @NotNull
    public final Map<Pair<SootClass, String>, Triple<SootClass, String, Integer>> getInvokeEnumInitExpr() {
        Lazy lazy = this.invokeEnumInitExpr$delegate;
        return (Map)lazy.getValue();
    }

    @Nullable
    public final SootField getNameField() {
        return this.nameField;
    }

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        if (this.nameField == null) {
            logger.error(WEnum::register$lambda$6);
            return;
        }
        $this$register.evalCallAtCaller("<java.lang.Enum: java.lang.Enum valueOf(java.lang.Class,java.lang.String)>", arg_0 -> WEnum.register$lambda$8(this, arg_0));
        $this$register.registerClassAllWrapper("java.lang.Enum");
    }

    /*
     * WARNING - void declaration
     */
    private static final Map invokeEnumInitExpr_delegate$lambda$5() {
        void $this$associateByTo$iv$iv;
        Iterable $this$filterTo$iv$iv;
        Iterable list$iv$iv;
        SootClass it;
        Iterable $this$flatMapTo$iv$iv;
        Chain chain = Scene.v().getClasses();
        Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getClasses(...)");
        Iterable $this$flatMap$iv = (Iterable)chain;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Iterable destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            it = (SootClass)element$iv$iv;
            boolean bl = false;
            List list = it.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
            list$iv$iv = list;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        Iterable $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$filter = false;
        $this$flatMapTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (SootMethod)element$iv$iv;
            boolean bl = false;
            if (!it.hasActiveBody()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$flatMap$iv = (List)destination$iv$iv;
        $i$f$flatMap = false;
        $this$filterTo$iv$iv = $this$flatMap$iv;
        destination$iv$iv = new ArrayList();
        $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            void $this$mapNotNullTo$iv$iv;
            it = (SootMethod)element$iv$iv;
            boolean bl = false;
            UnitPatchingChain unitPatchingChain = it.getActiveBody().getUnits();
            Intrinsics.checkNotNullExpressionValue((Object)unitPatchingChain, (String)"getUnits(...)");
            Iterable $this$mapNotNull$iv = (Iterable)unitPatchingChain;
            boolean $i$f$mapNotNull = false;
            Iterable iterable2 = $this$mapNotNull$iv;
            Collection destination$iv$iv2 = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                Triple triple;
                Object element$iv$iv$iv;
                Object element$iv$iv2 = element$iv$iv$iv = iterator2.next();
                boolean bl2 = false;
                Unit u = (Unit)element$iv$iv2;
                boolean bl3 = false;
                if (u instanceof InvokeStmt && ((InvokeStmt)u).containsInvokeExpr() && ((InvokeStmt)u).getInvokeExpr().getMethod().getDeclaringClass().isEnum() && Intrinsics.areEqual((Object)((InvokeStmt)u).getInvokeExpr().getMethod().getSubSignature(), (Object)"void <init>(java.lang.String,int)")) {
                    List list = ((InvokeStmt)u).getInvokeExpr().getArgs();
                    Intrinsics.checkNotNull((Object)list);
                    Value enumNameValue = (Value)list.get(0);
                    Value idValue = (Value)list.get(1);
                    Object object = enumNameValue instanceof StringConstant ? (StringConstant)enumNameValue : null;
                    if (object == null || (object = object.value) == null) {
                        triple = null;
                    } else {
                        Object enumName = object;
                        IntConstant intConstant = idValue instanceof IntConstant ? (IntConstant)idValue : null;
                        if (intConstant == null) {
                            triple = null;
                        } else {
                            int id = intConstant.value;
                            triple = new Triple((Object)((InvokeStmt)u).getInvokeExpr().getMethod().getDeclaringClass(), enumName, (Object)id);
                        }
                    }
                } else {
                    triple = null;
                }
                if (triple == null) continue;
                Triple it$iv$iv = triple;
                boolean bl4 = false;
                destination$iv$iv2.add(it$iv$iv);
            }
            list$iv$iv = (List)destination$iv$iv2;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        Iterable $this$associateBy$iv = (List)destination$iv$iv;
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateBy$iv, (int)10)), (int)16);
        destination$iv$iv = $this$associateBy$iv;
        Map destination$iv$iv3 = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            void it2;
            Triple bl = (Triple)element$iv$iv;
            Map map = destination$iv$iv3;
            boolean bl5 = false;
            map.put(TuplesKt.to((Object)it2.getFirst(), (Object)it2.getSecond()), element$iv$iv);
        }
        return destination$iv$iv3;
    }

    private static final Object register$lambda$6() {
        return "<java.lang.Enum: java.lang.String name> not exist";
    }

    private static final boolean register$lambda$8$lambda$7(CallerSiteCBImpl.EvalCall $this_evalCallAtCaller, WEnum this$0, IHeapValues $nameP, IOpCalculator $this$valueOf, IHeapValues.Builder ret, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$valueOf, (String)"$this$valueOf");
        Intrinsics.checkNotNullParameter((Object)ret, (String)"ret");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV clazzC = companionVArray[0];
        Type type = FactValuesKt.getClassValue$default((IValue)((IValue)clazzC.getValue()), (boolean)false, (int)1, null);
        RefType refType = type instanceof RefType ? (RefType)type : null;
        if (refType == null) {
            return false;
        }
        RefType clazz = refType;
        NewExpr newExpr2 = Jimple.v().newNewExpr(clazz);
        AbstractHeapFactory abstractHeapFactory = $this_evalCallAtCaller.getHf();
        HeapValuesEnv heapValuesEnv = (HeapValuesEnv)$this_evalCallAtCaller.getEnv();
        AbstractHeapFactory abstractHeapFactory2 = $this_evalCallAtCaller.getHf();
        AnyNewExprEnv anyNewExprEnv = $this_evalCallAtCaller.getNewEnv();
        Intrinsics.checkNotNull((Object)newExpr2);
        IHeapValues enumNew = abstractHeapFactory.push(heapValuesEnv, abstractHeapFactory2.anyNewVal(anyNewExprEnv, (AnyNewExpr)newExpr2)).popHV();
        IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)$this_evalCallAtCaller.getOut(), (HeapValuesEnv)((HeapValuesEnv)$this_evalCallAtCaller.getEnv()), (Object)"@new", (IHeapValues)enumNew, (boolean)false, (int)8, null);
        FieldUtil fieldUtil = FieldUtil.INSTANCE;
        SootField field$iv = this$0.nameField;
        boolean $i$f$of = false;
        $this_evalCallAtCaller.getOut().setFieldNew((HeapValuesEnv)$this_evalCallAtCaller.getEnv(), (Object)"@new", (JFieldType)new JSootFieldType(field$iv), $nameP);
        $this_evalCallAtCaller.getOut().kill((Object)"@new");
        $this$valueOf.getRes().add(enumNew);
        return true;
    }

    private static final kotlin.Unit register$lambda$8(WEnum this$0, CallerSiteCBImpl.EvalCall $this$evalCallAtCaller) {
        Intrinsics.checkNotNullParameter((Object)$this$evalCallAtCaller, (String)"$this$evalCallAtCaller");
        IHeapValues classP = $this$evalCallAtCaller.arg(0);
        IHeapValues nameP = $this$evalCallAtCaller.arg(1);
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{classP};
        IOpCalculator valueOfOp = $this$evalCallAtCaller.getHf().resolveOp((HeapValuesEnv)$this$evalCallAtCaller.getEnv(), iHeapValuesArray);
        valueOfOp.resolve((arg_0, arg_1, arg_2) -> WEnum.register$lambda$8$lambda$7($this$evalCallAtCaller, this$0, nameP, arg_0, arg_1, arg_2));
        RefType refType = Scene.v().getRefType("java.lang.Enum");
        Intrinsics.checkNotNullExpressionValue((Object)refType, (String)"getRefType(...)");
        valueOfOp.putSummaryIfNotConcrete((Type)refType, (Object)"valueOf");
        $this$evalCallAtCaller.setReturn(valueOfOp.getRes().build());
        return kotlin.Unit.INSTANCE;
    }

    private static final kotlin.Unit logger$lambda$9() {
        return kotlin.Unit.INSTANCE;
    }
}

