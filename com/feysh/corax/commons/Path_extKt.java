/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.text.Charsets
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.commons;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a7\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006\u00a8\u0006\u000b"}, d2={"linesMatch", "", "Ljava/nio/file/Path;", "max", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\npath-ext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 path-ext.kt\ncom/feysh/corax/commons/Path_extKt\n+ 2 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,22:1\n54#2,4:23\n1#3:27\n1317#4,2:28\n*S KotlinDebug\n*F\n+ 1 path-ext.kt\ncom/feysh/corax/commons/Path_extKt\n*L\n8#1:23,4\n8#1:27\n10#1:28,2\n*E\n"})
public final class Path_extKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public static final String linesMatch(@NotNull Path $this$linesMatch, int max, @NotNull Function1<? super String, Boolean> predicate) {
        Intrinsics.checkNotNullParameter((Object)$this$linesMatch, (String)"<this>");
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        OpenOption[] openOptionArray = new OpenOption[]{};
        InputStream inputStream = Files.newInputStream($this$linesMatch, Arrays.copyOf(openOptionArray, openOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"newInputStream(...)");
        Closeable closeable = inputStream;
        Object object = Charsets.UTF_8;
        closeable = new InputStreamReader((InputStream)closeable, (Charset)object);
        object = null;
        try {
            InputStreamReader reader = (InputStreamReader)closeable;
            boolean bl = false;
            Reader $this$useLines$iv = reader;
            boolean $i$f$useLines = false;
            Closeable closeable2 = $this$useLines$iv;
            int n = 8192;
            closeable2 = closeable2 instanceof BufferedReader ? (BufferedReader)closeable2 : new BufferedReader((Reader)closeable2, n);
            Throwable throwable = null;
            try {
                BufferedReader it$iv = (BufferedReader)closeable2;
                boolean bl2 = false;
                Sequence it = TextStreamsKt.lineSequence((BufferedReader)it$iv);
                boolean bl3 = false;
                Ref.IntRef i = new Ref.IntRef();
                Sequence $this$forEach$iv = it;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    String line = (String)element$iv;
                    boolean bl4 = false;
                    if (max > 0) {
                        int n2 = i.element;
                        i.element = n2 + 1;
                        if (n2 >= max) {
                            String string = null;
                            String string2 = string;
                            return string2;
                        }
                    }
                    if (!((Boolean)predicate.invoke((Object)line)).booleanValue()) continue;
                    String string = line;
                    String string3 = string;
                    return string3;
                }
                Unit unit = Unit.INSTANCE;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable2, (Throwable)throwable);
            }
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)object);
        }
        return null;
    }
}

