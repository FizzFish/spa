/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.config.FlowDroidSourceSinkTranslateKt
 *  cn.sast.cli.config.FlowDroidSourceSinkTranslatorCli
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.ClassLocation
 *  org.utbot.common.FileUtil
 *  soot.jimple.infoflow.android.InfoflowAndroidConfiguration
 *  soot.jimple.infoflow.android.data.parsers.PermissionMethodParser
 *  soot.jimple.infoflow.android.source.parsers.xml.XMLSourceSinkParser
 *  soot.jimple.infoflow.rifl.RIFLSourceSinkDefinitionProvider
 *  soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider
 */
package cn.sast.cli.config;

import cn.sast.cli.config.FlowDroidSourceSinkTranslatorCli;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.ClassLocation;
import org.utbot.common.FileUtil;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.android.data.parsers.PermissionMethodParser;
import soot.jimple.infoflow.android.source.parsers.xml.XMLSourceSinkParser;
import soot.jimple.infoflow.rifl.RIFLSourceSinkDefinitionProvider;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0019\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\u0002\u0010\u0011\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2={"flowDroidLoc", "Lorg/utbot/common/ClassLocation;", "getFlowDroidLoc", "()Lorg/utbot/common/ClassLocation;", "flowDroidClass", "Ljava/nio/file/Path;", "getFlowDroidClass", "()Ljava/nio/file/Path;", "getFlowDroidSourceSinkProvider", "Lsoot/jimple/infoflow/sourcesSinks/definitions/ISourceSinkDefinitionProvider;", "fileExtension", "", "sourceSinkFile", "main", "", "args", "", "([Ljava/lang/String;)V", "corax-cli"})
public final class FlowDroidSourceSinkTranslateKt {
    @NotNull
    private static final ClassLocation flowDroidLoc = FileUtil.INSTANCE.locateClass(InfoflowAndroidConfiguration.class);
    @NotNull
    private static final Path flowDroidClass = FileUtil.INSTANCE.findPathToClassFiles(flowDroidLoc);

    @NotNull
    public static final ClassLocation getFlowDroidLoc() {
        return flowDroidLoc;
    }

    @NotNull
    public static final Path getFlowDroidClass() {
        return flowDroidClass;
    }

    @Nullable
    public static final ISourceSinkDefinitionProvider getFlowDroidSourceSinkProvider(@NotNull String fileExtension, @NotNull String sourceSinkFile) {
        Intrinsics.checkNotNullParameter((Object)fileExtension, (String)"fileExtension");
        Intrinsics.checkNotNullParameter((Object)sourceSinkFile, (String)"sourceSinkFile");
        return switch (fileExtension) {
            case "xml" -> (ISourceSinkDefinitionProvider)XMLSourceSinkParser.fromFile((String)sourceSinkFile, null);
            case "txt" -> (ISourceSinkDefinitionProvider)PermissionMethodParser.fromFile((String)sourceSinkFile);
            case "rifl" -> (ISourceSinkDefinitionProvider)new RIFLSourceSinkDefinitionProvider(sourceSinkFile);
            default -> null;
        };
    }

    public static final void main(@NotNull String[] args) {
        Intrinsics.checkNotNullParameter((Object)args, (String)"args");
        try {
            new FlowDroidSourceSinkTranslatorCli().main(args);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
            System.exit(1);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }
}

