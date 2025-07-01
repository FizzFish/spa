package cn.sast.dataflow.interprocedural.check;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.*;
import cn.sast.dataflow.interprocedural.check.heapimpl.*;
import cn.sast.idfa.check.ICallCB;
import com.feysh.corax.config.api.*;
import com.feysh.corax.config.api.utils.UtilsKt;
import kotlin.sequences.Sequence;
import soot.*;
import soot.jimple.*;
import soot.jimple.internal.JIfStmt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public final class HeapFactory extends AbstractHeapFactory<IValue> {
    private final IVGlobal vg;
    private final HeapValues empty;
    private final IValue nullConst;

    public HeapFactory(@NotNull IVGlobal vg) {
        if (vg == null) throw new IllegalArgumentException("vg cannot be null");
        this.vg = vg;
        this.empty = HeapValues.Companion.empty$corax_data_flow();
        NullConstant nullConstant = NullConstant.v();
        this.nullConst = ConstVal.Companion.v(nullConstant, G.v().soot_NullType());
    }

    @NotNull
    public IVGlobal getVg() {
        return vg;
    }

    @NotNull
    public HeapValues getEmpty() {
        return empty;
    }

    @NotNull
    @Override
    public IHeapValues<IValue> empty() {
        return empty;
    }

    @NotNull
    @Override
    public IHeapValues<IValue> getField(@NotNull HeapValuesEnv env, @NotNull IFact.Builder<IValue> fact, 
                                      @NotNull IHeapValues<IValue> base, @NotNull JFieldType field) {
        if (env == null || fact == null || base == null || field == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        
        fact.assignNewExpr(env, "@base", base, false);
        fact.getField(env, "@res", "@base", field, true);
        
        IHeapValues value = fact.getTargetsUnsafe("@res");
        fact.kill("@res");
        fact.kill("@base");
        
        return value != null ? value : empty;
    }

    @NotNull
    @Override
    public IHeapValues<IValue> canStore(@NotNull IHeapValues<IValue> receivers, @NotNull Type receiverType) {
        if (receivers == null || receiverType == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        IHeapValues.Builder receiversValues = emptyBuilder();
        FastHierarchy hierarchy = Scene.v().getOrMakeFastHierarchy();

        for (CompanionV receiver : receivers) {
            IValue v = receiver.getValue();
            boolean canStore;

            if (v.typeIsConcrete()) {
                canStore = hierarchy.canStoreType(v.getType(), receiverType);
            } else if (!(receiverType instanceof RefLikeType)) {
                canStore = true;
            } else if (receiverType instanceof RefType && ((RefType)receiverType).getSootClass().isPhantom()) {
                canStore = true;
            } else {
                Type type = v.getType() instanceof RefType ? 
                    AnySubType.v((RefType)v.getType()) : v.getType();
                canStore = v.getType().equals(receiverType) || hierarchy.canStoreType(type, receiverType);
            }

            if (canStore) {
                receiversValues.add(receiver);
            }
        }

        return receiversValues.build();
    }

    @NotNull
    @Override
    public Sequence<Object> resolve(@NotNull HeapValuesEnv env,
                                    @NotNull ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> atCall,
                                    @NotNull IExpr iExpr) {
        if (env == null || atCall == null || iExpr == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return iExpr.accept(new IModelExpressionVisitor<Sequence<Object>>() {
            // Visitor implementation
        });
    }

    @NotNull
    @Override
    public IValue anyNewVal(@NotNull AnyNewExprEnv newExprEnv, @NotNull AnyNewExpr newExr) {
        if (newExprEnv == null || newExr == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return new AnyNewValue(newExprEnv.getNode(), newExprEnv.getMethod().getSignature(), newExr);
    }

    @NotNull
    @Override
    public IValue newSummaryVal(@NotNull HeapValuesEnv env, @NotNull Type type, @NotNull Object special) {
        if (env == null || type == null || special == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return SummaryValue.Companion.v(type, env.getNode(), special);
    }

    @NotNull
    @Override
    public IValue getNullConst() {
        return nullConst;
    }

    @NotNull
    @Override
    public ConstVal newConstVal(@NotNull Constant constant, @NotNull Type type) {
        if (constant == null || type == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return ConstVal.Companion.v(constant, type);
    }

    @NotNull
    @Override
    public HeapValuesEnv env(@NotNull Unit node) {
        if (node == null) throw new IllegalArgumentException("node cannot be null");
        return new HeapValuesEnvImpl(node);
    }

    @NotNull
    @Override
    public HookEnv env(@NotNull AIContext ctx, @NotNull Unit node) {
        if (ctx == null || node == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return new HookEnv(ctx, node);
    }

    @NotNull
    @Override
    public PathFactory<IValue> getPathFactory() {
        return new PathFactoryImpl();
    }

    @NotNull
    @Override
    public IOpCalculator<IValue> resolveOp(@NotNull HeapValuesEnv env, IHeapValues<IValue>... ops) {
        if (env == null || ops == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return new OpCalculator(env, this, Arrays.copyOf(ops, ops.length));
    }

    @NotNull
    @Override
    public IReNew<IValue> newReNewInterface(@NotNull Set<IValue> orig) {
        if (orig == null) throw new IllegalArgumentException("orig cannot be null");
        return new IReNew<IValue>() {
            // Implementation
        };
    }

    @Nullable
    @Override
    public Boolean getBooleanValue(@NotNull IValue v, boolean checkType) {
        if (v == null) throw new IllegalArgumentException("v cannot be null");
        return FactValuesKt.getBooleanValue(v, checkType);
    }

    @Nullable
    @Override
    public Integer getIntValue(@NotNull IValue v, boolean checkType) {
        if (v == null) throw new IllegalArgumentException("v cannot be null");
        return FactValuesKt.getIntValue(v, checkType);
    }

    @NotNull
    @Override
    public IHeapValues<IValue> single(@NotNull CompanionV<IValue> v) {
        if (v == null) throw new IllegalArgumentException("v cannot be null");
        return empty().plus(v);
    }

    @NotNull
    @Override
    public JOperatorV<IValue> push(@NotNull HeapValuesEnv env, @NotNull IValue alloc) {
        if (env == null || alloc == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return new OperatorPathFactory(this, env, alloc);
    }

    @NotNull
    @Override
    public JOperatorC<IValue> push(@NotNull HeapValuesEnv env, @NotNull CompanionV<IValue> value) {
        if (env == null || value == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return new JOperatorC<IValue>() {
            // Implementation
        };
    }

    @NotNull
    @Override
    public JOperatorHV<IValue> push(@NotNull HeapValuesEnv env, @NotNull IHeapValues<IValue> value) {
        if (env == null || value == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        return new JOperatorHVImpl(this, env, value);
    }

    private boolean checkTypeHierarchyIsPhantom(Type type) {
        if (type instanceof ArrayType) {
            return checkTypeHierarchyIsPhantom(((ArrayType)type).getElementType());
        }
        if (type instanceof RefType) {
            if (!((RefType)type).hasSootClass()) {
                return false;
            }
            return UtilsKt.findAncestors(((RefType)type).getSootClass())
                    .stream()
                    .anyMatch(SootClass::isPhantom);
        }
        return false;
    }

    @Nullable
    public IValue tryCastRef(@NotNull RefLikeType toType, @NotNull IValue it, @NotNull FastHierarchy h, boolean must) {
        if (toType == null || it == null || h == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        Type fromType = it.getType();
        if (fromType instanceof UnknownType) {
            return it;
        }

        boolean fromIsPhantom = checkTypeHierarchyIsPhantom(fromType);
        boolean toIsPhantom = checkTypeHierarchyIsPhantom(toType);
        boolean canStore = h.canStoreType(fromType, toType);

        if (it.typeIsConcrete() && (canStore || fromIsPhantom || toIsPhantom)) {
            return it;
        }

        if (!must && !it.typeIsConcrete()) {
            if (fromIsPhantom || toIsPhantom) {
                return it.copy(toType);
            }
            if (!canStore && h.canStoreType(toType, fromType)) {
                return it.copy(toType);
            }
            return canStore && h.canStoreType(toType, fromType) ? it : null;
        }

        return null;
    }

    // Other methods follow similar patterns of null checks and clean implementations
    // ...
}
