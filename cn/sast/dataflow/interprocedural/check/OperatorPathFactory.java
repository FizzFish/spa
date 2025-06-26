/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory
 *  cn.sast.dataflow.interprocedural.analysis.CompanionV
 *  cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv
 *  cn.sast.dataflow.interprocedural.analysis.IHeapValues
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.JOperatorV
 *  cn.sast.dataflow.interprocedural.check.CompanionValueImpl1
 *  cn.sast.dataflow.interprocedural.check.IPath
 *  cn.sast.dataflow.interprocedural.check.LiteralPath
 *  cn.sast.dataflow.interprocedural.check.MergePath
 *  cn.sast.dataflow.interprocedural.check.MergePath$Companion
 *  cn.sast.dataflow.interprocedural.check.OperatorPathFactory
 *  cn.sast.dataflow.interprocedural.check.PathCompanionV
 *  cn.sast.dataflow.interprocedural.check.UnknownPath
 *  cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl$EvalCall
 *  cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet
 *  com.feysh.corax.config.api.IIexConst
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.PrimType
 *  soot.RefLikeType
 *  soot.SootMethod
 *  soot.jimple.AnyNewExpr
 *  soot.jimple.BinopExpr
 *  soot.jimple.Constant
 *  soot.jimple.NegExpr
 */
