/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.CheckerInfo
 *  cn.sast.cli.command.tools.CheckerInfoCompare
 *  cn.sast.cli.command.tools.CheckerInfoCompare$Companion
 *  cn.sast.cli.command.tools.CheckerInfoGenerator
 *  cn.sast.common.IResFile
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.StringCompanionObject
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.builtins.BuiltinSerializersKt
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JvmStreamsKt
 *  mu.KLogger
 *  mu.KotlinLogging
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.cli.command.tools;

import cn.sast.api.config.CheckerInfo;
import cn.sast.cli.command.tools.CheckerInfoCompare;
import cn.sast.cli.command.tools.CheckerInfoGenerator;
import cn.sast.common.IResFile;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JvmStreamsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\f"}, d2={"Lcn/sast/cli/command/tools/CheckerInfoCompare;", "", "<init>", "()V", "compareWith", "", "output", "Ljava/nio/file/Path;", "left", "Lcn/sast/common/IResFile;", "right", "Companion", "corax-cli"})
@SourceDebugExtension(value={"SMAP\nCheckerInfoCompare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckerInfoCompare.kt\ncn/sast/cli/command/tools/CheckerInfoCompare\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1#2:60\n774#3:61\n865#3,2:62\n1557#3:64\n1628#3,3:65\n774#3:68\n865#3,2:69\n774#3:71\n865#3,2:72\n1557#3:74\n1628#3,3:75\n1187#3,2:78\n1261#3,4:80\n1628#3,3:84\n774#3:87\n865#3,2:88\n*S KotlinDebug\n*F\n+ 1 CheckerInfoCompare.kt\ncn/sast/cli/command/tools/CheckerInfoCompare\n*L\n28#1:61\n28#1:62,2\n28#1:64\n28#1:65,3\n29#1:68\n29#1:69,2\n31#1:71\n31#1:72,2\n34#1:74\n34#1:75,3\n44#1:78,2\n44#1:80,4\n47#1:84,3\n48#1:87\n48#1:88,2\n*E\n"})
public final class CheckerInfoCompare {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(CheckerInfoCompare::logger$lambda$17);
    @NotNull
    private static final Json jsonFormat = CheckerInfoGenerator.Companion.getJsonFormat();
    @NotNull
    private static final KSerializer<List<CheckerInfo>> infoSerializer = CheckerInfoGenerator.Companion.getInfoSerializer();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void compareWith(@NotNull Path output, @NotNull IResFile left, @NotNull IResFile right) {
        void $this$filterTo$iv$iv;
        void destination$iv;
        void $this$mapTo$iv;
        Iterable $this$associate$iv;
        Json $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        Object outputStream3;
        void $this$filterTo$iv$iv2;
        void $this$filterTo$iv$iv3;
        Collection collection;
        void $this$mapTo$iv$iv2;
        void $this$map$iv2;
        CheckerInfo it;
        void $this$filterTo$iv$iv4;
        Object inputStream3;
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)left, (String)"left");
        Intrinsics.checkNotNullParameter((Object)right, (String)"right");
        OpenOption[] openOptionArray = new OpenOption[]{};
        InputStream inputStream2 = Files.newInputStream(right.getPath(), Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)inputStream2, (String)"newInputStream(...)");
        Closeable closeable = inputStream2;
        Object object = null;
        try {
            inputStream3 = (InputStream)closeable;
            boolean bl = false;
            inputStream3 = (List)JvmStreamsKt.decodeFromStream((Json)jsonFormat, (DeserializationStrategy)((DeserializationStrategy)infoSerializer), (InputStream)inputStream3);
        }
        catch (Throwable inputStream3) {
            object = inputStream3;
            throw inputStream3;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)object);
        }
        Object checkerInfoList = inputStream3;
        OpenOption[] openOptionArray2 = new OpenOption[]{};
        InputStream inputStream4 = Files.newInputStream(left.getPath(), Arrays.copyOf(openOptionArray2, openOptionArray2.length));
        Intrinsics.checkNotNullExpressionValue((Object)inputStream4, (String)"newInputStream(...)");
        object = inputStream4;
        inputStream3 = null;
        try {
            Object inputStream5 = (InputStream)object;
            boolean bl = false;
            inputStream5 = (List)JvmStreamsKt.decodeFromStream((Json)jsonFormat, (DeserializationStrategy)((DeserializationStrategy)infoSerializer), (InputStream)inputStream5);
        }
        catch (Throwable inputStream5) {
            inputStream3 = inputStream5;
            throw inputStream5;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)inputStream3);
        }
        Object compare = inputStream5;
        Path out = output.resolve("compare-" + StringsKt.substringBeforeLast$default((String)left.getName(), (String)".", null, (int)2, null));
        Intrinsics.checkNotNull((Object)out);
        LinkOption[] linkOptionArray = new LinkOption[]{};
        if (!Files.exists(out, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
            Files.createDirectories(out, new FileAttribute[0]);
        }
        logger.info(() -> CheckerInfoCompare.compareWith$lambda$2(left, right, out));
        Iterable $this$filter$iv = (Iterable)checkerInfoList;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Iterable destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv4) {
            it = (CheckerInfo)element$iv$iv;
            boolean bl = false;
            if (!Intrinsics.areEqual((Object)it.getAnalyzer(), (Object)"Java(canary)")) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv4 = $this$map$iv2;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv2, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            it = (CheckerInfo)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getChecker_id());
        }
        List checkIds = (List)destination$iv$iv;
        Iterable $this$filter$iv2 = (Iterable)compare;
        boolean $i$f$filter2 = false;
        destination$iv$iv = $this$filter$iv2;
        Iterable destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo2 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv3) {
            CheckerInfo it2 = (CheckerInfo)element$iv$iv;
            boolean bl = false;
            if (!Intrinsics.areEqual((Object)it2.getAnalyzer(), (Object)"Java(canary)")) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        List compareChecks = (List)destination$iv$iv2;
        Object $this$filter$iv3 = compareChecks;
        boolean $i$f$filter222 = false;
        destination$iv$iv2 = $this$filter$iv3;
        Collection destination$iv$iv3 = new ArrayList();
        boolean $i$f$filterTo3 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv2) {
            CheckerInfo it3 = (CheckerInfo)element$iv$iv;
            boolean bl = false;
            if (!(!checkIds.contains(it3.getChecker_id()))) continue;
            destination$iv$iv3.add(element$iv$iv);
        }
        List deleted = (List)destination$iv$iv3;
        Path path = out.resolve("deleted-checker-ids.json");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        $this$filter$iv3 = path;
        Object $i$f$filter222 = new OpenOption[]{};
        OutputStream outputStream2 = Files.newOutputStream((Path)$this$filter$iv3, Arrays.copyOf($i$f$filter222, ((OpenOption[])$i$f$filter222).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream2, (String)"newOutputStream(...)");
        $this$filter$iv3 = outputStream2;
        $i$f$filter222 = null;
        try {
            outputStream3 = (OutputStream)$this$filter$iv3;
            boolean bl = false;
            $this$map$iv = deleted;
            boolean $i$f$map2 = false;
            Iterable element$iv$iv = $this$map$iv;
            Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo2 = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it4;
                CheckerInfo checkerInfo = (CheckerInfo)item$iv$iv;
                Collection collection2 = destination$iv$iv4;
                boolean bl2 = false;
                collection2.add(it4.getChecker_id());
            }
            List deletedIds = (List)destination$iv$iv4;
            logger.warn(() -> CheckerInfoCompare.compareWith$lambda$9$lambda$8(deletedIds));
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)BuiltinSerializersKt.ListSerializer((KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE))), (Object)deletedIds, (OutputStream)outputStream3);
            outputStream3 = Unit.INSTANCE;
        }
        catch (Throwable outputStream3) {
            $i$f$filter222 = outputStream3;
            throw outputStream3;
        }
        finally {
            CloseableKt.closeFinally((Closeable)$this$filter$iv3, (Throwable)$i$f$filter222);
        }
        Path path2 = out.resolve("deleted.json");
        Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"resolve(...)");
        $this$filter$iv3 = path2;
        $i$f$filter222 = new OpenOption[]{};
        OutputStream outputStream4 = Files.newOutputStream((Path)$this$filter$iv3, Arrays.copyOf($i$f$filter222, ((OpenOption[])$i$f$filter222).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream4, (String)"newOutputStream(...)");
        $this$filter$iv3 = outputStream4;
        $i$f$filter222 = null;
        try {
            outputStream3 = (OutputStream)$this$filter$iv3;
            boolean bl = false;
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)infoSerializer), (Object)deleted, (OutputStream)outputStream3);
            outputStream3 = Unit.INSTANCE;
        }
        catch (Throwable outputStream5) {
            $i$f$filter222 = outputStream5;
            throw outputStream5;
        }
        finally {
            CloseableKt.closeFinally((Closeable)$this$filter$iv3, (Throwable)$i$f$filter222);
        }
        Path path3 = out.resolve("checker_name_mapping.json");
        Intrinsics.checkNotNullExpressionValue((Object)path3, (String)"resolve(...)");
        $this$filter$iv3 = path3;
        $i$f$filter222 = new OpenOption[]{};
        OutputStream outputStream6 = Files.newOutputStream((Path)$this$filter$iv3, Arrays.copyOf($i$f$filter222, ((OpenOption[])$i$f$filter222).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream6, (String)"newOutputStream(...)");
        $this$filter$iv3 = outputStream6;
        $i$f$filter222 = null;
        try {
            void $this$associateTo$iv$iv;
            outputStream3 = (OutputStream)$this$filter$iv3;
            boolean bl = false;
            $this$map$iv = deleted;
            SerializationStrategy $i$f$map2 = (SerializationStrategy)BuiltinSerializersKt.MapSerializer((KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE), (KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE));
            $this$mapTo$iv$iv = jsonFormat;
            boolean $i$f$associate = false;
            int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associate$iv, (int)10)), (int)16);
            Iterator iterator2 = $this$associate$iv;
            Map destination$iv$iv5 = new LinkedHashMap(capacity$iv);
            boolean $i$f$associateTo = false;
            for (Object element$iv$iv : $this$associateTo$iv$iv) {
                Map map = destination$iv$iv5;
                CheckerInfo it5 = (CheckerInfo)element$iv$iv;
                boolean bl3 = false;
                Pair pair = TuplesKt.to((Object)it5.getChecker_id(), (Object)"");
                map.put(pair.getFirst(), pair.getSecond());
            }
            Map map = destination$iv$iv5;
            JvmStreamsKt.encodeToStream((Json)$this$mapTo$iv$iv, (SerializationStrategy)$i$f$map2, (Object)map, (OutputStream)outputStream3);
            outputStream3 = Unit.INSTANCE;
        }
        catch (Throwable outputStream7) {
            $i$f$filter222 = outputStream7;
            throw outputStream7;
        }
        finally {
            CloseableKt.closeFinally((Closeable)$this$filter$iv3, (Throwable)$i$f$filter222);
        }
        $i$f$filter222 = compareChecks;
        outputStream3 = new LinkedHashSet();
        boolean $i$f$mapTo3 = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it6;
            $this$mapTo$iv$iv = (CheckerInfo)item$iv;
            collection = destination$iv;
            boolean bl = false;
            collection.add(it6.getChecker_id());
        }
        Set checkerIdAll = (Set)destination$iv;
        Iterable $this$filter$iv4 = checkIds;
        boolean $i$f$filter3 = false;
        $this$associate$iv = $this$filter$iv4;
        Collection destination$iv$iv6 = new ArrayList();
        boolean $i$f$filterTo4 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            String it7 = (String)element$iv$iv;
            boolean bl = false;
            if (!(!checkerIdAll.contains(it7))) continue;
            destination$iv$iv6.add(element$iv$iv);
        }
        List list = (List)destination$iv$iv6;
        Path path4 = out.resolve("new.json");
        Intrinsics.checkNotNullExpressionValue((Object)path4, (String)"resolve(...)");
        Object object2 = path4;
        Object object3 = new OpenOption[]{};
        OutputStream outputStream8 = Files.newOutputStream((Path)object2, Arrays.copyOf(object3, ((OpenOption[])object3).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream8, (String)"newOutputStream(...)");
        object2 = outputStream8;
        object3 = null;
        try {
            OutputStream outputStream9 = (OutputStream)object2;
            boolean bl = false;
            logger.info(() -> CheckerInfoCompare.compareWith$lambda$16$lambda$15(list));
            JvmStreamsKt.encodeToStream((Json)jsonFormat, (SerializationStrategy)((SerializationStrategy)BuiltinSerializersKt.ListSerializer((KSerializer)BuiltinSerializersKt.serializer((StringCompanionObject)StringCompanionObject.INSTANCE))), (Object)list, (OutputStream)outputStream9);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object3 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object2, (Throwable)object3);
        }
    }

    private static final Object compareWith$lambda$2(IResFile $left, IResFile $right, Path $out) {
        return "The computed diff between '" + $left + "' and '" + $right + "' yields the following result: " + $out;
    }

    private static final Object compareWith$lambda$9$lambda$8(List $deletedIds) {
        return "[-] Deleted " + $deletedIds.size() + " checker ids. " + CollectionsKt.joinToString$default((Iterable)$deletedIds, (CharSequence)"\n\t", (CharSequence)"[\n\t", (CharSequence)"\n]", (int)0, null, null, (int)56, null);
    }

    private static final Object compareWith$lambda$16$lambda$15(List $new) {
        return "[+] New " + $new.size() + " checker ids: " + CollectionsKt.joinToString$default((Iterable)$new, (CharSequence)"\n\t", (CharSequence)"[\n\t", (CharSequence)"\n]", (int)0, null, null, (int)56, null);
    }

    private static final Unit logger$lambda$17() {
        return Unit.INSTANCE;
    }
}

