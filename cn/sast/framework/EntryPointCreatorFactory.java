/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.util.OthersKt
 *  cn.sast.common.IResource
 *  cn.sast.common.Resource
 *  cn.sast.framework.EntryPointCreatorFactory
 *  com.feysh.corax.config.api.IMethodMatch
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.SourceLocator
 */
package cn.sast.framework;

import cn.sast.api.util.OthersKt;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import com.feysh.corax.config.api.IMethodMatch;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SourceLocator;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lcn/sast/framework/EntryPointCreatorFactory;", "", "<init>", "()V", "logger", "Lmu/KLogger;", "lookFromDir", "", "res", "", "Lsoot/SootClass;", "direction", "Lcn/sast/common/IResource;", "loadClass", "className", "", "getEntryPointFromArgs", "Lkotlin/Function0;", "", "Lsoot/SootMethod;", "args", "", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nEntryPointCreatorFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntryPointCreatorFactory.kt\ncn/sast/framework/EntryPointCreatorFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,73:1\n1863#2:74\n1864#2:98\n108#3:75\n80#3,22:76\n*S KotlinDebug\n*F\n+ 1 EntryPointCreatorFactory.kt\ncn/sast/framework/EntryPointCreatorFactory\n*L\n32#1:74\n32#1:98\n52#1:75\n52#1:76,22\n*E\n"})
public final class EntryPointCreatorFactory {
    @NotNull
    public static final EntryPointCreatorFactory INSTANCE = new EntryPointCreatorFactory();
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(EntryPointCreatorFactory::logger$lambda$0);

    private EntryPointCreatorFactory() {
    }

    private final void lookFromDir(Set<SootClass> res, IResource direction) {
        Scene scene = Scene.v();
        for (String cl : SourceLocator.v().getClassesUnder(direction.getAbsolutePath())) {
            SootClass theClass;
            Intrinsics.checkNotNullExpressionValue((Object)scene.loadClass(cl, 2), (String)"loadClass(...)");
            res.add(theClass);
        }
    }

    private final void loadClass(String className) {
        Scene.v().forceResolve(className, 3);
        Scene.v().loadClassAndSupport(className);
    }

    @NotNull
    public final Function0<Set<SootMethod>> getEntryPointFromArgs(@NotNull List<String> args) {
        Intrinsics.checkNotNullParameter(args, (String)"args");
        return () -> EntryPointCreatorFactory.getEntryPointFromArgs$lambda$5(args);
    }

    private static final Unit logger$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final String getEntryPointFromArgs$lambda$5$lambda$4$lambda$3$lambda$2(Ref.ObjectRef $line) {
        return "soot method: " + $line.element + " not exists";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private static final Set getEntryPointFromArgs$lambda$5(List $args) {
        Set mSet = new LinkedHashSet();
        Iterable $this$forEach$iv = $args;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String arg = (String)element$iv;
            boolean bl = false;
            IMethodMatch match = OthersKt.methodSignatureToMatcher((String)arg);
            if (match != null) {
                Scene scene = Scene.v();
                Intrinsics.checkNotNullExpressionValue((Object)scene, (String)"v(...)");
                List ms = match.matched(scene);
                if (ms.isEmpty()) {
                    throw new IllegalStateException(("method: " + match + " not exists").toString());
                }
                mSet.addAll(ms);
                continue;
            }
            IResource res = Resource.INSTANCE.of(arg);
            if (!res.getExists()) {
                throw new IllegalStateException(("invalidate " + arg).toString());
            }
            if (!res.isFile()) continue;
            Object object = res.getPath();
            Object object2 = Charsets.UTF_8;
            Unit unit = new Unit[]{};
            object = new InputStreamReader(Files.newInputStream((Path)object, Arrays.copyOf(unit, ((OpenOption[])unit).length)), (Charset)object2);
            object2 = null;
            try {
                Ref.ObjectRef line;
                InputStreamReader sd = (InputStreamReader)object;
                boolean bl2 = false;
                BufferedReader reader = new BufferedReader(sd);
                while (true) {
                    void $this$trim$iv;
                    line = new Ref.ObjectRef();
                    if (reader.readLine() == null) break;
                    line.element = line.element;
                    String string = (String)line.element;
                    Ref.ObjectRef objectRef = line;
                    boolean $i$f$trim = false;
                    CharSequence $this$trim$iv$iv = (CharSequence)$this$trim$iv;
                    boolean $i$f$trim2 = false;
                    int startIndex$iv$iv = 0;
                    int endIndex$iv$iv = $this$trim$iv$iv.length() - 1;
                    boolean startFound$iv$iv = false;
                    while (startIndex$iv$iv <= endIndex$iv$iv) {
                        boolean match$iv$iv;
                        int index$iv$iv = !startFound$iv$iv ? startIndex$iv$iv : endIndex$iv$iv;
                        char it = $this$trim$iv$iv.charAt(index$iv$iv);
                        boolean bl3 = false;
                        boolean bl4 = match$iv$iv = Intrinsics.compare((int)it, (int)32) <= 0;
                        if (!startFound$iv$iv) {
                            if (!match$iv$iv) {
                                startFound$iv$iv = true;
                                continue;
                            }
                            ++startIndex$iv$iv;
                            continue;
                        }
                        if (!match$iv$iv) break;
                        --endIndex$iv$iv;
                    }
                    objectRef.element = ((Object)$this$trim$iv$iv.subSequence(startIndex$iv$iv, endIndex$iv$iv + 1)).toString();
                    if (((CharSequence)line.element).length() == 0 || StringsKt.startsWith$default((String)((String)line.element), (String)"-", (boolean)false, (int)2, null)) continue;
                    String string2 = Scene.signatureToClass((String)((String)line.element));
                    Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"signatureToClass(...)");
                    INSTANCE.loadClass(string2);
                    SootMethod m = Scene.v().grabMethod((String)line.element);
                    if (m == null) {
                        throw new IllegalStateException(((Function0)() -> EntryPointCreatorFactory.getEntryPointFromArgs$lambda$5$lambda$4$lambda$3$lambda$2(line)).toString());
                    }
                    mSet.add(m);
                }
                Object cfr_ignored_0 = line.element;
                unit = Unit.INSTANCE;
            }
            catch (Throwable throwable) {
                object2 = throwable;
                throw throwable;
            }
            finally {
                CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
            }
        }
        return mSet;
    }
}

