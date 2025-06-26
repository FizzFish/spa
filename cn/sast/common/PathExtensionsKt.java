/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.PathExtensionsKt
 *  cn.sast.common.PathExtensionsKt$files$1
 *  com.google.common.io.MoreFiles
 *  com.google.common.io.RecursiveDeleteOption
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.path.PathsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.apache.commons.io.FilenameUtils
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common;

import cn.sast.common.PathExtensionsKt;
import com.google.common.io.MoreFiles;
import com.google.common.io.RecursiveDeleteOption;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001a\u0010\f\u001a\u00020\r*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003\u001a\n\u0010\u0013\u001a\u00020\u0003*\u00020\u0001\u001a\n\u0010\u0014\u001a\u00020\r*\u00020\u0001\u001a\n\u0010\u0015\u001a\u00020\r*\u00020\u0001\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\"\u0015\u0010\u0007\u001a\u00020\u0005*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006\"\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\u0003*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2={"resolveDir", "Ljava/nio/file/Path;", "dir", "", "isRegularFile", "", "(Ljava/nio/file/Path;)Z", "isDirectory", "files", "", "getFiles", "(Ljava/nio/file/Path;)Ljava/util/List;", "replaceText", "", "sourceText", "replacementText", "text", "getText", "(Ljava/nio/file/Path;)Ljava/lang/String;", "getExtension", "deleteDirectoryRecursively", "deleteDirectoryContents", "corax-api"})
@SourceDebugExtension(value={"SMAP\nPathExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathExtensions.kt\ncn/sast/common/PathExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
public final class PathExtensionsKt {
    @NotNull
    public static final Path resolveDir(@NotNull Path $this$resolveDir, @NotNull String dir) {
        Intrinsics.checkNotNullParameter((Object)$this$resolveDir, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        if (!PathExtensionsKt.isDirectory((Path)$this$resolveDir)) {
            boolean $i$a$-check-PathExtensionsKt$resolveDir$42 = false;
            String $i$a$-check-PathExtensionsKt$resolveDir$42 = "Failed check: receiver.isDirectory, where receiver is: " + $this$resolveDir;
            throw new IllegalStateException($i$a$-check-PathExtensionsKt$resolveDir$42.toString());
        }
        if (!(((CharSequence)dir).length() > 0)) {
            boolean bl = false;
            String string = "Failed check: dir.length > 0, where dir is: '" + dir + "'";
            throw new IllegalStateException(string.toString());
        }
        Path resolvedDir = $this$resolveDir.resolve(dir);
        Intrinsics.checkNotNull((Object)resolvedDir);
        if (!PathExtensionsKt.isDirectory((Path)resolvedDir)) {
            boolean bl = false;
            String string = "Failed check: resolvedDir.isDirectory, where resolvedDir is: " + resolvedDir;
            throw new IllegalStateException(string.toString());
        }
        return resolvedDir;
    }

    public static final boolean isRegularFile(@NotNull Path $this$isRegularFile) {
        Intrinsics.checkNotNullParameter((Object)$this$isRegularFile, (String)"<this>");
        return Files.isRegularFile($this$isRegularFile, new LinkOption[0]);
    }

    public static final boolean isDirectory(@NotNull Path $this$isDirectory) {
        Intrinsics.checkNotNullParameter((Object)$this$isDirectory, (String)"<this>");
        return Files.isDirectory($this$isDirectory, new LinkOption[0]);
    }

    @NotNull
    public static final List<Path> getFiles(@NotNull Path $this$files) {
        Intrinsics.checkNotNullParameter((Object)$this$files, (String)"<this>");
        if (!PathExtensionsKt.isDirectory((Path)$this$files)) {
            String string = "Check failed.";
            throw new IllegalStateException(string.toString());
        }
        Function1 function1 = (Function1)files.1.INSTANCE;
        List<Path> list = Files.list($this$files).filter((Predicate)new /* Unavailable Anonymous Inner Class!! */).collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(list, (String)"collect(...)");
        return list;
    }

    public static final void replaceText(@NotNull Path $this$replaceText, @NotNull String sourceText, @NotNull String replacementText) {
        Intrinsics.checkNotNullParameter((Object)$this$replaceText, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sourceText, (String)"sourceText");
        Intrinsics.checkNotNullParameter((Object)replacementText, (String)"replacementText");
        PathsKt.writeText$default((Path)$this$replaceText, (CharSequence)StringsKt.replace$default((String)PathExtensionsKt.getText((Path)$this$replaceText), (String)sourceText, (String)replacementText, (boolean)false, (int)4, null), null, (OpenOption[])new OpenOption[0], (int)2, null);
    }

    @NotNull
    public static final String getText(@NotNull Path $this$text) {
        Intrinsics.checkNotNullParameter((Object)$this$text, (String)"<this>");
        if (!PathExtensionsKt.isRegularFile((Path)$this$text)) {
            String string = "Check failed.";
            throw new IllegalStateException(string.toString());
        }
        List<String> list = Files.readAllLines($this$text);
        Intrinsics.checkNotNullExpressionValue(list, (String)"readAllLines(...)");
        Iterable iterable = list;
        String string = System.lineSeparator();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"lineSeparator(...)");
        return CollectionsKt.joinToString$default((Iterable)iterable, (CharSequence)string, null, null, (int)0, null, null, (int)62, null);
    }

    @NotNull
    public static final String getExtension(@NotNull Path $this$getExtension) {
        Intrinsics.checkNotNullParameter((Object)$this$getExtension, (String)"<this>");
        String string = FilenameUtils.getExtension((String)((Object)$this$getExtension.getFileName()).toString());
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getExtension(...)");
        return string;
    }

    public static final void deleteDirectoryRecursively(@NotNull Path $this$deleteDirectoryRecursively) throws IOException {
        Intrinsics.checkNotNullParameter((Object)$this$deleteDirectoryRecursively, (String)"<this>");
        LinkOption[] linkOptionArray = new LinkOption[]{};
        if (!Files.exists($this$deleteDirectoryRecursively, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
            return;
        }
        RecursiveDeleteOption[] recursiveDeleteOptionArray = new RecursiveDeleteOption[]{RecursiveDeleteOption.ALLOW_INSECURE};
        MoreFiles.deleteRecursively((Path)$this$deleteDirectoryRecursively, (RecursiveDeleteOption[])recursiveDeleteOptionArray);
    }

    public static final void deleteDirectoryContents(@NotNull Path $this$deleteDirectoryContents) throws IOException {
        Intrinsics.checkNotNullParameter((Object)$this$deleteDirectoryContents, (String)"<this>");
        LinkOption[] linkOptionArray = new LinkOption[]{};
        if (!Files.exists($this$deleteDirectoryContents, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
            return;
        }
        RecursiveDeleteOption[] recursiveDeleteOptionArray = new RecursiveDeleteOption[]{RecursiveDeleteOption.ALLOW_INSECURE};
        MoreFiles.deleteDirectoryContents((Path)$this$deleteDirectoryContents, (RecursiveDeleteOption[])recursiveDeleteOptionArray);
    }
}

