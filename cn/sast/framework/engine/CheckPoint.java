import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import com.feysh.corax.config.api.ICheckPoint;
import com.feysh.corax.config.api.INodeWithRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Local;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.jimple.Constant;
import soot.jimple.StringConstant;
import java.util.Collections;
import java.util.Set;

public abstract class CheckPoint implements ICheckPoint {

    public boolean hasSideEffect(@NotNull SootMethod method) {
        return true;
    }

    @Nullable
    public Boolean isInstanceOf(@NotNull SootClass sootClass, @NotNull String parent) {
        SootClass parentClass = Scene.v().getSootClassUnsafe(parent, false);
        if (parentClass == null) {
            return null;
        }
        return isInstanceOf(sootClass, parentClass);
    }

    public boolean isInstanceOf(@NotNull SootClass sootClass, @NotNull SootClass parent) {
        return Scene.v().getOrMakeFastHierarchy().canStoreType(sootClass.getType(), parent.getType());
    }

    @NotNull
    public abstract IBugResInfo getFile();

    @NotNull
    public abstract DefaultEnv getEnv$corax_framework();

    @NotNull
    public Set<Type> getPossibleTypes(@NotNull Value value) {
        if (value instanceof Constant) {
            return Set.of(((Constant) value).getType());
        }
        if (!(value instanceof Local)) {
            return Collections.emptySet();
        }
        if (!Scene.v().hasPointsToAnalysis()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Set<Type> types = Scene.v().getPointsToAnalysis().reachingObjects((Local) value).possibleTypes();
        return types != null ? types : Collections.emptySet();
    }

    @NotNull
    public Set<String> getPossibleConstantValues(@NotNull Value value) {
        if (value instanceof StringConstant) {
            return Set.of(((StringConstant) value).value);
        }
        if (!(value instanceof Local)) {
            return Collections.emptySet();
        }
        if (!Scene.v().hasPointsToAnalysis()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Set<String> constants = Scene.v().getPointsToAnalysis().reachingObjects((Local) value).possibleStringConstants();
        return constants != null ? constants : Collections.emptySet();
    }

    @NotNull
    public String toString() {
        String className = this.getClass().getSimpleName();
        IBugResInfo file = getFile();
        String region = "";
        if (this instanceof INodeWithRange) {
            INodeWithRange node = (INodeWithRange) this;
            if (node.getRegion() != null) {
                region = node.getRegion().toString();
            }
        }
        return className + " at " + file + ":" + region;
    }
}