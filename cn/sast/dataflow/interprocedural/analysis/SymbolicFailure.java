package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SymbolicFailure<V> extends MethodResult<V> {
    private final V symbolic;
    @Nullable
    private final Throwable concrete;
    private final boolean explicit;
    private final boolean inNestedMethod;

    public SymbolicFailure(V symbolic, @Nullable Throwable concrete, boolean explicit, boolean inNestedMethod) {
        super(null);
        this.symbolic = symbolic;
        this.concrete = concrete;
        this.explicit = explicit;
        this.inNestedMethod = inNestedMethod;
    }

    public V getSymbolic() {
        return symbolic;
    }

    @Nullable
    public Throwable getConcrete() {
        return concrete;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public boolean isInNestedMethod() {
        return inNestedMethod;
    }

    @NotNull
    public SymbolicFailure<V> copy(V symbolic, @Nullable Throwable concrete, boolean explicit, boolean inNestedMethod) {
        return new SymbolicFailure<>(symbolic, concrete, explicit, inNestedMethod);
    }

    @Override
    public String toString() {
        return "SymbolicFailure(symbolic=" + symbolic + 
               ", concrete=" + concrete + 
               ", explicit=" + explicit + 
               ", inNestedMethod=" + inNestedMethod + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof SymbolicFailure)) return false;
        
        SymbolicFailure<?> that = (SymbolicFailure<?>) other;
        if (!java.util.Objects.equals(symbolic, that.symbolic)) return false;
        if (!java.util.Objects.equals(concrete, that.concrete)) return false;
        if (explicit != that.explicit) return false;
        return inNestedMethod == that.inNestedMethod;
    }

    @Override
    public int hashCode() {
        int result = symbolic != null ? symbolic.hashCode() : 0;
        result = 31 * result + (concrete != null ? concrete.hashCode() : 0);
        result = 31 * result + Boolean.hashCode(explicit);
        result = 31 * result + Boolean.hashCode(inNestedMethod);
        return result;
    }
}