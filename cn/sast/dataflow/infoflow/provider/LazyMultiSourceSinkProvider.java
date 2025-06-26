/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.dataflow.infoflow.provider.LazyMultiSourceSinkProvider
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinition
 *  soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider
 */
package cn.sast.dataflow.infoflow.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinition;
import soot.jimple.infoflow.sourcesSinks.definitions.ISourceSinkDefinitionProvider;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00010\nj\u0002`\u000bJ\u0010\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\rH\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lcn/sast/dataflow/infoflow/provider/LazyMultiSourceSinkProvider;", "Lsoot/jimple/infoflow/sourcesSinks/definitions/ISourceSinkDefinitionProvider;", "<init>", "()V", "lazyProviders", "", "Lkotlin/Lazy;", "add", "", "provider", "Lkotlin/Function0;", "Lcn/sast/dataflow/infoflow/provider/LazySourceSinkProvider;", "getSources", "", "Lsoot/jimple/infoflow/sourcesSinks/definitions/ISourceSinkDefinition;", "getSinks", "getAllMethods", "size", "", "isEmpty", "toString", "", "corax-data-flow"})
@SourceDebugExtension(value={"SMAP\nLazyMultiSourceSinkProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyMultiSourceSinkProvider.kt\ncn/sast/dataflow/infoflow/provider/LazyMultiSourceSinkProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,35:1\n1454#2,5:36\n1454#2,5:41\n1454#2,5:46\n*S KotlinDebug\n*F\n+ 1 LazyMultiSourceSinkProvider.kt\ncn/sast/dataflow/infoflow/provider/LazyMultiSourceSinkProvider\n*L\n15#1:36,5\n19#1:41,5\n23#1:46,5\n*E\n"})
public final class LazyMultiSourceSinkProvider
implements ISourceSinkDefinitionProvider {
    @NotNull
    private final List<Lazy<ISourceSinkDefinitionProvider>> lazyProviders = new ArrayList();

    public final boolean add(@NotNull Function0<? extends ISourceSinkDefinitionProvider> provider) {
        Intrinsics.checkNotNullParameter(provider, (String)"provider");
        return this.lazyProviders.add(LazyKt.lazy(provider));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<? extends ISourceSinkDefinition> getSources() {
        void var2_2;
        void $this$flatMapTo$iv;
        Iterable iterable = this.lazyProviders;
        Collection destination$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            Lazy it = (Lazy)element$iv;
            boolean bl = false;
            Collection collection = ((ISourceSinkDefinitionProvider)it.getValue()).getSources();
            Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"getSources(...)");
            Iterable list$iv = collection;
            CollectionsKt.addAll((Collection)destination$iv, (Iterable)list$iv);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<? extends ISourceSinkDefinition> getSinks() {
        void var2_2;
        void $this$flatMapTo$iv;
        Iterable iterable = this.lazyProviders;
        Collection destination$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            Lazy it = (Lazy)element$iv;
            boolean bl = false;
            Collection collection = ((ISourceSinkDefinitionProvider)it.getValue()).getSinks();
            Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"getSinks(...)");
            Iterable list$iv = collection;
            CollectionsKt.addAll((Collection)destination$iv, (Iterable)list$iv);
        }
        return var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public Collection<? extends ISourceSinkDefinition> getAllMethods() {
        void var2_2;
        void $this$flatMapTo$iv;
        Iterable iterable = this.lazyProviders;
        Collection destination$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv : $this$flatMapTo$iv) {
            Lazy it = (Lazy)element$iv;
            boolean bl = false;
            Collection collection = ((ISourceSinkDefinitionProvider)it.getValue()).getAllMethods();
            Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"getAllMethods(...)");
            Iterable list$iv = collection;
            CollectionsKt.addAll((Collection)destination$iv, (Iterable)list$iv);
        }
        return var2_2;
    }

    public final int size() {
        return this.lazyProviders.size();
    }

    public final boolean isEmpty() {
        return this.lazyProviders.isEmpty();
    }

    @NotNull
    public String toString() {
        return "MultiSourceSinkProvider(" + this.lazyProviders.size() + ")";
    }
}

