package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.FieldUtil;
import cn.sast.dataflow.interprocedural.analysis.IFieldManager;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Type;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PhantomField<V extends IValue> implements IValue {
    @NotNull
    private final Type type;
    @NotNull
    private final IFieldManager<V> base;
    @NotNull
    private final List<JFieldType> accessPath;

    public PhantomField(@NotNull Type type, @NotNull IFieldManager<V> base, @NotNull List<? extends JFieldType> accessPath) {
        this.type = Objects.requireNonNull(type, "type");
        this.base = Objects.requireNonNull(base, "base");
        this.accessPath = List.copyOf(Objects.requireNonNull(accessPath, "accessPath"));
    }

    public PhantomField(@NotNull IFieldManager<V> base, @NotNull List<? extends JFieldType> accessPath) {
        this(FieldUtil.typeOf(accessPath.get(accessPath.size() - 1)), 
             Objects.requireNonNull(base, "base"), 
             List.copyOf(Objects.requireNonNull(accessPath, "accessPath")));
    }

    @Override
    @NotNull
    public Type getType() {
        return type;
    }

    @NotNull
    public IFieldManager<V> getBase() {
        return base;
    }

    @NotNull
    public List<JFieldType> getAccessPath() {
        return accessPath;
    }

    @Override
    @NotNull
    public String toString() {
        return "PhantomObject_" + getType() + "_" + base + "." + 
               accessPath.stream()
                        .map(JFieldType::getName)
                        .collect(Collectors.joining());
    }

    @Override
    public boolean typeIsConcrete() {
        return false;
    }

    @Override
    @NotNull
    public IValue copy(@NotNull Type type) {
        return new PhantomField<>(Objects.requireNonNull(type), base, accessPath);
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

    @NotNull
    public PhantomField<V> getPhantomField(@NotNull JFieldType field) {
        Objects.requireNonNull(field, "field");
        return base.getPhantomField(
            List.<JFieldType>builder()
                .addAll(accessPath)
                .add(field)
                .build()
        );
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof PhantomField)) return false;
        PhantomField<?> that = (PhantomField<?>) other;
        return base.equals(that.base) && 
               accessPath.equals(that.accessPath) && 
               type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, accessPath, type);
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
    public IValue clone() {
        return new PhantomField<>(type, base, accessPath);
    }
}