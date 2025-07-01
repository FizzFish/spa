package cn.sast.dataflow.interprocedural.check;

import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.JOperatorHV;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JOperatorHVImpl implements JOperatorHV<IValue> {
    @NotNull
    private final AbstractHeapFactory<IValue> heapFactory;
    @NotNull
    private final HeapValuesEnv env;
    @NotNull
    private final IHeapValues<IValue> value;
    @NotNull
    private final PathFactory<IValue> pf;

    public JOperatorHVImpl(@NotNull AbstractHeapFactory<IValue> heapFactory, 
                          @NotNull HeapValuesEnv env, 
                          @NotNull IHeapValues<IValue> value) {
        if (heapFactory == null) throw new IllegalArgumentException("heapFactory");
        if (env == null) throw new IllegalArgumentException("env");
        if (value == null) throw new IllegalArgumentException("value");
        
        this.heapFactory = heapFactory;
        this.env = env;
        this.value = value;
        this.pf = heapFactory.getPathFactory();
    }

    @NotNull
    public AbstractHeapFactory<IValue> getHeapFactory() {
        return heapFactory;
    }

    @NotNull
    public HeapValuesEnv getEnv() {
        return env;
    }

    @NotNull
    public PathFactory<IValue> getPf() {
        return pf;
    }

    @Override
    @NotNull
    public IHeapValues<IValue> pop() {
        return value;
    }

    @Override
    @NotNull
    public <K> JOperatorHV<IValue> setKVValue(@NotNull Object mt, 
                                            @NotNull CompanionV<IValue> lhs, 
                                            @Nullable K key) {
        if (mt == null) throw new IllegalArgumentException("mt");
        if (lhs == null) throw new IllegalArgumentException("lhs");
        
        return copy(null, null, pf.updatePath(env, value, (v, valuePath) -> {
            if (v == null) throw new IllegalArgumentException("v");
            if (valuePath == null) throw new IllegalArgumentException("valuePath");
            
            IValue iValue = lhs.getValue();
            if (!(lhs instanceof PathCompanionV)) throw new ClassCastException();
            return SetEdgePath.Companion.v(env, iValue, ((PathCompanionV)lhs).getPath(), 
                                         mt, key, v, valuePath);
        });
    }

    @Override
    @NotNull
    public <K> JOperatorHV<IValue> getKVValue(@NotNull Object mt, 
                                            @NotNull CompanionV<IValue> rhs, 
                                            @Nullable K key) {
        if (mt == null) throw new IllegalArgumentException("mt");
        if (rhs == null) throw new IllegalArgumentException("rhs");
        
        return copy(null, null, pf.updatePath(env, value, (v, valuePath) -> {
            if (v == null) throw new IllegalArgumentException("v");
            if (valuePath == null) throw new IllegalArgumentException("valuePath");
            
            IValue iValue = rhs.getValue();
            if (!(rhs instanceof PathCompanionV)) throw new ClassCastException();
            return GetEdgePath.Companion.v(env, iValue, ((PathCompanionV)rhs).getPath(), 
                                         mt, key, v, valuePath);
        }));
    }

    @Override
    @NotNull
    public JOperatorHV<IValue> assignLocal(@NotNull Object lhs, 
                                         @NotNull IHeapValues<IValue> rhsValue) {
        if (lhs == null) throw new IllegalArgumentException("lhs");
        if (rhsValue == null) throw new IllegalArgumentException("rhsValue");
        
        return copy(null, null, pf.updatePath(env, value, (v, valuePath) -> {
            if (v == null) throw new IllegalArgumentException("v");
            if (valuePath == null) throw new IllegalArgumentException("valuePath");
            return AssignLocalPath.Companion.v(env, lhs, v, valuePath);
        }));
    }

    @Override
    @NotNull
    public JOperatorHV<IValue> markOfArrayLength(@NotNull CompanionV<IValue> rhs) {
        if (rhs == null) throw new IllegalArgumentException("rhs");
        return this;
    }

    @Override
    @NotNull
    public JOperatorHV<IValue> dataElementCopyToSequenceElement(@NotNull IHeapValues<IValue> sourceElement) {
        if (sourceElement == null) throw new IllegalArgumentException("sourceElement");
        return this;
    }

    @NotNull
    public JOperatorHVImpl copy(@NotNull AbstractHeapFactory<IValue> heapFactory, 
                              @NotNull HeapValuesEnv env, 
                              @NotNull IHeapValues<IValue> value) {
        if (heapFactory == null) throw new IllegalArgumentException("heapFactory");
        if (env == null) throw new IllegalArgumentException("env");
        if (value == null) throw new IllegalArgumentException("value");
        
        return new JOperatorHVImpl(heapFactory, env, value);
    }

    @Override
    public String toString() {
        return "JOperatorHVImpl(heapFactory=" + heapFactory + 
               ", env=" + env + 
               ", value=" + value + ")";
    }

    @Override
    public int hashCode() {
        int result = heapFactory.hashCode();
        result = 31 * result + env.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof JOperatorHVImpl)) return false;
        
        JOperatorHVImpl that = (JOperatorHVImpl) other;
        return heapFactory.equals(that.heapFactory) &&
               env.equals(that.env) &&
               value.equals(that.value);
    }
}