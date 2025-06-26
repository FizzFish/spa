/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.MainConfigKt
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles$InterProceduralAnalysisDependsGraph
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph
 *  cn.sast.api.incremental.ModifyInfoFactory
 *  cn.sast.api.util.SootUtilsKt
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.framework.incremental.IncrementalAnalyzeImplByChangeFiles
 *  cn.sast.framework.incremental.IncrementalAnalyzeImplByChangeFiles$Companion
 *  cn.sast.framework.incremental.IncrementalAnalyzeImplByChangeFiles$getChangeType$indexer$1
 *  cn.sast.framework.incremental.ModifyInfoFactoryImpl
 *  cn.sast.framework.report.AbstractFileIndexer
 *  cn.sast.framework.report.AbstractFileIndexer$CompareMode
 *  cn.sast.framework.report.ProjectFileLocator
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.eclipse.jgit.diff.DiffEntry
 *  org.eclipse.jgit.patch.FileHeader
 *  org.eclipse.jgit.patch.Patch
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 *  soot.SootClass
 */
package cn.sast.framework.incremental;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.MainConfigKt;
import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.incremental.ModifyInfoFactory;
import cn.sast.api.util.SootUtilsKt;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.framework.incremental.IncrementalAnalyzeImplByChangeFiles;
import cn.sast.framework.incremental.ModifyInfoFactoryImpl;
import cn.sast.framework.report.AbstractFileIndexer;
import cn.sast.framework.report.ProjectFileLocator;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.patch.FileHeader;
import org.eclipse.jgit.patch.Patch;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 @2\u00020\u0001:\u0001@B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0017H\u0002J\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)J2\u0010*\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00170+j\u0002`,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140.2\u0006\u0010/\u001a\u000200H\u0002J$\u00101\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00170+j\u0002`,2\u0006\u00102\u001a\u000203H\u0016J$\u00104\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00170+j\u0002`,2\u0006\u00105\u001a\u00020\u0014H\u0016J\u0010\u00106\u001a\u00020 2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\u0014H\u0002J\u0010\u0010;\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0014H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020 2\u0006\u0010=\u001a\u00020>H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00190\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2={"Lcn/sast/framework/incremental/IncrementalAnalyzeImplByChangeFiles;", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "mappingDiffInArchive", "", "factory", "Lcn/sast/api/incremental/ModifyInfoFactory;", "simpleDeclAnalysisDependsGraph", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph;", "interProceduralAnalysisDependsGraph", "Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$InterProceduralAnalysisDependsGraph;", "<init>", "(Lcn/sast/api/config/MainConfig;ZLcn/sast/api/incremental/ModifyInfoFactory;Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph;Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$InterProceduralAnalysisDependsGraph;)V", "getSimpleDeclAnalysisDependsGraph", "()Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$SimpleDeclAnalysisDependsGraph;", "getInterProceduralAnalysisDependsGraph", "()Lcn/sast/api/incremental/IncrementalAnalyzeByChangeFiles$InterProceduralAnalysisDependsGraph;", "modifyFiles", "Ljava/util/LinkedHashSet;", "", "oldPath2Header", "Ljava/util/LinkedHashMap;", "Lorg/eclipse/jgit/diff/DiffEntry;", "newPath2Header", "Lorg/eclipse/jgit/patch/FileHeader;", "pathsInPatch", "name2Path", "", "", "ignoreCase", "visitChangedDecl", "", "target", "", "diffPath", "diff", "update", "scene", "Lsoot/Scene;", "locator", "Lcn/sast/framework/report/ProjectFileLocator;", "getChangeType", "Lkotlin/Pair;", "Lcn/sast/api/incremental/ChangeType;", "possibleSourceFiles", "", "mode", "Lcn/sast/framework/report/AbstractFileIndexer$CompareMode;", "getChangeTypeOfClass", "cls", "Lsoot/SootClass;", "getChangeTypeOfFile", "file", "parseIncrementBaseFile", "base", "Lcn/sast/common/IResource;", "addOnePath", "p", "normalizePath", "parseChangeFiles", "diffFilePath", "Lcn/sast/common/IResFile;", "parseGitDiff", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nIncrementalAnalyzeImplByChangeFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IncrementalAnalyzeImplByChangeFiles.kt\ncn/sast/framework/incremental/IncrementalAnalyzeImplByChangeFiles\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,395:1\n1317#2,2:396\n1#3:398\n1557#4:399\n1628#4,3:400\n381#5,7:403\n*S KotlinDebug\n*F\n+ 1 IncrementalAnalyzeImplByChangeFiles.kt\ncn/sast/framework/incremental/IncrementalAnalyzeImplByChangeFiles\n*L\n264#1:396,2\n299#1:399\n299#1:400,3\n337#1:403,7\n*E\n"})
public final class IncrementalAnalyzeImplByChangeFiles
implements IncrementalAnalyzeByChangeFiles {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    private final boolean mappingDiffInArchive;
    @NotNull
    private final ModifyInfoFactory factory;
    @NotNull
    private final IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph simpleDeclAnalysisDependsGraph;
    @NotNull
    private final IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph interProceduralAnalysisDependsGraph;
    @NotNull
    private final LinkedHashSet<String> modifyFiles;
    @NotNull
    private final LinkedHashMap<String, DiffEntry> oldPath2Header;
    @NotNull
    private final LinkedHashMap<String, FileHeader> newPath2Header;
    @NotNull
    private final LinkedHashSet<String> pathsInPatch;
    @NotNull
    private final Map<String, Set<String>> name2Path;
    private boolean ignoreCase;
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(IncrementalAnalyzeImplByChangeFiles::logger$lambda$12);

    public IncrementalAnalyzeImplByChangeFiles(@NotNull MainConfig mainConfig, boolean mappingDiffInArchive, @NotNull ModifyInfoFactory factory, @NotNull IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph simpleDeclAnalysisDependsGraph, @NotNull IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph interProceduralAnalysisDependsGraph) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)factory, (String)"factory");
        Intrinsics.checkNotNullParameter((Object)simpleDeclAnalysisDependsGraph, (String)"simpleDeclAnalysisDependsGraph");
        Intrinsics.checkNotNullParameter((Object)interProceduralAnalysisDependsGraph, (String)"interProceduralAnalysisDependsGraph");
        this.mainConfig = mainConfig;
        this.mappingDiffInArchive = mappingDiffInArchive;
        this.factory = factory;
        this.simpleDeclAnalysisDependsGraph = simpleDeclAnalysisDependsGraph;
        this.interProceduralAnalysisDependsGraph = interProceduralAnalysisDependsGraph;
        this.modifyFiles = new LinkedHashSet();
        this.oldPath2Header = new LinkedHashMap();
        this.newPath2Header = new LinkedHashMap();
        this.pathsInPatch = new LinkedHashSet();
        this.name2Path = new HashMap();
    }

    public /* synthetic */ IncrementalAnalyzeImplByChangeFiles(MainConfig mainConfig, boolean bl, ModifyInfoFactory modifyInfoFactory, IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph simpleDeclAnalysisDependsGraph, IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph interProceduralAnalysisDependsGraph, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = true;
        }
        if ((n & 4) != 0) {
            modifyInfoFactory = (ModifyInfoFactory)new ModifyInfoFactoryImpl();
        }
        if ((n & 8) != 0) {
            simpleDeclAnalysisDependsGraph = modifyInfoFactory.createSimpleDeclAnalysisDependsGraph();
        }
        if ((n & 0x10) != 0) {
            interProceduralAnalysisDependsGraph = modifyInfoFactory.createInterProceduralAnalysisDependsGraph();
        }
        this(mainConfig, bl, modifyInfoFactory, simpleDeclAnalysisDependsGraph, interProceduralAnalysisDependsGraph);
    }

    @NotNull
    public IncrementalAnalyzeByChangeFiles.SimpleDeclAnalysisDependsGraph getSimpleDeclAnalysisDependsGraph() {
        return this.simpleDeclAnalysisDependsGraph;
    }

    @NotNull
    public IncrementalAnalyzeByChangeFiles.InterProceduralAnalysisDependsGraph getInterProceduralAnalysisDependsGraph() {
        return this.interProceduralAnalysisDependsGraph;
    }

    private final void visitChangedDecl(Object target, String diffPath, DiffEntry diff2) {
        if (!this.pathsInPatch.contains(diffPath)) {
            String string = "Check failed.";
            throw new IllegalStateException(string.toString());
        }
        Collection changed = this.factory.getPatchedDeclsByDiff(target, diff2);
        this.getSimpleDeclAnalysisDependsGraph().visitChangedDecl(diffPath, changed);
        this.getInterProceduralAnalysisDependsGraph().visitChangedDecl(diffPath, changed);
    }

    public final void update(@NotNull Scene scene, @Nullable ProjectFileLocator locator2) {
        String[] stringArray;
        Intrinsics.checkNotNullParameter((Object)scene, (String)"scene");
        Iterator iterator2 = scene.getClasses().snapshotIterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"snapshotIterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            SootClass clazz = (SootClass)iterator3.next();
            Intrinsics.checkNotNull((Object)clazz);
            stringArray = this.getChangeTypeOfClass(clazz);
            DiffEntry old = (DiffEntry)stringArray.component1();
            DiffEntry diffEntry = (DiffEntry)stringArray.component2();
            if (old != null) {
                String string = old.getOldPath();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getOldPath(...)");
                this.visitChangedDecl((Object)clazz, string, old);
            }
            if (diffEntry == null) continue;
            String string = diffEntry.getNewPath();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getNewPath(...)");
            this.visitChangedDecl((Object)clazz, string, diffEntry);
        }
        if (locator2 != null) {
            Iterator iterator4 = this.pathsInPatch.iterator();
            Intrinsics.checkNotNullExpressionValue(iterator4, (String)"iterator(...)");
            iterator3 = iterator4;
            while (iterator3.hasNext()) {
                Object e = iterator3.next();
                Intrinsics.checkNotNullExpressionValue(e, (String)"next(...)");
                String p = (String)e;
                stringArray = new String[]{"/"};
                Sequence $this$forEach$iv = locator2.findFromFileIndexMap(StringsKt.split$default((CharSequence)p, (String[])stringArray, (boolean)false, (int)0, (int)6, null), AbstractFileIndexer.CompareMode.Path);
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    IResFile it = (IResFile)element$iv;
                    boolean bl = false;
                    if (!this.mappingDiffInArchive && MainConfigKt.skipResourceInArchive((MainConfig)this.mainConfig, (IResource)((IResource)it))) continue;
                    DiffEntry old = (DiffEntry)this.oldPath2Header.get(p);
                    FileHeader fileHeader = (FileHeader)this.newPath2Header.get(p);
                    if (old != null) {
                        if (!Intrinsics.areEqual((Object)old.getOldPath(), (Object)p)) {
                            String string = "Check failed.";
                            throw new IllegalStateException(string.toString());
                        }
                        this.visitChangedDecl((Object)it, p, old);
                    }
                    if (fileHeader == null) continue;
                    if (!Intrinsics.areEqual((Object)fileHeader.getNewPath(), (Object)p)) {
                        String string = "Check failed.";
                        throw new IllegalStateException(string.toString());
                    }
                    this.visitChangedDecl((Object)it, p, (DiffEntry)fileHeader);
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<DiffEntry, DiffEntry> getChangeType(Collection<String> possibleSourceFiles, AbstractFileIndexer.CompareMode mode) {
        Pair pair;
        Pair pair2;
        block5: {
            Collection collection;
            getChangeType.indexer.1 indexer2 = new /* Unavailable Anonymous Inner Class!! */;
            Collection<String> collection2 = possibleSourceFiles;
            getChangeType.indexer.1 var18_5 = indexer2;
            boolean bl = false;
            if (this.ignoreCase) {
                void $this$mapTo$iv$iv;
                Iterable $this$map$iv = (Iterable)set;
                boolean $i$f$map = false;
                Iterable iterable = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    String string = (String)item$iv$iv;
                    Collection collection3 = destination$iv$iv;
                    boolean bl2 = false;
                    void var17_18 = it;
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
                    String string2 = var17_18.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
                    collection3.add(string2);
                }
                collection = (List)destination$iv$iv;
            } else {
                collection = set;
            }
            List found = var18_5.findFiles(collection, mode);
            for (String it : (Iterable)found) {
                boolean bl3 = false;
                Pair pair3 = TuplesKt.to(this.oldPath2Header.get(it), this.newPath2Header.get(it));
                if (pair3 == null) continue;
                pair2 = pair3;
                break block5;
            }
            pair2 = pair = null;
        }
        if (pair2 == null) {
            pair = new Pair(null, null);
        }
        return pair;
    }

    @NotNull
    public Pair<DiffEntry, DiffEntry> getChangeTypeOfClass(@NotNull SootClass cls) {
        Intrinsics.checkNotNullParameter((Object)cls, (String)"cls");
        return this.getChangeType((Collection)SootUtilsKt.getPossibleSourceFiles((SootClass)cls), AbstractFileIndexer.Companion.getDefaultClassCompareMode());
    }

    @NotNull
    public Pair<DiffEntry, DiffEntry> getChangeTypeOfFile(@NotNull String file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return this.getChangeType((Collection)CollectionsKt.listOf((Object)file), AbstractFileIndexer.CompareMode.Path);
    }

    public void parseIncrementBaseFile(@NotNull IResource base) {
        Intrinsics.checkNotNullParameter((Object)base, (String)"base");
        if (!base.getExists()) {
            throw new IllegalStateException(("The incremental base file: `" + base + "` not exists").toString());
        }
        if (!base.isFile()) {
            throw new IllegalStateException(("The incremental base file: `" + base + "` is not a file").toString());
        }
        IResFile file = base.toFile();
        switch (file.getExtension()) {
            case "txt": {
                this.parseChangeFiles(file);
                break;
            }
            case "patch": 
            case "diff": {
                this.parseGitDiff(file);
                break;
            }
            default: {
                throw new IllegalStateException(("The incremental base file: `" + base + "` with a unsupported extension. Now only support .diff/.patch/.txt").toString());
            }
        }
    }

    private final void addOnePath(String p) {
        Object object;
        if (!(StringsKt.indexOf$default((CharSequence)p, (String)"\\", (int)0, (boolean)false, (int)6, null) == -1)) {
            String string = "Check failed.";
            throw new IllegalStateException(string.toString());
        }
        ((Collection)this.pathsInPatch).add(p);
        String name = StringsKt.substringAfterLast$default((String)StringsKt.removeSuffix((String)p, (CharSequence)"/"), (String)"/", null, (int)2, null);
        Map $this$getOrPut$iv = this.name2Path;
        boolean $i$f$getOrPut = false;
        Object value$iv = $this$getOrPut$iv.get(name);
        if (value$iv == null) {
            boolean bl = false;
            Set answer$iv = new LinkedHashSet();
            $this$getOrPut$iv.put(name, answer$iv);
            object = answer$iv;
        } else {
            object = value$iv;
        }
        ((Set)object).add(p);
    }

    /*
     * WARNING - void declaration
     */
    private final String normalizePath(String p) {
        String string;
        String it = StringsKt.removeSuffix((String)StringsKt.removePrefix((String)StringsKt.replace$default((String)StringsKt.replace$default((String)p, (String)"\\", (String)"/", (boolean)false, (int)4, null), (String)"//", (String)"/", (boolean)false, (int)4, null), (CharSequence)"/"), (CharSequence)"\r");
        boolean bl = false;
        if (this.ignoreCase) {
            String string2 = it;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
            String string3 = string2.toLowerCase(locale);
            string = string3;
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
        } else {
            void var2_2;
            string = var2_2;
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void parseChangeFiles(IResFile diffFilePath) throws IOException {
        OpenOption[] openOptionArray = new OpenOption[]{};
        InputStream inputStream = Files.newInputStream(diffFilePath.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
        Reader reader = new InputStreamReader(inputStream, Charsets.UTF_8);
        int n = 8192;
        Closeable closeable = reader instanceof BufferedReader ? (BufferedReader)reader : new BufferedReader(reader, n);
        Throwable throwable = null;
        try {
            BufferedReader reader2 = (BufferedReader)closeable;
            boolean bl = false;
            Function1 function1 = arg_0 -> IncrementalAnalyzeImplByChangeFiles.parseChangeFiles$lambda$7$lambda$6(this, arg_0);
            reader2.lines().forEach((Consumer)new /* Unavailable Anonymous Inner Class!! */);
            reader = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void parseGitDiff(IResFile diffFilePath) throws IOException {
        Patch p = new Patch();
        OpenOption[] openOptionArray = new OpenOption[]{};
        InputStream inputStream = Files.newInputStream(diffFilePath.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
        Closeable closeable = inputStream;
        Throwable throwable = null;
        try {
            InputStream stream = (InputStream)closeable;
            boolean bl = false;
            p.parse(stream);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        if (p.getFiles().isEmpty()) {
            logger.error(() -> IncrementalAnalyzeImplByChangeFiles.parseGitDiff$lambda$9(diffFilePath));
            return;
        }
        for (FileHeader handler : p.getFiles()) {
            Pair pair;
            Map map;
            String it;
            if (handler.getOldPath() != null) {
                boolean bl = false;
                String oldPath = this.normalizePath(it);
                map = this.oldPath2Header;
                pair = TuplesKt.to((Object)oldPath, (Object)handler);
                map.put(pair.getFirst(), pair.getSecond());
                this.addOnePath(oldPath);
            }
            if (handler.getNewPath() == null) continue;
            boolean bl = false;
            String newPath = this.normalizePath(it);
            map = this.newPath2Header;
            pair = TuplesKt.to((Object)newPath, (Object)handler);
            map.put(pair.getFirst(), pair.getSecond());
            this.addOnePath(newPath);
        }
    }

    private static final Unit parseChangeFiles$lambda$7$lambda$6(IncrementalAnalyzeImplByChangeFiles this$0, String ln) {
        Intrinsics.checkNotNull((Object)ln);
        String file = this$0.normalizePath(StringsKt.removeSuffix((String)ln, (CharSequence)"\n"));
        if (((CharSequence)file).length() == 0) {
            return Unit.INSTANCE;
        }
        ((Collection)this$0.modifyFiles).add(file);
        this$0.addOnePath(file);
        Map map = this$0.oldPath2Header;
        Pair pair = TuplesKt.to((Object)file, (Object)new /* Unavailable Anonymous Inner Class!! */);
        map.put(pair.getFirst(), pair.getSecond());
        return Unit.INSTANCE;
    }

    private static final Object parseGitDiff$lambda$9(IResFile $diffFilePath) {
        return "The patch file " + $diffFilePath + " has no any change files";
    }

    private static final Unit logger$lambda$12() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Map access$getName2Path$p(IncrementalAnalyzeImplByChangeFiles $this) {
        return $this.name2Path;
    }
}

