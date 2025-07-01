package cn.sast.framework.plugin;

import cn.sast.framework.plugin.ConfigSerializable;
import cn.sast.framework.plugin.IFieldOptions;
import cn.sast.framework.plugin.IOptional;
import com.feysh.corax.config.api.SAOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CheckerUnitOptionalConfig extends ConfigSerializable implements IOptional, IFieldOptions {
    @NotNull
    private final String name;
    private final boolean enable;
    @Nullable
    private final SAOptions options;

    public CheckerUnitOptionalConfig(@NotNull String name, boolean enable, @Nullable SAOptions options) {
        super(null);
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
        this.enable = enable;
        this.options = options;
    }

    @Override
    @NotNull
    public String getName() {
        return name;
    }

    @Override
    public boolean getEnable() {
        return enable;
    }

    @Override
    @Nullable
    public SAOptions getOptions() {
        return options;
    }

    @Override
    public int compareTo(@NotNull ConfigSerializable other) {
        if (other == null) {
            throw new IllegalArgumentException("other cannot be null");
        }
        
        if (!(other instanceof CheckerUnitOptionalConfig)) {
            return super.compareTo(other);
        }
        
        int parentComparison = super.compareTo(other);
        if (parentComparison != 0) {
            return parentComparison;
        }
        
        CheckerUnitOptionalConfig that = (CheckerUnitOptionalConfig) other;
        if (this.enable != that.enable) {
            return this.enable ? -1 : 1;
        }
        return 0;
    }

    @NotNull
    public String component1() {
        return name;
    }

    public boolean component2() {
        return enable;
    }

    @Nullable
    public SAOptions component3() {
        return options;
    }

    @NotNull
    public CheckerUnitOptionalConfig copy(@NotNull String name, boolean enable, @Nullable SAOptions options) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        return new CheckerUnitOptionalConfig(name, enable, options);
    }

    @Override
    public String toString() {
        return "CheckerUnitOptionalConfig(name=" + name + ", enable=" + enable + ", options=" + options + ")";
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Boolean.hashCode(enable);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof CheckerUnitOptionalConfig)) return false;
        
        CheckerUnitOptionalConfig that = (CheckerUnitOptionalConfig) other;
        return name.equals(that.name) && 
               enable == that.enable && 
               (options == null ? that.options == null : options.equals(that.options));
    }
}