/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.common.IResource
 *  cn.sast.framework.SootCtx
 *  cn.sast.framework.engine.UtStaticEngine
 *  cn.sast.framework.engine.UtStaticEngine$Companion
 *  cn.sast.framework.engine.UtStaticEngineConfiguration
 *  cn.sast.framework.entries.IEntryPointProvider
 *  cn.sast.framework.result.IUTBotResultCollector
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jdk7.AutoCloseableKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.collections.immutable.PersistentSet
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.flow.FlowCollector
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.FileUtil
 *  org.utbot.common.PathUtil
 *  org.utbot.engine.Mocker
 *  org.utbot.framework.UtSettings
 *  org.utbot.framework.codegen.CodeGenerator
 *  org.utbot.framework.codegen.domain.DomainKt
 *  org.utbot.framework.codegen.domain.ForceStaticMocking
 *  org.utbot.framework.codegen.domain.NoStaticMocking
 *  org.utbot.framework.codegen.domain.StaticsMocking
 *  org.utbot.framework.codegen.domain.TestFramework
 *  org.utbot.framework.plugin.api.ClassId
 *  org.utbot.framework.plugin.api.CodegenLanguage
 *  org.utbot.framework.plugin.api.MockStrategyApi
 *  org.utbot.framework.plugin.api.TestCaseGenerator
 *  org.utbot.framework.plugin.api.TreatOverflowAsError
 *  org.utbot.framework.plugin.api.UtMethodTestSet
 *  org.utbot.framework.plugin.api.util.UtContext
 *  org.utbot.framework.plugin.services.JdkInfo
 *  org.utbot.framework.plugin.services.JdkInfoDefaultProvider
 *  org.utbot.framework.util.EngineUtilsKt
 *  org.utbot.framework.util.SootUtilsKt
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.options.Options
 */
package cn.sast.framework.engine;

