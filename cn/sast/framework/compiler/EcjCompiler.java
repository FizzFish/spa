/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResource
 *  cn.sast.framework.compiler.EcjCompiler
 *  cn.sast.framework.compiler.EcjCompiler$Companion
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  kotlinx.collections.immutable.PersistentSet
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.eclipse.jdt.core.compiler.CompilationProgress
 *  org.eclipse.jdt.internal.compiler.batch.FileSystem$Classpath
 *  org.eclipse.jdt.internal.compiler.batch.Main
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.LoggingKt
 *  org.utbot.common.Maybe
 */
package cn.sast.framework.compiler;

import cn.sast.common.IResource;
import cn.sast.framework.compiler.EcjCompiler;
import java.io.Closeable;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.PersistentSet;
import mu.KLogger;
import mu.KotlinLogging;
import org.eclipse.jdt.core.compiler.CompilationProgress;
import org.eclipse.jdt.internal.compiler.batch.FileSystem;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.LoggingKt;
import org.utbot.common.Maybe;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 62\u00020\u0001:\u00016B\u0083\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&H\u0002Jt\u0010(\u001a\u00020)2\u001e\u0010*\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$j\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u0001`&2\u0006\u0010+\u001a\u00020\u00062\u001e\u0010,\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010$j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`&2\b\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010.\u001a\u0004\u0018\u00010\u00062\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bH\u0014J$\u00101\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&2\u0006\u00102\u001a\u00020\u0006H\u0002J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u00104\u001a\u00020\u0006H\u0002J\u0006\u00105\u001a\u00020\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060 X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2={"Lcn/sast/framework/compiler/EcjCompiler;", "Lorg/eclipse/jdt/internal/compiler/batch/Main;", "sourcePath", "Lkotlinx/collections/immutable/PersistentSet;", "Lcn/sast/common/IResource;", "classpath", "", "class_opt", "customOptions", "", "useDefaultJava", "", "outWriter", "Ljava/io/PrintWriter;", "errWriter", "systemExitWhenFinished", "customDefaultOptions", "", "compilationProgress", "Lorg/eclipse/jdt/core/compiler/CompilationProgress;", "<init>", "(Lkotlinx/collections/immutable/PersistentSet;Lkotlinx/collections/immutable/PersistentSet;Lcn/sast/common/IResource;Ljava/util/List;ZLjava/io/PrintWriter;Ljava/io/PrintWriter;ZLjava/util/Map;Lorg/eclipse/jdt/core/compiler/CompilationProgress;)V", "getSourcePath", "()Lkotlinx/collections/immutable/PersistentSet;", "getClasspath", "getClass_opt", "()Lcn/sast/common/IResource;", "getCustomOptions", "()Ljava/util/List;", "getUseDefaultJava", "()Z", "collectClassPath", "", "getCollectClassPath", "()Ljava/util/Set;", "getDefaultClasspath", "Ljava/util/ArrayList;", "Lorg/eclipse/jdt/internal/compiler/batch/FileSystem$Classpath;", "Lkotlin/collections/ArrayList;", "currentClasspathNameHack", "addNewEntry", "", "paths", "currentClasspathName", "currentRuleSpecs", "customEncoding", "destPath", "isSourceOnly", "rejectDestinationPathOnJars", "getPathsFrom", "path", "replace", "ecjClasspathName", "compile", "Companion", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nEcjCompiler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EcjCompiler.kt\ncn/sast/framework/compiler/EcjCompiler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Logging.kt\norg/utbot/common/LoggingKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,150:1\n1279#2,2:151\n1293#2,4:153\n1557#2:157\n1628#2,3:158\n1863#2,2:161\n1863#2,2:163\n1#3:165\n49#4,13:166\n62#4,11:181\n37#5,2:179\n*S KotlinDebug\n*F\n+ 1 EcjCompiler.kt\ncn/sast/framework/compiler/EcjCompiler\n*L\n113#1:151,2\n113#1:153,4\n118#1:157\n118#1:158,3\n121#1:161,2\n130#1:163,2\n143#1:166,13\n143#1:181,11\n144#1:179,2\n*E\n"})
public final class EcjCompiler
extends Main {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final PersistentSet<IResource> sourcePath;
    @NotNull
    private final PersistentSet<String> classpath;
    @NotNull
    private final IResource class_opt;
    @NotNull
    private final List<String> customOptions;
    private final boolean useDefaultJava;
    @NotNull
    private final Set<String> collectClassPath;
    @NotNull
    private final Set<String> currentClasspathNameHack;
    @NotNull
    private static final KLogger kLogger = KotlinLogging.INSTANCE.logger(EcjCompiler::kLogger$lambda$9);

    public EcjCompiler(@NotNull PersistentSet<? extends IResource> sourcePath, @NotNull PersistentSet<String> classpath, @NotNull IResource class_opt, @NotNull List<String> customOptions, boolean useDefaultJava, @NotNull PrintWriter outWriter, @NotNull PrintWriter errWriter, boolean systemExitWhenFinished, @Nullable Map<String, String> customDefaultOptions, @Nullable CompilationProgress compilationProgress) {
        Intrinsics.checkNotNullParameter(sourcePath, (String)"sourcePath");
        Intrinsics.checkNotNullParameter(classpath, (String)"classpath");
        Intrinsics.checkNotNullParameter((Object)class_opt, (String)"class_opt");
        Intrinsics.checkNotNullParameter(customOptions, (String)"customOptions");
        Intrinsics.checkNotNullParameter((Object)outWriter, (String)"outWriter");
        Intrinsics.checkNotNullParameter((Object)errWriter, (String)"errWriter");
        super(outWriter, errWriter, systemExitWhenFinished, customDefaultOptions, compilationProgress);
        this.sourcePath = sourcePath;
        this.classpath = classpath;
        this.class_opt = class_opt;
        this.customOptions = customOptions;
        this.useDefaultJava = useDefaultJava;
        this.collectClassPath = new LinkedHashSet();
        this.currentClasspathNameHack = new LinkedHashSet();
    }

    public /* synthetic */ EcjCompiler(PersistentSet persistentSet, PersistentSet persistentSet2, IResource iResource, List list, boolean bl, PrintWriter printWriter, PrintWriter printWriter2, boolean bl2, Map map, CompilationProgress compilationProgress, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x20) != 0) {
            printWriter = new PrintWriter(System.out);
        }
        if ((n & 0x40) != 0) {
            printWriter2 = new PrintWriter(System.err);
        }
        if ((n & 0x80) != 0) {
            bl2 = false;
        }
        if ((n & 0x100) != 0) {
            map = null;
        }
        if ((n & 0x200) != 0) {
            compilationProgress = null;
        }
        this(persistentSet, persistentSet2, iResource, list, bl, printWriter, printWriter2, bl2, map, compilationProgress);
    }

    @NotNull
    public final PersistentSet<IResource> getSourcePath() {
        return this.sourcePath;
    }

    @NotNull
    public final PersistentSet<String> getClasspath() {
        return this.classpath;
    }

    @NotNull
    public final IResource getClass_opt() {
        return this.class_opt;
    }

    @NotNull
    public final List<String> getCustomOptions() {
        return this.customOptions;
    }

    public final boolean getUseDefaultJava() {
        return this.useDefaultJava;
    }

    @NotNull
    public final Set<String> getCollectClassPath() {
        return this.collectClassPath;
    }

    private final ArrayList<FileSystem.Classpath> getDefaultClasspath() {
        ArrayList arrayList = super.handleClasspath(null, null);
        Intrinsics.checkNotNullExpressionValue((Object)arrayList, (String)"handleClasspath(...)");
        return arrayList;
    }

    protected void addNewEntry(@Nullable ArrayList<FileSystem.Classpath> paths, @NotNull String currentClasspathName, @Nullable ArrayList<String> currentRuleSpecs, @Nullable String customEncoding, @Nullable String destPath, boolean isSourceOnly, boolean rejectDestinationPathOnJars) {
        Intrinsics.checkNotNullParameter((Object)currentClasspathName, (String)"currentClasspathName");
        this.currentClasspathNameHack.add(currentClasspathName);
        super.addNewEntry(paths, currentClasspathName, currentRuleSpecs, customEncoding, destPath, isSourceOnly, rejectDestinationPathOnJars);
    }

    private final ArrayList<FileSystem.Classpath> getPathsFrom(String path) {
        this.currentClasspathNameHack.clear();
        ArrayList<FileSystem.Classpath> paths = new ArrayList<FileSystem.Classpath>();
        try {
            this.processPathEntries(4, paths, path, null, false, false);
        }
        catch (IllegalArgumentException var6) {
            return null;
        }
        return paths;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final List<String> replace(String ecjClasspathName) {
        File cpf;
        ArrayList path = this.getPathsFrom(ecjClasspathName);
        if (this.currentClasspathNameHack.size() != 1 || path == null || path.size() != 1) {
            this.collectClassPath.add(ecjClasspathName);
            return CollectionsKt.listOf((Object)ecjClasspathName);
        }
        String origClassPathFileName = (String)CollectionsKt.first((Iterable)this.currentClasspathNameHack);
        List res = new ArrayList();
        if (((CharSequence)origClassPathFileName).length() > 0 && !(cpf = new File(origClassPathFileName)).exists()) {
            Path path2 = cpf.getParentFile().toPath();
            Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"toPath(...)");
            Path path3 = path2;
            String string = cpf.getName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
            Closeable closeable = Files.newDirectoryStream(path3, string);
            Throwable throwable = null;
            try {
                DirectoryStream directoryStream = (DirectoryStream)closeable;
                Intrinsics.checkNotNull((Object)directoryStream);
                Iterable iterable = directoryStream;
                for (Path subClasspathName : iterable) {
                    boolean bl = false;
                    res.add(StringsKt.replace((String)ecjClasspathName, (String)origClassPathFileName, (String)((Object)subClasspathName).toString(), (boolean)false));
                    this.collectClassPath.add(((Object)subClasspathName).toString());
                }
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
            return res;
        }
        this.collectClassPath.add(ecjClasspathName);
        return CollectionsKt.listOf((Object)ecjClasspathName);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final boolean compile() {
        Object object;
        void $this$bracket_u24default$iv;
        Object object2;
        Set classpath;
        List args = new ArrayList();
        if (this.customOptions.isEmpty()) {
            Object replacedClassPathNames;
            classpath = CollectionsKt.toMutableSet((Iterable)((Iterable)this.classpath));
            Object[] objectArray = new String[]{"-source", "11", "-target", "11", "-proceedOnError", "-warn:none", "-g:lines,vars,source", "-preserveAllLocals"};
            args.addAll(CollectionsKt.listOf((Object[])objectArray));
            if (!((Collection)classpath).isEmpty()) {
                Object object3;
                Iterable $this$associateWith$iv = classpath;
                boolean $i$f$associateWith = false;
                Object result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
                Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
                boolean $i$f$associateWithTo2 = false;
                for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
                    Iterator it;
                    String string = (String)element$iv$iv;
                    object3 = element$iv$iv;
                    object2 = (Map)result$iv;
                    boolean bl = false;
                    List list = this.replace((String)((Object)it));
                    object2.put(object3, list);
                }
                replacedClassPathNames = (Map)result$iv;
                List classPathRule = CollectionsKt.toMutableList((Collection)CollectionsKt.flatten((Iterable)replacedClassPathNames.values()));
                if (this.useDefaultJava) {
                    void $this$mapTo$iv$iv;
                    void $this$map$iv;
                    ArrayList cps = this.getDefaultClasspath();
                    result$iv = cps;
                    object2 = classPathRule;
                    boolean $i$f$map = false;
                    void $i$f$associateWithTo2 = $this$map$iv;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it;
                        FileSystem.Classpath classpath2 = (FileSystem.Classpath)item$iv$iv;
                        object3 = destination$iv$iv;
                        boolean bl = false;
                        object3.add((String)it.getPath());
                    }
                    object2.addAll((List)destination$iv$iv);
                }
                Iterable $this$forEach$iv = classPathRule;
                boolean $i$f$forEach = false;
                Iterator $i$f$map = $this$forEach$iv.iterator();
                while ($i$f$map.hasNext()) {
                    Object element$iv = $i$f$map.next();
                    String it = (String)element$iv;
                    boolean bl = false;
                    args.add("-classpath");
                    args.add(it);
                }
            }
            replacedClassPathNames = new String[]{"-d", this.class_opt.toString()};
            args.addAll(CollectionsKt.listOf((Object[])replacedClassPathNames));
            if (!((Collection)this.sourcePath).isEmpty()) {
                Iterable $this$forEach$iv = (Iterable)this.sourcePath;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    IResource it = (IResource)element$iv;
                    boolean bl = false;
                    String string = it.getFile().getPath();
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
                    args.add(string);
                }
            }
            kLogger.info(() -> EcjCompiler.compile$lambda$5(args));
        } else {
            if (!this.sourcePath.isEmpty()) {
                boolean $i$a$-check-EcjCompiler$compile$72 = false;
                String $i$a$-check-EcjCompiler$compile$72 = "sourcePath: " + this.sourcePath + " must be empty while use customOptions: " + this.customOptions;
                throw new IllegalStateException($i$a$-check-EcjCompiler$compile$72.toString());
            }
            if (!this.classpath.isEmpty()) {
                boolean $i$a$-check-EcjCompiler$compile$82 = false;
                String $i$a$-check-EcjCompiler$compile$82 = "classpath: " + this.classpath + " must be empty while use customOptions: " + this.customOptions;
                throw new IllegalStateException($i$a$-check-EcjCompiler$compile$82.toString());
            }
            args.addAll(this.customOptions);
        }
        classpath = LoggingKt.info((KLogger)kLogger);
        String msg$iv = "compile java source";
        boolean $i$f$bracket = false;
        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        LocalDateTime startTime$iv = LocalDateTime.now();
        boolean alreadyLogged$iv = false;
        Ref.ObjectRef res$iv = new Ref.ObjectRef();
        res$iv.element = Maybe.Companion.empty();
        try {
            object2 = res$iv;
            boolean bl = false;
            Collection $this$toTypedArray$iv = args;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            String[] commandLineArguments = thisCollection$iv.toArray(new String[0]);
            Boolean bl2 = this.compile(commandLineArguments);
            ((Ref.ObjectRef)object2).element = new Maybe((Object)bl2);
            object = ((Maybe)res$iv.element).getOrThrow();
        }
        catch (Throwable t$iv) {
            try {
                $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                alreadyLogged$iv = true;
                throw t$iv;
            }
            catch (Throwable throwable) {
                if (!alreadyLogged$iv) {
                    if (((Maybe)res$iv.element).getHasValue()) {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    } else {
                        $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
                    }
                }
                throw throwable;
            }
        }
        if (((Maybe)res$iv.element).getHasValue()) {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            $this$bracket_u24default$iv.getLogMethod().invoke((Object)new /* Unavailable Anonymous Inner Class!! */);
        }
        return (Boolean)object;
    }

    private static final Object compile$lambda$5(List $args) {
        return "ecj cmd args:\n[ " + CollectionsKt.joinToString$default((Iterable)$args, (CharSequence)"\n", null, null, (int)0, null, null, (int)62, null) + " ]\n";
    }

    private static final Unit kLogger$lambda$9() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ KLogger access$getKLogger$cp() {
        return kLogger;
    }
}

