/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.provider.MethodSummaryProviderKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 */
package cn.sast.dataflow.infoflow.provider;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0004"}, d2={"findAllOverrideMethodsOfMethod", "", "Lsoot/SootMethod;", "method", "corax-data-flow"})
public final class MethodSummaryProviderKt {
    @NotNull
    public static final Set<SootMethod> findAllOverrideMethodsOfMethod(@NotNull SootMethod method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        SootClass sootClass = method.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        SootClass sootClass2 = sootClass;
        Set set = Scene.v().getFastHierarchy().resolveAbstractDispatch(sootClass2, method);
        Intrinsics.checkNotNullExpressionValue((Object)set, (String)"resolveAbstractDispatch(...)");
        return set;
    }
}

