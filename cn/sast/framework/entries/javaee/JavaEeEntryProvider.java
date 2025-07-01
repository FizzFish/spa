package cn.sast.framework.entries.javaee;

import analysis.Config;
import analysis.CreateEdge;
import analysis.Implement;
import cn.sast.common.IResFile;
import cn.sast.framework.SootCtx;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.entries.utils.PhantomValueForType;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlinx.coroutines.flow.Flow;
import mock.MockObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.SootMethod;
import utils.BaseBodyGeneratorFactory;

public final class JavaEeEntryProvider implements IEntryPointProvider {
    private static final Logger logger = LoggerFactory.getLogger(JavaEeEntryProvider.class);
    private final SootCtx ctx;
    private final Set<IResFile> beanXmls;
    private final Flow<IEntryPointProvider.AnalyzeTask> iterator;

    public JavaEeEntryProvider(SootCtx ctx, Set<IResFile> beanXmls) {
        if (ctx == null) throw new IllegalArgumentException("ctx cannot be null");
        if (beanXmls == null) throw new IllegalArgumentException("beanXmls cannot be null");
        this.ctx = ctx;
        this.beanXmls = beanXmls;
        this.iterator = createIterator();
    }

    public JavaEeEntryProvider(SootCtx ctx) {
        this(ctx, new LinkedHashSet<>());
    }

    public Set<IResFile> getBeanXmls() {
        return beanXmls;
    }

    @Override
    public Flow<IEntryPointProvider.AnalyzeTask> getIterator() {
        return iterator;
    }

    private Flow<IEntryPointProvider.AnalyzeTask> createIterator() {
        return FlowKt.flow(emitter -> {
            try {
                Set<String> paths = collectBeanXmlPaths();
                SootMethod dummyMain = createDummyMain(paths);
                if (dummyMain != null) {
                    emitter.emit(new IEntryPointProvider.AnalyzeTask(dummyMain, ctx));
                }
                emitter.complete();
            } catch (Exception e) {
                emitter.error(e);
            }
            return Unit.INSTANCE;
        });
    }

    private Set<String> collectBeanXmlPaths() {
        Set<String> paths = new LinkedHashSet<>();
        for (IResFile file : beanXmls) {
            paths.add(file.getPath());
        }
        return paths;
    }

    private SootMethod createDummyMain(Set<String> beanXmlPaths) {
        PhantomValueForType p = new PhantomValueForType(null, 1, null);
        BaseBodyGeneratorFactory.instance = new CustomBodyGenerator();
        Implement.mockObject = new CustomMockObject();

        try {
            Config config = new Config();
            config.linkMainAndController = false;
            config.linkSpringCGLIB_CallEntrySyntheticAndRequestMappingMethods = false;
            config.bean_xml_paths = beanXmlPaths;

            CreateEdge edge = new CreateEdge();
            try {
                edge.initCallGraph(config);
                SootMethod dummy = edge.projectMainMethod;
                logger.info("JavaEE dummy main is {}", dummy);
                return dummy;
            } finally {
                edge.clear();
            }
        } catch (Exception e) {
            logger.error("create JavaEE dummy main failed!", e);
            return null;
        } finally {
            BaseBodyGeneratorFactory.instance = null;
        }
    }

    private static class CustomBodyGenerator extends BaseBodyGeneratorFactory {
        // Implementation omitted for brevity
    }

    private static class CustomMockObject extends MockObject {
        // Implementation omitted for brevity
    }
}
