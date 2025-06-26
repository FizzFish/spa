/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.svfa.AP
 *  cn.sast.dataflow.infoflow.svfa.AP$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.NullType
 *  soot.SootField
 *  soot.Type
 *  soot.Value
 *  soot.jimple.internal.JimpleLocal
 */
package cn.sast.dataflow.infoflow.svfa;

import cn.sast.dataflow.infoflow.svfa.AP;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.NullType;
import soot.SootField;
import soot.Type;
import soot.Value;
import soot.jimple.internal.JimpleLocal;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0000J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2={"Lcn/sast/dataflow/infoflow/svfa/AP;", "", "value", "Lsoot/Value;", "field", "Lsoot/SootField;", "<init>", "(Lsoot/Value;Lsoot/SootField;)V", "getValue", "()Lsoot/Value;", "getField", "()Lsoot/SootField;", "base", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "Companion", "corax-data-flow"})
public final class AP {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Value value;
    @Nullable
    private final SootField field;
    @NotNull
    private static final Value staticValue = (Value)new JimpleLocal("staticValueFake", (Type)NullType.v());

    public AP(@NotNull Value value, @Nullable SootField field) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.value = value;
        this.field = field;
    }

    public /* synthetic */ AP(Value value, SootField sootField, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            sootField = null;
        }
        this(value, sootField);
    }

    @NotNull
    public final Value getValue() {
        return this.value;
    }

    @Nullable
    public final SootField getField() {
        return this.field;
    }

    @NotNull
    public final AP base() {
        return this.field == null ? this : new AP(this.value, null, 2, null);
    }

    @NotNull
    public String toString() {
        return this.field != null ? this.value + "." + this.field.getName() : String.valueOf(this.value);
    }

    @NotNull
    public final Value component1() {
        return this.value;
    }

    @Nullable
    public final SootField component2() {
        return this.field;
    }

    @NotNull
    public final AP copy(@NotNull Value value, @Nullable SootField field) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return new AP(value, field);
    }

    public static /* synthetic */ AP copy$default(AP aP, Value value, SootField sootField, int n, Object object) {
        if ((n & 1) != 0) {
            value = aP.value;
        }
        if ((n & 2) != 0) {
            sootField = aP.field;
        }
        return aP.copy(value, sootField);
    }

    public int hashCode() {
        int result = this.value.hashCode();
        result = result * 31 + (this.field == null ? 0 : this.field.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AP)) {
            return false;
        }
        AP aP = (AP)other;
        if (!Intrinsics.areEqual((Object)this.value, (Object)aP.value)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.field, (Object)aP.field);
    }

    public static final /* synthetic */ Value access$getStaticValue$cp() {
        return staticValue;
    }
}

