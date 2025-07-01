package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.IValue;
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
import java.util.function.Consumer;

public final class FactValuesKt {
    private static final boolean leastExpr = true;

    public static boolean getLeastExpr() {
        return leastExpr;
    }

    @Nullable
    public static Boolean getBooleanValue(@NotNull IValue value, boolean checkType) {
        if (checkType && value.typeIsConcrete() && !value.getType().equals(G.v().soot_BooleanType())) {
            return null;
        }
        if (!(value instanceof ConstVal)) {
            return null;
        }
        Constant constant = ((ConstVal) value).getV();
        if (!(constant instanceof IntConstant)) {
            return null;
        }
        return ((IntConstant) constant).value == 1;
    }

    public static Boolean getBooleanValue(@NotNull IValue value) {
        return getBooleanValue(value, true);
    }

    @Nullable
    public static Integer getIntValue(@NotNull IValue value, boolean checkType) {
        if (checkType && value.typeIsConcrete() && !value.getType().equals(G.v().soot_IntType())) {
            return null;
        }
        if (!(value instanceof ConstVal)) {
            return null;
        }
        Constant constant = ((ConstVal) value).getV();
        if (!(constant instanceof IntConstant)) {
            return null;
        }
        return ((IntConstant) constant).value;
    }

    public static Integer getIntValue(@NotNull IValue value) {
        return getIntValue(value, true);
    }

    @Nullable
    public static Long getLongValue(@NotNull IValue value, boolean checkType) {
        if (checkType && value.typeIsConcrete() && !value.getType().equals(G.v().soot_LongType())) {
            return null;
        }
        if (!(value instanceof ConstVal)) {
            return null;
        }
        Constant constant = ((ConstVal) value).getV();
        if (!(constant instanceof LongConstant)) {
            return null;
        }
        return ((LongConstant) constant).value;
    }

    public static Long getLongValue(@NotNull IValue value) {
        return getLongValue(value, true);
    }

    @Nullable
    public static Byte getByteValue(@NotNull IValue value, boolean checkType) {
        if (checkType && value.typeIsConcrete() && !value.getType().equals(G.v().soot_ByteType())) {
            return null;
        }
        if (!(value instanceof ConstVal)) {
            return null;
        }
        Constant constant = ((ConstVal) value).getV();
        if (!(constant instanceof IntConstant)) {
            return null;
        }
        return (byte) ((IntConstant) constant).value;
    }

    public static Byte getByteValue(@NotNull IValue value) {
        return getByteValue(value, true);
    }

    @Nullable
    public static Float getFloatValue(@NotNull IValue value, boolean checkType) {
        if (checkType && value.typeIsConcrete() && !value.getType().equals(G.v().soot_FloatType())) {
            return null;
        }
        if (!(value instanceof ConstVal)) {
            return null;
        }
        Constant constant = ((ConstVal) value).getV();
        if (!(constant instanceof FloatConstant)) {
            return null;
        }
        return ((FloatConstant) constant).value;
    }

    public static Float getFloatValue(@NotNull IValue value) {
        return getFloatValue(value, true);
    }

    @Nullable
    public static Double getDoubleValue(@NotNull IValue value, boolean checkType) {
        if (checkType && value.typeIsConcrete() && !value.getType().equals(G.v().soot_DoubleType())) {
            return null;
        }
        if (!(value instanceof ConstVal)) {
            return null;
        }
        Constant constant = ((ConstVal) value).getV();
        if (!(constant instanceof DoubleConstant)) {
            return null;
        }
        return ((DoubleConstant) constant).value;
    }

    public static Double getDoubleValue(@NotNull IValue value) {
        return getDoubleValue(value, true);
    }

    @Nullable
    public static String getStringValue(@NotNull IValue value, boolean checkType) {
        if (checkType && value.typeIsConcrete() && !value.getType().equals(RefType.v("java.lang.String"))) {
            return null;
        }
        if (!(value instanceof ConstVal)) {
            return null;
        }
        Constant constant = ((ConstVal) value).getV();
        if (!(constant instanceof StringConstant)) {
            return null;
        }
        return ((StringConstant) constant).value;
    }

    public static String getStringValue(@NotNull IValue value) {
        return getStringValue(value, true);
    }

    @Nullable
    public static Type getClassValue(@NotNull IValue value, boolean checkType) {
        if (checkType && value.typeIsConcrete() && !value.getType().equals(RefType.v("java.lang.Class"))) {
            return null;
        }
        if (!(value instanceof ConstVal)) {
            return null;
        }
        Constant constant = ((ConstVal) value).getV();
        if (!(constant instanceof ClassConstant)) {
            return null;
        }
        return ((ClassConstant) constant).toSootType();
    }

    public static Type getClassValue(@NotNull IValue value) {
        return getClassValue(value, true);
    }

    public static void getAnyValue(@NotNull IValue value, @NotNull Consumer<Object> res) {
        if (!(value instanceof ConstVal)) {
            return;
        }
        Constant constant = ((ConstVal) value).getV();
        if (constant == null) {
            return;
        }

        if (constant instanceof IntConstant) {
            res.accept(((IntConstant) constant).value);
        } else if (constant instanceof StringConstant) {
            res.accept(((StringConstant) constant).value);
        } else if (constant instanceof LongConstant) {
            res.accept(((LongConstant) constant).value);
        } else if (constant instanceof NullConstant) {
            res.accept(null);
        } else if (constant instanceof DoubleConstant) {
            res.accept(((DoubleConstant) constant).value);
        } else if (constant instanceof FloatConstant) {
            res.accept(((FloatConstant) constant).value);
        } else if (constant instanceof ClassConstant) {
            res.accept(((ClassConstant) constant).value);
        } else if (constant instanceof UntypedIntOrFloatConstant) {
            res.accept(((UntypedIntOrFloatConstant) constant).value);
        } else if (constant instanceof UntypedLongOrDoubleConstant) {
            res.accept(((UntypedLongOrDoubleConstant) constant).value);
        }
    }

    @Nullable
    public static Boolean isNull(@NotNull IValue value) {
        if (!(value instanceof ConstVal)) {
            return null;
        }
        return ((ConstVal) value).getV() instanceof NullConstant;
    }
}