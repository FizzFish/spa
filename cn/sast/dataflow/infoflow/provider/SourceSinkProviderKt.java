package cn.sast.dataflow.infoflow.provider;

import com.feysh.corax.config.api.MGlobal;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import com.feysh.corax.config.api.MReturn;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootMethod;
import soot.Type;

public final class SourceSinkProviderKt {
    private static final List<String> nullArg = null;

    @Nullable
    public static Type baseType(@NotNull SootMethod method, @NotNull MLocal loc) {
        if (method == null) throw new NullPointerException("<this> is null");
        if (loc == null) throw new NullPointerException("loc is null");

        if (loc instanceof MParameter) {
            MParameter param = (MParameter) loc;
            if (param.getIndex() == -1) {
                return method.getDeclaringClass().getType();
            } else if (param.getIndex() >= method.getParameterCount()) {
                return null;
            } else {
                return method.getParameterType(param.getIndex());
            }
        } else if (loc instanceof MReturn) {
            return method.getReturnType();
        } else if (loc == MGlobal.INSTANCE) {
            return Scene.v().getObjectType();
        } else {
            throw new IllegalArgumentException("Unknown MLocal type");
        }
    }
}