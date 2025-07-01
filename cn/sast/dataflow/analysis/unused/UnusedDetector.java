package cn.sast.dataflow.analysis.unused;

import cn.sast.api.config.BuiltinAnalysisConfig;
import cn.sast.api.config.MainConfig;
import cn.sast.api.util.OthersKt;
import cn.sast.api.util.SootUtilsKt;
import cn.sast.dataflow.analysis.IBugReporter;
import cn.sast.dataflow.infoflow.provider.MethodSummaryProviderKt;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.utils.UtilsKt;
import com.feysh.corax.config.builtin.checkers.DefineUnusedChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.*;
import soot.jimple.FieldRef;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.tagkit.AbstractHost;
import soot.tagkit.VisibilityAnnotationTag;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class UnusedDetector {
    private static final Logger logger = LoggerFactory.getLogger(UnusedDetector.class);
    
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final BuiltinAnalysisConfig builtinAnalysisConfig;
    @NotNull
    private final CallGraph cg;
    @NotNull
    private final IBugReporter reporter;
    @NotNull
    private final Set<SootMethod> calleeAndSuperMethods;
    @NotNull
    private final Set<SootMethod> allBlackMethods;
    @NotNull
    private final List<Pattern> blackMethodPatterns;
    private final boolean enableUnusedMethod;
    private final boolean enableUrfUnreadField;

    public UnusedDetector(@NotNull MainConfig mainConfig, 
                         @NotNull BuiltinAnalysisConfig builtinAnalysisConfig,
                         @NotNull CallGraph cg, 
                         @NotNull IBugReporter reporter) {
        this.mainConfig = Objects.requireNonNull(mainConfig, "mainConfig");
        this.builtinAnalysisConfig = Objects.requireNonNull(builtinAnalysisConfig, "builtinAnalysisConfig");
        this.cg = Objects.requireNonNull(cg, "cg");
        this.reporter = Objects.requireNonNull(reporter, "reporter");
        
        this.calleeAndSuperMethods = Collections.unmodifiableSet(initCalleeAndSuperMethods());
        this.allBlackMethods = Collections.unmodifiableSet(initAllBlackMethods());
        this.blackMethodPatterns = builtinAnalysisConfig.getUnusedDetectorSootSigPatternBlackList()
                .stream()
                .map(Pattern::compile)
                .collect(Collectors.toList());
        
        this.enableUnusedMethod = mainConfig.isEnable(DefineUnusedChecker.UnusedMethod.INSTANCE);
        this.enableUrfUnreadField = mainConfig.isEnable(DefineUnusedChecker.UrfUnreadField.INSTANCE);
    }

    @NotNull
    public MainConfig getMainConfig() {
        return mainConfig;
    }

    private boolean isAnnotated(AbstractHost abstractHost) {
        return abstractHost.getTag("VisibilityAnnotationTag") != null;
    }

    private Set<SootField> findUnusedField(SootClass appClass) {
        Set<SootField> unused = appClass.getFields().stream()
                .filter(field -> field.isPrivate() && !field.isFinal() && !isAnnotated(field))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (SootMethod method : appClass.getMethods()) {
            if (!method.hasActiveBody()) {
                return Collections.emptySet();
            }

            for (Unit unit : method.getActiveBody().getUnits()) {
                for (ValueBox useBox : unit.getUseBoxes()) {
                    Value value = useBox.getValue();
                    if (value instanceof FieldRef) {
                        unused.remove(((FieldRef) value).getField());
                    }
                }
            }
        }
        return unused;
    }

    private Set<SootMethod> initCalleeAndSuperMethods() {
        Set<SootMethod> methods = new LinkedHashSet<>();
        
        // Collect all target methods from call graph
        for (Edge edge : cg) {
            if (edge.tgt() != null) {
                methods.add(edge.tgt());
            }
        }

        // Find all super methods
        Set<SootMethod> superMethods = new LinkedHashSet<>();
        for (SootMethod method : methods) {
            SootClass declaringClass = method.getDeclaringClass();
            SootUtilsKt.findMethodOrNull(declaringClass, method.getSubSignature().toString(), 
                it -> !it.equals(method) && !it.isConstructor() && !it.isPrivate())
                .forEach(superMethods::add);
        }
        
        methods.addAll(superMethods);
        return methods;
    }

    private Set<SootMethod> initAllBlackMethods() {
        Scene scene = Scene.v();
        Set<SootMethod> allBlackMethods = new LinkedHashSet<>();
        
        for (String blackMethodSig : builtinAnalysisConfig.getUnusedDetectorMethodSigBlackList()) {
            IMethodMatch match = OthersKt.methodSignatureToMatcher(blackMethodSig);
            if (match == null) {
                throw new IllegalStateException("`" + blackMethodSig + "` is not a valid method signature");
            }
            
            for (SootMethod mBlack : match.matched(scene)) {
                allBlackMethods.add(mBlack);
                allBlackMethods.addAll(MethodSummaryProviderKt.findAllOverrideMethodsOfMethod(mBlack));
            }
        }
        return allBlackMethods;
    }

    private boolean isSkipped(SootMethod method) {
        String sig = method.getSignature();
        if (allBlackMethods.contains(method)) {
            return true;
        }
        return blackMethodPatterns.stream().anyMatch(p -> p.matcher(sig).matches());
    }

    private boolean isSkipped(SootField field) {
        String sig = field.getSignature();
        return blackMethodPatterns.stream().anyMatch(p -> p.matcher(sig).matches());
    }

    private boolean isUnused(SootMethod sootMethod) {
        if (sootMethod.isStaticInitializer() || isAnnotated(sootMethod)) {
            return false;
        }

        if (sootMethod.isConstructor()) {
            if ("void <init>()".equals(sootMethod.getSubSignature())) {
                return false;
            }
            if (sootMethod.getParameterCount() == 1) {
                String className = sootMethod.getDeclaringClass().getName();
                Type paramType = sootMethod.getParameterType(0);
                String paramTypeName = UtilsKt.getTypename(paramType);
                String shortName = sootMethod.getDeclaringClass().getShortJavaStyleName();
                String lastPart = shortName.substring(shortName.lastIndexOf('$') + 1);
                if (className.equals(paramTypeName + "$" + lastPart)) {
                    return false;
                }
            }
        }

        String name = sootMethod.getName();
        if (name.contains("$") || name.toLowerCase().contains("lambda")) {
            return false;
        }

        String subSig = sootMethod.getSubSignature();
        if (subSig.endsWith("valueOf(java.lang.String)") || 
            subSig.endsWith("[] values()")) {
            return false;
        }

        if (!sootMethod.isStatic()) {
            String methodName = sootMethod.getName();
            if (methodName.startsWith("get") || methodName.startsWith("set") || methodName.startsWith("is")) {
                return false;
            }
        }

        if (sootMethod.isMain() || cg.edgesInto(sootMethod).hasNext()) {
            return false;
        }

        SootClass declaringClass = sootMethod.getDeclaringClass();
        SootMethod superMethod = SootUtilsKt.findMethodOrNull(declaringClass, 
            sootMethod.getSubSignature().toString(), 
            it -> !it.equals(sootMethod) && !it.isConstructor() && !it.isPrivate());
        
        if (superMethod != null || calleeAndSuperMethods.contains(sootMethod)) {
            return false;
        }

        return sootMethod.hasActiveBody();
    }

    public void analyze(@NotNull SootClass clazz) {
        if (enableUnusedMethod) {
            int count = 1;
            int maxReports = builtinAnalysisConfig.getMaximumUnusedMethodReportsEachClass();
            
            clazz.getMethods().stream()
                .filter(method -> isUnused(method) && !isSkipped(method))
                .sorted(Comparator.comparing(SootMethod::getSignature))
                .limit(maxReports)
                .forEach(method -> reporter.report(DefineUnusedChecker.UnusedMethod.INSTANCE, method, null));
        }

        if (enableUrfUnreadField) {
            int count = 1;
            int maxReports = builtinAnalysisConfig.getMaximumUnusedFieldReportsEachClass();
            
            findUnusedField(clazz).stream()
                .filter(field -> !isSkipped(field))
                .sorted(Comparator.comparing(SootField::getSignature))
                .limit(maxReports)
                .forEach(field -> reporter.report(DefineUnusedChecker.UrfUnreadField.INSTANCE, field, null));
        }
    }
}
