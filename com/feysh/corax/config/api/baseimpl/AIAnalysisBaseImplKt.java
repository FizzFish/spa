package com.feysh.corax.config.api.baseimpl;

/**
 * Type aliases for common configuration-related functional interfaces.
 */
public final class AIAnalysisBaseImplKt {
    /**
     * Represents a custom attribute with a specific type.
     * @param <T> The type of the attribute value
     */
    public interface CustomAttribute<T> extends Attribute<AttributeName, T> {}

    /**
     * Callback executed before configuration processing.
     */
    @FunctionalInterface
    public interface BeforeConfigCallBack extends Runnable {}

    /**
     * Callback executed for each class during configuration.
     */
    @FunctionalInterface
    public interface EachClassCallBack {
        void accept(soot.SootClass clazz);
    }

    /**
     * Callback executed after configuration processing.
     */
    @FunctionalInterface
    public interface AfterConfigCallBack extends Runnable {}
}