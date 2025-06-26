/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.ConstVal
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.G
 *  soot.RefType
 *  soot.Type
 *  soot.dexpler.typing.UntypedIntOrFloatConstant
 *  soot.dexpler.typing.UntypedLongOrDoubleConstant
 *  soot.jimple.ClassConstant
 *  soot.jimple.Constant
 *  soot.jimple.DoubleConstant
 *  soot.jimple.FloatConstant
 *  soot.jimple.IntConstant
 *  soot.jimple.LongConstant
 *  soot.jimple.NullConstant
 *  soot.jimple.StringConstant
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.G;
import soot.RefType;
import soot.Type;
import soot.dexpler.typing.UntypedIntOrFloatConstant;
import soot.dexpler.typing.UntypedLongOrDoubleConstant;
import soot.jimple.ClassConstant;
import soot.jimple.Constant;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.IntConstant;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.StringConstant;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000X\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0007\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\n\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\r\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u001b\u001a\u00020\u001c*\u00020\u00052\u0014\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u001c0\u001eH\u0086\b\u00f8\u0001\u0000\u001a\u0011\u0010 \u001a\u0004\u0018\u00010\u0001*\u00020\u0005\u00a2\u0006\u0002\u0010!\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\""}, d2={"leastExpr", "", "getLeastExpr", "()Z", "getBooleanValue", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "checkType", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Z)Ljava/lang/Boolean;", "getIntValue", "", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Z)Ljava/lang/Integer;", "getLongValue", "", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Z)Ljava/lang/Long;", "getByteValue", "", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Z)Ljava/lang/Byte;", "getFloatValue", "", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Z)Ljava/lang/Float;", "getDoubleValue", "", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;Z)Ljava/lang/Double;", "getStringValue", "", "getClassValue", "Lsoot/Type;", "getAnyValue", "", "res", "Lkotlin/Function1;", "", "isNull", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;)Ljava/lang/Boolean;", "corax-data-flow"})
public final class FactValuesKt {
    private static final boolean leastExpr = true;

    public static final boolean getLeastExpr() {
        return leastExpr;
    }

