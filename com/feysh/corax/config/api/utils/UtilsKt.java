/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  kotlin.Function
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IndexedValue
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.CallableReference
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KCallable
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KClassifier
 *  kotlin.reflect.KDeclarationContainer
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KParameter
 *  kotlin.reflect.KProperty
 *  kotlin.reflect.KType
 *  kotlin.reflect.full.KCallables
 *  kotlin.reflect.jvm.ReflectJvmMapping
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.StringsKt
 *  org.apache.logging.log4j.Level
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.slf4j.event.Level
 *  soot.ArrayType
 *  soot.Body
 *  soot.BooleanType
 *  soot.ByteType
 *  soot.CharType
 *  soot.DoubleType
 *  soot.FloatType
 *  soot.IntType
 *  soot.Local
 *  soot.LongType
 *  soot.RefType
 *  soot.Scene
 *  soot.ShortType
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Type
 *  soot.Value
 *  soot.VoidType
 *  soot.asm.AsmUtil
 *  soot.jimple.Constant
 *  soot.tagkit.ParamNamesTag
 *  soot.tagkit.VisibilityAnnotationTag
 *  soot.util.Chain
 */
package com.feysh.corax.config.api.utils;

import com.feysh.corax.commons.ExceptionsKt;
import com.feysh.corax.config.api.utils.KFunctionType;
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
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
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
import soot.Value;
import soot.VoidType;
import soot.asm.AsmUtil;
import soot.jimple.Constant;
import soot.tagkit.ParamNamesTag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.util.Chain;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u00ce\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\f2\u0006\u0010D\u001a\u00020C\u001a\f\u0010E\u001a\u0004\u0018\u00010C*\u00020C\u001a\u001b\u0010P\u001a\n R*\u0004\u0018\u00010Q0Q2\u0006\u0010P\u001a\u00020S\u00a2\u0006\u0002\u0010T\u001a\u0016\u0010U\u001a\u0004\u0018\u00010\r*\u00020V2\b\b\u0002\u0010W\u001a\u00020X\u001a\u0012\u0010[\u001a\u00020\\*\u00020C2\u0006\u0010P\u001a\u00020]\u001a;\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00020G*\u00020C2\u0006\u0010_\u001a\u00020\r2!\u0010`\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020X0a\u001a?\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00020G*\u00020C2\u0006\u0010_\u001a\u00020\r2%\b\u0002\u0010`\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020X\u0018\u00010a\u001a\u0014\u0010j\u001a\u0004\u0018\u00010\r*\u00020\u00022\u0006\u0010k\u001a\u00020]\u001a\u0014\u0010l\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010m\u001a\u00020X\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"%\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\"\u0015\u0010\u0013\u001a\u00020\r*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0015\u0010\u0016\u001a\u00020\r*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u0006\u0012\u0002\b\u00030\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0018\"\u0019\u0010\u0013\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0019\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u001b\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u001d\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u001f\"\u0015\u0010 \u001a\u00020\r*\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\"\u0018\u0010#\u001a\u00020\r*\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"\"\u0018\u0010\u0013\u001a\u00020\r*\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\"\"\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010%\"\u0015\u0010&\u001a\u00020\r*\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\"\"\u0015\u0010(\u001a\u00020\r*\u00020)8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\"\u0015\u0010(\u001a\u00020\r*\u00020,8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010-\"\u0019\u0010(\u001a\u00020\r*\u0006\u0012\u0002\b\u00030.8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010/\"\u0019\u0010(\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00068F\u00a2\u0006\u0006\u001a\u0004\b*\u00100\"%\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\f*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006028F\u00a2\u0006\u0006\u001a\u0004\b3\u00104\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u00105\"\u0019\u00106\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\b8F\u00a2\u0006\u0006\u001a\u0004\b7\u0010\u0019\"\u0019\u0010#\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\b8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u0019\"\u0019\u00108\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\b8F\u00a2\u0006\u0006\u001a\u0004\b9\u0010\u0019\"\u0019\u0010(\u001a\u00020\r*\u0006\u0012\u0002\b\u00030:8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010;\"\u0019\u0010&\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\b8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0019\"-\u0010<\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070=8F\u00a2\u0006\f\u0012\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u001b\u0010F\u001a\b\u0012\u0004\u0012\u00020C0G*\u00020C8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010I\"\u001b\u0010J\u001a\b\u0012\u0004\u0012\u00020C0G*\u00020C8F\u00a2\u0006\u0006\u001a\u0004\bK\u0010I\"\u0017\u0010L\u001a\u0004\u0018\u00010M*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bN\u0010O\"\u0017\u0010Y\u001a\u0004\u0018\u00010\r*\u00020V8F\u00a2\u0006\u0006\u001a\u0004\bU\u0010Z\"\u0017\u0010f\u001a\u0004\u0018\u00010g*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bh\u0010i\"\u001b\u0010n\u001a\b\u0012\u0004\u0012\u00020V0o*\u00020p8F\u00a2\u0006\u0006\u001a\u0004\bq\u0010r\u00a8\u0006s"}, d2={"functionType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "Lsoot/SootMethod;", "getFunctionType", "(Lsoot/SootMethod;)Lcom/feysh/corax/config/api/utils/KFunctionType;", "declaringClass", "Ljava/lang/Class;", "R", "Lkotlin/reflect/KCallable;", "getDeclaringClass", "(Lkotlin/reflect/KCallable;)Ljava/lang/Class;", "jimpleDesc", "", "", "Lkotlin/jvm/internal/CallableReference;", "getJimpleDesc", "(Lkotlin/jvm/internal/CallableReference;)Ljava/util/List;", "sootParamStringList", "getSootParamStringList", "sootReturnType", "getSootReturnType", "(Lkotlin/jvm/internal/CallableReference;)Ljava/lang/String;", "subSootSignature", "getSubSootSignature", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "(Lkotlin/reflect/KCallable;)Ljava/lang/String;", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)Lcom/feysh/corax/config/api/utils/KFunctionType;", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)Lcom/feysh/corax/config/api/utils/KFunctionType;", "Ljava/lang/reflect/Executable;", "(Ljava/lang/reflect/Executable;)Lcom/feysh/corax/config/api/utils/KFunctionType;", "sootName", "getSootName", "(Ljava/lang/reflect/Executable;)Ljava/lang/String;", "sootSubSignature", "getSootSubSignature", "(Ljava/lang/reflect/Executable;)Ljava/util/List;", "sootSignature", "getSootSignature", "sootTypeName", "Ljava/lang/reflect/Type;", "getSootTypeName", "(Ljava/lang/reflect/Type;)Ljava/lang/String;", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Ljava/lang/String;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "(Ljava/lang/Class;)Ljava/lang/String;", "classesToSootTypeNames", "", "getClassesToSootTypeNames", "([Ljava/lang/Class;)Ljava/util/List;", "(Lkotlin/reflect/KCallable;)Lcom/feysh/corax/config/api/utils/KFunctionType;", "paramSignature", "getParamSignature", "declaringClassName", "getDeclaringClassName", "Lkotlin/reflect/KProperty;", "(Lkotlin/reflect/KProperty;)Ljava/lang/String;", "callable", "Lkotlin/Function;", "getCallable$annotations", "(Lkotlin/Function;)V", "getCallable", "(Lkotlin/Function;)Lkotlin/reflect/KCallable;", "findAncestors", "Lsoot/SootClass;", "sc", "superClassOrNull", "superClasses", "Lkotlin/sequences/Sequence;", "getSuperClasses", "(Lsoot/SootClass;)Lkotlin/sequences/Sequence;", "superInterfaces", "getSuperInterfaces", "visibilityAnnotationTag", "Lsoot/tagkit/VisibilityAnnotationTag;", "getVisibilityAnnotationTag", "(Lsoot/SootMethod;)Lsoot/tagkit/VisibilityAnnotationTag;", "level", "Lorg/apache/logging/log4j/Level;", "kotlin.jvm.PlatformType", "Lorg/slf4j/event/Level;", "(Lorg/slf4j/event/Level;)Lorg/apache/logging/log4j/Level;", "getTypename", "Lsoot/Type;", "short", "", "typename", "(Lsoot/Type;)Ljava/lang/String;", "adjustLevel", "", "", "resolveCallsDispatchChainBase", "subSignature", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "method", "resolveCallsDispatchChain", "activeBodyOrNull", "Lsoot/Body;", "getActiveBodyOrNull", "(Lsoot/SootMethod;)Lsoot/Body;", "getParameterNameByIndex", "index", "getSignatureWithOriginalName", "shortParamType", "possibleTypes", "", "Lsoot/Value;", "getPossibleTypes", "(Lsoot/Value;)Ljava/util/Set;", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/feysh/corax/config/api/utils/UtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,484:1\n1557#2:485\n1628#2,3:486\n1557#2:489\n1628#2,3:490\n1368#2:498\n1454#2,5:499\n1368#2:504\n1454#2,5:505\n808#2,11:510\n1368#2:521\n1454#2,5:522\n1368#2:527\n1454#2,5:528\n1#3:493\n1310#4,2:494\n1310#4,2:496\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/feysh/corax/config/api/utils/UtilsKt\n*L\n128#1:485\n128#1:486,3\n151#1:489\n151#1:490,3\n347#1:498\n347#1:499,5\n348#1:504\n348#1:505,5\n447#1:510,11\n358#1:521\n358#1:522,5\n405#1:527\n405#1:528,5\n285#1:494,2\n291#1:496,2\n*E\n"})
public final class UtilsKt {
    @NotNull
    public static final KFunctionType getFunctionType(@NotNull SootMethod $this$functionType) {
        Intrinsics.checkNotNullParameter((Object)$this$functionType, (String)"<this>");
        return $this$functionType.isConstructor() ? KFunctionType.Constructor : ($this$functionType.isStatic() || $this$functionType.isStaticInitializer() ? KFunctionType.StaticMethod : KFunctionType.InstanceMethod);
    }

