package cn.sast.framework.engine;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.IUnitCheckPoint;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.Expr;
import soot.tagkit.Host;
import java.util.List;
import java.util.function.Consumer;

public final class UnitCheckPoint extends CheckPoint implements IUnitCheckPoint {
    @NotNull
    private final SootInfoCache info;
    @NotNull
    private final Unit unit;
    @NotNull
    private final SootMethod sootMethod;
    @NotNull
    private final IBugResInfo file;
    private final DefaultEnv env;

    public UnitCheckPoint(@NotNull SootInfoCache info, @NotNull Unit unit, @NotNull SootMethod sootMethod) {
        if (info == null) throw new IllegalArgumentException("info cannot be null");
        if (unit == null) throw new IllegalArgumentException("unit cannot be null");
        if (sootMethod == null) throw new IllegalArgumentException("sootMethod cannot be null");
        
        this.info = info;
        this.unit = unit;
        this.sootMethod = sootMethod;
        SootClass sootClass = sootMethod.getDeclaringClass();
        this.file = new ClassResInfo(sootClass);
        this.env = new DefaultEnv(
            getRegion().getMutable(), 
            null, 
            null, 
            null, 
            sootMethod, 
            null, 
            sootClass, 
            null, 
            sootMethod, 
            174, 
            null
        );
    }

    @NotNull
    public SootInfoCache getInfo() {
        return info;
    }

    @NotNull
    @Override
    public Unit getUnit() {
        return unit;
    }

    @NotNull
    public SootMethod getSootMethod() {
        return sootMethod;
    }

    @NotNull
    @Override
    public Region getRegion() {
        Region region = Region.Companion.invoke(info, getUnit());
        return region != null ? region : Region.Companion.getERROR();
    }

    @Override
    public void eachExpr(@NotNull Consumer<? super Expr> block) {
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        
        for (ValueBox box : unit.getUseAndDefBoxes()) {
            Value value = box.getValue();
            if (value instanceof Expr) {
                block.accept((Expr) value);
            }
        }
    }

    @NotNull
    @Override
    public IBugResInfo getFile() {
        return file;
    }

    @NotNull
    public DefaultEnv getEnv$corax_framework() {
        return env;
    }
}
