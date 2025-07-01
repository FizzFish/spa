package cn.sast.cli.config;

import com.github.ajalt.clikt.core.CliktCommand;
import com.github.ajalt.clikt.parameters.options.Option;
import com.github.ajalt.clikt.parameters.options.default;
import com.github.ajalt.clikt.parameters.options.option;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FlowDroidSourceSinkTranslatorCli extends CliktCommand {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(FlowDroidSourceSinkTranslatorCli.class);
    
    private final Option<String> sourceSinkFileOption = option("--sourceSinkFile")
        .default("DEFAULT");
    private final Option<String> outOption = option("--out")
        .default("out/flowdroid/Taint");

    public FlowDroidSourceSinkTranslatorCli() {
        super("help", "Flow Droid Source Sink Translator");
    }

    @NotNull
    public String getSourceSinkFile() {
        return sourceSinkFileOption.getValue();
    }

    @NotNull
    public String getOut() {
        return outOption.getValue();
    }

    @Override
    public void run() {
        Path path;
        if ("DEFAULT".equals(getSourceSinkFile())) {
            logger.info(() -> "use default source sink file: " + FlowDroidSourceSinkTranslateKt.getFlowDroidLoc());
            path = FlowDroidSourceSinkTranslateKt.getFlowDroidClass().resolve("SourcesAndSinks.txt");
        } else {
            path = Paths.get(getSourceSinkFile());
        }

        File file = path.toFile();
        if (!file.exists()) {
            throw new IllegalArgumentException("[" + path + "] not exists");
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException("[" + path + "] not a file");
        }

        String extension = getFileExtension(file);
        String canonicalPath = file.getCanonicalPath();
        ISourceSinkDefinitionProvider provider = FlowDroidSourceSinkTranslateKt.getFlowDroidSourceSinkProvider(extension, canonicalPath);
        
        if (provider == null) {
            throw new IllegalArgumentException("[" + path + "] not a valid flowdroid source sink file");
        }
    }

    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastDot = name.lastIndexOf('.');
        return lastDot > 0 ? name.substring(lastDot + 1) : "";
    }
}