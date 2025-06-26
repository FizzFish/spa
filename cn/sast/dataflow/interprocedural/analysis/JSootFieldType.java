/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.JSootFieldType
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootField
 *  soot.Type
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootField;
import soot.Type;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/JSootFieldType;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "sootField", "Lsoot/SootField;", "<init>", "(Lsoot/SootField;)V", "getSootField", "()Lsoot/SootField;", "type", "Lsoot/Type;", "getType", "()Lsoot/Type;", "name", "", "getName", "()Ljava/lang/String;", "hashCode", "", "equals", "", "other", "", "toString", "corax-data-flow"})
public final class JSootFieldType
extends JFieldType {
    @NotNull
    private final SootField sootField;

    public JSootFieldType(@NotNull SootField sootField) {
        Intrinsics.checkNotNullParameter((Object)sootField, (String)"sootField");
        super(null);
        this.sootField = sootField;
    }

    @NotNull
    public final SootField getSootField() {
        return this.sootField;
    }

    @NotNull
    public Type getType() {
        Type type = this.sootField.getType();
        Intrinsics.checkNotNullExpressionValue((Object)type, (String)"getType(...)");
        return type;
    }

    @NotNull
    public String getName() {
        String string = this.sootField.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        return string;
    }

    public int hashCode() {
        return this.getName().hashCode();
    }

    public boolean equals(@Nullable Object other) {
        JFieldType jFieldType = other instanceof JFieldType ? (JFieldType)other : null;
        return Intrinsics.areEqual((Object)this.getName(), (Object)(jFieldType != null ? jFieldType.getName() : null));
    }

    @NotNull
    public String toString() {
        return this.getName();
    }
}

