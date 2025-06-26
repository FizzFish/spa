/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.command.FySastCliKt
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.cli.command;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u0001X\u0080D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"defaultConfigPathName", "", "defaultConfigDir", "getDefaultConfigDir", "()Ljava/lang/String;", "ANCHOR_POINT_FILE", "getANCHOR_POINT_FILE", "MAPPING_FILE_NAME", "corax-cli"})
public final class FySastCliKt {
    @NotNull
    public static final String defaultConfigPathName = "CORAX_CONFIG_DEFAULT_DIR";
    @NotNull
    private static final String ANCHOR_POINT_FILE = ".corax" + File.separator + "anchor_point";
    @NotNull
    public static final String MAPPING_FILE_NAME = "checker_name_mapping.json";

    @Nullable
    public static final String getDefaultConfigDir() {
        String string = System.getenv(defaultConfigPathName);
        if (string == null) {
            string = System.getProperty(defaultConfigPathName);
        }
        return string;
    }

    @NotNull
    public static final String getANCHOR_POINT_FILE() {
        return ANCHOR_POINT_FILE;
    }
}

