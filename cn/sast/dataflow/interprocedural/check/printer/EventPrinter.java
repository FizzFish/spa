package cn.sast.dataflow.interprocedural.check.printer;

import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.interprocedural.analysis.EntryParam;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.analysis.PhantomField;
import cn.sast.dataflow.interprocedural.check.*;
import cn.sast.dataflow.interprocedural.check.printer.EventPrinterKt;
import cn.sast.dataflow.interprocedural.check.printer.SimpleUnitPrinter;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.TaintProperty;
import com.feysh.corax.config.api.baseimpl.IexConst;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.*;
import soot.jimple.*;
import soot.tagkit.ParamNamesTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class EventPrinter {
    @NotNull
    private final String prefix;
    @NotNull
    private StringBuffer outputEn;
    @NotNull
    private StringBuffer outputZh;
    @Nullable
    private Region region;

    public EventPrinter(@NotNull String prefix) {
        this.prefix = prefix;
        this.outputEn = new StringBuffer();
        this.outputZh = new StringBuffer();
    }

    @Nullable
    public Region getRegion() {
        return region;
    }

    public void setRegion(@Nullable Region region) {
        this.region = region;
    }

    public void plusAssign(@NotNull StringBuffer buffer, @NotNull String string) {
        buffer.append(string);
    }

    public void defaultPrint(@NotNull IPath pathNode, @NotNull Unit unit) {
        String keyPath = SimpleUnitPrinter.getStringOf(unit);
        plusAssign(outputEn, "key path: " + keyPath);
        plusAssign(outputZh, "关键路径: " + keyPath);
    }

    private void printModelingBinding(ModelBind v, Unit unit, SootMethod sootMethod) {
        if (v.getMt() instanceof TaintProperty) {
            IValue iValue = v.getObj();
            if (iValue instanceof EntryParam || iValue instanceof PhantomField) {
                plusAssign(outputZh, "污点源 Source 点: ");
                plusAssign(outputEn, "Taint source: ");
                if (iValue instanceof EntryParam && printParameterNameByIndex(((EntryParam) iValue).getMethod(), ((EntryParam) iValue).getParamIndex())) {
                    return;
                }
            } else {
                plusAssign(outputZh, "污点传递");
                plusAssign(outputEn, "Taint propagate");
            }

            String call = SimpleUnitPrinter.getStringOf(unit);
            boolean hasMessage = false;
            if (!(unit instanceof IdentityStmt)) {
                write(": " + call);
                hasMessage = true;
            }

            List<String> params = v.getInfo() != null ? v.getInfo().getParameterNamesInUnitDefUse(unit) : null;
            if (params != null && !params.isEmpty()) {
                String paramsStr = String.join(", ", params);
                plusAssign(outputZh, ", 关键位置: `" + paramsStr + "`");
                plusAssign(outputEn, ", key scope: `" + paramsStr + "`");
                
                if (v.getInfo() instanceof PrevCallStmtInfo) {
                    Integer paramIndex = ((PrevCallStmtInfo) v.getInfo()).getFirstParamIndex();
                    if (paramIndex != null) {
                        region = Region.getParamRegion(sootMethod, paramIndex);
                    }
                }
                hasMessage = true;
            }
            
            if (hasMessage) {
                return;
            }
            clean();
        }
        defaultPrint(v, unit);
    }

    @NotNull
    public EventPrinter printModeling(@NotNull ModelBind pathEvent, @NotNull Unit unit, @NotNull SootMethod sootMethod) {
        printModelingBinding(pathEvent, unit, sootMethod);
        return this;
    }

    @NotNull
    public EventPrinter normalPrint(@NotNull ExitInvoke node) {
        SootMethod sootMethod = node.getInvoke().getCallee();
        Unit unit = node.getInvoke().getNode();
        Value leftOp = unit instanceof DefinitionStmt ? ((DefinitionStmt) unit).getLeftOp() : null;
        InvokeExpr invokeExpr = unit instanceof Stmt && ((Stmt) unit).containsInvokeExpr() ? ((Stmt) unit).getInvokeExpr() : null;
        
        String call = SimpleUnitPrinter.getStringOf(sootMethod, leftOp, invokeExpr, false);
        plusAssign(outputZh, "离开被调用方法: `" + call + "`");
        plusAssign(outputEn, "return from calling: `" + call + "`");
        return this;
    }

    public void write(@NotNull String s) {
        plusAssign(outputZh, s);
        plusAssign(outputEn, s);
    }

    private void clean() {
        outputZh = new StringBuffer();
        outputEn = new StringBuffer();
    }

    @NotNull
    public EventPrinter calleeBeginPrint(@NotNull InvokeEdgePath invoke) {
        SootMethod container = invoke.getContainer();
        String call = container.getDeclaringClass().getName() + "#" + container.getName();
        plusAssign(outputZh, "从 `" + call + "` 进入调用");
        plusAssign(outputEn, "calling from: `" + call + "`");
        return this;
    }

    @NotNull
    public EventPrinter normalPrint(@NotNull IndexedValue<? extends IPath> nodeI, @NotNull Unit unit, @NotNull SootMethod sootMethod) {
        IPath node = nodeI.getValue();
        if (node instanceof InvokeEdgePath) {
            SootMethod callee = ((InvokeEdgePath) node).getCallee();
            InvokeExpr invokeExpr = unit instanceof Stmt && ((Stmt) unit).containsInvokeExpr() ? ((Stmt) unit).getInvokeExpr() : null;
            String call = SimpleUnitPrinter.getStringOf(callee, null, invokeExpr, false);
            plusAssign(outputZh, "进入被调用方法: `" + call + "`");
            plusAssign(outputEn, "calling: `" + call + "`");
        } else if (!(node instanceof MergePath)) {
            if (node instanceof AssignLocalPath) {
                defaultPrint(node, unit);
            } else if (node instanceof ModelBind) {
                printModelingBinding((ModelBind) node, unit, sootMethod);
            } else if (node instanceof LiteralPath) {
                Object constant = ((LiteralPath) node).getConst();
                if (constant instanceof IexConst) {
                    IexConst iexConst = (IexConst) constant;
                    switch (iexConst.getType()) {
                        case SOURCE:
                            InvokeExpr expr = unit instanceof Stmt && ((Stmt) unit).containsInvokeExpr() ? ((Stmt) unit).getInvokeExpr() : null;
                            if (expr != null && nodeI.getIndex() == 0) {
                                plusAssign(outputZh, "污点源 Source 点: ");
                                plusAssign(outputEn, "Taint source: ");
                                write(SimpleUnitPrinter.getStringOf(null, null, expr, false));
                            }
                            break;
                        case SINK:
                            clean();
                            break;
                        default:
                            plusAssign(outputZh, iexConst.getType() + " 类型的常量: ");
                            plusAssign(outputEn, iexConst.getType() + " type constant: ");
                            write("`" + iexConst.getConst() + "`");
                    }
                } else if (constant instanceof Constant) {
                    Type type = ((Constant) constant).getType();
                    String typeName = EventPrinterKt.getPname(type);
                    plusAssign(outputZh, typeName + " 类型的常量: ");
                    plusAssign(outputEn, typeName + " type constant: ");
                    write(String.valueOf(constant));
                }
            } else if (node instanceof GetEdgePath || node instanceof SetEdgePath) {
                defaultPrint(node, unit);
            } else {
                defaultPrint(node, unit);
            }
        }
        return this;
    }

    @Nullable
    public Map<Language, String> getMessage() {
        if (outputEn.length() == 0) {
            return null;
        }
        return Map.of(
            Language.EN, prefix + " " + outputEn,
            Language.ZH, prefix + " " + outputZh
        );
    }

    private boolean printParameterNameByIndex(SootMethod sootMethod, int index) {
        if (index == -1) {
            String className = sootMethod.getDeclaringClass().getName();
            plusAssign(outputZh, className + "类型的参数: this");
            plusAssign(outputEn, className + " type parameter: this");
            region = Region.getParamRegion(sootMethod, index);
            return true;
        } else if (index >= 0 && index < sootMethod.getParameterCount()) {
            ParamNamesTag tag = sootMethod.getTags().stream()
                .filter(ParamNamesTag.class::isInstance)
                .map(ParamNamesTag.class::cast)
                .findFirst()
                .orElse(null);
            
            List<String> names = tag != null ? tag.getNames() : List.of();
            Type paramType = sootMethod.getParameterType(index);
            String name = names.size() > index ? names.get(index) : null;
            
            if (name == null) {
                try {
                    Body body = SootUtilsKt.getActiveBodyOrNull(sootMethod);
                    Local local = body != null ? body.getParameterLocal(index) : null;
                    name = local != null ? "local var " + local : "";
                } catch (RuntimeException ignore) {
                    name = "";
                }
            }
            
            plusAssign(outputZh, paramType + "类型的第" + (index + 1) + "个参数" + name);
            plusAssign(outputEn, paramType + " type parameter" + (index + 1) + name);
            region = Region.getParamRegion(sootMethod, index);
            return true;
        }
        return false;
    }
}
