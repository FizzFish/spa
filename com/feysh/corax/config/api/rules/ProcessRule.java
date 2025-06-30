/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KClass
 *  kotlin.text.MatchGroupCollection
 *  kotlin.text.MatchResult
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  kotlin.text.jdk8.RegexExtensionsJDK8Kt
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.EncodeDefault
 *  kotlinx.serialization.EncodeDefault$Mode
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationException
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.SerializersKt
 *  kotlinx.serialization.descriptors.PrimitiveKind
 *  kotlinx.serialization.descriptors.PrimitiveKind$STRING
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.descriptors.SerialDescriptorKt
 *  kotlinx.serialization.descriptors.SerialDescriptorsKt
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.encoding.Decoder
 *  kotlinx.serialization.encoding.Encoder
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonElement
 *  kotlinx.serialization.json.JsonKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.config.api.rules;

import com.feysh.corax.config.api.rules.ProcessRule$ClassMemberMatch$;
import com.feysh.corax.config.api.rules.ProcessRule$ClassPathMatch$;
import com.feysh.corax.config.api.rules.ProcessRule$FileMatch$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.jdk8.RegexExtensionsJDK8Kt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.EncodeDefault;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001:\r\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0086\bJ4\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\n\"\u00020\tH\u0086\b\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0002\u0010\u0013J5\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00160\u0015\"\b\b\u0000\u0010\u0006*\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0018\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u0019\u00a8\u0006'"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule;", "", "<init>", "()V", "cvt", "", "T", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "ruleItems", "", "", "([Ljava/lang/String;)Ljava/util/List;", "isValidOf", "Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "type", "Lcom/feysh/corax/config/api/rules/ProcessRule$Type;", "matcher", "", "str", "(Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Ljava/lang/String;)Ljava/lang/Boolean;", "matches", "Lkotlin/Pair;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ScanAction;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "content", "(Ljava/util/List;Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;)Lkotlin/Pair;", "ScanAction", "ProcRegexBaseSerializer", "ProcRegexBase", "ProcRegex", "Type", "OP", "ErrorCommit", "IMatchTarget", "IMatchItem", "ClassMemberMatch", "ClassPathMatch", "FileMatch", "InlineRuleStringSerialize", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nProcessRule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,373:1\n1557#2:374\n1628#2,3:375\n543#2,6:382\n11165#3:378\n11500#3,3:379\n*S KotlinDebug\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule\n*L\n24#1:374\n24#1:375,3\n314#1:382,6\n27#1:378\n27#1:379,3\n*E\n"})
public final class ProcessRule {
    @NotNull
    public static final ProcessRule INSTANCE = new ProcessRule();

    private ProcessRule() {
    }

