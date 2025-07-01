package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassField;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.IIexGetField;
import com.feysh.corax.config.api.IModelExpressionVisitor;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

public final class IexGetFieldExpr implements IIexGetField {
    @NotNull
    private final IExpr base;
    @NotNull
    private final PersistentList<IClassField> accessPath;

    public IexGetFieldExpr(@NotNull IExpr base, @NotNull PersistentList<? extends IClassField> accessPath) {
        if (base == null) throw new IllegalArgumentException("base cannot be null");
        if (accessPath == null) throw new IllegalArgumentException("accessPath cannot be null");
        this.base = base;
        this.accessPath = (PersistentList<IClassField>) accessPath;
    }

    @Override
    @NotNull
    public IExpr getBase() {
        return base;
    }

    @Override
    @NotNull
    public PersistentList<IClassField> getAccessPath() {
        return accessPath;
    }

    @Override
    @NotNull
    public String toString() {
        String path = accessPath.stream()
                .map(IClassField::toString)
                .collect(Collectors.joining("."));
        return "IexGetField( " + base + "." + path + " )";
    }

    @Override
    public <TResult> TResult accept(@NotNull IModelExpressionVisitor<TResult> visitor) {
        if (visitor == null) throw new IllegalArgumentException("visitor cannot be null");
        return visitor.visit(this);
    }

    public static final class Factory {
        private Factory() {}

        @NotNull
        public static IexGetFieldExpr create(@NotNull IExpr base, @NotNull IClassField field) {
            if (base == null) throw new IllegalArgumentException("base cannot be null");
            if (field == null) throw new IllegalArgumentException("field cannot be null");

            if (base instanceof IexGetFieldExpr) {
                IexGetFieldExpr existing = (IexGetFieldExpr) base;
                PersistentList<IClassField> newPath = existing.getAccessPath().add(field);
                return new IexGetFieldExpr(existing.getBase(), newPath);
            } else {
                return new IexGetFieldExpr(base, PersistentList.of(field));
            }
        }
    }
}