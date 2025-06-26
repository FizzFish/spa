/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.validator.PrettyTable
 *  kotlin.Metadata
 *  kotlin._Assertions
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.framework.validator;

import java.io.Closeable;
import java.io.Flushable;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0006J\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u0010*\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lcn/sast/framework/validator/PrettyTable;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "out", "Ljava/io/PrintWriter;", "head", "", "", "<init>", "(Ljava/io/PrintWriter;Ljava/util/List;)V", "table", "", "columns", "", "blockSize", "addLine", "", "line", "", "dump", "flush", "close", "printLine", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nPrettyTable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrettyTable.kt\ncn/sast/framework/validator/PrettyTable\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n1557#2:62\n1628#2,3:63\n1557#2:66\n1628#2,3:67\n1557#2:70\n1628#2,3:71\n1567#2:74\n1598#2,4:75\n*S KotlinDebug\n*F\n+ 1 PrettyTable.kt\ncn/sast/framework/validator/PrettyTable\n*L\n17#1:62\n17#1:63,3\n21#1:66\n21#1:67,3\n24#1:70\n24#1:71,3\n53#1:74\n53#1:75,4\n*E\n"})
public final class PrettyTable
implements Closeable,
Flushable {
    @NotNull
    private final PrintWriter out;
    @NotNull
    private final List<List<String>> table;
    private final int columns;
    @NotNull
    private List<Integer> blockSize;

    /*
     * WARNING - void declaration
     */
    public PrettyTable(@NotNull PrintWriter out, @NotNull List<String> head) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter((Object)out, (String)"out");
        Intrinsics.checkNotNullParameter(head, (String)"head");
        this.out = out;
        this.table = new ArrayList();
        this.table.add(head);
        this.columns = head.size();
        Iterable iterable = head;
        PrettyTable prettyTable = this;
        boolean $i$f$map = false;
        void var5_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            String string = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.length());
        }
        prettyTable.blockSize = (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    public final void addLine(@NotNull List<? extends Object> line) {
        Collection collection;
        Iterable $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(line, (String)"line");
        Iterable $this$map$iv = line;
        boolean $i$f$map2 = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void it;
            Object item$iv$iv;
            Object t = item$iv$iv = iterator2.next();
            collection = destination$iv$iv;
            boolean bl = false;
            String string = it;
            if (string == null || (string = string.toString()) == null) {
                string = "";
            }
            collection.add(string);
        }
        List lineStr = (List)destination$iv$iv;
        this.table.add(lineStr);
        boolean bl = $this$map$iv = this.columns == line.size();
        if (_Assertions.ENABLED && !$this$map$iv) {
            String $i$f$map2 = "Assertion failed";
            throw new AssertionError((Object)$i$f$map2);
        }
        $this$map$iv = (Iterable)RangesKt.until((int)0, (int)this.columns);
        collection = this;
        $i$f$map2 = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        $i$f$mapTo = false;
        iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void i;
            int item$iv$iv;
            int it = item$iv$iv = ((IntIterator)iterator2).nextInt();
            Collection collection2 = destination$iv$iv;
            boolean bl2 = false;
            collection2.add(Math.max(((Number)this.blockSize.get((int)i)).intValue(), ((String)lineStr.get((int)i)).length()));
        }
        ((PrettyTable)collection).blockSize = (List)destination$iv$iv;
    }

    public final void dump() {
        int lines2 = this.table.size();
        String normalBar = "+" + CollectionsKt.joinToString$default((Iterable)this.blockSize, (CharSequence)"+", null, null, (int)0, null, PrettyTable::dump$lambda$3, (int)30, null) + "+";
        String doubleBar = "+" + CollectionsKt.joinToString$default((Iterable)this.blockSize, (CharSequence)"+", null, null, (int)0, null, PrettyTable::dump$lambda$4, (int)30, null) + "+";
        this.out.println(normalBar);
        this.printLine(this.out, (List)this.table.get(0));
        this.out.println(doubleBar);
        for (int i = 1; i < lines2; ++i) {
            this.printLine(this.out, (List)this.table.get(i));
            this.out.println(normalBar);
        }
    }

    @Override
    public void flush() {
        this.out.flush();
    }

    @Override
    public void close() {
        this.out.close();
    }

    /*
     * WARNING - void declaration
     */
    private final void printLine(PrintWriter $this$printLine, List<String> line) {
        void $this$mapIndexedTo$iv$iv;
        void $this$mapIndexed$iv;
        $this$printLine.print("|");
        Iterable iterable = line;
        PrintWriter printWriter = $this$printLine;
        boolean $i$f$mapIndexed = false;
        void var5_6 = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed$iv, (int)10));
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            void block;
            void i;
            int n;
            if ((n = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String string = (String)item$iv$iv;
            int n2 = n;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            int totalSize = ((Number)this.blockSize.get((int)i)).intValue() - block.length() + 2;
            int leftSize = totalSize / 2;
            int rightSize = totalSize - leftSize;
            collection.add(StringsKt.repeat((CharSequence)" ", (int)leftSize) + (String)block + StringsKt.repeat((CharSequence)" ", (int)rightSize));
        }
        printWriter.print(CollectionsKt.joinToString$default((Iterable)((List)destination$iv$iv), (CharSequence)"|", null, null, (int)0, null, null, (int)62, null));
        $this$printLine.println("|");
    }

    private static final CharSequence dump$lambda$3(int it) {
        return StringsKt.repeat((CharSequence)"-", (int)(it + 2));
    }

    private static final CharSequence dump$lambda$4(int it) {
        return StringsKt.repeat((CharSequence)"=", (int)(it + 2));
    }
}

