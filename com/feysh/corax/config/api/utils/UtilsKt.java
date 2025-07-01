package com.feysh.corax.config.api.utils;

import com.feysh.corax.commons.ExceptionsKt;
import com.google.common.base.Optional;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.ArrayType;
import soot.Body;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.IntType;
import soot.Local;
import soot.LongType;
import soot.RefType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.VoidType;
import soot.asm.AsmUtil;
import soot.jimple.Constant;
import soot.tagkit.ParamNamesTag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.util.Chain;

public final class UtilsKt {

    @NotNull
    public static KFunctionType getFunctionType(@NotNull SootMethod method) {
        if (method.isConstructor()) {
            return KFunctionType.Constructor;
        }
        return method.isStatic() || method.isStaticInitializer() 
            ? KFunctionType.StaticMethod 
            : KFunctionType.InstanceMethod;
    }

    @NotNull
    public static <R> Class<?> getDeclaringClass(@NotNull KCallable<? extends R> callable) {
        if (callable instanceof CallableReference) {
            CallableReference ref = (CallableReference) callable;
            KDeclarationContainer owner = ref.getOwner();
            if (owner instanceof KClass) {
                Class<?> javaClass = ((KClass<?>) owner).getJavaClass();
                if (javaClass != null) {
                    return javaClass;
                }
            }
        }

        if (callable instanceof KFunction) {
            try {
                KParameter instanceParam = KCallables.getInstanceParameter(callable);
                if (instanceParam != null) {
                    KType type = instanceParam.getType();
                    if (type != null) {
                        KClassifier classifier = type.getClassifier();
                        if (classifier instanceof KClass) {
                            return ((KClass<?>) classifier).getJavaClass();
                        }
                    }
                }
            } catch (Throwable ignore) {
                ExceptionsKt.checkCritical(ignore);
            }

            try {
                Method method = ReflectJvmMapping.getJavaMethod((KFunction<?>) callable);
                if (method != null) {
                    return method.getDeclaringClass();
                }

                Constructor<?> constructor = ReflectJvmMapping.getJavaConstructor((KFunction<?>) callable);
                if (constructor != null) {
                    return constructor.getDeclaringClass();
                }

                throw new IllegalStateException(callable + " is neither a method nor a constructor");
            } catch (Throwable ignore) {
                ExceptionsKt.checkCritical(ignore);
                throw new IllegalStateException(callable + " has unknown kind");
            }
        }

        if (callable instanceof KProperty) {
            Method getter = ReflectJvmMapping.getJavaGetter((KProperty<?>) callable);
            if (getter != null) {
                return getter.getDeclaringClass();
            }

            Field field = ReflectJvmMapping.getJavaField((KProperty<?>) callable);
            if (field != null) {
                return field.getDeclaringClass();
            }

            throw new IllegalStateException("not support " + callable);
        }

        throw new IllegalStateException("Unknown KCallable type: " + callable.getClass());
    }

    @NotNull
    public static List<String> getJimpleDesc(@NotNull CallableReference reference) {
        String signature = reference.getSignature();
        String desc = signature.substring(signature.indexOf('('));
        List<soot.Type> types = AsmUtil.toJimpleDesc(desc, Optional.absent());
        
        List<String> result = new ArrayList<>(types.size());
        for (soot.Type type : types) {
            result.add(getTypename(type));
        }
        return result;
    }

    @NotNull
    public static List<String> getSootParamStringList(@NotNull CallableReference reference) {
        List<String> sigTypes = new ArrayList<>(getJimpleDesc(reference));
        sigTypes.remove(sigTypes.size() - 1);
        return sigTypes;
    }

    @NotNull
    public static String getSootReturnType(@NotNull CallableReference reference) {
        List<String> desc = getJimpleDesc(reference);
        return desc.get(desc.size() - 1);
    }

    @NotNull
    public static String getSubSootSignature(@NotNull CallableReference reference) {
        return getSootReturnType(reference) + " " + reference.getName() + 
            "(" + String.join(",", getSootParamStringList(reference)) + ")";
    }

    @NotNull
    public static List<String> getSootParamStringList(@NotNull KCallable<?> callable) {
        if (callable instanceof KFunction) {
            if (callable instanceof CallableReference) {
                return getSootParamStringList((CallableReference) callable);
            } else {
                List<KParameter> parameters = ((KFunction<?>) callable).getParameters();
                if (KCallables.getInstanceParameter(callable) != null) {
                    parameters = parameters.subList(1, parameters.size());
                }
                
                List<String> result = new ArrayList<>(parameters.size());
                for (KParameter param : parameters) {
                    String typeName = ReflectJvmMapping.getJavaType(param.getType()).getTypeName();
                    result.add(typeName.split("<")[0]);
                }
                return result;
            }
        } else if (callable instanceof KProperty) {
            Method getter = ReflectJvmMapping.getJavaGetter((KProperty<?>) callable);
            if (getter == null) {
                throw new IllegalStateException("Getter for " + callable + " not found");
            }
            return getSootParamStringList(getter);
        } else {
            throw new IllegalStateException("Unknown KCallable type: " + callable.getClass());
        }
    }

