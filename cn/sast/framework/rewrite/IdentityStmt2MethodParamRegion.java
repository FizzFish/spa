package cn.sast.framework.rewrite;

import com.feysh.corax.cache.AnalysisCache;
import com.feysh.corax.cache.analysis.SootInfoCache;
import com.feysh.corax.cache.analysis.SootMethodExtend;
import com.feysh.corax.config.api.report.Region;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.CallableDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Body;
import soot.BodyTransformer;
import soot.PatchingChain;
import soot.SootMethod;
import soot.Unit;
import soot.UnitPatchingChain;
import soot.Value;
import soot.jimple.IdentityStmt;
import soot.jimple.ParameterRef;
import soot.jimple.ThisRef;
import soot.options.Options;
import soot.tagkit.Host;
import soot.tagkit.SourceLnPosTag;
import soot.tagkit.Tag;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class IdentityStmt2MethodParamRegion extends BodyTransformer {
    private static final Logger logger = LoggerFactory.getLogger(IdentityStmt2MethodParamRegion.class);
    public static final String phase = "jb.identityStmt2MethodParamRegion";

    @NotNull
    private final SootInfoCache info;

    public IdentityStmt2MethodParamRegion(@NotNull SootInfoCache info) {
        if (info == null) {
            throw new IllegalArgumentException("info cannot be null");
        }
        this.info = info;
    }

    @NotNull
    public SootInfoCache getInfo() {
        return info;
    }

    @Override
    protected void internalTransform(@NotNull Body b, @NotNull String phaseName, @NotNull Map<String, String> options) {
        if (b == null || phaseName == null || options == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        if (Options.v().verbose()) {
            logger.debug("[{}] Rewrite IdentityStmt region ...", b.getMethod().getName());
        }

        UnitPatchingChain units = b.getUnits();
        if (units.isEmpty()) {
            return;
        }

        SootMethod method = b.getMethod();
        if (method.isStatic() && method.getParameterCount() == 0) {
            return;
        }

        SootMethodExtend sootMethodExtend = (SootMethodExtend) AnalysisCache.G.INSTANCE.sootHost2decl(method);
        if (sootMethodExtend == null) {
            return;
        }

        CallableDeclaration<?> decl = sootMethodExtend.getDecl();
        if (decl == null) {
            return;
        }

        for (Unit unit : units) {
            if (!(unit instanceof IdentityStmt)) {
                continue;
            }

            Value rop = ((IdentityStmt) unit).getRightOp();
            if (rop instanceof ThisRef) {
                if (sootMethodExtend.getNameDecl() != null) {
                    Region region = Region.invoke(sootMethodExtend.getNameDecl());
                    addTag(unit, region);
                }
            } else if (rop instanceof ParameterRef) {
                NodeList<Parameter> parameters = decl.getParameters();
                Parameter parameter = parameters.size() > ((ParameterRef) rop).getIndex() 
                    ? parameters.get(((ParameterRef) rop).getIndex()) 
                    : null;
                
                if (parameter != null) {
                    Region region = Region.invoke(parameter);
                    if (region != null && region.startLine >= 0) {
                        addTag(unit, region);
                    }
                }
            }
        }
    }

    private void addTag(Host host, Region region) {
        if (region == null || region.startLine < 0) {
            return;
        }

        if (Options.v().keep_line_number()) {
            host.removeTag("SourceLnPosTag");
            host.addTag(new SourceLnPosTag(
                region.startLine, 
                region.getEndLine(), 
                region.startColumn, 
                region.getEndColumn()
            ));
        }
    }
}