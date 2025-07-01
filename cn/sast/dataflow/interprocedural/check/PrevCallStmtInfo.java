package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.util.SootUtilsKt;
import com.feysh.corax.config.api.IStmt;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.Local;
import soot.SootMethod;
import soot.tagkit.ParamNamesTag;

public final class PrevCallStmtInfo extends ModelingStmtInfo {
    @NotNull
    private final SootMethod method;

    public PrevCallStmtInfo(@NotNull IStmt stmt, @NotNull SootMethod method) {
        super(stmt);
        if (method == null) {
            throw new IllegalArgumentException("method cannot be null");
        }
        this.method = method;
    }

    @NotNull
    public SootMethod getMethod() {
        return method;
    }

    @Nullable
    public Object getParameterNameByIndex(@NotNull MLocal index, @NotNull Function<Object, Boolean> filter) {
        if (index == null) {
            throw new IllegalArgumentException("index cannot be null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("filter cannot be null");
        }

        if (index instanceof MParameter) {
            String paramName = getParameterNameByIndex(((MParameter) index).getIndex());
            if (paramName != null) {
                if (getFirstParamIndex() == null) {
                    setFirstParamIndex(((MParameter) index).getIndex());
                }
                return filter.apply(paramName) ? paramName : null;
            }
            return null;
        }
        return filter.apply(index) ? index : null;
    }

    @Nullable
    public String getParameterNameByIndex(int index) {
        if (index == -1) {
            return method.getDeclaringClass().getShortName() + ".this";
        }
        if (index < 0 || index >= method.getParameterCount()) {
            return null;
        }

        List<?> tags = method.getTags();
        List<ParamNamesTag> paramNameTags = new ArrayList<>();
        for (Object tag : tags) {
            if (tag instanceof ParamNamesTag) {
                paramNameTags.add((ParamNamesTag) tag);
            }
        }

        ParamNamesTag firstTag = paramNameTags.isEmpty() ? null : paramNameTags.get(0);
        String[] names = firstTag != null ? firstTag.getNames() : null;
        if (names != null && index < names.length) {
            return names[index];
        }

        try {
            Body body = SootUtilsKt.getActiveBodyOrNull(method);
            if (body != null) {
                Local paramLocal = body.getParameterLocal(index);
                if (paramLocal != null) {
                    return "local var " + paramLocal;
                }
            }
        } catch (RuntimeException ignore) {
        }

        return null;
    }
}
