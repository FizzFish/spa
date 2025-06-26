/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.ApplicationKt
 *  cn.sast.cli.command.tools.UtilsCli
 *  com.github.ajalt.clikt.core.CliktCommand
 *  com.github.ajalt.clikt.core.CliktCommandKt
 *  com.github.ajalt.clikt.core.Context
 *  com.github.ajalt.clikt.core.Context$Builder
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.output.MordantHelpFormatter
 *  com.github.ajalt.clikt.parameters.options.EagerOptionKt
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  com.github.ajalt.clikt.parameters.types.FileKt
 *  com.github.doyaaaaaken.kotlincsv.client.CsvReader
 *  com.github.doyaaaaaken.kotlincsv.client.CsvWriter
 *  com.github.doyaaaaaken.kotlincsv.client.ICsvFileWriter
 *  com.github.doyaaaaaken.kotlincsv.dsl.CsvReaderDslKt
 *  com.github.doyaaaaaken.kotlincsv.dsl.CsvWriterDslKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.cli.command.tools;

import cn.sast.cli.ApplicationKt;
import com.github.ajalt.clikt.core.CliktCommand;
import com.github.ajalt.clikt.core.CliktCommandKt;
import com.github.ajalt.clikt.core.Context;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.output.MordantHelpFormatter;
import com.github.ajalt.clikt.parameters.options.EagerOptionKt;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.FileKt;
import com.github.doyaaaaaken.kotlincsv.client.CsvReader;
import com.github.doyaaaaaken.kotlincsv.client.CsvWriter;
import com.github.doyaaaaaken.kotlincsv.client.ICsvFileWriter;
import com.github.doyaaaaaken.kotlincsv.dsl.CsvReaderDslKt;
import com.github.doyaaaaaken.kotlincsv.dsl.CsvWriterDslKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2={"Lcn/sast/cli/command/tools/UtilsCli;", "Lcom/github/ajalt/clikt/core/CliktCommand;", "<init>", "()V", "input", "Ljava/io/File;", "getInput", "()Ljava/io/File;", "input$delegate", "Lkotlin/properties/ReadOnlyProperty;", "output", "getOutput", "output$delegate", "csvDeleteColumns", "", "", "getCsvDeleteColumns", "()Ljava/util/List;", "csvDeleteColumns$delegate", "run", "", "corax-cli"})
@SourceDebugExtension(value={"SMAP\nUtilsCli.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UtilsCli.kt\ncn/sast/cli/command/tools/UtilsCli\n+ 2 EagerOption.kt\ncom/github/ajalt/clikt/parameters/options/EagerOptionKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n65#2,10:60\n1368#3:70\n1454#3,5:71\n2632#3,3:76\n1628#3,3:80\n1863#3:83\n1797#3,3:84\n1864#3:87\n1#4:79\n*S KotlinDebug\n*F\n+ 1 UtilsCli.kt\ncn/sast/cli/command/tools/UtilsCli\n*L\n18#1:60,10\n28#1:70\n28#1:71,5\n29#1:76,3\n34#1:80,3\n38#1:83\n39#1:84,3\n38#1:87\n*E\n"})
public final class UtilsCli
extends CliktCommand {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty input$delegate;
    @NotNull
    private final ReadOnlyProperty output$delegate;
    @NotNull
    private final ReadOnlyProperty csvDeleteColumns$delegate;

    /*
     * WARNING - void declaration
     */
    public UtilsCli() {
        super(null, null, "Utils", false, false, null, null, false, false, false, 1019, null);
        void $this$versionOption_u24default$iv;
        String[] stringArray = (String[])this;
        String version$iv = ApplicationKt.getVersion();
        String help$iv = "Show the version and exit";
        Set names$iv = SetsKt.setOf((Object)"--version");
        void var5_5 = $this$versionOption_u24default$iv;
        boolean $i$f$versionOption = false;
        EagerOptionKt.eagerOption$default((CliktCommand)$this$versionOption_u24default$iv, (Collection)names$iv, (String)help$iv, (boolean)false, null, null, (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */), (int)28, null);
        CliktCommandKt.context((CliktCommand)((CliktCommand)this), UtilsCli::_init_$lambda$1);
        stringArray = new String[]{"-i"};
        this.input$delegate = FileKt.file$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])stringArray, null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null), (boolean)true, (boolean)false, (boolean)false, (boolean)false, (boolean)true, (boolean)false, (int)46, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
        stringArray = new String[]{"-o"};
        this.output$delegate = FileKt.file$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])stringArray, null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null), (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (int)63, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
        stringArray = new String[]{"--csv-d-c"};
        this.csvDeleteColumns$delegate = OptionWithValuesKt.multiple$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])stringArray, null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null), null, (boolean)false, (int)3, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[2]);
    }

    private final File getInput() {
        return (File)this.input$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    private final File getOutput() {
        return (File)this.output$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    private final List<String> getCsvDeleteColumns() {
        return (List)this.csvDeleteColumns$delegate.getValue((Object)this, $$delegatedProperties[2]);
    }

    /*
     * WARNING - void declaration
     */
    public void run() {
        if (!((Collection)this.getCsvDeleteColumns()).isEmpty()) {
            void destination$iv;
            void $this$mapTo$iv;
            Object element$iv2;
            boolean bl;
            List csvDeleteColumnNames;
            block10: {
                Iterator $this$flatMapTo$iv$iv;
                Iterable $this$flatMap$iv = this.getCsvDeleteColumns();
                boolean $i$f$flatMap = false;
                Iterable iterable = $this$flatMap$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$flatMapTo = false;
                Iterator iterator2 = $this$flatMapTo$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    Object element$iv$iv = iterator2.next();
                    String it = (String)element$iv$iv;
                    boolean bl2 = false;
                    String[] stringArray = new String[]{","};
                    Iterable list$iv$iv = StringsKt.split$default((CharSequence)it, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
                    CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
                }
                csvDeleteColumnNames = (List)destination$iv$iv;
                Iterable $this$none$iv = csvDeleteColumnNames;
                boolean $i$f$none = false;
                if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                    bl = true;
                } else {
                    for (Object element$iv2 : $this$none$iv) {
                        String it = (String)element$iv2;
                        boolean bl3 = false;
                        boolean bl4 = ((CharSequence)it).length() == 0;
                        if (!bl4) continue;
                        bl = false;
                        break block10;
                    }
                    bl = true;
                }
            }
            if (!bl) {
                boolean $i$a$-check-UtilsCli$run$52 = false;
                String $i$a$-check-UtilsCli$run$52 = csvDeleteColumnNames + " has a empty string element";
                throw new IllegalStateException($i$a$-check-UtilsCli$run$52.toString());
            }
            if (!(this.getInput() != null)) {
                boolean $i$a$-check-UtilsCli$run$62 = false;
                String $i$a$-check-UtilsCli$run$62 = "input is required";
                throw new IllegalStateException($i$a$-check-UtilsCli$run$62.toString());
            }
            if (!(this.getOutput() != null)) {
                boolean $i$a$-check-UtilsCli$run$72 = false;
                String $i$a$-check-UtilsCli$run$72 = "output is required";
                throw new IllegalStateException($i$a$-check-UtilsCli$run$72.toString());
            }
            CsvReader csvReader = CsvReaderDslKt.csvReader$default(null, (int)1, null);
            File file = this.getInput();
            Intrinsics.checkNotNull((Object)file);
            List rows = csvReader.readAll(file);
            List header = (List)CollectionsKt.first((List)rows);
            element$iv2 = csvDeleteColumnNames;
            Collection it = new LinkedHashSet();
            boolean $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                void c;
                String bl2 = (String)item$iv;
                void var15_25 = destination$iv;
                boolean bl5 = false;
                Integer n = header.indexOf(c);
                int it2 = ((Number)n).intValue();
                boolean bl6 = false;
                Integer n2 = it2 >= 0 ? n : null;
                if (n2 == null) {
                    throw new IllegalStateException(((String)c + " not exists in header: " + header).toString());
                }
                var15_25.add(Integer.valueOf(n2));
            }
            List columnIdxToDelete = CollectionsKt.reversed((Iterable)CollectionsKt.sorted((Iterable)((Iterable)destination$iv)));
            CsvWriter csvWriter = CsvWriterDslKt.csvWriter$default(null, (int)1, null);
            File file2 = this.getOutput();
            Intrinsics.checkNotNull((Object)file2);
            CsvWriter.open$default((CsvWriter)csvWriter, (File)file2, (boolean)false, arg_0 -> UtilsCli.run$lambda$11(rows, columnIdxToDelete, arg_0), (int)2, null);
        }
    }

    private static final MordantHelpFormatter lambda$1$lambda$0(Context it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new MordantHelpFormatter(it, null, true, true, 2, null);
    }

    private static final Unit _init_$lambda$1(Context.Builder $this$context) {
        Intrinsics.checkNotNullParameter((Object)$this$context, (String)"$this$context");
        $this$context.setHelpFormatter(UtilsCli::lambda$1$lambda$0);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit run$lambda$11(List $rows, List $columnIdxToDelete, ICsvFileWriter $this$open) {
        Intrinsics.checkNotNullParameter((Object)$this$open, (String)"$this$open");
        Iterable $this$forEach$iv = $rows;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            void $this$fold$iv;
            void initial$iv;
            List it = (List)element$iv;
            boolean bl = false;
            Iterable iterable = $columnIdxToDelete;
            List list = CollectionsKt.toMutableList((Collection)it);
            ICsvFileWriter iCsvFileWriter = $this$open;
            boolean $i$f$fold = false;
            void accumulator$iv = initial$iv;
            for (Object element$iv2 : $this$fold$iv) {
                void idx;
                int n = ((Number)element$iv2).intValue();
                void acc = accumulator$iv;
                boolean bl2 = false;
                acc.remove((int)idx);
                accumulator$iv = acc;
            }
            iCsvFileWriter.writeRow((List)accumulator$iv);
        }
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(UtilsCli.class, "input", "getInput()Ljava/io/File;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(UtilsCli.class, "output", "getOutput()Ljava/io/File;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(UtilsCli.class, "csvDeleteColumns", "getCsvDeleteColumns()Ljava/util/List;", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}

