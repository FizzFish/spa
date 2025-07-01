package cn.sast.framework.result;

import cn.sast.common.IResDirectory;
import cn.sast.common.IResource;
import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.android.results.xml.InfoflowResultsSerializer;
import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

public class FlowDroidResultSerializer implements IFlowDroidResultCollector {
    @NotNull
    private final IResDirectory outputDir;
    private final boolean enableLineNumbers;

    public FlowDroidResultSerializer(@NotNull IResDirectory outputDir) {
        this(outputDir, true);
    }

    public FlowDroidResultSerializer(@NotNull IResDirectory outputDir, boolean enableLineNumbers) {
        if (outputDir == null) {
            throw new IllegalArgumentException("outputDir must not be null");
        }
        this.outputDir = outputDir;
        this.enableLineNumbers = enableLineNumbers;
    }

    @NotNull
    public IResDirectory getOutputDir() {
        return outputDir;
    }

    public boolean getEnableLineNumbers() {
        return enableLineNumbers;
    }

    public final void serializeResults(@NotNull InfoflowResults results, @Nullable IInfoflowCFG cfg) {
        if (results == null) {
            throw new IllegalArgumentException("results must not be null");
        }
        if (results.isEmpty()) {
            return;
        }

        IResource resultsFile = outputDir.resolve("infoflow-result.txt");
        InfoflowConfiguration config = new InfoflowConfiguration();
        config.setEnableLineNumbers(enableLineNumbers);
        InfoflowResultsSerializer serializer = new InfoflowResultsSerializer(cfg, config);

        try {
            serializer.serialize(results, resultsFile.toString());
        } catch (IOException | XMLStreamException ex) {
            System.err.println("Could not write data flow results to file: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void onResultsAvailable(@NotNull IInfoflowCFG cfg, @NotNull InfoflowResults results) {
        if (cfg == null) {
            throw new IllegalArgumentException("cfg must not be null");
        }
        if (results == null) {
            throw new IllegalArgumentException("results must not be null");
        }
        serializeResults(results, cfg);
    }

    @Override
    public boolean onResultAvailable(@Nullable IInfoflowCFG icfg, @Nullable AbstractionAtSink abs) {
        return true;
    }

    @Override
    public void flush() {
        // No-op implementation
    }
}