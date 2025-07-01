package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.IFieldManager;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import kotlinx.collections.immutable.PersistentList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;
import soot.Unit;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class SummaryValue implements IValue, IFieldManager<SummaryValue> {
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

    public SummaryValue(@NotNull Type type, @NotNull Unit unit, @Nullable Object special) {
        this.type = type;
        this.unit = unit;
        this.special = special;
        this.fieldObjects = new LinkedHashMap<>();
    }

    @Override
    @NotNull
    public Type getType() {
        return type;
    }

    @NotNull
    public Unit getUnit() {
        return unit;
    }

    @Nullable
    public Object getSpecial() {
        return special;
    }

    @Override
    @NotNull
    public SummaryValue clone() {
        return new SummaryValue(getType(), unit, special);
    }

    @Override
    @NotNull
    public String toString() {
        return "Summary_" + getType() + "_" + unit + "_" + special + "_(" + hashCode() + ")";
    }

    @Override
    public boolean typeIsConcrete() {
        return false;
    }

    @Override
    @NotNull
    public IValue copy(@NotNull Type type) {
        Objects.requireNonNull(type, "type");
        return new SummaryValue(type, unit, special);
    }

    @Override
    public boolean isNullConstant() {
        return false;
    }

    @Override
    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Summary;
    }

    @Override
    @NotNull
    public Map<PersistentList<JFieldType>, PhantomField<SummaryValue>> getPhantomFieldMap() {
        return fieldObjects;
    }

    @Nullable
    public Integer getHashCode() {
        return hashCode;
    }

    public void setHashCode(@Nullable Integer hashCode) {
        this.hashCode = hashCode;
    }

    public int hash() {
        if (!FactValuesKt.getLeastExpr()) {
            return System.identityHashCode(this);
        }
        int result = 1;
        result = 31 * result + unit.hashCode();
        result = 31 * result + (special != null ? special.hashCode() : 0);
        result = 31 * result + getType().hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (!FactValuesKt.getLeastExpr()) {
            return this == other;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof SummaryValue)) {
            return false;
        }
        SummaryValue that = (SummaryValue) other;
        if (hashCode != null && that.hashCode != null && !hashCode.equals(that.hashCode)) {
            return false;
        }
        return unit.equals(that.unit) 
            && Objects.equals(special, that.special)
            && getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        if (hashCode == null) {
            hashCode = hash();
        }
        return hashCode;
    }

    @Override
    public boolean isNormal() {
        return false;
    }

    @Override
    @Nullable
    public Boolean objectEqual(@NotNull IValue b) {
        return null;
    }

    @Override
    @NotNull
    public PhantomField<SummaryValue> getPhantomField(@NotNull JFieldType field) {
        return IFieldManager.super.getPhantomField(field);
    }

    @Override
    @NotNull
    public PhantomField<SummaryValue> getPhantomField(@NotNull PersistentList<? extends JFieldType> ap) {
        return IFieldManager.super.getPhantomField(ap);
    }
}