package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JOperatorV;
import cn.sast.dataflow.interprocedural.check.CompanionValueImpl1;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.LiteralPath;
import cn.sast.dataflow.interprocedural.check.MergePath;
import cn.sast.dataflow.interprocedural.check.PathCompanionV;
import cn.sast.dataflow.interprocedural.check.UnknownPath;
import cn.sast.dataflow.interprocedural.check.callback.CalleeCBImpl;
import cn.sast.dataflow.interprocedural.check.heapimpl.ImmutableElementSet;
import com.feysh.corax.config.api.IIexConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.PrimType;
import soot.RefLikeType;
import soot.SootMethod;
import soot.jimple.AnyNewExpr;
import soot.jimple.BinopExpr;
import soot.jimple.Constant;
import soot.jimple.NegExpr;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B9\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0014H\u0016J\u0012\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0016H\u0016J$\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010\u0018\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J.\u0010 \u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\"\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J\u0012\u0010#\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J\u0012\u0010$\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J\u0012\u0010%\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J\u001a\u0010&\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010'\u001a\u00020(H\u0016J6\u0010)\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010\u001e\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016JM\u0010-\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010.\u001a\u00020\u001b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\u001e\u00100\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u001401\"\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016\u00a2\u0006\u0002\u00102JM\u0010-\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010.\u001a\u00020\u001b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001b032\u001e\u00100\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u001b0301\"\b\u0012\u0004\u0012\u00020\u001b03H\u0016\u00a2\u0006\u0002\u00104J(\u00105\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010\u001e\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u001a\u00108\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u00109\u001a\u00020:H\u0016J\u001a\u00108\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010;\u001a\u00020<H\u0016J\u0012\u0010=\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J\u0012\u0010>\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J(\u0010?\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010@\u001a\u00020A2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J:\u0010C\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010D\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00142\n\u0010E\u001a\u00060\u001bj\u0002`F2\b\u0010G\u001a\u0004\u0018\u00010\u001bH\u0016J$\u0010H\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010I\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0014H\u0016J$\u0010J\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010K\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0016H\u0016J \u0010L\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J.\u0010M\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u001a\u0010P\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0006\u0010Q\u001a\u00020RH\u0016J$\u0010S\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010I\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0014H\u0016J$\u0010T\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0014H\u0016J\u0012\u0010U\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J \u0010V\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0012\u0010X\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001H\u0016J\u0013\u0010Y\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0007H\u00c6\u0003J\r\u0010[\u001a\u00060\u0002j\u0002`\u0003H\u00c2\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\nH\u00c6\u0003JA\u0010]\u001a\u00020\u00002\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010a\u001a\u00020bH\u00d6\u0001J\t\u0010c\u001a\u00020AH\u00d6\u0001R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\b\u001a\u00060\u0002j\u0002`\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006d"}, d2={"Lcn/sast/dataflow/interprocedural/check/OperatorPathFactory;", "Lcn/sast/dataflow/interprocedural/analysis/JOperatorV;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "heapFactory", "Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "env", "Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "alloc", "path", "Lcn/sast/dataflow/interprocedural/check/IPath;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;Lcn/sast/dataflow/interprocedural/analysis/IValue;Lcn/sast/dataflow/interprocedural/check/IPath;)V", "getHeapFactory", "()Lcn/sast/dataflow/interprocedural/analysis/AbstractHeapFactory;", "getEnv", "()Lcn/sast/dataflow/interprocedural/analysis/HeapValuesEnv;", "getPath", "()Lcn/sast/dataflow/interprocedural/check/IPath;", "pop", "Lcn/sast/dataflow/interprocedural/analysis/CompanionV;", "popHV", "Lcn/sast/dataflow/interprocedural/analysis/IHeapValues;", "markOfConstant", "c", "Lsoot/jimple/Constant;", "info", "", "Lcom/feysh/corax/config/api/IIexConst;", "markOfNewExpr", "expr", "Lsoot/jimple/AnyNewExpr;", "markSummaryValueFromArrayGet", "array", "markSummaryValueInCaughtExceptionRhs", "markSummaryReturnValueFailedInHook", "markSummaryReturnValueInCalleeSite", "markOfCantCalcAbstractResultValue", "markOfEntryMethodParam", "entryPoint", "Lsoot/SootMethod;", "markSootBinOp", "Lsoot/jimple/BinopExpr;", "clop", "crop", "markOfOp", "op", "op1", "ops", "", "(Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/analysis/CompanionV;[Lcn/sast/dataflow/interprocedural/analysis/CompanionV;)Lcn/sast/dataflow/interprocedural/analysis/JOperatorV;", "Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet;", "(Ljava/lang/Object;Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet;[Lcn/sast/dataflow/interprocedural/check/heapimpl/ImmutableElementSet;)Lcn/sast/dataflow/interprocedural/analysis/JOperatorV;", "markOfNegExpr", "Lsoot/jimple/NegExpr;", "cop", "markOfCastTo", "toPrimType", "Lsoot/PrimType;", "toRefType", "Lsoot/RefLikeType;", "markOfInstanceOf", "markOfArrayContentEqualsBoolResult", "markOfParseString", "hint", "", "str", "markSummaryReturnValueFailedGetKeyFromKey", "src", "mt", "Lcn/sast/dataflow/interprocedural/check/ModelT;", "key", "dataGetElementFromSequence", "sourceSequence", "markSummaryArraySize", "allocSite", "markOfGetClass", "markOfObjectEqualsResult", "th1s", "that", "markOfReturnValueOfMethod", "ctx", "Lcn/sast/dataflow/interprocedural/check/callback/CalleeCBImpl$EvalCall;", "dataSequenceToSeq", "markArraySizeOf", "markOfTaint", "markOfStringLatin1Hash", "byteArray", "markOfWideningSummary", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nOperatorPathFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OperatorPathFactory.kt\ncn/sast/dataflow/interprocedural/check/OperatorPathFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,201:1\n1628#2,3:202\n1454#2,2:205\n1368#2:207\n1557#2:208\n1628#2,3:209\n1456#2,3:212\n*S KotlinDebug\n*F\n+ 1 OperatorPathFactory.kt\ncn/sast/dataflow/interprocedural/check/OperatorPathFactory\n*L\n73#1:202,3\n77#1:205,2\n77#1:207\n77#1:208\n77#1:209,3\n77#1:212,3\n*E\n"})
public final class OperatorPathFactory
implements JOperatorV<IValue> {
    @NotNull
    private final AbstractHeapFactory<IValue> heapFactory;
    @NotNull
    private final HeapValuesEnv env;
    @NotNull
    private final IValue alloc;
    @Nullable
    private final IPath path;

    public OperatorPathFactory(@NotNull AbstractHeapFactory<IValue> heapFactory, @NotNull HeapValuesEnv env, @NotNull IValue alloc, @Nullable IPath path) {
        Intrinsics.checkNotNullParameter(heapFactory, (String)"heapFactory");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)alloc, (String)"alloc");
        this.heapFactory = heapFactory;
        this.env = env;
        this.alloc = alloc;
        this.path = path;
    }

    public /* synthetic */ OperatorPathFactory(AbstractHeapFactory abstractHeapFactory, HeapValuesEnv heapValuesEnv, IValue iValue, IPath iPath, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            iPath = null;
        }
        this(abstractHeapFactory, heapValuesEnv, iValue, iPath);
    }

    @NotNull
    public final AbstractHeapFactory<IValue> getHeapFactory() {
        return this.heapFactory;
    }

    @NotNull
    public final HeapValuesEnv getEnv() {
        return this.env;
    }

    @Nullable
    public final IPath getPath() {
        return this.path;
    }

    @NotNull
    public CompanionV<IValue> pop() {
        IPath iPath = this.path;
        if (iPath == null) {
            iPath = (IPath)UnknownPath.Companion.v(this.env);
        }
        return (CompanionV)new CompanionValueImpl1(this.alloc, iPath);
    }

    @NotNull
    public IHeapValues<IValue> popHV() {
        return this.heapFactory.empty().plus(this.pop());
    }

    @NotNull
    public JOperatorV<IValue> markOfConstant(@NotNull Constant c, @Nullable Object info2) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((IPath)LiteralPath.Companion.v(this.env, c, info2)), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markOfConstant(@NotNull IIexConst c) {
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((IPath)LiteralPath.Companion.v(this.env, c)), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markOfNewExpr(@NotNull AnyNewExpr expr) {
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markSummaryValueFromArrayGet(@NotNull CompanionV<IValue> array, @Nullable Object info2) {
        Intrinsics.checkNotNullParameter(array, (String)"array");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((PathCompanionV)array).getPath(), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markSummaryValueInCaughtExceptionRhs() {
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markSummaryReturnValueFailedInHook() {
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markSummaryReturnValueInCalleeSite() {
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markOfCantCalcAbstractResultValue() {
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markOfEntryMethodParam(@NotNull SootMethod entryPoint) {
        Intrinsics.checkNotNullParameter((Object)entryPoint, (String)"entryPoint");
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markSootBinOp(@NotNull BinopExpr expr, @NotNull CompanionV<IValue> clop, @NotNull CompanionV<IValue> crop) {
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter(clop, (String)"clop");
        Intrinsics.checkNotNullParameter(crop, (String)"crop");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)MergePath.Companion.v(this.env, ((PathCompanionV)clop).getPath(), ((PathCompanionV)crop).getPath()), (int)7, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public JOperatorV<IValue> markOfOp(@NotNull Object op, @NotNull CompanionV<IValue> op1, CompanionV<IValue> ... ops) {
        void var17_17;
        void destination$iv;
        void $this$mapTo$iv;
        Intrinsics.checkNotNullParameter((Object)op, (String)"op");
        Intrinsics.checkNotNullParameter(op1, (String)"op1");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        Iterable iterable = CollectionsKt.plus((Collection)CollectionsKt.listOf(op1), (Object[])ops);
        Collection collection = new HashSet(8);
        HeapValuesEnv heapValuesEnv = this.env;
        MergePath.Companion companion = MergePath.Companion;
        IValue iValue = null;
        HeapValuesEnv heapValuesEnv2 = null;
        AbstractHeapFactory abstractHeapFactory = null;
        OperatorPathFactory operatorPathFactory = this;
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void c;
            CompanionV companionV = (CompanionV)item$iv;
            var17_17 = destination$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)c, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.PathCompanionV");
            var17_17.add(((PathCompanionV)c).getPath());
        }
        var17_17 = destination$iv;
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)operatorPathFactory, abstractHeapFactory, heapValuesEnv2, iValue, (IPath)companion.v(heapValuesEnv, (Set)var17_17), (int)7, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public JOperatorV<IValue> markOfOp(@NotNull Object op, @NotNull ImmutableElementSet<Object> op1, ImmutableElementSet<Object> ... ops) {
        void destination$iv;
        void $this$flatMapTo$iv;
        Intrinsics.checkNotNullParameter((Object)op, (String)"op");
        Intrinsics.checkNotNullParameter(op1, (String)"op1");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        Iterable iterable = CollectionsKt.plus((Collection)CollectionsKt.listOf(op1), (Object[])ops);
        Collection collection = new HashSet(8);
        HeapValuesEnv heapValuesEnv = this.env;
        MergePath.Companion companion = MergePath.Companion;
        IValue iValue = null;
        HeapValuesEnv heapValuesEnv2 = null;
        AbstractHeapFactory abstractHeapFactory = null;
        OperatorPathFactory operatorPathFactory = this;
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            void $this$flatMapTo$iv$iv;
            ImmutableElementSet set = (ImmutableElementSet)element$iv;
            boolean bl = false;
            Iterable $this$flatMap$iv = set.getMap().values();
            boolean $i$f$flatMap = false;
            Iterable iterable2 = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo2 = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                void $this$mapTo$iv$iv;
                IHeapValues values = (IHeapValues)element$iv$iv;
                boolean bl2 = false;
                Iterable $this$map$iv = (Iterable)values.getValuesCompanion();
                boolean $i$f$map = false;
                Iterable iterable3 = $this$map$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    CompanionV companionV = (CompanionV)item$iv$iv;
                    Collection collection2 = destination$iv$iv2;
                    boolean bl3 = false;
                    Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type cn.sast.dataflow.interprocedural.check.PathCompanionV");
                    collection2.add(((PathCompanionV)it).getPath());
                }
                Iterable list$iv$iv = (List)destination$iv$iv2;
                CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
            }
            Iterable list$iv = (List)destination$iv$iv;
            CollectionsKt.addAll((Collection)destination$iv, (Iterable)list$iv);
        }
        void var36_36 = destination$iv;
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)operatorPathFactory, abstractHeapFactory, heapValuesEnv2, iValue, (IPath)companion.v(heapValuesEnv, (Set)var36_36), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markOfNegExpr(@NotNull NegExpr expr, @NotNull CompanionV<IValue> cop) {
        Intrinsics.checkNotNullParameter((Object)expr, (String)"expr");
        Intrinsics.checkNotNullParameter(cop, (String)"cop");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((PathCompanionV)cop).getPath(), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markOfCastTo(@NotNull PrimType toPrimType) {
        Intrinsics.checkNotNullParameter((Object)toPrimType, (String)"toPrimType");
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markOfCastTo(@NotNull RefLikeType toRefType) {
        Intrinsics.checkNotNullParameter((Object)toRefType, (String)"toRefType");
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markOfInstanceOf() {
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markOfArrayContentEqualsBoolResult() {
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markOfParseString(@NotNull String hint, @NotNull CompanionV<IValue> str) {
        Intrinsics.checkNotNullParameter((Object)hint, (String)"hint");
        Intrinsics.checkNotNullParameter(str, (String)"str");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((PathCompanionV)str).getPath(), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markSummaryReturnValueFailedGetKeyFromKey(@NotNull CompanionV<IValue> src, @NotNull Object mt, @Nullable Object key2) {
        Intrinsics.checkNotNullParameter(src, (String)"src");
        Intrinsics.checkNotNullParameter((Object)mt, (String)"mt");
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> dataGetElementFromSequence(@NotNull CompanionV<IValue> sourceSequence) {
        Intrinsics.checkNotNullParameter(sourceSequence, (String)"sourceSequence");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((PathCompanionV)sourceSequence).getPath(), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markSummaryArraySize(@NotNull IHeapValues<IValue> allocSite) {
        Intrinsics.checkNotNullParameter(allocSite, (String)"allocSite");
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markOfGetClass(@NotNull CompanionV<IValue> cop) {
        Intrinsics.checkNotNullParameter(cop, (String)"cop");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((PathCompanionV)cop).getPath(), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markOfObjectEqualsResult(@NotNull CompanionV<IValue> th1s, @NotNull CompanionV<IValue> that) {
        Intrinsics.checkNotNullParameter(th1s, (String)"th1s");
        Intrinsics.checkNotNullParameter(that, (String)"that");
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markOfReturnValueOfMethod(@NotNull CalleeCBImpl.EvalCall ctx2) {
        Intrinsics.checkNotNullParameter((Object)ctx2, (String)"ctx");
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> dataSequenceToSeq(@NotNull CompanionV<IValue> sourceSequence) {
        Intrinsics.checkNotNullParameter(sourceSequence, (String)"sourceSequence");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((PathCompanionV)sourceSequence).getPath(), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markArraySizeOf(@NotNull CompanionV<IValue> array) {
        Intrinsics.checkNotNullParameter(array, (String)"array");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((PathCompanionV)array).getPath(), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markOfTaint() {
        return (JOperatorV)this;
    }

    @NotNull
    public JOperatorV<IValue> markOfStringLatin1Hash(@NotNull CompanionV<IValue> byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, (String)"byteArray");
        return (JOperatorV)OperatorPathFactory.copy$default((OperatorPathFactory)this, null, null, null, (IPath)((PathCompanionV)byteArray).getPath(), (int)7, null);
    }

    @NotNull
    public JOperatorV<IValue> markOfWideningSummary() {
        return (JOperatorV)this;
    }

    @NotNull
    public final AbstractHeapFactory<IValue> component1() {
        return this.heapFactory;
    }

    @NotNull
    public final HeapValuesEnv component2() {
        return this.env;
    }

    private final IValue component3() {
        return this.alloc;
    }

    @Nullable
    public final IPath component4() {
        return this.path;
    }

    @NotNull
    public final OperatorPathFactory copy(@NotNull AbstractHeapFactory<IValue> heapFactory, @NotNull HeapValuesEnv env, @NotNull IValue alloc, @Nullable IPath path) {
        Intrinsics.checkNotNullParameter(heapFactory, (String)"heapFactory");
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        Intrinsics.checkNotNullParameter((Object)alloc, (String)"alloc");
        return new OperatorPathFactory(heapFactory, env, alloc, path);
    }

    public static /* synthetic */ OperatorPathFactory copy$default(OperatorPathFactory operatorPathFactory, AbstractHeapFactory abstractHeapFactory, HeapValuesEnv heapValuesEnv, IValue iValue, IPath iPath, int n, Object object) {
        if ((n & 1) != 0) {
            abstractHeapFactory = operatorPathFactory.heapFactory;
        }
        if ((n & 2) != 0) {
            heapValuesEnv = operatorPathFactory.env;
        }
        if ((n & 4) != 0) {
            iValue = operatorPathFactory.alloc;
        }
        if ((n & 8) != 0) {
            iPath = operatorPathFactory.path;
        }
        return operatorPathFactory.copy(abstractHeapFactory, heapValuesEnv, iValue, iPath);
    }

    @NotNull
    public String toString() {
        return "OperatorPathFactory(heapFactory=" + this.heapFactory + ", env=" + this.env + ", alloc=" + this.alloc + ", path=" + this.path + ")";
    }

    public int hashCode() {
        int result = this.heapFactory.hashCode();
        result = result * 31 + this.env.hashCode();
        result = result * 31 + this.alloc.hashCode();
        result = result * 31 + (this.path == null ? 0 : this.path.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperatorPathFactory)) {
            return false;
        }
        OperatorPathFactory operatorPathFactory = (OperatorPathFactory)other;
        if (!Intrinsics.areEqual((Object)this.heapFactory, (Object)operatorPathFactory.heapFactory)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.env, (Object)operatorPathFactory.env)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.alloc, (Object)operatorPathFactory.alloc)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.path, (Object)operatorPathFactory.path);
    }
}

