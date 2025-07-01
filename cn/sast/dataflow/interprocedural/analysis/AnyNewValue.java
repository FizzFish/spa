package cn.sast.dataflow.interprocedural.analysis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.RefType;
import soot.Type;
import soot.Unit;
import soot.jimple.AnyNewExpr;

public class AnyNewValue implements IValue {
    @NotNull
    private final Unit u;
    @NotNull
    private final String method;
    @NotNull
    private final AnyNewExpr newExpr;
    @NotNull
    private final Type type;
    @Nullable
    private Integer hashCode;

    public AnyNewValue(@NotNull Unit u, @NotNull String method, @NotNull AnyNewExpr newExpr) {
        if (u == null) throw new IllegalArgumentException("u cannot be null");
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        if (newExpr == null) throw new IllegalArgumentException("newExpr cannot be null");
        
        this.u = u;
        this.method = method;
        this.newExpr = newExpr;
        
        if (!(newExpr.getType() instanceof RefType) && !(newExpr.getType() instanceof ArrayType)) {
            throw new IllegalStateException(newExpr.toString());
        }
        this.type = newExpr.getType();
    }

    @NotNull
    public Unit getU() {
        return u;
    }

    @NotNull
    public String getMethod() {
        return method;
    }

    @NotNull
    public AnyNewExpr getNewExpr() {
        return newExpr;
    }

    @Override
    @NotNull
    public IValue clone() {
        return new AnyNewValue(u, method, newExpr);
    }

    @Override
    @NotNull
    public String toString() {
        return newExpr + " *" + u.getJavaSourceStartLineNumber() + " (" + hashCode() + ")";
    }

    @Override
    @NotNull
    public Type getType() {
        return type;
    }

    @Override
    public boolean typeIsConcrete() {
        return true;
    }

    @Override
    public boolean isNullConstant() {
        return false;
    }

    @Override
    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Normal;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!FactValuesKt.getLeastExpr()) {
            return this == other;
        }
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        
        AnyNewValue that = (AnyNewValue) other;
        
        if (hashCode != null && that.hashCode != null && !hashCode.equals(that.hashCode)) {
            return false;
        }
        return method.equals(that.method) 
            && newExpr.equals(that.newExpr) 
            && type.equals(that.getType());
    }

    @Nullable
    public Integer getHashCode() {
        return hashCode;
    }

    public void setHashCode(@Nullable Integer hashCode) {
        this.hashCode = hashCode;
    }

    public int hash() {
        if (!FactValuesKt.getLeastExpr()) {
            return System.identityHashCode(this);
        }
        int result = method.hashCode();
        result = 31 * result + newExpr.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public int hashCode() {
        if (hashCode == null) {
            hashCode = hash();
        }
        return hashCode;
    }

    @Override
    public boolean isNormal() {
        return true;
    }

    @Override
    @Nullable
    public Boolean objectEqual(@NotNull IValue b) {
        return equals(b);
    }

    @Override
    @NotNull
    public IValue copy(@NotNull Type type) {
        return new AnyNewValue(u, method, newExpr);
    }
}