    @Nullable
    public static final Boolean getBooleanValue(@NotNull IValue $this$getBooleanValue, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)$this$getBooleanValue, (String)"<this>");
        if (checkType && $this$getBooleanValue.typeIsConcrete() && !Intrinsics.areEqual((Object)$this$getBooleanValue.getType(), (Object)G.v().soot_BooleanType())) {
            return null;
        }
        ConstVal constVal = $this$getBooleanValue instanceof ConstVal ? (ConstVal)$this$getBooleanValue : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        IntConstant intConstant = constant instanceof IntConstant ? (IntConstant)constant : null;
        if (intConstant == null) {
            return null;
        }
        int num = intConstant.value;
        return num == 1;
    }

    public static /* synthetic */ Boolean getBooleanValue$default(IValue iValue, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return FactValuesKt.getBooleanValue((IValue)iValue, (boolean)bl);
    }

    @Nullable
    public static final Integer getIntValue(@NotNull IValue $this$getIntValue, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)$this$getIntValue, (String)"<this>");
        if (checkType && $this$getIntValue.typeIsConcrete() && !Intrinsics.areEqual((Object)$this$getIntValue.getType(), (Object)G.v().soot_IntType())) {
            return null;
        }
        ConstVal constVal = $this$getIntValue instanceof ConstVal ? (ConstVal)$this$getIntValue : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        IntConstant intConstant = constant instanceof IntConstant ? (IntConstant)constant : null;
        if (intConstant == null) {
            return null;
        }
        return intConstant.value;
    }

    public static /* synthetic */ Integer getIntValue$default(IValue iValue, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return FactValuesKt.getIntValue((IValue)iValue, (boolean)bl);
    }

    @Nullable
    public static final Long getLongValue(@NotNull IValue $this$getLongValue, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)$this$getLongValue, (String)"<this>");
        if (checkType && $this$getLongValue.typeIsConcrete() && !Intrinsics.areEqual((Object)$this$getLongValue.getType(), (Object)G.v().soot_LongType())) {
            return null;
        }
        ConstVal constVal = $this$getLongValue instanceof ConstVal ? (ConstVal)$this$getLongValue : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        LongConstant longConstant = constant instanceof LongConstant ? (LongConstant)constant : null;
        if (longConstant == null) {
            return null;
        }
        return longConstant.value;
    }

    public static /* synthetic */ Long getLongValue$default(IValue iValue, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return FactValuesKt.getLongValue((IValue)iValue, (boolean)bl);
    }

    @Nullable
    public static final Byte getByteValue(@NotNull IValue $this$getByteValue, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)$this$getByteValue, (String)"<this>");
        if (checkType && $this$getByteValue.typeIsConcrete() && !Intrinsics.areEqual((Object)$this$getByteValue.getType(), (Object)G.v().soot_ByteType())) {
            return null;
        }
        ConstVal constVal = $this$getByteValue instanceof ConstVal ? (ConstVal)$this$getByteValue : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        IntConstant intConstant = constant instanceof IntConstant ? (IntConstant)constant : null;
        if (intConstant == null) {
            return null;
        }
        return (byte)intConstant.value;
    }

    public static /* synthetic */ Byte getByteValue$default(IValue iValue, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return FactValuesKt.getByteValue((IValue)iValue, (boolean)bl);
    }

    @Nullable
    public static final Float getFloatValue(@NotNull IValue $this$getFloatValue, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)$this$getFloatValue, (String)"<this>");
        if (checkType && $this$getFloatValue.typeIsConcrete() && !Intrinsics.areEqual((Object)$this$getFloatValue.getType(), (Object)G.v().soot_FloatType())) {
            return null;
        }
        ConstVal constVal = $this$getFloatValue instanceof ConstVal ? (ConstVal)$this$getFloatValue : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        FloatConstant floatConstant = constant instanceof FloatConstant ? (FloatConstant)constant : null;
        if (floatConstant == null) {
            return null;
        }
        return Float.valueOf(floatConstant.value);
    }

    public static /* synthetic */ Float getFloatValue$default(IValue iValue, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return FactValuesKt.getFloatValue((IValue)iValue, (boolean)bl);
    }

    @Nullable
    public static final Double getDoubleValue(@NotNull IValue $this$getDoubleValue, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)$this$getDoubleValue, (String)"<this>");
        if (checkType && $this$getDoubleValue.typeIsConcrete() && !Intrinsics.areEqual((Object)$this$getDoubleValue.getType(), (Object)G.v().soot_DoubleType())) {
            return null;
        }
        ConstVal constVal = $this$getDoubleValue instanceof ConstVal ? (ConstVal)$this$getDoubleValue : null;
        Constant constant = constVal != null ? constVal.getV() : null;
        DoubleConstant doubleConstant = constant instanceof DoubleConstant ? (DoubleConstant)constant : null;
        if (doubleConstant == null) {
            return null;
        }
        return doubleConstant.value;
    }

    public static /* synthetic */ Double getDoubleValue$default(IValue iValue, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return FactValuesKt.getDoubleValue((IValue)iValue, (boolean)bl);
    }

    @Nullable
    public static final String getStringValue(@NotNull IValue $this$getStringValue, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)$this$getStringValue, (String)"<this>");
        if (checkType && $this$getStringValue.typeIsConcrete() && !Intrinsics.areEqual((Object)$this$getStringValue.getType(), (Object)RefType.v((String)"java.lang.String"))) {
            return null;
        }
        ConstVal constVal = $this$getStringValue instanceof ConstVal ? (ConstVal)$this$getStringValue : null;
        Object object = constVal != null ? constVal.getV() : null;
        Object object2 = object instanceof StringConstant ? (StringConstant)object : null;
        if (object2 == null || (object2 = object2.value) == null) {
            return null;
        }
        return object2;
    }

    public static /* synthetic */ String getStringValue$default(IValue iValue, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return FactValuesKt.getStringValue((IValue)iValue, (boolean)bl);
    }

    @Nullable
    public static final Type getClassValue(@NotNull IValue $this$getClassValue, boolean checkType) {
        Intrinsics.checkNotNullParameter((Object)$this$getClassValue, (String)"<this>");
        if (checkType && $this$getClassValue.typeIsConcrete() && !Intrinsics.areEqual((Object)$this$getClassValue.getType(), (Object)RefType.v((String)"java.lang.Class"))) {
            return null;
        }
        ConstVal constVal = $this$getClassValue instanceof ConstVal ? (ConstVal)$this$getClassValue : null;
        Object object = constVal != null ? constVal.getV() : null;
        ClassConstant classConstant = object instanceof ClassConstant ? (ClassConstant)object : null;
        if (classConstant == null || (classConstant = classConstant.toSootType()) == null) {
            return null;
        }
        return classConstant;
    }

    public static /* synthetic */ Type getClassValue$default(IValue iValue, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return FactValuesKt.getClassValue((IValue)iValue, (boolean)bl);
    }

    public static final void getAnyValue(@NotNull IValue $this$getAnyValue, @NotNull Function1<Object, Unit> res) {
        Constant v;
        Intrinsics.checkNotNullParameter((Object)$this$getAnyValue, (String)"<this>");
        Intrinsics.checkNotNullParameter(res, (String)"res");
        boolean $i$f$getAnyValue = false;
        ConstVal constVal = $this$getAnyValue instanceof ConstVal ? (ConstVal)$this$getAnyValue : null;
        Object object = v = constVal != null ? constVal.getV() : null;
        if (v != null) {
            if (v instanceof IntConstant) {
                res.invoke((Object)((IntConstant)v).value);
            } else if (v instanceof StringConstant) {
                res.invoke((Object)((StringConstant)v).value);
            } else if (v instanceof LongConstant) {
                res.invoke((Object)((LongConstant)v).value);
            } else if (v instanceof NullConstant) {
                res.invoke(null);
            } else if (v instanceof DoubleConstant) {
                res.invoke((Object)((DoubleConstant)v).value);
            } else if (v instanceof FloatConstant) {
                res.invoke((Object)Float.valueOf(((FloatConstant)v).value));
            } else if (v instanceof ClassConstant) {
                res.invoke((Object)((ClassConstant)v).value);
            } else if (v instanceof UntypedIntOrFloatConstant) {
                res.invoke((Object)((UntypedIntOrFloatConstant)v).value);
            } else if (v instanceof UntypedLongOrDoubleConstant) {
                res.invoke((Object)((UntypedLongOrDoubleConstant)v).value);
            }
        }
    }

    @Nullable
    public static final Boolean isNull(@NotNull IValue $this$isNull) {
        Intrinsics.checkNotNullParameter((Object)$this$isNull, (String)"<this>");
        return $this$isNull instanceof ConstVal ? Boolean.valueOf(((ConstVal)$this$isNull).getV() instanceof NullConstant) : null;
    }
}

