package cn.sast.api.report;

import com.feysh.corax.config.api.report.Region;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.InvokeExpr;

public class DefaultEnv extends AbstractBugEnv {
    @NotNull
    private Region.Mutable region;
    @Nullable
    private String fileName;
    @Nullable
    private Unit callSite;
    @Nullable
    private SootMethod callee;
    @Nullable
    private SootMethod container;
    @Nullable
    private InvokeExpr invokeExpr;
    @Nullable
    private SootClass clazz;
    @Nullable
    private SootField field;
    @Nullable
    private SootMethod method;
    @NotNull
    private final Map<Object, Object> args = new LinkedHashMap<>();

    public DefaultEnv(@NotNull Region.Mutable region, @Nullable String fileName, @Nullable Unit callSite, 
                     @Nullable SootMethod callee, @Nullable SootMethod container, @Nullable InvokeExpr invokeExpr,
                     @Nullable SootClass clazz, @Nullable SootField field, @Nullable SootMethod method) {
        if (region == null) {
            throw new IllegalArgumentException("region cannot be null");
        }
        this.region = region;
        this.fileName = fileName;
        this.callSite = callSite;
        this.callee = callee;
        this.container = container;
        this.invokeExpr = invokeExpr;
        this.clazz = clazz;
        this.field = field;
        this.method = method;
    }

    @NotNull
    public Region.Mutable getRegion() {
        return region;
    }

    public void setRegion(@NotNull Region.Mutable region) {
        if (region == null) {
            throw new IllegalArgumentException("region cannot be null");
        }
        this.region = region;
    }

    @Nullable
    public String getFileName() {
        return fileName;
    }

    public void setFileName(@Nullable String fileName) {
        this.fileName = fileName;
    }

    @Nullable
    public Unit getCallSite() {
        return callSite;
    }

    public void setCallSite(@Nullable Unit callSite) {
        this.callSite = callSite;
    }

    @Nullable
    public SootMethod getCallee() {
        return callee;
    }

    public void setCallee(@Nullable SootMethod callee) {
        this.callee = callee;
    }

    @Nullable
    public SootMethod getContainer() {
        return container;
    }

    public void setContainer(@Nullable SootMethod container) {
        this.container = container;
    }

    @Nullable
    public InvokeExpr getInvokeExpr() {
        return invokeExpr;
    }

    public void setInvokeExpr(@Nullable InvokeExpr invokeExpr) {
        this.invokeExpr = invokeExpr;
    }

    @Nullable
    public SootClass getClazz() {
        return clazz;
    }

    public void setClazz(@Nullable SootClass clazz) {
        this.clazz = clazz;
    }

    @Nullable
    public SootField getField() {
        return field;
    }

    public void setField(@Nullable SootField field) {
        this.field = field;
    }

    @Nullable
    public SootMethod getMethod() {
        return method;
    }

    public void setMethod(@Nullable SootMethod method) {
        this.method = method;
    }

    @NotNull
    public Map<Object, Object> getArgs() {
        return args;
    }
}