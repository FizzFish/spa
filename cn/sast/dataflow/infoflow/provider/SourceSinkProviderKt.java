/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.provider.SourceSinkProviderKt
 *  com.feysh.corax.config.api.MGlobal
 *  com.feysh.corax.config.api.MLocal
 *  com.feysh.corax.config.api.MParameter
 *  com.feysh.corax.config.api.MReturn
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootMethod
 *  soot.Type
 */
package cn.sast.dataflow.infoflow.provider;

import com.feysh.corax.config.api.MGlobal;
import com.feysh.corax.config.api.MLocal;
import com.feysh.corax.config.api.MParameter;
import com.feysh.corax.config.api.MReturn;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootMethod;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u001c\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\"\u0016\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"nullArg", "", "", "baseType", "Lsoot/Type;", "Lsoot/SootMethod;", "loc", "Lcom/feysh/corax/config/api/MLocal;", "corax-data-flow"})
public final class SourceSinkProviderKt {
    @Nullable
    private static final List<String> nullArg;

    @Nullable
    public static final Type baseType(@NotNull SootMethod $this$baseType, @NotNull MLocal loc) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)$this$baseType, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        MLocal mLocal = loc;
        if (mLocal instanceof MParameter) {
            object = ((MParameter)loc).getIndex() == -1 ? (Type)$this$baseType.getDeclaringClass().getType() : (((MParameter)loc).getIndex() >= $this$baseType.getParameterCount() ? null : $this$baseType.getParameterType(((MParameter)loc).getIndex()));
        } else if (mLocal instanceof MReturn) {
            object = $this$baseType.getReturnType();
        } else if (Intrinsics.areEqual((Object)mLocal, (Object)MGlobal.INSTANCE)) {
            object = (Type)Scene.v().getObjectType();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return object;
    }
}

