/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.dataflow.util.SootUtilsKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.Body
 *  soot.Local
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethodRef
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.IdentityRef
 *  soot.jimple.IdentityStmt
 *  soot.jimple.InstanceInvokeExpr
 *  soot.jimple.InvokeExpr
 *  soot.jimple.ParameterRef
 *  soot.jimple.ThisRef
 *  soot.jimple.infoflow.data.SootMethodAndClass
 *  soot.jimple.infoflow.util.SootMethodRepresentationParser
 */
package cn.sast.dataflow.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.Body;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.IdentityRef;
import soot.jimple.IdentityStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.ParameterRef;
import soot.jimple.ThisRef;
import soot.jimple.infoflow.data.SootMethodAndClass;
import soot.jimple.infoflow.util.SootMethodRepresentationParser;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u001e\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0007*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0007*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f\u001a\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\t\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0007*\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"!\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0007*\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010\"!\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0007*\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2={"sootSignatureToRef", "Lsoot/SootMethodRef;", "signature", "", "isStatic", "", "argToOpAndType", "Lkotlin/Pair;", "Lsoot/Local;", "Lsoot/Type;", "Lsoot/Body;", "index", "", "thisLocalAndType", "Lsoot/RefType;", "getThisLocalAndType", "(Lsoot/Body;)Lkotlin/Pair;", "argToIdentityRef", "Lsoot/jimple/IdentityRef;", "thisIdentityRef", "Lsoot/jimple/ThisRef;", "getThisIdentityRef", "Lsoot/Value;", "Lsoot/jimple/InvokeExpr;", "thisOpAndType", "getThisOpAndType", "(Lsoot/jimple/InvokeExpr;)Lkotlin/Pair;", "getOrMakeField", "Lsoot/SootField;", "sootClass", "fieldName", "sootFieldType", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nSootUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SootUtils.kt\ncn/sast/dataflow/util/SootUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n1#2:60\n*E\n"})
public final class SootUtilsKt {
    @NotNull
    public static final SootMethodRef sootSignatureToRef(@NotNull String signature, boolean isStatic) {
        Intrinsics.checkNotNullParameter((Object)signature, (String)"signature");
        SootMethodAndClass smac = SootMethodRepresentationParser.v().parseSootMethodString(signature);
        SootClass sootClass = Scene.v().getSootClass(smac.getClassName());
        Intrinsics.checkNotNull((Object)sootClass);
        SootClass sc = sootClass;
        Scene scene = Scene.v();
        String string = smac.getMethodName();
        List list = smac.getParameters();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getParameters(...)");
        List list2 = cn.sast.api.util.SootUtilsKt.convertParameterTypes((List)list);
        Type type = Scene.v().getTypeUnsafe(smac.getReturnType(), true);
        Intrinsics.checkNotNull((Object)type);
        SootMethodRef sootMethodRef = scene.makeMethodRef(sc, string, list2, type, isStatic);
        Intrinsics.checkNotNullExpressionValue((Object)sootMethodRef, (String)"makeMethodRef(...)");
        return sootMethodRef;
    }

    @NotNull
    public static final Pair<Local, Type> argToOpAndType(@NotNull Body $this$argToOpAndType, int index) {
        Pair pair;
        Intrinsics.checkNotNullParameter((Object)$this$argToOpAndType, (String)"<this>");
        int n = index;
        if (n == -1) {
            pair = TuplesKt.to((Object)$this$argToOpAndType.getThisLocal(), (Object)$this$argToOpAndType.getMethod().getDeclaringClass().getType());
        } else {
            boolean bl = 0 <= n ? n < $this$argToOpAndType.getMethod().getParameterCount() : false;
            if (bl) {
                pair = TuplesKt.to((Object)$this$argToOpAndType.getParameterLocal(index), (Object)$this$argToOpAndType.getMethod().getParameterType(index));
            } else {
                throw new IllegalStateException(($this$argToOpAndType + " parameterCount: " + $this$argToOpAndType.getMethod().getParameterCount() + ", but index: " + index).toString());
            }
        }
        return pair;
    }

    @NotNull
    public static final Pair<Local, RefType> getThisLocalAndType(@NotNull Body $this$thisLocalAndType) {
        Intrinsics.checkNotNullParameter((Object)$this$thisLocalAndType, (String)"<this>");
        Pair it = SootUtilsKt.argToOpAndType((Body)$this$thisLocalAndType, (int)-1);
        boolean bl = false;
        Object object = it.getFirst();
        Object object2 = it.getSecond();
        Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type soot.RefType");
        return TuplesKt.to((Object)object, (Object)((RefType)object2));
    }

