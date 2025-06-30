/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.benmanes.caffeine.cache.Cache
 *  com.github.benmanes.caffeine.cache.Caffeine
 *  com.github.benmanes.caffeine.cache.Expiry
 *  com.github.benmanes.caffeine.cache.RemovalCause
 *  com.github.benmanes.caffeine.cache.RemovalListener
 *  com.github.benmanes.caffeine.cache.Scheduler
 *  com.github.benmanes.caffeine.cache.Ticker
 *  com.github.benmanes.caffeine.cache.Weigher
 *  com.github.benmanes.caffeine.cache.stats.StatsCounter
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.time.Duration
 *  kotlin.time.DurationKt
 *  kotlin.time.DurationUnit
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.future.FutureKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.feysh.corax.cache.coroutines;

import com.feysh.corax.cache.coroutines.Configuration;
import com.feysh.corax.cache.coroutines.Scheduler;
import com.feysh.corax.cache.coroutines.XCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import com.github.benmanes.caffeine.cache.Ticker;
import com.github.benmanes.caffeine.cache.Weigher;
import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.future.FutureKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u001bB?\b\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2={"Lcom/feysh/corax/cache/coroutines/XCache;", "K", "V", "", "config", "Lcom/feysh/corax/cache/coroutines/Configuration;", "defaultScope", "Lkotlin/Lazy;", "Lkotlinx/coroutines/CoroutineScope;", "caffeine", "Lcom/github/benmanes/caffeine/cache/Caffeine;", "<init>", "(Lcom/feysh/corax/cache/coroutines/Configuration;Lkotlin/Lazy;Lcom/github/benmanes/caffeine/cache/Caffeine;)V", "getDefaultScope", "()Lkotlin/Lazy;", "getCaffeine", "()Lcom/github/benmanes/caffeine/cache/Caffeine;", "useCallingContext", "", "getUseCallingContext", "()Z", "stats", "Lcom/github/benmanes/caffeine/cache/stats/StatsCounter;", "getStats", "()Lcom/github/benmanes/caffeine/cache/stats/StatsCounter;", "build", "Lcom/github/benmanes/caffeine/cache/Cache;", "Companion", "corax-config-api"})
public final class XCache<K, V> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Configuration<K, V> config;
    @NotNull
    private final Lazy<CoroutineScope> defaultScope;
    @NotNull
    private final Caffeine<Object, Object> caffeine;

    private XCache(Configuration<K, V> config, Lazy<? extends CoroutineScope> defaultScope, Caffeine<Object, Object> caffeine) {
        this.config = config;
        this.defaultScope = defaultScope;
        this.caffeine = caffeine;
    }

    @NotNull
    public final Lazy<CoroutineScope> getDefaultScope() {
        return this.defaultScope;
    }

    @NotNull
    public final Caffeine<Object, Object> getCaffeine() {
        return this.caffeine;
    }

    public final boolean getUseCallingContext() {
        return this.config.getUseCallingContext();
    }

    @Nullable
    public final StatsCounter getStats() {
        return this.config.getStatsCounter();
    }

    @NotNull
    public final Cache<K, V> build() {
        Cache cache2 = this.caffeine.build();
        Intrinsics.checkNotNullExpressionValue((Object)cache2, (String)"build(...)");
        return cache2;
    }

    public /* synthetic */ XCache(Configuration config, Lazy defaultScope, Caffeine caffeine, DefaultConstructorMarker $constructor_marker) {
        this(config, (Lazy<? extends CoroutineScope>)defaultScope, (Caffeine<Object, Object>)caffeine);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0002\u0010\u0006\"\u0004\b\u0003\u0010\u00072%\b\u0002\u0010\b\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\b\f\u00a8\u0006\r"}, d2={"Lcom/feysh/corax/cache/coroutines/XCache$Companion;", "", "<init>", "()V", "cacheBuilder", "Lcom/feysh/corax/cache/coroutines/XCache;", "K", "V", "configure", "Lkotlin/Function1;", "Lcom/feysh/corax/cache/coroutines/Configuration;", "", "Lkotlin/ExtensionFunctionType;", "corax-config-api"})
    @SourceDebugExtension(value={"SMAP\nXCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XCache.kt\ncom/feysh/corax/cache/coroutines/XCache$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <K, V> XCache<K, V> cacheBuilder(@NotNull Function1<? super Configuration<K, V>, Unit> configure) {
            long l;
            int n;
            long l2;
            Function3 function3;
            Function4 listener;
            Intrinsics.checkNotNullParameter(configure, (String)"configure");
            Configuration c = new Configuration(false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
            configure.invoke(c);
            Caffeine caffeine = Caffeine.newBuilder();
            Lazy defaultScope = LazyKt.lazy(() -> Companion.cacheBuilder$lambda$1(c));
            Function4 function4 = c.getEvictionListener();
            if (function4 != null) {
                listener = function4;
                boolean bl = false;
                function3 = (arg_0, arg_1, arg_2) -> Companion.cacheBuilder$lambda$3$lambda$2(defaultScope, listener, arg_0, arg_1, arg_2);
                caffeine.evictionListener(new RemovalListener(function3){
                    private final /* synthetic */ Function3 function;
                    {
                        Intrinsics.checkNotNullParameter((Object)function, (String)"function");
                        this.function = function;
                    }

                    public final /* synthetic */ void onRemoval(Object p0, Object p1, RemovalCause p2) {
                        this.function.invoke(p0, p1, (Object)p2);
                    }
                });
            }
            Function4 function42 = c.getRemovalListener();
            if (function42 != null) {
                listener = function42;
                boolean bl = false;
                function3 = (arg_0, arg_1, arg_2) -> Companion.cacheBuilder$lambda$5$lambda$4(defaultScope, listener, arg_0, arg_1, arg_2);
                caffeine.removalListener(new /* invalid duplicate definition of identical inner class */);
            }
            Integer n2 = c.getInitialCapacity();
            if (n2 != null) {
                int it = ((Number)n2).intValue();
                boolean bl = false;
                caffeine.initialCapacity(it);
            }
            Function0<Long> function0 = c.getTicker();
            if (function0 != null) {
                Function0<Long> it = function0;
                boolean bl = false;
                caffeine.ticker(new Ticker(it){
                    private final /* synthetic */ Function0 function;
                    {
                        Intrinsics.checkNotNullParameter((Object)function, (String)"function");
                        this.function = function;
                    }

                    public final /* synthetic */ long read() {
                        return ((Number)this.function.invoke()).longValue();
                    }
                });
            }
            Long l3 = c.getMaximumSize();
            if (l3 != null) {
                long it = ((Number)l3).longValue();
                boolean bl = false;
                caffeine.maximumSize(it);
            }
            Long l4 = c.getMaximumWeight();
            if (l4 != null) {
                long it = ((Number)l4).longValue();
                boolean bl2 = false;
                caffeine.maximumWeight(it);
            }
            Function2 function2 = c.getWeigher();
            if (function2 != null) {
                Function2 it = function2;
                boolean bl = false;
                Function2 bl2 = it;
                caffeine.weigher(new Weigher(bl2){
                    private final /* synthetic */ Function2 function;
                    {
                        Intrinsics.checkNotNullParameter((Object)function, (String)"function");
                        this.function = function;
                    }

                    public final /* synthetic */ int weigh(Object p0, Object p1) {
                        return ((Number)this.function.invoke(p0, p1)).intValue();
                    }
                });
            }
            Duration duration = c.getExpireAfterWrite-FghU774();
            if (duration != null) {
                long it = duration.unbox-impl();
                boolean bl = false;
                l2 = it;
                n = Duration.getNanosecondsComponent-impl((long)l2);
                l = Duration.getInWholeSeconds-impl((long)l2);
                java.time.Duration duration2 = java.time.Duration.ofSeconds(l, n);
                Intrinsics.checkNotNullExpressionValue((Object)duration2, (String)"toComponents-impl(...)");
                caffeine.expireAfterWrite(duration2);
            }
            Duration duration3 = c.getExpireAfterAccess-FghU774();
            if (duration3 != null) {
                long it = duration3.unbox-impl();
                boolean bl = false;
                l2 = it;
                n = Duration.getNanosecondsComponent-impl((long)l2);
                l = Duration.getInWholeSeconds-impl((long)l2);
                java.time.Duration duration4 = java.time.Duration.ofSeconds(l, n);
                Intrinsics.checkNotNullExpressionValue((Object)duration4, (String)"toComponents-impl(...)");
                caffeine.expireAfterAccess(duration4);
            }
            Expiry expiry = c.getExpireAfter();
            if (expiry != null) {
                Expiry it = expiry;
                boolean bl = false;
                caffeine.expireAfter(it);
            }
            Duration duration5 = c.getRefreshAfterWrite-FghU774();
            if (duration5 != null) {
                long it = duration5.unbox-impl();
                boolean bl = false;
                l2 = it;
                n = Duration.getNanosecondsComponent-impl((long)l2);
                l = Duration.getInWholeSeconds-impl((long)l2);
                java.time.Duration duration6 = java.time.Duration.ofSeconds(l, n);
                Intrinsics.checkNotNullExpressionValue((Object)duration6, (String)"toComponents-impl(...)");
                caffeine.refreshAfterWrite(duration6);
            }
            StatsCounter statsCounter = c.getStatsCounter();
            if (statsCounter != null) {
                StatsCounter counter = statsCounter;
                boolean bl = false;
                caffeine.recordStats(new Supplier(counter){
                    final /* synthetic */ StatsCounter $counter;
                    {
                        this.$counter = $counter;
                    }

                    public final StatsCounter get() {
                        return this.$counter;
                    }
                });
            }
            if (Intrinsics.areEqual((Object)c.getWeakKeys(), (Object)true)) {
                caffeine.weakKeys();
            }
            if (Intrinsics.areEqual((Object)c.getWeakValues(), (Object)true)) {
                caffeine.weakValues();
            }
            if (Intrinsics.areEqual((Object)c.getSoftValues(), (Object)true)) {
                caffeine.softValues();
            }
            Scheduler scheduler = c.getScheduler();
            if (scheduler != null) {
                Scheduler scheduler2 = scheduler;
                boolean bl = false;
                caffeine.scheduler(new com.github.benmanes.caffeine.cache.Scheduler(scheduler2){
                    final /* synthetic */ Scheduler $scheduler;
                    {
                        this.$scheduler = $scheduler;
                    }

                    public final Future<?> schedule(Executor executor, Runnable command, long delay, TimeUnit unit) {
                        Intrinsics.checkNotNull((Object)executor);
                        return FutureKt.asCompletableFuture(this.$scheduler.schedule-SxA4cEA(executor, (Function0<Unit>)((Function0)() -> cacheBuilder.14.1.schedule$lambda$0(command)), DurationKt.toDuration((long)unit.toNanos(delay), (DurationUnit)DurationUnit.NANOSECONDS)));
                    }

                    private static final Unit schedule$lambda$0(Runnable $command) {
                        $command.run();
                        return Unit.INSTANCE;
                    }
                });
            }
            com.github.benmanes.caffeine.cache.Scheduler scheduler3 = c.getCaffeineScheduler();
            if (scheduler3 != null) {
                com.github.benmanes.caffeine.cache.Scheduler scheduler4 = scheduler3;
                boolean bl = false;
                caffeine.scheduler(scheduler4);
            }
            Intrinsics.checkNotNull((Object)caffeine);
            return new XCache(c, defaultScope, caffeine, null);
        }

        public static /* synthetic */ XCache cacheBuilder$default(Companion companion, Function1 function1, int n, Object object) {
            if ((n & 1) != 0) {
                function1 = Companion::cacheBuilder$lambda$0;
            }
            return companion.cacheBuilder(function1);
        }

        private static final Unit cacheBuilder$lambda$0(Configuration configuration) {
            Intrinsics.checkNotNullParameter((Object)configuration, (String)"<this>");
            return Unit.INSTANCE;
        }

        private static final CoroutineScope cacheBuilder$lambda$1(Configuration $c) {
            CoroutineScope coroutineScope = $c.getScope();
            if (coroutineScope == null) {
                throw new IllegalStateException("not set scope".toString());
            }
            return coroutineScope;
        }

        private static final Unit cacheBuilder$lambda$3$lambda$2(Lazy $defaultScope, Function4 $listener, Object key2, Object value, RemovalCause cause) {
            BuildersKt.launch$default((CoroutineScope)((CoroutineScope)$defaultScope.getValue()), null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>($listener, key2, value, cause, null){
                int label;
                final /* synthetic */ Function4<K, V, RemovalCause, Continuation<? super Unit>, Object> $listener;
                final /* synthetic */ K $key;
                final /* synthetic */ V $value;
                final /* synthetic */ RemovalCause $cause;
                {
                    this.$listener = $listener;
                    this.$key = $key;
                    this.$value = $value;
                    this.$cause = $cause;
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
                            RemovalCause removalCause = this.$cause;
                            Intrinsics.checkNotNull((Object)removalCause);
                            this.label = 1;
                            Object object3 = this.$listener.invoke(this.$key, this.$value, (Object)removalCause, (Object)((Object)this));
                            if (object3 != object2) return Unit.INSTANCE;
                            return object2;
                        }
                        case 1: {
                            void $result;
                            ResultKt.throwOnFailure((Object)$result);
                            Object object3 = $result;
                            return Unit.INSTANCE;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                }
            }), (int)3, null);
            return Unit.INSTANCE;
        }

        private static final Unit cacheBuilder$lambda$5$lambda$4(Lazy $defaultScope, Function4 $listener, Object key2, Object value, RemovalCause cause) {
            BuildersKt.launch$default((CoroutineScope)((CoroutineScope)$defaultScope.getValue()), null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>($listener, key2, value, cause, null){
                int label;
                final /* synthetic */ Function4<K, V, RemovalCause, Continuation<? super Unit>, Object> $listener;
                final /* synthetic */ K $key;
                final /* synthetic */ V $value;
                final /* synthetic */ RemovalCause $cause;
                {
                    this.$listener = $listener;
                    this.$key = $key;
                    this.$value = $value;
                    this.$cause = $cause;
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
                            RemovalCause removalCause = this.$cause;
                            Intrinsics.checkNotNull((Object)removalCause);
                            this.label = 1;
                            Object object3 = this.$listener.invoke(this.$key, this.$value, (Object)removalCause, (Object)((Object)this));
                            if (object3 != object2) return Unit.INSTANCE;
                            return object2;
                        }
                        case 1: {
                            void $result;
                            ResultKt.throwOnFailure((Object)$result);
                            Object object3 = $result;
                            return Unit.INSTANCE;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                }
            }), (int)3, null);
            return Unit.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

