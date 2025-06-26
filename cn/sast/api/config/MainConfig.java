/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.CheckerInfoGenResult
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.MainConfig$Companion
 *  cn.sast.api.config.MainConfig$RelativePath
 *  cn.sast.api.config.MainConfigKt
 *  cn.sast.api.config.ProjectConfig
 *  cn.sast.api.config.SaConfig
 *  cn.sast.api.config.ScanFilter
 *  cn.sast.api.config.SrcPrecedence
 *  cn.sast.api.config.StaticFieldTrackingMode
 *  cn.sast.api.incremental.IncrementalAnalyze
 *  cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles
 *  cn.sast.api.util.IMonitor
 *  cn.sast.common.FileSystemLocator$TraverseMode
 *  cn.sast.common.IResDirectory
 *  cn.sast.common.IResFile
 *  cn.sast.common.IResource
 *  cn.sast.common.OS
 *  cn.sast.common.Resource
 *  cn.sast.common.ResourceImplKt
 *  com.feysh.corax.config.api.CheckType
 *  com.feysh.corax.config.api.Language
 *  com.feysh.corax.config.api.rules.ProcessRule$ScanAction
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlinx.collections.immutable.ExtensionsKt
 *  kotlinx.collections.immutable.PersistentSet
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.Scene
 */
package cn.sast.api.config;