    @NotNull
    public static final Pair<IdentityRef, Type> argToIdentityRef(@NotNull Body $this$argToIdentityRef, int index) {
        Pair pair;
        Intrinsics.checkNotNullParameter((Object)$this$argToIdentityRef, (String)"<this>");
        int n = index;
        if (n == -1) {
            Unit unit = $this$argToIdentityRef.getThisUnit();
            Intrinsics.checkNotNull((Object)unit, (String)"null cannot be cast to non-null type soot.jimple.IdentityStmt");
            Value value = ((IdentityStmt)unit).getRightOp();
            Intrinsics.checkNotNull((Object)value, (String)"null cannot be cast to non-null type soot.jimple.ThisRef");
            ThisRef it = (ThisRef)value;
            boolean bl = false;
            pair = TuplesKt.to((Object)it, (Object)it.getType());
        } else {
            boolean bl = 0 <= n ? n < $this$argToIdentityRef.getMethod().getParameterCount() : false;
            if (bl) {
                Object e = $this$argToIdentityRef.getParameterRefs().get(index);
                Intrinsics.checkNotNull(e, (String)"null cannot be cast to non-null type soot.jimple.ParameterRef");
                ParameterRef it = (ParameterRef)e;
                boolean bl2 = false;
                pair = TuplesKt.to((Object)it, (Object)it.getType());
            } else {
                throw new IllegalStateException(($this$argToIdentityRef + " parameterCount: " + $this$argToIdentityRef.getMethod().getParameterCount() + ", but index: " + index).toString());
            }
        }
        return pair;
    }

    @NotNull
    public static final Pair<ThisRef, RefType> getThisIdentityRef(@NotNull Body $this$thisIdentityRef) {
        Intrinsics.checkNotNullParameter((Object)$this$thisIdentityRef, (String)"<this>");
        IdentityRef it = (IdentityRef)SootUtilsKt.argToIdentityRef((Body)$this$thisIdentityRef, (int)-1).getFirst();
        boolean bl = false;
        Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type soot.jimple.ThisRef");
        ThisRef thisRef = (ThisRef)it;
        Type type = ((ThisRef)it).getType();
        Intrinsics.checkNotNull((Object)type, (String)"null cannot be cast to non-null type soot.RefType");
        return TuplesKt.to((Object)thisRef, (Object)((RefType)type));
    }

    @NotNull
    public static final Pair<Value, Type> argToOpAndType(@NotNull InvokeExpr $this$argToOpAndType, int index) {
        Pair pair;
        Intrinsics.checkNotNullParameter((Object)$this$argToOpAndType, (String)"<this>");
        if (index == -1 && $this$argToOpAndType instanceof InstanceInvokeExpr) {
            Value value = ((InstanceInvokeExpr)$this$argToOpAndType).getBase();
            Intrinsics.checkNotNull((Object)value, (String)"null cannot be cast to non-null type soot.Local");
            pair = TuplesKt.to((Object)((Local)value), (Object)((InstanceInvokeExpr)$this$argToOpAndType).getMethodRef().getDeclaringClass().getType());
        } else {
            boolean bl = 0 <= index ? index < $this$argToOpAndType.getArgCount() : false;
            if (bl) {
                pair = TuplesKt.to((Object)$this$argToOpAndType.getArg(index), (Object)$this$argToOpAndType.getMethodRef().getParameterType(index));
            } else {
                throw new IllegalStateException(($this$argToOpAndType + " parameterCount: " + $this$argToOpAndType.getMethodRef() + ", but index is: " + index).toString());
            }
        }
        return pair;
    }

    @NotNull
    public static final Pair<Value, Type> getThisOpAndType(@NotNull InvokeExpr $this$thisOpAndType) {
        Intrinsics.checkNotNullParameter((Object)$this$thisOpAndType, (String)"<this>");
        return SootUtilsKt.argToOpAndType((InvokeExpr)$this$thisOpAndType, (int)-1);
    }

    @NotNull
    public static final SootField getOrMakeField(@NotNull String sootClass, @NotNull String fieldName, @NotNull Type sootFieldType) {
        Intrinsics.checkNotNullParameter((Object)sootClass, (String)"sootClass");
        Intrinsics.checkNotNullParameter((Object)fieldName, (String)"fieldName");
        Intrinsics.checkNotNullParameter((Object)sootFieldType, (String)"sootFieldType");
        SootClass it = Scene.v().getSootClass(sootClass);
        boolean bl = false;
        SootField sootField = it.declaresFieldByName(fieldName) ? it.getFieldByName(fieldName) : it.getOrAddField(new SootField(fieldName, sootFieldType));
        Intrinsics.checkNotNullExpressionValue((Object)sootField, (String)"let(...)");
        return sootField;
    }
}

