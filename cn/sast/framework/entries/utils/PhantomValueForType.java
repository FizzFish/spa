package cn.sast.framework.entries.utils;

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

import java.util.Collections;

public final class PhantomValueForType {
    @NotNull
    private final String dummyClassName;
    @NotNull
    private final KLogger logger;

    public PhantomValueForType(@NotNull String dummyClassName) {
        if (dummyClassName == null) {
            throw new IllegalArgumentException("dummyClassName cannot be null");
        }
        this.dummyClassName = dummyClassName;
        this.logger = KotlinLogging.INSTANCE.logger(this.getClass());
    }

    public PhantomValueForType() {
        this("dummyMainClass");
    }

    private SootClass getSummaryClass() {
        SootClass sootClass = Scene.v().getSootClassUnsafe(this.dummyClassName, false);
        if (sootClass == null) {
            sootClass = Scene.v().makeSootClass(this.dummyClassName);
            sootClass.setResolvingLevel(3);
            sootClass.setApplicationClass();
        }
        return sootClass;
    }

    @Nullable
    public String getName(@NotNull Type tp) {
        if (tp == null) {
            throw new IllegalArgumentException("tp cannot be null");
        }

        if (tp instanceof PrimType) {
            return tp.toString();
        } else if (tp instanceof RefType) {
            String className = ((RefType) tp).getClassName();
            int lastDot = className.lastIndexOf('.');
            return lastDot >= 0 ? className.substring(lastDot + 1) : className;
        } else if (tp instanceof ArrayType) {
            Type elementType = ((ArrayType) tp).getElementType();
            String name = getName(elementType);
            return name != null ? name + "Array" : null;
        } else {
            logger.warn("Unsupported parameter type: {}", tp.toString());
            return null;
        }
    }

    @NotNull
    public SootMethod getOrMakeSootMethodForType(@NotNull Type tp, @NotNull String name, int number) {
        if (tp == null || name == null) {
            throw new IllegalArgumentException("Neither tp nor name can be null");
        }

        SootMethod method = this.getSummaryClass().getMethodByNameUnsafe(name);
        if (method == null) {
            method = Scene.v().makeSootMethod(name, Collections.emptyList(), tp, 8);
            this.getSummaryClass().addMethod(method);
            method.setPhantom(true);
        }

        if (method.getReturnType().equals(tp)) {
            return method;
        } else {
            return getOrMakeSootMethodForType(tp, name + number, number + 1);
        }
    }

    @NotNull
    public SootMethod getOrMakeSootMethodForType(@NotNull Type tp, @NotNull String name) {
        return getOrMakeSootMethodForType(tp, name, 1);
    }

    @Nullable
    public Local getValueForType(@NotNull INewUnits units, @NotNull LocalGenerator generator, @NotNull Type tp) {
        if (units == null || generator == null || tp == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        String name = getName(tp);
        if (name == null) {
            return null;
        }

        SootMethod getter = getOrMakeSootMethodForType(tp, "get" + name);
        Local local = generator.generateLocal(tp);
        AssignStmt aStmt = Jimple.v().newAssignStmt(local, Jimple.v().newStaticInvokeExpr(getter.makeRef()));
        units.add(aStmt);
        return local;
    }

    @Nullable
    public Local getValueForType(@NotNull Body body, @NotNull LocalGenerator generator, @NotNull Type tp) {
        if (body == null || generator == null || tp == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return getValueForType(new NewUnitsAtLastImmediately(body.getUnits()), generator, tp);
    }

    @Nullable
    public Local getValueForType(@NotNull BaseBodyGenerator body, @NotNull Type tp) {
        if (body == null || tp == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return getValueForType(new NewUnitsAtLastImmediately(body.getUnits()), body.getGenerator(), tp);
    }

    @Nullable
    public Local getValueForType(@NotNull INewUnits newUnits, @NotNull BaseBodyGenerator body, @NotNull Type tp) {
        if (newUnits == null || body == null || tp == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return getValueForType(newUnits, body.getGenerator(), tp);
    }
}
