/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.command.tools.CheckerInfoCompare
 *  cn.sast.cli.command.tools.CheckerInfoCompareOptions
 *  cn.sast.cli.command.tools.CheckerInfoCompareOptions$Companion
 *  cn.sast.common.IResFile
 *  cn.sast.common.Resource
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.parameters.groups.OptionGroup
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  com.github.ajalt.clikt.parameters.types.FileKt
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.cli.command.tools;

import cn.sast.cli.command.tools.CheckerInfoCompare;
import cn.sast.cli.command.tools.CheckerInfoCompareOptions;
import cn.sast.common.IResFile;
import cn.sast.common.Resource;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.FileKt;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\u0010\u00b2\u0006\u0012\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u008a\u0084\u0002"}, d2={"Lcn/sast/cli/command/tools/CheckerInfoCompareOptions;", "Lcom/github/ajalt/clikt/parameters/groups/OptionGroup;", "<init>", "()V", "compareRight", "Ljava/io/File;", "getCompareRight", "()Ljava/io/File;", "compareRight$delegate", "Lkotlin/properties/ReadOnlyProperty;", "compareLeft", "getCompareLeft", "compareLeft$delegate", "run", "", "Companion", "corax-cli", "output", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType"})
public final class CheckerInfoCompareOptions
extends OptionGroup {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty compareRight$delegate = OptionWithValuesKt.required((OptionWithValues)FileKt.file$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Compare and diff an other checker_info.json", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (boolean)true, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (int)58, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
    @NotNull
    private final ReadOnlyProperty compareLeft$delegate = OptionWithValuesKt.required((OptionWithValues)FileKt.file$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], (String)"Compare and diff an other checker_info.json", null, (boolean)false, null, null, null, null, (boolean)false, (int)508, null), (boolean)true, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (int)58, null)).provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
    @NotNull
    private static final KLogger logger;

    public CheckerInfoCompareOptions() {
        super("Compare checker_info.json Options", null, 2, null);
    }

    private final File getCompareRight() {
        return (File)this.compareRight$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    private final File getCompareLeft() {
        return (File)this.compareLeft$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    public final void run() {
        Lazy output$delegate = LazyKt.lazy(() -> CheckerInfoCompareOptions.run$lambda$3(this));
        CheckerInfoCompare checkerInfoCompare = new CheckerInfoCompare();
        Path path = CheckerInfoCompareOptions.run$lambda$4((Lazy)output$delegate);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"run$lambda$4(...)");
        String string = this.getCompareLeft().getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        IResFile iResFile = Resource.INSTANCE.fileOf(string);
        String string2 = this.getCompareRight().getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
        checkerInfoCompare.compareWith(path, iResFile, Resource.INSTANCE.fileOf(string2));
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private static final Object run$lambda$3$lambda$2$lambda$1(Path $it) {
        return "The compare output path is: " + $it;
    }

    private static final Path run$lambda$3(CheckerInfoCompareOptions this$0) {
        Path path;
        Path it = path = this$0.getCompareLeft().toPath().getParent().resolve("compare-result");
        boolean bl = false;
        Intrinsics.checkNotNull((Object)it);
        LinkOption[] linkOptionArray = new LinkOption[]{};
        if (!Files.exists(it, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
            Files.createDirectories(it, new FileAttribute[0]);
        }
        it = path = path.normalize();
        boolean bl2 = false;
        logger.info(() -> CheckerInfoCompareOptions.run$lambda$3$lambda$2$lambda$1(it));
        return path;
    }

    private static final Path run$lambda$4(Lazy<? extends Path> $output$delegate) {
        Lazy<? extends Path> lazy = $output$delegate;
        return (Path)lazy.getValue();
    }

    private static final Unit logger$lambda$5() {
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(CheckerInfoCompareOptions.class, "compareRight", "getCompareRight()Ljava/io/File;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(CheckerInfoCompareOptions.class, "compareLeft", "getCompareLeft()Ljava/io/File;", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        logger = KotlinLogging.INSTANCE.logger(CheckerInfoCompareOptions::logger$lambda$5);
    }
}

