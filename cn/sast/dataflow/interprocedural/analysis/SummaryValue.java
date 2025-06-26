/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.interprocedural.analysis.FactValuesKt
 *  cn.sast.dataflow.interprocedural.analysis.IFieldManager
 *  cn.sast.dataflow.interprocedural.analysis.IFieldManager$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IValue
 *  cn.sast.dataflow.interprocedural.analysis.IValue$DefaultImpls
 *  cn.sast.dataflow.interprocedural.analysis.IValue$Kind
 *  cn.sast.dataflow.interprocedural.analysis.JFieldType
 *  cn.sast.dataflow.interprocedural.analysis.PhantomField
 *  cn.sast.dataflow.interprocedural.analysis.SummaryValue
 *  cn.sast.dataflow.interprocedural.analysis.SummaryValue$Companion
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.collections.immutable.PersistentList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Type
 *  soot.Unit
 */
package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.IFieldManager;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import cn.sast.dataflow.interprocedural.analysis.SummaryValue;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;
import soot.Unit;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 *2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001*B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0016\u001a\u00020\u0000H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00150\u0012H\u0016J\u0006\u0010'\u001a\u00020!J\u0013\u0010(\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00150\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006+"}, d2={"Lcn/sast/dataflow/interprocedural/analysis/SummaryValue;", "Lcn/sast/dataflow/interprocedural/analysis/IValue;", "Lcn/sast/dataflow/interprocedural/analysis/IFieldManager;", "type", "Lsoot/Type;", "unit", "Lsoot/Unit;", "special", "", "<init>", "(Lsoot/Type;Lsoot/Unit;Ljava/lang/Object;)V", "getType", "()Lsoot/Type;", "getUnit", "()Lsoot/Unit;", "getSpecial", "()Ljava/lang/Object;", "fieldObjects", "", "Lkotlinx/collections/immutable/PersistentList;", "Lcn/sast/dataflow/interprocedural/analysis/JFieldType;", "Lcn/sast/dataflow/interprocedural/analysis/PhantomField;", "clone", "toString", "", "typeIsConcrete", "", "copy", "isNullConstant", "getKind", "Lcn/sast/dataflow/interprocedural/analysis/IValue$Kind;", "getPhantomFieldMap", "hashCode", "", "getHashCode", "()Ljava/lang/Integer;", "setHashCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hash", "equals", "other", "Companion", "corax-data-flow"})
public class SummaryValue
implements IValue,
IFieldManager<SummaryValue> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Type type;
    @NotNull
    private final Unit unit;
    @Nullable
    private final Object special;
    @NotNull
    private final Map<PersistentList<JFieldType>, PhantomField<SummaryValue>> fieldObjects;
    @Nullable
    private Integer hashCode;

    private SummaryValue(Type type, Unit unit, Object special) {
        this.type = type;
        this.unit = unit;
        this.special = special;
        this.fieldObjects = new LinkedHashMap();
    }

    @NotNull
    public Type getType() {
        return this.type;
    }

    @NotNull
    public final Unit getUnit() {
        return this.unit;
    }

    @Nullable
    public final Object getSpecial() {
        return this.special;
    }

    @NotNull
    public SummaryValue clone() {
        return new SummaryValue(this.getType(), this.unit, this.special);
    }

    @NotNull
    public String toString() {
        return "Summary_" + this.getType() + "_" + this.unit + "_" + this.special + "_(" + this.hashCode() + ")";
    }

    public boolean typeIsConcrete() {
        return false;
    }

    @NotNull
    public IValue copy(@NotNull Type type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return (IValue)new SummaryValue(type, this.unit, this.special);
    }

    public boolean isNullConstant() {
        return false;
    }

    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Summary;
    }

    @NotNull
    public Map<PersistentList<JFieldType>, PhantomField<SummaryValue>> getPhantomFieldMap() {
        return this.fieldObjects;
    }

    @Nullable
    public final Integer getHashCode() {
        return this.hashCode;
    }

    public final void setHashCode(@Nullable Integer n) {
        this.hashCode = n;
    }

    public final int hash() {
        if (!FactValuesKt.getLeastExpr()) {
            return System.identityHashCode(this);
        }
        int result = 1;
        result = 31 * result + this.unit.hashCode();
        Object object = this.special;
        result = 31 * result + (object != null ? object.hashCode() : 0);
        result = 31 * result + this.getType().hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (!FactValuesKt.getLeastExpr()) {
            return this == other;
        }
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof SummaryValue)) {
            return false;
        }
        if (this.hashCode != null && ((SummaryValue)other).hashCode != null && !Intrinsics.areEqual((Object)this.hashCode, (Object)((SummaryValue)other).hashCode)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.unit, (Object)((SummaryValue)other).unit)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.special, (Object)((SummaryValue)other).special)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.getType(), (Object)((SummaryValue)other).getType());
    }

    public int hashCode() {
        Integer h = this.hashCode;
        if (h == null) {
            this.hashCode = h = Integer.valueOf(this.hash());
        }
        return h;
    }

    public boolean isNormal() {
        return IValue.DefaultImpls.isNormal((IValue)this);
    }

    @Nullable
    public Boolean objectEqual(@NotNull IValue b) {
        return IValue.DefaultImpls.objectEqual((IValue)this, (IValue)b);
    }

    @NotNull
    public PhantomField<SummaryValue> getPhantomField(@NotNull JFieldType field) {
        return IFieldManager.DefaultImpls.getPhantomField((IFieldManager)this, (JFieldType)field);
    }

    @NotNull
    public PhantomField<SummaryValue> getPhantomField(@NotNull PersistentList<? extends JFieldType> ap) {
        return IFieldManager.DefaultImpls.getPhantomField((IFieldManager)this, ap);
    }

    public /* synthetic */ SummaryValue(Type type, Unit unit, Object special, DefaultConstructorMarker $constructor_marker) {
        this(type, unit, special);
    }
}

