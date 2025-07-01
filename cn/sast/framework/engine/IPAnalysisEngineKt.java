package cn.sast.framework.engine;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import org.jetbrains.annotations.NotNull;
import soot.SootMethod;

public final class IPAnalysisEngineKt {
    @NotNull
    private static final SerializersModule graphSerializersModule;
    @NotNull
    private static final Json graphJson;

    @NotNull
    public static SerializersModule getGraphSerializersModule() {
        return graphSerializersModule;
    }

    @NotNull
    public static Json getGraphJson() {
        return graphJson;
    }

    private static void configureJson(JsonBuilder builder) {
        builder.setEncodeDefaults(true);
        builder.setUseArrayPolymorphism(true);
        builder.setLenient(true);
        builder.setPrettyPrint(true);
        builder.setSerializersModule(graphSerializersModule);
    }

    static {
        SerializersModuleBuilder builder = new SerializersModuleBuilder();
        builder.contextual(SootMethod.class, SootMethodSerializer.INSTANCE);
        graphSerializersModule = builder.build();
        graphJson = JsonKt.Json$default(null, IPAnalysisEngineKt::configureJson, 1, null);
    }
}