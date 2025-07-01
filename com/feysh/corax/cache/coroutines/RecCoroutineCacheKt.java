package com.feysh.corax.cache.coroutines;

import kotlinx.coroutines.Deferred;

/**
 * Type alias for a deferred result used in recursive coroutine caching.
 * 
 * @param <V> The type of the deferred value
 */
public final class RecCoroutineCacheKt {
    /**
     * Recursive result type representing a deferred computation that may itself
     * return another deferred computation of the same type.
     */
    public static class RecRes<V> extends Deferred<Deferred<V>> {}
}