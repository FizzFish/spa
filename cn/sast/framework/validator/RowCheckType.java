package cn.sast.framework.validator;

import cn.sast.api.report.ReportKt;
import com.feysh.corax.config.api.CheckType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RowCheckType extends RowType {
    @NotNull
    private final CheckType type;

    public RowCheckType(@NotNull CheckType type) {
        super(null);
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        this.type = type;
    }

    @NotNull
    public CheckType getType() {
        return type;
    }

    @Override
    @NotNull
    public String toString() {
        return ReportKt.getPerfectName(getType());
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RowCheckType)) {
            return false;
        }
        RowCheckType that = (RowCheckType) other;
        return type.equals(that.type);
    }
}