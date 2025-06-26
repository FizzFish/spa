/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.entries.utils.PhantomValueForType
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.ArrayType
 *  soot.Body
 *  soot.Local
 *  soot.LocalGenerator
 *  soot.PrimType
 *  soot.RefType
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Type
 *  soot.Unit
 *  soot.Value
 *  soot.jimple.AssignStmt
 *  soot.jimple.Jimple
 *  utils.BaseBodyGenerator
 *  utils.INewUnits
 *  utils.NewUnitsAtLastImmediately
 */
package cn.sast.framework.entries.utils;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.Body;
import soot.Local;
import soot.LocalGenerator;
import soot.PrimType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.Jimple;
import utils.BaseBodyGenerator;
import utils.INewUnits;
import utils.NewUnitsAtLastImmediately;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001e"}, d2={"Lcn/sast/framework/entries/utils/PhantomValueForType;", "", "dummyClassName", "", "<init>", "(Ljava/lang/String;)V", "logger", "Lmu/KLogger;", "summaryClass", "Lsoot/SootClass;", "getSummaryClass", "()Lsoot/SootClass;", "getName", "tp", "Lsoot/Type;", "getOrMakeSootMethodForType", "Lsoot/SootMethod;", "name", "number", "", "getValueForType", "Lsoot/Local;", "units", "Lutils/INewUnits;", "generator", "Lsoot/LocalGenerator;", "body", "Lsoot/Body;", "Lutils/BaseBodyGenerator;", "newUnits", "corax-framework"})
public final class PhantomValueForType {
    @NotNull
    private final String dummyClassName;
    @NotNull
    private final KLogger logger;

    public PhantomValueForType(@NotNull String dummyClassName) {
        Intrinsics.checkNotNullParameter((Object)dummyClassName, (String)"dummyClassName");
        this.dummyClassName = dummyClassName;
        this.logger = KotlinLogging.INSTANCE.logger(PhantomValueForType::logger$lambda$0);
    }

    public /* synthetic */ PhantomValueForType(String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = "dummyMainClass";
        }
        this(string);
    }

    private final SootClass getSummaryClass() {
        SootClass sootClass = Scene.v().getSootClassUnsafe(this.dummyClassName, false);
        if (sootClass == null) {
            SootClass sootClass2;
            SootClass it = sootClass2 = Scene.v().makeSootClass(this.dummyClassName);
            boolean bl = false;
            it.setResolvingLevel(3);
            it.setApplicationClass();
            SootClass sootClass3 = sootClass2;
            sootClass = sootClass3;
            Intrinsics.checkNotNullExpressionValue((Object)sootClass3, (String)"also(...)");
        }
        return sootClass;
    }

    @Nullable
    public final String getName(@NotNull Type tp) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)tp, (String)"tp");
        Type type = tp;
        if (type instanceof PrimType) {
            object = tp.toString();
        } else if (type instanceof RefType) {
            String string = ((RefType)tp).getClassName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getClassName(...)");
            object = StringsKt.substringAfterLast$default((String)string, (String)".", null, (int)2, null);
        } else if (type instanceof ArrayType) {
            Type type2 = ((ArrayType)tp).getElementType();
            Intrinsics.checkNotNullExpressionValue((Object)type2, (String)"getElementType(...)");
            object = this.getName(type2) + "Array";
        } else {
            this.logger.warn("Unsupported parameter type: {}", (Object)tp.toString());
            return null;
        }
        return object;
    }

    @NotNull
    public final SootMethod getOrMakeSootMethodForType(@NotNull Type tp, @NotNull String name, int number) {
        SootMethod sootMethod;
        SootMethod getter;
        Intrinsics.checkNotNullParameter((Object)tp, (String)"tp");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        SootMethod sootMethod2 = this.getSummaryClass().getMethodByNameUnsafe(name);
        if (sootMethod2 == null) {
            SootMethod sootMethod3;
            SootMethod it = sootMethod3 = Scene.v().makeSootMethod(name, CollectionsKt.emptyList(), tp, 8);
            boolean bl = false;
            this.getSummaryClass().addMethod(it);
            it.setPhantom(true);
            sootMethod2 = sootMethod3;
        }
        if (Intrinsics.areEqual((Object)(getter = sootMethod2).getReturnType(), (Object)tp)) {
            SootMethod sootMethod4 = getter;
            Intrinsics.checkNotNull((Object)sootMethod4);
            sootMethod = sootMethod4;
        } else {
            sootMethod = this.getOrMakeSootMethodForType(tp, name + number, number + 1);
        }
        return sootMethod;
    }

    public static /* synthetic */ SootMethod getOrMakeSootMethodForType$default(PhantomValueForType phantomValueForType, Type type, String string, int n, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = 1;
        }
        return phantomValueForType.getOrMakeSootMethodForType(type, string, n);
    }

    @Nullable
    public final Local getValueForType(@NotNull INewUnits units, @NotNull LocalGenerator generator, @NotNull Type tp) {
        Intrinsics.checkNotNullParameter((Object)units, (String)"units");
        Intrinsics.checkNotNullParameter((Object)generator, (String)"generator");
        Intrinsics.checkNotNullParameter((Object)tp, (String)"tp");
        String string = this.getName(tp);
        if (string == null) {
            return null;
        }
        String name = string;
        SootMethod getter = PhantomValueForType.getOrMakeSootMethodForType$default((PhantomValueForType)this, (Type)tp, (String)("get" + name), (int)0, (int)4, null);
        Local local = generator.generateLocal(tp);
        AssignStmt aStmt = Jimple.v().newAssignStmt((Value)local, (Value)Jimple.v().newStaticInvokeExpr(getter.makeRef()));
        units.add((Unit)aStmt);
        return local;
    }

    @Nullable
    public final Local getValueForType(@NotNull Body body, @NotNull LocalGenerator generator, @NotNull Type tp) {
        Intrinsics.checkNotNullParameter((Object)body, (String)"body");
        Intrinsics.checkNotNullParameter((Object)generator, (String)"generator");
        Intrinsics.checkNotNullParameter((Object)tp, (String)"tp");
        return this.getValueForType((INewUnits)new NewUnitsAtLastImmediately(body.getUnits()), generator, tp);
    }

    @Nullable
    public final Local getValueForType(@NotNull BaseBodyGenerator body, @NotNull Type tp) {
        Intrinsics.checkNotNullParameter((Object)body, (String)"body");
        Intrinsics.checkNotNullParameter((Object)tp, (String)"tp");
        INewUnits iNewUnits = (INewUnits)new NewUnitsAtLastImmediately(body.getUnits());
        LocalGenerator localGenerator = body.getGenerator();
        Intrinsics.checkNotNullExpressionValue((Object)localGenerator, (String)"getGenerator(...)");
        return this.getValueForType(iNewUnits, localGenerator, tp);
    }

    @Nullable
    public final Local getValueForType(@NotNull INewUnits newUnits, @NotNull BaseBodyGenerator body, @NotNull Type tp) {
        Intrinsics.checkNotNullParameter((Object)newUnits, (String)"newUnits");
        Intrinsics.checkNotNullParameter((Object)body, (String)"body");
        Intrinsics.checkNotNullParameter((Object)tp, (String)"tp");
        LocalGenerator localGenerator = body.getGenerator();
        Intrinsics.checkNotNullExpressionValue((Object)localGenerator, (String)"getGenerator(...)");
        return this.getValueForType(newUnits, localGenerator, tp);
    }

    private static final kotlin.Unit logger$lambda$0() {
        return kotlin.Unit.INSTANCE;
    }

    public PhantomValueForType() {
        this(null, 1, null);
    }
}

