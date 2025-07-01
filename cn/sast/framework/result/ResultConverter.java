package cn.sast.framework.result;

import cn.sast.api.report.BugPathEvent;
import cn.sast.api.report.ClassResInfo;
import cn.sast.api.report.DefaultEnv;
import cn.sast.api.report.IBugResInfo;
import cn.sast.api.report.Report;
import cn.sast.dataflow.infoflow.provider.BugTypeProvider;
import cn.sast.framework.engine.PreAnalysisReportEnv;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.report.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Scene;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.infoflow.data.AccessPath;
import soot.jimple.infoflow.data.AccessPathFragment;
import soot.jimple.infoflow.results.DataFlowResult;
import soot.jimple.infoflow.results.ResultSinkInfo;
import soot.jimple.infoflow.results.ResultSourceInfo;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinition;
import soot.jimple.infoflow.sourcesSinks.definitions.MethodSourceSinkDefinition;
import soot.tagkit.AbstractHost;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ResultConverter {
    private static final Logger logger = LoggerFactory.getLogger(ResultConverter.class);
    
    @Nullable
    private final SootInfoCache info;

    public ResultConverter(@Nullable SootInfoCache info) {
        this.info = info;
    }

    @Nullable
    public SootInfoCache getInfo() {
        return info;
    }

    private String writeAccessPath(AccessPath accessPath, boolean simple) {
        if (!simple) {
            return accessPath.toString();
        }
        
        StringBuilder b = new StringBuilder();
        if (accessPath.getPlainValue() != null) {
            b.append(accessPath.getPlainValue());
        }
        if (accessPath.getBaseType() != null) {
            b.append(accessPath.getBaseType());
        }
        if (accessPath.getFragmentCount() > 0) {
            for (int i = 0; i < accessPath.getFragmentCount(); i++) {
                AccessPathFragment fragment = accessPath.getFragments()[i];
                b.append(".").append(fragment.getField());
            }
        }
        b.append(accessPath.getTaintSubFields() ? "*" : "");
        return b.toString();
    }

    @NotNull
    public Report getReport(@NotNull CheckType checkType, @NotNull PreAnalysisReportEnv env) {
        return Report.of(
            info,
            env.getFile(),
            env.getEnv().getRegion().getImmutable(),
            checkType,
            env.getEnv(),
            null
        );
    }

    @NotNull
    public List<Report> getReport(
        @NotNull IInfoflowCFG icfg,
        @NotNull DataFlowResult result,
        @NotNull BugTypeProvider bugTypeProvider,
        boolean serializeTaintPath
    ) {
        ResultSinkInfo sink = result.getSink();
        Stmt stmt = sink.getStmt();
        SootMethod method = icfg.getMethodOf(stmt);
        ISourceSinkDefinition definition = sink.getDefinition();

        if (!(definition instanceof MethodSourceSinkDefinition)) {
            logger.warn("Definition: {} is not a MethodSourceSinkDefinition.", definition);
            return Collections.emptyList();
        }

        SootMethod sinkMethod = Scene.v().grabMethod(((MethodSourceSinkDefinition)definition).getMethod().getSignature());
        if (sinkMethod == null) {
            logger.warn("Soot can not find method: {}", definition);
            return Collections.emptyList();
        }

        List<BugPathEvent> events = new ArrayList<>();
        ResultSourceInfo source = result.getSource();
        if (serializeTaintPath && source.getPath() != null) {
            Stmt[] path = source.getPath();
            for (int i = 0; i < path.length; i++) {
                Stmt curStmt = path[i];
                SootMethod sm = icfg.getMethodOf(curStmt);
                AccessPath curAP = source.getPathAccessPaths()[i];
                String ap = writeAccessPath(curAP, false);
                
                Region region = Region.invoke(curStmt);
                if (region == null) {
                    if (info != null) {
                        region = Region.invoke(info, sm);
                    }
                    if (region == null) {
                        region = Region.ERROR();
                    }
                }

                Map<Language, String> message = Map.of(
                    Language.EN, "`" + ap + "` is tainted after `" + curStmt + "`"
                );
                events.add(new BugPathEvent(message, ClassResInfo.of(sm), region, null));
            }
        }

        Set<CheckType> checkTypes = bugTypeProvider.lookUpCheckType(sinkMethod);
        if (checkTypes.isEmpty()) {
            logger.warn("could not find any checkTypes from bugTypeProvider at sink method: {}", sinkMethod);
        }

        Region region = Region.invoke(stmt);
        if (region == null) {
            if (info != null) {
                region = Region.invoke(info, method);
            }
            if (region == null) {
                region = Region.ERROR();
            }
        }

        DefaultEnv env = new DefaultEnv(region.getMutable(), null, null, null, null, null, null, null, null);
        env.setCallSite(stmt);
        env.setClazz(method.getDeclaringClass());
        env.setContainer(method);
        env.setCallee(sinkMethod);
        env.setMethod(sinkMethod);
        if (stmt.containsInvokeExpr()) {
            env.setInvokeExpr(stmt.getInvokeExpr());
        }

        List<Report> reports = new ArrayList<>();
        for (CheckType type : checkTypes) {
            reports.add(Report.of(
                info,
                ClassResInfo.of(method),
                region,
                type,
                env,
                events
            ));
        }
        return reports;
    }
}
