package cn.sast.dataflow.infoflow.provider;

import java.util.Set;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;

public final class MethodSummaryProviderKt {
    @NotNull
    public static Set<SootMethod> findAllOverrideMethodsOfMethod(@NotNull SootMethod method) {
        if (method == null) {
            throw new IllegalArgumentException("method cannot be null");
        }
        SootClass sootClass = method.getDeclaringClass();
        if (sootClass == null) {
            throw new IllegalStateException("Declaring class cannot be null");
        }
        return Scene.v().getFastHierarchy().resolveAbstractDispatch(sootClass, method);
    }
}