/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.AsyncLoadingCache
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.future.FutureKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.coroutines;

import com.feysh.corax.cache.coroutines.LoadingCache;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import java.lang.invoke.LambdaMetafactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.future.FutureKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00028\u0000H\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u0000H\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u000e\u001a\u00028\u0000H\u0086@\u00a2\u0006\u0002\u0010\u000fJ(\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018J^\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u001724\u0010\u0019\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00150\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001dJ:\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u00002\"\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001eJ>\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u00002$\u0010\u0019\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001eJ:\u0010 \u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u00002\"\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001aH\u0087@\u00a2\u0006\u0002\u0010\u001eJ4\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00028\u00002\u001c\u0010\u0019\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00030#H\u0086@\u00a2\u0006\u0002\u0010$J\u001b\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010%\u001a\u00028\u0001\u00a2\u0006\u0002\u0010&J\u001e\u0010'\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010%\u001a\u00028\u0001H\u0086\u0002\u00a2\u0006\u0002\u0010&J\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015H\u0086@\u00a2\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010+0\u0015J\u0013\u0010,\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00028\u0000\u00a2\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\"J\u000e\u0010/\u001a\u00020\u0005H\u0082@\u00a2\u0006\u0002\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2={"Lcom/feysh/corax/cache/coroutines/LoadingCache;", "K", "V", "", "defaultScope", "Lkotlinx/coroutines/CoroutineScope;", "useCallingContext", "", "cache", "Lcom/github/benmanes/caffeine/cache/AsyncLoadingCache;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;ZLcom/github/benmanes/caffeine/cache/AsyncLoadingCache;)V", "underlying", "contains", "key", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIfPresent", "get", "getAsync", "Ljava/util/concurrent/CompletableFuture;", "getAll", "", "keys", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compute", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrNull", "getOrPut", "put", "", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "set", "asMap", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asDeferredMap", "Lkotlinx/coroutines/Deferred;", "invalidate", "(Ljava/lang/Object;)V", "invalidateAll", "scope", "corax-config-api"})
@SourceDebugExtension(value={"SMAP\nLoadingCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadingCache.kt\ncom/feysh/corax/cache/coroutines/LoadingCache\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,186:1\n462#2:187\n412#2:188\n462#2:193\n412#2:194\n1246#3,4:189\n1246#3,4:195\n*S KotlinDebug\n*F\n+ 1 LoadingCache.kt\ncom/feysh/corax/cache/coroutines/LoadingCache\n*L\n153#1:187\n153#1:188\n161#1:193\n161#1:194\n153#1:189,4\n161#1:195,4\n*E\n"})
public final class LoadingCache<K, V> {
    @NotNull
    private final CoroutineScope defaultScope;
    private final boolean useCallingContext;
    @NotNull
    private final AsyncLoadingCache<K, V> cache;

    public LoadingCache(@NotNull CoroutineScope defaultScope, boolean useCallingContext, @NotNull AsyncLoadingCache<K, V> cache2) {
        Intrinsics.checkNotNullParameter((Object)defaultScope, (String)"defaultScope");
        Intrinsics.checkNotNullParameter(cache2, (String)"cache");
        this.defaultScope = defaultScope;
        this.useCallingContext = useCallingContext;
        this.cache = cache2;
    }

