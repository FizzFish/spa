package com.feysh.corax.config.api;

import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IAccessPathT;
import com.feysh.corax.config.api.IAttribute;
import com.feysh.corax.config.api.IBoolExpr;
import com.feysh.corax.config.api.ILocalT;
import com.feysh.corax.config.api.ILocalValue;
import com.feysh.corax.config.api.IMethodDecl;
import com.feysh.corax.config.api.IParameterT;
import com.feysh.corax.config.api.ISootClassDecl;
import com.feysh.corax.config.api.IStringExpr;
import com.feysh.corax.config.api.ITaintType;
import com.feysh.corax.config.api.IViaType;
import com.feysh.corax.config.api.MethodConfig;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.ViaProperty;
import com.feysh.corax.config.api.baseimpl.ConfigException;
import com.feysh.corax.config.api.baseimpl.SootParameter;
import com.feysh.corax.config.api.baseimpl.SootReturn;
import com.feysh.corax.config.api.utils.KFunctionType;
import com.feysh.corax.config.api.utils.UtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.tagkit.VisibilityParameterAnnotationTag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;

public interface ISootMethodDecl<R> extends IMethodDecl<R> {
    @NotNull
    ISootClassDecl getClazz();

    @NotNull
    SootMethod getSootMethod();

    @NotNull
    default SootClass getSootClass() {
        return getSootMethod().getDeclaringClass();
    }

    @Override
    @NotNull
    default Integer getArgumentCnt() {
        return getSootMethod().getParameterCount();
    }

    @Override
    @NotNull
    default KFunctionType getActualType() {
        return UtilsKt.getFunctionType(getSootMethod());
    }

    @Nullable
    default VisibilityParameterAnnotationTag getParameterAnnotationTag() {
        return (VisibilityParameterAnnotationTag) getSootMethod().getTag("VisibilityParameterAnnotationTag");
    }

    @Nullable
    default VisibilityAnnotationTag getVisibilityAnnotationTag(@NotNull IParameterT<?> receiver) {
        if (receiver.getIndex() >= 0) {
            VisibilityParameterAnnotationTag tag = getParameterAnnotationTag();
            if (tag != null) {
                List<VisibilityAnnotationTag> annotations = tag.getVisibilityAnnotations();
                if (annotations != null) {
                    return annotations.get(receiver.getIndex());
                }
            }
        }
        return null;
    }

    @NotNull
    default List<AnnotationTag> getAnnotationTag(@NotNull IParameterT<?> receiver) {
        VisibilityAnnotationTag tag = getVisibilityAnnotationTag(receiver);
        return tag != null && tag.getAnnotations() != null ? tag.getAnnotations() : Collections.emptyList();
    }

    @NotNull
    default List<Tag> getTags() {
        return getSootMethod().getTags();
    }

    @Nullable
    default AnnotationTag getAnnotationTag() {
        return (AnnotationTag) getSootMethod().getTag("AnnotationTag");
    }

    @Nullable
    default VisibilityAnnotationTag getVisibilityAnnotationTag() {
        return UtilsKt.getVisibilityAnnotationTag(getSootMethod());
    }

    @Override
    @NotNull
    CheckBuilder<R> checkBuilder(@NotNull Consumer<MethodConfig> config);

    @NotNull
    default ISootMethodDecl<R> model(@NotNull Consumer<MethodConfig> config, @NotNull BiConsumer<CheckBuilder<R>, IParameterT<Object>[]> block) {
        int cnt = getArgumentCnt();
        CheckBuilder<R> builder = checkBuilder(config);
        try {
            IParameterT<Object>[] params = new IParameterT[cnt];
            for (int i = 0; i < cnt; i++) {
                params[i] = builder.paramAt(i);
            }
            block.accept(builder, params);
        } catch (ConfigException e) {
            System.err.println(e);
        }
        return this;
    }

    @NotNull
    default ISootMethodDecl<R> modelNoArg(@NotNull Consumer<MethodConfig> config, @NotNull Consumer<CheckBuilder<R>> block) {
        CheckBuilder<R> builder = checkBuilder(config);
        try {
            block.accept(builder);
        } catch (ConfigException e) {
            System.err.println(e);
        }
        return this;
    }

    interface CheckBuilder<R> extends IMethodDecl.CheckBuilder<R> {
        @Override
        @NotNull
        ISootMethodDecl<R> getMethod();

        @NotNull
        SootParameter<Object> getThis();

        @NotNull
        SootParameter<Object> getP0();
        @NotNull
        SootParameter<Object> getP1();
        @NotNull
        SootParameter<Object> getP2();
        @NotNull
        SootParameter<Object> getP3();
        @NotNull
        SootParameter<Object> getP4();
        @NotNull
        SootParameter<Object> getP5();
        @NotNull
        SootParameter<Object> getP6();
        @NotNull
        SootParameter<Object> getP7();
        @NotNull
        SootParameter<Object> getP8();
        @NotNull
        SootParameter<Object> getP9();
        @NotNull
        SootParameter<Object> getP10();
        @NotNull
        SootParameter<Object> getP11();
        @NotNull
        SootParameter<Object> getP12();
        @NotNull
        SootParameter<Object> getP13();
        @NotNull
        SootParameter<Object> getP14();
        @NotNull
        SootParameter<Object> getP15();

        @Override
        @NotNull
        <T> SootParameter<T> paramAt(int index);

        @Override
        @NotNull
        SootReturn<R> getReturn();

        @NotNull
        default SootParameter<Object> parameter(int index) {
            return paramAt(index);
        }

        @NotNull
        default SootParameter<Object> getThis() {
            return paramAt(-1);
        }

        @NotNull
        default SootParameter<Object> getP0() {
            return paramAt(0);
        }

        @NotNull
        default SootParameter<Object> getP1() {
            return paramAt(1);
        }

        @NotNull
        default SootParameter<Object> getP2() {
            return paramAt(2);
        }

        @NotNull
        default SootParameter<Object> getP3() {
            return paramAt(3);
        }

        @NotNull
        default SootParameter<Object> getP4() {
            return paramAt(4);
        }

        @NotNull
        default SootParameter<Object> getP5() {
            return paramAt(5);
        }

        @NotNull
        default SootParameter<Object> getP6() {
            return paramAt(6);
        }

        @NotNull
        default SootParameter<Object> getP7() {
            return paramAt(7);
        }

        @NotNull
        default SootParameter<Object> getP8() {
            return paramAt(8);
        }

        @NotNull
        default SootParameter<Object> getP9() {
            return paramAt(9);
        }

        @NotNull
        default SootParameter<Object> getP10() {
            return paramAt(10);
        }

        @NotNull
        default SootParameter<Object> getP11() {
            return paramAt(11);
        }

        @NotNull
        default SootParameter<Object> getP12() {
            return paramAt(12);
        }

        @NotNull
        default SootParameter<Object> getP13() {
            return paramAt(13);
        }

        @NotNull
        default SootParameter<Object> getP14() {
            return paramAt(14);
        }

        @NotNull
        default SootParameter<Object> getP15() {
            return paramAt(15);
        }
    }
}
