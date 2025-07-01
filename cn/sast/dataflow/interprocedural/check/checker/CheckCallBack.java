package cn.sast.dataflow.interprocedural.check.checker;

import cn.sast.api.report.ClassResInfo;
import cn.sast.dataflow.interprocedural.analysis.AbstractHeapFactory;
import cn.sast.dataflow.interprocedural.analysis.CallStackContext;
import cn.sast.dataflow.interprocedural.analysis.CompanionV;
import cn.sast.dataflow.interprocedural.analysis.ConstVal;
import cn.sast.dataflow.interprocedural.analysis.FactValuesKt;
import cn.sast.dataflow.interprocedural.analysis.HeapValuesEnv;
import cn.sast.dataflow.interprocedural.analysis.HookEnv;
import cn.sast.dataflow.interprocedural.analysis.IFact;
import cn.sast.dataflow.interprocedural.analysis.IHeapValues;
import cn.sast.dataflow.interprocedural.analysis.IValue;
import cn.sast.dataflow.interprocedural.check.IPath;
import cn.sast.dataflow.interprocedural.check.PathCompanionV;
import cn.sast.dataflow.interprocedural.check.UnknownPath;
import cn.sast.dataflow.interprocedural.check.checker.CheckerModeling;
import cn.sast.dataflow.interprocedural.check.checker.ProgramStateContext;
import cn.sast.idfa.analysis.InterproceduralCFG;
import cn.sast.idfa.check.ICallCB;
import com.feysh.corax.config.api.IExpr;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.SootMethod;
import soot.Unit;

import java.util.List;

public final class CheckCallBack {
    private static final Logger logger = LoggerFactory.getLogger(CheckCallBack.class);
    
    @NotNull private final SootMethod atMethod;
    @NotNull private final CheckerModeling.Checker define;

    public CheckCallBack(@NotNull SootMethod atMethod, @NotNull CheckerModeling.Checker define) {
        if (atMethod == null) throw new IllegalArgumentException("atMethod cannot be null");
        if (define == null) throw new IllegalArgumentException("define cannot be null");
        this.atMethod = atMethod;
        this.define = define;
    }

    @NotNull
    public SootMethod getAtMethod() {
        return atMethod;
    }

    @Override
    @NotNull
    public String toString() {
        return "check " + atMethod + ":  " + define.getGuard();
    }

    @Nullable
    public Object check(
            @NotNull AbstractHeapFactory<IValue> hf,
            @NotNull HookEnv env,
            @NotNull ICallCB<IHeapValues<IValue>, IFact.Builder<IValue>> summaryCtxCalleeSite,
            @NotNull InterproceduralCFG icfg,
            @NotNull Object $completion) {
        
        CallStackContext callStack = summaryCtxCalleeSite.getOut().getCallStack();
        IFact.Builder<IValue> fact = summaryCtxCalleeSite.getOut();
        List<?> booleans = hf.resolve(env, summaryCtxCalleeSite, define.getGuard().getExpr());

        for (Object isBug : booleans) {
            if (!(isBug instanceof CompanionV)) continue;
            
            CompanionV c = (CompanionV) isBug;
            IPath paths = (c instanceof PathCompanionV) ? ((PathCompanionV) c).getPath() : UnknownPath.v(env);
            
            Object bool = c.getValue();
            if (!(bool instanceof ConstVal) || !FactValuesKt.getBooleanValue((IValue) bool)) continue;

            logger.debug("found a bug at: method: {}. define = {}", atMethod, define);
            
            SootMethod container = icfg.getMethodOf(env.getNode());
            Region region = Region.of(env.getNode());
            if (region == null) {
                region = Region.ERROR();
            }
            
            Region.Mutable mutable = region.getMutable();
            ClassResInfo classResInfo = ClassResInfo.of(container);
            ProgramStateContext ctx = new ProgramStateContext(
                mutable, 
                env.getNode(), 
                atMethod, 
                define.getGuard().getExpr()
            );
            
            define.getEnv().invoke(mutable);
            env.getCtx().report(paths, ctx, define);
        }
        return null;
    }
}