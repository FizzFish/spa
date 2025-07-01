import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import cn.sast.framework.engine.CheckPoint;
import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.AnalysisDataFactory;
import com.feysh.corax.cache.analysis.SootHostExtend;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.IFieldCheckPoint;
import com.feysh.corax.config.api.report.Region;
import com.github.javaparser.ast.body.BodyDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.tagkit.AbstractHost;
import soot.tagkit.Host;
import soot.tagkit.VisibilityAnnotationTag;

import java.util.Objects;
import java.util.function.Supplier;

public final class FieldCheckPoint extends CheckPoint implements IFieldCheckPoint, SootInfoCache {
    @NotNull
    private final SootField sootField;
    @NotNull
    private final SootInfoCache info;
    @NotNull
    private final IBugResInfo file;
    private final Supplier<DefaultEnv> envSupplier;

    public FieldCheckPoint(@NotNull SootField sootField, @NotNull SootInfoCache info) {
        Objects.requireNonNull(sootField, "sootField");
        Objects.requireNonNull(info, "info");
        this.sootField = sootField;
        this.info = info;
        SootClass sootClass = sootField.getDeclaringClass();
        this.file = new ClassResInfo(sootClass);
        this.envSupplier = () -> new DefaultEnv(
            getRegion().getMutable(), 
            null, 
            null, 
            null, 
            null, 
            null, 
            sootField.getDeclaringClass(), 
            sootField, 
            null, 
            318, 
            null
        );
    }

    @NotNull
    public SootField getSootField() {
        return sootField;
    }

    @NotNull
    public SootInfoCache getInfo() {
        return info;
    }

    @Nullable
    public VisibilityAnnotationTag getVisibilityAnnotationTag() {
        return (VisibilityAnnotationTag) sootField.getTag("VisibilityAnnotationTag");
    }

    @NotNull
    public Region getRegion() {
        Region region = Region.Companion.invoke(info, sootField);
        return region != null ? region : Region.Companion.getERROR();
    }

    @NotNull
    public IBugResInfo getFile() {
        return file;
    }

    @NotNull
    public DefaultEnv getEnv$corax_framework() {
        return envSupplier.get();
    }

    @Nullable
    public BodyDeclaration<?> getMemberAtLine(@NotNull SootClass sootClass, int ln) {
        Objects.requireNonNull(sootClass, "sootClass");
        return info.getMemberAtLine(sootClass, ln);
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
        Objects.requireNonNull(host, "host");
        return info.getExt(host);
    }

    public int getJavaNameSourceStartLineNumber(@NotNull AbstractHost host) {
        Objects.requireNonNull(host, "host");
        return info.getJavaNameSourceStartLineNumber(host);
    }

    public int getJavaNameSourceStartColumnNumber(@NotNull AbstractHost host) {
        Objects.requireNonNull(host, "host");
        return info.getJavaNameSourceStartColumnNumber(host);
    }

    public int getJavaNameSourceEndLineNumber(@NotNull AbstractHost host) {
        Objects.requireNonNull(host, "host");
        return info.getJavaNameSourceEndLineNumber(host);
    }

    public int getJavaNameSourceEndColumnNumber(@NotNull AbstractHost host) {
        Objects.requireNonNull(host, "host");
        return info.getJavaNameSourceEndColumnNumber(host);
    }
}