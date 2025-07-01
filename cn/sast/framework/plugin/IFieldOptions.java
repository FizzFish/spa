package cn.sast.framework.plugin;

import com.feysh.corax.config.api.SAOptions;
import org.jetbrains.annotations.Nullable;

public interface IFieldOptions {
    @Nullable
    SAOptions getOptions();
}