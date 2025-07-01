package cn.sast.framework.engine;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.IMethodCheckPoint;
import com.feysh.corax.config.api.IUnitCheckPoint;
import com.feysh.corax.config.api.report.Region;
import com.github.javaparser.ast.body.BodyDeclaration;
import java.util.Iterator;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Body;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;
import soot.tagkit.VisibilityAnnotationTag;

public final class MethodCheckPoint extends CheckPoint implements IMethodCheckPoint, SootInfoCache {
    @NotNull
    private final SootMethod sootMethod;
    @NotNull
    private final SootInfoCache info;
    @NotNull
    private final IBugResInfo file;
    @NotNull
    private final DefaultEnv env;

    public MethodCheckPoint(@NotNull SootMethod sootMethod, @NotNull SootInfoCache info) {
        if (sootMethod == null) throw new IllegalArgumentException("sootMethod cannot be null");
        if (info == null) throw new IllegalArgumentException("info cannot be null");
        this.sootMethod = sootMethod;
        this.info = info;
        SootClass sootClass = this.sootMethod.getDeclaringClass();
        this.file = new ClassResInfo(sootClass);
        this.env = new DefaultEnv(this.getRegion().getMutable(), null, null, null, 
            this.sootMethod, null, this.sootMethod.getDeclaringClass(), null, this.sootMethod, 174, null);
    }

    @NotNull
    public SootMethod getSootMethod() {
        return sootMethod;
    }

    @NotNull
    public SootInfoCache getInfo() {
        return info;
    }

    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag() {
        return (VisibilityAnnotationTag) sootMethod.getTag("VisibilityAnnotationTag");
    }

    public void eachUnit(@NotNull Consumer<? super IUnitCheckPoint> block) {
        if (block == null) throw new IllegalArgumentException("block cannot be null");
        if (!sootMethod.hasActiveBody()) {
            return;
        }
        Body body = sootMethod.getActiveBody();
        for (Unit unit : body.getUnits()) {
            block.accept(new UnitCheckPoint(info, unit, sootMethod));
        }
    }

    @NotNull
    public Region getRegion() {
        Region region = Region.Companion.invoke(this, sootMethod);
        return region != null ? region : Region.Companion.getERROR();
    }

    @NotNull
    public IBugResInfo getFile() {
        return file;
    }

    @NotNull
    public DefaultEnv getEnv$corax_framework() {
        return env;
    }

    @Nullable
    public BodyDeclaration<?> getMemberAtLine(@NotNull SootClass clazz, int ln) {
        if (clazz == null) throw new IllegalArgumentException("clazz cannot be null");
        return info.getMemberAtLine(clazz, ln);
    }

    @NotNull
    public AnalysisCache getCache() {
        return info.getCache();
    }

    @NotNull
    public AnalysisDataFactory.Key<SootHostExtend> getHostKey() {
        return info.getHostKey();
    }

    @Nullable
    public SootHostExtend getExt(@NotNull Host host) {
        if (host == null) throw new IllegalArgumentException("host cannot be null");
        return info.getExt(host);
    }

    public int getJavaNameSourceStartLineNumber(@NotNull AbstractHost host) {
        if (host == null) throw new IllegalArgumentException("host cannot be null");
        return info.getJavaNameSourceStartLineNumber(host);
    }

    public int getJavaNameSourceStartColumnNumber(@NotNull AbstractHost host) {
        if (host == null) throw new IllegalArgumentException("host cannot be null");
        return info.getJavaNameSourceStartColumnNumber(host);
    }

    public int getJavaNameSourceEndLineNumber(@NotNull AbstractHost host) {
        if (host == null) throw new IllegalArgumentException("host cannot be null");
        return info.getJavaNameSourceEndLineNumber(host);
    }

    public int getJavaNameSourceEndColumnNumber(@NotNull AbstractHost host) {
        if (host == null) throw new IllegalArgumentException("host cannot be null");
        return info.getJavaNameSourceEndColumnNumber(host);
    }
}
