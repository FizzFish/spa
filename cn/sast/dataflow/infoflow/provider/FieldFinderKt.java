/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.provider.FieldFinderKt
 *  com.feysh.corax.config.api.ClassField
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootField
 *  soot.Type
 */
package cn.sast.dataflow.infoflow.provider;

import com.feysh.corax.config.api.ClassField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"sootField", "Lsoot/SootField;", "Lcom/feysh/corax/config/api/ClassField;", "getSootField", "(Lcom/feysh/corax/config/api/ClassField;)Lsoot/SootField;", "corax-data-flow"})
public final class FieldFinderKt {
    @Nullable
    public static final SootField getSootField(@NotNull ClassField $this$sootField) {
        SootField sootField;
        Intrinsics.checkNotNullParameter((Object)$this$sootField, (String)"<this>");
        String string = $this$sootField.getDeclaringClassType();
        if (string == null) {
            return null;
        }
        String declaringClassType = string;
        SootClass sootClass = Scene.v().getSootClassUnsafe(declaringClassType, false);
        if (sootClass == null) {
            return null;
        }
        SootClass sc = sootClass;
        if ($this$sootField.getFieldType() == null) {
            sootField = sc.getFieldByNameUnsafe($this$sootField.getFieldName());
        } else {
            Type type = Scene.v().getTypeUnsafe($this$sootField.getFieldType());
            if (type == null) {
                return sc.getFieldByNameUnsafe($this$sootField.getFieldName());
            }
            Type type2 = type;
            sootField = sc.getFieldUnsafe($this$sootField.getFieldName(), type2);
        }
        return sootField;
    }
}

