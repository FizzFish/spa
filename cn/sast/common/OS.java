/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.IResource
 *  cn.sast.common.OS
 *  cn.sast.common.PathExtensionsKt
 *  cn.sast.common.Resource
 *  cn.sast.common.ResourceKt
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.path.PathsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.utbot.common.PathUtil
 */
package cn.sast.common;

import cn.sast.common.IResource;
import cn.sast.common.PathExtensionsKt;
import cn.sast.common.Resource;
import cn.sast.common.ResourceKt;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.utbot.common.PathUtil;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J/\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010$2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\b\b\u0002\u0010%\u001a\u00020\u000b\u00a2\u0006\u0002\u0010&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0013\u0010 \u001a\u0004\u0018\u00010\u001a8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0019\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+\u00a8\u0006,"}, d2={"Lcn/sast/common/OS;", "", "<init>", "()V", "maxThreadNum", "", "getMaxThreadNum", "()I", "setMaxThreadNum", "(I)V", "isWindows", "", "()Z", "binaryUrl", "Ljava/net/URL;", "getBinaryUrl", "()Ljava/net/URL;", "binaryUrl$delegate", "Lkotlin/Lazy;", "jarBinPath", "Ljava/nio/file/Path;", "getJarBinPath", "()Ljava/nio/file/Path;", "jarBinPath$delegate", "args", "", "", "getArgs", "()[Ljava/lang/String;", "setArgs", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "javaExecutableFilePath", "getJavaExecutableFilePath", "()Ljava/lang/String;", "getCommandLine", "", "jvmOptions", "([Ljava/lang/String;Z)Ljava/util/List;", "posixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "getPosixFilePermissions", "()Ljava/util/Set;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nOS.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OS.kt\ncn/sast/common/OS\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,63:1\n1#2:64\n*E\n"})
public final class OS {
    @NotNull
    public static final OS INSTANCE = new OS();
    private static int maxThreadNum = Runtime.getRuntime().availableProcessors();
    private static final boolean isWindows;
    @NotNull
    private static final Lazy binaryUrl$delegate;
    @NotNull
    private static final Lazy jarBinPath$delegate;
    @NotNull
    private static String[] args;
    @Nullable
    private static final Set<PosixFilePermission> posixFilePermissions;

    private OS() {
    }

    public final int getMaxThreadNum() {
        return maxThreadNum;
    }

    public final void setMaxThreadNum(int n) {
        maxThreadNum = n;
    }

    public final boolean isWindows() {
        return isWindows;
    }

    @Nullable
    public final URL getBinaryUrl() {
        Lazy lazy = binaryUrl$delegate;
        return (URL)lazy.getValue();
    }

    @Nullable
    public final Path getJarBinPath() {
        Lazy lazy = jarBinPath$delegate;
        return (Path)lazy.getValue();
    }

    @NotNull
    public final String[] getArgs() {
        return args;
    }

    public final void setArgs(@NotNull String[] stringArray) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"<set-?>");
        args = stringArray;
    }

    @Nullable
    public final String getJavaExecutableFilePath() {
        Optional<String> optional = ProcessHandle.current().info().command();
        Intrinsics.checkNotNullExpressionValue(optional, (String)"command(...)");
        return (String)OptionalsKt.getOrNull(optional);
    }

    @Nullable
    public final List<String> getCommandLine(@Nullable String[] args, boolean jvmOptions) {
        List list;
        String string = this.getJavaExecutableFilePath();
        if (string == null) {
            return null;
        }
        String javaExecutableFilePath = string;
        try {
            Object object;
            Object it;
            List r = new ArrayList();
            r.add(javaExecutableFilePath);
            if (jvmOptions) {
                Object object2 = ManagementFactory.getRuntimeMXBean();
                if (object2 != null && (object2 = object2.getInputArguments()) != null) {
                    it = object2;
                    boolean bl = false;
                    r.addAll((Collection)it);
                }
            }
            if ((object = this.getBinaryUrl()) != null && (object = ((URL)object).getPath()) != null) {
                it = object;
                boolean bl = false;
                r.add("-cp");
                r.add(it);
                Collection collection = r;
                Object[] objectArray = args;
                if (args == null) {
                    objectArray = OS.args;
                }
                CollectionsKt.addAll((Collection)collection, (Object[])objectArray);
            }
            list = r;
        }
        catch (Throwable e) {
            list = null;
        }
        return list;
    }

    public static /* synthetic */ List getCommandLine$default(OS oS, String[] stringArray, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            stringArray = null;
        }
        if ((n & 2) != 0) {
            bl = true;
        }
        return oS.getCommandLine(stringArray, bl);
    }

    @Nullable
    public final Set<PosixFilePermission> getPosixFilePermissions() {
        return posixFilePermissions;
    }

    private static final URL binaryUrl_delegate$lambda$0() {
        Object object = OS.class.getProtectionDomain();
        if (object == null || (object = ((ProtectionDomain)object).getCodeSource()) == null || (object = ((CodeSource)object).getLocation()) == null) {
            return null;
        }
        Object loc = object;
        String string = ((URL)loc).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String locString = string;
        if (StringsKt.endsWith$default((String)locString, (String)"BOOT-INF/classes!/", (boolean)false, (int)2, null) || StringsKt.endsWith$default((String)locString, (String)"BOOT-INF/classes", (boolean)false, (int)2, null)) {
            locString = StringsKt.removeSuffix((String)locString, (CharSequence)"!/");
            IResource classLoc = Resource.INSTANCE.of(ResourceKt.uriOf((String)locString));
            return PathUtil.INSTANCE.toURL(classLoc.getSchemePath());
        }
        return loc;
    }

    private static final Path jarBinPath_delegate$lambda$3() {
        Path path;
        URL uRL = INSTANCE.getBinaryUrl();
        if (uRL != null) {
            Path path2;
            URL url = uRL;
            boolean bl = false;
            Path it = path2 = Path.of(url.toURI());
            boolean bl2 = false;
            Intrinsics.checkNotNull((Object)it);
            path = PathExtensionsKt.isRegularFile((Path)it) && StringsKt.endsWith$default((String)PathsKt.getName((Path)it), (String)".jar", (boolean)false, (int)2, null) ? path2 : null;
        } else {
            path = null;
        }
        return path;
    }

    static {
        String string = System.getProperty("os.name");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getProperty(...)");
        String string2 = string;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
        String string3 = string2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
        isWindows = StringsKt.contains$default((CharSequence)string3, (CharSequence)"windows", (boolean)false, (int)2, null);
        binaryUrl$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, OS::binaryUrl_delegate$lambda$0);
        jarBinPath$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, OS::jarBinPath_delegate$lambda$3);
        args = new String[0];
        posixFilePermissions = isWindows ? null : PosixFilePermissions.fromString("rwxr--r--");
    }
}

