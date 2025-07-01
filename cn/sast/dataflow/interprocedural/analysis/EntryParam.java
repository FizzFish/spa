package cn.sast.dataflow.interprocedural.analysis;

import cn.sast.dataflow.interprocedural.analysis.IFieldManager;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JFieldType;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootMethod;
import soot.Type;

public class EntryParam implements IValue, IFieldManager<EntryParam> {
    @NotNull
    private final Type type;
    @NotNull
    private final SootMethod method;
    private final int paramIndex;
    @NotNull
    private final Map<PersistentList<JFieldType>, PhantomField<EntryParam>> fieldObjects;

    public EntryParam(@NotNull Type type, @NotNull SootMethod method, int paramIndex) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        this.type = type;
        this.method = method;
        this.paramIndex = paramIndex;
        this.fieldObjects = new LinkedHashMap<>();
    }

    public EntryParam(@NotNull SootMethod method, int paramIndex) {
        if (method == null) throw new IllegalArgumentException("method cannot be null");
        Type type = paramIndex != -1 
            ? method.getParameterType(paramIndex) 
            : method.getDeclaringClass().getType();
        if (type == null) throw new IllegalStateException("Type cannot be null");
        this.type = type;
        this.method = method;
        this.paramIndex = paramIndex;
        this.fieldObjects = new LinkedHashMap<>();
    }

    @Override
    @NotNull
    public Type getType() {
        return type;
    }

    @NotNull
    public SootMethod getMethod() {
        return method;
    }

    public int getParamIndex() {
        return paramIndex;
    }

    @Override
    @NotNull
    public Map<PersistentList<JFieldType>, PhantomField<EntryParam>> getPhantomFieldMap() {
        return fieldObjects;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof EntryParam)) return false;
        
        EntryParam that = (EntryParam) other;
        return paramIndex == that.paramIndex 
            && method.equals(that.method) 
            && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = method.hashCode();
        result = 31 * result + Integer.hashCode(paramIndex);
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public boolean typeIsConcrete() {
        return false;
    }

    @Override
    @NotNull
    public IValue copy(@NotNull Type type) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        return new EntryParam(type, method, paramIndex);
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
    @NotNull
    public String toString() {
        return "param<" + paramIndex + ">_" + type;
    }

    @Override
    public boolean isNormal() {
        return false;
    }

    @Override
    @Nullable
    public Boolean objectEqual(@NotNull IValue b) {
        if (b == null) throw new IllegalArgumentException("b cannot be null");
        return null;
    }

    @Override
    @NotNull
    public IValue clone() {
        return new EntryParam(type, method, paramIndex);
    }

    @Override
    @NotNull
    public PhantomField<EntryParam> getPhantomField(@NotNull JFieldType field) {
        if (field == null) throw new IllegalArgumentException("field cannot be null");
        return new PhantomField<>(this, field);
    }

    @Override
    @NotNull
    public PhantomField<EntryParam> getPhantomField(@NotNull PersistentList<? extends JFieldType> ap) {
        if (ap == null) throw new IllegalArgumentException("ap cannot be null");
        return new PhantomField<>(this, ap);
    }
}