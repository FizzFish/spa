package cn.sast.framework.validator;

import org.jetbrains.annotations.NotNull;

public abstract class RowType {
    protected RowType() {
    }

    @NotNull
    public abstract Object getType();
}