    @NotNull
    public final AsyncLoadingCache<K, V> underlying() {
        return this.cache;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object contains(K var1_1, @NotNull Continuation<? super Boolean> $completion) {
        block7: {
            if (!($completion instanceof contains.1)) ** GOTO lbl-1000
            var4_3 = $completion;
            if ((var4_3.label & -2147483648) != 0) {
                var4_3.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    /* synthetic */ Object result;
                    final /* synthetic */ LoadingCache<K, V> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.contains(null, (Continuation<Boolean>)((Continuation)this));
                    }
                };
            }
            $result = $continuation.result;
            var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = this.cache.getIfPresent((Object)key);
                    if (v0 == null) break;
                    $continuation.label = 1;
                    v1 = FutureKt.await((CompletionStage)v0, (Continuation)$continuation);
                    if (v1 == var5_5) {
                        return var5_5;
                    }
                    break block7;
                }
                case 1: {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
                    break block7;
                }
            }
            v1 = null;
        }
        return Boxing.boxBoolean((boolean)(v1 != null));
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object getIfPresent(K key2, @NotNull Continuation<? super V> $completion) {
        CompletableFuture completableFuture = this.cache.getIfPresent(key2);
        if (completableFuture != null) {
            return FutureKt.await((CompletionStage)completableFuture, $completion);
        }
        return null;
    }

    @Nullable
    public final Object get(K key2, @NotNull Continuation<? super V> $completion) {
        CompletableFuture completableFuture = this.cache.get(key2);
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"get(...)");
        return FutureKt.await((CompletionStage)completableFuture, $completion);
    }

    @Nullable
    public final Object getAsync(K key2, @NotNull Continuation<? super CompletableFuture<V>> $completion) {
        CompletableFuture completableFuture = this.cache.get(key2);
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"get(...)");
        return completableFuture;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getAll(@NotNull Collection<? extends K> var1_1, @NotNull Continuation<? super Map<K, ? extends V>> $completion) {
        if (!($completion instanceof getAll.1)) ** GOTO lbl-1000
        var5_3 = $completion;
        if ((var5_3.label & -2147483648) != 0) {
            var5_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                /* synthetic */ Object result;
                final /* synthetic */ LoadingCache<K, V> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getAll(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var3_6 = this.cache.getAll((Iterable)keys);
                Intrinsics.checkNotNullExpressionValue((Object)var3_6, (String)"getAll(...)");
                $continuation.label = 1;
                v0 = FutureKt.await((CompletionStage)var3_6, (Continuation)$continuation);
                if (v0 == var6_5) {
                    return var6_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"await(...)");
                return v0;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getAll(@NotNull Collection<? extends K> var1_1, @NotNull Function2<? super Set<? extends K>, ? super Continuation<? super Map<K, ? extends V>>, ? extends Object> var2_2, @NotNull Continuation<? super Map<K, ? extends V>> $completion) {
        if (!($completion instanceof getAll.2)) ** GOTO lbl-1000
        var7_4 = $completion;
        if ((var7_4.label & -2147483648) != 0) {
            var7_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ LoadingCache<K, V> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getAll(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var8_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.L$1 = keys;
                $continuation.L$2 = compute;
                $continuation.label = 1;
                v0 = this.scope((Continuation<CoroutineScope>)$continuation);
                if (v0 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl26
            }
            case 1: {
                compute = (Function2)$continuation.L$2;
                keys = (Collection)$continuation.L$1;
                this = (LoadingCache)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl26:
                // 2 sources

                scope = (CoroutineScope)v0;
                var5_8 = (Function2)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, getAll$lambda$0(kotlinx.coroutines.CoroutineScope kotlin.jvm.functions.Function2 java.util.Set java.util.concurrent.Executor ), (Ljava/util/Set;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;)((CoroutineScope)scope, (Function2)compute);
                v1 = this.cache.getAll((Iterable)keys, new BiFunction(var5_8){
                    private final /* synthetic */ Function2 function;
                    {
                        Intrinsics.checkNotNullParameter((Object)function, (String)"function");
                        this.function = function;
                    }

                    public final /* synthetic */ Object apply(Object p0, Object p1) {
                        return this.function.invoke(p0, p1);
                    }
                });
                Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"getAll(...)");
                $continuation.L$0 = null;
                $continuation.L$1 = null;
                $continuation.L$2 = null;
                $continuation.label = 2;
                v2 = FutureKt.await((CompletionStage)v1, (Continuation)$continuation);
                if (v2 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl41
            }
            case 2: {
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl41:
                // 2 sources

                Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"await(...)");
                return v2;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object get(K var1_1, @NotNull Function2<? super K, ? super Continuation<? super V>, ? extends Object> var2_2, @NotNull Continuation<? super V> $completion) {
        if (!($completion instanceof get.2)) ** GOTO lbl-1000
        var7_4 = $completion;
        if ((var7_4.label & -2147483648) != 0) {
            var7_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ LoadingCache<K, V> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.get(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var8_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.L$1 = key;
                $continuation.L$2 = compute;
                $continuation.label = 1;
                v0 = this.scope((Continuation<CoroutineScope>)$continuation);
                if (v0 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl26
            }
            case 1: {
                compute = (Function2)$continuation.L$2;
                key = $continuation.L$1;
                this = (LoadingCache)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl26:
                // 2 sources

                scope = (CoroutineScope)v0;
                var5_8 = (Function2)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, get$lambda$1(kotlinx.coroutines.CoroutineScope kotlin.jvm.functions.Function2 java.lang.Object java.util.concurrent.Executor ), (Ljava/lang/Object;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;)((CoroutineScope)scope, (Function2)compute);
                v1 = this.cache.get(key, new /* invalid duplicate definition of identical inner class */);
                Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"get(...)");
                $continuation.L$0 = null;
                $continuation.L$1 = null;
                $continuation.L$2 = null;
                $continuation.label = 2;
                v2 = FutureKt.await((CompletionStage)v1, (Continuation)$continuation);
                if (v2 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl41
            }
            case 2: {
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl41:
                // 2 sources

                return v2;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getOrNull(K var1_1, @NotNull Function2<? super K, ? super Continuation<? super V>, ? extends Object> var2_2, @NotNull Continuation<? super V> $completion) {
        if (!($completion instanceof getOrNull.1)) ** GOTO lbl-1000
        var7_4 = $completion;
        if ((var7_4.label & -2147483648) != 0) {
            var7_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ LoadingCache<K, V> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getOrNull(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var8_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.L$1 = key;
                $continuation.L$2 = compute;
                $continuation.label = 1;
                v0 = this.scope((Continuation<CoroutineScope>)$continuation);
                if (v0 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl26
            }
            case 1: {
                compute = (Function2)$continuation.L$2;
                key = $continuation.L$1;
                this = (LoadingCache)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl26:
                // 2 sources

                scope = (CoroutineScope)v0;
                var5_8 = (Function2)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;, getOrNull$lambda$2(kotlinx.coroutines.CoroutineScope kotlin.jvm.functions.Function2 java.lang.Object java.util.concurrent.Executor ), (Ljava/lang/Object;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;)((CoroutineScope)scope, (Function2)compute);
                v1 = this.cache.get(key, new /* invalid duplicate definition of identical inner class */);
                Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"get(...)");
                $continuation.L$0 = null;
                $continuation.L$1 = null;
                $continuation.L$2 = null;
                $continuation.label = 2;
                v2 = FutureKt.await((CompletionStage)v1, (Continuation)$continuation);
                if (v2 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl41
            }
            case 2: {
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl41:
                // 2 sources

                return v2;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Deprecated(message="Use get", replaceWith=@ReplaceWith(expression="get(key, compute)", imports={}))
    @Nullable
    public final Object getOrPut(K key2, @NotNull Function2<? super K, ? super Continuation<? super V>, ? extends Object> compute, @NotNull Continuation<? super V> $completion) {
        return this.get(key2, compute, $completion);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object put(K var1_1, @NotNull Function1<? super Continuation<? super V>, ? extends Object> var2_2, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof put.1)) ** GOTO lbl-1000
        var6_4 = $completion;
        if ((var6_4.label & -2147483648) != 0) {
            var6_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ LoadingCache<K, V> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.put(null, null, (Continuation<Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var7_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.L$1 = key;
                $continuation.L$2 = compute;
                $continuation.label = 1;
                v0 = this.scope((Continuation<CoroutineScope>)$continuation);
                if (v0 == var7_6) {
                    return var7_6;
                }
                ** GOTO lbl26
            }
            case 1: {
                compute = (Function1)$continuation.L$2;
                key = $continuation.L$1;
                this = (LoadingCache)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl26:
                // 2 sources

                scope = (CoroutineScope)v0;
                this.cache.put(key, FutureKt.asCompletableFuture((Deferred)BuildersKt.async$default((CoroutineScope)scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super V>, Object>(compute, null){
                    int label;
                    final /* synthetic */ Function1<Continuation<? super V>, Object> $compute;
                    {
                        this.$compute = $compute;
                        super(2, $completion);
                    }

                    /*
                     * WARNING - void declaration
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    public final Object invokeSuspend(Object object) {
                        Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)object);
                                this.label = 1;
                                Object object3 = this.$compute.invoke((Object)((Object)this));
                                if (object3 != object2) return object3;
                                return object2;
                            }
                            case 1: {
                                void $result;
                                ResultKt.throwOnFailure((Object)$result);
                                Object object3 = $result;
                                return object3;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                        return (Continuation)new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(CoroutineScope p1, Continuation<? super V> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }), (int)3, null)));
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final void put(K key2, V value) {
        this.cache.put(key2, CompletableFuture.completedFuture(value));
    }

    public final void set(K key2, V value) {
        this.put(key2, value);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object asMap(@NotNull Continuation<? super Map<K, ? extends V>> $completion) {
        if (!($completion instanceof asMap.1)) ** GOTO lbl-1000
        var21_2 = $completion;
        if ((var21_2.label & -2147483648) != 0) {
            var21_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                /* synthetic */ Object result;
                final /* synthetic */ LoadingCache<K, V> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.asMap((Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var22_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var2_5 = this.cache.asMap();
                Intrinsics.checkNotNullExpressionValue((Object)var2_5, (String)"asMap(...)");
                $this$mapValues$iv = var2_5;
                $i$f$mapValues = false;
                var4_7 = $this$mapValues$iv;
                destination$iv$iv = new LinkedHashMap<K, V>(MapsKt.mapCapacity((int)$this$mapValues$iv.size()));
                $i$f$mapValuesTo = false;
                $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
                $i$f$associateByTo = false;
                var9_12 = $this$associateByTo$iv$iv$iv.iterator();
lbl22:
                // 2 sources

                while (var9_12.hasNext()) {
                    element$iv$iv$iv = var9_12.next();
                    var11_14 = (Map.Entry)element$iv$iv$iv;
                    var12_15 = destination$iv$iv;
                    $i$a$-associateByTo-MapsKt__MapsKt$mapValuesTo$1$iv$iv = false;
                    var14_17 = (Map.Entry)element$iv$iv$iv;
                    var18_21 = it$iv$iv.getKey();
                    var17_20 = var12_15;
                    $i$a$-mapValues-LoadingCache$asMap$2 = false;
                    var16_19 = it.getValue();
                    Intrinsics.checkNotNullExpressionValue(var16_19, (String)"<get-value>(...)");
                    $continuation.L$0 = destination$iv$iv;
                    $continuation.L$1 = var9_12;
                    $continuation.L$2 = var17_20;
                    $continuation.L$3 = var18_21;
                    $continuation.label = 1;
                    v0 = FutureKt.await((CompletionStage)((CompletionStage)var16_19), (Continuation)$continuation);
                    if (v0 == var22_4) {
                        return var22_4;
                    }
                    ** GOTO lbl55
                }
                break;
            }
            case 1: {
                $i$f$mapValues = false;
                $i$f$mapValuesTo = false;
                $i$f$associateByTo = false;
                $i$a$-mapValues-LoadingCache$asMap$2 = false;
                var18_21 = $continuation.L$3;
                var17_20 = (Map)$continuation.L$2;
                var9_12 = (Iterator<T>)$continuation.L$1;
                destination$iv$iv = (Map)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl55:
                // 2 sources

                var19_22 = v0;
                var17_20.put(var18_21, var19_22);
                ** GOTO lbl22
            }
        }
        return destination$iv$iv;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Map<K, Deferred<V>> asDeferredMap() {
        void $this$mapValuesTo$iv$iv;
        ConcurrentMap concurrentMap = this.cache.asMap();
        Intrinsics.checkNotNullExpressionValue((Object)concurrentMap, (String)"asMap(...)");
        Map $this$mapValues$iv = concurrentMap;
        boolean $i$f$mapValues = false;
        Map map = $this$mapValues$iv;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapValues$iv.size()));
        boolean $i$f$mapValuesTo = false;
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            void it;
            void it$iv$iv;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            Map map2 = destination$iv$iv;
            boolean bl = false;
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            Object k = it$iv$iv.getKey();
            Map map3 = map2;
            boolean bl2 = false;
            Object v = it.getValue();
            Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
            Deferred deferred = FutureKt.asDeferred((CompletionStage)((CompletionStage)v));
            map3.put(k, deferred);
        }
        return destination$iv$iv;
    }

    public final void invalidate(K key2) {
        this.cache.synchronous().invalidate(key2);
    }

    public final void invalidateAll() {
        this.cache.synchronous().invalidateAll();
    }

    private final Object scope(Continuation<? super CoroutineScope> $completion) {
        return this.useCallingContext ? CoroutineScopeKt.CoroutineScope((CoroutineContext)$completion.getContext()) : this.defaultScope;
    }

    private static final CompletableFuture getAll$lambda$0(CoroutineScope $scope, Function2 $compute, Set k, Executor executor) {
        return FutureKt.asCompletableFuture((Deferred)BuildersKt.async$default((CoroutineScope)$scope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super Map<K, ? extends V>>, Object>($compute, k, null){
            int label;
            final /* synthetic */ Function2<Set<? extends K>, Continuation<? super Map<K, ? extends V>>, Object> $compute;
            final /* synthetic */ Set<? extends K> $k;
            {
                this.$compute = $compute;
                this.$k = $k;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        Set<? extends K> set = this.$k;
                        Intrinsics.checkNotNull(set);
                        this.label = 1;
                        Object object3 = this.$compute.invoke((Object)CollectionsKt.toSet((Iterable)set), (Object)((Object)this));
                        if (object3 != object2) return object3;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return object3;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Map<K, ? extends V>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, (int)3, null));
    }

    private static final CompletableFuture get$lambda$1(CoroutineScope $scope, Function2 $compute, Object k, Executor executor) {
        return FutureKt.asCompletableFuture((Deferred)BuildersKt.async$default((CoroutineScope)$scope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super V>, Object>($compute, k, null){
            int label;
            final /* synthetic */ Function2<K, Continuation<? super V>, Object> $compute;
            final /* synthetic */ K $k;
            {
                this.$compute = $compute;
                this.$k = $k;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        this.label = 1;
                        Object object3 = this.$compute.invoke(this.$k, (Object)((Object)this));
                        if (object3 != object2) return object3;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return object3;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super V> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, (int)3, null));
    }

    private static final CompletableFuture getOrNull$lambda$2(CoroutineScope $scope, Function2 $compute, Object k, Executor executor) {
        return FutureKt.asCompletableFuture((Deferred)BuildersKt.async$default((CoroutineScope)$scope, null, null, (Function2)new Function2<CoroutineScope, Continuation<? super V>, Object>($compute, k, null){
            int label;
            final /* synthetic */ Function2<K, Continuation<? super V>, Object> $compute;
            final /* synthetic */ K $k;
            {
                this.$compute = $compute;
                this.$k = $k;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        this.label = 1;
                        Object object3 = this.$compute.invoke(this.$k, (Object)((Object)this));
                        if (object3 != object2) return object3;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return object3;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super V> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, (int)3, null));
    }

    public static final /* synthetic */ Object access$scope(LoadingCache $this, Continuation $completion) {
        return $this.scope((Continuation<CoroutineScope>)$completion);
    }
}

