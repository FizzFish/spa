/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.report.AbstractFileIndexer
 *  cn.sast.framework.report.AbstractFileIndexer$Companion
 *  cn.sast.framework.report.AbstractFileIndexer$CompareMode
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.framework.report;

import cn.sast.framework.report.AbstractFileIndexer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH&\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\tH&J\u0012\u0010\u0011\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b*\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\fJ#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u0016\u001a\u00028\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u000b\u001a\u00020\fJ#\u0010\u001a\u001a\u0004\u0018\u00018\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lcn/sast/framework/report/AbstractFileIndexer;", "PathType", "", "<init>", "()V", "errorMsgShow", "", "getNames", "", "", "path", "mode", "Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;", "(Ljava/lang/Object;Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;)Ljava/util/List;", "getPathsByName", "", "name", "hasDot", "normalizePathParts", "findFromFileIndexMap", "Lkotlin/sequences/Sequence;", "toFindNames", "find", "(Ljava/lang/Object;Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;)Lkotlin/sequences/Sequence;", "findFiles", "fileNames", "findAnyFile", "(Ljava/util/Collection;Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;)Ljava/lang/Object;", "CompareMode", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nJavaSourceLocator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaSourceLocator.kt\ncn/sast/framework/report/AbstractFileIndexer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,490:1\n1381#2:491\n1469#2,2:492\n1471#2,3:495\n1#3:494\n*S KotlinDebug\n*F\n+ 1 JavaSourceLocator.kt\ncn/sast/framework/report/AbstractFileIndexer\n*L\n197#1:491\n197#1:492,2\n197#1:495,3\n*E\n"})
public abstract class AbstractFileIndexer<PathType> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean errorMsgShow;
    @NotNull
    private static CompareMode defaultClassCompareMode = CompareMode.Class;

    @NotNull
    public abstract List<String> getNames(PathType var1, @NotNull CompareMode var2);

    @NotNull
    public abstract Collection<PathType> getPathsByName(@NotNull String var1);

    private final boolean hasDot(List<String> $this$hasDot) {
        int sz = $this$hasDot.size();
        if (sz <= 1) {
            return false;
        }
        int i = 0;
        for (String e : $this$hasDot) {
            if (++i == sz || !StringsKt.contains$default((CharSequence)e, (CharSequence)".", (boolean)false, (int)2, null)) continue;
            return true;
        }
        return false;
    }

    private final List<String> normalizePathParts(List<String> $this$normalizePathParts, CompareMode mode) {
        if (mode.isClass() && this.hasDot($this$normalizePathParts)) {
            int lastIndex = CollectionsKt.getLastIndex($this$normalizePathParts);
            ArrayList ret = new ArrayList($this$normalizePathParts.size() + 2);
            int i = 0;
            for (String e : $this$normalizePathParts) {
                if (i++ != lastIndex && StringsKt.contains$default((CharSequence)e, (CharSequence)".", (boolean)false, (int)2, null)) {
                    Collection collection = ret;
                    String[] stringArray = new String[]{"."};
                    CollectionsKt.addAll((Collection)collection, (Iterable)StringsKt.split$default((CharSequence)e, (String[])stringArray, (boolean)false, (int)0, (int)6, null));
                    continue;
                }
                ((Collection)ret).add(e);
            }
            return ret;
        }
        return $this$normalizePathParts;
    }

    static /* synthetic */ List normalizePathParts$default(AbstractFileIndexer abstractFileIndexer, List list, CompareMode compareMode, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: normalizePathParts");
        }
        if ((n & 1) != 0) {
            compareMode = CompareMode.Path;
        }
        return abstractFileIndexer.normalizePathParts(list, compareMode);
    }

    @NotNull
    public final Sequence<PathType> findFromFileIndexMap(@NotNull List<String> toFindNames, @NotNull CompareMode mode) {
        Intrinsics.checkNotNullParameter(toFindNames, (String)"toFindNames");
        Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
        return SequencesKt.sequence((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    public static /* synthetic */ Sequence findFromFileIndexMap$default(AbstractFileIndexer abstractFileIndexer, List list, CompareMode compareMode, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findFromFileIndexMap");
        }
        if ((n & 2) != 0) {
            compareMode = CompareMode.Path;
        }
        return abstractFileIndexer.findFromFileIndexMap(list, compareMode);
    }

    @NotNull
    public final Sequence<PathType> findFromFileIndexMap(PathType find, @NotNull CompareMode mode) {
        Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
        return this.findFromFileIndexMap(this.getNames(find, mode), mode);
    }

    public static /* synthetic */ Sequence findFromFileIndexMap$default(AbstractFileIndexer abstractFileIndexer, Object object, CompareMode compareMode, int n, Object object2) {
        if (object2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findFromFileIndexMap");
        }
        if ((n & 2) != 0) {
            compareMode = CompareMode.Path;
        }
        return abstractFileIndexer.findFromFileIndexMap(object, compareMode);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<PathType> findFiles(@NotNull Collection<String> fileNames, @NotNull CompareMode mode) {
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter(fileNames, (String)"fileNames");
        Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
        Iterable $this$flatMap$iv = fileNames;
        boolean $i$f$flatMapSequence = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapSequenceTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            String s = (String)element$iv$iv;
            boolean bl = false;
            if (!(StringsKt.indexOf$default((CharSequence)s, (String)"\\", (int)0, (boolean)false, (int)6, null) == -1)) {
                boolean bl2 = false;
                String string = "invalid source file name: " + s;
                throw new IllegalArgumentException(string.toString());
            }
            String[] stringArray = new String[]{"/"};
            Sequence list$iv$iv = this.findFromFileIndexMap(StringsKt.split$default((CharSequence)s, (String[])stringArray, (boolean)false, (int)0, (int)6, null), mode);
            CollectionsKt.addAll((Collection)destination$iv$iv, (Sequence)list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Nullable
    public final PathType findAnyFile(@NotNull Collection<String> fileNames, @NotNull CompareMode mode) {
        Pair src;
        Pair pair;
        block4: {
            Intrinsics.checkNotNullParameter(fileNames, (String)"fileNames");
            Intrinsics.checkNotNullParameter((Object)mode, (String)"mode");
            for (String s : (Iterable)fileNames) {
                Pair pair2;
                Pair pair3;
                boolean bl = false;
                if (!(StringsKt.indexOf$default((CharSequence)s, (String)"\\", (int)0, (boolean)false, (int)6, null) == -1)) {
                    boolean bl2 = false;
                    String string = "invalid source file name: " + s + " in " + fileNames;
                    throw new IllegalArgumentException(string.toString());
                }
                String[] stringArray = new String[]{"/"};
                if (SequencesKt.firstOrNull((Sequence)this.findFromFileIndexMap(StringsKt.split$default((CharSequence)s, (String[])stringArray, (boolean)false, (int)0, (int)6, null), mode)) != null) {
                    Object it;
                    boolean bl3 = false;
                    pair3 = TuplesKt.to((Object)s, (Object)it);
                } else {
                    pair3 = null;
                }
                if ((pair2 = pair3) == null) continue;
                pair = pair2;
                break block4;
            }
            pair = null;
        }
        Pair pair4 = src = pair;
        return (PathType)(pair4 != null ? pair4.getSecond() : null);
    }

    public static final /* synthetic */ CompareMode access$getDefaultClassCompareMode$cp() {
        return defaultClassCompareMode;
    }

    public static final /* synthetic */ void access$setDefaultClassCompareMode$cp(CompareMode compareMode) {
        defaultClassCompareMode = compareMode;
    }

    public static final /* synthetic */ List access$normalizePathParts(AbstractFileIndexer $this, List $receiver, CompareMode mode) {
        return $this.normalizePathParts($receiver, mode);
    }
}

