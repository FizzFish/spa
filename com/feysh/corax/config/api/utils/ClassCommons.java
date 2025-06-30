/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package com.feysh.corax.config.api.utils;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0006J\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006\u00a8\u0006\f"}, d2={"Lcom/feysh/corax/config/api/utils/ClassCommons;", "", "<init>", "()V", "toClassFilePath", "", "Ljava/lang/Class;", "extractJarName", "Ljava/net/URI;", "locateAllClass", "Ljava/nio/file/Path;", "clazz", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nClassCommons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassCommons.kt\ncom/feysh/corax/config/api/utils/ClassCommons\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
public final class ClassCommons {
    @NotNull
    public static final ClassCommons INSTANCE = new ClassCommons();

    private ClassCommons() {
    }

    @NotNull
    public final String toClassFilePath(@NotNull Class<?> $this$toClassFilePath) {
        Intrinsics.checkNotNullParameter($this$toClassFilePath, (String)"<this>");
        String string = $this$toClassFilePath.getName();
        if (string == null) {
            boolean bl = false;
            String string2 = "Class is local or anonymous";
            throw new IllegalArgumentException(string2.toString());
        }
        String name = string;
        return StringsKt.replace$default((String)name, (char)'.', (char)'/', (boolean)false, (int)4, null) + ".class";
    }

    private final URI extractJarName(URI $this$extractJarName) {
        String string = $this$extractJarName.getSchemeSpecificPart();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getSchemeSpecificPart(...)");
        return new URI(StringsKt.replace$default((String)StringsKt.substringBefore$default((String)string, (String)"!", null, (int)2, null), (String)" ", (String)"%20", (boolean)false, (int)4, null));
    }

    @NotNull
    public final Path locateAllClass(@NotNull Class<?> clazz) {
        Path path;
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        String path2 = this.toClassFilePath(clazz);
        URL uRL = clazz.getClassLoader().getResource(path2);
        if (uRL == null) {
            boolean $i$a$-requireNotNull-ClassCommons$locateAllClass$resource$22 = false;
            String $i$a$-requireNotNull-ClassCommons$locateAllClass$resource$22 = "No such file: " + path2;
            throw new IllegalArgumentException($i$a$-requireNotNull-ClassCommons$locateAllClass$resource$22.toString());
        }
        URL resource = uRL;
        if (Intrinsics.areEqual((Object)resource.toURI().getScheme(), (Object)"jar")) {
            URI uRI = resource.toURI();
            Intrinsics.checkNotNullExpressionValue((Object)uRI, (String)"toURI(...)");
            URI jarLocation = this.extractJarName(uRI);
            Path path3 = Paths.get(jarLocation);
            path = path3;
            Intrinsics.checkNotNullExpressionValue((Object)path3, (String)"get(...)");
        } else {
            Path path4;
            URI uri = resource.toURI();
            if (Intrinsics.areEqual((Object)uri.getScheme(), (Object)"file")) {
                Intrinsics.checkNotNull((Object)uri);
                Path path5 = Paths.get(uri);
                path4 = path5;
                Intrinsics.checkNotNullExpressionValue((Object)path5, (String)"get(...)");
            } else {
                try {
                    FileSystems.getFileSystem(uri);
                }
                catch (FileSystemNotFoundException e) {
                    FileSystems.newFileSystem(uri, MapsKt.mapOf((Pair)TuplesKt.to((Object)"zipinfo-time", (Object)"false")));
                }
                Intrinsics.checkNotNull((Object)uri);
                Path path6 = Paths.get(uri);
                path4 = path6;
                Intrinsics.checkNotNullExpressionValue((Object)path6, (String)"get(...)");
            }
            Path classLoc = path4;
            Path path7 = classLoc.toAbsolutePath();
            Intrinsics.checkNotNullExpressionValue((Object)path7, (String)"toAbsolutePath(...)");
            String fullPath = StringsKt.removeSuffix((String)StringsKt.replace$default((String)StringsKt.replace$default((String)((Object)path7.normalize()).toString(), (String)"\\", (String)"/", (boolean)false, (int)4, null), (String)"//", (String)"/", (boolean)false, (int)4, null), (CharSequence)path2);
            Path path8 = new File(fullPath).toPath();
            Intrinsics.checkNotNull((Object)path8);
            path = path8;
        }
        return path;
    }
}

