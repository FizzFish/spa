package cn.sast.framework.engine;

import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.IClassCheckPoint;
import com.feysh.corax.config.api.IFieldCheckPoint;
import com.feysh.corax.config.api.IMethodCheckPoint;
import com.feysh.corax.config.api.report.Region;
import com.github.javaparser.ast.body.BodyDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;

import java.util.Iterator;
import java.util.function.Consumer;

public final class ClassCheckPoint extends CheckPoint implements IClassCheckPoint, SootInfoCache {
    @NotNull
    private final SootClass sootClass;
    @NotNull
    private final SootInfoCache info;
    @NotNull
    private final IBugResInfo file;
    private final DefaultEnv env;

    public ClassCheckPoint(@NotNull SootClass sootClass, @NotNull SootInfoCache info) {
        if (sootClass == null) throw new NullPointerException("sootClass");
        if (info == null) throw new NullPointerException("info");
        this.sootClass = sootClass;
        this.info = info;
        this.file = new ClassResInfo(this.getSootClass());
        this.env = new DefaultEnv(this.getRegion().getMutable(), null, null, null, null, null, 
            this.getSootClass(), null, null, 446, null);
    }

    @NotNull
    public SootClass getSootClass() {
        return sootClass;
    }

    @NotNull
    public SootInfoCache getInfo() {
        return info;
    }

    @NotNull
    public String getClassName() {
        return sootClass.getName();
    }

    public void eachMethod(@NotNull Consumer<? super IMethodCheckPoint> block) {
        if (block == null) throw new NullPointerException("block");
        for (SootMethod method : sootClass.getMethods()) {
            block.accept(new MethodCheckPoint(method, info));
        }
    }

    public void eachField(@NotNull Consumer<? super IFieldCheckPoint> block) {
        if (block == null) throw new NullPointerException("block");
        for (SootField field : sootClass.getFields()) {
            block.accept(new FieldCheckPoint(field, info));
        }
    }

    @NotNull
    public Region getRegion() {
        Region region = Region.Companion.invoke(this, sootClass);
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
    public BodyDeclaration<?> getMemberAtLine(@NotNull SootClass host, int ln) {
        if (host == null) throw new NullPointerException("host");
        return info.getMemberAtLine(host, ln);
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
        if (host == null) throw new NullPointerException("host");
        return info.getExt(host);
    }

    public int getJavaNameSourceStartLineNumber(@NotNull AbstractHost host) {
        if (host == null) throw new NullPointerException("host");
        return info.getJavaNameSourceStartLineNumber(host);
    }

    public int getJavaNameSourceStartColumnNumber(@NotNull AbstractHost host) {
        if (host == null) throw new NullPointerException("host");
        return info.getJavaNameSourceStartColumnNumber(host);
    }

    public int getJavaNameSourceEndLineNumber(@NotNull AbstractHost host) {
        if (host == null) throw new NullPointerException("host");
        return info.getJavaNameSourceEndLineNumber(host);
    }

    public int getJavaNameSourceEndColumnNumber(@NotNull AbstractHost host) {
        if (host == null) throw new NullPointerException("host");
        return info.getJavaNameSourceEndColumnNumber(host);
    }
}
