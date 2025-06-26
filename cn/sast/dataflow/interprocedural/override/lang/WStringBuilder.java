/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage
 *  cn.sast.dataflow.interprocedural.override.lang.WStringBuilder
 *  cn.sast.dataflow.interprocedural.override.lang.WStringBuilder$Companion
 *  cn.sast.dataflow.interprocedural.override.lang.WStringBuilder$register$appendBoolean$1
 *  cn.sast.dataflow.interprocedural.override.lang.WStringBuilder$register$appendChar$1
 *  cn.sast.dataflow.interprocedural.override.lang.WStringBuilder$register$appendInt$1
 *  cn.sast.dataflow.interprocedural.override.lang.WStringBuilder$register$appendLong$1
 *  cn.sast.dataflow.interprocedural.override.lang.WStringBuilder$register$appendShort$1
 *  cn.sast.dataflow.interprocedural.override.lang.WStringBuilder$register$appendString$1
 *  cn.sast.dataflow.util.SootUtilsKt
 *  com.feysh.corax.config.api.utils.UtilsKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.CallableReference
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KCallable
 *  org.jetbrains.annotations.NotNull
 *  soot.ArrayType
 *  soot.G
 *  soot.RefType
 *  soot.SootField
 *  soot.Type
 *  soot.jimple.Jimple
 *  soot.jimple.NewExpr
 */
package cn.sast.dataflow.interprocedural.override.lang;

import cn.sast.dataflow.interprocedural.analysis.ACheckCallAnalysis;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.SummaryHandlePackage;
import cn.sast.dataflow.interprocedural.override.lang.WStringBuilder;
import cn.sast.dataflow.util.SootUtilsKt;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import org.jetbrains.annotations.NotNull;
import soot.ArrayType;
import soot.G;
import soot.RefType;
import soot.SootField;
import soot.Type;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u0007*\u00100\bj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\tH\u0016\u00a8\u0006\u000b"}, d2={"Lcn/sast/dataflow/interprocedural/override/lang/WStringBuilder;", "Lcn/sast/dataflow/interprocedural/analysis/SummaryHandlePackage;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/V;", "<init>", "()V", "register", "", "Lcn/sast/dataflow/interprocedural/analysis/ACheckCallAnalysis;", "Lcn/sast/dataflow/interprocedural/analysis/AnalysisInSummary;", "Companion", "corax-data-flow"})
public final class WStringBuilder
implements SummaryHandlePackage<IValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public void register(@NotNull ACheckCallAnalysis $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        Function2 appendInt2 = (Function2)register.appendInt.1.INSTANCE;
        Function2 appendString2 = (Function2)register.appendString.1.INSTANCE;
        Function2 appendBoolean2 = (Function2)register.appendBoolean.1.INSTANCE;
        Function2 appendChar2 = (Function2)register.appendChar.1.INSTANCE;
        Function2 appendLong2 = (Function2)register.appendLong.1.INSTANCE;
        Function2 appendShort2 = (Function2)register.appendShort.1.INSTANCE;
        Intrinsics.checkNotNull((Object)appendInt2, (String)"null cannot be cast to non-null type kotlin.jvm.internal.CallableReference");
        String appendIntSignature = UtilsKt.getSootSignature((KCallable)((KCallable)((CallableReference)appendInt2)));
        Intrinsics.checkNotNull((Object)appendString2, (String)"null cannot be cast to non-null type kotlin.jvm.internal.CallableReference");
        String appendStringSignature = UtilsKt.getSootSignature((KCallable)((KCallable)((CallableReference)appendString2)));
        Intrinsics.checkNotNull((Object)appendBoolean2, (String)"null cannot be cast to non-null type kotlin.jvm.internal.CallableReference");
        String appendBooleanSignature = UtilsKt.getSootSignature((KCallable)((KCallable)((CallableReference)appendBoolean2)));
        Intrinsics.checkNotNull((Object)appendChar2, (String)"null cannot be cast to non-null type kotlin.jvm.internal.CallableReference");
        String appendCharSignature = UtilsKt.getSootSignature((KCallable)((KCallable)((CallableReference)appendChar2)));
        Intrinsics.checkNotNull((Object)appendLong2, (String)"null cannot be cast to non-null type kotlin.jvm.internal.CallableReference");
        String appendLongSignature = UtilsKt.getSootSignature((KCallable)((KCallable)((CallableReference)appendLong2)));
        Intrinsics.checkNotNull((Object)appendShort2, (String)"null cannot be cast to non-null type kotlin.jvm.internal.CallableReference");
        String appendShortSignature = UtilsKt.getSootSignature((KCallable)((KCallable)((CallableReference)appendShort2)));
        NewExpr newInteger = Jimple.v().newNewExpr(RefType.v((String)"java.lang.Integer"));
        ArrayType arrayType = ArrayType.v((Type)((Type)G.v().soot_ByteType()), (int)1);
        Intrinsics.checkNotNullExpressionValue((Object)arrayType, (String)"v(...)");
        SootField valueField = SootUtilsKt.getOrMakeField((String)"java.lang.AbstractStringBuilder", (String)"value", (Type)((Type)arrayType));
    }
}

