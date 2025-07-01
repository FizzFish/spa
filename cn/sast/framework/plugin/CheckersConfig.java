package cn.sast.framework.plugin;

import cn.sast.framework.plugin.ConfigSerializable;
import cn.sast.framework.plugin.IOptional;
import com.feysh.corax.config.api.IChecker;
import com.feysh.corax.config.api.utils.UtilsKt;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CheckersConfig extends ConfigSerializable implements IOptional {
    @NotNull
    private final String name;
    @Nullable
    private final String desc;
    private final boolean enable;
    @NotNull
    private LinkedHashSet<CheckTypeConfig> checkTypes;

    public CheckersConfig(@NotNull String name, @Nullable String desc, boolean enable, @NotNull LinkedHashSet<CheckTypeConfig> checkTypes) {
        super();
        this.name = Objects.requireNonNull(name, "name");
        this.desc = desc;
        this.enable = enable;
        this.checkTypes = Objects.requireNonNull(checkTypes, "checkTypes");
    }

    public CheckersConfig(@NotNull IChecker checker) {
        this(UtilsKt.getSootTypeName(checker.getClass()), checker.getDesc(), true, new LinkedHashSet<>());
    }

    @Override
    @NotNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getDesc() {
        return desc;
    }

    @Override
    public boolean getEnable() {
        return enable;
    }

    @NotNull
    public LinkedHashSet<CheckTypeConfig> getCheckTypes() {
        return checkTypes;
    }

    public void setCheckTypes(@NotNull LinkedHashSet<CheckTypeConfig> checkTypes) {
        this.checkTypes = Objects.requireNonNull(checkTypes, "<set-?>");
    }

    @NotNull
    public CheckersConfig sort() {
        checkTypes = new LinkedHashSet<>(checkTypes.stream().sorted().toList());
        return this;
    }

    @Override
    public int compareTo(@NotNull ConfigSerializable other) {
        Objects.requireNonNull(other, "other");
        if (!(other instanceof CheckersConfig)) {
            return super.compareTo(other);
        }
        
        int result = super.compareTo(other);
        if (result != 0) {
            return result;
        }
        
        CheckersConfig that = (CheckersConfig) other;
        if (enable != that.enable) {
            return enable ? -1 : 1;
        }
        return 0;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof CheckersConfig)) return false;
        CheckersConfig that = (CheckersConfig) other;
        return enable == that.enable &&
                name.equals(that.name) &&
                Objects.equals(desc, that.desc) &&
                checkTypes.equals(that.checkTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc, enable, checkTypes);
    }

    @Override
    public String toString() {
        return "CheckersConfig(name=" + name + 
               ", desc=" + desc + 
               ", enable=" + enable + 
               ", checkTypes=" + checkTypes + ")";
    }

    public static final class CheckTypeConfig {
        // Implementation omitted as not provided in original code
    }
}
