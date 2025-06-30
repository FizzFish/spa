/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b!\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!\u00a8\u0006\""}, d2={"Lcom/feysh/corax/config/api/BinOp;", "", "<init>", "(Ljava/lang/String;I)V", "LT", "LE", "EQ", "GE", "GT", "Add", "Sub", "Mul", "Div", "Mod", "Or", "And", "Xor", "BvAnd", "BvOr", "BvXor", "BvShr", "BvShl", "BvLShr", "OrSet", "AndSet", "RemoveSet", "HasIntersectionSet", "ContainsSet", "StartsWith", "EndsWith", "Contains", "StringEquals", "IsInstanceOf", "AnyOf", "corax-config-api"})
public final class BinOp
extends Enum<BinOp> {
    public static final /* enum */ BinOp LT = new BinOp();
    public static final /* enum */ BinOp LE = new BinOp();
    public static final /* enum */ BinOp EQ = new BinOp();
    public static final /* enum */ BinOp GE = new BinOp();
    public static final /* enum */ BinOp GT = new BinOp();
    public static final /* enum */ BinOp Add = new BinOp();
    public static final /* enum */ BinOp Sub = new BinOp();
    public static final /* enum */ BinOp Mul = new BinOp();
    public static final /* enum */ BinOp Div = new BinOp();
    public static final /* enum */ BinOp Mod = new BinOp();
    public static final /* enum */ BinOp Or = new BinOp();
    public static final /* enum */ BinOp And = new BinOp();
    public static final /* enum */ BinOp Xor = new BinOp();
    public static final /* enum */ BinOp BvAnd = new BinOp();
    public static final /* enum */ BinOp BvOr = new BinOp();
    public static final /* enum */ BinOp BvXor = new BinOp();
    public static final /* enum */ BinOp BvShr = new BinOp();
    public static final /* enum */ BinOp BvShl = new BinOp();
    public static final /* enum */ BinOp BvLShr = new BinOp();
    public static final /* enum */ BinOp OrSet = new BinOp();
    public static final /* enum */ BinOp AndSet = new BinOp();
    public static final /* enum */ BinOp RemoveSet = new BinOp();
    public static final /* enum */ BinOp HasIntersectionSet = new BinOp();
    public static final /* enum */ BinOp ContainsSet = new BinOp();
    public static final /* enum */ BinOp StartsWith = new BinOp();
    public static final /* enum */ BinOp EndsWith = new BinOp();
    public static final /* enum */ BinOp Contains = new BinOp();
    public static final /* enum */ BinOp StringEquals = new BinOp();
    public static final /* enum */ BinOp IsInstanceOf = new BinOp();
    public static final /* enum */ BinOp AnyOf = new BinOp();
    private static final /* synthetic */ BinOp[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static BinOp[] values() {
        return (BinOp[])$VALUES.clone();
    }

    public static BinOp valueOf(String value) {
        return Enum.valueOf(BinOp.class, value);
    }

    @NotNull
    public static EnumEntries<BinOp> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = binOpArray = new BinOp[]{BinOp.LT, BinOp.LE, BinOp.EQ, BinOp.GE, BinOp.GT, BinOp.Add, BinOp.Sub, BinOp.Mul, BinOp.Div, BinOp.Mod, BinOp.Or, BinOp.And, BinOp.Xor, BinOp.BvAnd, BinOp.BvOr, BinOp.BvXor, BinOp.BvShr, BinOp.BvShl, BinOp.BvLShr, BinOp.OrSet, BinOp.AndSet, BinOp.RemoveSet, BinOp.HasIntersectionSet, BinOp.ContainsSet, BinOp.StartsWith, BinOp.EndsWith, BinOp.Contains, BinOp.StringEquals, BinOp.IsInstanceOf, BinOp.AnyOf};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

