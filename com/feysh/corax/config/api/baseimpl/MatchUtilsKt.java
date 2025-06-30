/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Function
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function10
 *  kotlin.jvm.functions.Function11
 *  kotlin.jvm.functions.Function12
 *  kotlin.jvm.functions.Function13
 *  kotlin.jvm.functions.Function14
 *  kotlin.jvm.functions.Function15
 *  kotlin.jvm.functions.Function16
 *  kotlin.jvm.functions.Function17
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.functions.Function7
 *  kotlin.jvm.functions.Function8
 *  kotlin.jvm.functions.Function9
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.config.api.baseimpl;

import com.feysh.corax.config.api.AIAnalysisApi;
import com.feysh.corax.config.api.baseimpl.PackageDeclare;
import com.feysh.corax.config.api.baseimpl.RawSignatureMatch;
import com.feysh.corax.config.api.baseimpl.SootSignatureMatch;
import com.feysh.corax.config.api.utils.KFunctionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u00b8\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003\u001a\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0003\u001a'\u0010\u0011\u001a\u00020\b*\u00020\b2\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0013\"\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\b*\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\b*\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u001a+\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00032\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001b0\u001e\u00a2\u0006\u0002\b \u001a\u001a\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\"0#\u001a+\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H%0\u001e\u00a2\u0006\u0002\b \u001a\u001a\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H%0#\u001a&\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H\"0\u001e\u001a7\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(2\u001d\u0010\u0005\u001a\u0019\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H%0)\u00a2\u0006\u0002\b \u001a&\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H%0\u001e\u001a2\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*2\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H\"0)\u001aC\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*2#\u0010\u0005\u001a\u001f\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H%0+\u00a2\u0006\u0002\b \u001a2\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*2\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H%0)\u001a>\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,2\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H\"0+\u001aO\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,2)\u0010\u0005\u001a%\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H%0-\u00a2\u0006\u0002\b \u001a>\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,2\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H%0+\u001aJ\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.2$\u0010\u0005\u001a \u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H\"0-\u001a[\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.2/\u0010\u0005\u001a+\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H%0/\u00a2\u0006\u0002\b \u001aJ\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.2$\u0010\u0005\u001a \u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H%0-\u001aV\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u001002*\u0010\u0005\u001a&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H\"0/\u001ag\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u0010025\u0010\u0005\u001a1\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H%01\u00a2\u0006\u0002\b \u001aV\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u001002*\u0010\u0005\u001a&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H%0/\u001ab\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u0010220\u0010\u0005\u001a,\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H\"01\u001as\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u001022;\u0010\u0005\u001a7\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H%03\u00a2\u0006\u0002\b \u001ab\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u0010220\u0010\u0005\u001a,\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H%01\u001an\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u0010426\u0010\u0005\u001a2\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H\"03\u001a\u007f\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u001042A\u0010\u0005\u001a=\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H%05\u00a2\u0006\u0002\b \u001an\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u0010426\u0010\u0005\u001a2\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H%03\u001az\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u001062<\u0010\u0005\u001a8\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H\"05\u001a\u008b\u0001\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u00104\"\u0004\b\t\u001062G\u0010\u0005\u001aC\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H%07\u00a2\u0006\u0002\b \u001az\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u001062<\u0010\u0005\u001a8\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H%05\u001a\u0086\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u001082B\u0010\u0005\u001a>\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H\"07\u001a\u0097\u0001\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u00104\"\u0004\b\t\u00106\"\u0004\b\n\u001082M\u0010\u0005\u001aI\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H%09\u00a2\u0006\u0002\b \u001a\u0086\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u001082B\u0010\u0005\u001a>\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H%07\u001a\u0092\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:2H\u0010\u0005\u001aD\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H\"09\u001a\u00a3\u0001\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u00104\"\u0004\b\t\u00106\"\u0004\b\n\u00108\"\u0004\b\u000b\u0010:2S\u0010\u0005\u001aO\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H%0;\u00a2\u0006\u0002\b \u001a\u0092\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:2H\u0010\u0005\u001aD\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H%09\u001a\u009e\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<2N\u0010\u0005\u001aJ\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H\"0;\u001a\u00af\u0001\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u00104\"\u0004\b\t\u00106\"\u0004\b\n\u00108\"\u0004\b\u000b\u0010:\"\u0004\b\f\u0010<2Y\u0010\u0005\u001aU\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H%0=\u00a2\u0006\u0002\b \u001a\u009e\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<2N\u0010\u0005\u001aJ\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H%0;\u001a\u00aa\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>2T\u0010\u0005\u001aP\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H\"0=\u001a\u00bb\u0001\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u00104\"\u0004\b\t\u00106\"\u0004\b\n\u00108\"\u0004\b\u000b\u0010:\"\u0004\b\f\u0010<\"\u0004\b\r\u0010>2_\u0010\u0005\u001a[\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H%0?\u00a2\u0006\u0002\b \u001a\u00aa\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>2T\u0010\u0005\u001aP\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H%0=\u001a\u00b6\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>\"\u0004\b\r\u0010@2Z\u0010\u0005\u001aV\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002H\"0?\u001a\u00c7\u0001\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u00104\"\u0004\b\t\u00106\"\u0004\b\n\u00108\"\u0004\b\u000b\u0010:\"\u0004\b\f\u0010<\"\u0004\b\r\u0010>\"\u0004\b\u000e\u0010@2e\u0010\u0005\u001aa\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002H%0A\u00a2\u0006\u0002\b \u001a\u00b6\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>\"\u0004\b\r\u0010@2Z\u0010\u0005\u001aV\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002H%0?\u001a\u00c2\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>\"\u0004\b\r\u0010@\"\u0004\b\u000e\u0010B2`\u0010\u0005\u001a\\\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002H\"0A\u001a\u00d3\u0001\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u00104\"\u0004\b\t\u00106\"\u0004\b\n\u00108\"\u0004\b\u000b\u0010:\"\u0004\b\f\u0010<\"\u0004\b\r\u0010>\"\u0004\b\u000e\u0010@\"\u0004\b\u000f\u0010B2k\u0010\u0005\u001ag\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002H%0C\u00a2\u0006\u0002\b \u001a\u00c2\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>\"\u0004\b\r\u0010@\"\u0004\b\u000e\u0010B2`\u0010\u0005\u001a\\\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002H%0A\u001a\u00ce\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>\"\u0004\b\r\u0010@\"\u0004\b\u000e\u0010B\"\u0004\b\u000f\u0010D2f\u0010\u0005\u001ab\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002H\"0C\u001a\u00df\u0001\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u00104\"\u0004\b\t\u00106\"\u0004\b\n\u00108\"\u0004\b\u000b\u0010:\"\u0004\b\f\u0010<\"\u0004\b\r\u0010>\"\u0004\b\u000e\u0010@\"\u0004\b\u000f\u0010B\"\u0004\b\u0010\u0010D2q\u0010\u0005\u001am\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002H%0E\u00a2\u0006\u0002\b \u001a\u00ce\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>\"\u0004\b\r\u0010@\"\u0004\b\u000e\u0010B\"\u0004\b\u000f\u0010D2f\u0010\u0005\u001ab\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002H%0C\u001a\u00da\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>\"\u0004\b\r\u0010@\"\u0004\b\u000e\u0010B\"\u0004\b\u000f\u0010D\"\u0004\b\u0010\u0010F2l\u0010\u0005\u001ah\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002H\"0E\u001a\u00eb\u0001\u0010$\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010(\"\u0004\b\u0003\u0010*\"\u0004\b\u0004\u0010,\"\u0004\b\u0005\u0010.\"\u0004\b\u0006\u00100\"\u0004\b\u0007\u00102\"\u0004\b\b\u00104\"\u0004\b\t\u00106\"\u0004\b\n\u00108\"\u0004\b\u000b\u0010:\"\u0004\b\f\u0010<\"\u0004\b\r\u0010>\"\u0004\b\u000e\u0010@\"\u0004\b\u000f\u0010B\"\u0004\b\u0010\u0010D\"\u0004\b\u0011\u0010F2w\u0010\u0005\u001as\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002H%0G\u00a2\u0006\u0002\b \u001a\u00da\u0001\u0010'\u001a\u00020\u0001\"\u0004\b\u0000\u0010%\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010*\"\u0004\b\u0003\u0010,\"\u0004\b\u0004\u0010.\"\u0004\b\u0005\u00100\"\u0004\b\u0006\u00102\"\u0004\b\u0007\u00104\"\u0004\b\b\u00106\"\u0004\b\t\u00108\"\u0004\b\n\u0010:\"\u0004\b\u000b\u0010<\"\u0004\b\f\u0010>\"\u0004\b\r\u0010@\"\u0004\b\u000e\u0010B\"\u0004\b\u000f\u0010D\"\u0004\b\u0010\u0010F2l\u0010\u0005\u001ah\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H>\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002H%0E\"\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006H"}, d2={"matchSoot", "Lcom/feysh/corax/config/api/baseimpl/SootSignatureMatch;", "sootSignature", "", "match", "function", "Lkotlin/Function;", "matchMethodName", "Lcom/feysh/corax/config/api/baseimpl/RawSignatureMatch;", "class", "methodName", "patternSimpleSig", "Ljava/util/regex/Pattern;", "getPatternSimpleSig", "()Ljava/util/regex/Pattern;", "matchSimpleSig", "sig", "matchParameters", "parameters", "", "(Lcom/feysh/corax/config/api/baseimpl/RawSignatureMatch;[Ljava/lang/String;)Lcom/feysh/corax/config/api/baseimpl/RawSignatureMatch;", "matchFunctionType", "actualType", "Lcom/feysh/corax/config/api/utils/KFunctionType;", "matchReturnType", "returnType", "package", "", "Lcom/feysh/corax/config/api/AIAnalysisApi;", "block", "Lkotlin/Function1;", "Lcom/feysh/corax/config/api/baseimpl/PackageDeclare;", "Lkotlin/ExtensionFunctionType;", "matchConstructor", "This", "Lkotlin/Function0;", "matchMethod", "R", "THIS", "matchStaticMethod", "P0", "Lkotlin/Function2;", "P1", "Lkotlin/Function3;", "P2", "Lkotlin/Function4;", "P3", "Lkotlin/Function5;", "P4", "Lkotlin/Function6;", "P5", "Lkotlin/Function7;", "P6", "Lkotlin/Function8;", "P7", "Lkotlin/Function9;", "P8", "Lkotlin/Function10;", "P9", "Lkotlin/Function11;", "P10", "Lkotlin/Function12;", "P11", "Lkotlin/Function13;", "P12", "Lkotlin/Function14;", "P13", "Lkotlin/Function15;", "P14", "Lkotlin/Function16;", "P15", "Lkotlin/Function17;", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nMatchUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchUtils.kt\ncom/feysh/corax/config/api/baseimpl/MatchUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,220:1\n1557#2:221\n1628#2,3:222\n1#3:225\n*S KotlinDebug\n*F\n+ 1 MatchUtils.kt\ncom/feysh/corax/config/api/baseimpl/MatchUtilsKt\n*L\n43#1:221\n43#1:222,3\n*E\n"})
public final class MatchUtilsKt {
    @NotNull
    private static final Pattern patternSimpleSig;

    @NotNull
    public static final SootSignatureMatch matchSoot(@NotNull String sootSignature) {
        Intrinsics.checkNotNullParameter((Object)sootSignature, (String)"sootSignature");
        return SootSignatureMatch.Companion.invoke(sootSignature);
    }

    @NotNull
    public static final SootSignatureMatch match(@NotNull Function<?> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return SootSignatureMatch.Companion.invoke(function);
    }

    @NotNull
    public static final RawSignatureMatch matchMethodName(@NotNull String string, @NotNull String methodName) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"class");
        Intrinsics.checkNotNullParameter((Object)methodName, (String)"methodName");
        return RawSignatureMatch.Companion.invoke$default(RawSignatureMatch.Companion, string, methodName, null, null, null, 16, null);
    }

    @NotNull
    public static final Pattern getPatternSimpleSig() {
        return patternSimpleSig;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final RawSignatureMatch matchSimpleSig(@NotNull String sig) {
        List list;
        Intrinsics.checkNotNullParameter((Object)sig, (String)"sig");
        Matcher matcher = patternSimpleSig.matcher(sig);
        Intrinsics.checkNotNullExpressionValue((Object)matcher, (String)"matcher(...)");
        Matcher matcher2 = matcher;
        if (!(matcher2.matches() && !StringsKt.startsWith$default((String)sig, (String)"<", (boolean)false, (int)2, null) && !StringsKt.endsWith$default((String)sig, (String)">", (boolean)false, (int)2, null))) {
            boolean $i$a$-require-MatchUtilsKt$matchSimpleSig$22 = false;
            String $i$a$-require-MatchUtilsKt$matchSimpleSig$22 = "invalid java style signature syntax: " + sig + ". eg: \"java.util.Map: Object getOrDefault(Object key, Object defaultValue, *)\"";
            throw new IllegalArgumentException($i$a$-require-MatchUtilsKt$matchSimpleSig$22.toString());
        }
        String clazz = matcher2.group("class");
        String it = matcher2.group("returnType");
        boolean bl = false;
        String returnType = Intrinsics.areEqual((Object)it, (Object)"*") ? null : it;
        String methodName = matcher2.group("methodName");
        String s = matcher2.group("parameters");
        boolean bl2 = false;
        if (Intrinsics.areEqual((Object)s, (Object)"**")) {
            list = null;
        } else {
            Intrinsics.checkNotNull((Object)s);
            if (((CharSequence)s).length() == 0) {
                list = CollectionsKt.emptyList();
            } else {
                void $this$mapTo$iv$iv;
                String[] stringArray = new String[]{","};
                Iterable $this$map$iv = StringsKt.split$default((CharSequence)s, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
                boolean $i$f$map = false;
                Iterable iterable = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it2;
                    String string = (String)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    boolean bl3 = false;
                    collection.add(MatchUtilsKt.matchSimpleSig$extractParameter(sig, (String)it2));
                }
                list = (List)destination$iv$iv;
            }
        }
        List parameters = list;
        Intrinsics.checkNotNull((Object)clazz);
        String[] stringArray = new String[]{"."};
        if (Intrinsics.areEqual((Object)CollectionsKt.last((List)StringsKt.split$default((CharSequence)clazz, (String[])stringArray, (boolean)false, (int)0, (int)6, null)), (Object)methodName)) {
            throw new IllegalStateException(("This is a constructor: " + sig).toString());
        }
        Intrinsics.checkNotNull((Object)methodName);
        return RawSignatureMatch.Companion.invoke$default(RawSignatureMatch.Companion, clazz, methodName, returnType, parameters, null, 16, null);
    }

    @NotNull
    public static final RawSignatureMatch matchParameters(@NotNull RawSignatureMatch $this$matchParameters, String ... parameters) {
        Intrinsics.checkNotNullParameter((Object)$this$matchParameters, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"parameters");
        return new RawSignatureMatch($this$matchParameters.getClazz(), $this$matchParameters.getName(), $this$matchParameters.getReturnType(), ArraysKt.toList((Object[])parameters), $this$matchParameters.getActualType());
    }

    @NotNull
    public static final RawSignatureMatch matchFunctionType(@NotNull RawSignatureMatch $this$matchFunctionType, @Nullable KFunctionType actualType) {
        Intrinsics.checkNotNullParameter((Object)$this$matchFunctionType, (String)"<this>");
        return new RawSignatureMatch($this$matchFunctionType.getClazz(), $this$matchFunctionType.getName(), $this$matchFunctionType.getReturnType(), $this$matchFunctionType.getParameters(), actualType);
    }

    @NotNull
    public static final RawSignatureMatch matchReturnType(@NotNull RawSignatureMatch $this$matchReturnType, @Nullable String returnType) {
        Intrinsics.checkNotNullParameter((Object)$this$matchReturnType, (String)"<this>");
        return new RawSignatureMatch($this$matchReturnType.getClazz(), $this$matchReturnType.getName(), returnType, $this$matchReturnType.getParameters(), $this$matchReturnType.getActualType());
    }

    public static final void package(@NotNull AIAnalysisApi $this$package, @NotNull String string, @NotNull Function1<? super PackageDeclare, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$package, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string, (String)"package");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        block.invoke((Object)new PackageDeclare(string));
    }

    @NotNull
    public static final <This> SootSignatureMatch matchConstructor(@NotNull Function0<? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS> SootSignatureMatch matchMethod(@NotNull Function1<? super THIS, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R> SootSignatureMatch matchStaticMethod(@NotNull Function0<? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0> SootSignatureMatch matchConstructor(@NotNull Function1<? super P0, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0> SootSignatureMatch matchMethod(@NotNull Function2<? super THIS, ? super P0, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0> SootSignatureMatch matchStaticMethod(@NotNull Function1<? super P0, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1> SootSignatureMatch matchConstructor(@NotNull Function2<? super P0, ? super P1, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1> SootSignatureMatch matchMethod(@NotNull Function3<? super THIS, ? super P0, ? super P1, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1> SootSignatureMatch matchStaticMethod(@NotNull Function2<? super P0, ? super P1, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2> SootSignatureMatch matchConstructor(@NotNull Function3<? super P0, ? super P1, ? super P2, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2> SootSignatureMatch matchMethod(@NotNull Function4<? super THIS, ? super P0, ? super P1, ? super P2, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2> SootSignatureMatch matchStaticMethod(@NotNull Function3<? super P0, ? super P1, ? super P2, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3> SootSignatureMatch matchConstructor(@NotNull Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3> SootSignatureMatch matchMethod(@NotNull Function5<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3> SootSignatureMatch matchStaticMethod(@NotNull Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4> SootSignatureMatch matchConstructor(@NotNull Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4> SootSignatureMatch matchMethod(@NotNull Function6<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4> SootSignatureMatch matchStaticMethod(@NotNull Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5> SootSignatureMatch matchConstructor(@NotNull Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5> SootSignatureMatch matchMethod(@NotNull Function7<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5> SootSignatureMatch matchStaticMethod(@NotNull Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6> SootSignatureMatch matchConstructor(@NotNull Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6> SootSignatureMatch matchMethod(@NotNull Function8<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6> SootSignatureMatch matchStaticMethod(@NotNull Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6, P7> SootSignatureMatch matchConstructor(@NotNull Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7> SootSignatureMatch matchMethod(@NotNull Function9<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6, P7> SootSignatureMatch matchStaticMethod(@NotNull Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6, P7, P8> SootSignatureMatch matchConstructor(@NotNull Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8> SootSignatureMatch matchMethod(@NotNull Function10<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6, P7, P8> SootSignatureMatch matchStaticMethod(@NotNull Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> SootSignatureMatch matchConstructor(@NotNull Function10<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> SootSignatureMatch matchMethod(@NotNull Function11<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> SootSignatureMatch matchStaticMethod(@NotNull Function10<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> SootSignatureMatch matchConstructor(@NotNull Function11<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> SootSignatureMatch matchMethod(@NotNull Function12<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> SootSignatureMatch matchStaticMethod(@NotNull Function11<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> SootSignatureMatch matchConstructor(@NotNull Function12<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> SootSignatureMatch matchMethod(@NotNull Function13<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> SootSignatureMatch matchStaticMethod(@NotNull Function12<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> SootSignatureMatch matchConstructor(@NotNull Function13<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> SootSignatureMatch matchMethod(@NotNull Function14<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> SootSignatureMatch matchStaticMethod(@NotNull Function13<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> SootSignatureMatch matchConstructor(@NotNull Function14<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> SootSignatureMatch matchMethod(@NotNull Function15<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> SootSignatureMatch matchStaticMethod(@NotNull Function14<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> SootSignatureMatch matchConstructor(@NotNull Function15<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> SootSignatureMatch matchMethod(@NotNull Function16<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> SootSignatureMatch matchStaticMethod(@NotNull Function15<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <This, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> SootSignatureMatch matchConstructor(@NotNull Function16<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? extends This> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, THIS, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> SootSignatureMatch matchMethod(@NotNull Function17<? super THIS, ? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    @NotNull
    public static final <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> SootSignatureMatch matchStaticMethod(@NotNull Function16<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? extends R> function) {
        Intrinsics.checkNotNullParameter(function, (String)"function");
        return MatchUtilsKt.match((Function)function);
    }

    private static final String matchSimpleSig$extractParameter(String $sig, String str) {
        String[] stringArray;
        String pass1Str = StringsKt.substringBefore$default((String)((Object)StringsKt.trim((CharSequence)str)).toString(), (String)"<", null, (int)2, null);
        List sp = StringsKt.split$default((CharSequence)pass1Str, (String[])(stringArray = new String[]{" "}), (boolean)false, (int)0, (int)6, null);
        if (!(sp.size() <= 2)) {
            boolean bl = false;
            String string = "error syntax signature: " + $sig;
            throw new IllegalArgumentException(string.toString());
        }
        String type = (String)CollectionsKt.first((List)sp);
        return Intrinsics.areEqual((Object)type, (Object)"*") ? null : type;
    }

    static {
        Pattern pattern = Pattern.compile("^(?<class>.*?): (?<returnType>.*?) (?<methodName>.*?)\\((?<parameters>.*?)\\)$");
        Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"compile(...)");
        patternSimpleSig = pattern;
    }
}

