package com.feysh.corax.config.api.utils;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Serializable
public final class SootMethodDesc implements IMethodDescriptor {
    @NotNull
    public static final Companion Companion = new Companion();
    @NotNull
    private final String clazz;
    @NotNull
    private final String name;
    @NotNull
    private final String returnType;
    @NotNull
    private final List<String> parameters;
    private final String signature;

    private static final Pattern patternMethodSig = Pattern.compile("^<(?<className>.*?): (?<returnType>.*?) (?<methodName>.*?)\\((?<parameters>.*?)\\)>$");

    public SootMethodDesc(@NotNull String clazz, @NotNull String name, @NotNull String returnType, @NotNull List<String> parameters) {
        if (clazz == null) throw new IllegalArgumentException("clazz cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (returnType == null) throw new IllegalArgumentException("returnType cannot be null");
        if (parameters == null) throw new IllegalArgumentException("parameters cannot be null");
        
        if (clazz.contains("/")) {
            throw new IllegalArgumentException("invalid format clazz: " + clazz);
        }

        this.clazz = clazz;
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.signature = generateSignature();
    }

    private String generateSignature() {
        return "<" + clazz + ": " + returnType + " " + name + "(" + String.join(",", parameters) + ")>";
    }

    @Override
    @NotNull
    public String getClazz() {
        return clazz;
    }

    @Override
    @NotNull
    public String getName() {
        return name;
    }

    @Override
    @NotNull
    public String getReturnType() {
        return returnType;
    }

    @Override
    @NotNull
    public List<String> getParameters() {
        return parameters;
    }

    @NotNull
    public String getSignature() {
        return signature;
    }

    @Override
    @NotNull
    public String toString() {
        return signature;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof SootMethodDesc)) return false;
        
        SootMethodDesc that = (SootMethodDesc) other;
        return clazz.equals(that.clazz) &&
               name.equals(that.name) &&
               returnType.equals(that.returnType) &&
               parameters.equals(that.parameters);
    }

    @Override
    public int hashCode() {
        int result = clazz.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + returnType.hashCode();
        result = 31 * result + parameters.hashCode();
        return result;
    }

    public static final class Companion {
        @Nullable
        public SootMethodDesc invoke(@NotNull String parseString) {
            if (parseString == null) throw new IllegalArgumentException("parseString cannot be null");
            if (parseString.isEmpty()) return null;
            
            Matcher matcher = patternMethodSig.matcher(parseString);
            if (matcher.matches()) {
                String className = matcher.group("className");
                String returnType = matcher.group("returnType");
                String methodName = matcher.group("methodName");
                String paramList = matcher.group("parameters");
                
                return new SootMethodDesc(
                    className, 
                    methodName, 
                    returnType, 
                    List.of(paramList.split(","))
                );
            }
            return null;
        }

        @NotNull
        public SootMethodDesc invoke(@NotNull SootMethod sm) {
            if (sm == null) throw new IllegalArgumentException("sm cannot be null");
            
            String className = sm.getDeclaringClass().getName();
            String methodName = sm.getName();
            Type returnType = sm.getReturnType();
            String returnTypeName = UtilsKt.getTypename(returnType);
            if (returnTypeName == null) {
                returnTypeName = returnType.toString();
            }
            
            List<String> paramTypes = new ArrayList<>();
            for (Type paramType : sm.getParameterTypes()) {
                String typeName = UtilsKt.getTypename(paramType);
                if (typeName == null) {
                    typeName = paramType.toString();
                }
                paramTypes.add(typeName);
            }
            
            return new SootMethodDesc(className, methodName, returnTypeName, paramTypes);
        }

        @NotNull
        public KSerializer<SootMethodDesc> serializer() {
            return SootMethodDesc$.serializer();
        }
    }
}