    @NotNull
    public static String getSootReturnType(@NotNull KCallable<?> callable) {
        if (callable instanceof KFunction) {
            if (callable instanceof CallableReference) {
                return getSootReturnType((CallableReference) callable);
            } else {
                return getSootTypeName(((KFunction<?>) callable).getReturnType());
            }
        } else if (callable instanceof KProperty) {
            Method getter = ReflectJvmMapping.getJavaGetter((KProperty<?>) callable);
            if (getter != null) {
                String type = getSootReturnType(getter);
                if (type != null) {
                    return type;
                }
            }
            return getSootTypeName(((KProperty<?>) callable).getGetter().getProperty().getReturnType());
        } else {
            throw new IllegalStateException("Unknown KCallable type: " + callable.getClass());
        }
    }

    @NotNull
    public static KFunctionType getFunctionType(@NotNull Method method) {
        return Modifier.isStatic(method.getModifiers()) 
            ? KFunctionType.StaticMethod 
            : KFunctionType.InstanceMethod;
    }

    @NotNull
    public static KFunctionType getFunctionType(@NotNull Constructor<?> constructor) {
        return KFunctionType.Constructor;
    }

    @NotNull
    public static KFunctionType getFunctionType(@NotNull Executable executable) {
        if (executable instanceof Method) {
            return getFunctionType((Method) executable);
        } else if (executable instanceof Constructor) {
            return getFunctionType((Constructor<?>) executable);
        } else {
            throw new IllegalStateException(executable + " is neither a method nor a constructor");
        }
    }

    @NotNull
    public static String getSootName(@NotNull Executable executable) {
        return executable instanceof Constructor ? "<init>" : executable.getName();
    }

    private static String getSootSubSignature(Executable executable) {
        String paramTypes = "(" + String.join(",", getSootParamStringList(executable)) + ")";
        
        if (executable instanceof Constructor) {
            return "void <init>" + paramTypes;
        } else if (executable instanceof Method) {
            return getSootTypeName(((Method) executable).getReturnType()) + " " + 
                ((Method) executable).getName() + paramTypes;
        } else {
            throw new IllegalStateException(executable + " is neither a method nor a constructor");
        }
    }

    private static String getSootReturnType(Executable executable) {
        if (executable instanceof Constructor) {
            return "void";
        } else if (executable instanceof Method) {
            return getSootTypeName(((Method) executable).getReturnType());
        } else {
            throw new IllegalStateException(executable + " is neither a method nor a constructor");
        }
    }

    @NotNull
    public static List<String> getSootParamStringList(@NotNull Executable executable) {
        return getClassesToSootTypeNames(executable.getParameterTypes());
    }

    @NotNull
    public static String getSootSignature(@NotNull Executable executable) {
        return "<" + executable.getDeclaringClass().getName() + ": " + 
            getSootSubSignature(executable) + ">";
    }

    @NotNull
    public static String getSootTypeName(@NotNull Type type) {
        return type.getTypeName();
    }

    @NotNull
    public static String getSootTypeName(@NotNull KType type) {
        KClassifier classifier = type.getClassifier();
        if (classifier instanceof KClass) {
            String name = getSootTypeName((KClass<?>) classifier);
            if (name != null) {
                return name;
            }
        }
        return getSootTypeName(ReflectJvmMapping.getJavaType(type));
    }

    @NotNull
    public static String getSootTypeName(@NotNull KClass<?> kclass) {
        return getSootTypeName(kclass.getJavaClass());
    }

    @NotNull
    public static String getSootTypeName(@NotNull Class<?> clazz) {
        if (clazz.isArray()) {
            try {
                Class<?> component = clazz;
                int dimensions = 0;
                while (component.isArray()) {
                    dimensions++;
                    component = component.getComponentType();
                }
                
                StringBuilder sb = new StringBuilder();
                sb.append(component.getName());
                for (int i = 0; i < dimensions; i++) {
                    sb.append("[]");
                }
                return sb.toString();
            } catch (Throwable e) {
                ExceptionsKt.checkCritical(e);
            }
        }
        return clazz.getName();
    }

