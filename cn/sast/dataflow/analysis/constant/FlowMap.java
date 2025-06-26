/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.analysis.constant.CPValue
 *  cn.sast.dataflow.analysis.constant.FlowMap
 *  cn.sast.dataflow.analysis.constant.FlowMap$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Local
 *  soot.Value
 *  soot.jimple.AddExpr
 *  soot.jimple.BinopExpr
 *  soot.jimple.DivExpr
 *  soot.jimple.EqExpr
 *  soot.jimple.GeExpr
 *  soot.jimple.GtExpr
 *  soot.jimple.IntConstant
 *  soot.jimple.LeExpr
 *  soot.jimple.LtExpr
 *  soot.jimple.MulExpr
 *  soot.jimple.NeExpr
 *  soot.jimple.SubExpr
 */
package cn.sast.dataflow.analysis.constant;

import cn.sast.dataflow.analysis.constant.CPValue;
import cn.sast.dataflow.analysis.constant.FlowMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Value;
import soot.jimple.AddExpr;
import soot.jimple.BinopExpr;
import soot.jimple.DivExpr;
import soot.jimple.EqExpr;
import soot.jimple.GeExpr;
import soot.jimple.GtExpr;
import soot.jimple.IntConstant;
import soot.jimple.LeExpr;
import soot.jimple.LtExpr;
import soot.jimple.MulExpr;
import soot.jimple.NeExpr;
import soot.jimple.SubExpr;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\b\u0007\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0004H\u0086\u0002J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0005J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007\u00a8\u0006\u001e"}, d2={"Lcn/sast/dataflow/analysis/constant/FlowMap;", "", "delegateMap", "", "Lsoot/Local;", "Lcn/sast/dataflow/analysis/constant/CPValue;", "<init>", "(Ljava/util/Map;)V", "getDelegateMap", "()Ljava/util/Map;", "setDelegateMap", "get", "local", "put", "value", "keySet", "", "copyFrom", "", "flowMap", "computeValue", "sootValue", "Lsoot/Value;", "equals", "other", "hashCode", "", "toString", "", "Companion", "corax-data-flow"})
public final class FlowMap {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Map<Local, CPValue> delegateMap;

    @JvmOverloads
    public FlowMap(@NotNull Map<Local, CPValue> delegateMap) {
        Intrinsics.checkNotNullParameter(delegateMap, (String)"delegateMap");
        this.delegateMap = delegateMap;
    }

    public /* synthetic */ FlowMap(Map map, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            map = new HashMap();
        }
        this(map);
    }

    @NotNull
    public final Map<Local, CPValue> getDelegateMap() {
        return this.delegateMap;
    }

    public final void setDelegateMap(@NotNull Map<Local, CPValue> map) {
        Intrinsics.checkNotNullParameter(map, (String)"<set-?>");
        this.delegateMap = map;
    }

    @NotNull
    public final CPValue get(@NotNull Local local) {
        Intrinsics.checkNotNullParameter((Object)local, (String)"local");
        Function1 function1 = FlowMap::get$lambda$0;
        Object v = this.delegateMap.computeIfAbsent(local, (Function)new /* Unavailable Anonymous Inner Class!! */);
        Intrinsics.checkNotNullExpressionValue(v, (String)"computeIfAbsent(...)");
        return (CPValue)v;
    }

    @Nullable
    public final CPValue put(@NotNull Local local, @NotNull CPValue value) {
        Intrinsics.checkNotNullParameter((Object)local, (String)"local");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return this.delegateMap.put(local, value);
    }

    @NotNull
    public final Set<Local> keySet() {
        return this.delegateMap.keySet();
    }

    public final boolean copyFrom(@NotNull FlowMap flowMap) {
        Intrinsics.checkNotNullParameter((Object)flowMap, (String)"flowMap");
        this.delegateMap.putAll(flowMap.delegateMap);
        return Intrinsics.areEqual((Object)flowMap.delegateMap, (Object)this.delegateMap);
    }

    @NotNull
    public final CPValue computeValue(@NotNull Value sootValue) {
        Intrinsics.checkNotNullParameter((Object)sootValue, (String)"sootValue");
        Value value = sootValue;
        if (value instanceof Local) {
            return this.get((Local)sootValue);
        }
        if (value instanceof IntConstant) {
            return CPValue.Companion.makeConstant(((IntConstant)sootValue).value);
        }
        if (value instanceof BinopExpr) {
            Value op1 = ((BinopExpr)sootValue).getOp1();
            Intrinsics.checkNotNull((Object)op1);
            CPValue op1Val = this.computeValue(op1);
            Value op2 = ((BinopExpr)sootValue).getOp2();
            Intrinsics.checkNotNull((Object)op2);
            CPValue op2Val = this.computeValue(op2);
            if (op1Val == CPValue.Companion.getUndef() && op2Val == CPValue.Companion.getUndef()) {
                return CPValue.Companion.getUndef();
            }
            if (op1Val == CPValue.Companion.getUndef() || op2Val == CPValue.Companion.getUndef()) {
                return CPValue.Companion.getNac();
            }
            if (op1Val == CPValue.Companion.getNac() || op2Val == CPValue.Companion.getNac()) {
                return CPValue.Companion.getNac();
            }
            try {
                BinopExpr binopExpr = (BinopExpr)sootValue;
                return binopExpr instanceof AddExpr ? CPValue.Companion.makeConstant(op1Val.value() + op2Val.value()) : (binopExpr instanceof SubExpr ? CPValue.Companion.makeConstant(op1Val.value() - op2Val.value()) : (binopExpr instanceof MulExpr ? CPValue.Companion.makeConstant(op1Val.value() * op2Val.value()) : (binopExpr instanceof DivExpr ? CPValue.Companion.makeConstant(op1Val.value() / op2Val.value()) : (binopExpr instanceof EqExpr ? CPValue.Companion.makeConstant(op1Val.value() == op2Val.value()) : (binopExpr instanceof NeExpr ? CPValue.Companion.makeConstant(op1Val.value() != op2Val.value()) : (binopExpr instanceof GeExpr ? CPValue.Companion.makeConstant(op1Val.value() >= op2Val.value()) : (binopExpr instanceof GtExpr ? CPValue.Companion.makeConstant(op1Val.value() > op2Val.value()) : (binopExpr instanceof LeExpr ? CPValue.Companion.makeConstant(op1Val.value() <= op2Val.value()) : (binopExpr instanceof LtExpr ? CPValue.Companion.makeConstant(op1Val.value() < op2Val.value()) : CPValue.Companion.getNac())))))))));
            }
            catch (ArithmeticException arithmeticException) {
                return CPValue.Companion.getNac();
            }
        }
        return CPValue.Companion.getNac();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(this.getClass(), other.getClass())) {
            return false;
        }
        FlowMap flowMap = (FlowMap)other;
        return Intrinsics.areEqual((Object)this.delegateMap, (Object)flowMap.delegateMap);
    }

    public int hashCode() {
        Object[] objectArray = new Object[]{this.delegateMap};
        return Objects.hash(objectArray);
    }

    @NotNull
    public String toString() {
        return this.delegateMap.toString();
    }

    @JvmOverloads
    public FlowMap() {
        this(null, 1, null);
    }

    private static final CPValue get$lambda$0(Local l) {
        Intrinsics.checkNotNullParameter((Object)l, (String)"l");
        return CPValue.Companion.getUndef();
    }
}