import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.api.config.MainConfig;
import cn.sast.api.config.MainConfigKt;
import cn.sast.api.config.ProjectConfig;
import cn.sast.api.config.SaConfig;
import cn.sast.api.config.ScanFilter;
import cn.sast.api.config.SrcPrecedence;
import cn.sast.api.config.StaticFieldTrackingMode;
import cn.sast.api.incremental.IncrementalAnalyze;
import cn.sast.api.incremental.IncrementalAnalyzeByChangeFiles;
import cn.sast.api.util.IMonitor;
import cn.sast.common.FileSystemLocator;
import cn.sast.common.IResDirectory;
import cn.sast.common.IResFile;
import cn.sast.common.IResource;
import cn.sast.common.OS;
import cn.sast.common.Resource;
import cn.sast.common.ResourceImplKt;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentSet;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.Scene;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\bl\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0089\u00022\u00020\u0001:\u0004\u0089\u0002\u008a\u0002B\u00d7\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0014\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010$\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0&\u0012\b\b\u0002\u0010'\u001a\u00020(\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010-\u001a\u00020\u000b\u0012\b\b\u0002\u0010.\u001a\u00020\u000b\u0012\b\b\u0002\u0010/\u001a\u00020\u000b\u0012\b\b\u0002\u00100\u001a\u00020\u000b\u0012\b\b\u0002\u00101\u001a\u00020\u000b\u0012\b\b\u0002\u00102\u001a\u00020\u000b\u0012\b\b\u0002\u00103\u001a\u00020\u000b\u0012\b\b\u0002\u00104\u001a\u00020\u000b\u0012\b\b\u0002\u00105\u001a\u000206\u0012\b\b\u0002\u00107\u001a\u00020\r\u0012\b\b\u0002\u00108\u001a\u00020\r\u0012\b\b\u0002\u00109\u001a\u00020:\u00a2\u0006\u0004\b;\u0010<J\u001d\u0010\u00c9\u0001\u001a\b\u0012\u0004\u0012\u00020\r0&2\u000e\u0010\u00ca\u0001\u001a\t\u0012\u0004\u0012\u00020\r0\u00cb\u0001J\r\u0010\u00d8\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150&J\r\u0010\u00d9\u0001\u001a\b\u0012\u0004\u0012\u00020\r0&J\u0012\u0010\u00da\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010\u00db\u0001\u001a\u00020\rJ\u0011\u0010\u00dc\u0001\u001a\u00020\u000b2\b\u0010\u00dd\u0001\u001a\u00030\u00de\u0001J\u0010\u0010\u00dc\u0001\u001a\u00020\u000b2\u0007\u0010\u00dd\u0001\u001a\u00020\rJ\b\u0010\u00f6\u0001\u001a\u00030\u00f7\u0001J\u0011\u0010\u00f8\u0001\u001a\u00020\u000b2\b\u0010\u00f9\u0001\u001a\u00030\u00fa\u0001J%\u0010\u00fb\u0001\u001a\u00020\u000b2\u0016\u0010\u00f9\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u00fa\u00010\u00fc\u0001\"\u00030\u00fa\u0001\u00a2\u0006\u0003\u0010\u00fd\u0001J\u001b\u0010\u00fe\u0001\u001a\u00020\r2\u0007\u0010\u00ff\u0001\u001a\u00020\r2\u0007\u0010\u00dd\u0001\u001a\u00020\rH\u0002J\u0011\u0010\u0080\u0002\u001a\u00030\u0081\u00022\u0007\u0010\u0082\u0002\u001a\u00020\rJ\u0011\u0010\u0080\u0002\u001a\u00030\u0081\u00022\u0007\u0010\u0082\u0002\u001a\u00020\u0015J\u0011\u0010\u0083\u0002\u001a\u00030\u0081\u00022\u0007\u0010\u0084\u0002\u001a\u00020\u0015J\u0012\u0010\u0083\u0002\u001a\u00030\u0081\u00022\b\u0010\u0084\u0002\u001a\u00030\u00de\u0001J+\u0010\u0085\u0002\u001a\n\u0012\u0005\u0012\u0003H\u0086\u00020\u00cb\u0001\"\t\b\u0000\u0010\u0086\u0002*\u00020\u00012\u000f\u0010\u0087\u0002\u001a\n\u0012\u0005\u0012\u0003H\u0086\u00020\u00cb\u0001J+\u0010\u0088\u0002\u001a\n\u0012\u0005\u0012\u0003H\u0086\u00020\u00cb\u0001\"\t\b\u0000\u0010\u0086\u0002*\u00020\u00012\u000f\u0010\u0087\u0002\u001a\n\u0012\u0005\u0012\u0003H\u0086\u00020\u00cb\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010L\"\u0004\bP\u0010NR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010L\"\u0004\bR\u0010NR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010\u0012\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010L\"\u0004\bX\u0010NR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010Z\"\u0004\b^\u0010\\R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010Z\"\u0004\b`\u0010\\R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010Z\"\u0004\bb\u0010\\R\u001a\u0010\u001a\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010T\"\u0004\bd\u0010VR\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010L\"\u0004\bf\u0010NR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010L\"\u0004\bh\u0010NR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010L\"\u0004\bn\u0010NR\u001a\u0010 \u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010L\"\u0004\bp\u0010NR\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010#\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010r\"\u0004\bv\u0010tR\u001a\u0010$\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010L\"\u0004\bx\u0010NR \u0010%\u001a\b\u0012\u0004\u0012\u00020\r0&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u001b\u0010'\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R$\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0*X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010+\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R \u0010,\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u0086\u0001\"\u0006\b\u008a\u0001\u0010\u0088\u0001R\u001c\u0010-\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010L\"\u0005\b\u008c\u0001\u0010NR\u001c\u0010.\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010L\"\u0005\b\u008e\u0001\u0010NR\u001c\u0010/\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010L\"\u0005\b\u0090\u0001\u0010NR\u001c\u00100\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010L\"\u0005\b\u0092\u0001\u0010NR\u001c\u00101\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010L\"\u0005\b\u0094\u0001\u0010NR\u001c\u00102\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010L\"\u0005\b\u0096\u0001\u0010NR\u001c\u00103\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010L\"\u0005\b\u0098\u0001\u0010NR\u001c\u00104\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010L\"\u0005\b\u009a\u0001\u0010NR\u001e\u00105\u001a\u000206X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001e\u00109\u001a\u00020:X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001\"\u0006\b\u00a1\u0001\u0010\u00a2\u0001R!\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a4\u0001\u0010\u0086\u0001\"\u0006\b\u00a5\u0001\u0010\u0088\u0001R+\u0010\u00a6\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010\u00a8\u0001\u0018\u00010\u00a7\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001\"\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001b\u0010\u00ad\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150\u00ae\u0001\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00af\u0001\u0010\u0082\u0001R\u0015\u0010\u00b0\u0001\u001a\u0004\u0018\u00010\t8F\u00a2\u0006\u0007\u001a\u0005\b\u00b1\u0001\u0010HR\u0017\u0010\u00b2\u0001\u001a\u0005\u0018\u00010\u00b3\u00018F\u00a2\u0006\b\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001R\u0017\u0010\u00b6\u0001\u001a\u0005\u0018\u00010\u00b3\u00018F\u00a2\u0006\b\u001a\u0006\b\u00b7\u0001\u0010\u00b5\u0001R\u001d\u0010\u00b8\u0001\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b9\u0001\u0010L\"\u0005\b\u00ba\u0001\u0010NR3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\r\u0010\u00bb\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@FX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bc\u0001\u0010Z\"\u0005\b\u00bd\u0001\u0010\\R/\u0010\u00bf\u0001\u001a\t\u0012\u0005\u0012\u00030\u00be\u00010\u00142\u000e\u0010\u00bb\u0001\u001a\t\u0012\u0005\u0012\u00030\u00be\u00010\u0014@BX\u0086\u000e\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00c0\u0001\u0010ZR6\u0010\u00c1\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150*2\r\u0010\u00bb\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150*@FX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00c2\u0001\u0010\u0082\u0001\"\u0006\b\u00c3\u0001\u0010\u0084\u0001R%\u0010\u00c4\u0001\u001a\b\u0012\u0004\u0012\u00020\r0*X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00c5\u0001\u0010\u0082\u0001\"\u0006\b\u00c6\u0001\u0010\u0084\u0001R\u0015\u0010\u00c7\u0001\u001a\u00030\u00b3\u00018F\u00a2\u0006\b\u001a\u0006\b\u00c8\u0001\u0010\u00b5\u0001R)\u00107\u001a\u00020\r2\u0007\u0010\u00bb\u0001\u001a\u00020\r@FX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00cc\u0001\u0010\u0086\u0001\"\u0006\b\u00cd\u0001\u0010\u0088\u0001R)\u00108\u001a\u00020\r2\u0007\u0010\u00bb\u0001\u001a\u00020\r@FX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00ce\u0001\u0010\u0086\u0001\"\u0006\b\u00cf\u0001\u0010\u0088\u0001R$\u0010\u00d0\u0001\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0015\n\u0003\u0010\u00d4\u0001\u001a\u0006\b\u00d0\u0001\u0010\u00d1\u0001\"\u0006\b\u00d2\u0001\u0010\u00d3\u0001R*\u0010\u00d5\u0001\u001a\u00020\"2\u0007\u0010\u00bb\u0001\u001a\u00020\"8F@FX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d6\u0001\u0010r\"\u0005\b\u00d7\u0001\u0010tR\u0019\u0010\u00df\u0001\u001a\b\u0012\u0004\u0012\u00020\r0&8F\u00a2\u0006\u0007\u001a\u0005\b\u00e0\u0001\u0010zR\u0014\u0010\u00e1\u0001\u001a\u00020\u00158F\u00a2\u0006\b\u001a\u0006\b\u00e2\u0001\u0010\u00e3\u0001R\"\u0010\u00e4\u0001\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00e6\u0001\u0010\u00e7\u0001\u001a\u0006\b\u00e5\u0001\u0010\u00d1\u0001R/\u0010\f\u001a\u0004\u0018\u00010\r2\t\u0010\u00bb\u0001\u001a\u0004\u0018\u00010\r8F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00e8\u0001\u0010\u0086\u0001\"\u0006\b\u00e9\u0001\u0010\u0088\u0001R \u0010\u00ea\u0001\u001a\u00030\u00eb\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00ec\u0001\u0010\u00ed\u0001\"\u0006\b\u00ee\u0001\u0010\u00ef\u0001R,\u0010\u00f1\u0001\u001a\u00030\u00f0\u00012\b\u0010\u00bb\u0001\u001a\u00030\u00f0\u0001@FX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00f2\u0001\u0010\u00f3\u0001\"\u0006\b\u00f4\u0001\u0010\u00f5\u0001\u00a8\u0006\u008b\u0002"}, d2={"Lcn/sast/api/config/MainConfig;", "", "sourceEncoding", "Ljava/nio/charset/Charset;", "monitor", "Lcn/sast/api/util/IMonitor;", "saConfig", "Lcn/sast/api/config/SaConfig;", "output_dir", "Lcn/sast/common/IResDirectory;", "dumpSootScene", "", "androidPlatformDir", "", "use_wrapper", "hideNoSource", "traverseMode", "Lcn/sast/common/FileSystemLocator$TraverseMode;", "useDefaultJavaClassPath", "processDir", "Lkotlinx/collections/immutable/PersistentSet;", "Lcn/sast/common/IResource;", "classpath", "sourcePath", "projectRoot", "autoAppClasses", "autoAppTraverseMode", "autoAppSrcInZipScheme", "skipClass", "incrementAnalyze", "Lcn/sast/api/incremental/IncrementalAnalyze;", "enableLineNumbers", "enableOriginalNames", "output_format", "", "throw_analysis", "process_multiple_dex", "appClasses", "", "src_precedence", "Lcn/sast/api/config/SrcPrecedence;", "ecj_options", "", "sunBootClassPath", "javaExtDirs", "hashAbspathInPlist", "deCompileIfNotExists", "enableCodeMetrics", "prepend_classpath", "whole_program", "no_bodies_for_excluded", "allow_phantom_refs", "enableReflection", "staticFieldTrackingMode", "Lcn/sast/api/config/StaticFieldTrackingMode;", "callGraphAlgorithm", "callGraphAlgorithmBuiltIn", "memoryThreshold", "", "<init>", "(Ljava/nio/charset/Charset;Lcn/sast/api/util/IMonitor;Lcn/sast/api/config/SaConfig;Lcn/sast/common/IResDirectory;ZLjava/lang/String;ZZLcn/sast/common/FileSystemLocator$TraverseMode;ZLkotlinx/collections/immutable/PersistentSet;Lkotlinx/collections/immutable/PersistentSet;Lkotlinx/collections/immutable/PersistentSet;Lkotlinx/collections/immutable/PersistentSet;Lkotlinx/collections/immutable/PersistentSet;Lcn/sast/common/FileSystemLocator$TraverseMode;ZZLcn/sast/api/incremental/IncrementalAnalyze;ZZIIZLjava/util/Set;Lcn/sast/api/config/SrcPrecedence;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZZZZZZZZLcn/sast/api/config/StaticFieldTrackingMode;Ljava/lang/String;Ljava/lang/String;D)V", "getSourceEncoding", "()Ljava/nio/charset/Charset;", "getMonitor", "()Lcn/sast/api/util/IMonitor;", "setMonitor", "(Lcn/sast/api/util/IMonitor;)V", "getSaConfig", "()Lcn/sast/api/config/SaConfig;", "setSaConfig", "(Lcn/sast/api/config/SaConfig;)V", "getOutput_dir", "()Lcn/sast/common/IResDirectory;", "setOutput_dir", "(Lcn/sast/common/IResDirectory;)V", "getDumpSootScene", "()Z", "setDumpSootScene", "(Z)V", "getUse_wrapper", "setUse_wrapper", "getHideNoSource", "setHideNoSource", "getTraverseMode", "()Lcn/sast/common/FileSystemLocator$TraverseMode;", "setTraverseMode", "(Lcn/sast/common/FileSystemLocator$TraverseMode;)V", "getUseDefaultJavaClassPath", "setUseDefaultJavaClassPath", "getProcessDir", "()Lkotlinx/collections/immutable/PersistentSet;", "setProcessDir", "(Lkotlinx/collections/immutable/PersistentSet;)V", "getClasspath", "setClasspath", "getProjectRoot", "setProjectRoot", "getAutoAppClasses", "setAutoAppClasses", "getAutoAppTraverseMode", "setAutoAppTraverseMode", "getAutoAppSrcInZipScheme", "setAutoAppSrcInZipScheme", "getSkipClass", "setSkipClass", "getIncrementAnalyze", "()Lcn/sast/api/incremental/IncrementalAnalyze;", "setIncrementAnalyze", "(Lcn/sast/api/incremental/IncrementalAnalyze;)V", "getEnableLineNumbers", "setEnableLineNumbers", "getEnableOriginalNames", "setEnableOriginalNames", "getOutput_format", "()I", "setOutput_format", "(I)V", "getThrow_analysis", "setThrow_analysis", "getProcess_multiple_dex", "setProcess_multiple_dex", "getAppClasses", "()Ljava/util/Set;", "setAppClasses", "(Ljava/util/Set;)V", "getSrc_precedence", "()Lcn/sast/api/config/SrcPrecedence;", "setSrc_precedence", "(Lcn/sast/api/config/SrcPrecedence;)V", "getEcj_options", "()Ljava/util/List;", "setEcj_options", "(Ljava/util/List;)V", "getSunBootClassPath", "()Ljava/lang/String;", "setSunBootClassPath", "(Ljava/lang/String;)V", "getJavaExtDirs", "setJavaExtDirs", "getHashAbspathInPlist", "setHashAbspathInPlist", "getDeCompileIfNotExists", "setDeCompileIfNotExists", "getEnableCodeMetrics", "setEnableCodeMetrics", "getPrepend_classpath", "setPrepend_classpath", "getWhole_program", "setWhole_program", "getNo_bodies_for_excluded", "setNo_bodies_for_excluded", "getAllow_phantom_refs", "setAllow_phantom_refs", "getEnableReflection", "setEnableReflection", "getStaticFieldTrackingMode", "()Lcn/sast/api/config/StaticFieldTrackingMode;", "setStaticFieldTrackingMode", "(Lcn/sast/api/config/StaticFieldTrackingMode;)V", "getMemoryThreshold", "()D", "setMemoryThreshold", "(D)V", "version", "getVersion", "setVersion", "checkerInfo", "Lkotlin/Lazy;", "Lcn/sast/api/config/CheckerInfoGenResult;", "getCheckerInfo", "()Lkotlin/Lazy;", "setCheckerInfo", "(Lkotlin/Lazy;)V", "configDirs", "", "getConfigDirs", "checkerInfoDir", "getCheckerInfoDir", "checker_info_csv", "Lcn/sast/common/IResFile;", "getChecker_info_csv", "()Lcn/sast/common/IResFile;", "rule_sort_yaml", "getRule_sort_yaml", "apponly", "getApponly", "setApponly", "value", "getSourcePath", "setSourcePath", "Ljava/nio/file/FileSystem;", "sourcePathZFS", "getSourcePathZFS", "rootPathsForConvertRelativePath", "getRootPathsForConvertRelativePath", "setRootPathsForConvertRelativePath", "allResourcePathNormalized", "getAllResourcePathNormalized", "setAllResourcePathNormalized", "sqlite_report_db", "getSqlite_report_db", "skipInvalidClassPaths", "paths", "", "getCallGraphAlgorithm", "setCallGraphAlgorithm", "getCallGraphAlgorithmBuiltIn", "setCallGraphAlgorithmBuiltIn", "isAndroidScene", "()Ljava/lang/Boolean;", "setAndroidScene", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "parallelsNum", "getParallelsNum", "setParallelsNum", "get_expand_class_path", "get_soot_classpath", "getAndroidJarClasspath", "targetAPKFile", "isSkipClassSource", "path", "Ljava/nio/file/Path;", "soot_process_dir", "getSoot_process_dir", "soot_output_dir", "getSoot_output_dir", "()Lcn/sast/common/IResource;", "forceAndroidJar", "getForceAndroidJar", "forceAndroidJar$delegate", "Lkotlin/Lazy;", "getAndroidPlatformDir", "setAndroidPlatformDir", "scanFilter", "Lcn/sast/api/config/ScanFilter;", "getScanFilter", "()Lcn/sast/api/config/ScanFilter;", "setScanFilter", "(Lcn/sast/api/config/ScanFilter;)V", "Lcn/sast/api/config/ProjectConfig;", "projectConfig", "getProjectConfig", "()Lcn/sast/api/config/ProjectConfig;", "setProjectConfig", "(Lcn/sast/api/config/ProjectConfig;)V", "validate", "", "isEnable", "type", "Lcom/feysh/corax/config/api/CheckType;", "isAnyEnable", "", "([Lcom/feysh/corax/config/api/CheckType;)Z", "getRelative", "src", "tryGetRelativePathFromAbsolutePath", "Lcn/sast/api/config/MainConfig$RelativePath;", "abs", "tryGetRelativePath", "p", "simpleDeclIncrementalAnalysisFilter", "E", "targets", "InterProceduralIncrementalAnalysisFilter", "Companion", "RelativePath", "corax-api"})
@SourceDebugExtension(value={"SMAP\nMainConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainConfig.kt\ncn/sast/api/config/MainConfig\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,463:1\n1611#2,9:464\n1863#2:473\n1864#2:475\n1620#2:476\n774#2:477\n865#2,2:478\n1557#2:480\n1628#2,3:481\n1619#2:484\n1863#2:485\n1864#2:488\n1620#2:489\n1454#2,5:490\n1628#2,3:495\n1557#2:499\n1628#2,3:500\n1755#2,3:503\n1755#2,3:506\n1755#2,3:509\n774#2:514\n865#2,2:515\n774#2:517\n865#2,2:518\n1#3:474\n1#3:486\n1#3:487\n1#3:498\n12574#4,2:512\n*S KotlinDebug\n*F\n+ 1 MainConfig.kt\ncn/sast/api/config/MainConfig\n*L\n182#1:464,9\n182#1:473\n182#1:475\n182#1:476\n197#1:477\n197#1:478,2\n197#1:480\n197#1:481,3\n224#1:484\n224#1:485\n224#1:488\n224#1:489\n262#1:490,5\n270#1:495,3\n303#1:499\n303#1:500,3\n342#1:503,3\n343#1:506,3\n344#1:509,3\n405#1:514\n405#1:515,2\n412#1:517\n412#1:518,2\n182#1:474\n224#1:487\n352#1:512,2\n*E\n"})
public final class MainConfig {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Charset sourceEncoding;
    @Nullable
    private IMonitor monitor;
    @Nullable
    private SaConfig saConfig;
    @NotNull
    private IResDirectory output_dir;
    private boolean dumpSootScene;
    private boolean use_wrapper;
    private boolean hideNoSource;
    @NotNull
    private FileSystemLocator.TraverseMode traverseMode;
    private boolean useDefaultJavaClassPath;
    @NotNull
    private PersistentSet<? extends IResource> processDir;
    @NotNull
    private PersistentSet<String> classpath;
    @NotNull
    private PersistentSet<? extends IResource> projectRoot;
    @NotNull
    private PersistentSet<? extends IResource> autoAppClasses;
    @NotNull
    private FileSystemLocator.TraverseMode autoAppTraverseMode;
    private boolean autoAppSrcInZipScheme;
    private boolean skipClass;
    @Nullable
    private IncrementalAnalyze incrementAnalyze;
    private boolean enableLineNumbers;
    private boolean enableOriginalNames;
    private int output_format;
    private int throw_analysis;
    private boolean process_multiple_dex;
    @NotNull
    private Set<String> appClasses;
    @NotNull
    private SrcPrecedence src_precedence;
    @NotNull
    private List<String> ecj_options;
    @Nullable
    private String sunBootClassPath;
    @Nullable
    private String javaExtDirs;
    private boolean hashAbspathInPlist;
    private boolean deCompileIfNotExists;
    private boolean enableCodeMetrics;
    private boolean prepend_classpath;
    private boolean whole_program;
    private boolean no_bodies_for_excluded;
    private boolean allow_phantom_refs;
    private boolean enableReflection;
    @NotNull
    private StaticFieldTrackingMode staticFieldTrackingMode;
    private double memoryThreshold;
    @Nullable
    private String version;
    @Nullable
    private Lazy<CheckerInfoGenResult> checkerInfo;
    @NotNull
    private final List<IResource> configDirs;
    private boolean apponly;
    @NotNull
    private PersistentSet<? extends IResource> sourcePath;
    @NotNull
    private PersistentSet<? extends FileSystem> sourcePathZFS;
    @NotNull
    private List<? extends IResource> rootPathsForConvertRelativePath;
    @NotNull
    private List<String> allResourcePathNormalized;
    @NotNull
    private String callGraphAlgorithm;
    @NotNull
    private String callGraphAlgorithmBuiltIn;
    @Nullable
    private Boolean isAndroidScene;
    private int parallelsNum;
    @NotNull
    private final Lazy forceAndroidJar$delegate;
    @Nullable
    private String androidPlatformDir;
    @NotNull
    private ScanFilter scanFilter;
    @NotNull
    private ProjectConfig projectConfig;
    @NotNull
    public static final String CHECKER_INFO_CSV_NAME = "checker_info.csv";
    @NotNull
    public static final String RULE_SORT_YAML = "rule_sort.yaml";
    @NotNull
    private static List<? extends Language> preferredLanguages;
    @NotNull
    private static final KLogger logger;
    @NotNull
    private static final Set<String> excludeFiles;

