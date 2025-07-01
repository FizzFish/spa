import cn.sast.cli.config.FlowDroidSourceSinkTranslatorCli;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.ClassLocation;
import org.utbot.common.FileUtil;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.android.data.parsers.PermissionMethodParser;
import soot.jimple.infoflow.android.source.parsers.xml.XMLSourceSinkParser;
import soot.jimple.infoflow.rifl.RIFLSourceSinkDefinitionProvider;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;

public final class FlowDroidSourceSinkTranslateKt {
    private static final ClassLocation flowDroidLoc = FileUtil.INSTANCE.locateClass(InfoflowAndroidConfiguration.class);
    private static final Path flowDroidClass = FileUtil.INSTANCE.findPathToClassFiles(flowDroidLoc);

    @NotNull
    public static ClassLocation getFlowDroidLoc() {
        return flowDroidLoc;
    }

    @NotNull
    public static Path getFlowDroidClass() {
        return flowDroidClass;
    }

    @Nullable
    public static ISourceSinkDefinitionProvider getFlowDroidSourceSinkProvider(
            @NotNull String fileExtension, 
            @NotNull String sourceSinkFile) {
        if (fileExtension == null) {
            throw new IllegalArgumentException("fileExtension cannot be null");
        }
        if (sourceSinkFile == null) {
            throw new IllegalArgumentException("sourceSinkFile cannot be null");
        }

        return switch (fileExtension) {
            case "xml" -> XMLSourceSinkParser.fromFile(sourceSinkFile, null);
            case "txt" -> PermissionMethodParser.fromFile(sourceSinkFile);
            case "rifl" -> new RIFLSourceSinkDefinitionProvider(sourceSinkFile);
            default -> null;
        };
    }

    public static void main(@NotNull String[] args) {
        if (args == null) {
            throw new IllegalArgumentException("args cannot be null");
        }

        try {
            new FlowDroidSourceSinkTranslatorCli().main(args);
        } catch (Throwable ex) {
            ex.printStackTrace();
            System.exit(1);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }
}