import cn.sast.api.config.MainConfig;
import cn.sast.common.IResource;
import cn.sast.framework.SootCtx;
import cn.sast.framework.engine.UtStaticEngine;
import cn.sast.framework.engine.UtStaticEngineConfiguration;
import cn.sast.framework.entries.IEntryPointProvider;
import cn.sast.framework.result.IUTBotResultCollector;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.PersistentSet;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.FileUtil;
import org.utbot.common.PathUtil;
import org.utbot.engine.Mocker;
import org.utbot.framework.UtSettings;
import org.utbot.framework.codegen.CodeGenerator;
import org.utbot.framework.codegen.domain.DomainKt;
import org.utbot.framework.codegen.domain.ForceStaticMocking;
import org.utbot.framework.codegen.domain.NoStaticMocking;
import org.utbot.framework.codegen.domain.StaticsMocking;
import org.utbot.framework.codegen.domain.TestFramework;
import org.utbot.framework.plugin.api.ClassId;
import org.utbot.framework.plugin.api.CodegenLanguage;
import org.utbot.framework.plugin.api.MockStrategyApi;
import org.utbot.framework.plugin.api.TestCaseGenerator;
import org.utbot.framework.plugin.api.TreatOverflowAsError;
import org.utbot.framework.plugin.api.UtMethodTestSet;
import org.utbot.framework.plugin.api.util.UtContext;
import org.utbot.framework.plugin.services.JdkInfo;
import org.utbot.framework.plugin.services.JdkInfoDefaultProvider;
import org.utbot.framework.util.EngineUtilsKt;
import org.utbot.framework.util.SootUtilsKt;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.options.Options;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 E2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0002J$\u0010-\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,2\u0006\u0010.\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J$\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00104\u001a\u00020\u0015J\b\u00105\u001a\u000206H\u0004J,\u00107\u001a\u00020%2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002062\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\r2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020%2\u0006\u00108\u001a\u000209J&\u0010@\u001a\u00020%2\u0006\u00108\u001a\u0002092\u0006\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u00020>H\u0086@\u00a2\u0006\u0002\u0010CJ\u001e\u0010D\u001a\u00020%2\u0006\u00108\u001a\u0002092\u0006\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u00020>R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010!\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006F"}, d2={"Lcn/sast/framework/engine/UtStaticEngine;", "", "mainConfig", "Lcn/sast/api/config/MainConfig;", "utConfig", "Lcn/sast/framework/engine/UtStaticEngineConfiguration;", "<init>", "(Lcn/sast/api/config/MainConfig;Lcn/sast/framework/engine/UtStaticEngineConfiguration;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "getUtConfig", "()Lcn/sast/framework/engine/UtStaticEngineConfiguration;", "fullyQualifiedNames", "", "", "classesToMockAlways", "getClassesToMockAlways", "()Ljava/util/Set;", "setClassesToMockAlways", "(Ljava/util/Set;)V", "classpath", "Lcn/sast/common/IResource;", "getClasspath", "useDefaultJavaClassPath", "", "getUseDefaultJavaClassPath", "()Z", "classLoader", "Ljava/net/URLClassLoader;", "getClassLoader", "()Ljava/net/URLClassLoader;", "classLoader$delegate", "Lkotlin/Lazy;", "dependencyPaths", "getDependencyPaths", "()Ljava/lang/String;", "saveToFile", "", "snippet", "outputPath", "initializeCodeGenerator", "Lorg/utbot/framework/codegen/CodeGenerator;", "testFramework", "classUnderTest", "Lorg/utbot/framework/plugin/api/ClassId;", "generateTest", "testClassname", "testCases", "", "Lorg/utbot/framework/plugin/api/UtMethodTestSet;", "generateTestsForClass", "classIdUnderTest", "output", "initializeGenerator", "Lorg/utbot/framework/plugin/api/TestCaseGenerator;", "runTest", "soot", "Lcn/sast/framework/SootCtx;", "test", "entries", "Lsoot/SootMethod;", "result", "Lcn/sast/framework/result/IUTBotResultCollector;", "initUt", "analyzeSuspend", "provider", "Lcn/sast/framework/entries/IEntryPointProvider;", "(Lcn/sast/framework/SootCtx;Lcn/sast/framework/entries/IEntryPointProvider;Lcn/sast/framework/result/IUTBotResultCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyze", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nUtStaticEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UtStaticEngine.kt\ncn/sast/framework/engine/UtStaticEngine\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 UtContext.kt\norg/utbot/framework/plugin/api/util/UtContextKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,229:1\n1557#2:230\n1628#2,3:231\n1557#2:234\n1628#2,3:235\n1628#2,3:241\n1557#2:251\n1628#2,3:252\n74#3,3:238\n77#3,5:244\n13409#4,2:249\n37#5,2:255\n*S KotlinDebug\n*F\n+ 1 UtStaticEngine.kt\ncn/sast/framework/engine/UtStaticEngine\n*L\n152#1:230\n152#1:231,3\n161#1:234\n161#1:235,3\n167#1:241,3\n81#1:251\n81#1:252,3\n163#1:238,3\n163#1:244,5\n195#1:249,2\n81#1:255,2\n*E\n"})
public class UtStaticEngine {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final UtStaticEngineConfiguration utConfig;
    @NotNull
    private Set<String> classesToMockAlways;
    @NotNull
    private final Lazy classLoader$delegate;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(UtStaticEngine::logger$lambda$12);

    public UtStaticEngine(@NotNull MainConfig mainConfig, @NotNull UtStaticEngineConfiguration utConfig) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)utConfig, (String)"utConfig");
        this.mainConfig = mainConfig;
        this.utConfig = utConfig;
        this.classesToMockAlways = this.utConfig.getClassesToMockAlways();
        this.classLoader$delegate = LazyKt.lazy(() -> UtStaticEngine.classLoader_delegate$lambda$1(this));
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final UtStaticEngineConfiguration getUtConfig() {
        return this.utConfig;
    }

    @NotNull
    public final Set<String> getClassesToMockAlways() {
        return this.classesToMockAlways;
    }

    public final void setClassesToMockAlways(@NotNull Set<String> fullyQualifiedNames) {
        Intrinsics.checkNotNullParameter(fullyQualifiedNames, (String)"fullyQualifiedNames");
        for (String fullyQualifiedName : fullyQualifiedNames) {
            try {
                boolean initialize2 = false;
                Class.forName(fullyQualifiedName, initialize2, this.getClassLoader());
            }
            catch (ClassNotFoundException e) {
                logger.error("", (Throwable)e);
            }
        }
        this.classesToMockAlways = fullyQualifiedNames;
    }

    @NotNull
    public final Set<IResource> getClasspath() {
        return this.mainConfig.get_expand_class_path();
    }

    public final boolean getUseDefaultJavaClassPath() {
        return this.mainConfig.getUseDefaultJavaClassPath();
    }

    @NotNull
    public final URLClassLoader getClassLoader() {
        Lazy lazy = this.classLoader$delegate;
        return (URLClassLoader)lazy.getValue();
    }

    @NotNull
    public final String getDependencyPaths() {
        String string = System.getProperty("java.class.path");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getProperty(...)");
        return string;
    }

    public final void saveToFile(@NotNull String snippet, @Nullable String outputPath) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)snippet, (String)"snippet");
            String string = outputPath;
            if (string == null) break block0;
            String it = string;
            boolean bl = false;
            Files.write(PathUtil.INSTANCE.toPath(it), (Iterable<? extends CharSequence>)CollectionsKt.listOf((Object)snippet), new OpenOption[0]);
        }
    }

    private final CodeGenerator initializeCodeGenerator(String testFramework, ClassId classUnderTest) {
        boolean generateWarningsForStaticMocking = this.utConfig.getForceStaticMocking() == ForceStaticMocking.FORCE && this.utConfig.getStaticsMocking() instanceof NoStaticMocking;
        TestFramework testFramework2 = DomainKt.testFrameworkByName((String)testFramework);
        CodegenLanguage codegenLanguage = this.utConfig.getCodegenLanguage();
        StaticsMocking staticsMocking = this.utConfig.getStaticsMocking();
        ForceStaticMocking forceStaticMocking = this.utConfig.getForceStaticMocking();
        return new CodeGenerator(classUnderTest, null, false, testFramework2, null, staticsMocking, forceStaticMocking, generateWarningsForStaticMocking, codegenLanguage, null, null, null, false, null, 15894, null);
    }

    @NotNull
    public final String generateTest(@NotNull ClassId classUnderTest, @NotNull String testClassname, @NotNull List<UtMethodTestSet> testCases) {
        Intrinsics.checkNotNullParameter((Object)classUnderTest, (String)"classUnderTest");
        Intrinsics.checkNotNullParameter((Object)testClassname, (String)"testClassname");
        Intrinsics.checkNotNullParameter(testCases, (String)"testCases");
        return this.initializeCodeGenerator(this.utConfig.getTestFramework(), classUnderTest).generateAsString((Collection)testCases, testClassname);
    }

    public final void generateTestsForClass(@NotNull ClassId classIdUnderTest, @NotNull List<UtMethodTestSet> testCases, @NotNull IResource output) {
        File outputArgAsFile;
        Intrinsics.checkNotNullParameter((Object)classIdUnderTest, (String)"classIdUnderTest");
        Intrinsics.checkNotNullParameter(testCases, (String)"testCases");
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        String testClassName = classIdUnderTest.getSimpleName() + "Test";
        String testClassBody = this.generateTest(classIdUnderTest, testClassName, testCases);
        if (logger.isTraceEnabled()) {
            logger.info(() -> UtStaticEngine.generateTestsForClass$lambda$3(testClassBody));
        }
        if (!(outputArgAsFile = output.getFile()).exists()) {
            outputArgAsFile.mkdirs();
        }
        String outputDir = outputArgAsFile + File.separator;
        char[] cArray = new char[]{'.'};
        List packageNameAsList = CollectionsKt.dropLast((List)StringsKt.split$default((CharSequence)classIdUnderTest.getJvmName(), (char[])cArray, (boolean)false, (int)0, (int)6, null), (int)1);
        Iterable iterable = packageNameAsList;
        String string = File.separator;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"separator");
        Path path = Paths.get(outputDir + CollectionsKt.joinToString$default((Iterable)iterable, (CharSequence)string, null, null, (int)0, null, null, (int)62, null), new String[0]);
        path.toFile().mkdirs();
        this.saveToFile(testClassBody, path + File.separator + testClassName + ".java");
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final TestCaseGenerator initializeGenerator() {
        void $this$mapTo$iv$iv;
        UtSettings.INSTANCE.setTreatOverflowAsError(this.utConfig.getTreatOverflowAsError() == TreatOverflowAsError.AS_ERROR);
        JdkInfo jdkInfo = new JdkInfoDefaultProvider().getInfo();
        Iterable $this$map$iv = (Iterable)this.mainConfig.getProcessDir();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            IResource iResource = (IResource)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getPath());
        }
        List list = (List)destination$iv$iv;
        Iterable iterable2 = this.getClasspath();
        String string = File.pathSeparator;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"pathSeparator");
        DefaultConstructorMarker defaultConstructorMarker = null;
        int n = 112;
        boolean bl = false;
        boolean bl2 = false;
        Function0 function0 = null;
        List list2 = null;
        JdkInfo jdkInfo2 = jdkInfo;
        String string2 = this.getDependencyPaths();
        String string3 = CollectionsKt.joinToString$default((Iterable)iterable2, (CharSequence)string, null, null, (int)0, null, UtStaticEngine::initializeGenerator$lambda$5, (int)30, null);
        List list3 = list;
        return new TestCaseGenerator(list3, string3, string2, jdkInfo2, list2, function0, bl2, bl, n, defaultConstructorMarker);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void runTest(@NotNull SootCtx soot, @NotNull TestCaseGenerator test, @NotNull Set<? extends SootMethod> entries, @NotNull IUTBotResultCollector result) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)soot, (String)"soot");
        Intrinsics.checkNotNullParameter((Object)test, (String)"test");
        Intrinsics.checkNotNullParameter(entries, (String)"entries");
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        Iterable $this$map$iv = entries;
        boolean $i$f$map = false;
        Object object = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            SootMethod sootMethod = (SootMethod)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(EngineUtilsKt.getExecutableId((SootMethod)it));
        }
        List targetMethods = (List)destination$iv$iv;
        UtContext context$iv = new UtContext((ClassLoader)this.getClassLoader());
        boolean $i$f$withUtContext = false;
        object = UtContext.Companion.setUtContext(context$iv);
        Throwable throwable = null;
        try {
            Unit unit;
            Object it$iv = object;
            boolean bl = false;
            try {
                void destination$iv;
                void $this$mapTo$iv;
                boolean bl2 = false;
                MockStrategyApi mockStrategy = MockStrategyApi.NO_MOCKS;
                Iterable bl3 = SetsKt.plus((Set)Mocker.Companion.getDefaultSuperClassesToMockAlwaysNames(), (Iterable)this.classesToMockAlways);
                Collection collection = new LinkedHashSet();
                boolean $i$f$mapTo2 = false;
                for (Object item$iv : $this$mapTo$iv) {
                    void it;
                    String string = (String)item$iv;
                    void var20_27 = destination$iv;
                    boolean bl4 = false;
                    Intrinsics.checkNotNull((Object)it);
                    var20_27.add(new ClassId((String)it, null, false, 6, null));
                }
                Set chosenClassesToMockAlways = (Set)destination$iv;
                List testCases = TestCaseGenerator.generate$default((TestCaseGenerator)test, (List)targetMethods, (MockStrategyApi)mockStrategy, (Set)chosenClassesToMockAlways, (long)0L, null, (int)24, null);
                logger.info(() -> UtStaticEngine.runTest$lambda$9$lambda$8(testCases));
                unit = Unit.INSTANCE;
            }
            catch (Exception e$iv) {
                KotlinLogging.INSTANCE.logger("withUtContext").error((Function0)new /* Unavailable Anonymous Inner Class!! */);
                throw e$iv;
            }
            Unit unit2 = unit;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            AutoCloseableKt.closeFinally((AutoCloseable)object, (Throwable)throwable);
        }
    }

    public final void initUt(@NotNull SootCtx soot) {
        Intrinsics.checkNotNullParameter((Object)soot, (String)"soot");
        UtSettings.INSTANCE.setUseFuzzing(false);
        UtSettings.INSTANCE.setUseSandbox(false);
        UtSettings.INSTANCE.setUseConcreteExecution(false);
        UtSettings.INSTANCE.setUseCustomJavaDocTags(false);
        UtSettings.INSTANCE.setEnableSummariesGeneration(false);
        UtSettings.INSTANCE.setCheckNpeInNestedNotPrivateMethods(true);
        UtSettings.INSTANCE.setPreferredCexOption(false);
        UtSettings.INSTANCE.setUseAssembleModelGenerator(false);
        PersistentSet persistentSet = this.mainConfig.getClasspath();
        Class[] classArray = SootUtilsKt.getClassesToLoad();
        String string = FileUtil.INSTANCE.isolateClassFiles(Arrays.copyOf(classArray, classArray.length)).getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getCanonicalPath(...)");
        this.mainConfig.setClasspath(persistentSet.add((Object)string));
        Scene scene = Scene.v();
        scene.setSootClassPath(null);
        Options options = Options.v();
        Intrinsics.checkNotNullExpressionValue((Object)options, (String)"v(...)");
        soot.configureSootClassPath(options);
        Class[] $this$forEach$iv = SootUtilsKt.getClassesToLoad();
        boolean $i$f$forEach = false;
        int n = $this$forEach$iv.length;
        for (int i = 0; i < n; ++i) {
            SootClass sootClass;
            Class element$iv;
            Class clazz = element$iv = $this$forEach$iv[i];
            boolean bl = false;
            scene.addBasicClass(clazz.getName(), 3);
            SootClass it = sootClass = scene.forceResolve(clazz.getName(), 3);
            boolean bl2 = false;
            it.setApplicationClass();
        }
    }

    @Nullable
    public final Object analyzeSuspend(@NotNull SootCtx soot, @NotNull IEntryPointProvider provider, @NotNull IUTBotResultCollector result, @NotNull Continuation<? super Unit> $completion) {
        UtSettings.INSTANCE.setTreatOverflowAsError(false);
        TestCaseGenerator test = this.initializeGenerator();
        this.initUt(soot);
        Object object = provider.getIterator().collect((FlowCollector)new /* Unavailable Anonymous Inner Class!! */, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public final void analyze(@NotNull SootCtx soot, @NotNull IEntryPointProvider provider, @NotNull IUTBotResultCollector result) {
        Intrinsics.checkNotNullParameter((Object)soot, (String)"soot");
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        BuildersKt.runBlocking$default(null, (Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */), (int)1, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final URLClassLoader classLoader_delegate$lambda$1(UtStaticEngine this$0) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = SetsKt.plus((Set)this$0.getClasspath(), (Iterable)((Iterable)this$0.mainConfig.getProcessDir()));
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            IResource iResource = (IResource)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getUrl());
        }
        Collection $this$toTypedArray$iv = (List)destination$iv$iv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        URL[] urls = thisCollection$iv.toArray(new URL[0]);
        return this$0.getUseDefaultJavaClassPath() ? new URLClassLoader(urls, ClassLoader.getSystemClassLoader()) : new URLClassLoader(urls, null);
    }

    private static final Object generateTestsForClass$lambda$3(String $testClassBody) {
        return $testClassBody;
    }

    private static final CharSequence initializeGenerator$lambda$5(IResource it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getAbsolutePath();
    }

    private static final Object runTest$lambda$9$lambda$8(List $testCases) {
        return "symbolic result: " + $testCases.size();
    }

    private static final Unit logger$lambda$12() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$cp() {
        return logger;
    }
}