    /*
     * WARNING - void declaration
     */
    public final /* synthetic */ <T extends IMatchItem> List<T> cvt(List<String> ruleItems) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(ruleItems, (String)"ruleItems");
        boolean $i$f$cvt = false;
        Iterable $this$map$iv = ruleItems;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            String string = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
            collection.add(InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(IMatchItem.class)), (String)it));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    public final /* synthetic */ <T extends IMatchItem> List<T> cvt(String ... ruleItems) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)ruleItems, (String)"ruleItems");
        boolean $i$f$cvt = false;
        String[] $this$map$iv = ruleItems;
        boolean $i$f$map = false;
        String[] stringArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        for (void item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            String string = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
            collection.add(InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(IMatchItem.class)), (String)it));
        }
        return (List)destination$iv$iv;
    }

    @Nullable
    public final String isValidOf(@NotNull ProcRegexBase $this$isValidOf, @NotNull Type type) {
        Intrinsics.checkNotNullParameter((Object)$this$isValidOf, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        if ($this$isValidOf instanceof ProcRegex) {
            CharSequence charSequence;
            String regex = ((ProcRegex)$this$isValidOf).getRegexExpr();
            return type.isFile() && StringsKt.contains$default((CharSequence)regex, (CharSequence)"\\\\", (boolean)false, (int)2, null) ? "Matching regex for file cannot contains \\ char" : (type.isClassMember() && new Regex("\\\\\\\\|/").containsMatchIn(charSequence = (CharSequence)regex) ? "Matching regex for class cannot contains \\ char" : null);
        }
        return null;
    }

    private final Boolean matcher(ProcRegexBase $this$matcher, String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        return $this$matcher.matches(str);
    }

    @NotNull
    public final <T extends IMatchTarget> Pair<IMatchItem, ScanAction> matches(@NotNull List<? extends IMatchItem> $this$matches, @NotNull T content) {
        IMatchItem ruleItem;
        IMatchItem iMatchItem;
        block7: {
            Intrinsics.checkNotNullParameter($this$matches, (String)"<this>");
            Intrinsics.checkNotNullParameter(content, (String)"content");
            if ($this$matches.isEmpty()) {
                return TuplesKt.to(null, (Object)((Object)ScanAction.Keep));
            }
            List<? extends IMatchItem> $this$lastOrNull$iv = $this$matches;
            boolean $i$f$lastOrNull = false;
            ListIterator<? extends IMatchItem> iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
            while (iterator$iv.hasPrevious()) {
                IMatchItem element$iv;
                IMatchItem it = element$iv = iterator$iv.previous();
                boolean bl = false;
                if (!it.matches(content)) continue;
                iMatchItem = element$iv;
                break block7;
            }
            iMatchItem = null;
        }
        IMatchItem iMatchItem2 = ruleItem = (IMatchItem)iMatchItem;
        OP oP = iMatchItem2 != null ? iMatchItem2.getOp() : null;
        return TuplesKt.to((Object)ruleItem, (Object)((Object)(switch (oP == null ? -1 : WhenMappings.$EnumSwitchMapping$0[oP.ordinal()]) {
            case -1 -> ScanAction.Keep;
            case 1 -> ScanAction.Process;
            case 2 -> ScanAction.Skip;
            default -> throw new NoWhenBranchMatchedException();
        })));
    }

    @Serializable
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0003DEFBW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\f\u0010\rBa\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\f\u0010\u0012J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010/\u001a\u00020,H\u0016J\t\u00100\u001a\u00020\u0004H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J[\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u00108\u001a\u00020$2\b\u00109\u001a\u0004\u0018\u00010:H\u00d6\u0003J\t\u0010;\u001a\u00020\u000fH\u00d6\u0001J%\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0001\u00a2\u0006\u0002\bCR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u0011\u0010#\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010%R\u0011\u0010&\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010%R\u0011\u0010'\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010%R\u0016\u0010+\u001a\u0004\u0018\u00010,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u0006G"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ErrorCommit;", "op", "Lcom/feysh/corax/config/api/rules/ProcessRule$OP;", "classNameMatch", "Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "classSrcMatch", "methodSignatureMatch", "methodNameMatch", "fieldSignatureMatch", "fieldNameMatch", "<init>", "(Lcom/feysh/corax/config/api/rules/ProcessRule$OP;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/feysh/corax/config/api/rules/ProcessRule$OP;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOp", "()Lcom/feysh/corax/config/api/rules/ProcessRule$OP;", "getClassNameMatch$annotations", "()V", "getClassNameMatch", "()Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "getClassSrcMatch$annotations", "getClassSrcMatch", "getMethodSignatureMatch$annotations", "getMethodSignatureMatch", "getMethodNameMatch$annotations", "getMethodNameMatch", "getFieldSignatureMatch$annotations", "getFieldSignatureMatch", "getFieldNameMatch$annotations", "getFieldNameMatch", "isMatchField", "", "()Z", "isMatchMethod", "isMatchClass", "matches", "matchContent", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "error", "", "getError", "()Ljava/lang/String;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_config_api", "MatchTarget", "$serializer", "Companion", "corax-config-api"})
    @SourceDebugExtension(value={"SMAP\nProcessRule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,373:1\n1#2:374\n1863#3,2:375\n*S KotlinDebug\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch\n*L\n205#1:375,2\n*E\n"})
    public static final class ClassMemberMatch
    implements IMatchItem,
    ErrorCommit {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final OP op;
        @Nullable
        private final ProcRegexBase classNameMatch;
        @Nullable
        private final ProcRegexBase classSrcMatch;
        @Nullable
        private final ProcRegexBase methodSignatureMatch;
        @Nullable
        private final ProcRegexBase methodNameMatch;
        @Nullable
        private final ProcRegexBase fieldSignatureMatch;
        @Nullable
        private final ProcRegexBase fieldNameMatch;
        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers;

        public ClassMemberMatch(@NotNull OP op, @Nullable ProcRegexBase classNameMatch, @Nullable ProcRegexBase classSrcMatch, @Nullable ProcRegexBase methodSignatureMatch, @Nullable ProcRegexBase methodNameMatch, @Nullable ProcRegexBase fieldSignatureMatch, @Nullable ProcRegexBase fieldNameMatch) {
            Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
            this.op = op;
            this.classNameMatch = classNameMatch;
            this.classSrcMatch = classSrcMatch;
            this.methodSignatureMatch = methodSignatureMatch;
            this.methodNameMatch = methodNameMatch;
            this.fieldSignatureMatch = fieldSignatureMatch;
            this.fieldNameMatch = fieldNameMatch;
        }

        public /* synthetic */ ClassMemberMatch(OP oP, ProcRegexBase procRegexBase, ProcRegexBase procRegexBase2, ProcRegexBase procRegexBase3, ProcRegexBase procRegexBase4, ProcRegexBase procRegexBase5, ProcRegexBase procRegexBase6, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                procRegexBase = null;
            }
            if ((n & 4) != 0) {
                procRegexBase2 = null;
            }
            if ((n & 8) != 0) {
                procRegexBase3 = null;
            }
            if ((n & 0x10) != 0) {
                procRegexBase4 = null;
            }
            if ((n & 0x20) != 0) {
                procRegexBase5 = null;
            }
            if ((n & 0x40) != 0) {
                procRegexBase6 = null;
            }
            this(oP, procRegexBase, procRegexBase2, procRegexBase3, procRegexBase4, procRegexBase5, procRegexBase6);
        }

        @Override
        @NotNull
        public OP getOp() {
            return this.op;
        }

        @Nullable
        public final ProcRegexBase getClassNameMatch() {
            return this.classNameMatch;
        }

        @EncodeDefault(mode=EncodeDefault.Mode.NEVER)
        @SerialName(value="class:name")
        public static /* synthetic */ void getClassNameMatch$annotations() {
        }

        @Nullable
        public final ProcRegexBase getClassSrcMatch() {
            return this.classSrcMatch;
        }

        @EncodeDefault(mode=EncodeDefault.Mode.NEVER)
        @SerialName(value="class:src")
        public static /* synthetic */ void getClassSrcMatch$annotations() {
        }

        @Nullable
        public final ProcRegexBase getMethodSignatureMatch() {
            return this.methodSignatureMatch;
        }

        @EncodeDefault(mode=EncodeDefault.Mode.NEVER)
        @SerialName(value="method:signature")
        public static /* synthetic */ void getMethodSignatureMatch$annotations() {
        }

        @Nullable
        public final ProcRegexBase getMethodNameMatch() {
            return this.methodNameMatch;
        }

        @EncodeDefault(mode=EncodeDefault.Mode.NEVER)
        @SerialName(value="method:name")
        public static /* synthetic */ void getMethodNameMatch$annotations() {
        }

        @Nullable
        public final ProcRegexBase getFieldSignatureMatch() {
            return this.fieldSignatureMatch;
        }

        @EncodeDefault(mode=EncodeDefault.Mode.NEVER)
        @SerialName(value="field:signature")
        public static /* synthetic */ void getFieldSignatureMatch$annotations() {
        }

        @Nullable
        public final ProcRegexBase getFieldNameMatch() {
            return this.fieldNameMatch;
        }

        @EncodeDefault(mode=EncodeDefault.Mode.NEVER)
        @SerialName(value="field:name")
        public static /* synthetic */ void getFieldNameMatch$annotations() {
        }

        public final boolean isMatchField() {
            return this.fieldSignatureMatch != null || this.fieldNameMatch != null;
        }

        public final boolean isMatchMethod() {
            return this.methodSignatureMatch != null || this.methodNameMatch != null;
        }

        public final boolean isMatchClass() {
            return this.classSrcMatch != null || this.classNameMatch != null;
        }

        @Override
        public boolean matches(@NotNull IMatchTarget matchContent) {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            boolean it;
            Intrinsics.checkNotNullParameter((Object)matchContent, (String)"matchContent");
            if (!(matchContent instanceof MatchTarget)) {
                return false;
            }
            boolean anyMatch = false;
            Object object6 = this.classSrcMatch;
            if (object6 != null && (object6 = INSTANCE.matcher((ProcRegexBase)object6, ((MatchTarget)matchContent).getClassSrc())) != null) {
                it = (Boolean)object6;
                boolean bl = false;
                if (it) {
                    anyMatch = true;
                } else {
                    return false;
                }
            }
            if ((object5 = this.classNameMatch) != null && (object5 = INSTANCE.matcher((ProcRegexBase)object5, ((MatchTarget)matchContent).getClassName())) != null) {
                it = (Boolean)object5;
                boolean bl = false;
                if (it) {
                    anyMatch = true;
                } else {
                    return false;
                }
            }
            if ((object4 = this.methodSignatureMatch) != null && (object4 = INSTANCE.matcher((ProcRegexBase)object4, ((MatchTarget)matchContent).getMethodSignature())) != null) {
                it = (Boolean)object4;
                boolean bl = false;
                if (it) {
                    anyMatch = true;
                } else {
                    return false;
                }
            }
            if ((object3 = this.methodNameMatch) != null && (object3 = INSTANCE.matcher((ProcRegexBase)object3, ((MatchTarget)matchContent).getMethodName())) != null) {
                it = (Boolean)object3;
                boolean bl = false;
                if (it) {
                    anyMatch = true;
                } else {
                    return false;
                }
            }
            if ((object2 = this.fieldSignatureMatch) != null && (object2 = INSTANCE.matcher((ProcRegexBase)object2, ((MatchTarget)matchContent).getFieldSignature())) != null) {
                it = (Boolean)object2;
                boolean bl = false;
                if (it) {
                    anyMatch = true;
                } else {
                    return false;
                }
            }
            if ((object = this.fieldNameMatch) != null && (object = INSTANCE.matcher((ProcRegexBase)object, ((MatchTarget)matchContent).getFieldName())) != null) {
                it = (Boolean)object;
                boolean bl = false;
                if (it) {
                    anyMatch = true;
                } else {
                    return false;
                }
            }
            return anyMatch;
        }

        @Override
        @Nullable
        public String getError() {
            Object[] objectArray;
            Object[] objectArray2;
            Object[] it = objectArray2 = Unit.INSTANCE;
            boolean bl = false;
            Object object = objectArray = !this.isMatchClass() && !this.isMatchMethod() && !this.isMatchField() ? objectArray2 : null;
            if (objectArray != null) {
                it = objectArray;
                boolean bl2 = false;
                return "empty ClassMemberMatch";
            }
            objectArray = new Pair[]{TuplesKt.to((Object)this.classSrcMatch, (Object)((Object)Type.File)), TuplesKt.to((Object)this.classNameMatch, (Object)((Object)Type.Class)), TuplesKt.to((Object)this.methodSignatureMatch, (Object)((Object)Type.Method)), TuplesKt.to((Object)this.methodNameMatch, (Object)((Object)Type.Method)), TuplesKt.to((Object)this.fieldSignatureMatch, (Object)((Object)Type.Field)), TuplesKt.to((Object)this.fieldNameMatch, (Object)((Object)Type.Field))};
            Iterable $this$forEach$iv = CollectionsKt.listOf((Object[])objectArray);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Pair pair = (Pair)element$iv;
                boolean bl3 = false;
                ProcRegexBase regex = (ProcRegexBase)pair.component1();
                Type type = (Type)((Object)pair.component2());
                Object object2 = regex;
                if (object2 == null || (object2 = INSTANCE.isValidOf((ProcRegexBase)object2, type)) == null) continue;
                Object it2 = object2;
                boolean bl4 = false;
                return it2;
            }
            if (this.isMatchField() && this.isMatchMethod()) {
                return "The use of both class methods and class fields in the matching is not permitted.";
            }
            return null;
        }

        @NotNull
        public String toString() {
            Object object = new ArrayList();
            List it = object;
            boolean bl = false;
            if (this.isMatchClass()) {
                ((Collection)it).add("class:name=" + this.classNameMatch);
                ((Collection)it).add("class:src=" + this.classSrcMatch);
            }
            if (this.isMatchMethod()) {
                ((Collection)it).add("method:name=" + this.methodNameMatch);
                ((Collection)it).add("method:signature=" + this.methodSignatureMatch);
            }
            if (this.isMatchField()) {
                ((Collection)it).add("field:name=" + this.fieldNameMatch);
                ((Collection)it).add("field:signature=" + this.fieldSignatureMatch);
            }
            List list = object;
            object = "(" + this.getOp().getPretty() + ")";
            return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)", ", (CharSequence)((CharSequence)object), (CharSequence)"", (int)0, null, null, (int)56, null);
        }

        @NotNull
        public final OP component1() {
            return this.op;
        }

        @Nullable
        public final ProcRegexBase component2() {
            return this.classNameMatch;
        }

        @Nullable
        public final ProcRegexBase component3() {
            return this.classSrcMatch;
        }

        @Nullable
        public final ProcRegexBase component4() {
            return this.methodSignatureMatch;
        }

        @Nullable
        public final ProcRegexBase component5() {
            return this.methodNameMatch;
        }

        @Nullable
        public final ProcRegexBase component6() {
            return this.fieldSignatureMatch;
        }

        @Nullable
        public final ProcRegexBase component7() {
            return this.fieldNameMatch;
        }

        @NotNull
        public final ClassMemberMatch copy(@NotNull OP op, @Nullable ProcRegexBase classNameMatch, @Nullable ProcRegexBase classSrcMatch, @Nullable ProcRegexBase methodSignatureMatch, @Nullable ProcRegexBase methodNameMatch, @Nullable ProcRegexBase fieldSignatureMatch, @Nullable ProcRegexBase fieldNameMatch) {
            Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
            return new ClassMemberMatch(op, classNameMatch, classSrcMatch, methodSignatureMatch, methodNameMatch, fieldSignatureMatch, fieldNameMatch);
        }

        public static /* synthetic */ ClassMemberMatch copy$default(ClassMemberMatch classMemberMatch, OP oP, ProcRegexBase procRegexBase, ProcRegexBase procRegexBase2, ProcRegexBase procRegexBase3, ProcRegexBase procRegexBase4, ProcRegexBase procRegexBase5, ProcRegexBase procRegexBase6, int n, Object object) {
            if ((n & 1) != 0) {
                oP = classMemberMatch.op;
            }
            if ((n & 2) != 0) {
                procRegexBase = classMemberMatch.classNameMatch;
            }
            if ((n & 4) != 0) {
                procRegexBase2 = classMemberMatch.classSrcMatch;
            }
            if ((n & 8) != 0) {
                procRegexBase3 = classMemberMatch.methodSignatureMatch;
            }
            if ((n & 0x10) != 0) {
                procRegexBase4 = classMemberMatch.methodNameMatch;
            }
            if ((n & 0x20) != 0) {
                procRegexBase5 = classMemberMatch.fieldSignatureMatch;
            }
            if ((n & 0x40) != 0) {
                procRegexBase6 = classMemberMatch.fieldNameMatch;
            }
            return classMemberMatch.copy(oP, procRegexBase, procRegexBase2, procRegexBase3, procRegexBase4, procRegexBase5, procRegexBase6);
        }

        public int hashCode() {
            int result = this.op.hashCode();
            result = result * 31 + (this.classNameMatch == null ? 0 : this.classNameMatch.hashCode());
            result = result * 31 + (this.classSrcMatch == null ? 0 : this.classSrcMatch.hashCode());
            result = result * 31 + (this.methodSignatureMatch == null ? 0 : this.methodSignatureMatch.hashCode());
            result = result * 31 + (this.methodNameMatch == null ? 0 : this.methodNameMatch.hashCode());
            result = result * 31 + (this.fieldSignatureMatch == null ? 0 : this.fieldSignatureMatch.hashCode());
            result = result * 31 + (this.fieldNameMatch == null ? 0 : this.fieldNameMatch.hashCode());
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClassMemberMatch)) {
                return false;
            }
            ClassMemberMatch classMemberMatch = (ClassMemberMatch)other;
            if (this.op != classMemberMatch.op) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.classNameMatch, (Object)classMemberMatch.classNameMatch)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.classSrcMatch, (Object)classMemberMatch.classSrcMatch)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.methodSignatureMatch, (Object)classMemberMatch.methodSignatureMatch)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.methodNameMatch, (Object)classMemberMatch.methodNameMatch)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.fieldSignatureMatch, (Object)classMemberMatch.fieldSignatureMatch)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.fieldNameMatch, (Object)classMemberMatch.fieldNameMatch);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$corax_config_api(ClassMemberMatch self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArray = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.getOp());
            if (self.classNameMatch != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy)ProcRegexBaseSerializer.INSTANCE, (Object)self.classNameMatch);
            }
            if (self.classSrcMatch != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)ProcRegexBaseSerializer.INSTANCE, (Object)self.classSrcMatch);
            }
            if (self.methodSignatureMatch != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)ProcRegexBaseSerializer.INSTANCE, (Object)self.methodSignatureMatch);
            }
            if (self.methodNameMatch != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)ProcRegexBaseSerializer.INSTANCE, (Object)self.methodNameMatch);
            }
            if (self.fieldSignatureMatch != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy)ProcRegexBaseSerializer.INSTANCE, (Object)self.fieldSignatureMatch);
            }
            if (self.fieldNameMatch != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy)ProcRegexBaseSerializer.INSTANCE, (Object)self.fieldNameMatch);
            }
        }

        public /* synthetic */ ClassMemberMatch(int seen0, OP op, ProcRegexBase classNameMatch, ProcRegexBase classSrcMatch, ProcRegexBase methodSignatureMatch, ProcRegexBase methodNameMatch, ProcRegexBase fieldSignatureMatch, ProcRegexBase fieldNameMatch, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (1 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)ClassMemberMatch$$serializer.INSTANCE.getDescriptor());
            }
            this.op = op;
            this.classNameMatch = (seen0 & 2) == 0 ? null : classNameMatch;
            this.classSrcMatch = (seen0 & 4) == 0 ? null : classSrcMatch;
            this.methodSignatureMatch = (seen0 & 8) == 0 ? null : methodSignatureMatch;
            this.methodNameMatch = (seen0 & 0x10) == 0 ? null : methodNameMatch;
            this.fieldSignatureMatch = (seen0 & 0x20) == 0 ? null : fieldSignatureMatch;
            this.fieldNameMatch = (seen0 & 0x40) == 0 ? null : fieldNameMatch;
        }

        public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            KSerializer[] kSerializerArray = new KSerializer[]{EnumsKt.createSimpleEnumSerializer((String)"com.feysh.corax.config.api.rules.ProcessRule.OP", (Enum[])OP.values()), null, null, null, null, null, null};
            $childSerializers = kSerializerArray;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch;", "corax-config-api"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ClassMemberMatch> serializer() {
                return (KSerializer)ClassMemberMatch$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JQ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006&"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch$MatchTarget;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "className", "", "classSrc", "methodSignature", "methodName", "fieldSignature", "fieldName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "getClassSrc", "getMethodSignature", "getMethodName", "getFieldSignature", "getFieldName", "type", "getType", "isMatchField", "", "()Z", "isMatchMethod", "isMatchClass", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "corax-config-api"})
        public static final class MatchTarget
        implements IMatchTarget {
            @Nullable
            private final String className;
            @Nullable
            private final String classSrc;
            @Nullable
            private final String methodSignature;
            @Nullable
            private final String methodName;
            @Nullable
            private final String fieldSignature;
            @Nullable
            private final String fieldName;

            public MatchTarget(@Nullable String className, @Nullable String classSrc, @Nullable String methodSignature, @Nullable String methodName, @Nullable String fieldSignature, @Nullable String fieldName) {
                this.className = className;
                this.classSrc = classSrc;
                this.methodSignature = methodSignature;
                this.methodName = methodName;
                this.fieldSignature = fieldSignature;
                this.fieldName = fieldName;
            }

            @Nullable
            public final String getClassName() {
                return this.className;
            }

            @Nullable
            public final String getClassSrc() {
                return this.classSrc;
            }

            @Nullable
            public final String getMethodSignature() {
                return this.methodSignature;
            }

            @Nullable
            public final String getMethodName() {
                return this.methodName;
            }

            @Nullable
            public final String getFieldSignature() {
                return this.fieldSignature;
            }

            @Nullable
            public final String getFieldName() {
                return this.fieldName;
            }

            @Override
            @NotNull
            public String getType() {
                List list;
                List it = list = (List)new ArrayList();
                boolean bl = false;
                if (this.isMatchClass()) {
                    ((Collection)it).add("class");
                }
                if (this.isMatchMethod()) {
                    ((Collection)it).add("method");
                }
                if (this.isMatchField()) {
                    ((Collection)it).add("field");
                }
                return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)"_", (CharSequence)"", (CharSequence)"", (int)0, null, null, (int)56, null);
            }

            public final boolean isMatchField() {
                return this.fieldSignature != null || this.fieldName != null;
            }

            public final boolean isMatchMethod() {
                return this.methodSignature != null || this.methodName != null;
            }

            public final boolean isMatchClass() {
                return this.className != null || this.classSrc != null;
            }

            @NotNull
            public String toString() {
                Object object = new ArrayList();
                List it = object;
                boolean bl = false;
                if (this.isMatchClass()) {
                    ((Collection)it).add("class:name=" + this.className);
                    ((Collection)it).add("class:src=" + this.classSrc);
                }
                if (this.isMatchMethod()) {
                    ((Collection)it).add("method:name=" + this.methodName);
                    ((Collection)it).add("method:signature=" + this.methodSignature);
                }
                if (this.isMatchField()) {
                    ((Collection)it).add("field:name=" + this.fieldName);
                    ((Collection)it).add("field:signature=" + this.fieldSignature);
                }
                List list = object;
                object = this.getType() + ": { ";
                return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)", ", (CharSequence)((CharSequence)object), (CharSequence)" }", (int)0, null, null, (int)56, null);
            }

            @Nullable
            public final String component1() {
                return this.className;
            }

            @Nullable
            public final String component2() {
                return this.classSrc;
            }

            @Nullable
            public final String component3() {
                return this.methodSignature;
            }

            @Nullable
            public final String component4() {
                return this.methodName;
            }

            @Nullable
            public final String component5() {
                return this.fieldSignature;
            }

            @Nullable
            public final String component6() {
                return this.fieldName;
            }

            @NotNull
            public final MatchTarget copy(@Nullable String className, @Nullable String classSrc, @Nullable String methodSignature, @Nullable String methodName, @Nullable String fieldSignature, @Nullable String fieldName) {
                return new MatchTarget(className, classSrc, methodSignature, methodName, fieldSignature, fieldName);
            }

            public static /* synthetic */ MatchTarget copy$default(MatchTarget matchTarget, String string, String string2, String string3, String string4, String string5, String string6, int n, Object object) {
                if ((n & 1) != 0) {
                    string = matchTarget.className;
                }
                if ((n & 2) != 0) {
                    string2 = matchTarget.classSrc;
                }
                if ((n & 4) != 0) {
                    string3 = matchTarget.methodSignature;
                }
                if ((n & 8) != 0) {
                    string4 = matchTarget.methodName;
                }
                if ((n & 0x10) != 0) {
                    string5 = matchTarget.fieldSignature;
                }
                if ((n & 0x20) != 0) {
                    string6 = matchTarget.fieldName;
                }
                return matchTarget.copy(string, string2, string3, string4, string5, string6);
            }

            public int hashCode() {
                int result = this.className == null ? 0 : this.className.hashCode();
                result = result * 31 + (this.classSrc == null ? 0 : this.classSrc.hashCode());
                result = result * 31 + (this.methodSignature == null ? 0 : this.methodSignature.hashCode());
                result = result * 31 + (this.methodName == null ? 0 : this.methodName.hashCode());
                result = result * 31 + (this.fieldSignature == null ? 0 : this.fieldSignature.hashCode());
                result = result * 31 + (this.fieldName == null ? 0 : this.fieldName.hashCode());
                return result;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MatchTarget)) {
                    return false;
                }
                MatchTarget matchTarget = (MatchTarget)other;
                if (!Intrinsics.areEqual((Object)this.className, (Object)matchTarget.className)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.classSrc, (Object)matchTarget.classSrc)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.methodSignature, (Object)matchTarget.methodSignature)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.methodName, (Object)matchTarget.methodName)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.fieldSignature, (Object)matchTarget.fieldSignature)) {
                    return false;
                }
                return Intrinsics.areEqual((Object)this.fieldName, (Object)matchTarget.fieldName);
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0003,-.B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\t\u0010\u001d\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"H\u00d6\u0003J\t\u0010#\u001a\u00020\nH\u00d6\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001\u00a2\u0006\u0002\b+R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006/"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ErrorCommit;", "op", "Lcom/feysh/corax/config/api/rules/ProcessRule$OP;", "path", "Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "<init>", "(Lcom/feysh/corax/config/api/rules/ProcessRule$OP;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/feysh/corax/config/api/rules/ProcessRule$OP;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOp", "()Lcom/feysh/corax/config/api/rules/ProcessRule$OP;", "getPath$annotations", "()V", "getPath", "()Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "matches", "", "matchContent", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "error", "", "getError", "()Ljava/lang/String;", "toString", "component1", "component2", "copy", "equals", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_config_api", "MatchTarget", "$serializer", "Companion", "corax-config-api"})
    @SourceDebugExtension(value={"SMAP\nProcessRule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,373:1\n1#2:374\n*E\n"})
    public static final class ClassPathMatch
    implements IMatchItem,
    ErrorCommit {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final OP op;
        @NotNull
        private final ProcRegexBase path;
        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers;

        public ClassPathMatch(@NotNull OP op, @NotNull ProcRegexBase path) {
            Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
            Intrinsics.checkNotNullParameter((Object)path, (String)"path");
            this.op = op;
            this.path = path;
        }

        @Override
        @NotNull
        public OP getOp() {
            return this.op;
        }

        @NotNull
        public final ProcRegexBase getPath() {
            return this.path;
        }

        @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
        @SerialName(value="path")
        public static /* synthetic */ void getPath$annotations() {
        }

        @Override
        public boolean matches(@NotNull IMatchTarget matchContent) {
            Intrinsics.checkNotNullParameter((Object)matchContent, (String)"matchContent");
            if (!(matchContent instanceof MatchTarget)) {
                return false;
            }
            boolean anyMatch = false;
            Boolean bl = INSTANCE.matcher(this.path, ((MatchTarget)matchContent).getPath());
            if (bl != null) {
                boolean it = bl;
                boolean bl2 = false;
                if (it) {
                    anyMatch = true;
                } else {
                    return false;
                }
            }
            return anyMatch;
        }

        @Override
        @Nullable
        public String getError() {
            String string = INSTANCE.isValidOf(this.path, Type.File);
            if (string != null) {
                String it = string;
                boolean bl = false;
                return it;
            }
            return null;
        }

        @NotNull
        public String toString() {
            Object object = new ArrayList();
            List it = object;
            boolean bl = false;
            ((Collection)it).add("path=" + this.path);
            List list = object;
            object = "(" + this.getOp().getPretty() + ")";
            return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)", ", (CharSequence)((CharSequence)object), (CharSequence)"", (int)0, null, null, (int)56, null);
        }

        @NotNull
        public final OP component1() {
            return this.op;
        }

        @NotNull
        public final ProcRegexBase component2() {
            return this.path;
        }

        @NotNull
        public final ClassPathMatch copy(@NotNull OP op, @NotNull ProcRegexBase path) {
            Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
            Intrinsics.checkNotNullParameter((Object)path, (String)"path");
            return new ClassPathMatch(op, path);
        }

        public static /* synthetic */ ClassPathMatch copy$default(ClassPathMatch classPathMatch, OP oP, ProcRegexBase procRegexBase, int n, Object object) {
            if ((n & 1) != 0) {
                oP = classPathMatch.op;
            }
            if ((n & 2) != 0) {
                procRegexBase = classPathMatch.path;
            }
            return classPathMatch.copy(oP, procRegexBase);
        }

        public int hashCode() {
            int result = this.op.hashCode();
            result = result * 31 + this.path.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClassPathMatch)) {
                return false;
            }
            ClassPathMatch classPathMatch = (ClassPathMatch)other;
            if (this.op != classPathMatch.op) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.path, (Object)classPathMatch.path);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$corax_config_api(ClassPathMatch self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArray = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.getOp());
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)ProcRegexBaseSerializer.INSTANCE, (Object)self.path);
        }

        public /* synthetic */ ClassPathMatch(int seen0, OP op, ProcRegexBase path, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)ClassPathMatch$$serializer.INSTANCE.getDescriptor());
            }
            this.op = op;
            this.path = path;
        }

        public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            KSerializer[] kSerializerArray = new KSerializer[]{EnumsKt.createSimpleEnumSerializer((String)"com.feysh.corax.config.api.rules.ProcessRule.OP", (Enum[])OP.values()), null};
            $childSerializers = kSerializerArray;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch;", "corax-config-api"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ClassPathMatch> serializer() {
                return (KSerializer)ClassPathMatch$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch$MatchTarget;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "type", "getType", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "corax-config-api"})
        public static final class MatchTarget
        implements IMatchTarget {
            @Nullable
            private final String path;

            public MatchTarget(@Nullable String path) {
                this.path = path;
            }

            @Nullable
            public final String getPath() {
                return this.path;
            }

            @Override
            @NotNull
            public String getType() {
                return "classpath";
            }

            @NotNull
            public String toString() {
                Object object = new ArrayList();
                List it = object;
                boolean bl = false;
                if (this.path != null) {
                    ((Collection)it).add("path=" + this.path);
                }
                List list = object;
                object = this.getType() + ": { ";
                return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)", ", (CharSequence)((CharSequence)object), (CharSequence)" }", (int)0, null, null, (int)56, null);
            }

            @Nullable
            public final String component1() {
                return this.path;
            }

            @NotNull
            public final MatchTarget copy(@Nullable String path) {
                return new MatchTarget(path);
            }

            public static /* synthetic */ MatchTarget copy$default(MatchTarget matchTarget, String string, int n, Object object) {
                if ((n & 1) != 0) {
                    string = matchTarget.path;
                }
                return matchTarget.copy(string);
            }

            public int hashCode() {
                return this.path == null ? 0 : this.path.hashCode();
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MatchTarget)) {
                    return false;
                }
                MatchTarget matchTarget = (MatchTarget)other;
                return Intrinsics.areEqual((Object)this.path, (Object)matchTarget.path);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ErrorCommit;", "", "error", "", "getError", "()Ljava/lang/String;", "corax-config-api"})
    public static interface ErrorCommit {
        @Nullable
        public String getError();
    }

    @Serializable
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0003,-.B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\t\u0010\u001d\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"H\u00d6\u0003J\t\u0010#\u001a\u00020\nH\u00d6\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001\u00a2\u0006\u0002\b+R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006/"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ErrorCommit;", "op", "Lcom/feysh/corax/config/api/rules/ProcessRule$OP;", "path", "Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "<init>", "(Lcom/feysh/corax/config/api/rules/ProcessRule$OP;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/feysh/corax/config/api/rules/ProcessRule$OP;Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOp", "()Lcom/feysh/corax/config/api/rules/ProcessRule$OP;", "getPath$annotations", "()V", "getPath", "()Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "matches", "", "matchContent", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "error", "", "getError", "()Ljava/lang/String;", "toString", "component1", "component2", "copy", "equals", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_config_api", "MatchTarget", "$serializer", "Companion", "corax-config-api"})
    @SourceDebugExtension(value={"SMAP\nProcessRule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule$FileMatch\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,373:1\n1#2:374\n*E\n"})
    public static final class FileMatch
    implements IMatchItem,
    ErrorCommit {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final OP op;
        @NotNull
        private final ProcRegexBase path;
        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers;

        public FileMatch(@NotNull OP op, @NotNull ProcRegexBase path) {
            Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
            Intrinsics.checkNotNullParameter((Object)path, (String)"path");
            this.op = op;
            this.path = path;
        }

        @Override
        @NotNull
        public OP getOp() {
            return this.op;
        }

        @NotNull
        public final ProcRegexBase getPath() {
            return this.path;
        }

        @EncodeDefault(mode=EncodeDefault.Mode.ALWAYS)
        @SerialName(value="path")
        public static /* synthetic */ void getPath$annotations() {
        }

        @Override
        public boolean matches(@NotNull IMatchTarget matchContent) {
            Intrinsics.checkNotNullParameter((Object)matchContent, (String)"matchContent");
            if (!(matchContent instanceof MatchTarget)) {
                return false;
            }
            boolean anyMatch = false;
            Boolean bl = INSTANCE.matcher(this.path, ((MatchTarget)matchContent).getPath());
            if (bl != null) {
                boolean it = bl;
                boolean bl2 = false;
                if (it) {
                    anyMatch = true;
                } else {
                    return false;
                }
            }
            return anyMatch;
        }

        @Override
        @Nullable
        public String getError() {
            String string = INSTANCE.isValidOf(this.path, Type.File);
            if (string != null) {
                String it = string;
                boolean bl = false;
                return it;
            }
            return null;
        }

        @NotNull
        public String toString() {
            Object object = new ArrayList();
            List it = object;
            boolean bl = false;
            ((Collection)it).add("path=" + this.path);
            List list = object;
            object = "(" + this.getOp().getPretty() + ")";
            return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)", ", (CharSequence)((CharSequence)object), (CharSequence)"", (int)0, null, null, (int)56, null);
        }

        @NotNull
        public final OP component1() {
            return this.op;
        }

        @NotNull
        public final ProcRegexBase component2() {
            return this.path;
        }

        @NotNull
        public final FileMatch copy(@NotNull OP op, @NotNull ProcRegexBase path) {
            Intrinsics.checkNotNullParameter((Object)((Object)op), (String)"op");
            Intrinsics.checkNotNullParameter((Object)path, (String)"path");
            return new FileMatch(op, path);
        }

        public static /* synthetic */ FileMatch copy$default(FileMatch fileMatch, OP oP, ProcRegexBase procRegexBase, int n, Object object) {
            if ((n & 1) != 0) {
                oP = fileMatch.op;
            }
            if ((n & 2) != 0) {
                procRegexBase = fileMatch.path;
            }
            return fileMatch.copy(oP, procRegexBase);
        }

        public int hashCode() {
            int result = this.op.hashCode();
            result = result * 31 + this.path.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileMatch)) {
                return false;
            }
            FileMatch fileMatch = (FileMatch)other;
            if (this.op != fileMatch.op) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.path, (Object)fileMatch.path);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$corax_config_api(FileMatch self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArray = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.getOp());
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)ProcRegexBaseSerializer.INSTANCE, (Object)self.path);
        }

        public /* synthetic */ FileMatch(int seen0, OP op, ProcRegexBase path, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)FileMatch$$serializer.INSTANCE.getDescriptor());
            }
            this.op = op;
            this.path = path;
        }

        public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            KSerializer[] kSerializerArray = new KSerializer[]{EnumsKt.createSimpleEnumSerializer((String)"com.feysh.corax.config.api.rules.ProcessRule.OP", (Enum[])OP.values()), null};
            $childSerializers = kSerializerArray;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch;", "corax-config-api"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<FileMatch> serializer() {
                return (KSerializer)FileMatch$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u0013"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch$MatchTarget;", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "type", "getType", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "corax-config-api"})
        public static final class MatchTarget
        implements IMatchTarget {
            @Nullable
            private final String path;

            public MatchTarget(@Nullable String path) {
                this.path = path;
            }

            @Nullable
            public final String getPath() {
                return this.path;
            }

            @Override
            @NotNull
            public String getType() {
                return "file";
            }

            @NotNull
            public String toString() {
                Object object = new ArrayList();
                List it = object;
                boolean bl = false;
                if (this.path != null) {
                    ((Collection)it).add("path=" + this.path);
                }
                List list = object;
                object = this.getType() + ": { ";
                return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)", ", (CharSequence)((CharSequence)object), (CharSequence)" }", (int)0, null, null, (int)56, null);
            }

            @Nullable
            public final String component1() {
                return this.path;
            }

            @NotNull
            public final MatchTarget copy(@Nullable String path) {
                return new MatchTarget(path);
            }

            public static /* synthetic */ MatchTarget copy$default(MatchTarget matchTarget, String string, int n, Object object) {
                if ((n & 1) != 0) {
                    string = matchTarget.path;
                }
                return matchTarget.copy(string);
            }

            public int hashCode() {
                return this.path == null ? 0 : this.path.hashCode();
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MatchTarget)) {
                    return false;
                }
                MatchTarget matchTarget = (MatchTarget)other;
                return Intrinsics.areEqual((Object)this.path, (Object)matchTarget.path);
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "", "op", "Lcom/feysh/corax/config/api/rules/ProcessRule$OP;", "getOp", "()Lcom/feysh/corax/config/api/rules/ProcessRule$OP;", "matches", "", "matchContent", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "corax-config-api"})
    public static interface IMatchItem {
        @NotNull
        public OP getOp();

        public boolean matches(@NotNull IMatchTarget var1);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchTarget;", "", "type", "", "getType", "()Ljava/lang/String;", "corax-config-api"})
    public static interface IMatchTarget {
        @NotNull
        public String getType();
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000f\"\u0004\b\u0000\u0010\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00100\n2\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$InlineRuleStringSerialize;", "", "<init>", "()V", "jsonFormat", "Lkotlinx/serialization/json/Json;", "deserializeMatchFromLineString", "R", "Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "serializer", "Lkotlinx/serialization/KSerializer;", "objectKeyValues", "", "(Lkotlinx/serialization/KSerializer;Ljava/lang/String;)Lcom/feysh/corax/config/api/rules/ProcessRule$IMatchItem;", "lineString2map", "", "T", "fieldInline", "corax-config-api"})
    @SourceDebugExtension(value={"SMAP\nProcessRule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule$InlineRuleStringSerialize\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Json.kt\nkotlinx/serialization/json/JsonKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,373:1\n295#2,2:374\n774#2:378\n865#2,2:379\n1187#2,2:381\n1261#2,4:383\n211#3:376\n1#4:377\n*S KotlinDebug\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule$InlineRuleStringSerialize\n*L\n338#1:374,2\n358#1:378\n358#1:379,2\n358#1:381,2\n358#1:383,4\n346#1:376\n*E\n"})
    public static final class InlineRuleStringSerialize {
        @NotNull
        public static final InlineRuleStringSerialize INSTANCE = new InlineRuleStringSerialize();
        @NotNull
        private static final Json jsonFormat = JsonKt.Json$default(null, InlineRuleStringSerialize::jsonFormat$lambda$0, (int)1, null);

        private InlineRuleStringSerialize() {
        }

        @NotNull
        public final <R extends IMatchItem> R deserializeMatchFromLineString(@NotNull KSerializer<R> serializer2, @NotNull String objectKeyValues) {
            Map $i$f$firstOrNull2;
            Object v2;
            Object opText;
            MatchResult matchResult;
            block6: {
                Intrinsics.checkNotNullParameter(serializer2, (String)"serializer");
                Intrinsics.checkNotNullParameter((Object)objectKeyValues, (String)"objectKeyValues");
                String opMatch = CollectionsKt.joinToString$default((Iterable)((Iterable)OP.getEntries()), (CharSequence)"|", (CharSequence)"[", (CharSequence)"]", (int)0, null, InlineRuleStringSerialize::deserializeMatchFromLineString$lambda$1, (int)24, null);
                Regex itemRegex = new Regex("^\\((?<op>" + opMatch + ")\\)(?<fields>.+)$");
                MatchResult matchResult2 = itemRegex.matchEntire((CharSequence)objectKeyValues);
                if (matchResult2 == null) {
                    throw new SerializationException("No match found in the input string: `" + objectKeyValues + "`. matcher: " + itemRegex + ", serializer=" + serializer2);
                }
                matchResult = matchResult2;
                Object object = RegexExtensionsJDK8Kt.get((MatchGroupCollection)matchResult.getGroups(), (String)"op");
                if (object == null || (object = object.getValue()) == null) {
                    throw new SerializationException("invalid op syntax: `" + objectKeyValues + "`, serializer=" + serializer2);
                }
                opText = object;
                Iterable $this$firstOrNull$iv = (Iterable)OP.getEntries();
                boolean $i$f$firstOrNull2 = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    OP it = (OP)((Object)element$iv);
                    boolean bl = false;
                    if (!Intrinsics.areEqual((Object)it.getPretty(), (Object)opText)) continue;
                    v2 = element$iv;
                    break block6;
                }
                v2 = null;
            }
            OP oP = v2;
            if (oP == null) {
                throw new SerializationException("invalid op syntax: `" + (String)opText + "` in `" + objectKeyValues + "`, serializer=" + serializer2);
            }
            OP op = oP;
            Object object = RegexExtensionsJDK8Kt.get((MatchGroupCollection)matchResult.getGroups(), (String)"fields");
            if (object == null || (object = object.getValue()) == null) {
                throw new IllegalStateException(("invalid fields syntax in `" + objectKeyValues + "`, serializer=" + serializer2).toString());
            }
            Object fieldsPart = object;
            Map it = $i$f$firstOrNull2 = MapsKt.toMutableMap(this.lineString2map(serializer2, (String)fieldsPart));
            boolean bl = false;
            it.put("op", op.name());
            Map fieldMap = $i$f$firstOrNull2;
            Json $this$encodeToJsonElement$iv = jsonFormat;
            boolean $i$f$encodeToJsonElement = false;
            $this$encodeToJsonElement$iv.getSerializersModule();
            JsonElement jsonElement = $this$encodeToJsonElement$iv.encodeToJsonElement((SerializationStrategy)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE), (Object)fieldMap);
            Object object2 = jsonFormat.decodeFromJsonElement((DeserializationStrategy)serializer2, jsonElement);
            IMatchItem r = (IMatchItem)object2;
            boolean bl2 = false;
            Object object3 = r instanceof ErrorCommit ? (ErrorCommit)((Object)r) : null;
            if (object3 != null && (object3 = object3.getError()) != null) {
                Object it2 = object3;
                boolean bl3 = false;
                throw new IllegalStateException(("Invalid process-regex: `" + objectKeyValues + "`, error: " + (String)it2).toString());
            }
            return (R)((IMatchItem)object2);
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final <T> Map<String, String> lineString2map(@NotNull KSerializer<T> serializer2, @NotNull String fieldInline) {
            void $this$associateTo$iv$iv;
            void $this$associate$iv;
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv;
            Intrinsics.checkNotNullParameter(serializer2, (String)"serializer");
            Intrinsics.checkNotNullParameter((Object)fieldInline, (String)"fieldInline");
            String elementNames = CollectionsKt.joinToString$default((Iterable)SerialDescriptorKt.getElementNames((SerialDescriptor)serializer2.getDescriptor()), (CharSequence)"|", null, null, (int)0, null, null, (int)62, null);
            Regex split = new Regex(",\\s*(?=(" + elementNames + ")\\s*=)");
            String string = "^\\s*(?<key>" + elementNames + ")\\s*=(?<value>.*)$";
            int n = 0;
            Pattern pattern = Pattern.compile(string, n);
            Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"compile(...)");
            Pattern pairRegex = pattern;
            Object object = fieldInline;
            int n2 = 0;
            object = split.split((CharSequence)object, n2);
            boolean $i$f$filter = false;
            void var9_10 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                String it = (String)element$iv$iv;
                boolean bl = false;
                boolean bl2 = ((CharSequence)it).length() > 0;
                if (!bl2) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$associate = false;
            int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associate$iv, (int)10)), (int)16);
            destination$iv$iv = $this$associate$iv;
            Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
            boolean $i$f$associateTo = false;
            for (Object element$iv$iv : $this$associateTo$iv$iv) {
                String value;
                String key2;
                Map map = destination$iv$iv2;
                String it = (String)element$iv$iv;
                boolean bl = false;
                Matcher matcher = pairRegex.matcher(it);
                if (!matcher.find()) {
                    throw new SerializationException("invalid syntax regex `" + it + "` in `" + fieldInline + "`, serializer=" + serializer2);
                }
                if (matcher.group("key") == null) {
                    throw new IllegalStateException(("key not exists in `" + it + "`, pattern: " + pairRegex + ", serializer=" + serializer2).toString());
                }
                if (matcher.group("value") == null) {
                    throw new IllegalStateException(("value not exists in `" + it + "`, pattern: " + pairRegex + ", serializer=" + serializer2).toString());
                }
                Pair pair = TuplesKt.to((Object)key2, (Object)value);
                map.put(pair.getFirst(), pair.getSecond());
            }
            Map fieldMap = destination$iv$iv2;
            return fieldMap;
        }

        private static final Unit jsonFormat$lambda$0(JsonBuilder $this$Json) {
            Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
            $this$Json.setUseArrayPolymorphism(true);
            $this$Json.setPrettyPrint(true);
            return Unit.INSTANCE;
        }

        private static final CharSequence deserializeMatchFromLineString$lambda$1(OP it) {
            Intrinsics.checkNotNullParameter((Object)((Object)it), (String)"it");
            return Regex.Companion.escape(it.getPretty());
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$OP;", "", "pretty", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPretty", "()Ljava/lang/String;", "Add", "Sub", "corax-config-api"})
    public static final class OP
    extends Enum<OP> {
        @NotNull
        private final String pretty;
        public static final /* enum */ OP Add = new OP("+");
        public static final /* enum */ OP Sub = new OP("-");
        private static final /* synthetic */ OP[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private OP(String pretty) {
            this.pretty = pretty;
        }

        @NotNull
        public final String getPretty() {
            return this.pretty;
        }

        public static OP[] values() {
            return (OP[])$VALUES.clone();
        }

        public static OP valueOf(String value) {
            return Enum.valueOf(OP.class, value);
        }

        @NotNull
        public static EnumEntries<OP> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = oPArray = new OP[]{OP.Add, OP.Sub};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001a"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegex;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "regexExpr", "", "<init>", "(Ljava/lang/String;)V", "getRegexExpr", "()Ljava/lang/String;", "regex", "Lkotlin/text/Regex;", "getRegex", "()Lkotlin/text/Regex;", "regex$delegate", "Lkotlin/Lazy;", "serializerToString", "matches", "", "identifier", "toString", "component1", "copy", "equals", "other", "", "hashCode", "", "corax-config-api"})
    @SourceDebugExtension(value={"SMAP\nProcessRule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule$ProcRegex\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,373:1\n1#2:374\n*E\n"})
    private static final class ProcRegex
    extends ProcRegexBase {
        @NotNull
        private final String regexExpr;
        @NotNull
        private final Lazy regex$delegate;

        public ProcRegex(@NotNull String regexExpr) {
            Intrinsics.checkNotNullParameter((Object)regexExpr, (String)"regexExpr");
            this.regexExpr = regexExpr;
            if (!(((CharSequence)this.regexExpr).length() > 0)) {
                boolean bl = false;
                String string = "regex expr could not be empty";
                throw new IllegalStateException(string.toString());
            }
            this.regex$delegate = LazyKt.lazy(() -> ProcRegex.regex_delegate$lambda$1(this));
        }

        @NotNull
        public final String getRegexExpr() {
            return this.regexExpr;
        }

        private final Regex getRegex() {
            Lazy lazy = this.regex$delegate;
            return (Regex)lazy.getValue();
        }

        @Override
        @NotNull
        public String serializerToString() {
            return this.regexExpr;
        }

        @Override
        public boolean matches(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter((Object)identifier, (String)"identifier");
            return this.getRegex().containsMatchIn((CharSequence)identifier);
        }

        @Override
        @NotNull
        public String toString() {
            return this.serializerToString();
        }

        @NotNull
        public final String component1() {
            return this.regexExpr;
        }

        @NotNull
        public final ProcRegex copy(@NotNull String regexExpr) {
            Intrinsics.checkNotNullParameter((Object)regexExpr, (String)"regexExpr");
            return new ProcRegex(regexExpr);
        }

        public static /* synthetic */ ProcRegex copy$default(ProcRegex procRegex, String string, int n, Object object) {
            if ((n & 1) != 0) {
                string = procRegex.regexExpr;
            }
            return procRegex.copy(string);
        }

        public int hashCode() {
            return this.regexExpr.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProcRegex)) {
                return false;
            }
            ProcRegex procRegex = (ProcRegex)other;
            return Intrinsics.areEqual((Object)this.regexExpr, (Object)procRegex.regexExpr);
        }

        private static final Regex regex_delegate$lambda$1(ProcRegex this$0) {
            return new Regex(this$0.regexExpr);
        }
    }

    @Serializable(with=ProcRegexBaseSerializer.class)
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "", "<init>", "()V", "serializerToString", "", "matches", "", "identifier", "toString", "Companion", "corax-config-api"})
    public static abstract class ProcRegexBase {
        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        public abstract String serializerToString();

        public abstract boolean matches(@NotNull String var1);

        @NotNull
        public String toString() {
            return this.serializerToString();
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a8\u0006\u000b"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase$Companion;", "", "<init>", "()V", "parse", "Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "str", "", "origin", "serializer", "Lkotlinx/serialization/KSerializer;", "corax-config-api"})
        @SourceDebugExtension(value={"SMAP\nProcessRule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,373:1\n1#2:374\n*E\n"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final ProcRegexBase parse(@NotNull String str, @Nullable String origin) {
                block2: {
                    Object object;
                    block4: {
                        block3: {
                            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
                            if (!(((CharSequence)str).length() == 0)) break block2;
                            object = origin;
                            if (object == null) break block3;
                            String it = object;
                            boolean bl = false;
                            String string = " in ScanRegexItem: " + it;
                            object = string;
                            if (string != null) break block4;
                        }
                        object = "";
                    }
                    String string = "empty regex expression" + (String)object;
                    throw new SerializationException(string);
                }
                return new ProcRegex(str);
            }

            public static /* synthetic */ ProcRegexBase parse$default(Companion companion, String string, String string2, int n, Object object) {
                if ((n & 2) != 0) {
                    string2 = null;
                }
                return companion.parse(string, string2);
            }

            @NotNull
            public final KSerializer<ProcRegexBase> serializer() {
                return ProcRegexBaseSerializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBaseSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/api/rules/ProcessRule$ProcRegexBase;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "corax-config-api"})
    public static final class ProcRegexBaseSerializer
    implements KSerializer<ProcRegexBase> {
        @NotNull
        public static final ProcRegexBaseSerializer INSTANCE = new ProcRegexBaseSerializer();
        @NotNull
        private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor((String)"proc-regex", (PrimitiveKind)((PrimitiveKind)PrimitiveKind.STRING.INSTANCE));

        private ProcRegexBaseSerializer() {
        }

        @NotNull
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        public void serialize(@NotNull Encoder encoder, @NotNull ProcRegexBase value) {
            Intrinsics.checkNotNullParameter((Object)encoder, (String)"encoder");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            encoder.encodeString(value.serializerToString());
        }

        @NotNull
        public ProcRegexBase deserialize(@NotNull Decoder decoder) {
            Intrinsics.checkNotNullParameter((Object)decoder, (String)"decoder");
            return ProcRegexBase.Companion.parse(decoder.decodeString(), null);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$ScanAction;", "", "<init>", "(Ljava/lang/String;I)V", "Process", "Skip", "Keep", "corax-config-api"})
    public static final class ScanAction
    extends Enum<ScanAction> {
        public static final /* enum */ ScanAction Process = new ScanAction();
        public static final /* enum */ ScanAction Skip = new ScanAction();
        public static final /* enum */ ScanAction Keep = new ScanAction();
        private static final /* synthetic */ ScanAction[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static ScanAction[] values() {
            return (ScanAction[])$VALUES.clone();
        }

        public static ScanAction valueOf(String value) {
            return Enum.valueOf(ScanAction.class, value);
        }

        @NotNull
        public static EnumEntries<ScanAction> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = scanActionArray = new ScanAction[]{ScanAction.Process, ScanAction.Skip, ScanAction.Keep};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lcom/feysh/corax/config/api/rules/ProcessRule$Type;", "", "isFile", "", "isClassMember", "<init>", "(Ljava/lang/String;IZZ)V", "()Z", "File", "Class", "Method", "Field", "corax-config-api"})
    public static final class Type
    extends Enum<Type> {
        private final boolean isFile;
        private final boolean isClassMember;
        public static final /* enum */ Type File = new Type(true, false);
        public static final /* enum */ Type Class = new Type(false, true);
        public static final /* enum */ Type Method = new Type(false, true);
        public static final /* enum */ Type Field = new Type(false, true);
        private static final /* synthetic */ Type[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private Type(boolean isFile, boolean isClassMember) {
            this.isFile = isFile;
            this.isClassMember = isClassMember;
        }

        public final boolean isFile() {
            return this.isFile;
        }

        public final boolean isClassMember() {
            return this.isClassMember;
        }

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }

        public static Type valueOf(String value) {
            return Enum.valueOf(Type.class, value);
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = typeArray = new Type[]{Type.File, Type.Class, Type.Method, Type.Field};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[OP.values().length];
            try {
                nArray[OP.Add.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[OP.Sub.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

