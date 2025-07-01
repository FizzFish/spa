package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.GlobalStaticObject;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.util.SootUtilsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.NotImplementedError;
import org.jetbrains.annotations.NotNull;
import soot.*;
import soot.jimple.*;
import soot.jimple.internal.JimpleLocal;

public final class IVGlobal {
    @NotNull
    private final IValue GLOBAL_SITE;
    @NotNull
    private final String GLOBAL_LOCAL = "@global";
    @NotNull
    private final String RETURN_LOCAL = "@return";
    @NotNull
    private final Local SUMMARY_ETURN_LOCAL;
    @NotNull
    private final RefType STRING_TYPE;
    @NotNull
    private final RefType OBJECT_TYPE;
    @NotNull
    private final ArrayType BYTE_ARRAY_TYPE;
    @NotNull
    private final ArrayType OBJ_ARRAY_TYPE;
    @NotNull
    private final RefType CLASS_TYPE;
    @NotNull
    private final Unit NOP;
    @NotNull
    private final AnyNewExprEnv NEW_Env;
    private final NullConstant NULL_CONST;
    private final IntConstant INT_ZERO_CONST;
    private final DoubleConstant DOUBLE_ZERO_CONST;
    private final FloatConstant Float_ZERO_CONST;
    private final LongConstant Long_ZERO_CONST;
    @NotNull
    private StaticFieldTrackingMode staticFieldTrackingMode;

    public IVGlobal(@NotNull IValue GLOBAL_SITE) {
        if (GLOBAL_SITE == null) {
            throw new IllegalArgumentException("GLOBAL_SITE cannot be null");
        }
        this.GLOBAL_SITE = GLOBAL_SITE;
        this.SUMMARY_ETURN_LOCAL = new JimpleLocal("@SummaryReturn", Scene.v().getObjectType());
        this.STRING_TYPE = RefType.v("java.lang.String");
        this.OBJECT_TYPE = Scene.v().getObjectType();
        this.BYTE_ARRAY_TYPE = ArrayType.v(G.v().soot_ByteType(), 1);
        this.OBJ_ARRAY_TYPE = ArrayType.v(this.OBJECT_TYPE, 1);
        this.CLASS_TYPE = RefType.v("java.lang.Class");
        this.NOP = Jimple.v().newNopStmt();
        SootMethod sootMethod = SootUtilsKt.sootSignatureToRef("<java.lang.String: void <clinit>()>", true).resolve();
        this.NEW_Env = new AnyNewExprEnv(sootMethod, this.NOP);
        this.NULL_CONST = NullConstant.v();
        this.INT_ZERO_CONST = IntConstant.v(0);
        this.DOUBLE_ZERO_CONST = DoubleConstant.v(0.0);
        this.Float_ZERO_CONST = FloatConstant.v(0.0f);
        this.Long_ZERO_CONST = LongConstant.v(0L);
        this.staticFieldTrackingMode = StaticFieldTrackingMode.ContextFlowSensitive;
    }

    public IVGlobal() {
        this(new GlobalStaticObject());
    }

    @NotNull
    public IValue getGLOBAL_SITE() {
        return GLOBAL_SITE;
    }

    @NotNull
    public String getGLOBAL_LOCAL() {
        return GLOBAL_LOCAL;
    }

    @NotNull
    public String getRETURN_LOCAL() {
        return RETURN_LOCAL;
    }

    @NotNull
    public Local getSUMMARY_ETURN_LOCAL() {
        return SUMMARY_ETURN_LOCAL;
    }

    @NotNull
    public RefType getSTRING_TYPE() {
        return STRING_TYPE;
    }

    @NotNull
    public RefType getOBJECT_TYPE() {
        return OBJECT_TYPE;
    }

    @NotNull
    public ArrayType getBYTE_ARRAY_TYPE() {
        return BYTE_ARRAY_TYPE;
    }

    @NotNull
    public ArrayType getOBJ_ARRAY_TYPE() {
        return OBJ_ARRAY_TYPE;
    }

    @NotNull
    public RefType getCLASS_TYPE() {
        return CLASS_TYPE;
    }

    @NotNull
    public Unit getNOP() {
        return NOP;
    }

    @NotNull
    public AnyNewExprEnv getNEW_Env() {
        return NEW_Env;
    }

    public NullConstant getNULL_CONST() {
        return NULL_CONST;
    }

    public IntConstant getINT_ZERO_CONST() {
        return INT_ZERO_CONST;
    }

    public DoubleConstant getDOUBLE_ZERO_CONST() {
        return DOUBLE_ZERO_CONST;
    }

    public FloatConstant getFloat_ZERO_CONST() {
        return Float_ZERO_CONST;
    }

    public LongConstant getLong_ZERO_CONST() {
        return Long_ZERO_CONST;
    }

    @NotNull
    public StaticFieldTrackingMode getStaticFieldTrackingMode() {
        return staticFieldTrackingMode;
    }

    public void setStaticFieldTrackingMode(@NotNull StaticFieldTrackingMode staticFieldTrackingMode) {
        if (staticFieldTrackingMode == null) {
            throw new IllegalArgumentException("staticFieldTrackingMode cannot be null");
        }
        this.staticFieldTrackingMode = staticFieldTrackingMode;
    }

    @NotNull
    public Pair<Constant, Type> zeroValue(@NotNull ArrayType array) {
        if (array == null) {
            throw new IllegalArgumentException("array cannot be null");
        }
        Type type = array.getElementType();
        return defaultValue(type);
    }

    @NotNull
    public Pair<Constant, Type> defaultValue(@NotNull Type type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        
        if (type instanceof RefLikeType) {
            return TuplesKt.to(NULL_CONST, NullType.v());
        } else if (type instanceof IntegerType) {
            return TuplesKt.to(INT_ZERO_CONST, type);
        } else if (type instanceof DoubleType) {
            return TuplesKt.to(DOUBLE_ZERO_CONST, type);
        } else if (type instanceof FloatType) {
            return TuplesKt.to(Float_ZERO_CONST, type);
        } else if (type instanceof LongType) {
            return TuplesKt.to(Long_ZERO_CONST, type);
        } else {
            throw new NotImplementedError("An operation is not implemented: error type of " + this);
        }
    }
}