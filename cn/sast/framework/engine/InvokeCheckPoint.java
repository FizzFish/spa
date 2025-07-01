import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import cn.sast.framework.engine.CheckPoint;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.IInvokeCheckPoint;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.tagkit.AbstractHost;
import java.util.Objects;
import java.util.function.Supplier;

public final class InvokeCheckPoint extends CheckPoint implements IInvokeCheckPoint {
    @NotNull
    private final SootInfoCache info;
    @NotNull
    private final SootMethod container;
    @Nullable
    private final Unit callSite;
    @Nullable
    private final Type declaredReceiverType;
    @Nullable
    private final SootMethodRef invokeMethodRef;
    @NotNull
    private final SootMethod callee;
    @Nullable
    private final InvokeExpr invokeExpr;
    private final Supplier<IBugResInfo> fileSupplier;
    private final Supplier<DefaultEnv> envSupplier;

    public InvokeCheckPoint(@NotNull SootInfoCache info, @NotNull SootMethod container, 
                          @Nullable Unit callSite, @Nullable Type declaredReceiverType, 
                          @Nullable SootMethodRef invokeMethodRef, @NotNull SootMethod callee, 
                          @Nullable InvokeExpr invokeExpr) {
        Objects.requireNonNull(info, "info");
        Objects.requireNonNull(container, "container");
        Objects.requireNonNull(callee, "callee");
        this.info = info;
        this.container = container;
        this.callSite = callSite;
        this.declaredReceiverType = declaredReceiverType;
        this.invokeMethodRef = invokeMethodRef;
        this.callee = callee;
        this.invokeExpr = invokeExpr;
        this.fileSupplier = this::createFileInfo;
        this.envSupplier = this::createEnv;
    }

    @NotNull
    public SootInfoCache getInfo() {
        return info;
    }

    @Override
    @NotNull
    public SootMethod getContainer() {
        return container;
    }

    @Override
    @Nullable
    public Unit getCallSite() {
        return callSite;
    }

    @Override
    @Nullable
    public Type getDeclaredReceiverType() {
        return declaredReceiverType;
    }

    @Override
    @Nullable
    public SootMethodRef getInvokeMethodRef() {
        return invokeMethodRef;
    }

    @Override
    @NotNull
    public SootMethod getCallee() {
        return callee;
    }

    @Override
    @Nullable
    public InvokeExpr getInvokeExpr() {
        return invokeExpr;
    }

    @Override
    @NotNull
    public String toString() {
        return container + ": at " + (callSite != null ? callSite.getJavaSourceStartLineNumber() : null) 
               + " : " + callSite + " -> " + invokeMethodRef + " -> " + callee;
    }

    @Override
    @NotNull
    public Region getRegion() {
        if (callSite != null) {
            Region region = Region.Companion.invoke(callSite);
            if (region != null) {
                return region;
            }
        }
        Region region = Region.Companion.invoke(info, container);
        return region != null ? region : Region.Companion.getERROR();
    }

    @Override
    @NotNull
    public IBugResInfo getFile() {
        return fileSupplier.get();
    }

    @NotNull
    public DefaultEnv getEnv$corax_framework() {
        return envSupplier.get();
    }

    private ClassResInfo createFileInfo() {
        SootClass sootClass = container.getDeclaringClass();
        return new ClassResInfo(sootClass);
    }

    private DefaultEnv createEnv() {
        return new DefaultEnv(getRegion().getMutable(), null, callSite, callee, 
                            container, invokeExpr, null, null, null, 450, null);
    }
}