    @NotNull
    public static final <R> Class<?> getDeclaringClass(@NotNull KCallable<? extends R> $this$declaringClass) {
        Class res;
        CallableReference callable;
        Intrinsics.checkNotNullParameter($this$declaringClass, (String)"<this>");
        CallableReference callableReference = callable = $this$declaringClass instanceof CallableReference ? (CallableReference)$this$declaringClass : null;
        KDeclarationContainer kDeclarationContainer = callableReference != null ? callableReference.getOwner() : null;
        KClass kClass = kDeclarationContainer instanceof KClass ? (KClass)kDeclarationContainer : null;
        Class clazz = res = kClass != null ? JvmClassMappingKt.getJavaClass((KClass)kClass) : null;
        if (res != null) {
            return res;
        }
        KCallable<R> kCallable = $this$declaringClass;
        if (kCallable instanceof KFunction) {
            try {
                KClass kc;
                KParameter kParameter = KCallables.getInstanceParameter($this$declaringClass);
                KClassifier kClassifier = kParameter != null && (kParameter = kParameter.getType()) != null ? kParameter.getClassifier() : null;
                KClass kClass2 = kc = kClassifier instanceof KClass ? (KClass)kClassifier : null;
                if (kc != null) {
                    return JvmClassMappingKt.getJavaClass((KClass)kc);
                }
            }
            catch (Throwable ignore) {
                ExceptionsKt.checkCritical(ignore);
            }
            try {
                GenericDeclaration genericDeclaration = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)$this$declaringClass));
                if (genericDeclaration == null || (genericDeclaration = genericDeclaration.getDeclaringClass()) == null) {
                    Constructor constructor = ReflectJvmMapping.getJavaConstructor((KFunction)((KFunction)$this$declaringClass));
                    genericDeclaration = constructor != null ? constructor.getDeclaringClass() : null;
                    if (genericDeclaration == null) {
                        throw new IllegalStateException(($this$declaringClass + " is neither a method nor a constructor").toString());
                    }
                }
                return genericDeclaration;
            }
            catch (Throwable ignore) {
                ExceptionsKt.checkCritical(ignore);
                throw new IllegalStateException(($this$declaringClass + " has unknown kind").toString());
            }
        }
        if (kCallable instanceof KProperty) {
            GenericDeclaration genericDeclaration = ReflectJvmMapping.getJavaGetter((KProperty)((KProperty)$this$declaringClass));
            if (genericDeclaration == null || (genericDeclaration = genericDeclaration.getDeclaringClass()) == null) {
                Field field = ReflectJvmMapping.getJavaField((KProperty)((KProperty)$this$declaringClass));
                genericDeclaration = field != null ? field.getDeclaringClass() : null;
                if (genericDeclaration == null) {
                    throw new IllegalStateException(("not support " + $this$declaringClass).toString());
                }
            }
            return genericDeclaration;
        }
        throw new IllegalStateException(("Unknown KCallable type: " + Reflection.getOrCreateKotlinClass($this$declaringClass.getClass())).toString());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<String> getJimpleDesc(@NotNull CallableReference $this$jimpleDesc) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$jimpleDesc, (String)"<this>");
        String string = $this$jimpleDesc.getSignature();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSignature(...)");
        List list = AsmUtil.toJimpleDesc((String)StringsKt.substringAfter$default((String)string, (String)"(", null, (int)2, null), (Optional)Optional.fromNullable(null));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"toJimpleDesc(...)");
        Iterable $this$map$iv = list;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            soot.Type type = (soot.Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            String string2 = UtilsKt.getTypename((soot.Type)it);
            Intrinsics.checkNotNull((Object)string2);
            collection.add(string2);
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public static final List<String> getSootParamStringList(@NotNull CallableReference $this$sootParamStringList) {
        Intrinsics.checkNotNullParameter((Object)$this$sootParamStringList, (String)"<this>");
        List sigTypes = CollectionsKt.toMutableList((Collection)UtilsKt.getJimpleDesc($this$sootParamStringList));
        sigTypes.remove(sigTypes.size() - 1);
        return sigTypes;
    }

    @NotNull
    public static final String getSootReturnType(@NotNull CallableReference $this$sootReturnType) {
        Intrinsics.checkNotNullParameter((Object)$this$sootReturnType, (String)"<this>");
        return (String)CollectionsKt.last(UtilsKt.getJimpleDesc($this$sootReturnType));
    }

    @NotNull
    public static final String getSubSootSignature(@NotNull CallableReference $this$subSootSignature) {
        Intrinsics.checkNotNullParameter((Object)$this$subSootSignature, (String)"<this>");
        return UtilsKt.getSootReturnType($this$subSootSignature) + " " + $this$subSootSignature.getName() + CollectionsKt.joinToString$default((Iterable)UtilsKt.getSootParamStringList($this$subSootSignature), (CharSequence)",", (CharSequence)"(", (CharSequence)")", (int)0, null, null, (int)56, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<String> getSootParamStringList(@NotNull KCallable<?> $this$sootParamStringList) {
        Object object;
        Intrinsics.checkNotNullParameter($this$sootParamStringList, (String)"<this>");
        KCallable<?> kCallable = $this$sootParamStringList;
        if (kCallable instanceof KFunction) {
            if ($this$sootParamStringList instanceof CallableReference) {
                object = UtilsKt.getSootParamStringList((CallableReference)$this$sootParamStringList);
            } else {
                void $this$mapTo$iv$iv;
                Iterable $this$map$iv = CollectionsKt.drop((Iterable)((KFunction)$this$sootParamStringList).getParameters(), (int)(KCallables.getInstanceParameter($this$sootParamStringList) != null ? 1 : 0));
                boolean $i$f$map = false;
                Iterable iterable = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    KParameter kParameter = (KParameter)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    boolean bl = false;
                    String string = ReflectJvmMapping.getJavaType((KType)it.getType()).getTypeName();
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getTypeName(...)");
                    collection.add(StringsKt.substringBefore$default((String)string, (char)'<', null, (int)2, null));
                }
                object = (List)destination$iv$iv;
            }
        } else if (kCallable instanceof KProperty) {
            object = ReflectJvmMapping.getJavaGetter((KProperty)((KProperty)$this$sootParamStringList));
            if (object == null || (object = UtilsKt.getSootParamStringList((Executable)object)) == null) {
                throw new IllegalStateException(("Getter for " + $this$sootParamStringList + " not found").toString());
            }
        } else {
            throw new IllegalStateException(("Unknown KCallable type: " + Reflection.getOrCreateKotlinClass($this$sootParamStringList.getClass())).toString());
        }
        return object;
    }

    @NotNull
    public static final String getSootReturnType(@NotNull KCallable<?> $this$sootReturnType) {
        Object object;
        Intrinsics.checkNotNullParameter($this$sootReturnType, (String)"<this>");
        KCallable<?> kCallable = $this$sootReturnType;
        if (kCallable instanceof KFunction) {
            object = $this$sootReturnType instanceof CallableReference ? UtilsKt.getSootReturnType((CallableReference)$this$sootReturnType) : UtilsKt.getSootTypeName(((KFunction)$this$sootReturnType).getReturnType());
        } else if (kCallable instanceof KProperty) {
            object = ReflectJvmMapping.getJavaGetter((KProperty)((KProperty)$this$sootReturnType));
            if (object == null || (object = UtilsKt.getSootReturnType((Executable)object)) == null) {
                object = UtilsKt.getSootTypeName(((KProperty)$this$sootReturnType).getGetter().getProperty().getReturnType());
            }
        } else {
            throw new IllegalStateException(("Unknown KCallable type: " + Reflection.getOrCreateKotlinClass($this$sootReturnType.getClass())).toString());
        }
        return object;
    }

    @NotNull
    public static final KFunctionType getFunctionType(@NotNull Method $this$functionType) {
        Intrinsics.checkNotNullParameter((Object)$this$functionType, (String)"<this>");
        return Modifier.isStatic($this$functionType.getModifiers()) ? KFunctionType.StaticMethod : KFunctionType.InstanceMethod;
    }

    @NotNull
    public static final KFunctionType getFunctionType(@NotNull Constructor<?> $this$functionType) {
        Intrinsics.checkNotNullParameter($this$functionType, (String)"<this>");
        return KFunctionType.Constructor;
    }

    @NotNull
    public static final KFunctionType getFunctionType(@NotNull Executable $this$functionType) {
        KFunctionType kFunctionType;
        Intrinsics.checkNotNullParameter((Object)$this$functionType, (String)"<this>");
        Executable executable = $this$functionType;
        if (executable instanceof Method) {
            kFunctionType = UtilsKt.getFunctionType((Method)$this$functionType);
        } else if (executable instanceof Constructor) {
            kFunctionType = UtilsKt.getFunctionType((Constructor)$this$functionType);
        } else {
            throw new IllegalStateException(($this$functionType + " is neither a method nor a constructor").toString());
        }
        return kFunctionType;
    }

    @NotNull
    public static final String getSootName(@NotNull Executable $this$sootName) {
        String string;
        Intrinsics.checkNotNullParameter((Object)$this$sootName, (String)"<this>");
        if ($this$sootName instanceof Constructor) {
            string = "<init>";
        } else {
            String string2 = $this$sootName.getName();
            string = string2;
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getName(...)");
        }
        return string;
    }

    private static final String getSootSubSignature(Executable $this$sootSubSignature) {
        String string;
        String paramTypes = CollectionsKt.joinToString$default((Iterable)UtilsKt.getSootParamStringList($this$sootSubSignature), (CharSequence)",", (CharSequence)"(", (CharSequence)")", (int)0, null, null, (int)56, null);
        Executable executable = $this$sootSubSignature;
        if (executable instanceof Constructor) {
            string = "void <init>" + paramTypes;
        } else if (executable instanceof Method) {
            Class<?> clazz = ((Method)$this$sootSubSignature).getReturnType();
            Intrinsics.checkNotNullExpressionValue(clazz, (String)"getReturnType(...)");
            string = UtilsKt.getSootTypeName(clazz) + " " + ((Method)$this$sootSubSignature).getName() + paramTypes;
        } else {
            throw new IllegalStateException(($this$sootSubSignature + " is neither a method nor a constructor").toString());
        }
        return string;
    }

    private static final String getSootReturnType(Executable $this$sootReturnType) {
        String string;
        Executable executable = $this$sootReturnType;
        if (executable instanceof Constructor) {
            string = "void";
        } else if (executable instanceof Method) {
            Class<?> clazz = ((Method)$this$sootReturnType).getReturnType();
            Intrinsics.checkNotNullExpressionValue(clazz, (String)"getReturnType(...)");
            string = UtilsKt.getSootTypeName(clazz);
        } else {
            throw new IllegalStateException(($this$sootReturnType + " is neither a method nor a constructor").toString());
        }
        return string;
    }

    @NotNull
    public static final List<String> getSootParamStringList(@NotNull Executable $this$sootParamStringList) {
        Intrinsics.checkNotNullParameter((Object)$this$sootParamStringList, (String)"<this>");
        Class<?>[] classArray = $this$sootParamStringList.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(classArray, (String)"getParameterTypes(...)");
        return UtilsKt.getClassesToSootTypeNames(classArray);
    }

    @NotNull
    public static final String getSootSignature(@NotNull Executable $this$sootSignature) {
        Intrinsics.checkNotNullParameter((Object)$this$sootSignature, (String)"<this>");
        return "<" + $this$sootSignature.getDeclaringClass().getName() + ": " + UtilsKt.getSootSubSignature($this$sootSignature) + ">";
    }

    @NotNull
    public static final String getSootTypeName(@NotNull Type $this$sootTypeName) {
        Intrinsics.checkNotNullParameter((Object)$this$sootTypeName, (String)"<this>");
        String string = $this$sootTypeName.getTypeName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getTypeName(...)");
        return string;
    }

    @NotNull
    public static final String getSootTypeName(@NotNull KType $this$sootTypeName) {
        Intrinsics.checkNotNullParameter((Object)$this$sootTypeName, (String)"<this>");
        KClassifier kClassifier = $this$sootTypeName.getClassifier();
        Object object = kClassifier instanceof KClass ? (KClass)kClassifier : null;
        if (object == null || (object = UtilsKt.getSootTypeName(object)) == null) {
            object = UtilsKt.getSootTypeName(ReflectJvmMapping.getJavaType((KType)$this$sootTypeName));
        }
        return object;
    }

    @NotNull
    public static final String getSootTypeName(@NotNull KClass<?> $this$sootTypeName) {
        Intrinsics.checkNotNullParameter($this$sootTypeName, (String)"<this>");
        return UtilsKt.getSootTypeName(JvmClassMappingKt.getJavaClass($this$sootTypeName));
    }

    @NotNull
    public static final String getSootTypeName(@NotNull Class<?> $this$sootTypeName) {
        Intrinsics.checkNotNullParameter($this$sootTypeName, (String)"<this>");
        if ($this$sootTypeName.isArray()) {
            try {
                Class<?> cl = $this$sootTypeName;
                int dimensions = 0;
                while (cl.isArray()) {
                    ++dimensions;
                    cl = cl.getComponentType();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(cl.getName());
                int n = dimensions;
                for (int i = 0; i < n; ++i) {
                    sb.append("[]");
                }
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
                return string;
            }
            catch (Throwable e) {
                ExceptionsKt.checkCritical(e);
            }
        }
        String string = $this$sootTypeName.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        return string;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<String> getClassesToSootTypeNames(@NotNull Class<?>[] $this$classesToSootTypeNames) {
        Intrinsics.checkNotNullParameter($this$classesToSootTypeNames, (String)"<this>");
        int n = $this$classesToSootTypeNames.length;
        ArrayList<String> arrayList = new ArrayList<String>(n);
        int n2 = 0;
        while (n2 < n) {
            void it;
            int n3;
            int n4 = n3 = n2++;
            ArrayList<String> arrayList2 = arrayList;
            boolean bl = false;
            arrayList2.add(UtilsKt.getSootTypeName($this$classesToSootTypeNames[it]));
        }
        return arrayList;
    }

    @NotNull
    public static final KFunctionType getFunctionType(@NotNull KCallable<?> $this$functionType) {
        Intrinsics.checkNotNullParameter($this$functionType, (String)"<this>");
        KCallable<?> kCallable = $this$functionType;
        if (kCallable instanceof KFunction) {
            try {
                if (Intrinsics.areEqual((Object)((KFunction)$this$functionType).getName(), (Object)"<init>")) {
                    return KFunctionType.Constructor;
                }
                return KCallables.getInstanceParameter($this$functionType) == null ? KFunctionType.StaticMethod : KFunctionType.InstanceMethod;
            }
            catch (Throwable ignore) {
                ExceptionsKt.checkCritical(ignore);
                try {
                    Object object = ReflectJvmMapping.getJavaMethod((KFunction)((KFunction)$this$functionType));
                    if (object == null || (object = UtilsKt.getFunctionType(object)) == null) {
                        Constructor constructor = ReflectJvmMapping.getJavaConstructor((KFunction)((KFunction)$this$functionType));
                        if (constructor != null) {
                            object = UtilsKt.getFunctionType(constructor);
                        } else {
                            throw new IllegalStateException(($this$functionType + " is neither a method nor a constructor").toString());
                        }
                    }
                    return object;
                }
                catch (Throwable ignore2) {
                    Object object;
                    Executable found;
                    String sig;
                    Object javaClass;
                    block17: {
                        Object object2;
                        Executable m;
                        boolean $i$f$firstOrNull;
                        Object[] $this$firstOrNull$iv;
                        block16: {
                            ExceptionsKt.checkCritical(ignore2);
                            CallableReference callable = (CallableReference)$this$functionType;
                            KDeclarationContainer kDeclarationContainer = callable.getOwner();
                            Object object3 = kDeclarationContainer instanceof KClass ? (KClass)kDeclarationContainer : null;
                            if (object3 == null || (object3 = JvmClassMappingKt.getJavaClass((KClass)object3)) == null) {
                                throw new IllegalStateException(($this$functionType + " has unknown kind").toString());
                            }
                            javaClass = object3;
                            sig = UtilsKt.getSubSootSignature(callable);
                            Method[] methodArray = ((Class)javaClass).getDeclaredMethods();
                            Intrinsics.checkNotNullExpressionValue((Object)methodArray, (String)"getDeclaredMethods(...)");
                            $this$firstOrNull$iv = methodArray;
                            $i$f$firstOrNull = false;
                            for (Object element$iv : $this$firstOrNull$iv) {
                                m = (Method)element$iv;
                                boolean bl = false;
                                Intrinsics.checkNotNull((Object)m);
                                if (!Intrinsics.areEqual((Object)UtilsKt.getSootSubSignature(m), (Object)sig)) continue;
                                object2 = element$iv;
                                break block16;
                            }
                            object2 = null;
                        }
                        found = (Executable)object2;
                        if (found != null) {
                            return UtilsKt.getFunctionType(found);
                        }
                        Constructor<?>[] constructorArray = ((Class)javaClass).getConstructors();
                        Intrinsics.checkNotNullExpressionValue(constructorArray, (String)"getConstructors(...)");
                        $this$firstOrNull$iv = constructorArray;
                        $i$f$firstOrNull = false;
                        for (Object element$iv : $this$firstOrNull$iv) {
                            m = (Constructor)element$iv;
                            boolean bl = false;
                            Intrinsics.checkNotNull((Object)m);
                            if (!Intrinsics.areEqual((Object)UtilsKt.getSootSubSignature(m), (Object)sig)) continue;
                            object = element$iv;
                            break block17;
                        }
                        object = null;
                    }
                    found = (Executable)object;
                    if (found != null) {
                        return UtilsKt.getFunctionType((Constructor)found);
                    }
                    throw new IllegalStateException(("not found: " + (Class)javaClass + " " + sig).toString());
                }
            }
        }
        if (kCallable instanceof KProperty) {
            Object object = ReflectJvmMapping.getJavaGetter((KProperty)((KProperty)$this$functionType));
            if (object == null || (object = UtilsKt.getFunctionType(object)) == null) {
                throw new IllegalStateException(("Getter for " + $this$functionType + " not found").toString());
            }
            return object;
        }
        throw new IllegalStateException(("Unknown KCallable type: " + Reflection.getOrCreateKotlinClass($this$functionType.getClass())).toString());
    }

    @NotNull
    public static final String getParamSignature(@NotNull KCallable<?> $this$paramSignature) {
        Intrinsics.checkNotNullParameter($this$paramSignature, (String)"<this>");
        return CollectionsKt.joinToString$default((Iterable)UtilsKt.getSootParamStringList($this$paramSignature), (CharSequence)",", (CharSequence)"(", (CharSequence)")", (int)0, null, null, (int)56, null);
    }

    @NotNull
    public static final String getSootSubSignature(@NotNull KCallable<?> $this$sootSubSignature) {
        String string;
        Intrinsics.checkNotNullParameter($this$sootSubSignature, (String)"<this>");
        KCallable<?> kCallable = $this$sootSubSignature;
        if (kCallable instanceof KFunction) {
            string = UtilsKt.getSootReturnType($this$sootSubSignature) + " " + ((KFunction)$this$sootSubSignature).getName() + UtilsKt.getParamSignature($this$sootSubSignature);
        } else if (kCallable instanceof KProperty) {
            string = UtilsKt.getSootReturnType($this$sootSubSignature) + " " + ((KProperty)$this$sootSubSignature).getName();
        } else {
            throw new IllegalStateException(("Unknown KCallable type: " + Reflection.getOrCreateKotlinClass($this$sootSubSignature.getClass())).toString());
        }
        return string;
    }

    @NotNull
    public static final String getDeclaringClassName(@NotNull KCallable<?> $this$declaringClassName) {
        Intrinsics.checkNotNullParameter($this$declaringClassName, (String)"<this>");
        return UtilsKt.getSootTypeName(UtilsKt.getDeclaringClass($this$declaringClassName));
    }

    @NotNull
    public static final String getSootTypeName(@NotNull KProperty<?> $this$sootTypeName) {
        Intrinsics.checkNotNullParameter($this$sootTypeName, (String)"<this>");
        Object object = $this$sootTypeName instanceof CallableReference ? (CallableReference)$this$sootTypeName : null;
        if (object == null || (object = UtilsKt.getJimpleDesc(object)) == null || (object = (String)CollectionsKt.lastOrNull((List)object)) == null) {
            GenericDeclaration genericDeclaration = ReflectJvmMapping.getJavaGetter($this$sootTypeName);
            if (genericDeclaration != null && (genericDeclaration = genericDeclaration.getReturnType()) != null) {
                object = UtilsKt.getSootTypeName(genericDeclaration);
            } else {
                AnnotatedElement annotatedElement = ReflectJvmMapping.getJavaField($this$sootTypeName);
                if ((annotatedElement != null && (annotatedElement = annotatedElement.getType()) != null ? UtilsKt.getSootTypeName(annotatedElement) : (object = null)) == null) {
                    throw new IllegalStateException(("not support " + $this$sootTypeName).toString());
                }
            }
        }
        return object;
    }

    @NotNull
    public static final String getSootSignature(@NotNull KCallable<?> $this$sootSignature) {
        Intrinsics.checkNotNullParameter($this$sootSignature, (String)"<this>");
        return "<" + UtilsKt.getDeclaringClassName($this$sootSignature) + ": " + UtilsKt.getSootSubSignature($this$sootSignature) + ">";
    }

    @NotNull
    public static final <R> KCallable<R> getCallable(@NotNull Function<? extends R> $this$callable) {
        Intrinsics.checkNotNullParameter($this$callable, (String)"<this>");
        return (KCallable)$this$callable;
    }

    public static /* synthetic */ void getCallable$annotations(Function function) {
    }

    @NotNull
    public static final List<SootClass> findAncestors(@NotNull SootClass sc) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        SootClass $this$findAncestors_u24lambda_u247 = sc;
        boolean bl = false;
        List superClasses = new ArrayList();
        List superInterfaces = new ArrayList();
        if ($this$findAncestors_u24lambda_u247.isInterface()) {
            Collection collection = superInterfaces;
            List list = Scene.v().getActiveHierarchy().getSuperinterfacesOfIncluding($this$findAncestors_u24lambda_u247);
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getSuperinterfacesOfIncluding(...)");
            CollectionsKt.addAll((Collection)collection, (Iterable)list);
        } else {
            Iterable list$iv$iv;
            SootClass it;
            Iterable $this$flatMapTo$iv$iv;
            Iterable $this$flatMap$iv;
            Collection collection = superClasses;
            List list = Scene.v().getActiveHierarchy().getSuperclassesOfIncluding($this$findAncestors_u24lambda_u247);
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getSuperclassesOfIncluding(...)");
            CollectionsKt.addAll((Collection)collection, (Iterable)list);
            collection = superInterfaces;
            Iterable iterable = superClasses;
            boolean $i$f$flatMap = false;
            void var8_9 = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                it = (SootClass)element$iv$iv;
                boolean bl2 = false;
                Chain chain = it.getInterfaces();
                Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getInterfaces(...)");
                list$iv$iv = (Iterable)chain;
                CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
            }
            $this$flatMap$iv = (List)destination$iv$iv;
            $i$f$flatMap = false;
            $this$flatMapTo$iv$iv = $this$flatMap$iv;
            destination$iv$iv = new ArrayList();
            $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                it = (SootClass)element$iv$iv;
                boolean bl3 = false;
                List list2 = Scene.v().getActiveHierarchy().getSuperinterfacesOfIncluding(it);
                Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"getSuperinterfacesOfIncluding(...)");
                list$iv$iv = list2;
                CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
            }
            iterable = (List)destination$iv$iv;
            CollectionsKt.addAll((Collection)collection, (Iterable)iterable);
        }
        return CollectionsKt.plus((Collection)superClasses, (Iterable)superInterfaces);
    }

    @Nullable
    public static final SootClass superClassOrNull(@NotNull SootClass $this$superClassOrNull) {
        Intrinsics.checkNotNullParameter((Object)$this$superClassOrNull, (String)"<this>");
        return $this$superClassOrNull.hasSuperclass() ? $this$superClassOrNull.getSuperclass() : null;
    }

    @NotNull
    public static final Sequence<SootClass> getSuperClasses(@NotNull SootClass $this$superClasses) {
        Intrinsics.checkNotNullParameter((Object)$this$superClasses, (String)"<this>");
        return SequencesKt.generateSequence((Object)$this$superClasses, UtilsKt::_get_superClasses_$lambda$8);
    }

    @NotNull
    public static final Sequence<SootClass> getSuperInterfaces(@NotNull SootClass $this$superInterfaces) {
        Intrinsics.checkNotNullParameter((Object)$this$superInterfaces, (String)"<this>");
        return SequencesKt.distinct((Sequence)SequencesKt.flatMapIterable(UtilsKt.getSuperClasses($this$superInterfaces), UtilsKt::_get_superInterfaces_$lambda$10));
    }

    @Nullable
    public static final VisibilityAnnotationTag getVisibilityAnnotationTag(@NotNull SootMethod $this$visibilityAnnotationTag) {
        Intrinsics.checkNotNullParameter((Object)$this$visibilityAnnotationTag, (String)"<this>");
        return (VisibilityAnnotationTag)$this$visibilityAnnotationTag.getTag("VisibilityAnnotationTag");
    }

    public static final Level level(@NotNull org.slf4j.event.Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return Level.toLevel((String)level.name());
    }

    @Nullable
    public static final String getTypename(@NotNull soot.Type $this$getTypename, boolean bl) {
        String string;
        Intrinsics.checkNotNullParameter((Object)$this$getTypename, (String)"<this>");
        soot.Type type = $this$getTypename;
        if (type instanceof RefType) {
            if (bl) {
                String string2 = ((RefType)$this$getTypename).getClassName();
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getClassName(...)");
                string = StringsKt.substringAfterLast$default((String)string2, (String)".", null, (int)2, null);
            } else {
                string = ((RefType)$this$getTypename).getClassName();
            }
        } else if (type instanceof LongType) {
            string = "long";
        } else if (type instanceof ShortType) {
            string = "short";
        } else if (type instanceof DoubleType) {
            string = "double";
        } else if (type instanceof IntType) {
            string = "int";
        } else if (type instanceof FloatType) {
            string = "float";
        } else if (type instanceof ByteType) {
            string = "byte";
        } else if (type instanceof CharType) {
            string = "char";
        } else if (type instanceof VoidType) {
            string = "void";
        } else if (type instanceof BooleanType) {
            string = "boolean";
        } else {
            if (type instanceof ArrayType) {
                StringBuilder buffer = new StringBuilder();
                soot.Type type2 = ((ArrayType)$this$getTypename).baseType;
                Intrinsics.checkNotNullExpressionValue((Object)type2, (String)"baseType");
                String string3 = UtilsKt.getTypename(type2);
                if (string3 == null) {
                    return null;
                }
                buffer.append(string3);
                int n = ((ArrayType)$this$getTypename).numDimensions;
                for (int i = 0; i < n; ++i) {
                    buffer.append("[]");
                }
                return buffer.toString();
            }
            string = null;
        }
        return string;
    }

    public static /* synthetic */ String getTypename$default(soot.Type type, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        return UtilsKt.getTypename(type, bl);
    }

    @Nullable
    public static final String getTypename(@NotNull soot.Type $this$typename) {
        Intrinsics.checkNotNullParameter((Object)$this$typename, (String)"<this>");
        return UtilsKt.getTypename($this$typename, false);
    }

    public static final void adjustLevel(@NotNull SootClass $this$adjustLevel, int level) {
        Intrinsics.checkNotNullParameter((Object)$this$adjustLevel, (String)"<this>");
        if ($this$adjustLevel.resolvingLevel() < level) {
            $this$adjustLevel.setResolvingLevel(level);
        }
    }

    @NotNull
    public static final Sequence<SootMethod> resolveCallsDispatchChainBase(@NotNull SootClass $this$resolveCallsDispatchChainBase, @NotNull String subSignature, @NotNull Function1<? super SootMethod, Boolean> predicate) {
        Intrinsics.checkNotNullParameter((Object)$this$resolveCallsDispatchChainBase, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)subSignature, (String)"subSignature");
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        UtilsKt.adjustLevel($this$resolveCallsDispatchChainBase, 2);
        String params = StringsKt.substringAfter$default((String)subSignature, (String)" ", null, (int)2, null);
        Sequence classes = SequencesKt.generateSequence((Object)$this$resolveCallsDispatchChainBase, UtilsKt::resolveCallsDispatchChainBase$lambda$11);
        Sequence interfaces = SequencesKt.distinct((Sequence)SequencesKt.flatMapIterable((Sequence)SequencesKt.generateSequence((Object)$this$resolveCallsDispatchChainBase, UtilsKt::resolveCallsDispatchChainBase$lambda$12), UtilsKt::resolveCallsDispatchChainBase$lambda$14));
        return SequencesKt.filter((Sequence)SequencesKt.flatMapIterable((Sequence)SequencesKt.plus((Sequence)classes, (Sequence)interfaces), UtilsKt::resolveCallsDispatchChainBase$lambda$15), arg_0 -> UtilsKt.resolveCallsDispatchChainBase$lambda$16(params, predicate, arg_0));
    }

    @NotNull
    public static final Sequence<SootMethod> resolveCallsDispatchChain(@NotNull SootClass $this$resolveCallsDispatchChain, @NotNull String subSignature, @Nullable Function1<? super SootMethod, Boolean> predicate) {
        Intrinsics.checkNotNullParameter((Object)$this$resolveCallsDispatchChain, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)subSignature, (String)"subSignature");
        return UtilsKt.resolveCallsDispatchChainBase($this$resolveCallsDispatchChain, subSignature, (Function1<? super SootMethod, Boolean>)((Function1)arg_0 -> UtilsKt.resolveCallsDispatchChain$lambda$17($this$resolveCallsDispatchChain, predicate, arg_0)));
    }

    public static /* synthetic */ Sequence resolveCallsDispatchChain$default(SootClass sootClass, String string, Function1 function1, int n, Object object) {
        if ((n & 2) != 0) {
            function1 = null;
        }
        return UtilsKt.resolveCallsDispatchChain(sootClass, string, (Function1<? super SootMethod, Boolean>)function1);
    }

    @Nullable
    public static final Body getActiveBodyOrNull(@NotNull SootMethod $this$activeBodyOrNull) {
        Intrinsics.checkNotNullParameter((Object)$this$activeBodyOrNull, (String)"<this>");
        return $this$activeBodyOrNull.hasActiveBody() ? $this$activeBodyOrNull.getActiveBody() : null;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final String getParameterNameByIndex(@NotNull SootMethod $this$getParameterNameByIndex, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$getParameterNameByIndex, (String)"<this>");
        int n = index;
        if (n == -1) {
            return $this$getParameterNameByIndex.getDeclaringClass().getShortName() + ".this";
        }
        boolean bl = 0 <= n ? n < $this$getParameterNameByIndex.getParameterCount() : false;
        if (bl) {
            Object names;
            String string;
            void $this$filterIsInstanceTo$iv$iv;
            List list = $this$getParameterNameByIndex.getTags();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getTags(...)");
            Iterable $this$filterIsInstance$iv = list;
            boolean $i$f$filterIsInstance = false;
            Iterable iterable = $this$filterIsInstance$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIsInstanceTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                if (!(element$iv$iv instanceof ParamNamesTag)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Object object = (ParamNamesTag)CollectionsKt.firstOrNull((List)((List)destination$iv$iv));
            if (object == null || (object = object.getNames()) == null) {
                object = CollectionsKt.emptyList();
            }
            if ((string = (String)CollectionsKt.getOrNull((List)(names = object), (int)index)) == null) {
                String string2;
                try {
                    String string3;
                    Body body = UtilsKt.getActiveBodyOrNull($this$getParameterNameByIndex);
                    if (body != null && (body = body.getParameterLocal(index)) != null) {
                        Body it = body;
                        boolean bl2 = false;
                        string3 = String.valueOf(it);
                    } else {
                        string3 = null;
                    }
                    string2 = string3;
                }
                catch (RuntimeException ignore) {
                    string2 = null;
                }
                string = string2;
            }
            return string;
        }
        return null;
    }

    @NotNull
    public static final String getSignatureWithOriginalName(@NotNull SootMethod $this$getSignatureWithOriginalName, boolean shortParamType) {
        Intrinsics.checkNotNullParameter((Object)$this$getSignatureWithOriginalName, (String)"<this>");
        String string = $this$getSignatureWithOriginalName.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        List list = $this$getSignatureWithOriginalName.getParameterTypes();
        soot.Type type = $this$getSignatureWithOriginalName.getReturnType();
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getReturnType(...)");
        String subSig = UtilsKt.getSignatureWithOriginalName$getSubSignatureImplInternal($this$getSignatureWithOriginalName, shortParamType, string, list, type);
        return $this$getSignatureWithOriginalName.getDeclaringClass().getName() + ": " + subSig;
    }

    public static /* synthetic */ String getSignatureWithOriginalName$default(SootMethod sootMethod, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        return UtilsKt.getSignatureWithOriginalName(sootMethod, bl);
    }

    @NotNull
    public static final Set<soot.Type> getPossibleTypes(@NotNull Value $this$possibleTypes) {
        Intrinsics.checkNotNullParameter((Object)$this$possibleTypes, (String)"<this>");
        if ($this$possibleTypes instanceof Constant) {
            return SetsKt.setOf((Object)((Constant)$this$possibleTypes).getType());
        }
        if (!($this$possibleTypes instanceof Local)) {
            return SetsKt.emptySet();
        }
        if (!Scene.v().hasPointsToAnalysis()) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        Set set = Scene.v().getPointsToAnalysis().reachingObjects((Local)$this$possibleTypes).possibleTypes();
        if (set == null) {
            set = SetsKt.emptySet();
        }
        return set;
    }

    private static final SootClass _get_superClasses_$lambda$8(SootClass it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return UtilsKt.superClassOrNull(it);
    }

    /*
     * WARNING - void declaration
     */
    private static final Iterable _get_superInterfaces_$lambda$10(SootClass sootClass) {
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)sootClass, (String)"sootClass");
        Chain chain = sootClass.getInterfaces();
        Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getInterfaces(...)");
        Iterable $this$flatMap$iv = (Iterable)chain;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            SootClass it = (SootClass)element$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            Iterable list$iv$iv = UtilsKt.findAncestors(it);
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private static final SootClass resolveCallsDispatchChainBase$lambda$11(SootClass it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return UtilsKt.superClassOrNull(it);
    }

    private static final SootClass resolveCallsDispatchChainBase$lambda$12(SootClass it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return UtilsKt.superClassOrNull(it);
    }

    /*
     * WARNING - void declaration
     */
    private static final Iterable resolveCallsDispatchChainBase$lambda$14(SootClass sootClass) {
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)sootClass, (String)"sootClass");
        Chain chain = sootClass.getInterfaces();
        Intrinsics.checkNotNullExpressionValue((Object)chain, (String)"getInterfaces(...)");
        Iterable $this$flatMap$iv = (Iterable)chain;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            SootClass it = (SootClass)element$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            Iterable list$iv$iv = UtilsKt.findAncestors(it);
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private static final Iterable resolveCallsDispatchChainBase$lambda$15(SootClass it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        List list = it.getMethods();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMethods(...)");
        return list;
    }

    private static final boolean resolveCallsDispatchChainBase$lambda$16(String $params, Function1 $predicate, SootMethod it) {
        String string = it.getSubSignature();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSubSignature(...)");
        if (!Intrinsics.areEqual((Object)StringsKt.substringAfter$default((String)string, (String)" ", null, (int)2, null), (Object)$params)) {
            return false;
        }
        Intrinsics.checkNotNull((Object)it);
        return (Boolean)$predicate.invoke((Object)it) != false;
    }

    private static final boolean resolveCallsDispatchChain$lambda$17(SootClass $this_resolveCallsDispatchChain, Function1 $predicate, SootMethod it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (!Intrinsics.areEqual((Object)$this_resolveCallsDispatchChain, (Object)it.getDeclaringClass())) {
            if (it.isConstructor()) {
                return false;
            }
            if (it.isStatic() || it.isStaticInitializer()) {
                return false;
            }
            if (it.isPrivate()) {
                return false;
            }
        }
        return $predicate == null || (Boolean)$predicate.invoke((Object)it) != false;
    }

    private static final CharSequence getSignatureWithOriginalName$getSubSignatureImplInternal$lambda$20(SootMethod $this_getSignatureWithOriginalName, boolean $shortParamType, IndexedValue indexedValue) {
        Object object;
        soot.Type it;
        block3: {
            block2: {
                Intrinsics.checkNotNullParameter((Object)indexedValue, (String)"<destruct>");
                int i = indexedValue.component1();
                it = (soot.Type)indexedValue.component2();
                object = UtilsKt.getParameterNameByIndex($this_getSignatureWithOriginalName, i);
                if (object == null) break block2;
                String it2 = object;
                boolean bl = false;
                String string = " " + it2;
                object = string;
                if (string != null) break block3;
            }
            object = "";
        }
        String paramName = object;
        return UtilsKt.getTypename(it, $shortParamType) + paramName;
    }

    private static final String getSignatureWithOriginalName$getSubSignatureImplInternal(SootMethod $this_getSignatureWithOriginalName, boolean $shortParamType, String name, List<? extends soot.Type> params, soot.Type returnType) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(returnType.toQuotedString());
        buffer.append(' ');
        buffer.append(Scene.v().quotedNameOf(name));
        buffer.append('(');
        if (params != null) {
            buffer.append(CollectionsKt.joinToString$default((Iterable)CollectionsKt.withIndex((Iterable)params), (CharSequence)",", null, null, (int)0, null, arg_0 -> UtilsKt.getSignatureWithOriginalName$getSubSignatureImplInternal$lambda$20($this_getSignatureWithOriginalName, $shortParamType, arg_0), (int)30, null));
        }
        buffer.append(')');
        String string = buffer.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }
}

