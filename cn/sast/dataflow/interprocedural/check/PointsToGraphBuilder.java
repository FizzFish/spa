/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AIContext
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewValue
 *  cn.sast.dataflow.interprocedural.analysis.CallStackContext
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.FieldUtil
 *  cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IDiff
 *  cn.sast.dataflow.interprocedural.analysis.IFact
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IFieldManager
 *  cn.sast.dataflow.interprocedural.analysis.IHeapKVData$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.JSootFieldType
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstract
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphBuilderAbstract
 *  cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKV
 *  cn.sast.dataflow.interprocedural.check.ArraySpace
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.FieldSpace
 *  cn.sast.dataflow.interprocedural.check.JStrArrValue
 *  cn.sast.dataflow.interprocedural.check.PointsToGraph
 *  cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder
 *  cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder$PathTransfer
 *  cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder$activeCalleeReports$diff$1
 *  cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder$updateIntraEdge$transformPathx$1
 *  cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapKV
 *  cn.sast.dataflow.interprocedural.override.lang.WString
 *  cn.sast.idfa.analysis.Context
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentMap
 *  kotlinx.collections.immutable.PersistentMap$Builder
 *  kotlinx.collections.immutable.PersistentSet$Builder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 *  soot.ByteType
 *  soot.Context
 *  soot.G
 *  soot.IntType
 *  soot.RefType
 *  soot.SootField
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.Constant
 *  soot.jimple.IntConstant
 *  soot.jimple.NewArrayExpr
 *  soot.jimple.StringConstant
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AIContext;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.AnyNewValue;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IDiff;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IFieldManager;
import cn.sast.dataflow.interprocedural.analysis.IHeapKVData;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JOperatorV;
import cn.sast.dataflow.interprocedural.analysis.JSootFieldType;
import cn.sast.dataflow.interprocedural.analysis.PointsToGraphAbstract;
import cn.sast.dataflow.interprocedural.analysis.PointsToGraphBuilderAbstract;
import cn.sast.dataflow.interprocedural.analysis.heapimpl.ArrayHeapKV;
import cn.sast.dataflow.interprocedural.check.ArraySpace;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.FieldSpace;
import cn.sast.dataflow.interprocedural.check.JStrArrValue;
import cn.sast.dataflow.interprocedural.check.PointsToGraph;
import cn.sast.dataflow.interprocedural.check.PointsToGraphBuilder;
import cn.sast.dataflow.interprocedural.check.heapimpl.FieldHeapKV;
import cn.sast.dataflow.interprocedural.override.lang.WString;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.PersistentSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.ByteType;
import soot.Context;
import soot.G;
import soot.IntType;
import soot.RefType;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.jimple.AnyNewExpr;
import soot.jimple.Constant;
import soot.jimple.IntConstant;
import soot.jimple.NewArrayExpr;
import soot.jimple.StringConstant;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001GB\u0099\u0001\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000f0\r\u00120\u0010\u0010\u001a,\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u001e\u0012\u001c\u0012\b\u0012\u00060\u000ej\u0002`\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00130\u00110\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001cH\u0016JD\u0010\u001d\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030!2\n\u0010\"\u001a\u00060\u000ej\u0002`\u00122\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010$\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\u0010%\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000fJ\u001a\u0010&\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030'2\u0006\u0010(\u001a\u00020)H\u0016JH\u0010*\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030+2\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\u0010%\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000f2\u0006\u0010(\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u000fH\u0016J\u001c\u0010.\u001a\u0004\u0018\u00010/2\u0010\u00100\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030!H\u0016J\"\u00101\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u000eH\u0016J:\u00103\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\u00104\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030!2\n\u0010\"\u001a\u00060\u000ej\u0002`\u0012H\u0016JD\u00105\u001a\u0002062\"\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u000209\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001c082\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u0002092\u0006\u0010<\u001a\u000209H\u0016J:\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020A2\u0010\u0010B\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001c2\u0006\u0010C\u001a\u00020AH\u0002JF\u0010D\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020E2\u0006\u0010C\u001a\u00020E2\u0010\u0010B\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001c2\u0006\u0010F\u001a\u00020\u001aH\u0016\u00a8\u0006H"}, d2={"Lcn/sast/dataflow/interprocedural/check/PointsToGraphBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/PointsToGraphBuilderAbstract;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "orig", "Lcn/sast/dataflow/interprocedural/analysis/PointsToGraphAbstract;", "hf", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "vg", "Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "callStack", "Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;", "slots", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "heap", "Lkotlinx/collections/immutable/PersistentMap;", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "Lcn/sast/dataflow/interprocedural/analysis/IData;", "calledMethods", "Lkotlinx/collections/immutable/PersistentSet$Builder;", "Lsoot/SootMethod;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/PointsToGraphAbstract;Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;Lcn/sast/dataflow/interprocedural/analysis/CallStackContext;Lkotlinx/collections/immutable/PersistentMap$Builder;Lkotlinx/collections/immutable/PersistentMap$Builder;Lkotlinx/collections/immutable/PersistentSet$Builder;)V", "mayChange", "", "build", "Lcn/sast/dataflow/interprocedural/analysis/IFact;", "newSummary", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "src", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "mt", "key", "newSummaryArraySize", "allocSite", "getEmptyFieldSpace", "Lcn/sast/dataflow/interprocedural/check/heapimpl/FieldHeapKV;", "type", "Lsoot/RefType;", "getEmptyArraySpace", "Lcn/sast/dataflow/interprocedural/analysis/heapimpl/ArrayHeapKV;", "Lsoot/ArrayType;", "arrayLength", "getType", "Lsoot/Type;", "value", "getOfSlot", "slot", "getConstantPoolObjectData", "cv", "callEntryFlowFunction", "", "context", "Lcn/sast/idfa/analysis/Context;", "Lsoot/Unit;", "callee", "node", "succ", "activeCalleeReports", "Lcn/sast/dataflow/interprocedural/check/PointsToGraphBuilder$PathTransfer;", "container", "ctx", "Lcn/sast/dataflow/interprocedural/analysis/AIContext;", "callEdgeValue", "calleeCtx", "updateIntraEdge", "Lsoot/Context;", "hasReturnValue", "PathTransfer", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nPointsToGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointsToGraph.kt\ncn/sast/dataflow/interprocedural/check/PointsToGraphBuilder\n+ 2 IFact.kt\ncn/sast/dataflow/interprocedural/analysis/FieldUtil\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 extensions.kt\nkotlinx/collections/immutable/ExtensionsKt\n*L\n1#1,612:1\n49#2:613\n44#2:614\n44#2:615\n44#2:616\n1#3:617\n362#4:618\n362#4:619\n362#4:620\n*S KotlinDebug\n*F\n+ 1 PointsToGraph.kt\ncn/sast/dataflow/interprocedural/check/PointsToGraphBuilder\n*L\n308#1:613\n371#1:614\n372#1:615\n373#1:616\n556#1:618\n593#1:619\n596#1:620\n*E\n"})
public class PointsToGraphBuilder
extends PointsToGraphBuilderAbstract<IValue> {
    public PointsToGraphBuilder(@NotNull PointsToGraphAbstract<IValue> orig, @NotNull AbstractHeapFactory<IValue> hf, @NotNull IVGlobal vg, @NotNull CallStackContext callStack, @NotNull PersistentMap.Builder<Object, IHeapValues<IValue>> slots, @NotNull PersistentMap.Builder<IValue, PersistentMap<Object, IData<IValue>>> heap, @NotNull PersistentSet.Builder<SootMethod> calledMethods) {
        Intrinsics.checkNotNullParameter(orig, (String)"orig");
        Intrinsics.checkNotNullParameter(hf, (String)"hf");
        Intrinsics.checkNotNullParameter((Object)vg, (String)"vg");
        Intrinsics.checkNotNullParameter((Object)callStack, (String)"callStack");
        Intrinsics.checkNotNullParameter(slots, (String)"slots");
        Intrinsics.checkNotNullParameter(heap, (String)"heap");
        Intrinsics.checkNotNullParameter(calledMethods, (String)"calledMethods");
        super(orig, hf, vg, callStack, slots, heap, calledMethods);
    }

    public final boolean mayChange() {
        return this.getSlots().build() != this.getOrig().getSlots() || this.getHeap().build() != this.getOrig().getHeap() || this.getCalledMethods().build() != this.getOrig().getCalledMethods();
    }

    @NotNull
    public IFact<IValue> build() {
        if (!this.mayChange()) {
            return (IFact)this.getOrig();
        }
        return (IFact)new PointsToGraph(this.getHf(), this.getVg(), this.getCallStack(), this.getSlots().build(), this.getHeap().build(), this.getCalledMethods().build());
    }

    @Nullable
    public IHeapValues<IValue> newSummary(@NotNull HeapValuesEnv env, @NotNull CompanionV<IValue> src, @NotNull Object mt, @Nullable Object key2) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(src, (String)"src");
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        if (mt == BuiltInModelT.Field) {
            IHeapValues iHeapValues;
            if (src.getValue() instanceof IFieldManager) {
                AbstractHeapFactory abstractHeapFactory = this.getHf();
                IFieldManager iFieldManager = (IFieldManager)src.getValue();
                Intrinsics.checkNotNull((Object)key2, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.analysis.JFieldType");
                iHeapValues = abstractHeapFactory.push(env, (Object)iFieldManager.getPhantomField((JFieldType)key2)).markSummaryReturnValueFailedGetKeyFromKey(src, mt, key2).popHV();
            } else if (src.getValue() instanceof AnyNewValue && key2 instanceof JFieldType) {
                FieldUtil fieldUtil = FieldUtil.INSTANCE;
                JFieldType field$iv = (JFieldType)key2;
                boolean $i$f$typeOf = false;
                Pair pair = this.getHf().getVg().defaultValue(field$iv.getType());
                Constant constant = (Constant)pair.component1();
                Type type = (Type)pair.component2();
                iHeapValues = this.getHf().push(env, this.getHf().newConstVal(constant, type)).markOfConstant(constant, (Object)"unset null field").popHV();
            } else {
                iHeapValues = null;
            }
            return iHeapValues;
        }
        if (mt == BuiltInModelT.Array) {
            ArrayType arrayTy;
            Type type = this.getType(src);
            ArrayType arrayType = arrayTy = type instanceof ArrayType ? (ArrayType)type : null;
            if (arrayTy != null) {
                AbstractHeapFactory abstractHeapFactory = this.getHf();
                AbstractHeapFactory abstractHeapFactory2 = this.getHf();
                Type type2 = arrayTy.getElementType();
                Intrinsics.checkNotNullExpressionValue((Object)type2, (String)"getElementType(...)");
                return abstractHeapFactory.push(env, abstractHeapFactory2.newSummaryVal(env, type2, (Object)(src.getValue().hashCode() + "." + key2))).markSummaryReturnValueFailedGetKeyFromKey(src, mt, key2).popHV();
            }
        }
        return null;
    }

    @NotNull
    public final IHeapValues<IValue> newSummaryArraySize(@NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> allocSite) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(allocSite, (String)"allocSite");
        AbstractHeapFactory abstractHeapFactory = this.getHf();
        AbstractHeapFactory abstractHeapFactory2 = this.getHf();
        IntType intType = G.v().soot_IntType();
        Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
        return abstractHeapFactory.push(env, abstractHeapFactory2.newSummaryVal(env, (Type)intType, (Object)"arraySize")).markSummaryArraySize(allocSite).popHV();
    }

    @NotNull
    public FieldHeapKV<IValue> getEmptyFieldSpace(@NotNull RefType type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return (FieldHeapKV)new FieldSpace(type, ExtensionsKt.persistentHashMapOf(), this.getHf().empty());
    }

    @NotNull
    public ArrayHeapKV<IValue> getEmptyArraySpace(@NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> allocSite, @NotNull ArrayType type, @Nullable IHeapValues<IValue> arrayLength) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(allocSite, (String)"allocSite");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        IHeapValues size = arrayLength == null || arrayLength.isEmpty() ? this.newSummaryArraySize(env, allocSite) : arrayLength;
        return (ArrayHeapKV)ArraySpace.Companion.v(this.getHf(), env, ExtensionsKt.persistentHashMapOf(), this.getHf().empty(), type, size);
    }

    @Nullable
    public Type getType(@NotNull CompanionV<IValue> value) {
        Intrinsics.checkNotNullParameter(value, (String)"value");
        return ((IValue)value.getValue()).getType();
    }

    @NotNull
    public IHeapValues<IValue> getOfSlot(@NotNull HeapValuesEnv env, @NotNull Object slot) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)slot, (String)"slot");
        IHeapValues iHeapValues = this.getTargets(slot);
        if (iHeapValues == null) {
            iHeapValues = this.getHf().empty();
        }
        return iHeapValues;
    }

    @Nullable
    public IData<IValue> getConstantPoolObjectData(@NotNull HeapValuesEnv env, @NotNull CompanionV<IValue> cv, @NotNull Object mt) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(cv, (String)"cv");
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        IValue value = (IValue)cv.getValue();
        if (value instanceof ConstVal && ((ConstVal)value).getV() instanceof StringConstant) {
            PointsToGraphBuilder cb = this;
            if (!cb.getHeap().containsKey(cv.getValue())) {
                Unit unit = env.getNode();
                AbstractHeapFactory abstractHeapFactory = this.getHf();
                String string = ((StringConstant)((ConstVal)value).getV()).value;
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"value");
                String string2 = string;
                byte[] byArray = string2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBytes(...)");
                JStrArrValue arrayValue = new JStrArrValue(unit, abstractHeapFactory, byArray);
                WString ws = WString.Companion.v();
                Object object = this.emptyFieldFx().invoke(cv);
                Intrinsics.checkNotNull((Object)object);
                IHeapKVData.Builder members = ((FieldHeapKV)object).builder();
                AbstractHeapFactory abstractHeapFactory2 = this.getHf();
                AnyNewExprEnv anyNewExprEnv = this.getHf().getVg().getNEW_Env();
                NewArrayExpr newArrayExpr = ws.getNewValueExpr();
                Intrinsics.checkNotNullExpressionValue((Object)newArrayExpr, (String)"<get-newValueExpr>(...)");
                IValue newArrayValue = (IValue)abstractHeapFactory2.anyNewVal(anyNewExprEnv, (AnyNewExpr)newArrayExpr);
                IHeapValues newValue = this.getHf().empty().plus(this.getHf().push(env, (Object)newArrayValue).dataSequenceToSeq(cv).pop());
                IHeapValues iHeapValues = this.getHf().empty();
                AbstractHeapFactory abstractHeapFactory3 = this.getHf();
                AbstractHeapFactory abstractHeapFactory4 = this.getHf();
                Constant constant = (Constant)WString.Companion.getLATIN1();
                ByteType byteType = G.v().soot_ByteType();
                Intrinsics.checkNotNullExpressionValue((Object)byteType, (String)"soot_ByteType(...)");
                IHeapValues newCoder = iHeapValues.plus(JOperatorV.DefaultImpls.markOfConstant$default((JOperatorV)abstractHeapFactory3.push(env, abstractHeapFactory4.newConstVal(constant, (Type)byteType)), (Constant)((Constant)WString.Companion.getLATIN1()), null, (int)2, null).pop());
                IHeapValues iHeapValues2 = this.getHf().empty();
                AbstractHeapFactory abstractHeapFactory5 = this.getHf();
                AbstractHeapFactory abstractHeapFactory6 = this.getHf();
                IntConstant intConstant = IntConstant.v((int)((StringConstant)((ConstVal)value).getV()).value.hashCode());
                Intrinsics.checkNotNullExpressionValue((Object)intConstant, (String)"v(...)");
                Constant constant2 = (Constant)intConstant;
                IntType intType = G.v().soot_IntType();
                Intrinsics.checkNotNullExpressionValue((Object)intType, (String)"soot_IntType(...)");
                IHeapValues newHash = iHeapValues2.plus(abstractHeapFactory5.push(env, abstractHeapFactory6.newConstVal(constant2, (Type)intType)).markOfOp((Object)"string.hash", cv, new CompanionV[0]).pop());
                FieldUtil fieldUtil = FieldUtil.INSTANCE;
                SootField field$iv = ws.getValueField();
                boolean $i$f$of = false;
                members.set((IHeapValuesFactory)this.getHf(), env, (Object)new JSootFieldType(field$iv), newValue, false);
                FieldUtil this_$iv = FieldUtil.INSTANCE;
                field$iv = ws.getCoderField();
                $i$f$of = false;
                members.set((IHeapValuesFactory)this.getHf(), env, (Object)new JSootFieldType(field$iv), newCoder, false);
                this_$iv = FieldUtil.INSTANCE;
                field$iv = ws.getHashField();
                $i$f$of = false;
                members.set((IHeapValuesFactory)this.getHf(), env, (Object)new JSootFieldType(field$iv), newHash, false);
                cb.setValueData(env, (Object)newArrayValue, (Object)BuiltInModelT.Array, (IData)arrayValue);
                cb.setValueData(env, (Object)value, (Object)BuiltInModelT.Field, members.build());
                IFact.Builder builder2 = (IFact.Builder)cb;
                String string3 = ((StringConstant)((ConstVal)value).getV()).value;
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"value");
                IFact.Builder.DefaultImpls.assignNewExpr$default((IFact.Builder)builder2, (HeapValuesEnv)env, (Object)string3, (IHeapValues)this.getHf().empty().plus(cv), (boolean)false, (int)8, null);
            }
            return this.getValueData((Object)value, mt);
        }
        return null;
    }

    public void callEntryFlowFunction(@NotNull cn.sast.idfa.analysis.Context<SootMethod, Unit, IFact<IValue>> context, @NotNull SootMethod callee, @NotNull Unit node, @NotNull Unit succ) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)callee, (String)"callee");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter((Object)succ, (String)"succ");
        this.setCallStack(new CallStackContext(this.getCallStack(), node, callee, this.getCallStack().getDeep() + 1));
        IHeapValues receivers = (IHeapValues)this.getSlots().get((Object)-1);
        if (receivers != null) {
            AbstractHeapFactory abstractHeapFactory = this.getHf();
            RefType refType = callee.getDeclaringClass().getType();
            Intrinsics.checkNotNullExpressionValue((Object)refType, (String)"getType(...)");
            IHeapValues receiversValues = abstractHeapFactory.canStore(receivers, (Type)refType);
            ((Map)this.getSlots()).put(-1, receiversValues);
        }
    }

    private final PathTransfer activeCalleeReports(SootMethod container, HeapValuesEnv env, AIContext ctx2, IFact<IValue> callEdgeValue, AIContext calleeCtx) {
        Map calleePathToCallerPath = new LinkedHashMap();
        activeCalleeReports.diff.1 diff2 = new /* Unavailable Anonymous Inner Class!! */;
        IDiff iDiff = (IDiff)diff2;
        Object object = calleeCtx.getEntryValue();
        Intrinsics.checkNotNull((Object)object);
        callEdgeValue.diff(iDiff, (IFact)object);
        return new PathTransfer(env, calleePathToCallerPath, ctx2, calleeCtx);
    }

    @Nullable
    public IHeapValues<IValue> updateIntraEdge(@NotNull HeapValuesEnv env, @NotNull Context ctx2, @NotNull Context calleeCtx, @NotNull IFact<IValue> callEdgeValue, boolean hasReturnValue) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)ctx2, (String)"ctx");
        Intrinsics.checkNotNullParameter((Object)calleeCtx, (String)"calleeCtx");
        Intrinsics.checkNotNullParameter(callEdgeValue, (String)"callEdgeValue");
        if (!(callEdgeValue instanceof PointsToGraphAbstract)) {
            throw new IllegalArgumentException("updateIntraEdge error of fact type: " + callEdgeValue.getClass() + " \n" + callEdgeValue);
        }
        AIContext cfr_ignored_0 = (AIContext)ctx2;
        AIContext cfr_ignored_1 = (AIContext)calleeCtx;
        PathTransfer pathTransfer = this.activeCalleeReports((SootMethod)((AIContext)ctx2).getMethod(), env, (AIContext)ctx2, callEdgeValue, (AIContext)calleeCtx);
        Object object = ((AIContext)calleeCtx).getExitValue();
        Intrinsics.checkNotNull((Object)object);
        IFact exitValue = (IFact)object;
        if (!(exitValue instanceof PointsToGraphAbstract)) {
            if (exitValue.isBottom()) {
                return null;
            }
            throw new IllegalArgumentException("updateIntraEdge error of fact type: " + exitValue.getClass() + " \n" + exitValue);
        }
        this.getCalledMethods().addAll((Collection)((PointsToGraphAbstract)exitValue).getCalledMethods());
        if (FactValuesKt.getLeastExpr()) {
            updateIntraEdge.transformPathx.1 transformPathx2 = new /* Unavailable Anonymous Inner Class!! */;
            for (Map.Entry entry : ((Map)((PointsToGraphAbstract)exitValue).getHeap()).entrySet()) {
                IData iData;
                Object data;
                IValue iValue = (IValue)entry.getKey();
                PersistentMap dataMap = (PersistentMap)entry.getValue();
                PersistentMap selfMap = (PersistentMap)this.getHeap().get((Object)iValue);
                PersistentMap.Builder builder2 = dataMap.builder();
                for (Map.Entry entry2 : ((Map)dataMap).entrySet()) {
                    Object mt = entry2.getKey();
                    data = (IData)entry2.getValue();
                    iData = data.cloneAndReNewObjects((IReNew)transformPathx2);
                    if (iData == data) continue;
                    ((Map)builder2).put(mt, iData);
                }
                if (Intrinsics.areEqual((Object)iValue, (Object)this.getHf().getVg().getGLOBAL_SITE())) {
                    BuiltInModelT mt = BuiltInModelT.Field;
                    PersistentMap persistentMap = selfMap;
                    IData iData2 = persistentMap != null ? (IData)persistentMap.get((Object)mt) : null;
                    IData old = (IData)builder2.get((Object)mt);
                    if (iData2 != null && old != null) {
                        data = (Map)builder2;
                        IData it = iData = old.builder();
                        boolean bl = false;
                        Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.analysis.HeapDataBuilder<*, cn.sast.dataflow.interprocedural.analysis.IValue>");
                        ((HeapDataBuilder)it).updateFrom(this.getHf(), iData2);
                        iData = iData.build();
                        data.put(mt, iData);
                    }
                }
                PersistentMap transformPath = builder2.build();
                Map map = (Map)selfMap;
                if (map == null || map.isEmpty()) {
                    ((Map)this.getHeap()).put(iValue, transformPath);
                    continue;
                }
                Map map2 = (Map)this.getHeap();
                PersistentMap $this$plus$iv = selfMap;
                boolean $i$f$plus = false;
                $this$plus$iv = ExtensionsKt.putAll((PersistentMap)$this$plus$iv, (Map)((Map)transformPath));
                map2.put(iValue, $this$plus$iv);
            }
            ((AIContext)ctx2).activeReport((AIContext)calleeCtx, pathTransfer);
            IHeapValues ret = ((PointsToGraphAbstract)exitValue).getTargetsUnsafe((Object)this.getVg().getRETURN_LOCAL());
            if (hasReturnValue && ret != null) {
                return ret.cloneAndReNewObjects((IReNew)transformPathx2);
            }
        } else {
            IHeapValues v;
            Set orig = new LinkedHashSet();
            for (Map.Entry object2 : ((Map)((PointsToGraphAbstract)callEdgeValue).getSlots()).entrySet()) {
                Object k = object2.getKey();
                v = (IHeapValues)object2.getValue();
                orig.addAll((Collection)v.getValues());
            }
            for (Map.Entry entry : ((Map)((PointsToGraphAbstract)callEdgeValue).getHeap()).entrySet()) {
                IValue iValue = (IValue)entry.getKey();
                PersistentMap dataMap = (PersistentMap)entry.getValue();
                for (Map.Entry entry3 : ((Map)dataMap).entrySet()) {
                    Object mt = entry3.getKey();
                    IData iData = (IData)entry3.getValue();
                    iData.reference((Collection)orig);
                }
            }
            IReNew reNew = this.getHf().newReNewInterface(orig);
            if (!((Map)((PointsToGraphAbstract)exitValue).getHeap()).isEmpty()) {
                for (Map.Entry entry : ((Map)((PointsToGraphAbstract)exitValue).getHeap()).entrySet()) {
                    PersistentMap $this$plus$iv;
                    boolean $i$f$plus;
                    Map map$iv;
                    Map map;
                    IValue iValue;
                    PersistentMap selfMap;
                    IData data;
                    v = (IValue)entry.getKey();
                    PersistentMap dataMap = (PersistentMap)entry.getValue();
                    PersistentMap.Builder builder3 = dataMap.builder();
                    for (Map.Entry entry4 : ((Map)dataMap).entrySet()) {
                        Object mt = entry4.getKey();
                        data = (IData)entry4.getValue();
                        IData iData = data.cloneAndReNewObjects(reNew);
                        if (iData == data) continue;
                        ((Map)builder3).put(mt, iData);
                    }
                    PersistentMap persistentMap = (PersistentMap)this.getHeap().get((Object)v);
                    if (persistentMap == null) {
                        persistentMap = selfMap = ExtensionsKt.persistentHashMapOf();
                    }
                    if ((iValue = (IValue)reNew.checkNeedReplace((Object)v)) == null) {
                        map = (Map)this.getHeap();
                        data = selfMap;
                        map$iv = (Map)builder3.build();
                        $i$f$plus = false;
                        $this$plus$iv = ExtensionsKt.putAll((PersistentMap)$this$plus$iv, (Map)map$iv);
                        map.put(v, $this$plus$iv);
                        continue;
                    }
                    if (Intrinsics.areEqual((Object)v, (Object)iValue)) continue;
                    map = (Map)this.getHeap();
                    $this$plus$iv = selfMap;
                    map$iv = (Map)builder3.build();
                    $i$f$plus = false;
                    PersistentMap persistentMap2 = ExtensionsKt.putAll((PersistentMap)$this$plus$iv, (Map)map$iv);
                    map.put(iValue, persistentMap2);
                    this.getHeap().remove((Object)v);
                }
            }
            if (hasReturnValue) {
                IHeapValues iHeapValues = ((PointsToGraphAbstract)exitValue).getTargetsUnsafe((Object)this.getVg().getRETURN_LOCAL());
                if (iHeapValues == null) {
                    return null;
                }
                IHeapValues iHeapValues2 = iHeapValues;
                return iHeapValues2.cloneAndReNewObjects(reNew);
            }
        }
        return null;
    }
}

