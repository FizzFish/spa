package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.utils.KFunctionType;
import com.feysh.corax.config.api.utils.SootMethodDesc;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Transient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootMethod;
import java.util.Collections;
import java.util.List;

@Serializable
@SerialName("SootSignatureMatch")
public final class SootSignatureMatch implements IMethodMatch {
    @NotNull
    private final SootMethodDesc sm;
    @Nullable
    private final Integer argumentCnt;
    @Nullable
    private final KFunctionType actualType;
    @NotNull
    private final Exception exception;

    public SootSignatureMatch(@NotNull SootMethodDesc sm, @Nullable Integer argumentCnt, @Nullable KFunctionType actualType) {
        if (sm == null) throw new IllegalArgumentException("sm cannot be null");
        this.sm = sm;
        this.argumentCnt = argumentCnt;
        this.actualType = actualType;
        this.exception = new Exception();
    }

    @NotNull
    public SootMethodDesc getSm() {
        return sm;
    }

    @Override
    @Nullable
    public Integer getArgumentCnt() {
        return argumentCnt;
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
    @NotNull
    public List<SootMethod> matched(@NotNull Scene scene) {
        if (scene == null) throw new IllegalArgumentException("scene cannot be null");
        SootMethod sootMethod = scene.grabMethod(sm.getSignature());
        if (sootMethod == null) {
            return Collections.emptyList();
        }

        if (actualType != null) {
            if (sootMethod.isConstructor() && actualType != KFunctionType.Constructor) {
                return Collections.emptyList();
            }
            if (sootMethod.isStatic() && actualType != KFunctionType.StaticMethod) {
                return Collections.emptyList();
            }
            if (!sootMethod.isStatic() && !sootMethod.isConstructor() && !sootMethod.isStaticInitializer() 
                && actualType != KFunctionType.InstanceMethod) {
                return Collections.emptyList();
            }
        }
        return Collections.singletonList(sootMethod);
    }

    @Override
    @NotNull
    public String toString() {
        return "match sootMethod: " + sm;
    }

    public static final class Companion {
        @NotNull
        public <R> SootSignatureMatch invoke(@NotNull Function<? extends R> function) {
            if (function == null) throw new IllegalArgumentException("function cannot be null");
            String sootSig = UtilsKt.getSootSignature((KCallable)function);
            SootMethodDesc sootMethodDesc = SootMethodDesc.Companion.invoke(sootSig);
            if (sootMethodDesc == null) {
                throw new IllegalStateException("invalid soot signature: " + sootSig);
            }
            return new SootSignatureMatch(
                sootMethodDesc, 
                UtilsKt.getSootParamStringList((KCallable)function).size(), 
                UtilsKt.getFunctionType((KCallable)function)
            );
        }

        @NotNull
        public SootSignatureMatch invoke(@NotNull String sootSig) {
            if (sootSig == null) throw new IllegalArgumentException("sootSig cannot be null");
            SootMethodDesc sootMethodDesc = SootMethodDesc.Companion.invoke(sootSig);
            if (sootMethodDesc == null) {
                throw new IllegalStateException("invalid soot signature: " + sootSig);
            }
            return new SootSignatureMatch(sootMethodDesc, sootMethodDesc.getParameters().size(), null);
        }

        @NotNull
        public SootSignatureMatch invoke(@NotNull SootMethod sm) {
            if (sm == null) throw new IllegalArgumentException("sm cannot be null");
            SootMethodDesc smd = SootMethodDesc.Companion.invoke(sm);
            return new SootSignatureMatch(smd, sm.getParameterCount(), UtilsKt.getFunctionType(sm));
        }
    }
}
