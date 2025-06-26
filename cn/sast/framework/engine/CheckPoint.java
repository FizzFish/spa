/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.report.DefaultEnv
 *  cn.sast.api.report.IBugResInfo
 *  cn.sast.framework.engine.CheckPoint
 *  com.feysh.corax.config.api.ICheckPoint
 *  com.feysh.corax.config.api.INodeWithRange
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Local
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Type
 *  soot.Value
 *  soot.jimple.Constant
 *  soot.jimple.StringConstant
 */
package cn.sast.framework.engine;

import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import com.feysh.corax.config.api.ICheckPoint;
import com.feysh.corax.config.api.INodeWithRange;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.Constant;
import soot.jimple.StringConstant;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0016J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u0007\u001a\u00020\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016R\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0015*\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006\u001d"}, d2={"Lcn/sast/framework/engine/CheckPoint;", "Lcom/feysh/corax/config/api/ICheckPoint;", "<init>", "()V", "hasSideEffect", "", "Lsoot/SootMethod;", "isInstanceOf", "Lsoot/SootClass;", "parent", "", "(Lsoot/SootClass;Ljava/lang/String;)Ljava/lang/Boolean;", "file", "Lcn/sast/api/report/IBugResInfo;", "getFile", "()Lcn/sast/api/report/IBugResInfo;", "env", "Lcn/sast/api/report/DefaultEnv;", "getEnv$corax_framework", "()Lcn/sast/api/report/DefaultEnv;", "possibleTypes", "", "Lsoot/Type;", "Lsoot/Value;", "getPossibleTypes", "(Lsoot/Value;)Ljava/util/Set;", "possibleConstantValues", "getPossibleConstantValues", "toString", "corax-framework"})
public abstract class CheckPoint
implements ICheckPoint {
    public boolean hasSideEffect(@NotNull SootMethod $this$hasSideEffect) {
        Intrinsics.checkNotNullParameter((Object)$this$hasSideEffect, (String)"<this>");
        return true;
    }

    @Nullable
    public Boolean isInstanceOf(@NotNull SootClass $this$isInstanceOf, @NotNull String parent) {
        Intrinsics.checkNotNullParameter((Object)$this$isInstanceOf, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        SootClass sootClass = Scene.v().getSootClassUnsafe(parent, false);
        if (sootClass == null) {
            return null;
        }
        SootClass parentClass = sootClass;
        return this.isInstanceOf($this$isInstanceOf, parentClass);
    }

    public boolean isInstanceOf(@NotNull SootClass $this$isInstanceOf, @NotNull SootClass parent) {
        Intrinsics.checkNotNullParameter((Object)$this$isInstanceOf, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        return Scene.v().getOrMakeFastHierarchy().canStoreType((Type)$this$isInstanceOf.getType(), (Type)parent.getType());
    }

    @NotNull
    public abstract IBugResInfo getFile();

    @NotNull
    public abstract DefaultEnv getEnv$corax_framework();

    @NotNull
    public Set<Type> getPossibleTypes(@NotNull Value $this$possibleTypes) {
        Intrinsics.checkNotNullParameter((Object)$this$possibleTypes, (String)"<this>");
        if ($this$possibleTypes instanceof Constant) {
            return SetsKt.setOf((Object)((Constant)$this$possibleTypes).getType());
        }
        if (!($this$possibleTypes instanceof Local)) {
            return SetsKt.emptySet();
        }
        if (!Scene.v().hasPointsToAnalysis()) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        Set set = Scene.v().getPointsToAnalysis().reachingObjects((Local)$this$possibleTypes).possibleTypes();
        if (set == null) {
            set = SetsKt.emptySet();
        }
        return set;
    }

    @NotNull
    public Set<String> getPossibleConstantValues(@NotNull Value $this$possibleConstantValues) {
        Intrinsics.checkNotNullParameter((Object)$this$possibleConstantValues, (String)"<this>");
        if ($this$possibleConstantValues instanceof StringConstant) {
            return SetsKt.setOf((Object)((StringConstant)$this$possibleConstantValues).value);
        }
        if (!($this$possibleConstantValues instanceof Local)) {
            return SetsKt.emptySet();
        }
        if (!Scene.v().hasPointsToAnalysis()) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        Set set = Scene.v().getPointsToAnalysis().reachingObjects((Local)$this$possibleConstantValues).possibleStringConstants();
        if (set == null) {
            set = SetsKt.emptySet();
        }
        return set;
    }

    @NotNull
    public String toString() {
        String string = this.getClass().getSimpleName();
        IBugResInfo iBugResInfo = this.getFile();
        Object object = this instanceof INodeWithRange ? (INodeWithRange)this : null;
        if (object == null || (object = object.getRegion()) == null || (object = object.toString()) == null) {
            object = "";
        }
        return string + " at " + iBugResInfo + ":" + (String)object;
    }
}

