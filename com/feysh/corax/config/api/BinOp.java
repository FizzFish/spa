package com.feysh.corax.config.api;

import org.jetbrains.annotations.NotNull;
import java.util.EnumSet;

public enum BinOp {
    LT,
    LE,
    EQ,
    GE,
    GT,
    Add,
    Sub,
    Mul,
    Div,
    Mod,
    Or,
    And,
    Xor,
    BvAnd,
    BvOr,
    BvXor,
    BvShr,
    BvShl,
    BvLShr,
    OrSet,
    AndSet,
    RemoveSet,
    HasIntersectionSet,
    ContainsSet,
    StartsWith,
    EndsWith,
    Contains,
    StringEquals,
    IsInstanceOf,
    AnyOf;

    @NotNull
    public static EnumSet<BinOp> getEntries() {
        return EnumSet.allOf(BinOp.class);
    }
}