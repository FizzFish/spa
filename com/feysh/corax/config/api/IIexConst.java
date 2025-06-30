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

import com.feysh.corax.config.api.IExpr;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/config/api/IIexConst;", "Lcom/feysh/corax/config/api/IExpr;", "const", "", "getConst", "()Ljava/lang/Object;", "type", "Lcom/feysh/corax/config/api/IIexConst$Type;", "getType", "()Lcom/feysh/corax/config/api/IIexConst$Type;", "Type", "corax-config-api"})
public interface IIexConst
extends IExpr {
    @NotNull
    public Object getConst();

    @NotNull
    public Type getType();

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2={"Lcom/feysh/corax/config/api/IIexConst$Type;", "", "<init>", "(Ljava/lang/String;I)V", "NULL", "Boolean", "Short", "Int", "Long", "Float", "Double", "Class", "String", "TaintSet", "ViaSet", "EmptyElement", "corax-config-api"})
    public static final class Type
    extends Enum<Type> {
        public static final /* enum */ Type NULL = new Type();
        public static final /* enum */ Type Boolean = new Type();
        public static final /* enum */ Type Short = new Type();
        public static final /* enum */ Type Int = new Type();
        public static final /* enum */ Type Long = new Type();
        public static final /* enum */ Type Float = new Type();
        public static final /* enum */ Type Double = new Type();
        public static final /* enum */ Type Class = new Type();
        public static final /* enum */ Type String = new Type();
        public static final /* enum */ Type TaintSet = new Type();
        public static final /* enum */ Type ViaSet = new Type();
        public static final /* enum */ Type EmptyElement = new Type();
        private static final /* synthetic */ Type[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }

        public static Type valueOf(String value) {
            return Enum.valueOf(Type.class, value);
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = typeArray = new Type[]{Type.NULL, Type.Boolean, Type.Short, Type.Int, Type.Long, Type.Float, Type.Double, Type.Class, Type.String, Type.TaintSet, Type.ViaSet, Type.EmptyElement};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