    public MainConfig(@NotNull Charset sourceEncoding, @Nullable IMonitor monitor, @Nullable SaConfig saConfig, @NotNull IResDirectory output_dir, boolean dumpSootScene, @Nullable String androidPlatformDir, boolean use_wrapper, boolean hideNoSource, @NotNull FileSystemLocator.TraverseMode traverseMode, boolean useDefaultJavaClassPath, @NotNull PersistentSet<? extends IResource> processDir, @NotNull PersistentSet<String> classpath, @NotNull PersistentSet<? extends IResource> sourcePath, @NotNull PersistentSet<? extends IResource> projectRoot, @NotNull PersistentSet<? extends IResource> autoAppClasses, @NotNull FileSystemLocator.TraverseMode autoAppTraverseMode, boolean autoAppSrcInZipScheme, boolean skipClass, @Nullable IncrementalAnalyze incrementAnalyze, boolean enableLineNumbers, boolean enableOriginalNames, int output_format, int throw_analysis, boolean process_multiple_dex, @NotNull Set<String> appClasses, @NotNull SrcPrecedence src_precedence, @NotNull List<String> ecj_options, @Nullable String sunBootClassPath, @Nullable String javaExtDirs, boolean hashAbspathInPlist, boolean deCompileIfNotExists, boolean enableCodeMetrics, boolean prepend_classpath, boolean whole_program, boolean no_bodies_for_excluded, boolean allow_phantom_refs, boolean enableReflection, @NotNull StaticFieldTrackingMode staticFieldTrackingMode, @NotNull String callGraphAlgorithm, @NotNull String callGraphAlgorithmBuiltIn, double memoryThreshold) {
        Intrinsics.checkNotNullParameter((Object)sourceEncoding, (String)"sourceEncoding");
        Intrinsics.checkNotNullParameter((Object)output_dir, (String)"output_dir");
        Intrinsics.checkNotNullParameter((Object)traverseMode, (String)"traverseMode");
        Intrinsics.checkNotNullParameter(processDir, (String)"processDir");
        Intrinsics.checkNotNullParameter(classpath, (String)"classpath");
        Intrinsics.checkNotNullParameter(sourcePath, (String)"sourcePath");
        Intrinsics.checkNotNullParameter(projectRoot, (String)"projectRoot");
        Intrinsics.checkNotNullParameter(autoAppClasses, (String)"autoAppClasses");
        Intrinsics.checkNotNullParameter((Object)autoAppTraverseMode, (String)"autoAppTraverseMode");
        Intrinsics.checkNotNullParameter(appClasses, (String)"appClasses");
        Intrinsics.checkNotNullParameter((Object)src_precedence, (String)"src_precedence");
        Intrinsics.checkNotNullParameter(ecj_options, (String)"ecj_options");
        Intrinsics.checkNotNullParameter((Object)staticFieldTrackingMode, (String)"staticFieldTrackingMode");
        Intrinsics.checkNotNullParameter((Object)callGraphAlgorithm, (String)"callGraphAlgorithm");
        Intrinsics.checkNotNullParameter((Object)callGraphAlgorithmBuiltIn, (String)"callGraphAlgorithmBuiltIn");
        this.sourceEncoding = sourceEncoding;
        this.monitor = monitor;
        this.saConfig = saConfig;
        this.output_dir = output_dir;
        this.dumpSootScene = dumpSootScene;
        this.use_wrapper = use_wrapper;
        this.hideNoSource = hideNoSource;
        this.traverseMode = traverseMode;
        this.useDefaultJavaClassPath = useDefaultJavaClassPath;
        this.processDir = processDir;
        this.classpath = classpath;
        this.projectRoot = projectRoot;
        this.autoAppClasses = autoAppClasses;
        this.autoAppTraverseMode = autoAppTraverseMode;
        this.autoAppSrcInZipScheme = autoAppSrcInZipScheme;
        this.skipClass = skipClass;
        this.incrementAnalyze = incrementAnalyze;
        this.enableLineNumbers = enableLineNumbers;
        this.enableOriginalNames = enableOriginalNames;
        this.output_format = output_format;
        this.throw_analysis = throw_analysis;
        this.process_multiple_dex = process_multiple_dex;
        this.appClasses = appClasses;
        this.src_precedence = src_precedence;
        this.ecj_options = ecj_options;
        this.sunBootClassPath = sunBootClassPath;
        this.javaExtDirs = javaExtDirs;
        this.hashAbspathInPlist = hashAbspathInPlist;
        this.deCompileIfNotExists = deCompileIfNotExists;
        this.enableCodeMetrics = enableCodeMetrics;
        this.prepend_classpath = prepend_classpath;
        this.whole_program = whole_program;
        this.no_bodies_for_excluded = no_bodies_for_excluded;
        this.allow_phantom_refs = allow_phantom_refs;
        this.enableReflection = enableReflection;
        this.staticFieldTrackingMode = staticFieldTrackingMode;
        this.memoryThreshold = memoryThreshold;
        this.configDirs = new ArrayList();
        this.sourcePath = ExtensionsKt.persistentSetOf();
        this.sourcePathZFS = ExtensionsKt.persistentSetOf();
        this.rootPathsForConvertRelativePath = CollectionsKt.emptyList();
        this.allResourcePathNormalized = CollectionsKt.emptyList();
        String string = callGraphAlgorithm;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
        String string2 = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        this.callGraphAlgorithm = string2;
        string = callGraphAlgorithmBuiltIn;
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale2, (String)"getDefault(...)");
        String string3 = string.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
        this.callGraphAlgorithmBuiltIn = string3;
        this.isAndroidScene = false;
        this.parallelsNum = Math.max(OS.INSTANCE.getMaxThreadNum() - 1, 1);
        this.forceAndroidJar$delegate = LazyKt.lazy(() -> MainConfig.forceAndroidJar_delegate$lambda$12(this));
        this.androidPlatformDir = androidPlatformDir;
        this.scanFilter = new ScanFilter(this, null, 2, null);
        this.projectConfig = new ProjectConfig(null, 1, null);
        this.setSourcePath(sourcePath);
        this.scanFilter.update(this.projectConfig);
    }

    public /* synthetic */ MainConfig(Charset charset, IMonitor iMonitor, SaConfig saConfig, IResDirectory iResDirectory, boolean bl, String string, boolean bl2, boolean bl3, FileSystemLocator.TraverseMode traverseMode, boolean bl4, PersistentSet persistentSet, PersistentSet persistentSet2, PersistentSet persistentSet3, PersistentSet persistentSet4, PersistentSet persistentSet5, FileSystemLocator.TraverseMode traverseMode2, boolean bl5, boolean bl6, IncrementalAnalyze incrementalAnalyze, boolean bl7, boolean bl8, int n, int n2, boolean bl9, Set set, SrcPrecedence srcPrecedence, List list, String string2, String string3, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, StaticFieldTrackingMode staticFieldTrackingMode, String string4, String string5, double d, int n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((n3 & 2) != 0) {
            iMonitor = null;
        }
        if ((n3 & 4) != 0) {
            saConfig = null;
        }
        if ((n3 & 8) != 0) {
            iResDirectory = Resource.INSTANCE.dirOf("out/test-out");
        }
        if ((n3 & 0x10) != 0) {
            bl = false;
        }
        if ((n3 & 0x20) != 0) {
            string = null;
        }
        if ((n3 & 0x40) != 0) {
            bl2 = true;
        }
        if ((n3 & 0x80) != 0) {
            bl3 = false;
        }
        if ((n3 & 0x100) != 0) {
            traverseMode = FileSystemLocator.TraverseMode.RecursivelyIndexArchive;
        }
        if ((n3 & 0x200) != 0) {
            bl4 = true;
        }
        if ((n3 & 0x400) != 0) {
            persistentSet = ExtensionsKt.persistentSetOf();
        }
        if ((n3 & 0x800) != 0) {
            persistentSet2 = ExtensionsKt.persistentSetOf();
        }
        if ((n3 & 0x1000) != 0) {
            persistentSet3 = ExtensionsKt.persistentSetOf();
        }
        if ((n3 & 0x2000) != 0) {
            persistentSet4 = ExtensionsKt.persistentSetOf();
        }
        if ((n3 & 0x4000) != 0) {
            persistentSet5 = ExtensionsKt.persistentSetOf();
        }
        if ((n3 & 0x8000) != 0) {
            traverseMode2 = FileSystemLocator.TraverseMode.RecursivelyIndexArchive;
        }
        if ((n3 & 0x10000) != 0) {
            bl5 = true;
        }
        if ((n3 & 0x20000) != 0) {
            bl6 = false;
        }
        if ((n3 & 0x40000) != 0) {
            incrementalAnalyze = null;
        }
        if ((n3 & 0x80000) != 0) {
            bl7 = true;
        }
        if ((n3 & 0x100000) != 0) {
            bl8 = true;
        }
        if ((n3 & 0x200000) != 0) {
            n = 14;
        }
        if ((n3 & 0x400000) != 0) {
            n2 = 3;
        }
        if ((n3 & 0x800000) != 0) {
            bl9 = true;
        }
        if ((n3 & 0x1000000) != 0) {
            set = SetsKt.emptySet();
        }
        if ((n3 & 0x2000000) != 0) {
            srcPrecedence = SrcPrecedence.prec_apk_class_jimple;
        }
        if ((n3 & 0x4000000) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((n3 & 0x8000000) != 0) {
            string2 = System.getProperty("sun.boot.class.path");
        }
        if ((n3 & 0x10000000) != 0) {
            string3 = System.getProperty("java.ext.dirs");
        }
        if ((n3 & 0x20000000) != 0) {
            bl10 = false;
        }
        if ((n3 & 0x40000000) != 0) {
            bl11 = true;
        }
        if ((n3 & Integer.MIN_VALUE) != 0) {
            bl12 = true;
        }
        if ((n4 & 1) != 0) {
            bl13 = false;
        }
        if ((n4 & 2) != 0) {
            bl14 = true;
        }
        if ((n4 & 4) != 0) {
            bl15 = true;
        }
        if ((n4 & 8) != 0) {
            bl16 = true;
        }
        if ((n4 & 0x10) != 0) {
            bl17 = true;
        }
        if ((n4 & 0x20) != 0) {
            staticFieldTrackingMode = StaticFieldTrackingMode.ContextFlowSensitive;
        }
        if ((n4 & 0x40) != 0) {
            string4 = "insens";
        }
        if ((n4 & 0x80) != 0) {
            string5 = "cha";
        }
        if ((n4 & 0x100) != 0) {
            d = 0.9;
        }
        this(charset, iMonitor, saConfig, iResDirectory, bl, string, bl2, bl3, traverseMode, bl4, persistentSet, persistentSet2, persistentSet3, persistentSet4, persistentSet5, traverseMode2, bl5, bl6, incrementalAnalyze, bl7, bl8, n, n2, bl9, set, srcPrecedence, list, string2, string3, bl10, bl11, bl12, bl13, bl14, bl15, bl16, bl17, staticFieldTrackingMode, string4, string5, d);
    }

    @NotNull
    public final Charset getSourceEncoding() {
        return this.sourceEncoding;
    }

    @Nullable
    public final IMonitor getMonitor() {
        return this.monitor;
    }

    public final void setMonitor(@Nullable IMonitor iMonitor) {
        this.monitor = iMonitor;
    }

    @Nullable
    public final SaConfig getSaConfig() {
        return this.saConfig;
    }

    public final void setSaConfig(@Nullable SaConfig saConfig) {
        this.saConfig = saConfig;
    }

    @NotNull
    public final IResDirectory getOutput_dir() {
        return this.output_dir;
    }

    public final void setOutput_dir(@NotNull IResDirectory iResDirectory) {
        Intrinsics.checkNotNullParameter((Object)iResDirectory, (String)"<set-?>");
        this.output_dir = iResDirectory;
    }

    public final boolean getDumpSootScene() {
        return this.dumpSootScene;
    }

    public final void setDumpSootScene(boolean bl) {
        this.dumpSootScene = bl;
    }

    public final boolean getUse_wrapper() {
        return this.use_wrapper;
    }

    public final void setUse_wrapper(boolean bl) {
        this.use_wrapper = bl;
    }

    public final boolean getHideNoSource() {
        return this.hideNoSource;
    }

    public final void setHideNoSource(boolean bl) {
        this.hideNoSource = bl;
    }

    @NotNull
    public final FileSystemLocator.TraverseMode getTraverseMode() {
        return this.traverseMode;
    }

    public final void setTraverseMode(@NotNull FileSystemLocator.TraverseMode traverseMode) {
        Intrinsics.checkNotNullParameter((Object)traverseMode, (String)"<set-?>");
        this.traverseMode = traverseMode;
    }

    public final boolean getUseDefaultJavaClassPath() {
        return this.useDefaultJavaClassPath;
    }

    public final void setUseDefaultJavaClassPath(boolean bl) {
        this.useDefaultJavaClassPath = bl;
    }

    @NotNull
    public final PersistentSet<IResource> getProcessDir() {
        return this.processDir;
    }

    public final void setProcessDir(@NotNull PersistentSet<? extends IResource> persistentSet) {
        Intrinsics.checkNotNullParameter(persistentSet, (String)"<set-?>");
        this.processDir = persistentSet;
    }

    @NotNull
    public final PersistentSet<String> getClasspath() {
        return this.classpath;
    }

    public final void setClasspath(@NotNull PersistentSet<String> persistentSet) {
        Intrinsics.checkNotNullParameter(persistentSet, (String)"<set-?>");
        this.classpath = persistentSet;
    }

    @NotNull
    public final PersistentSet<IResource> getProjectRoot() {
        return this.projectRoot;
    }

    public final void setProjectRoot(@NotNull PersistentSet<? extends IResource> persistentSet) {
        Intrinsics.checkNotNullParameter(persistentSet, (String)"<set-?>");
        this.projectRoot = persistentSet;
    }

    @NotNull
    public final PersistentSet<IResource> getAutoAppClasses() {
        return this.autoAppClasses;
    }

    public final void setAutoAppClasses(@NotNull PersistentSet<? extends IResource> persistentSet) {
        Intrinsics.checkNotNullParameter(persistentSet, (String)"<set-?>");
        this.autoAppClasses = persistentSet;
    }

    @NotNull
    public final FileSystemLocator.TraverseMode getAutoAppTraverseMode() {
        return this.autoAppTraverseMode;
    }

    public final void setAutoAppTraverseMode(@NotNull FileSystemLocator.TraverseMode traverseMode) {
        Intrinsics.checkNotNullParameter((Object)traverseMode, (String)"<set-?>");
        this.autoAppTraverseMode = traverseMode;
    }

    public final boolean getAutoAppSrcInZipScheme() {
        return this.autoAppSrcInZipScheme;
    }

    public final void setAutoAppSrcInZipScheme(boolean bl) {
        this.autoAppSrcInZipScheme = bl;
    }

    public final boolean getSkipClass() {
        return this.skipClass;
    }

    public final void setSkipClass(boolean bl) {
        this.skipClass = bl;
    }

    @Nullable
    public final IncrementalAnalyze getIncrementAnalyze() {
        return this.incrementAnalyze;
    }

    public final void setIncrementAnalyze(@Nullable IncrementalAnalyze incrementalAnalyze) {
        this.incrementAnalyze = incrementalAnalyze;
    }

    public final boolean getEnableLineNumbers() {
        return this.enableLineNumbers;
    }

    public final void setEnableLineNumbers(boolean bl) {
        this.enableLineNumbers = bl;
    }

    public final boolean getEnableOriginalNames() {
        return this.enableOriginalNames;
    }

    public final void setEnableOriginalNames(boolean bl) {
        this.enableOriginalNames = bl;
    }

    public final int getOutput_format() {
        return this.output_format;
    }

    public final void setOutput_format(int n) {
        this.output_format = n;
    }

    public final int getThrow_analysis() {
        return this.throw_analysis;
    }

    public final void setThrow_analysis(int n) {
        this.throw_analysis = n;
    }

    public final boolean getProcess_multiple_dex() {
        return this.process_multiple_dex;
    }

    public final void setProcess_multiple_dex(boolean bl) {
        this.process_multiple_dex = bl;
    }

    @NotNull
    public final Set<String> getAppClasses() {
        return this.appClasses;
    }

    public final void setAppClasses(@NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, (String)"<set-?>");
        this.appClasses = set;
    }

    @NotNull
    public final SrcPrecedence getSrc_precedence() {
        return this.src_precedence;
    }

    public final void setSrc_precedence(@NotNull SrcPrecedence srcPrecedence) {
        Intrinsics.checkNotNullParameter((Object)srcPrecedence, (String)"<set-?>");
        this.src_precedence = srcPrecedence;
    }

    @NotNull
    public final List<String> getEcj_options() {
        return this.ecj_options;
    }

    public final void setEcj_options(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.ecj_options = list;
    }

    @Nullable
    public final String getSunBootClassPath() {
        return this.sunBootClassPath;
    }

    public final void setSunBootClassPath(@Nullable String string) {
        this.sunBootClassPath = string;
    }

    @Nullable
    public final String getJavaExtDirs() {
        return this.javaExtDirs;
    }

    public final void setJavaExtDirs(@Nullable String string) {
        this.javaExtDirs = string;
    }

    public final boolean getHashAbspathInPlist() {
        return this.hashAbspathInPlist;
    }

    public final void setHashAbspathInPlist(boolean bl) {
        this.hashAbspathInPlist = bl;
    }

    public final boolean getDeCompileIfNotExists() {
        return this.deCompileIfNotExists;
    }

    public final void setDeCompileIfNotExists(boolean bl) {
        this.deCompileIfNotExists = bl;
    }

    public final boolean getEnableCodeMetrics() {
        return this.enableCodeMetrics;
    }

    public final void setEnableCodeMetrics(boolean bl) {
        this.enableCodeMetrics = bl;
    }

    public final boolean getPrepend_classpath() {
        return this.prepend_classpath;
    }

    public final void setPrepend_classpath(boolean bl) {
        this.prepend_classpath = bl;
    }

    public final boolean getWhole_program() {
        return this.whole_program;
    }

    public final void setWhole_program(boolean bl) {
        this.whole_program = bl;
    }

    public final boolean getNo_bodies_for_excluded() {
        return this.no_bodies_for_excluded;
    }

    public final void setNo_bodies_for_excluded(boolean bl) {
        this.no_bodies_for_excluded = bl;
    }

    public final boolean getAllow_phantom_refs() {
        return this.allow_phantom_refs;
    }

    public final void setAllow_phantom_refs(boolean bl) {
        this.allow_phantom_refs = bl;
    }

    public final boolean getEnableReflection() {
        return this.enableReflection;
    }

    public final void setEnableReflection(boolean bl) {
        this.enableReflection = bl;
    }

    @NotNull
    public final StaticFieldTrackingMode getStaticFieldTrackingMode() {
        return this.staticFieldTrackingMode;
    }

    public final void setStaticFieldTrackingMode(@NotNull StaticFieldTrackingMode staticFieldTrackingMode) {
        Intrinsics.checkNotNullParameter((Object)staticFieldTrackingMode, (String)"<set-?>");
        this.staticFieldTrackingMode = staticFieldTrackingMode;
    }

    public final double getMemoryThreshold() {
        return this.memoryThreshold;
    }

    public final void setMemoryThreshold(double d) {
        this.memoryThreshold = d;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(@Nullable String string) {
        this.version = string;
    }

    @Nullable
    public final Lazy<CheckerInfoGenResult> getCheckerInfo() {
        return this.checkerInfo;
    }

    public final void setCheckerInfo(@Nullable Lazy<CheckerInfoGenResult> lazy) {
        this.checkerInfo = lazy;
    }

    @NotNull
    public final List<IResource> getConfigDirs() {
        return this.configDirs;
    }

    @Nullable
    public final IResDirectory getCheckerInfoDir() {
        return MainConfigKt.checkerInfoDir((List)this.configDirs, (boolean)false);
    }

    @Nullable
    public final IResFile getChecker_info_csv() {
        IResDirectory iResDirectory = this.getCheckerInfoDir();
        return iResDirectory != null && (iResDirectory = iResDirectory.resolve(CHECKER_INFO_CSV_NAME)) != null ? iResDirectory.toFile() : null;
    }

    @Nullable
    public final IResFile getRule_sort_yaml() {
        IResDirectory iResDirectory = this.getCheckerInfoDir();
        return iResDirectory != null && (iResDirectory = iResDirectory.resolve(RULE_SORT_YAML)) != null ? iResDirectory.toFile() : null;
    }

    public final boolean getApponly() {
        return this.apponly;
    }

    public final void setApponly(boolean bl) {
        this.apponly = bl;
    }

    @NotNull
    public final PersistentSet<IResource> getSourcePath() {
        return this.sourcePath;
    }

    /*
     * WARNING - void declaration
     */
    public final void setSourcePath(@NotNull PersistentSet<? extends IResource> value) {
        void $this$mapNotNullTo$iv$iv;
        void $this$mapNotNull$iv;
        Intrinsics.checkNotNullParameter(value, (String)"value");
        this.sourcePath = value;
        Iterable iterable = (Iterable)value;
        MainConfig mainConfig = this;
        boolean $i$f$mapNotNull = false;
        void var4_5 = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            FileSystem fileSystem;
            block5: {
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                boolean bl = false;
                IResource it = (IResource)element$iv$iv;
                boolean bl2 = false;
                if (!it.getZipLike()) {
                    fileSystem = null;
                } else {
                    FileSystem fileSystem2;
                    try {
                        fileSystem2 = Resource.INSTANCE.getZipFileSystem(it.getPath());
                    }
                    catch (Exception e) {
                        fileSystem = null;
                        break block5;
                    }
                    fileSystem = fileSystem2;
                }
            }
            if (fileSystem == null) continue;
            FileSystem it$iv$iv = fileSystem;
            boolean bl = false;
            destination$iv$iv.add(it$iv$iv);
        }
        mainConfig.sourcePathZFS = ExtensionsKt.toPersistentSet((Iterable)((List)destination$iv$iv));
    }

    @NotNull
    public final PersistentSet<FileSystem> getSourcePathZFS() {
        return this.sourcePathZFS;
    }

    @NotNull
    public final List<IResource> getRootPathsForConvertRelativePath() {
        return this.rootPathsForConvertRelativePath;
    }

    /*
     * WARNING - void declaration
     */
    public final void setRootPathsForConvertRelativePath(@NotNull List<? extends IResource> value) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        IResource it;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        Intrinsics.checkNotNullParameter(value, (String)"value");
        Iterable iterable = value;
        MainConfig mainConfig = this;
        boolean $i$f$filter = false;
        void var4_5 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (IResource)element$iv$iv;
            boolean bl = false;
            if (!(it.isDirectory() || it.getZipLike())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            it = (IResource)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getAbsolute().getNormalize().toString());
        }
        Collection collection = (List)destination$iv$iv;
        mainConfig.allResourcePathNormalized = CollectionsKt.toList((Iterable)new LinkedHashSet(collection));
        this.rootPathsForConvertRelativePath = value;
    }

    @NotNull
    public final List<String> getAllResourcePathNormalized() {
        return this.allResourcePathNormalized;
    }

    public final void setAllResourcePathNormalized(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.allResourcePathNormalized = list;
    }

    @NotNull
    public final IResFile getSqlite_report_db() {
        return this.output_dir.resolve("sqlite").resolve("sqlite_report_coraxjava.db").toFile();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Set<String> skipInvalidClassPaths(@NotNull Collection<String> paths) {
        void var3_3;
        void $this$mapNotNullTo$iv;
        Intrinsics.checkNotNullParameter(paths, (String)"paths");
        Iterable iterable = paths;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv = $this$mapNotNullTo$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv.iterator();
        while (iterator2.hasNext()) {
            String string;
            block9: {
                Object element$iv$iv;
                Object element$iv = element$iv$iv = iterator2.next();
                boolean bl = false;
                String path = (String)element$iv;
                boolean bl2 = false;
                if (this.isSkipClassSource(path)) {
                    logger.info("Exclude class path: " + path);
                    string = null;
                } else {
                    IResource iResource;
                    try {
                        IResource it = iResource = Resource.INSTANCE.of(path);
                        boolean bl3 = false;
                        iResource = it.isFile() && it.getZipLike() ? iResource : null;
                    }
                    catch (Exception e) {
                        string = path;
                        break block9;
                    }
                    if (iResource == null) {
                        string = path;
                    } else {
                        IResource zipLikeFile;
                        try {
                            Resource.INSTANCE.getEntriesUnsafe(zipLikeFile.getPath());
                            string = path;
                        }
                        catch (Exception e) {
                            logger.error("skip the invalid archive file: " + zipLikeFile + " e: " + e.getMessage());
                            string = null;
                        }
                    }
                }
            }
            if (string == null) continue;
            String it$iv = string;
            boolean bl = false;
            destination$iv.add(it$iv);
        }
        return (Set)var3_3;
    }

    @NotNull
    public final String getCallGraphAlgorithm() {
        return this.callGraphAlgorithm;
    }

    public final void setCallGraphAlgorithm(@NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        String string = value;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
        String string2 = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        this.callGraphAlgorithm = string2;
    }

    @NotNull
    public final String getCallGraphAlgorithmBuiltIn() {
        return this.callGraphAlgorithmBuiltIn;
    }

    public final void setCallGraphAlgorithmBuiltIn(@NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        String string = value;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
        String string2 = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        this.callGraphAlgorithmBuiltIn = string2;
    }

    @Nullable
    public final Boolean isAndroidScene() {
        return this.isAndroidScene;
    }

    public final void setAndroidScene(@Nullable Boolean bl) {
        this.isAndroidScene = bl;
    }

    public final int getParallelsNum() {
        return this.parallelsNum <= 0 ? OS.INSTANCE.getMaxThreadNum() : this.parallelsNum;
    }

    public final void setParallelsNum(int value) {
        if (value > 0) {
            this.parallelsNum = value;
        }
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Set<IResource> get_expand_class_path() {
        Set set;
        if (!this.apponly) {
            void var2_2;
            void $this$flatMapTo$iv;
            Iterable iterable = (Iterable)this.classpath;
            Collection destination$iv = new LinkedHashSet();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv : $this$flatMapTo$iv) {
                String it = (String)element$iv;
                boolean bl = false;
                List list = ResourceImplKt.globPaths((String)it);
                if (list == null) {
                    boolean bl2 = false;
                    throw new IllegalStateException(("classpath option: \"" + it + "\" is invalid or target not exists").toString());
                }
                Iterable list$iv = list;
                CollectionsKt.addAll((Collection)destination$iv, (Iterable)list$iv);
            }
            set = (Set)var2_2;
        } else {
            set = SetsKt.emptySet();
        }
        return set;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Set<String> get_soot_classpath() {
        char[] cArray;
        void $this$mapTo$iv;
        Iterable iterable = this.get_expand_class_path();
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            IResource iResource = (IResource)item$iv;
            Collection collection = destination$iv;
            boolean bl = false;
            collection.add(it.expandRes(this.output_dir).getAbsolutePath());
        }
        Set cps = (Set)cArray;
        String javaClasspath = Scene.defaultJavaClassPath();
        if (this.useDefaultJavaClassPath) {
            Intrinsics.checkNotNull((Object)javaClasspath);
            if (((CharSequence)javaClasspath).length() > 0) {
                cArray = new char[]{File.pathSeparatorChar};
                cps.addAll(StringsKt.split$default((CharSequence)javaClasspath, (char[])cArray, (boolean)false, (int)0, (int)6, null));
            }
        }
        return this.skipInvalidClassPaths((Collection)cps);
    }

    @Nullable
    public final String getAndroidJarClasspath(@NotNull String targetAPKFile) {
        String string;
        Intrinsics.checkNotNullParameter((Object)targetAPKFile, (String)"targetAPKFile");
        Boolean bl = this.getForceAndroidJar();
        if (bl != null) {
            boolean it = bl;
            boolean bl2 = false;
            String androidJar = it ? this.getAndroidPlatformDir() : Scene.v().getAndroidJarPath(this.getAndroidPlatformDir(), targetAPKFile);
            CharSequence charSequence = androidJar;
            if (!(!(charSequence == null || charSequence.length() == 0))) {
                String string2 = "Failed requirement.";
                throw new IllegalArgumentException(string2.toString());
            }
            string = androidJar;
        } else {
            string = null;
        }
        return string;
    }

    public final boolean isSkipClassSource(@NotNull Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        return this.scanFilter.getActionOfClassPath("Process", path, null) == ProcessRule.ScanAction.Skip;
    }

    public final boolean isSkipClassSource(@NotNull String path) {
        Path path2;
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        try {
            Path path3;
            Path it = path3 = Path.of(path, new String[0]);
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            LinkOption[] linkOptionArray = new LinkOption[]{};
            Path path4 = Files.exists(it, Arrays.copyOf(linkOptionArray, linkOptionArray.length)) ? path3 : null;
            if (path4 == null) {
                return false;
            }
            path2 = path4;
        }
        catch (Exception ignore) {
            return false;
        }
        Path cp = path2;
        return this.isSkipClassSource(cp);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Set<String> getSoot_process_dir() {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Iterable iterable = SetsKt.plus((Set)((Set)this.processDir), (Iterable)((Iterable)this.autoAppClasses));
        MainConfig mainConfig = this;
        boolean $i$f$map = false;
        void var3_4 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            IResource iResource = (IResource)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.expandRes(this.output_dir).getAbsolutePath());
        }
        return CollectionsKt.toSet((Iterable)mainConfig.skipInvalidClassPaths((Collection)((List)destination$iv$iv)));
    }

    @NotNull
    public final IResource getSoot_output_dir() {
        return this.output_dir.resolve("sootOutPut");
    }

    @Nullable
    public Boolean getForceAndroidJar() {
        Lazy lazy = this.forceAndroidJar$delegate;
        return (Boolean)lazy.getValue();
    }

    @Nullable
    public final String getAndroidPlatformDir() {
        return Intrinsics.areEqual((Object)this.androidPlatformDir, (Object)"ANDROID_JARS") ? System.getenv("ANDROID_JARS") : this.androidPlatformDir;
    }

    public final void setAndroidPlatformDir(@Nullable String value) {
        this.androidPlatformDir = value;
        if (!(value == null || ((CharSequence)value).length() > 0)) {
            String string = "Check failed.";
            throw new IllegalStateException(string.toString());
        }
    }

    @NotNull
    public final ScanFilter getScanFilter() {
        return this.scanFilter;
    }

    public final void setScanFilter(@NotNull ScanFilter scanFilter) {
        Intrinsics.checkNotNullParameter((Object)scanFilter, (String)"<set-?>");
        this.scanFilter = scanFilter;
    }

    @NotNull
    public final ProjectConfig getProjectConfig() {
        return this.projectConfig;
    }

    public final void setProjectConfig(@NotNull ProjectConfig value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.projectConfig = value;
        this.scanFilter.update(value);
    }

    public final void validate() {
        boolean bl;
        block14: {
            boolean bl2;
            String it;
            boolean $i$f$any;
            Iterable $this$any$iv;
            block13: {
                boolean bl3;
                block12: {
                    $this$any$iv = (Iterable)this.classpath;
                    $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl3 = false;
                    } else {
                        for (Object element$iv : $this$any$iv) {
                            it = (String)element$iv;
                            boolean bl4 = false;
                            boolean bl5 = ((CharSequence)it).length() == 0;
                            if (!bl5) continue;
                            bl3 = true;
                            break block12;
                        }
                        bl3 = false;
                    }
                }
                if (!(!bl3)) {
                    boolean $i$a$-check-MainConfig$validate$32 = false;
                    String $i$a$-check-MainConfig$validate$32 = "classpath has empty string";
                    throw new IllegalStateException($i$a$-check-MainConfig$validate$32.toString());
                }
                $this$any$iv = (Iterable)this.processDir;
                $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl2 = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        it = (IResource)element$iv;
                        boolean bl6 = false;
                        boolean bl7 = ((CharSequence)it.toString()).length() == 0;
                        if (!bl7) continue;
                        bl2 = true;
                        break block13;
                    }
                    bl2 = false;
                }
            }
            if (!(!bl2)) {
                boolean $i$a$-check-MainConfig$validate$52 = false;
                String $i$a$-check-MainConfig$validate$52 = "processDir has empty string";
                throw new IllegalStateException($i$a$-check-MainConfig$validate$52.toString());
            }
            $this$any$iv = (Iterable)this.sourcePath;
            $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    it = (IResource)element$iv;
                    boolean bl8 = false;
                    boolean bl9 = ((CharSequence)it.toString()).length() == 0;
                    if (!bl9) continue;
                    bl = true;
                    break block14;
                }
                bl = false;
            }
        }
        if (!(!bl)) {
            boolean bl10 = false;
            String string = "sourcePath has empty string";
            throw new IllegalStateException(string.toString());
        }
    }

    public final boolean isEnable(@NotNull CheckType type) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        SaConfig saConfig = this.saConfig;
        return !(saConfig != null ? !saConfig.isEnable(type) : false);
    }

    public final boolean isAnyEnable(CheckType ... type) {
        boolean bl;
        block1: {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            CheckType[] $this$any$iv = type;
            boolean $i$f$any = false;
            int n = $this$any$iv.length;
            for (int i = 0; i < n; ++i) {
                CheckType element$iv;
                CheckType it = element$iv = $this$any$iv[i];
                boolean bl2 = false;
                if (!this.isEnable(it)) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    private final String getRelative(String src, String path) {
        String string = path.substring(src.length());
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
        Object pathString = string;
        pathString = StringsKt.replace$default((String)StringsKt.replace$default((String)pathString, (String)"\\", (String)"/", (boolean)false, (int)4, null), (String)"//", (String)"/", (boolean)false, (int)4, null);
        if (!StringsKt.startsWith$default((String)pathString, (String)"/", (boolean)false, (int)2, null)) {
            Object object;
            if (StringsKt.startsWith$default((String)pathString, (String)"!/", (boolean)false, (int)2, null)) {
                String string2 = ((String)pathString).substring(1);
                object = string2;
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"substring(...)");
            } else {
                object = "/" + (String)pathString;
            }
            pathString = object;
        }
        return pathString;
    }

    @NotNull
    public final RelativePath tryGetRelativePathFromAbsolutePath(@NotNull String abs) {
        Intrinsics.checkNotNullParameter((Object)abs, (String)"abs");
        for (String src : this.allResourcePathNormalized) {
            if (!StringsKt.startsWith$default((String)abs, (String)src, (boolean)false, (int)2, null)) continue;
            String nSrc = StringsKt.removeSuffix((String)StringsKt.replace$default((String)StringsKt.replace$default((String)src, (String)"\\", (String)"/", (boolean)false, (int)4, null), (String)"//", (String)"/", (boolean)false, (int)4, null), (CharSequence)"/");
            return new RelativePath(nSrc, this.getRelative(src, abs));
        }
        return new RelativePath("", StringsKt.replace$default((String)StringsKt.replace$default((String)abs, (String)"\\", (String)"/", (boolean)false, (int)4, null), (String)"//", (String)"/", (boolean)false, (int)4, null));
    }

    @NotNull
    public final RelativePath tryGetRelativePathFromAbsolutePath(@NotNull IResource abs) {
        Intrinsics.checkNotNullParameter((Object)abs, (String)"abs");
        return this.tryGetRelativePathFromAbsolutePath(abs.toString());
    }

    @NotNull
    public final RelativePath tryGetRelativePath(@NotNull IResource p) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        return this.tryGetRelativePathFromAbsolutePath(p.getAbsolute().getNormalize());
    }

    @NotNull
    public final RelativePath tryGetRelativePath(@NotNull Path p) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        return this.tryGetRelativePath(Resource.INSTANCE.of(p));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <E> Collection<E> simpleDeclIncrementalAnalysisFilter(@NotNull Collection<? extends E> targets) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(targets, (String)"targets");
        IncrementalAnalyze incrementalAnalyze = this.incrementAnalyze;
        IncrementalAnalyzeByChangeFiles changeFileBasedIncAnalysis = incrementalAnalyze instanceof IncrementalAnalyzeByChangeFiles ? (IncrementalAnalyzeByChangeFiles)incrementalAnalyze : null;
        IncrementalAnalyzeByChangeFiles incrementalAnalyzeByChangeFiles = changeFileBasedIncAnalysis;
        if (incrementalAnalyzeByChangeFiles == null || (incrementalAnalyzeByChangeFiles = incrementalAnalyzeByChangeFiles.getSimpleDeclAnalysisDependsGraph()) == null) {
            return targets;
        }
        IncrementalAnalyzeByChangeFiles dg = incrementalAnalyzeByChangeFiles;
        Iterable $this$filter$iv = targets;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        Iterator iterator2 = $this$filterTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object element$iv$iv;
            Object it = element$iv$iv = iterator2.next();
            boolean bl = false;
            if (!(dg.shouldReAnalyzeTarget(it) != ProcessRule.ScanAction.Skip)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <E> Collection<E> InterProceduralIncrementalAnalysisFilter(@NotNull Collection<? extends E> targets) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(targets, (String)"targets");
        IncrementalAnalyze incrementalAnalyze = this.incrementAnalyze;
        IncrementalAnalyzeByChangeFiles changeFileBasedIncAnalysis = incrementalAnalyze instanceof IncrementalAnalyzeByChangeFiles ? (IncrementalAnalyzeByChangeFiles)incrementalAnalyze : null;
        IncrementalAnalyzeByChangeFiles incrementalAnalyzeByChangeFiles = changeFileBasedIncAnalysis;
        if (incrementalAnalyzeByChangeFiles == null || (incrementalAnalyzeByChangeFiles = incrementalAnalyzeByChangeFiles.getInterProceduralAnalysisDependsGraph()) == null) {
            return targets;
        }
        IncrementalAnalyzeByChangeFiles dg = incrementalAnalyzeByChangeFiles;
        Iterable $this$filter$iv = targets;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        Iterator iterator2 = $this$filterTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object element$iv$iv;
            Object it = element$iv$iv = iterator2.next();
            boolean bl = false;
            if (!(dg.shouldReAnalyzeTarget(it) != ProcessRule.ScanAction.Skip)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private static final Boolean forceAndroidJar_delegate$lambda$12(MainConfig this$0) {
        String string = this$0.getAndroidPlatformDir();
        if (string == null) {
            return null;
        }
        String platformDir = string;
        if (((CharSequence)platformDir).length() == 0) {
            throw new RuntimeException("Android platform directory is empty");
        }
        File f = new File(platformDir);
        if (!f.exists()) {
            boolean bl = false;
            String string2 = "androidPlatformDir not exist";
            throw new IllegalArgumentException(string2.toString());
        }
        return f.isFile();
    }

    private static final Unit logger$lambda$22() {
        return Unit.INSTANCE;
    }

    public MainConfig() {
        this(null, null, null, null, false, null, false, false, null, false, null, null, null, null, null, null, false, false, null, false, false, 0, 0, false, null, null, null, null, null, false, false, false, false, false, false, false, false, null, null, null, 0.0, -1, 511, null);
    }

    public static final /* synthetic */ List access$getPreferredLanguages$cp() {
        return preferredLanguages;
    }

    public static final /* synthetic */ void access$setPreferredLanguages$cp(List list) {
        preferredLanguages = list;
    }

    public static final /* synthetic */ Set access$getExcludeFiles$cp() {
        return excludeFiles;
    }

    static {
        Object[] objectArray = new Language[]{Language.ZH, Language.EN};
        preferredLanguages = CollectionsKt.listOf((Object[])objectArray);
        logger = KotlinLogging.INSTANCE.logger(MainConfig::logger$lambda$22);
        objectArray = new String[]{"classes-header.jar", "classes-turbine.jar"};
        excludeFiles = SetsKt.setOf((Object[])objectArray);
    }
}

