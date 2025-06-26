/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.dataflow.interprocedural.analysis.AIContext
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewValue
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.HeapValues
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.HookEnv
 *  cn.sast.dataflow.interprocedural.analysis.IData
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IFact$Builder$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IFieldManager
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues$Builder
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory
 *  cn.sast.dataflow.interprocedural.analysis.IIFact
 *  cn.sast.dataflow.interprocedural.analysis.IOpCalculator
 *  cn.sast.dataflow.interprocedural.analysis.IReNew
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorC
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorHV
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV
 *  cn.sast.dataflow.interprocedural.analysis.PointsToGraphBuilderAbstract
 *  cn.sast.dataflow.interprocedural.analysis.SummaryValue
 *  cn.sast.dataflow.interprocedural.check.BuiltInModelT
 *  cn.sast.dataflow.interprocedural.check.HeapFactory
 *  cn.sast.dataflow.interprocedural.check.HeapFactory$resolve$visitor$1
 *  cn.sast.dataflow.interprocedural.check.HeapFactory$resolveCast$rpFactory$1
 *  cn.sast.dataflow.interprocedural.check.HeapValuesEnvImpl
 *  cn.sast.dataflow.interprocedural.check.JOperatorHVImpl
 *  cn.sast.dataflow.interprocedural.check.OpCalculator
 *  cn.sast.dataflow.interprocedural.check.OperatorPathFactory
 *  cn.sast.dataflow.interprocedural.check.PathFactory
 *  cn.sast.dataflow.interprocedural.check.PathFactoryImpl
 *  cn.sast.dataflow.interprocedural.check.checker.CheckerModelingKt
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSetBuilder
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValues
 *  cn.sast.idfa.check.ICallCB
 *  com.feysh.corax.config.api.IClassField
 *  com.feysh.corax.config.api.IExpr
 *  com.feysh.corax.config.api.IModelExpressionVisitor
 *  com.feysh.corax.config.api.TaintProperty
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.AnySubType
 *  soot.ArrayType
 *  soot.BooleanType
 *  soot.FastHierarchy
 *  soot.G
 *  soot.NullType
 *  soot.PrimType
 *  soot.RefLikeType
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.Type
 *  soot.Unit
 *  soot.UnknownType
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.BinopExpr
 *  soot.jimple.ConditionExpr
 *  soot.jimple.Constant
 *  soot.jimple.EqExpr
 *  soot.jimple.Expr
 *  soot.jimple.IntConstant
 *  soot.jimple.LengthExpr
 *  soot.jimple.NeExpr
 *  soot.jimple.NegExpr
 *  soot.jimple.NullConstant
 *  soot.jimple.NumericConstant
 *  soot.jimple.UnopExpr
 *  soot.jimple.internal.JIfStmt
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.AIContext;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.AnyNewValue;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.HeapValues;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.HookEnv;
import cn.sast.dataflow.interprocedural.analysis.IData;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IFieldManager;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IHeapValuesFactory;
import cn.sast.dataflow.interprocedural.analysis.IIFact;
import cn.sast.dataflow.interprocedural.analysis.IOpCalculator;
import cn.sast.dataflow.interprocedural.analysis.IReNew;
import cn.sast.dataflow.interprocedural.analysis.IVGlobal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.JOperatorC;
import cn.sast.dataflow.interprocedural.analysis.JOperatorHV;
import cn.sast.dataflow.interprocedural.analysis.JOperatorV;
import cn.sast.dataflow.interprocedural.analysis.PointsToGraphBuilderAbstract;
import cn.sast.dataflow.interprocedural.analysis.SummaryValue;
import cn.sast.dataflow.interprocedural.check.BuiltInModelT;
import cn.sast.dataflow.interprocedural.check.HeapFactory;
import cn.sast.dataflow.interprocedural.check.HeapValuesEnvImpl;
import cn.sast.dataflow.interprocedural.check.JOperatorHVImpl;
import cn.sast.dataflow.interprocedural.check.OpCalculator;
import cn.sast.dataflow.interprocedural.check.OperatorPathFactory;
import cn.sast.dataflow.interprocedural.check.PathFactory;
import cn.sast.dataflow.interprocedural.check.PathFactoryImpl;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModelingKt;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSetBuilder;
import cn.sast.dataflow.interprocedural.check.heapimpl.ObjectValues;
import cn.sast.idfa.check.ICallCB;
import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.AnySubType;
import soot.ArrayType;
import soot.BooleanType;
import soot.FastHierarchy;
import soot.G;
import soot.NullType;
import soot.PrimType;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.Type;
import soot.Unit;
import soot.UnknownType;
import soot.jimple.AnyNewExpr;
import soot.jimple.BinopExpr;
import soot.jimple.ConditionExpr;
import soot.jimple.Constant;
import soot.jimple.EqExpr;
import soot.jimple.Expr;
import soot.jimple.IntConstant;
import soot.jimple.LengthExpr;
import soot.jimple.NeExpr;
import soot.jimple.NegExpr;
import soot.jimple.NullConstant;
import soot.jimple.NumericConstant;
import soot.jimple.UnopExpr;
import soot.jimple.internal.JIfStmt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000eH\u0016J@\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J,\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000e2\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016JF\u0010\u001b\u001a\f\u0012\u0004\u0012\u00020\u001d0\u001cj\u0002`\u001e2\u0006\u0010\u0010\u001a\u00020\u00112\"\u0010\u001f\u001a\u001e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130 2\u0006\u0010!\u001a\u00020\"H\u0016J\u001c\u0010#\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001dH\u0016J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010)\u001a\u00020\u001aH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u00102\u001a\u000203H\u0016J\u0018\u0010\u0010\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00102\u001a\u000203H\u0016J\u0012\u00107\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u000308H\u0016JK\u00109\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030:2\u0006\u0010\u0010\u001a\u00020\u00112*\u0010;\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u000e0<\"\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010=J$\u0010>\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030?2\u0010\u0010@\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030AH\u0016J#\u0010B\u001a\u0004\u0018\u00010C2\n\u0010D\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010E\u001a\u00020CH\u0016\u00a2\u0006\u0002\u0010FJ#\u0010G\u001a\u0004\u0018\u00010H2\n\u0010D\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010E\u001a\u00020CH\u0016\u00a2\u0006\u0002\u0010IJ$\u0010J\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000e2\u0010\u0010D\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030KH\u0016J&\u0010L\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030M2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010N\u001a\u00060\u0002j\u0002`\u0003H\u0016J,\u0010L\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030O2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010P\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030KH\u0016J,\u0010L\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030Q2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010P\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000eH\u0016J\u0010\u0010R\u001a\u00020C2\u0006\u0010)\u001a\u00020\u001aH\u0002J(\u0010S\u001a\u0004\u0018\u00010\u00022\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00022\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020CJH\u0010Z\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010:2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00132\u0006\u0010T\u001a\u00020\u001a2\u0010\u0010[\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000eH\u0016J4\u0010\\\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030:2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010[\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000e2\u0006\u0010E\u001a\u00020\u001aH\u0016JF\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00020:2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u001aH\u0016JN\u0010c\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010K2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010`\u001a\u00020d2\u0010\u0010e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030K2\u0010\u0010f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030K2\u0006\u0010b\u001a\u00020\u001aJL\u0010g\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030K2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010`\u001a\u00020d2\u0010\u0010e\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030K2\u0010\u0010f\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030K2\u0006\u0010b\u001a\u00020\u001aJ`\u0010g\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030:2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00132\u0010\u0010h\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000e2\u0010\u0010i\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000e2\u0006\u0010`\u001a\u00020d2\u0006\u0010b\u001a\u00020\u001aH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010+\u001a\u00060\u0002j\u0002`\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u00a8\u0006j"}, d2={"Lcn/sast/dataflow/interprocedural/check/HeapFactory;", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/check/V;", "vg", "Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;)V", "getVg", "()Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "empty", "Lcn/sast/dataflow/interprocedural/analysis/HeapValues;", "getEmpty", "()Lcn/sast/dataflow/interprocedural/analysis/HeapValues;", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "getField", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "fact", "Lcn/sast/dataflow/interprocedural/analysis/IFact$Builder;", "base", "field", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "canStore", "receivers", "receiverType", "Lsoot/Type;", "resolve", "Lkotlin/sequences/Sequence;", "", "Lcn/sast/dataflow/interprocedural/check/ExprResType;", "atCall", "Lcn/sast/idfa/check/ICallCB;", "iExpr", "Lcom/feysh/corax/config/api/IExpr;", "anyNewVal", "newExprEnv", "Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "newExr", "Lsoot/jimple/AnyNewExpr;", "newSummaryVal", "type", "special", "nullConst", "getNullConst", "()Lcn/sast/dataflow/interprocedural/analysis/IValue;", "newConstVal", "Lcn/sast/dataflow/interprocedural/analysis/ConstVal;", "constant", "Lsoot/jimple/Constant;", "node", "Lsoot/Unit;", "Lcn/sast/dataflow/interprocedural/analysis/HookEnv;", "ctx", "Lcn/sast/dataflow/interprocedural/analysis/AIContext;", "getPathFactory", "Lcn/sast/dataflow/interprocedural/check/PathFactory;", "resolveOp", "Lcn/sast/dataflow/interprocedural/analysis/IOpCalculator;", "ops", "", "(Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;[Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;)Lcn/sast/dataflow/interprocedural/analysis/IOpCalculator;", "newReNewInterface", "Lcn/sast/dataflow/interprocedural/analysis/IReNew;", "orig", "", "getBooleanValue", "", "v", "checkType", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Z)Ljava/lang/Boolean;", "getIntValue", "", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Z)Ljava/lang/Integer;", "single", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "push", "Lcn/sast/dataflow/interprocedural/analysis/JOperatorV;", "alloc", "Lcn/sast/dataflow/interprocedural/analysis/JOperatorC;", "value", "Lcn/sast/dataflow/interprocedural/analysis/JOperatorHV;", "checkTypeHierarchyIsPhantom", "tryCastRef", "toType", "Lsoot/RefLikeType;", "it", "h", "Lsoot/FastHierarchy;", "must", "resolveCast", "fromValues", "resolveInstanceOf", "resolveUnop", "Lcn/sast/dataflow/interprocedural/analysis/IIFact;", "opValues", "expr", "Lsoot/jimple/UnopExpr;", "resType", "resolveBinopOrNull", "Lsoot/jimple/BinopExpr;", "clop", "crop", "resolveBinop", "op1Values", "op2Values", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nHeapFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeapFactory.kt\ncn/sast/dataflow/interprocedural/check/HeapFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1430:1\n1755#2,3:1431\n1#3:1434\n*S KotlinDebug\n*F\n+ 1 HeapFactory.kt\ncn/sast/dataflow/interprocedural/check/HeapFactory\n*L\n1150#1:1431,3\n*E\n"})
public final class HeapFactory
extends AbstractHeapFactory<IValue> {
    @NotNull
    private final IVGlobal vg;
    @NotNull
    private final HeapValues empty;
    @NotNull
    private final IValue nullConst;

    public HeapFactory(@NotNull IVGlobal vg) {
        Intrinsics.checkNotNullParameter((Object)vg, (String)"vg");
        this.vg = vg;
        this.empty = HeapValues.Companion.empty$corax_data_flow();
        NullConstant nullConstant = NullConstant.v();
        Intrinsics.checkNotNullExpressionValue((Object)nullConstant, (String)"v(...)");
        Constant constant = (Constant)nullConstant;
        NullType nullType = G.v().soot_NullType();
        Intrinsics.checkNotNullExpressionValue((Object)nullType, (String)"soot_NullType(...)");
        this.nullConst = (IValue)ConstVal.Companion.v(constant, (Type)nullType);
    }

    @NotNull
    public IVGlobal getVg() {
        return this.vg;
    }

    @NotNull
    public final HeapValues getEmpty() {
        return this.empty;
    }

    @NotNull
    public IHeapValues<IValue> empty() {
        return (IHeapValues)this.empty;
    }

    @NotNull
    public final IHeapValues<IValue> getField(@NotNull HeapValuesEnv env, @NotNull IFact.Builder<IValue> fact, @NotNull IHeapValues<IValue> base, @NotNull JFieldType field) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(fact, (String)"fact");
        Intrinsics.checkNotNullParameter(base, (String)"base");
        Intrinsics.checkNotNullParameter((Object)field, (String)"field");
        IFact.Builder.DefaultImpls.assignNewExpr$default(fact, (HeapValuesEnv)env, (Object)"@base", base, (boolean)false, (int)8, null);
        fact.getField(env, (Object)"@res", (Object)"@base", field, true);
        IHeapValues value = fact.getTargetsUnsafe((Object)"@res");
        fact.kill((Object)"@res");
        fact.kill((Object)"@base");
        IHeapValues iHeapValues = value;
        if (iHeapValues == null) {
            iHeapValues = (IHeapValues)this.empty;
        }
        return iHeapValues;
    }

    @NotNull
    public IHeapValues<IValue> canStore(@NotNull IHeapValues<IValue> receivers, @NotNull Type receiverType) {
        Intrinsics.checkNotNullParameter(receivers, (String)"receivers");
        Intrinsics.checkNotNullParameter((Object)receiverType, (String)"receiverType");
        IHeapValues.Builder receiversValues = this.emptyBuilder();
        FastHierarchy hierarchy = Scene.v().getOrMakeFastHierarchy();
        for (CompanionV receiver : receivers) {
            boolean canStore;
            boolean bl;
            IValue v = (IValue)receiver.getValue();
            if (v.typeIsConcrete()) {
                bl = hierarchy.canStoreType(v.getType(), receiverType);
            } else if (!(receiverType instanceof RefLikeType)) {
                bl = true;
            } else if (receiverType instanceof RefType && ((RefType)receiverType).getSootClass().isPhantom()) {
                bl = true;
            } else {
                Type type;
                if (v.getType() instanceof RefType) {
                    Type type2 = v.getType();
                    Intrinsics.checkNotNull((Object)type2, (String)"null cannot be cast to non-null type soot.RefType");
                    type = (Type)AnySubType.v((RefType)((RefType)type2));
                } else {
                    type = v.getType();
                }
                Type type3 = type;
                bl = Intrinsics.areEqual((Object)v.getType(), (Object)receiverType) || hierarchy.canStoreType(type3, receiverType);
            }
            if (!(canStore = bl)) continue;
            receiversValues.add(receiver);
        }
        return receiversValues.build();
    }

    @NotNull
    public Sequence<Object> resolve(@NotNull HeapValuesEnv env, @NotNull ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> atCall, @NotNull IExpr iExpr) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(atCall, (String)"atCall");
        Intrinsics.checkNotNullParameter((Object)iExpr, (String)"iExpr");
        resolve.visitor.1 visitor2 = new /* Unavailable Anonymous Inner Class!! */;
        return (Sequence)iExpr.accept((IModelExpressionVisitor)visitor2);
    }

    @NotNull
    public IValue anyNewVal(@NotNull AnyNewExprEnv newExprEnv, @NotNull AnyNewExpr newExr) {
        Intrinsics.checkNotNullParameter((Object)newExprEnv, (String)"newExprEnv");
        Intrinsics.checkNotNullParameter((Object)newExr, (String)"newExr");
        Unit unit = newExprEnv.getNode();
        String string = newExprEnv.getMethod().getSignature();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSignature(...)");
        return (IValue)new AnyNewValue(unit, string, newExr);
    }

    @NotNull
    public IValue newSummaryVal(@NotNull HeapValuesEnv env, @NotNull Type type, @NotNull Object special) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)special, (String)"special");
        return (IValue)SummaryValue.Companion.v(type, env.getNode(), special);
    }

    @NotNull
    public IValue getNullConst() {
        return this.nullConst;
    }

    @NotNull
    public ConstVal newConstVal(@NotNull Constant constant, @NotNull Type type) {
        Intrinsics.checkNotNullParameter((Object)constant, (String)"constant");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return ConstVal.Companion.v(constant, type);
    }

    @NotNull
    public HeapValuesEnv env(@NotNull Unit node) {
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        return (HeapValuesEnv)new HeapValuesEnvImpl(node);
    }

    @NotNull
    public HookEnv env(@NotNull AIContext ctx2, @NotNull Unit node) {
        Intrinsics.checkNotNullParameter((Object)ctx2, (String)"ctx");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        return new HookEnv(ctx2, node);
    }

    @NotNull
    public PathFactory<IValue> getPathFactory() {
        return (PathFactory)new PathFactoryImpl();
    }

    @NotNull
    public IOpCalculator<IValue> resolveOp(@NotNull HeapValuesEnv env, IHeapValues<IValue> ... ops) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        return (IOpCalculator)new OpCalculator(env, (AbstractHeapFactory)this, Arrays.copyOf(ops, ops.length));
    }

    @NotNull
    public IReNew<IValue> newReNewInterface(@NotNull Set<IValue> orig) {
        Intrinsics.checkNotNullParameter(orig, (String)"orig");
        return (IReNew)new /* Unavailable Anonymous Inner Class!! */;
    }

    @Nullable
    public Boolean getBooleanValue(@NotNull IValue v, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        return FactValuesKt.getBooleanValue((IValue)v, (boolean)checkType);
    }

    @Nullable
    public Integer getIntValue(@NotNull IValue v, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        return FactValuesKt.getIntValue((IValue)v, (boolean)checkType);
    }

    @NotNull
    public IHeapValues<IValue> single(@NotNull CompanionV<IValue> v) {
        Intrinsics.checkNotNullParameter(v, (String)"v");
        return this.empty().plus(v);
    }

    @NotNull
    public JOperatorV<IValue> push(@NotNull HeapValuesEnv env, @NotNull IValue alloc) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)alloc, (String)"alloc");
        return (JOperatorV)new OperatorPathFactory((AbstractHeapFactory)this, env, alloc, null, 8, null);
    }

    @NotNull
    public JOperatorC<IValue> push(@NotNull HeapValuesEnv env, @NotNull CompanionV<IValue> value) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        Ref.ObjectRef res = new Ref.ObjectRef();
        res.element = value;
        return (JOperatorC)new /* Unavailable Anonymous Inner Class!! */;
    }

    @NotNull
    public JOperatorHV<IValue> push(@NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> value) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        return (JOperatorHV)new JOperatorHVImpl((AbstractHeapFactory)this, env, value);
    }

    private final boolean checkTypeHierarchyIsPhantom(Type type) {
        if (type instanceof ArrayType) {
            Type type2 = ((ArrayType)type).getElementType();
            Intrinsics.checkNotNullExpressionValue((Object)type2, (String)"getElementType(...)");
            return this.checkTypeHierarchyIsPhantom(type2);
        }
        if (type instanceof RefType) {
            boolean bl;
            block6: {
                if (!((RefType)type).hasSootClass()) {
                    return false;
                }
                SootClass sootClass = ((RefType)type).getSootClass();
                Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getSootClass(...)");
                Iterable $this$any$iv = UtilsKt.findAncestors((SootClass)sootClass);
                boolean $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        SootClass it = (SootClass)element$iv;
                        boolean bl2 = false;
                        if (!it.isPhantom()) continue;
                        bl = true;
                        break block6;
                    }
                    bl = false;
                }
            }
            return bl;
        }
        return false;
    }

    @Nullable
    public final IValue tryCastRef(@NotNull RefLikeType toType, @NotNull IValue it, @NotNull FastHierarchy h, boolean must) {
        Intrinsics.checkNotNullParameter((Object)toType, (String)"toType");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Intrinsics.checkNotNullParameter((Object)h, (String)"h");
        Type fromType = it.getType();
        if (fromType instanceof UnknownType) {
            return it;
        }
        boolean fromIsPhantom = this.checkTypeHierarchyIsPhantom(fromType);
        boolean toIsPhantom = this.checkTypeHierarchyIsPhantom((Type)toType);
        boolean canStore = h.canStoreType(fromType, (Type)toType);
        return it.typeIsConcrete() && (canStore || fromIsPhantom || toIsPhantom) ? it : (!must && !it.typeIsConcrete() ? (fromIsPhantom || toIsPhantom ? it.copy((Type)toType) : (!canStore && h.canStoreType((Type)toType, fromType) ? it.copy((Type)toType) : (canStore && h.canStoreType((Type)toType, fromType) ? it : null))) : null);
    }

    @Nullable
    public IOpCalculator<IValue> resolveCast(@NotNull HeapValuesEnv env, @NotNull IFact.Builder<IValue> fact, @NotNull Type toType, @NotNull IHeapValues<IValue> fromValues) {
        IOpCalculator iOpCalculator;
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(fact, (String)"fact");
        Intrinsics.checkNotNullParameter((Object)toType, (String)"toType");
        Intrinsics.checkNotNullParameter(fromValues, (String)"fromValues");
        HeapFactory hf = this;
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{fromValues};
        IOpCalculator unop = hf.resolveOp(env, iHeapValuesArray);
        if (toType instanceof PrimType) {
            unop.resolve((arg_0, arg_1, arg_2) -> HeapFactory.resolveCast$lambda$1(hf, toType, env, fact, arg_0, arg_1, arg_2));
            iOpCalculator = unop;
        } else if (toType instanceof RefLikeType) {
            FastHierarchy h = Scene.v().getOrMakeFastHierarchy();
            Map replaceMap = new LinkedHashMap();
            unop.resolve((arg_0, arg_1, arg_2) -> HeapFactory.resolveCast$lambda$2(this, toType, h, hf, env, replaceMap, arg_0, arg_1, arg_2));
            resolveCast.rpFactory.1 rpFactory2 = new /* Unavailable Anonymous Inner Class!! */;
            if (!(fact instanceof PointsToGraphBuilderAbstract)) {
                String string = "Check failed.";
                throw new IllegalStateException(string.toString());
            }
            ((PointsToGraphBuilderAbstract)fact).apply((IReNew)rpFactory2);
            for (Map.Entry entry : replaceMap.entrySet()) {
                IData iData;
                ObjectValues collection;
                IValue from = (IValue)entry.getKey();
                IValue to = (IValue)entry.getValue();
                if (!(toType instanceof ArrayType) || from.getType() instanceof ArrayType || ((PointsToGraphBuilderAbstract)fact).getArray((Object)to) != null || (collection = (iData = ((PointsToGraphBuilderAbstract)fact).getValueData((Object)to, (Object)BuiltInModelT.Element)) instanceof ObjectValues ? (ObjectValues)iData : null) == null) continue;
                CompanionV array = hf.push(env, to).markOfCastTo((RefLikeType)toType).pop();
                IFact.Builder.DefaultImpls.assignNewExpr$default(fact, (HeapValuesEnv)env, (Object)"@arr", (IHeapValues)this.empty.plus(array), (boolean)false, (int)8, null);
                ((PointsToGraphBuilderAbstract)fact).setArrayValueNew(env, (Object)"@arr", null, collection.getValues());
                ((PointsToGraphBuilderAbstract)fact).kill((Object)"@arr");
            }
            iOpCalculator = unop;
        } else {
            iOpCalculator = null;
        }
        return iOpCalculator;
    }

    @NotNull
    public IOpCalculator<IValue> resolveInstanceOf(@NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> fromValues, @NotNull Type checkType) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(fromValues, (String)"fromValues");
        Intrinsics.checkNotNullParameter((Object)checkType, (String)"checkType");
        HeapFactory hf = this;
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{fromValues};
        IOpCalculator unop = hf.resolveOp(env, iHeapValuesArray);
        FastHierarchy h = Scene.v().getOrMakeFastHierarchy();
        unop.resolve((arg_0, arg_1, arg_2) -> HeapFactory.resolveInstanceOf$lambda$3(h, checkType, hf, env, arg_0, arg_1, arg_2));
        BooleanType booleanType = G.v().soot_BooleanType();
        Intrinsics.checkNotNullExpressionValue((Object)booleanType, (String)"soot_BooleanType(...)");
        unop.putSummaryIfNotConcrete((Type)booleanType, (Object)"instanceOfValue");
        return unop;
    }

    @NotNull
    public IOpCalculator<IValue> resolveUnop(@NotNull HeapValuesEnv env, @NotNull IIFact<IValue> fact, @NotNull IHeapValues<IValue> opValues, @NotNull UnopExpr expr, @NotNull Type resType) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(fact, (String)"fact");
        Intrinsics.checkNotNullParameter(opValues, (String)"opValues");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter((Object)resType, (String)"resType");
        HeapFactory hf = this;
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{opValues};
        IOpCalculator unop = hf.resolveOp(env, iHeapValuesArray);
        if (expr instanceof NegExpr) {
            unop.resolve((arg_0, arg_1, arg_2) -> HeapFactory.resolveUnop$lambda$4(hf, env, resType, expr, arg_0, arg_1, arg_2));
            BooleanType booleanType = G.v().soot_BooleanType();
            Intrinsics.checkNotNullExpressionValue((Object)booleanType, (String)"soot_BooleanType(...)");
            unop.putSummaryIfNotConcrete((Type)booleanType, (Object)expr);
        } else if (expr instanceof LengthExpr) {
            unop.resolve((arg_0, arg_1, arg_2) -> HeapFactory.resolveUnop$lambda$5(fact, hf, env, arg_0, arg_1, arg_2));
            unop.putSummaryIfNotConcrete(resType, (Object)expr);
        } else {
            unop.putSummaryValue(resType, (Object)expr);
        }
        return unop;
    }

    @Nullable
    public final CompanionV<IValue> resolveBinopOrNull(@NotNull HeapValuesEnv env, @NotNull BinopExpr expr, @NotNull CompanionV<IValue> clop, @NotNull CompanionV<IValue> crop, @NotNull Type resType) {
        NumericConstant c2;
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter(clop, (String)"clop");
        Intrinsics.checkNotNullParameter(crop, (String)"crop");
        Intrinsics.checkNotNullParameter((Object)resType, (String)"resType");
        HeapFactory hf = this;
        IValue lop = (IValue)clop.getValue();
        IValue rop = (IValue)crop.getValue();
        ConstVal constVal = lop instanceof ConstVal ? (ConstVal)lop : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        NumericConstant c1 = constant instanceof NumericConstant ? (NumericConstant)constant : null;
        ConstVal constVal2 = rop instanceof ConstVal ? (ConstVal)rop : null;
        Constant constant2 = constVal2 != null ? constVal2.getV() : null;
        NumericConstant numericConstant = c2 = constant2 instanceof NumericConstant ? (NumericConstant)constant2 : null;
        if (c1 != null && c2 != null) {
            try {
                NumericConstant numericConstant2 = SootUtilsKt.evalConstantBinop((Expr)((Expr)expr), (Constant)((Constant)c1), (Constant)((Constant)c2));
                if (numericConstant2 == null) {
                    return null;
                }
                NumericConstant c = numericConstant2;
                return hf.push(env, (IValue)hf.newConstVal((Constant)c, resType)).markSootBinOp(expr, clop, crop).pop();
            }
            catch (Exception e) {
                return null;
            }
        }
        constant2 = expr;
        if (constant2 instanceof EqExpr || constant2 instanceof NeExpr) {
            if (((ConditionExpr)expr).getOp1().getType() instanceof RefLikeType && ((ConditionExpr)expr).getOp1().getType() instanceof RefLikeType) {
            } else {
                return null;
            }
            Boolean equality = lop instanceof IFieldManager && rop instanceof IFieldManager ? Boolean.valueOf(Intrinsics.areEqual((Object)lop, (Object)rop)) : (lop instanceof AnyNewValue && rop instanceof AnyNewValue || lop instanceof SummaryValue || rop instanceof SummaryValue ? (FactValuesKt.getLeastExpr() ? null : Boolean.valueOf(Intrinsics.areEqual((Object)lop, (Object)rop))) : (lop instanceof ConstVal || rop instanceof ConstVal ? null : Boolean.valueOf(Intrinsics.areEqual((Object)lop, (Object)rop))));
            if (equality == null) {
                return null;
            }
            boolean truth = expr instanceof EqExpr ? equality : equality == false;
            IntConstant intConstant = IntConstant.v((int)(truth ? 1 : 0));
            Intrinsics.checkNotNullExpressionValue((Object)intConstant, (String)"v(...)");
            return hf.push(env, (IValue)hf.newConstVal((Constant)intConstant, resType)).markSootBinOp(expr, clop, crop).pop();
        }
        return null;
    }

    @NotNull
    public final CompanionV<IValue> resolveBinop(@NotNull HeapValuesEnv env, @NotNull BinopExpr expr, @NotNull CompanionV<IValue> clop, @NotNull CompanionV<IValue> crop, @NotNull Type resType) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter(clop, (String)"clop");
        Intrinsics.checkNotNullParameter(crop, (String)"crop");
        Intrinsics.checkNotNullParameter((Object)resType, (String)"resType");
        HeapFactory hf = this;
        CompanionV companionV = this.resolveBinopOrNull(env, expr, clop, crop, resType);
        if (companionV == null) {
            companionV = hf.push(env, hf.newSummaryVal(env, resType, (Object)expr)).markSootBinOp(expr, clop, crop).pop();
        }
        return companionV;
    }

    @NotNull
    public IOpCalculator<IValue> resolveBinop(@NotNull HeapValuesEnv env, @NotNull IFact.Builder<IValue> fact, @NotNull IHeapValues<IValue> op1Values, @NotNull IHeapValues<IValue> op2Values, @NotNull BinopExpr expr, @NotNull Type resType) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter(fact, (String)"fact");
        Intrinsics.checkNotNullParameter(op1Values, (String)"op1Values");
        Intrinsics.checkNotNullParameter(op2Values, (String)"op2Values");
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter((Object)resType, (String)"resType");
        HeapFactory hf = this;
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{op1Values, op2Values};
        IOpCalculator binop = hf.resolveOp(env, iHeapValuesArray);
        Set types = new LinkedHashSet();
        binop.resolve((arg_0, arg_1, arg_2) -> HeapFactory.resolveBinop$lambda$8(this, env, expr, resType, fact, types, arg_0, arg_1, arg_2));
        binop.putSummaryIfNotConcrete(resType, (Object)expr);
        if (env.getNode() instanceof JIfStmt) {
            return binop;
        }
        IHeapValues res = binop.getRes().build();
        HeapFactory.resolveBinop$taint((HeapFactory)hf, (HeapValuesEnv)env, fact, (IHeapValues)res, (Set)types, (IClassField)((IClassField)TaintProperty.INSTANCE), (boolean)false);
        return binop;
    }

    private static final boolean resolveCast$lambda$1(HeapFactory $hf, Type $toType, HeapValuesEnv $env, IFact.Builder $fact, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        IValue iValue;
        NumericConstant nc;
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV cop = companionVArray[0];
        IValue op = (IValue)cop.getValue();
        ConstVal constVal = op instanceof ConstVal ? (ConstVal)op : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        NumericConstant numericConstant = nc = constant instanceof NumericConstant ? (NumericConstant)constant : null;
        if (nc != null) {
            Constant constant2 = SootUtilsKt.castTo((NumericConstant)nc, (Type)$toType);
            if (constant2 == null) {
                return false;
            }
            iValue = (IValue)$hf.newConstVal(constant2, $toType);
        } else {
            iValue = $hf.newSummaryVal($env, $toType, (Object)"castValue");
        }
        IValue casted = iValue;
        $fact.copyValueData((Object)op, (Object)casted);
        res.add($hf.push($env, casted).markOfCastTo((PrimType)$toType).pop());
        return true;
    }

    private static final boolean resolveCast$lambda$2(HeapFactory this$0, Type $toType, FastHierarchy $h, HeapFactory $hf, HeapValuesEnv $env, Map $replaceMap, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV cop = companionVArray[0];
        IValue op = (IValue)cop.getValue();
        RefLikeType refLikeType = (RefLikeType)$toType;
        Intrinsics.checkNotNull((Object)$h);
        IValue iValue = this$0.tryCastRef(refLikeType, op, $h, false);
        if (iValue == null) {
            return true;
        }
        IValue casted = iValue;
        CompanionV to = $hf.push($env, casted).markOfCastTo((RefLikeType)$toType).pop();
        if (!Intrinsics.areEqual((Object)casted, (Object)op)) {
            $replaceMap.put(op, casted);
        }
        res.add(to);
        return true;
    }

    private static final boolean resolveInstanceOf$lambda$3(FastHierarchy $h, Type $checkType, HeapFactory $hf, HeapValuesEnv $env, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV cop = companionVArray[0];
        IValue op = (IValue)cop.getValue();
        Type type = op.getType();
        if (type == null) {
            return false;
        }
        Type fromType = type;
        if (fromType instanceof UnknownType) {
            return false;
        }
        boolean canStore = $h.canStoreType(fromType, $checkType);
        if (op.typeIsConcrete() || canStore) {
            res.add($hf.push($env, (IValue)$hf.toConstVal((Object)canStore)).markOfInstanceOf().pop());
            bl = true;
        } else if ($h.canStoreType($checkType, fromType)) {
            bl = false;
        } else {
            res.add($hf.push($env, (IValue)$hf.toConstVal((Object)false)).markOfInstanceOf().pop());
            bl = true;
        }
        return bl;
    }

    private static final boolean resolveUnop$lambda$4(HeapFactory $hf, HeapValuesEnv $env, Type $resType, UnopExpr $expr, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV cop = companionVArray[0];
        IValue op = (IValue)cop.getValue();
        ConstVal constVal = op instanceof ConstVal ? (ConstVal)op : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        NumericConstant numericConstant = constant instanceof NumericConstant ? (NumericConstant)constant : null;
        if (numericConstant == null) {
            return false;
        }
        NumericConstant nc = numericConstant;
        NumericConstant numericConstant2 = nc.negate();
        Intrinsics.checkNotNullExpressionValue((Object)numericConstant2, (String)"negate(...)");
        res.add($hf.push($env, (IValue)$hf.newConstVal((Constant)numericConstant2, $resType)).markOfNegExpr((NegExpr)$expr, cop).pop());
        return true;
    }

    private static final boolean resolveUnop$lambda$5(IIFact $fact, HeapFactory $hf, HeapValuesEnv $env, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV cop = companionVArray[0];
        IHeapValues iHeapValues = $fact.getArrayLength(cop.getValue());
        if (iHeapValues == null) {
            return false;
        }
        IHeapValues length = iHeapValues;
        res.add($hf.push($env, length).markOfArrayLength(cop).pop());
        return true;
    }

    private static final boolean resolveBinop$lambda$8(HeapFactory this$0, HeapValuesEnv $env, BinopExpr $expr, Type $resType, IFact.Builder $fact, Set $types, IOpCalculator $this$resolve, IHeapValues.Builder res, CompanionV[] companionVArray) {
        boolean bl;
        IData it;
        Intrinsics.checkNotNullParameter((Object)$this$resolve, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)res, (String)"res");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV clop = companionVArray[0];
        CompanionV crop = companionVArray[1];
        CompanionV r = this$0.resolveBinop($env, $expr, clop, crop, $resType);
        IData iData = $fact.getValueData(clop.getValue(), CheckerModelingKt.getKeyTaintProperty());
        ImmutableElementSet immutableElementSet = iData instanceof ImmutableElementSet ? (ImmutableElementSet)iData : null;
        if (immutableElementSet != null) {
            it = iData = immutableElementSet;
            boolean bl2 = false;
            $types.add(it);
        }
        iData = $fact.getValueData(crop.getValue(), CheckerModelingKt.getKeyTaintProperty());
        ImmutableElementSet immutableElementSet2 = iData instanceof ImmutableElementSet ? (ImmutableElementSet)iData : null;
        if (immutableElementSet2 != null) {
            it = iData = immutableElementSet2;
            boolean bl3 = false;
            $types.add(it);
        }
        if (r == null) {
            bl = false;
        } else {
            res.add(r);
            bl = true;
        }
        return bl;
    }

    private static final boolean resolveBinop$taint$lambda$10(boolean $append1, IFact.Builder $fact, IClassField $field, Set $values, HeapValuesEnv $env, HeapFactory $hf, IOpCalculator $this$solve, IHeapValues.Builder builder2, CompanionV[] companionVArray) {
        ImmutableElementSet immutableElementSet;
        ImmutableElementSet immutableElementSet2;
        IData iData;
        Intrinsics.checkNotNullParameter((Object)$this$solve, (String)"$this$solve");
        Intrinsics.checkNotNullParameter((Object)builder2, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)companionVArray, (String)"<destruct>");
        CompanionV base = companionVArray[0];
        ImmutableElementSet setDate = $append1 ? ((iData = $fact.getValueData(base.getValue(), (Object)$field)) instanceof ImmutableElementSet ? (ImmutableElementSet)iData : null) : null;
        if (setDate == null || setDate.isEmpty()) {
            if ($values.size() == 1) {
                Object object = CollectionsKt.first((Iterable)$values);
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet<kotlin.Any>");
                immutableElementSet2 = (ImmutableElementSet)object;
            } else {
                immutableElementSet2 = null;
            }
        } else {
            immutableElementSet2 = immutableElementSet = null;
        }
        if (immutableElementSet2 == null) {
            boolean bl = false;
            ImmutableElementSet immutableElementSet3 = setDate;
            if (immutableElementSet3 == null) {
                immutableElementSet3 = new ImmutableElementSet(null, null, 3, null);
            }
            ImmutableElementSetBuilder setBuilder = immutableElementSet3.builder();
            for (ImmutableElementSet typeValues : $values) {
                ImmutableElementSet set;
                if ((typeValues instanceof ImmutableElementSet ? typeValues : null) == null) continue;
                set = set;
                for (Object e : set.getElement()) {
                    IHeapValues v = set.get((IHeapValuesFactory)$hf, e);
                    setBuilder.set((IHeapValuesFactory)$hf, $env, e, v, $append1);
                }
            }
            immutableElementSet = setBuilder.build();
        }
        ImmutableElementSet immutableElementSet4 = immutableElementSet;
        if ((IValue)base.getValue() instanceof ConstVal) {
            return false;
        }
        $fact.setValueData($env, base.getValue(), (Object)$field, (IData)immutableElementSet4);
        return true;
    }

    private static final void resolveBinop$taint(HeapFactory hf, HeapValuesEnv $env, IFact.Builder<IValue> $fact, IHeapValues<IValue> bases, Set<ImmutableElementSet<Object>> values, IClassField field, boolean append) {
        IHeapValues[] iHeapValuesArray = new IHeapValues[]{bases};
        IOpCalculator op = hf.resolveOp($env, iHeapValuesArray);
        boolean append1 = !bases.isSingle() || append;
        op.resolve((arg_0, arg_1, arg_2) -> HeapFactory.resolveBinop$taint$lambda$10(append1, $fact, field, values, $env, hf, arg_0, arg_1, arg_2));
    }
}

