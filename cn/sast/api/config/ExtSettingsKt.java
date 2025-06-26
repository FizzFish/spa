/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.ExtSettingsKt
 *  cn.sast.common.OS
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.api.config;

import cn.sast.common.OS;
import java.io.File;
import java.lang.invoke.LambdaMetafactory;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"logger", "Lmu/KLogger;", "coraxHomePath", "", "getCoraxHomePath", "()Ljava/lang/String;", "SETTING_FILE_NAME", "defaultSettingsPath", "defaultKeyForSettingsPath", "corax-api"})
@SourceDebugExtension(value={"SMAP\nExtSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtSettings.kt\ncn/sast/api/config/ExtSettingsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,118:1\n1#2:119\n*E\n"})
public final class ExtSettingsKt {
    @NotNull
    private static final KLogger logger;
    @NotNull
    private static final String coraxHomePath;
    @NotNull
    private static final String SETTING_FILE_NAME = "settings.properties";
    @NotNull
    private static final String defaultSettingsPath;
    @NotNull
    private static final String defaultKeyForSettingsPath = "corax.settings.path";

    @NotNull
    public static final String getCoraxHomePath() {
        return coraxHomePath;
    }

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getLogger$p() {
        return logger;
    }

    public static final /* synthetic */ String access$getDefaultSettingsPath$p() {
        return defaultSettingsPath;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static {
        block3: {
            ExtSettingsKt.logger = KotlinLogging.INSTANCE.logger((Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, logger$lambda$0(), ()Lkotlin/Unit;)());
            ExtSettingsKt.coraxHomePath = System.getProperty("user.home") + File.separatorChar + ".corax";
            var1 /* !! */  = new Path[2];
            Intrinsics.checkNotNullExpressionValue((Object)Paths.get(".", new String[0]), (String)"get(...)");
            v0 = OS.INSTANCE.getJarBinPath();
            var1 /* !! */ [1] = v0 != null ? v0.getParent() : null;
            for (Path dir : (Iterable)CollectionsKt.listOfNotNull((Object[])var1 /* !! */ )) {
                $i$a$-firstNotNullOfOrNull-ExtSettingsKt$defaultSettingsPath$1 = false;
                it = var5_4 = dir.resolve("settings.properties");
                $i$a$-takeIf-ExtSettingsKt$defaultSettingsPath$1$1 = false;
                Intrinsics.checkNotNull((Object)it);
                v1 = new LinkOption[]{};
                var3_2 = Files.exists(it, Arrays.copyOf(v1, v1.length)) ? var5_4 : null;
                if (var3_2 == null) continue;
                v2 = var3_2;
                break block3;
            }
            v2 = var0_7 = null;
        }
        if (var0_7 == null) ** GOTO lbl-1000
        var1 /* !! */  = var0_7.toString();
        if (var1 /* !! */  != null) {
            v3 /* !! */  = var1 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            v4 = Paths.get(ExtSettingsKt.coraxHomePath, new String[0]);
            Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"get(...)");
            v5 = v4.resolve("settings.properties");
            Intrinsics.checkNotNullExpressionValue((Object)v5, (String)"resolve(...)");
            v3 /* !! */  = v5.toString();
        }
        ExtSettingsKt.defaultSettingsPath = v3 /* !! */ ;
    }
}

