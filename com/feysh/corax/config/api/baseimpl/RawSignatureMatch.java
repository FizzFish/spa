package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IClassMatch;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.utils.KFunctionType;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Transient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Serializable
@SerialName("RawSignatureMatch")
public final class RawSignatureMatch implements IMethodMatch {
    @NotNull
    private final IClassMatch clazz;
    @NotNull
    private final List<String> name;
    @Nullable
    private final String returnType;
    @Nullable
    private final List<String> parameters;
    @Nullable
    private final KFunctionType actualType;
    @NotNull
    private final Exception exception;
    private final Supplier<String> signatureSupplier;

    public RawSignatureMatch(
        @NotNull IClassMatch clazz,
        @NotNull List<String> name,
        @Nullable String returnType,
        @Nullable List<String> parameters,
        @Nullable KFunctionType actualType
    ) {
        Objects.requireNonNull(clazz, "clazz");
        Objects.requireNonNull(name, "name");
        this.clazz = clazz;
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.actualType = actualType;
        this.exception = new Exception();
        this.signatureSupplier = () -> generateSignature();

        validate();
    }

    private void validate() {
        List<String> cNames = clazz.getSimpleName();
        if (cNames.isEmpty()) {
            throw new IllegalStateException("error syntax: " + this);
        }
        if (name.isEmpty()) {
            throw new IllegalStateException("error syntax: " + this);
        }
        if (name.stream().anyMatch(String::isEmpty)) {
            throw new IllegalStateException("error syntax: " + this);
        }
        
        for (String cName : cNames) {
            if (name.contains(cName)) {
                throw new IllegalStateException("This is a constructor: " + this);
            }
        }

        if (parameters != null) {
            if (parameters.stream().anyMatch(String::isEmpty)) {
                throw new IllegalStateException("invalid type: " + this);
            }
        }
    }

    @NotNull
    public IClassMatch getClazz() {
        return clazz;
    }

    @NotNull
    public List<String> getName() {
        return name;
    }

    @Nullable
    public String getReturnType() {
        return returnType;
    }

    @Nullable
    public List<String> getParameters() {
        return parameters;
    }

    @Override
    @Nullable
    public KFunctionType getActualType() {
        return actualType;
    }

    @Override
    @NotNull
    public Exception getException() {
        return exception;
    }

    @Override
    @Nullable
    public Integer getArgumentCnt() {
        if (parameters != null && parameters.contains("**")) {
            return null;
        }
        return parameters != null ? parameters.size() : null;
    }

    @Override
    @NotNull
    public List<SootMethod> matched(@NotNull Scene scene) {
        Objects.requireNonNull(scene, "scene");
        return clazz.matched(scene).stream()
            .filter(c -> c.resolvingLevel() >= 2)
            .flatMap(c -> c.getMethods().stream())
            .filter(this::match)
            .collect(Collectors.toList());
    }

    private boolean isMatches(Type type, String t) {
        if (t == null || "*".equals(t)) {
            return true;
        }
        if (type.toString().equals(t)) {
            return true;
        }
        if (type instanceof ArrayType && t.endsWith("[]")) {
            Type elementType = ((ArrayType)type).getElementType();
            return isMatches(elementType, t.substring(0, t.indexOf('[')));
        }
        if (t.isEmpty()) {
            throw new IllegalStateException("invalid type: " + this);
        }
        
        String typeName = UtilsKt.getTypename(type);
        if (typeName == null) return false;
        
        String simpleName = typeName.substring(typeName.lastIndexOf('.') + 1);
        if (simpleName.equals(t)) return true;
        
        String innerName = typeName.substring(typeName.lastIndexOf('$') + 1);
        return innerName.equals(t);
    }

    private boolean match(SootMethod sm) {
        if (!name.contains(sm.getName())) {
            return false;
        }
        
        Type returnType = sm.getReturnType();
        if (!isMatches(returnType, this.returnType)) {
            return false;
        }
        
        if (parameters == null) {
            return true;
        }
        
        int count = 0;
        for (int i = 0; i < parameters.size(); i++) {
            String param = parameters.get(i);
            if ("**".equals(param)) {
                return true;
            }
            if (i >= sm.getParameterCount()) {
                return false;
            }
            Type paramType = sm.getParameterType(i);
            if (paramType == null || !isMatches(paramType, param)) {
                return false;
            }
            count++;
        }
        return count == sm.getParameterCount();
    }

    @NotNull
    public String getSignature() {
        return signatureSupplier.get();
    }

    private String generateSignature() {
        String nameString = name.size() == 1 ? name.get(0) : 
            "[" + String.join(", ", name) + "]";
        String returnTypeStr = returnType != null ? returnType : "*";
        String paramsStr = parameters != null ? 
            String.join(",", parameters) : "**";
        return "^" + clazz + ": " + returnTypeStr + " " + nameString + "(" + paramsStr + ")";
    }

    @Override
    public String toString() {
        return "method match: " + getSignature();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RawSignatureMatch)) return false;
        RawSignatureMatch that = (RawSignatureMatch) o;
        return clazz.equals(that.clazz) &&
            name.equals(that.name) &&
            Objects.equals(returnType, that.returnType) &&
            Objects.equals(parameters, that.parameters) &&
            actualType == that.actualType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clazz, name, returnType, parameters, actualType);
    }

    public static final class Companion {
        @NotNull
        public RawSignatureMatch invoke(
            @NotNull String clazz,
            @NotNull String name,
            @Nullable String returnType,
            @Nullable List<String> parameters,
            @Nullable KFunctionType actualType
        ) {
            return new RawSignatureMatch(
                new QualifiedRefType(clazz),
                List.of(name),
                returnType,
                parameters,
                actualType
            );
        }
    }

    public static final Companion Companion = new Companion();
}
