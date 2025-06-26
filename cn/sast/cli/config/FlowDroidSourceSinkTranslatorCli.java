/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.config.FlowDroidSourceSinkTranslateKt
 *  cn.sast.cli.config.FlowDroidSourceSinkTranslatorCli
 *  cn.sast.cli.config.FlowDroidSourceSinkTranslatorCli$Companion
 *  com.github.ajalt.clikt.core.CliktCommand
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider
 */
package cn.sast.cli.config;

import cn.sast.cli.config.FlowDroidSourceSinkTranslateKt;
import cn.sast.cli.config.FlowDroidSourceSinkTranslatorCli;
import com.github.ajalt.clikt.core.CliktCommand;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\u0010"}, d2={"Lcn/sast/cli/config/FlowDroidSourceSinkTranslatorCli;", "Lcom/github/ajalt/clikt/core/CliktCommand;", "<init>", "()V", "sourceSinkFile", "", "getSourceSinkFile", "()Ljava/lang/String;", "sourceSinkFile$delegate", "Lkotlin/properties/ReadOnlyProperty;", "out", "getOut", "out$delegate", "run", "", "Companion", "corax-cli"})
@SourceDebugExtension(value={"SMAP\nFlowDroidSourceSinkTranslate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowDroidSourceSinkTranslate.kt\ncn/sast/cli/config/FlowDroidSourceSinkTranslatorCli\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,143:1\n1#2:144\n*E\n"})
public final class FlowDroidSourceSinkTranslatorCli
extends CliktCommand {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty sourceSinkFile$delegate = OptionWithValuesKt.default$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"sourceSinkFile", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (Object)"DEFAULT", null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
    @NotNull
    private final ReadOnlyProperty out$delegate = OptionWithValuesKt.default$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"sourceSinkFile", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (Object)"out/flowdroid/Taint", null, (int)2, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
    @NotNull
    private static final KLogger logger;

    public FlowDroidSourceSinkTranslatorCli() {
        super("help", null, "Flow Droid Source Sink Translator", false, false, null, null, false, false, false, 1002, null);
    }

    @NotNull
    public final String getSourceSinkFile() {
        return (String)this.sourceSinkFile$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    @NotNull
    public final String getOut() {
        return (String)this.out$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    public void run() {
        Path path;
        if (Intrinsics.areEqual((Object)this.getSourceSinkFile(), (Object)"DEFAULT")) {
            logger.info(FlowDroidSourceSinkTranslatorCli::run$lambda$0);
            path = FlowDroidSourceSinkTranslateKt.getFlowDroidClass().resolve("SourcesAndSinks.txt");
        } else {
            path = Paths.get(this.getSourceSinkFile(), new String[0]);
        }
        Path path2 = path;
        File file = path2.toFile();
        if (!file.exists()) {
            boolean $i$a$-require-FlowDroidSourceSinkTranslatorCli$run$42 = false;
            String $i$a$-require-FlowDroidSourceSinkTranslatorCli$run$42 = "[" + path2 + "] not exists";
            throw new IllegalArgumentException($i$a$-require-FlowDroidSourceSinkTranslatorCli$run$42.toString());
        }
        if (!file.isFile()) {
            boolean bl = false;
            String string = "[" + path2 + "] not a file";
            throw new IllegalArgumentException(string.toString());
        }
        Intrinsics.checkNotNull((Object)file);
        String string = FilesKt.getExtension((File)file);
        String string2 = file.getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getCanonicalPath(...)");
        ISourceSinkDefinitionProvider provider = FlowDroidSourceSinkTranslateKt.getFlowDroidSourceSinkProvider((String)string, (String)string2);
        if (!(provider != null)) {
            boolean bl = false;
            String string3 = "[" + path2 + "] not a valid flowdroid source sink file";
            throw new IllegalArgumentException(string3.toString());
        }
    }

    private static final Object run$lambda$0() {
        return "use default source sink file: " + FlowDroidSourceSinkTranslateKt.getFlowDroidLoc();
    }

    private static final Unit logger$lambda$4() {
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidSourceSinkTranslatorCli.class, "sourceSinkFile", "getSourceSinkFile()Ljava/lang/String;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FlowDroidSourceSinkTranslatorCli.class, "out", "getOut()Ljava/lang/String;", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        logger = KotlinLogging.INSTANCE.logger(FlowDroidSourceSinkTranslatorCli::logger$lambda$4);
    }
}

