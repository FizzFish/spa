package com.feysh.corax.config.api;

import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface IIexGetField extends IExpr {
    @NotNull
    IExpr getBase();

    @NotNull
    List<IClassField> getAccessPath();
}