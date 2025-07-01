package cn.sast.framework.engine;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.framework.codegen.domain.ForceStaticMocking;
import org.utbot.framework.codegen.domain.StaticsMocking;
import org.utbot.framework.plugin.api.CodegenLanguage;
import org.utbot.framework.plugin.api.MockStrategyApi;
import org.utbot.framework.plugin.api.TreatOverflowAsError;
import mu.KLogger;
import mu.KotlinLogging;
import java.util.Set;
import java.util.Collections;

public final class UtStaticEngineConfiguration {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(UtStaticEngineConfiguration.class.getName());

    @NotNull
    private CodegenLanguage codegenLanguage;
    @NotNull
    private MockStrategyApi mockStrategy;
    @NotNull
    private String testFramework;
    @NotNull
    private StaticsMocking staticsMocking;
    @NotNull
    private ForceStaticMocking forceStaticMocking;
    @NotNull
    private TreatOverflowAsError treatOverflowAsError;
    @NotNull
    private Set<String> classesToMockAlways;

    public UtStaticEngineConfiguration(
            @NotNull CodegenLanguage codegenLanguage,
            @NotNull MockStrategyApi mockStrategy,
            @NotNull String testFramework,
            @NotNull StaticsMocking staticsMocking,
            @NotNull ForceStaticMocking forceStaticMocking,
            @NotNull TreatOverflowAsError treatOverflowAsError) {
        if (codegenLanguage == null) throw new IllegalArgumentException("codegenLanguage cannot be null");
        if (mockStrategy == null) throw new IllegalArgumentException("mockStrategy cannot be null");
        if (testFramework == null) throw new IllegalArgumentException("testFramework cannot be null");
        if (staticsMocking == null) throw new IllegalArgumentException("staticsMocking cannot be null");
        if (forceStaticMocking == null) throw new IllegalArgumentException("forceStaticMocking cannot be null");
        if (treatOverflowAsError == null) throw new IllegalArgumentException("treatOverflowAsError cannot be null");

        this.codegenLanguage = codegenLanguage;
        this.mockStrategy = mockStrategy;
        this.testFramework = testFramework;
        this.staticsMocking = staticsMocking;
        this.forceStaticMocking = forceStaticMocking;
        this.treatOverflowAsError = treatOverflowAsError;
        this.classesToMockAlways = Collections.emptySet();
    }

    public UtStaticEngineConfiguration() {
        this(
            CodegenLanguage.getDefaultItem(),
            MockStrategyApi.NO_MOCKS,
            "junit4",
            StaticsMocking.getDefaultItem(),
            ForceStaticMocking.getDefaultItem(),
            TreatOverflowAsError.getDefaultItem()
        );
    }

    @NotNull
    public CodegenLanguage getCodegenLanguage() {
        return codegenLanguage;
    }

    public void setCodegenLanguage(@NotNull CodegenLanguage codegenLanguage) {
        if (codegenLanguage == null) throw new IllegalArgumentException("codegenLanguage cannot be null");
        this.codegenLanguage = codegenLanguage;
    }

    @NotNull
    public MockStrategyApi getMockStrategy() {
        return mockStrategy;
    }

    public void setMockStrategy(@NotNull MockStrategyApi mockStrategy) {
        if (mockStrategy == null) throw new IllegalArgumentException("mockStrategy cannot be null");
        this.mockStrategy = mockStrategy;
    }

    @NotNull
    public String getTestFramework() {
        return testFramework;
    }

    public void setTestFramework(@NotNull String testFramework) {
        if (testFramework == null) throw new IllegalArgumentException("testFramework cannot be null");
        this.testFramework = testFramework;
    }

    @NotNull
    public StaticsMocking getStaticsMocking() {
        return staticsMocking;
    }

    public void setStaticsMocking(@NotNull StaticsMocking staticsMocking) {
        if (staticsMocking == null) throw new IllegalArgumentException("staticsMocking cannot be null");
        this.staticsMocking = staticsMocking;
    }

    @NotNull
    public ForceStaticMocking getForceStaticMocking() {
        return forceStaticMocking;
    }

    public void setForceStaticMocking(@NotNull ForceStaticMocking forceStaticMocking) {
        if (forceStaticMocking == null) throw new IllegalArgumentException("forceStaticMocking cannot be null");
        this.forceStaticMocking = forceStaticMocking;
    }

    @NotNull
    public TreatOverflowAsError getTreatOverflowAsError() {
        return treatOverflowAsError;
    }

    public void setTreatOverflowAsError(@NotNull TreatOverflowAsError treatOverflowAsError) {
        if (treatOverflowAsError == null) throw new IllegalArgumentException("treatOverflowAsError cannot be null");
        this.treatOverflowAsError = treatOverflowAsError;
    }

    @NotNull
    public Set<String> getClassesToMockAlways() {
        return classesToMockAlways;
    }

    public void setClassesToMockAlways(@NotNull Set<String> classesToMockAlways) {
        if (classesToMockAlways == null) throw new IllegalArgumentException("classesToMockAlways cannot be null");
        this.classesToMockAlways = classesToMockAlways;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof UtStaticEngineConfiguration)) return false;
        
        UtStaticEngineConfiguration that = (UtStaticEngineConfiguration) other;
        return codegenLanguage == that.codegenLanguage &&
               mockStrategy == that.mockStrategy &&
               testFramework.equals(that.testFramework) &&
               staticsMocking.equals(that.staticsMocking) &&
               forceStaticMocking == that.forceStaticMocking &&
               treatOverflowAsError == that.treatOverflowAsError;
    }

    @Override
    public int hashCode() {
        int result = codegenLanguage.hashCode();
        result = 31 * result + mockStrategy.hashCode();
        result = 31 * result + testFramework.hashCode();
        result = 31 * result + staticsMocking.hashCode();
        result = 31 * result + forceStaticMocking.hashCode();
        result = 31 * result + treatOverflowAsError.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UtStaticEngineConfiguration{" +
               "codegenLanguage=" + codegenLanguage +
               ", mockStrategy=" + mockStrategy +
               ", testFramework='" + testFramework + '\'' +
               ", staticsMocking=" + staticsMocking +
               ", forceStaticMocking=" + forceStaticMocking +
               ", treatOverflowAsError=" + treatOverflowAsError +
               '}';
    }
}