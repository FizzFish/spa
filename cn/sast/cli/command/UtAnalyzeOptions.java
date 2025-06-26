/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.command.UtAnalyzeOptions
 *  com.github.ajalt.clikt.completion.CompletionCandidates
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.parameters.groups.OptionGroup
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues$DefaultImpls
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KProperty
 *  org.jetbrains.annotations.NotNull
 */
package cn.sast.cli.command;

import com.github.ajalt.clikt.completion.CompletionCandidates;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lcn/sast/cli/command/UtAnalyzeOptions;", "Lcom/github/ajalt/clikt/parameters/groups/OptionGroup;", "<init>", "()V", "enableUtAnalyze", "", "getEnableUtAnalyze", "()Z", "enableUtAnalyze$delegate", "Lkotlin/properties/ReadOnlyProperty;", "corax-cli"})
@SourceDebugExtension(value={"SMAP\nUtAnalyzeOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UtAnalyzeOptions.kt\ncn/sast/cli/command/UtAnalyzeOptions\n+ 2 Convert.kt\ncom/github/ajalt/clikt/parameters/options/OptionWithValuesKt__ConvertKt\n*L\n1#1,16:1\n35#2,6:17\n70#2:23\n82#2,4:24\n*S KotlinDebug\n*F\n+ 1 UtAnalyzeOptions.kt\ncn/sast/cli/command/UtAnalyzeOptions\n*L\n12#1:17,6\n12#1:23\n12#1:24,4\n*E\n"})
public final class UtAnalyzeOptions
extends OptionGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty enableUtAnalyze$delegate;

    /*
     * WARNING - void declaration
     */
    public UtAnalyzeOptions() {
        super("UtAnalyze Options", null, 2, null);
        CompletionCandidates completionCandidates;
        void $this$convert$iv$iv$iv;
        void $this$convert_u24default$iv;
        OptionWithValues optionWithValues = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null);
        String metavar$iv = "BOOL";
        Object completionCandidates$iv = null;
        void $this$convert$iv$iv = $this$convert_u24default$iv;
        boolean $i$f$convert = false;
        void var6_6 = $this$convert$iv$iv;
        Function1 metavar$iv$iv$iv = (Function1)new /* Unavailable Anonymous Inner Class!! */;
        boolean $i$f$convert2 = false;
        Function2 valueTransform$iv$iv$iv = (Function2)new /* Unavailable Anonymous Inner Class!! */;
        Function2 function2 = OptionWithValuesKt.defaultEachProcessor();
        Function2 function22 = OptionWithValuesKt.defaultAllProcessor();
        Function2 function23 = OptionWithValuesKt.defaultValidator();
        Function1 function1 = $this$convert$iv$iv$iv.getMetavarGetter();
        if (function1 == null) {
            function1 = metavar$iv$iv$iv;
        }
        if ((completionCandidates = $this$convert$iv$iv$iv.getExplicitCompletionCandidates()) == null) {
            completionCandidates = completionCandidates$iv;
        }
        this.enableUtAnalyze$delegate = OptionWithValuesKt.help((OptionWithValues)OptionWithValuesKt.required((OptionWithValues)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$convert$iv$iv$iv, (Function2)valueTransform$iv$iv$iv, (Function2)function2, (Function2)function22, (Function2)function23, null, (Function1)function1, null, null, (boolean)false, null, null, null, null, (CompletionCandidates)completionCandidates, null, (boolean)false, (boolean)false, (boolean)false, (int)253904, null)), (String)"Set if the UtAnalyze engine shall be enabled").provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
    }

    public final boolean getEnableUtAnalyze() {
        return (Boolean)this.enableUtAnalyze$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(UtAnalyzeOptions.class, "enableUtAnalyze", "getEnableUtAnalyze()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}

