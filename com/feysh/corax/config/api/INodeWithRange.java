package com.feysh.corax.config.api;

import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;

public interface INodeWithRange {
    @NotNull
    Region getRegion();
}