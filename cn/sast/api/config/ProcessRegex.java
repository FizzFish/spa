/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.api.config.MainConfig
 *  cn.sast.api.config.ProcessRegex
 *  cn.sast.api.config.ProcessRegex$$serializer
 *  cn.sast.api.config.ProcessRegex$Companion
 *  cn.sast.api.config.ProjectConfigKt
 *  com.feysh.corax.config.api.rules.ProcessRule
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassMemberMatch
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassMemberMatch$$serializer
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassPathMatch
 *  com.feysh.corax.config.api.rules.ProcessRule$ClassPathMatch$$serializer
 *  com.feysh.corax.config.api.rules.ProcessRule$FileMatch
 *  com.feysh.corax.config.api.rules.ProcessRule$FileMatch$$serializer
 *  com.feysh.corax.config.api.rules.ProcessRule$InlineRuleStringSerialize
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerialName
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.SerializersKt
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.api.config;

import cn.sast.api.config.MainConfig;
import cn.sast.api.config.ProcessRegex;
import cn.sast.api.config.ProcessRegex$;
import cn.sast.api.config.ProjectConfigKt;
import com.feysh.corax.config.api.rules.ProcessRule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0004\b\t\u0010\nBK\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\t\u0010\u000fJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J9\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\fH\u00d6\u0001J\t\u0010 \u001a\u00020!H\u00d6\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001\u00a2\u0006\u0002\b)R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\u00a8\u0006,"}, d2={"Lcn/sast/api/config/ProcessRegex;", "", "clazzRules", "", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassMemberMatch;", "classpathRules", "Lcom/feysh/corax/config/api/rules/ProcessRule$ClassPathMatch;", "fileRules", "Lcom/feysh/corax/config/api/rules/ProcessRule$FileMatch;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClazzRules$annotations", "()V", "getClazzRules", "()Ljava/util/List;", "getClasspathRules$annotations", "getClasspathRules", "getFileRules$annotations", "getFileRules", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_api", "$serializer", "Companion", "corax-api"})
@SourceDebugExtension(value={"SMAP\nProjectConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProjectConfig.kt\ncn/sast/api/config/ProcessRegex\n+ 2 ProcessRule.kt\ncom/feysh/corax/config/api/rules/ProcessRule\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n27#2:46\n24#2:55\n27#2:56\n24#2:64\n27#2:65\n24#2:73\n27#2:74\n11165#3:47\n11500#3,3:48\n11165#3:57\n11500#3,3:58\n11500#3,3:61\n11165#3:66\n11500#3,3:67\n11500#3,3:70\n11165#3:75\n11500#3,3:76\n1557#4:51\n1628#4,3:52\n*S KotlinDebug\n*F\n+ 1 ProjectConfig.kt\ncn/sast/api/config/ProcessRegex\n*L\n18#1:46\n20#1:55\n22#1:56\n20#1:64\n22#1:65\n20#1:73\n22#1:74\n18#1:47\n18#1:48,3\n22#1:57\n22#1:58,3\n18#1:61,3\n22#1:66\n22#1:67,3\n18#1:70,3\n22#1:75\n22#1:76,3\n20#1:51\n20#1:52,3\n*E\n"})
public final class ProcessRegex {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<ProcessRule.ClassMemberMatch> clazzRules;
    @NotNull
    private final List<ProcessRule.ClassPathMatch> classpathRules;
    @NotNull
    private final List<ProcessRule.FileMatch> fileRules;
    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers;

