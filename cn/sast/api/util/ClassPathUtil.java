/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.ClassPathUtil
 *  javax.annotation.Nonnull
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.util;

import java.io.File;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lcn/sast/api/util/ClassPathUtil;", "", "<init>", "()V", "findCodeBaseInClassPath", "", "codeBaseName", "classPath", "codeBaseNamePattern", "Ljava/util/regex/Pattern;", "javaClassPath", "", "getJavaClassPath", "()[Ljava/lang/String;", "corax-api"})
@SourceDebugExtension(value={"SMAP\nClassPathUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassPathUtil.kt\ncn/sast/api/util/ClassPathUtil\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,81:1\n37#2,2:82\n*S KotlinDebug\n*F\n+ 1 ClassPathUtil.kt\ncn/sast/api/util/ClassPathUtil\n*L\n67#1:82,2\n*E\n"})
public final class ClassPathUtil {
    @NotNull
    public static final ClassPathUtil INSTANCE = new ClassPathUtil();

    private ClassPathUtil() {
    }

    @Nullable
    public final String findCodeBaseInClassPath(@Nonnull @NotNull String codeBaseName, @Nullable String classPath) {
        Intrinsics.checkNotNullParameter((Object)codeBaseName, (String)"codeBaseName");
        if (classPath == null) {
            return null;
        }
        StringTokenizer tok = new StringTokenizer(classPath, File.pathSeparator);
        while (tok.hasMoreTokens()) {
            String t = tok.nextToken();
            File f = new File(t);
            if (!Intrinsics.areEqual((Object)f.getName(), (Object)codeBaseName)) continue;
            return t;
        }
        return null;
    }

    @Nullable
    public final String findCodeBaseInClassPath(@NotNull Pattern codeBaseNamePattern, @Nullable String classPath) {
        Intrinsics.checkNotNullParameter((Object)codeBaseNamePattern, (String)"codeBaseNamePattern");
        if (classPath == null) {
            return null;
        }
        StringTokenizer tok = new StringTokenizer(classPath, File.pathSeparator);
        while (tok.hasMoreTokens()) {
            String t = tok.nextToken();
            File f = new File(t);
            Matcher m = codeBaseNamePattern.matcher(f.getName());
            if (!m.matches()) continue;
            return t;
        }
        return null;
    }

    @NotNull
    public final String[] getJavaClassPath() {
        String string = System.getProperty("java.class.path");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getProperty(...)");
        String[] stringArray = new String[]{":"};
        Collection $this$toTypedArray$iv = StringsKt.split$default((CharSequence)string, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        return thisCollection$iv.toArray(new String[0]);
    }
}

