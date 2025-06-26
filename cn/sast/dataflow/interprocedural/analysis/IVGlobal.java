/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv
 *  cn.sast.dataflow.interprocedural.analysis.GlobalStaticObject
 *  cn.sast.dataflow.interprocedural.analysis.IVGlobal
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.util.SootUtilsKt
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.ArrayType
 *  soot.DoubleType
 *  soot.FloatType
 *  soot.G
 *  soot.IntegerType
 *  soot.Local
 *  soot.LongType
 *  soot.NullType
 *  soot.RefLikeType
 *  soot.RefType
 *  soot.Scene
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.jimple.Constant
 *  soot.jimple.DoubleConstant
 *  soot.jimple.FloatConstant
 *  soot.jimple.IntConstant
 *  soot.jimple.Jimple
 *  soot.jimple.LongConstant
 *  soot.jimple.NopStmt
 *  soot.jimple.NullConstant
 *  soot.jimple.internal.JimpleLocal
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.dataflow.interprocedural.analysis.AnyNewExprEnv;
import cn.sast.dataflow.interprocedural.analysis.GlobalStaticObject;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.util.SootUtilsKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.ArrayType;
import soot.DoubleType;
import soot.FloatType;
import soot.G;
import soot.IntegerType;
import soot.Local;
import soot.LongType;
import soot.NullType;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.jimple.Constant;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.IntConstant;
import soot.jimple.Jimple;
import soot.jimple.LongConstant;
import soot.jimple.NopStmt;
import soot.jimple.NullConstant;
import soot.jimple.internal.JimpleLocal;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010H\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K0I2\u0006\u0010L\u001a\u00020\u0019J\u001a\u0010M\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K0I2\u0006\u0010N\u001a\u00020KR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010 \u001a\u00020!\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001b\u0010(\u001a\n **\u0004\u0018\u00010)0)\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\n **\u0004\u0018\u00010/0/\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u001b\u00103\u001a\n **\u0004\u0018\u00010404\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u001b\u00108\u001a\n **\u0004\u0018\u00010909\u00a2\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u001b\u0010=\u001a\n **\u0004\u0018\u00010>0>\u00a2\u0006\n\n\u0002\u0010A\u001a\u0004\b?\u0010@R\u001a\u0010B\u001a\u00020CX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u00a8\u0006O"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/IVGlobal;", "", "GLOBAL_SITE", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "<init>", "(Lcn/sast/dataflow/interprocedural/analysis/IValue;)V", "getGLOBAL_SITE", "()Lcn/sast/dataflow/interprocedural/analysis/IValue;", "GLOBAL_LOCAL", "", "getGLOBAL_LOCAL", "()Ljava/lang/String;", "RETURN_LOCAL", "getRETURN_LOCAL", "SUMMARY_ETURN_LOCAL", "Lsoot/Local;", "getSUMMARY_ETURN_LOCAL", "()Lsoot/Local;", "STRING_TYPE", "Lsoot/RefType;", "getSTRING_TYPE", "()Lsoot/RefType;", "OBJECT_TYPE", "getOBJECT_TYPE", "BYTE_ARRAY_TYPE", "Lsoot/ArrayType;", "getBYTE_ARRAY_TYPE", "()Lsoot/ArrayType;", "OBJ_ARRAY_TYPE", "getOBJ_ARRAY_TYPE", "CLASS_TYPE", "getCLASS_TYPE", "NOP", "Lsoot/Unit;", "getNOP", "()Lsoot/Unit;", "NEW_Env", "Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "getNEW_Env", "()Lcn/sast/dataflow/interprocedural/analysis/AnyNewExprEnv;", "NULL_CONST", "Lsoot/jimple/NullConstant;", "kotlin.jvm.PlatformType", "getNULL_CONST", "()Lsoot/jimple/NullConstant;", "Lsoot/jimple/NullConstant;", "INT_ZERO_CONST", "Lsoot/jimple/IntConstant;", "getINT_ZERO_CONST", "()Lsoot/jimple/IntConstant;", "Lsoot/jimple/IntConstant;", "DOUBLE_ZERO_CONST", "Lsoot/jimple/DoubleConstant;", "getDOUBLE_ZERO_CONST", "()Lsoot/jimple/DoubleConstant;", "Lsoot/jimple/DoubleConstant;", "Float_ZERO_CONST", "Lsoot/jimple/FloatConstant;", "getFloat_ZERO_CONST", "()Lsoot/jimple/FloatConstant;", "Lsoot/jimple/FloatConstant;", "Long_ZERO_CONST", "Lsoot/jimple/LongConstant;", "getLong_ZERO_CONST", "()Lsoot/jimple/LongConstant;", "Lsoot/jimple/LongConstant;", "staticFieldTrackingMode", "Lcn/sast/api/config/StaticFieldTrackingMode;", "getStaticFieldTrackingMode", "()Lcn/sast/api/config/StaticFieldTrackingMode;", "setStaticFieldTrackingMode", "(Lcn/sast/api/config/StaticFieldTrackingMode;)V", "zeroValue", "Lkotlin/Pair;", "Lsoot/jimple/Constant;", "Lsoot/Type;", "array", "defaultValue", "type", "corax-data-flow"})
public final class IVGlobal {
    @NotNull
    private final IValue GLOBAL_SITE;
    @NotNull
    private final String GLOBAL_LOCAL;
    @NotNull
    private final String RETURN_LOCAL;
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
        Intrinsics.checkNotNullParameter((Object)GLOBAL_SITE, (String)"GLOBAL_SITE");
        this.GLOBAL_SITE = GLOBAL_SITE;
        this.GLOBAL_LOCAL = "@global";
        this.RETURN_LOCAL = "@return";
        this.SUMMARY_ETURN_LOCAL = (Local)new JimpleLocal("@SummaryReturn", (Type)Scene.v().getObjectType());
        RefType refType = RefType.v((String)"java.lang.String");
        Intrinsics.checkNotNullExpressionValue((Object)refType, (String)"v(...)");
        this.STRING_TYPE = refType;
        RefType refType2 = Scene.v().getObjectType();
        Intrinsics.checkNotNullExpressionValue((Object)refType2, (String)"getObjectType(...)");
        this.OBJECT_TYPE = refType2;
        ArrayType arrayType = ArrayType.v((Type)((Type)G.v().soot_ByteType()), (int)1);
        Intrinsics.checkNotNullExpressionValue((Object)arrayType, (String)"v(...)");
        this.BYTE_ARRAY_TYPE = arrayType;
        ArrayType arrayType2 = ArrayType.v((Type)((Type)this.OBJECT_TYPE), (int)1);
        Intrinsics.checkNotNullExpressionValue((Object)arrayType2, (String)"v(...)");
        this.OBJ_ARRAY_TYPE = arrayType2;
        RefType refType3 = RefType.v((String)"java.lang.Class");
        Intrinsics.checkNotNullExpressionValue((Object)refType3, (String)"v(...)");
        this.CLASS_TYPE = refType3;
        NopStmt nopStmt = Jimple.v().newNopStmt();
        Intrinsics.checkNotNullExpressionValue((Object)nopStmt, (String)"newNopStmt(...)");
        this.NOP = (Unit)nopStmt;
        SootMethod sootMethod = SootUtilsKt.sootSignatureToRef((String)"<java.lang.String: void <clinit>()>", (boolean)true).resolve();
        Intrinsics.checkNotNullExpressionValue((Object)sootMethod, (String)"resolve(...)");
        this.NEW_Env = new AnyNewExprEnv(sootMethod, this.NOP);
        this.NULL_CONST = NullConstant.v();
        this.INT_ZERO_CONST = IntConstant.v((int)0);
        this.DOUBLE_ZERO_CONST = DoubleConstant.v((double)0.0);
        this.Float_ZERO_CONST = FloatConstant.v((float)0.0f);
        this.Long_ZERO_CONST = LongConstant.v((long)0L);
        this.staticFieldTrackingMode = StaticFieldTrackingMode.ContextFlowSensitive;
    }

    public /* synthetic */ IVGlobal(IValue iValue, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            iValue = (IValue)new GlobalStaticObject();
        }
        this(iValue);
    }

    @NotNull
    public final IValue getGLOBAL_SITE() {
        return this.GLOBAL_SITE;
    }

    @NotNull
    public final String getGLOBAL_LOCAL() {
        return this.GLOBAL_LOCAL;
    }

    @NotNull
    public final String getRETURN_LOCAL() {
        return this.RETURN_LOCAL;
    }

    @NotNull
    public final Local getSUMMARY_ETURN_LOCAL() {
        return this.SUMMARY_ETURN_LOCAL;
    }

    @NotNull
    public final RefType getSTRING_TYPE() {
        return this.STRING_TYPE;
    }

    @NotNull
    public final RefType getOBJECT_TYPE() {
        return this.OBJECT_TYPE;
    }

    @NotNull
    public final ArrayType getBYTE_ARRAY_TYPE() {
        return this.BYTE_ARRAY_TYPE;
    }

    @NotNull
    public final ArrayType getOBJ_ARRAY_TYPE() {
        return this.OBJ_ARRAY_TYPE;
    }

    @NotNull
    public final RefType getCLASS_TYPE() {
        return this.CLASS_TYPE;
    }

    @NotNull
    public final Unit getNOP() {
        return this.NOP;
    }

    @NotNull
    public final AnyNewExprEnv getNEW_Env() {
        return this.NEW_Env;
    }

    public final NullConstant getNULL_CONST() {
        return this.NULL_CONST;
    }

    public final IntConstant getINT_ZERO_CONST() {
        return this.INT_ZERO_CONST;
    }

    public final DoubleConstant getDOUBLE_ZERO_CONST() {
        return this.DOUBLE_ZERO_CONST;
    }

    public final FloatConstant getFloat_ZERO_CONST() {
        return this.Float_ZERO_CONST;
    }

    public final LongConstant getLong_ZERO_CONST() {
        return this.Long_ZERO_CONST;
    }

    @NotNull
    public StaticFieldTrackingMode getStaticFieldTrackingMode() {
        return this.staticFieldTrackingMode;
    }

    public void setStaticFieldTrackingMode(@NotNull StaticFieldTrackingMode staticFieldTrackingMode) {
        Intrinsics.checkNotNullParameter((Object)staticFieldTrackingMode, (String)"<set-?>");
        this.staticFieldTrackingMode = staticFieldTrackingMode;
    }

    @NotNull
    public final Pair<Constant, Type> zeroValue(@NotNull ArrayType array) {
        Intrinsics.checkNotNullParameter((Object)array, (String)"array");
        Type type = array.getElementType();
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getElementType(...)");
        return this.defaultValue(type);
    }

    @NotNull
    public final Pair<Constant, Type> defaultValue(@NotNull Type type) {
        Pair pair;
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Type type2 = type;
        if (type2 instanceof RefLikeType) {
            pair = TuplesKt.to((Object)this.NULL_CONST, (Object)NullType.v());
        } else if (type2 instanceof IntegerType) {
            pair = TuplesKt.to((Object)this.INT_ZERO_CONST, (Object)type);
        } else if (type2 instanceof DoubleType) {
            pair = TuplesKt.to((Object)this.DOUBLE_ZERO_CONST, (Object)type);
        } else if (type2 instanceof FloatType) {
            pair = TuplesKt.to((Object)this.Float_ZERO_CONST, (Object)type);
        } else if (type2 instanceof LongType) {
            pair = TuplesKt.to((Object)this.Long_ZERO_CONST, (Object)type);
        } else {
            String string = "error type of " + this;
            throw new NotImplementedError("An operation is not implemented: " + string);
        }
        return pair;
    }

    public IVGlobal() {
        this(null, 1, null);
    }
}

