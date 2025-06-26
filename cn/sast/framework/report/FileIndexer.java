/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResFile
 *  cn.sast.framework.report.AbstractFileIndexer
 *  cn.sast.framework.report.AbstractFileIndexer$CompareMode
 *  cn.sast.framework.report.FileIndexer
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.report;

import cn.sast.common.IResFile;
import cn.sast.framework.report.AbstractFileIndexer;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005R&\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2={"Lcn/sast/framework/report/FileIndexer;", "Lcn/sast/framework/report/AbstractFileIndexer;", "Lcn/sast/common/IResFile;", "fileNameToPathMap", "", "", "", "extensionToPathMap", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getFileNameToPathMap$corax_framework", "()Ljava/util/Map;", "getExtensionToPathMap$corax_framework", "getNames", "", "path", "mode", "Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;", "getPathsByName", "", "name", "getPathsByExtension", "extension", "count", "", "getCount", "()J", "count$delegate", "Lkotlin/Lazy;", "corax-framework"})
public final class FileIndexer
extends AbstractFileIndexer<IResFile> {
    @NotNull
    private final Map<String, Set<IResFile>> fileNameToPathMap;
    @NotNull
    private final Map<String, Set<IResFile>> extensionToPathMap;
    @NotNull
    private final Lazy count$delegate;

    public FileIndexer(@NotNull Map<String, ? extends Set<? extends IResFile>> fileNameToPathMap, @NotNull Map<String, ? extends Set<? extends IResFile>> extensionToPathMap) {
        Intrinsics.checkNotNullParameter(fileNameToPathMap, (String)"fileNameToPathMap");
        Intrinsics.checkNotNullParameter(extensionToPathMap, (String)"extensionToPathMap");
        this.fileNameToPathMap = fileNameToPathMap;
        this.extensionToPathMap = extensionToPathMap;
        this.count$delegate = LazyKt.lazy(() -> FileIndexer.count_delegate$lambda$0(this));
    }

    @NotNull
    public final Map<String, Set<IResFile>> getFileNameToPathMap$corax_framework() {
        return this.fileNameToPathMap;
    }

    @NotNull
    public final Map<String, Set<IResFile>> getExtensionToPathMap$corax_framework() {
        return this.extensionToPathMap;
    }

    @NotNull
    public List<String> getNames(@NotNull IResFile path, @NotNull AbstractFileIndexer.CompareMode mode) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
        Path p = path.getPath();
        int n = 0;
        int n2 = p.getNameCount();
        Object[] objectArray = new String[n2];
        while (n < n2) {
            int n3 = n++;
            Path path2 = p.getName(n3);
            Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"getName(...)");
            objectArray[n3] = ((Object)path2).toString();
        }
        return ArraysKt.toList((Object[])objectArray);
    }

    @NotNull
    public Collection<IResFile> getPathsByName(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Set set = (Set)this.fileNameToPathMap.get(name);
        return set != null ? (Collection)set : (Collection)CollectionsKt.emptyList();
    }

    @NotNull
    public final Collection<IResFile> getPathsByExtension(@NotNull String extension) {
        Intrinsics.checkNotNullParameter((Object)extension, (String)"extension");
        Set set = (Set)this.extensionToPathMap.get(extension);
        return set != null ? (Collection)set : (Collection)CollectionsKt.emptyList();
    }

    public final long getCount() {
        Lazy lazy = this.count$delegate;
        return ((Number)lazy.getValue()).longValue();
    }

    private static final long count_delegate$lambda$0(FileIndexer this$0) {
        long c = 0L;
        for (Map.Entry x : this$0.fileNameToPathMap.entrySet()) {
            c += (long)((Set)x.getValue()).size();
        }
        return c;
    }
}

