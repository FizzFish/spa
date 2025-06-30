/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 *  kotlin.sequences.SequencesKt
 *  org.jetbrains.annotations.NotNull
 *  soot.FastHierarchy
 *  soot.Hierarchy
 *  soot.RefLikeType
 *  soot.SootClass
 */
package com.feysh.corax.config.api.utils;

import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import soot.FastHierarchy;
import soot.Hierarchy;
import soot.RefLikeType;
import soot.SootClass;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0007\u001a\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0007\u00a8\u0006\u000b"}, d2={"getSubclassesOrImplementersOf", "", "Lsoot/SootClass;", "kotlin.jvm.PlatformType", "", "Lsoot/Hierarchy;", "sootClass", "(Lsoot/Hierarchy;Lsoot/SootClass;)Ljava/util/List;", "getAllSubclasses", "Lkotlin/sequences/Sequence;", "Lsoot/FastHierarchy;", "corax-config-api"})
public final class HierarchyExtKt {
    public static final List<SootClass> getSubclassesOrImplementersOf(@NotNull Hierarchy $this$getSubclassesOrImplementersOf, @NotNull SootClass sootClass) {
        Intrinsics.checkNotNullParameter((Object)$this$getSubclassesOrImplementersOf, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sootClass, (String)"sootClass");
        return sootClass.isInterface() ? $this$getSubclassesOrImplementersOf.getImplementersOf(sootClass) : $this$getSubclassesOrImplementersOf.getSubclassesOf(sootClass);
    }

    @Deprecated(message="Scene.v().activeHierarchy().getSubclassesOf()")
    @NotNull
    public static final Sequence<SootClass> getAllSubclasses(@NotNull FastHierarchy $this$getAllSubclasses, @NotNull SootClass sootClass) {
        Intrinsics.checkNotNullParameter((Object)$this$getAllSubclasses, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sootClass, (String)"sootClass");
        return SequencesKt.sequence((Function2)((Function2)new Function2<SequenceScope<? super SootClass>, Continuation<? super Unit>, Object>(sootClass, $this$getAllSubclasses, null){
            Object L$1;
            Object L$2;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ SootClass $sootClass;
            final /* synthetic */ FastHierarchy $this_getAllSubclasses;
            {
                this.$sootClass = $sootClass;
                this.$this_getAllSubclasses = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object var1_1) {
                var6_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$sequence = (SequenceScope)this.L$0;
                        if (!(this.$sootClass.getType() instanceof RefLikeType)) break;
                        subClasses = this.$this_getAllSubclasses.getSubclassesOf(this.$sootClass);
                        var4_5 = subClasses.iterator();
lbl9:
                        // 3 sources

                        while (var4_5.hasNext()) {
                            subClass = (SootClass)var4_5.next();
                            Intrinsics.checkNotNull((Object)subClass);
                            this.L$0 = $this$sequence;
                            this.L$1 = var4_5;
                            this.L$2 = subClass;
                            this.label = 1;
                            v0 = $this$sequence.yield((Object)subClass, (Continuation)this);
                            if (v0 == var6_2) {
                                return var6_2;
                            }
                            ** GOTO lbl27
                        }
                        break;
                    }
                    case 1: {
                        subClass = (SootClass)this.L$2;
                        var4_5 = (Iterator)this.L$1;
                        $this$sequence = (SequenceScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl27:
                        // 2 sources

                        Intrinsics.checkNotNull((Object)subClass);
                        this.L$0 = $this$sequence;
                        this.L$1 = var4_5;
                        this.L$2 = null;
                        this.label = 2;
                        v1 = $this$sequence.yieldAll(HierarchyExtKt.getAllSubclasses(this.$this_getAllSubclasses, subClass), (Continuation)this);
                        if (v1 != var6_2) ** GOTO lbl9
                        return var6_2;
                    }
                    case 2: {
                        var4_5 = (Iterator<E>)this.L$1;
                        $this$sequence = (SequenceScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
                        ** GOTO lbl9
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value;
                return (Continuation)var3_3;
            }

            public final Object invoke(SequenceScope<? super SootClass> p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }));
    }
}

