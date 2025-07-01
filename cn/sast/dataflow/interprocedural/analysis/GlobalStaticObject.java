package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IFieldManager;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.RefType;
import soot.Scene;
import soot.Type;
import kotlinx.collections.immutable.PersistentList;

public class GlobalStaticObject implements IValue, IFieldManager<GlobalStaticObject> {
    @NotNull
    private final Map<PersistentList<JFieldType>, PhantomField<GlobalStaticObject>> fieldObjects = new LinkedHashMap<>();
    @NotNull
    private final Type type;

    public GlobalStaticObject() {
        this.type = Scene.v().getObjectType();
    }

    @Override
    @NotNull
    public Map<PersistentList<JFieldType>, PhantomField<GlobalStaticObject>> getPhantomFieldMap() {
        return fieldObjects;
    }

    @Override
    @NotNull
    public String toString() {
        return "GlobalStaticObject";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return other instanceof GlobalStaticObject;
    }

    @Override
    public int hashCode() {
        return 30864;
    }

    @Override
    @NotNull
    public Type getType() {
        return type;
    }

    @Override
    public boolean typeIsConcrete() {
        return true;
    }

    @Override
    public boolean isNullConstant() {
        return false;
    }

    @Override
    @NotNull
    public IValue.Kind getKind() {
        return IValue.Kind.Entry;
    }

    @Override
    public boolean isNormal() {
        return true;
    }

    @Override
    @Nullable
    public Boolean objectEqual(@NotNull IValue b) {
        return equals(b);
    }

    @Override
    @NotNull
    public IValue clone() {
        return new GlobalStaticObject();
    }

    @Override
    @NotNull
    public IValue copy(@NotNull Type type) {
        return clone();
    }

    @Override
    @NotNull
    public PhantomField<GlobalStaticObject> getPhantomField(@NotNull JFieldType field) {
        return fieldObjects.computeIfAbsent(
            PersistentList.of(field), 
            k -> new PhantomField<>(this)
        );
    }

    @Override
    @NotNull
    public PhantomField<GlobalStaticObject> getPhantomField(@NotNull PersistentList<? extends JFieldType> ap) {
        return fieldObjects.computeIfAbsent(
            (PersistentList<JFieldType>) ap, 
            k -> new PhantomField<>(this)
        );
    }
}