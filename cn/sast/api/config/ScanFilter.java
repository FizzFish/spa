/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.MatchContentProvider
 *  cn.sast.api.config.MatchContentProviderImpl
 *  cn.sast.api.config.ProcessRegex
 *  cn.sast.api.config.ProjectConfig
 *  cn.sast.api.config.ScanFilter
 *  cn.sast.api.config.ScanFilter$ClassFilerRecord
 *  cn.sast.api.config.ScanFilter$Companion
 *  cn.sast.common.IResDirectory
 *  com.feysh.corax.config.api.rules.ProcessRule
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassMemberMatch$MatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassPathMatch$MatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$FileMatch$MatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$IMatchItem
 *  com.feysh.corax.config.api.rules.ProcessRule$IMatchTarget
 *  com.feysh.corax.config.api.rules.ProcessRule$ScanAction
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  kotlinx.serialization.json.JvmStreamsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootField
 *  soot.SootMethod
 */
package cn.sast.api.config;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.MatchContentProvider;
import cn.sast.api.config.MatchContentProviderImpl;
import cn.sast.api.config.ProcessRegex;
import cn.sast.api.config.ProjectConfig;
import cn.sast.api.config.ScanFilter;
import cn.sast.common.IResDirectory;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.io.Closeable;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JvmStreamsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00029:B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J6\u0010\u0018\u001a\u00020\u00192\u0010\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u00150\u001bj\u0002`\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014J$\u0010!\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014J$\u0010\u0018\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010$\u001a\u00020#2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014J$\u0010\u0018\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014J$\u0010\u0018\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010'\u001a\u00020(2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014J$\u0010\u0018\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014J\u0016\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0014J\u000e\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u000203J\u0011\u00104\u001a\u0002052\u0006\u0010$\u001a\u00020#H\u0096\u0001J\u0011\u00104\u001a\u0002062\u0006\u0010%\u001a\u00020&H\u0096\u0001J\u0011\u00104\u001a\u0002062\u0006\u0010)\u001a\u00020*H\u0096\u0001J\u0011\u00104\u001a\u0002062\u0006\u0010'\u001a\u00020(H\u0096\u0001J\u0011\u00107\u001a\u0002082\u0006\u0010\"\u001a\u00020#H\u0096\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0014*\u0004\u0018\u00010\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R \u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140-0,X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2={"Lcn/sast/api/config/ScanFilter;", "Lcn/sast/api/config/MatchContentProvider;", "mainConfig", "Lcn/sast/api/config/MainConfig;", "matchContentProvider", "<init>", "(Lcn/sast/api/config/MainConfig;Lcn/sast/api/config/MatchContentProvider;)V", "getMainConfig", "()Lcn/sast/api/config/MainConfig;", "processRegex", "Lcn/sast/api/config/ProcessRegex;", "getProcessRegex", "()Lcn/sast/api/config/ProcessRegex;", "setProcessRegex", "(Lcn/sast/api/config/ProcessRegex;)V", "update", "", "value", "Lcn/sast/api/config/ProjectConfig;", "show", "", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "getShow", "(Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;)Ljava/lang/String;", "getActionOf", "Lcom/feysh/corax/config/api/rules/ProcessRule$ScanAction;", "rule", "", "Lcom/feysh/corax/config/api/rules/ProcessRulesType;", "origAction", "matchTarget", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "prefix", "getActionOfClassPath", "classpath", "Ljava/nio/file/Path;", "file", "sc", "Lsoot/SootClass;", "sm", "Lsoot/SootMethod;", "sf", "Lsoot/SootField;", "filterDiagnostics", "Ljava/util/concurrent/ConcurrentHashMap;", "", "add", "key", "item", "dump", "dir", "Lcn/sast/common/IResDirectory;", "get", "Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch$MatchTarget;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch$MatchTarget;", "getClassPath", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch$MatchTarget;", "Companion", "ClassFilerRecord", "corax-api"})
@SourceDebugExtension(value={"SMAP\nScanFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScanFilter.kt\ncn/sast/api/config/ScanFilter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n*L\n1#1,106:1\n1#2:107\n1#2:110\n72#3,2:108\n*S KotlinDebug\n*F\n+ 1 ScanFilter.kt\ncn/sast/api/config/ScanFilter\n*L\n96#1:110\n96#1:108,2\n*E\n"})
public final class ScanFilter
implements MatchContentProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MainConfig mainConfig;
    @NotNull
    private final MatchContentProvider matchContentProvider;
    public ProcessRegex processRegex;
    @NotNull
    private final ConcurrentHashMap<String, Set<String>> filterDiagnostics;
    @NotNull
    private static final Json jsonFormat = JsonKt.Json$default(null, ScanFilter::jsonFormat$lambda$3, (int)1, null);

    public ScanFilter(@NotNull MainConfig mainConfig, @NotNull MatchContentProvider matchContentProvider) {
        Intrinsics.checkNotNullParameter((Object)mainConfig, (String)"mainConfig");
        Intrinsics.checkNotNullParameter((Object)matchContentProvider, (String)"matchContentProvider");
        this.mainConfig = mainConfig;
        this.matchContentProvider = matchContentProvider;
        this.filterDiagnostics = new ConcurrentHashMap();
    }

    public /* synthetic */ ScanFilter(MainConfig mainConfig, MatchContentProvider matchContentProvider, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            matchContentProvider = (MatchContentProvider)new MatchContentProviderImpl(mainConfig);
        }
        this(mainConfig, matchContentProvider);
    }

    @NotNull
    public final MainConfig getMainConfig() {
        return this.mainConfig;
    }

    @NotNull
    public final ProcessRegex getProcessRegex() {
        ProcessRegex processRegex = this.processRegex;
        if (processRegex != null) {
            return processRegex;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"processRegex");
        return null;
    }

    public final void setProcessRegex(@NotNull ProcessRegex processRegex) {
        Intrinsics.checkNotNullParameter((Object)processRegex, (String)"<set-?>");
        this.processRegex = processRegex;
    }

    public final void update(@NotNull ProjectConfig value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.setProcessRegex(value.getProcessRegex());
    }

    private final String getShow(ProcessRule.IMatchItem $this$show) {
        Object object = $this$show;
        if (object == null || (object = object.toString()) == null) {
            object = "{no matched rule}";
        }
        return object;
    }

    @NotNull
    public final ProcessRule.ScanAction getActionOf(@NotNull List<? extends ProcessRule.IMatchItem> rule, @Nullable String origAction, @NotNull ProcessRule.IMatchTarget matchTarget, @Nullable String prefix) {
        Pair pair;
        Intrinsics.checkNotNullParameter(rule, (String)"rule");
        Intrinsics.checkNotNullParameter((Object)matchTarget, (String)"matchTarget");
        Pair pair2 = pair = ProcessRule.INSTANCE.matches(rule, matchTarget);
        boolean bl = false;
        ProcessRule.IMatchItem rule2 = (ProcessRule.IMatchItem)pair2.component1();
        ProcessRule.ScanAction finalAction = (ProcessRule.ScanAction)pair2.component2();
        if (origAction != null) {
            String string;
            String string2 = origAction + " -> " + finalAction + ". rule= " + this.getShow(rule2);
            Object object = rule2;
            if (object == null || (object = object.getOp()) == null) {
                object = "Keep";
            }
            if ((string = prefix) == null) {
                string = "";
            }
            this.add(string2, object + ": " + string + " " + matchTarget);
        }
        return (ProcessRule.ScanAction)pair.getSecond();
    }

    public static /* synthetic */ ProcessRule.ScanAction getActionOf$default(ScanFilter scanFilter, List list, String string, ProcessRule.IMatchTarget iMatchTarget, String string2, int n, Object object) {
        if ((n & 8) != 0) {
            string2 = null;
        }
        return scanFilter.getActionOf(list, string, iMatchTarget, string2);
    }

    @NotNull
    public final ProcessRule.ScanAction getActionOfClassPath(@Nullable String origAction, @NotNull Path classpath, @Nullable String prefix) {
        Intrinsics.checkNotNullParameter((Object)classpath, (String)"classpath");
        return this.getActionOf(this.getProcessRegex().getClasspathRules(), origAction, (ProcessRule.IMatchTarget)this.getClassPath(classpath), prefix);
    }

    public static /* synthetic */ ProcessRule.ScanAction getActionOfClassPath$default(ScanFilter scanFilter, String string, Path path, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            string2 = null;
        }
        return scanFilter.getActionOfClassPath(string, path, string2);
    }

    @NotNull
    public final ProcessRule.ScanAction getActionOf(@Nullable String origAction, @NotNull Path file, @Nullable String prefix) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return this.getActionOf(this.getProcessRegex().getFileRules(), origAction, (ProcessRule.IMatchTarget)this.get(file), prefix);
    }

    public static /* synthetic */ ProcessRule.ScanAction getActionOf$default(ScanFilter scanFilter, String string, Path path, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            string2 = null;
        }
        return scanFilter.getActionOf(string, path, string2);
    }

    @NotNull
    public final ProcessRule.ScanAction getActionOf(@Nullable String origAction, @NotNull SootClass sc, @Nullable String prefix) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        return this.getActionOf(this.getProcessRegex().getClazzRules(), origAction, (ProcessRule.IMatchTarget)this.get(sc), prefix);
    }

    public static /* synthetic */ ProcessRule.ScanAction getActionOf$default(ScanFilter scanFilter, String string, SootClass sootClass, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            string2 = null;
        }
        return scanFilter.getActionOf(string, sootClass, string2);
    }

    @NotNull
    public final ProcessRule.ScanAction getActionOf(@Nullable String origAction, @NotNull SootMethod sm, @Nullable String prefix) {
        Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
        return this.getActionOf(this.getProcessRegex().getClazzRules(), origAction, (ProcessRule.IMatchTarget)this.get(sm), prefix);
    }

    public static /* synthetic */ ProcessRule.ScanAction getActionOf$default(ScanFilter scanFilter, String string, SootMethod sootMethod, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            string2 = null;
        }
        return scanFilter.getActionOf(string, sootMethod, string2);
    }

    @NotNull
    public final ProcessRule.ScanAction getActionOf(@Nullable String origAction, @NotNull SootField sf, @Nullable String prefix) {
        Intrinsics.checkNotNullParameter((Object)sf, (String)"sf");
        return this.getActionOf(this.getProcessRegex().getClazzRules(), origAction, (ProcessRule.IMatchTarget)this.get(sf), prefix);
    }

    public static /* synthetic */ ProcessRule.ScanAction getActionOf$default(ScanFilter scanFilter, String string, SootField sootField, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            string2 = null;
        }
        return scanFilter.getActionOf(string, sootField, string2);
    }

    public final void add(@NotNull String key2, @NotNull String item) {
        Intrinsics.checkNotNullParameter((Object)key2, (String)"key");
        Intrinsics.checkNotNullParameter((Object)item, (String)"item");
        ConcurrentMap $this$getOrPut$iv = this.filterDiagnostics;
        boolean $i$f$getOrPut = false;
        Object object = $this$getOrPut$iv.get(key2);
        if (object == null) {
            boolean bl = false;
            Set default$iv = Collections.synchronizedSet(new TreeSet());
            boolean bl2 = false;
            object = $this$getOrPut$iv.putIfAbsent(key2, default$iv);
            if (object == null) {
                object = default$iv;
            }
        }
        ((Set)object).add(item);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void dump(@NotNull IResDirectory dir) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        dir.mkdirs();
        OpenOption[] openOptionArray = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream(dir.resolve("scan-classifier-info.json").getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        Closeable closeable = outputStream;
        Throwable throwable = null;
        try {
            OutputStream it = (OutputStream)closeable;
            boolean bl = false;
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)ClassFilerRecord.Companion.serializer()), (Object)new ClassFilerRecord((Map)new TreeMap(this.filterDiagnostics)), (OutputStream)it);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }

    @NotNull
    public ProcessRule.FileMatch.MatchTarget get(@NotNull Path file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return this.matchContentProvider.get(file);
    }

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootField sf) {
        Intrinsics.checkNotNullParameter((Object)sf, (String)"sf");
        return this.matchContentProvider.get(sf);
    }

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootMethod sm) {
        Intrinsics.checkNotNullParameter((Object)sm, (String)"sm");
        return this.matchContentProvider.get(sm);
    }

    @NotNull
    public ProcessRule.ClassMemberMatch.MatchTarget get(@NotNull SootClass sc) {
        Intrinsics.checkNotNullParameter((Object)sc, (String)"sc");
        return this.matchContentProvider.get(sc);
    }

    @NotNull
    public ProcessRule.ClassPathMatch.MatchTarget getClassPath(@NotNull Path classpath) {
        Intrinsics.checkNotNullParameter((Object)classpath, (String)"classpath");
        return this.matchContentProvider.getClassPath(classpath);
    }

    private static final Unit jsonFormat$lambda$3(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setUseArrayPolymorphism(true);
        $this$Json.setPrettyPrint(true);
        return Unit.INSTANCE;
    }
}

