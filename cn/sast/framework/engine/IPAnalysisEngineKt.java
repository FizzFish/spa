/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.framework.engine.IPAnalysisEngineKt
 *  cn.sast.framework.engine.SootMethodSerializer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  kotlinx.serialization.modules.SerializersModule
 *  kotlinx.serialization.modules.SerializersModuleBuilder
 *  org.jetbrains.annotations.NotNull
 *  soot.SootMethod
 */
package cn.sast.framework.engine;

import cn.sast.framework.engine.SootMethodSerializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"graphSerializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getGraphSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "graphJson", "Lkotlinx/serialization/json/Json;", "getGraphJson", "()Lkotlinx/serialization/json/Json;", "corax-framework"})
@SourceDebugExtension(value={"SMAP\nIPAnalysisEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IPAnalysisEngine.kt\ncn/sast/framework/engine/IPAnalysisEngineKt\n+ 2 SerializersModuleBuilders.kt\nkotlinx/serialization/modules/SerializersModuleBuildersKt\n*L\n1#1,344:1\n31#2,3:345\n*S KotlinDebug\n*F\n+ 1 IPAnalysisEngine.kt\ncn/sast/framework/engine/IPAnalysisEngineKt\n*L\n74#1:345,3\n*E\n"})
public final class IPAnalysisEngineKt {
    @NotNull
    private static final SerializersModule graphSerializersModule;
    @NotNull
    private static final Json graphJson;

    @NotNull
    public static final SerializersModule getGraphSerializersModule() {
        return graphSerializersModule;
    }

    @NotNull
    public static final Json getGraphJson() {
        return graphJson;
    }

    private static final Unit graphJson$lambda$1(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setEncodeDefaults(true);
        $this$Json.setUseArrayPolymorphism(true);
        $this$Json.setLenient(true);
        $this$Json.setPrettyPrint(true);
        $this$Json.setSerializersModule(graphSerializersModule);
        return Unit.INSTANCE;
    }

    static {
        SerializersModuleBuilder builder$iv;
        boolean $i$f$SerializersModule = false;
        SerializersModuleBuilder $this$graphSerializersModule_u24lambda_u240 = builder$iv = new SerializersModuleBuilder();
        boolean bl = false;
        $this$graphSerializersModule_u24lambda_u240.contextual(Reflection.getOrCreateKotlinClass(SootMethod.class), (KSerializer)SootMethodSerializer.INSTANCE);
        graphSerializersModule = builder$iv.build();
        graphJson = JsonKt.Json$default(null, IPAnalysisEngineKt::graphJson$lambda$1, (int)1, null);
    }
}

