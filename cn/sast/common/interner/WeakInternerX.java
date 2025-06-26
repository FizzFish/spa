/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.common.interner.InternerEquiv
 *  cn.sast.common.interner.WeakInternerX
 *  com.feysh.corax.commons.Kotlin_extKt
 *  com.google.common.base.Equivalence
 *  com.google.common.base.InternerEquals
 *  com.google.common.collect.Interner
 *  com.google.common.collect.Interners
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.jvm.internal.PropertyReference0
 *  kotlin.jvm.internal.PropertyReference0Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.properties.ReadWriteProperty
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.common.interner;

import cn.sast.common.interner.InternerEquiv;
import com.feysh.corax.commons.Kotlin_extKt;
import com.google.common.base.Equivalence;
import com.google.common.base.InternerEquals;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\t\u001a\u0002H\b\u00a2\u0006\u0002\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b\u00b2\u0006\n\u0010\f\u001a\u00020\u0001X\u008a\u0084\u0002\u00b2\u0006\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u008a\u008e\u0002"}, d2={"Lcn/sast/common/interner/WeakInternerX;", "", "<init>", "()V", "interner", "Lcom/google/common/collect/Interner;", "Lcn/sast/common/interner/InternerEquiv;", "intern", "E", "value", "(Lcn/sast/common/interner/InternerEquiv;)Lcn/sast/common/interner/InternerEquiv;", "corax-api", "map", "keyEquivalence", "Lcom/google/common/base/Equivalence;"})
public final class WeakInternerX {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Interner<InternerEquiv> interner;

    public WeakInternerX() {
        Interner interner = Interners.newWeakInterner();
        Intrinsics.checkNotNullExpressionValue((Object)interner, (String)"newWeakInterner(...)");
        this.interner = interner;
        ReadWriteProperty map$delegate = (ReadWriteProperty)Kotlin_extKt.delegateField$default((Object)this.interner, null, (int)1, null).provideDelegate(null, $$delegatedProperties[0]);
        ReadWriteProperty keyEquivalence$delegate = (ReadWriteProperty)Kotlin_extKt.delegateField$default((Object)WeakInternerX._init_$lambda$0((ReadWriteProperty)map$delegate), null, (int)1, null).provideDelegate(null, $$delegatedProperties[1]);
        WeakInternerX._init_$lambda$2((ReadWriteProperty)keyEquivalence$delegate, (Equivalence)((Equivalence)new InternerEquals()));
    }

    @NotNull
    public final <E extends InternerEquiv> E intern(@NotNull E value) {
        Intrinsics.checkNotNullParameter(value, (String)"value");
        InternerEquiv representative = (InternerEquiv)this.interner.intern(value);
        Intrinsics.checkNotNull((Object)representative, (String)"null cannot be cast to non-null type E of cn.sast.common.interner.WeakInternerX.intern");
        return (E)representative;
    }

    private static final Object _init_$lambda$0(ReadWriteProperty<Object, Object> $map$delegate) {
        return $map$delegate.getValue(null, $$delegatedProperties[0]);
    }

    private static final Equivalence<InternerEquiv> _init_$lambda$1(ReadWriteProperty<Object, Equivalence<InternerEquiv>> $keyEquivalence$delegate) {
        return (Equivalence)$keyEquivalence$delegate.getValue(null, $$delegatedProperties[1]);
    }

    private static final void _init_$lambda$2(ReadWriteProperty<Object, Equivalence<InternerEquiv>> $keyEquivalence$delegate, Equivalence<InternerEquiv> equivalence) {
        $keyEquivalence$delegate.setValue(null, $$delegatedProperties[1], equivalence);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property0((PropertyReference0)((PropertyReference0)new PropertyReference0Impl(WeakInternerX.class, "map", "<v#0>", 0))), Reflection.mutableProperty0((MutablePropertyReference0)((MutablePropertyReference0)new MutablePropertyReference0Impl(WeakInternerX.class, "keyEquivalence", "<v#1>", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}

