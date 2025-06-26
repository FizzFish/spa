/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.OthersKt
 *  cn.sast.api.util.SootUtilsKt
 *  com.feysh.corax.config.api.IMethodMatch
 *  com.feysh.corax.config.api.baseimpl.MatchUtilsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  soot.SootClass
 *  soot.SootMethod
 */
package cn.sast.api.util;

import cn.sast.api.util.SootUtilsKt;
import com.feysh.corax.config.api.IMethodMatch;
import com.feysh.corax.config.api.baseimpl.MatchUtilsKt;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import soot.SootClass;
import soot.SootMethod;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\t\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u000b\u001a\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u001a\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0003\u00a8\u0006\u0015"}, d2={"isDummy", "", "Lsoot/SootMethod;", "(Lsoot/SootMethod;)Z", "Lsoot/SootClass;", "(Lsoot/SootClass;)Z", "isSyntheticComponent", "skipPathSensitive", "getSkipPathSensitive", "asInputStream", "Ljava/io/InputStream;", "Lkotlin/reflect/KClass;", "printMilliseconds", "", "message", "", "body", "Lkotlin/Function0;", "methodSignatureToMatcher", "Lcom/feysh/corax/config/api/IMethodMatch;", "signature", "corax-api"})
@SourceDebugExtension(value={"SMAP\nOthers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Others.kt\ncn/sast/api/util/OthersKt\n+ 2 Timing.kt\nkotlin/system/TimingKt\n*L\n1#1,48:1\n17#2,6:49\n*S KotlinDebug\n*F\n+ 1 Others.kt\ncn/sast/api/util/OthersKt\n*L\n36#1:49,6\n*E\n"})
public final class OthersKt {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isDummy(@NotNull SootMethod $this$isDummy) {
        Intrinsics.checkNotNullParameter((Object)$this$isDummy, (String)"<this>");
        if (Intrinsics.areEqual((Object)$this$isDummy.getName(), (Object)"dummyMainMethod")) return true;
        SootClass sootClass = $this$isDummy.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue((Object)sootClass, (String)"getDeclaringClass(...)");
        if (!OthersKt.isDummy((SootClass)sootClass)) return false;
        return true;
    }

    public static final boolean isDummy(@NotNull SootClass $this$isDummy) {
        Intrinsics.checkNotNullParameter((Object)$this$isDummy, (String)"<this>");
        String string = $this$isDummy.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        return StringsKt.contains((CharSequence)string, (CharSequence)"dummy", (boolean)true);
    }

    public static final boolean isSyntheticComponent(@NotNull SootMethod $this$isSyntheticComponent) {
        Intrinsics.checkNotNullParameter((Object)$this$isSyntheticComponent, (String)"<this>");
        String string = $this$isSyntheticComponent.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        return StringsKt.contains((CharSequence)string, (CharSequence)"synthetic", (boolean)true) || OthersKt.isDummy((SootMethod)$this$isSyntheticComponent);
    }

    public static final boolean isSyntheticComponent(@NotNull SootClass $this$isSyntheticComponent) {
        Intrinsics.checkNotNullParameter((Object)$this$isSyntheticComponent, (String)"<this>");
        String string = $this$isSyntheticComponent.getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getName(...)");
        return StringsKt.contains((CharSequence)string, (CharSequence)"synthetic", (boolean)true) || OthersKt.isDummy((SootClass)$this$isSyntheticComponent);
    }

    public static final boolean getSkipPathSensitive(@NotNull SootMethod $this$skipPathSensitive) {
        Intrinsics.checkNotNullParameter((Object)$this$skipPathSensitive, (String)"<this>");
        return OthersKt.isDummy((SootMethod)$this$skipPathSensitive) || OthersKt.isSyntheticComponent((SootMethod)$this$skipPathSensitive);
    }

    @NotNull
    public static final InputStream asInputStream(@NotNull KClass<?> $this$asInputStream) {
        Intrinsics.checkNotNullParameter($this$asInputStream, (String)"<this>");
        InputStream inputStream = JvmClassMappingKt.getJavaClass($this$asInputStream).getResourceAsStream("/" + StringsKt.replace$default((String)SootUtilsKt.getClassName($this$asInputStream), (char)'.', (char)'/', (boolean)false, (int)4, null) + ".class");
        Intrinsics.checkNotNull((Object)inputStream);
        return inputStream;
    }

    public static final void printMilliseconds(@NotNull String message, @NotNull Function0<Unit> body) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        Intrinsics.checkNotNullParameter(body, (String)"body");
        boolean $i$f$measureTimeMillis = false;
        long start$iv = System.currentTimeMillis();
        body.invoke();
        long time = System.currentTimeMillis() - start$iv;
        System.out.println((Object)(message + ": " + time + " ms"));
    }

    @Nullable
    public static final IMethodMatch methodSignatureToMatcher(@NotNull String signature) {
        Intrinsics.checkNotNullParameter((Object)signature, (String)"signature");
        return StringsKt.startsWith$default((String)signature, (String)"<", (boolean)false, (int)2, null) && StringsKt.endsWith$default((String)signature, (String)">", (boolean)false, (int)2, null) ? (IMethodMatch)MatchUtilsKt.matchSoot((String)signature) : (StringsKt.contains$default((CharSequence)signature, (CharSequence)":", (boolean)false, (int)2, null) ? (IMethodMatch)MatchUtilsKt.matchSimpleSig((String)signature) : null);
    }
}