    @NotNull
    public static List<String> getClassesToSootTypeNames(@NotNull Class<?>[] classes) {
        List<String> result = new ArrayList<>(classes.length);
        for (Class<?> clazz : classes) {
            result.add(getSootTypeName(clazz));
        }
        return result;
    }

    @Nullable
    public static String getTypename(@NotNull soot.Type type, boolean shortName) {
        if (type instanceof RefType) {
            String className = ((RefType) type).getClassName();
            return shortName ? className.substring(className.lastIndexOf('.') + 1) : className;
        } else if (type instanceof LongType) {
            return "long";
        } else if (type instanceof ShortType) {
            return "short";
        } else if (type instanceof DoubleType) {
            return "double";
        } else if (type instanceof IntType) {
            return "int";
        } else if (type instanceof FloatType) {
            return "float";
        } else if (type instanceof ByteType) {
            return "byte";
        } else if (type instanceof CharType) {
            return "char";
        } else if (type instanceof VoidType) {
            return "void";
        } else if (type instanceof BooleanType) {
            return "boolean";
        } else if (type instanceof ArrayType) {
            StringBuilder buffer = new StringBuilder();
            soot.Type baseType = ((ArrayType) type).baseType;
            String baseName = getTypename(baseType, shortName);
            if (baseName == null) {
                return null;
            }
            buffer.append(baseName);
            for (int i = 0; i < ((ArrayType) type).numDimensions; i++) {
                buffer.append("[]");
            }
            return buffer.toString();
        }
        return null;
    }

    @Nullable
    public static String getTypename(@NotNull soot.Type type) {
        return getTypename(type, false);
    }

    @Nullable
    public static VisibilityAnnotationTag getVisibilityAnnotationTag(@NotNull SootMethod method) {
        return (VisibilityAnnotationTag) method.getTag("VisibilityAnnotationTag");
    }

    public static Level level(@NotNull org.slf4j.event.Level level) {
        return Level.toLevel(level.name());
    }

    @Nullable
    public static Body getActiveBodyOrNull(@NotNull SootMethod method) {
        return method.hasActiveBody() ? method.getActiveBody() : null;
    }

    @Nullable
    public static String getParameterNameByIndex(@NotNull SootMethod method, int index) {
        if (index == -1) {
            return method.getDeclaringClass().getShortName() + ".this";
        }
        
        if (index < 0 || index >= method.getParameterCount()) {
            return null;
        }

        ParamNamesTag tag = (ParamNamesTag) method.getTags().stream()
            .filter(t -> t instanceof ParamNamesTag)
            .findFirst()
            .orElse(null);
            
        List<String> names = tag != null ? tag.getNames() : null;
        if (names != null && index < names.size()) {
            return names.get(index);
        }

        try {
            Body body = getActiveBodyOrNull(method);
            if (body != null) {
                Local local = body.getParameterLocal(index);
                if (local != null) {
                    return local.toString();
                }
            }
        } catch (RuntimeException ignore) {
        }
        
        return null;
    }

    @NotNull
    public static String getSignatureWithOriginalName(@NotNull SootMethod method, boolean shortParamType) {
        String name = method.getName();
        List<soot.Type> paramTypes = method.getParameterTypes();
        soot.Type returnType = method.getReturnType();
        
        StringBuilder buffer = new StringBuilder();
        buffer.append(returnType.toQuotedString());
        buffer.append(' ');
        buffer.append(Scene.v().quotedNameOf(name));
        buffer.append('(');
        
        if (paramTypes != null && !paramTypes.isEmpty()) {
            for (int i = 0; i < paramTypes.size(); i++) {
                if (i > 0) {
                    buffer.append(',');
                }
                buffer.append(getTypename(paramTypes.get(i), shortParamType));
                String paramName = getParameterNameByIndex(method, i);
                if (paramName != null) {
                    buffer.append(' ').append(paramName);
                }
            }
        }
        
        buffer.append(')');
        return method.getDeclaringClass().getName() + ": " + buffer.toString();
    }

    @NotNull
    public static Set<soot.Type> getPossibleTypes(@NotNull Value value) {
        if (value instanceof Constant) {
            return Set.of(((Constant) value).getType());
        }
        if (!(value instanceof Local)) {
            return Set.of();
        }
        if (!Scene.v().hasPointsToAnalysis()) {
            throw new IllegalArgumentException("Points-to analysis not available");
        }
        Set<soot.Type> types = Scene.v().getPointsToAnalysis()
            .reachingObjects((Local) value)
            .possibleTypes();
        return types != null ? types : Set.of();
    }
}