    public ProcessRegex(@NotNull List<ProcessRule.ClassMemberMatch> clazzRules, @NotNull List<ProcessRule.ClassPathMatch> classpathRules, @NotNull List<ProcessRule.FileMatch> fileRules) {
        Intrinsics.checkNotNullParameter(clazzRules, (String)"clazzRules");
        Intrinsics.checkNotNullParameter(classpathRules, (String)"classpathRules");
        Intrinsics.checkNotNullParameter(fileRules, (String)"fileRules");
        this.clazzRules = clazzRules;
        this.classpathRules = classpathRules;
        this.fileRules = fileRules;
        ProjectConfigKt.validate((List)this.clazzRules);
        ProjectConfigKt.validate((List)this.classpathRules);
        ProjectConfigKt.validate((List)this.fileRules);
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ ProcessRegex(List list, List list2, List list3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        ProcessRule this_$iv;
        Object it$iv;
        boolean bl;
        String item$iv$iv$iv3;
        String[] $this$mapTo$iv$iv$iv;
        boolean $i$f$mapTo;
        Object destination$iv$iv$iv;
        boolean $i$f$map;
        Object $this$map$iv$iv;
        boolean $i$f$cvt;
        String[] ruleItems$iv;
        if ((n & 1) != 0) {
            ProcessRule processRule = ProcessRule.INSTANCE;
            ruleItems$iv = new String[]{};
            $i$f$cvt = false;
            $this$map$iv$iv = ruleItems$iv;
            $i$f$map = false;
            String[] stringArray = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList(((String[])$this$map$iv$iv).length);
            $i$f$mapTo = false;
            int n2 = $this$mapTo$iv$iv$iv.length;
            for (int i = 0; i < n2; ++i) {
                String string = item$iv$iv$iv3 = $this$mapTo$iv$iv$iv[i];
                Object object = destination$iv$iv$iv;
                bl = false;
                object.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.ClassMemberMatch.class)), (String)it$iv));
            }
            list = (List)destination$iv$iv$iv;
        }
        if ((n & 2) != 0) {
            void $this$mapTo$iv$iv;
            this_$iv = ProcessRule.INSTANCE;
            Iterable $this$map$iv = MainConfig.Companion.getExcludeFiles();
            boolean $i$f$map2 = false;
            $this$map$iv$iv = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo22 = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add("(-)path=" + (String)it);
            }
            $this$map$iv = (List)destination$iv$iv;
            $i$f$cvt = false;
            $this$map$iv$iv = (Iterable)ruleItems$iv;
            $i$f$map = false;
            Object $i$f$mapTo22 = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv$iv, (int)10));
            $i$f$mapTo = false;
            Iterator iterator2 = $this$mapTo$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                void it$iv2;
                Object item$iv$iv$iv2 = iterator2.next();
                item$iv$iv$iv3 = (String)item$iv$iv$iv2;
                it$iv = destination$iv$iv$iv;
                boolean bl3 = false;
                it$iv.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.ClassPathMatch.class)), (String)it$iv2));
            }
            list2 = (List)destination$iv$iv$iv;
        }
        if ((n & 4) != 0) {
            this_$iv = ProcessRule.INSTANCE;
            ruleItems$iv = new String[]{};
            $i$f$cvt = false;
            $this$map$iv$iv = ruleItems$iv;
            $i$f$map = false;
            $this$mapTo$iv$iv$iv = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList(((String[])$this$map$iv$iv).length);
            $i$f$mapTo = false;
            for (String item$iv$iv$iv3 : $this$mapTo$iv$iv$iv) {
                it$iv = item$iv$iv$iv3;
                Object object = destination$iv$iv$iv;
                bl = false;
                object.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.FileMatch.class)), (String)it$iv));
            }
            list3 = (List)destination$iv$iv$iv;
        }
        this(list, list2, list3);
    }

    @NotNull
    public final List<ProcessRule.ClassMemberMatch> getClazzRules() {
        return this.clazzRules;
    }

    @SerialName(value="class")
    public static /* synthetic */ void getClazzRules$annotations() {
    }

    @NotNull
    public final List<ProcessRule.ClassPathMatch> getClasspathRules() {
        return this.classpathRules;
    }

    @SerialName(value="classpath")
    public static /* synthetic */ void getClasspathRules$annotations() {
    }

    @NotNull
    public final List<ProcessRule.FileMatch> getFileRules() {
        return this.fileRules;
    }

    @SerialName(value="file")
    public static /* synthetic */ void getFileRules$annotations() {
    }

    @NotNull
    public final List<ProcessRule.ClassMemberMatch> component1() {
        return this.clazzRules;
    }

    @NotNull
    public final List<ProcessRule.ClassPathMatch> component2() {
        return this.classpathRules;
    }

    @NotNull
    public final List<ProcessRule.FileMatch> component3() {
        return this.fileRules;
    }

    @NotNull
    public final ProcessRegex copy(@NotNull List<ProcessRule.ClassMemberMatch> clazzRules, @NotNull List<ProcessRule.ClassPathMatch> classpathRules, @NotNull List<ProcessRule.FileMatch> fileRules) {
        Intrinsics.checkNotNullParameter(clazzRules, (String)"clazzRules");
        Intrinsics.checkNotNullParameter(classpathRules, (String)"classpathRules");
        Intrinsics.checkNotNullParameter(fileRules, (String)"fileRules");
        return new ProcessRegex(clazzRules, classpathRules, fileRules);
    }

    public static /* synthetic */ ProcessRegex copy$default(ProcessRegex processRegex, List list, List list2, List list3, int n, Object object) {
        if ((n & 1) != 0) {
            list = processRegex.clazzRules;
        }
        if ((n & 2) != 0) {
            list2 = processRegex.classpathRules;
        }
        if ((n & 4) != 0) {
            list3 = processRegex.fileRules;
        }
        return processRegex.copy(list, list2, list3);
    }

    @NotNull
    public String toString() {
        return "ProcessRegex(clazzRules=" + this.clazzRules + ", classpathRules=" + this.classpathRules + ", fileRules=" + this.fileRules + ")";
    }

    public int hashCode() {
        int result = ((Object)this.clazzRules).hashCode();
        result = result * 31 + ((Object)this.classpathRules).hashCode();
        result = result * 31 + ((Object)this.fileRules).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessRegex)) {
            return false;
        }
        ProcessRegex processRegex = (ProcessRegex)other;
        if (!Intrinsics.areEqual((Object)this.clazzRules, (Object)processRegex.clazzRules)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.classpathRules, (Object)processRegex.classpathRules)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.fileRules, (Object)processRegex.fileRules);
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    public static final /* synthetic */ void write$Self$corax_api(ProcessRegex self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean bl;
        ProcessRule this_$iv;
        boolean bl2;
        Object it$iv;
        String item$iv$iv$iv3;
        String[] $this$mapTo$iv$iv$iv;
        boolean $i$f$mapTo;
        Object destination$iv$iv$iv;
        boolean $i$f$map;
        Object $this$map$iv$iv;
        String[] ruleItems$iv;
        boolean $i$f$cvt;
        List list;
        boolean bl3;
        KSerializer[] kSerializerArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
            bl3 = true;
        } else {
            ProcessRule processRule = ProcessRule.INSTANCE;
            String[] stringArray = new String[]{};
            list = self.clazzRules;
            $i$f$cvt = false;
            $this$map$iv$iv = ruleItems$iv;
            $i$f$map = false;
            void var9_11 = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList(((void)$this$map$iv$iv).length);
            $i$f$mapTo = false;
            int n = $this$mapTo$iv$iv$iv.length;
            for (int i = 0; i < n; ++i) {
                String string = item$iv$iv$iv3 = $this$mapTo$iv$iv$iv[i];
                Object object = destination$iv$iv$iv;
                boolean bl32 = false;
                object.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.ClassMemberMatch.class)), (String)it$iv));
            }
            bl3 = !Intrinsics.areEqual((Object)list, (Object)((List)destination$iv$iv$iv));
        }
        if (bl3) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], (Object)self.clazzRules);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
            bl2 = true;
        } else {
            void $this$mapTo$iv$iv;
            List $this$map$iv;
            this_$iv = ProcessRule.INSTANCE;
            ruleItems$iv = (String[])MainConfig.Companion.getExcludeFiles();
            list = self.classpathRules;
            boolean $i$f$map2 = false;
            $this$map$iv$iv = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo232 = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl4 = false;
                collection.add("(-)path=" + (String)it);
            }
            $this$map$iv = (List)destination$iv$iv;
            $i$f$cvt = false;
            $this$map$iv$iv = (Iterable)ruleItems$iv;
            $i$f$map = false;
            Object $i$f$mapTo232 = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv$iv, (int)10));
            $i$f$mapTo = false;
            for (Object t : $this$mapTo$iv$iv$iv) {
                void it$iv2;
                item$iv$iv$iv3 = (String)t;
                it$iv = destination$iv$iv$iv;
                boolean bl6 = false;
                it$iv.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.ClassPathMatch.class)), (String)it$iv2));
            }
            bl2 = !Intrinsics.areEqual((Object)list, (Object)((List)destination$iv$iv$iv));
        }
        if (bl2) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], (Object)self.classpathRules);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2)) {
            bl = true;
        } else {
            this_$iv = ProcessRule.INSTANCE;
            ruleItems$iv = new String[]{};
            list = self.fileRules;
            $i$f$cvt = false;
            $this$map$iv$iv = ruleItems$iv;
            $i$f$map = false;
            $this$mapTo$iv$iv$iv = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList(((String[])$this$map$iv$iv).length);
            $i$f$mapTo = false;
            for (String item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
                it$iv = item$iv$iv$iv;
                Object object = destination$iv$iv$iv;
                boolean bl5 = false;
                object.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.FileMatch.class)), (String)it$iv));
            }
            bl = !Intrinsics.areEqual((Object)list, (Object)((List)destination$iv$iv$iv));
        }
        if (bl) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)kSerializerArray[2], (Object)self.fileRules);
        }
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ ProcessRegex(int seen0, List clazzRules, List classpathRules, List fileRules, SerializationConstructorMarker serializationConstructorMarker) {
        ProcessRule this_$iv;
        Object it$iv;
        String item$iv$iv$iv3;
        String[] $this$mapTo$iv$iv$iv;
        boolean $i$f$mapTo;
        Object destination$iv$iv$iv;
        boolean $i$f$map;
        Object $this$map$iv$iv;
        String[] ruleItems$iv;
        boolean $i$f$cvt;
        ProcessRegex processRegex;
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            ProcessRule processRule = ProcessRule.INSTANCE;
            String[] stringArray = new String[]{};
            processRegex = this;
            $i$f$cvt = false;
            $this$map$iv$iv = ruleItems$iv;
            $i$f$map = false;
            void var11_13 = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList(((void)$this$map$iv$iv).length);
            $i$f$mapTo = false;
            int n = $this$mapTo$iv$iv$iv.length;
            for (int i = 0; i < n; ++i) {
                String string = item$iv$iv$iv3 = $this$mapTo$iv$iv$iv[i];
                Object object = destination$iv$iv$iv;
                boolean bl = false;
                object.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.ClassMemberMatch.class)), (String)it$iv));
            }
            processRegex.clazzRules = (List)destination$iv$iv$iv;
        } else {
            this.clazzRules = clazzRules;
        }
        if ((seen0 & 2) == 0) {
            void $this$mapTo$iv$iv;
            List $this$map$iv;
            this_$iv = ProcessRule.INSTANCE;
            ruleItems$iv = (String[])MainConfig.Companion.getExcludeFiles();
            processRegex = this;
            boolean $i$f$map2 = false;
            $this$map$iv$iv = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo232 = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add("(-)path=" + (String)it);
            }
            $this$map$iv = (List)destination$iv$iv;
            $i$f$cvt = false;
            $this$map$iv$iv = (Iterable)ruleItems$iv;
            $i$f$map = false;
            Object $i$f$mapTo232 = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv$iv, (int)10));
            $i$f$mapTo = false;
            for (Object t : $this$mapTo$iv$iv$iv) {
                void it$iv2;
                item$iv$iv$iv3 = (String)t;
                it$iv = destination$iv$iv$iv;
                boolean bl3 = false;
                it$iv.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.ClassPathMatch.class)), (String)it$iv2));
            }
            processRegex.classpathRules = (List)destination$iv$iv$iv;
        } else {
            this.classpathRules = classpathRules;
        }
        if ((seen0 & 4) == 0) {
            this_$iv = ProcessRule.INSTANCE;
            ruleItems$iv = new String[]{};
            processRegex = this;
            $i$f$cvt = false;
            $this$map$iv$iv = ruleItems$iv;
            $i$f$map = false;
            $this$mapTo$iv$iv$iv = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList(((String[])$this$map$iv$iv).length);
            $i$f$mapTo = false;
            for (String item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
                it$iv = item$iv$iv$iv;
                Object object = destination$iv$iv$iv;
                boolean bl = false;
                object.add(ProcessRule.InlineRuleStringSerialize.INSTANCE.deserializeMatchFromLineString(SerializersKt.serializer((KClass)Reflection.getOrCreateKotlinClass(ProcessRule.FileMatch.class)), (String)it$iv));
            }
            processRegex.fileRules = (List)destination$iv$iv$iv;
        } else {
            this.fileRules = fileRules;
        }
        ProjectConfigKt.validate((List)this.clazzRules);
        ProjectConfigKt.validate((List)this.classpathRules);
        ProjectConfigKt.validate((List)this.fileRules);
    }

    public ProcessRegex() {
        this(null, null, null, 7, null);
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        KSerializer[] kSerializerArray = new KSerializer[]{new ArrayListSerializer((KSerializer)ProcessRule.ClassMemberMatch.$serializer.INSTANCE), new ArrayListSerializer((KSerializer)ProcessRule.ClassPathMatch.$serializer.INSTANCE), new ArrayListSerializer((KSerializer)ProcessRule.FileMatch.$serializer.INSTANCE)};
        $childSerializers = kSerializerArray;
    }
}

