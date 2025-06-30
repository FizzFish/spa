/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  soot.Main
 *  soot.Scene
 *  soot.jimple.toolkits.callgraph.CallGraph
 *  soot.options.Options
 */
package com.feysh.corax.config.builtin.soot;

import com.feysh.corax.config.api.ISootInitializeHandler;
import com.feysh.corax.config.api.SAOptions;
import com.feysh.corax.config.builtin.soot.DefaultSootConfiguration$CustomOptions$;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import soot.Main;
import soot.Scene;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.options.Options;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Lcom/feysh/corax/config/builtin/soot/DefaultSootConfiguration;", "Lcom/feysh/corax/config/api/ISootInitializeHandler;", "<init>", "()V", "options", "Lcom/feysh/corax/config/builtin/soot/DefaultSootConfiguration$CustomOptions;", "getOptions", "()Lcom/feysh/corax/config/builtin/soot/DefaultSootConfiguration$CustomOptions;", "setOptions", "(Lcom/feysh/corax/config/builtin/soot/DefaultSootConfiguration$CustomOptions;)V", "configure", "", "Lsoot/options/Options;", "CustomOptions", "corax-config-api"})
public final class DefaultSootConfiguration
implements ISootInitializeHandler {
    @NotNull
    public static final DefaultSootConfiguration INSTANCE = new DefaultSootConfiguration();
    @NotNull
    private static CustomOptions options = new CustomOptions();

    private DefaultSootConfiguration() {
    }

    @NotNull
    public final CustomOptions getOptions() {
        return options;
    }

    public final void setOptions(@NotNull CustomOptions customOptions) {
        Intrinsics.checkNotNullParameter((Object)customOptions, (String)"<set-?>");
        options = customOptions;
    }

    @Override
    public void configure(@NotNull Options options) {
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        List excludeList = new LinkedList();
        excludeList.addAll((Collection)DefaultSootConfiguration.options.getExcludeList());
        options.set_exclude(excludeList);
        for (Map.Entry<String, String> entry : DefaultSootConfiguration.options.getSootPhaseNameToOption().entrySet()) {
            String phaseName = entry.getKey();
            String opt = entry.getValue();
            options.setPhaseOption(phaseName, opt);
        }
    }

    @Override
    public void configure(@NotNull Scene scene) {
        ISootInitializeHandler.DefaultImpls.configure((ISootInitializeHandler)this, scene);
    }

    @Override
    public void configure(@NotNull Main main) {
        ISootInitializeHandler.DefaultImpls.configure((ISootInitializeHandler)this, main);
    }

    @Override
    public void configureAfterSceneInit(@NotNull Scene scene, @NotNull Options options) {
        ISootInitializeHandler.DefaultImpls.configureAfterSceneInit(this, scene, options);
    }

    @Override
    public void onBeforeCallGraphConstruction(@NotNull Scene scene, @NotNull Options options) {
        ISootInitializeHandler.DefaultImpls.onBeforeCallGraphConstruction(this, scene, options);
    }

    @Override
    public void onAfterCallGraphConstruction(@NotNull CallGraph cg, @NotNull Scene scene, @NotNull Options options) {
        ISootInitializeHandler.DefaultImpls.onAfterCallGraphConstruction(this, cg, scene, options);
    }

    @Serializable
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003BA\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0002\u0010\rJ%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001\u00a2\u0006\u0002\b\u0019R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2={"Lcom/feysh/corax/config/builtin/soot/DefaultSootConfiguration$CustomOptions;", "Lcom/feysh/corax/config/api/SAOptions;", "<init>", "()V", "seen0", "", "excludeList", "", "", "sootPhaseNameToOption", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getExcludeList", "()Ljava/util/List;", "getSootPhaseNameToOption", "()Ljava/util/Map;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$corax_config_api", "$serializer", "Companion", "corax-config-api"})
    public static final class CustomOptions
    implements SAOptions {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final List<String> excludeList;
        @NotNull
        private final Map<String, String> sootPhaseNameToOption;
        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers;

        public CustomOptions() {
            Object[] objectArray = new String[]{"java.*", "javax.*", "jdk.*", "com.apple.*", "apple.awt.*", "org.w3c.*", "org.xml.*", "com.sun.*", "sun.*", "android.*", "androidx.*", "org.slf4j.*", "org.apache.log4j.*", "org.apache.logging.*", "java.util.logging.*", "ch.qos.logback.*", "com.mysql.*", "org.eclipse.*", "soot.*"};
            this.excludeList = CollectionsKt.listOf((Object[])objectArray);
            objectArray = new Pair[]{TuplesKt.to((Object)"jb.sils", (Object)"enabled:false"), TuplesKt.to((Object)"jb.tr", (Object)"ignore-nullpointer-dereferences:true")};
            this.sootPhaseNameToOption = MapsKt.mapOf((Pair[])objectArray);
        }

        @NotNull
        public final List<String> getExcludeList() {
            return this.excludeList;
        }

        @NotNull
        public final Map<String, String> getSootPhaseNameToOption() {
            return this.sootPhaseNameToOption;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$corax_config_api(CustomOptions self, CompositeEncoder output, SerialDescriptor serialDesc) {
            boolean bl;
            Object[] objectArray;
            boolean bl2;
            KSerializer<Object>[] kSerializerArray = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0)) {
                bl2 = true;
            } else {
                objectArray = new String[]{"java.*", "javax.*", "jdk.*", "com.apple.*", "apple.awt.*", "org.w3c.*", "org.xml.*", "com.sun.*", "sun.*", "android.*", "androidx.*", "org.slf4j.*", "org.apache.log4j.*", "org.apache.logging.*", "java.util.logging.*", "ch.qos.logback.*", "com.mysql.*", "org.eclipse.*", "soot.*"};
                bl2 = !Intrinsics.areEqual(self.excludeList, (Object)CollectionsKt.listOf((Object[])objectArray));
            }
            if (bl2) {
                output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)kSerializerArray[0], self.excludeList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1)) {
                bl = true;
            } else {
                objectArray = new Pair[]{TuplesKt.to((Object)"jb.sils", (Object)"enabled:false"), TuplesKt.to((Object)"jb.tr", (Object)"ignore-nullpointer-dereferences:true")};
                bl = !Intrinsics.areEqual(self.sootPhaseNameToOption, (Object)MapsKt.mapOf((Pair[])objectArray));
            }
            if (bl) {
                output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)kSerializerArray[1], self.sootPhaseNameToOption);
            }
        }

        public /* synthetic */ CustomOptions(int seen0, List excludeList, Map sootPhaseNameToOption, SerializationConstructorMarker serializationConstructorMarker) {
            Object[] objectArray;
            if ((0 & seen0) != 0) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)CustomOptions$$serializer.INSTANCE.getDescriptor());
            }
            if ((seen0 & 1) == 0) {
                objectArray = new String[]{"java.*", "javax.*", "jdk.*", "com.apple.*", "apple.awt.*", "org.w3c.*", "org.xml.*", "com.sun.*", "sun.*", "android.*", "androidx.*", "org.slf4j.*", "org.apache.log4j.*", "org.apache.logging.*", "java.util.logging.*", "ch.qos.logback.*", "com.mysql.*", "org.eclipse.*", "soot.*"};
                this.excludeList = CollectionsKt.listOf((Object[])objectArray);
            } else {
                this.excludeList = excludeList;
            }
            if ((seen0 & 2) == 0) {
                objectArray = new Pair[]{TuplesKt.to((Object)"jb.sils", (Object)"enabled:false"), TuplesKt.to((Object)"jb.tr", (Object)"ignore-nullpointer-dereferences:true")};
                this.sootPhaseNameToOption = MapsKt.mapOf((Pair[])objectArray);
            } else {
                this.sootPhaseNameToOption = sootPhaseNameToOption;
            }
        }

        public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            KSerializer[] kSerializerArray = new KSerializer[]{new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)};
            $childSerializers = kSerializerArray;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Lcom/feysh/corax/config/builtin/soot/DefaultSootConfiguration$CustomOptions$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/feysh/corax/config/builtin/soot/DefaultSootConfiguration$CustomOptions;", "corax-config-api"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<CustomOptions> serializer() {
                return (KSerializer)CustomOptions$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

