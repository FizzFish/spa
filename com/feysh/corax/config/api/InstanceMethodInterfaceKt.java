package com.feysh.corax.config.api;

/**
 * Type aliases for method configuration interfaces.
 */
public final class InstanceMethodInterfaceKt {
    /**
     * Alias for MethodConfig type.
     */
    public interface MethodConfigType extends MethodConfig {}

    /**
     * Functional interface for method configuration blocks.
     * @param <T> The method config type
     */
    @FunctionalInterface
    public interface MethodConfigBlockType<T extends MethodConfig> {
        void apply(T config);
    }
}