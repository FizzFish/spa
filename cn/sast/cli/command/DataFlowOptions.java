/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cn.sast.cli.command.DataFlowOptions
 *  cn.sast.cli.command.DataFlowOptions$special$$inlined$convert$default$2
 *  com.github.ajalt.clikt.completion.CompletionCandidates
 *  com.github.ajalt.clikt.core.ParameterHolder
 *  com.github.ajalt.clikt.parameters.groups.OptionGroup
 *  com.github.ajalt.clikt.parameters.options.FlagOptionKt
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues
 *  com.github.ajalt.clikt.parameters.options.OptionWithValues$DefaultImpls
 *  com.github.ajalt.clikt.parameters.options.OptionWithValuesKt
 *  com.github.ajalt.clikt.parameters.types.IntKt
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
 *  org.jetbrains.annotations.Nullable
 */
package cn.sast.cli.command;

import cn.sast.cli.command.DataFlowOptions$special$;
import com.github.ajalt.clikt.completion.CompletionCandidates;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.FlagOptionKt;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.IntKt;
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
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0015"}, d2={"Lcn/sast/cli/command/DataFlowOptions;", "Lcom/github/ajalt/clikt/parameters/groups/OptionGroup;", "<init>", "()V", "enableDataFlow", "", "getEnableDataFlow", "()Z", "enableDataFlow$delegate", "Lkotlin/properties/ReadOnlyProperty;", "enableCoverage", "getEnableCoverage", "enableCoverage$delegate", "factor1", "", "getFactor1", "()Ljava/lang/Integer;", "factor1$delegate", "dataFlowInterProceduralCalleeTimeOut", "getDataFlowInterProceduralCalleeTimeOut", "dataFlowInterProceduralCalleeTimeOut$delegate", "corax-cli"})
@SourceDebugExtension(value={"SMAP\nDataFlowOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataFlowOptions.kt\ncn/sast/cli/command/DataFlowOptions\n+ 2 Convert.kt\ncom/github/ajalt/clikt/parameters/options/OptionWithValuesKt__ConvertKt\n*L\n1#1,23:1\n35#2,6:24\n70#2:30\n82#2,4:31\n*S KotlinDebug\n*F\n+ 1 DataFlowOptions.kt\ncn/sast/cli/command/DataFlowOptions\n*L\n10#1:24,6\n10#1:30\n10#1:31,4\n*E\n"})
public final class DataFlowOptions
extends OptionGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty enableDataFlow$delegate;
    @NotNull
    private final ReadOnlyProperty enableCoverage$delegate;
    @NotNull
    private final ReadOnlyProperty factor1$delegate;
    @NotNull
    private final ReadOnlyProperty dataFlowInterProceduralCalleeTimeOut$delegate;

    /*
     * WARNING - void declaration
     */
    public DataFlowOptions() {
        super("Data Flow Options", null, 2, null);
        CompletionCandidates completionCandidates;
        void $this$convert$iv$iv$iv;
        void $this$convert_u24default$iv;
        String[] stringArray = OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null);
        String metavar$iv = "BOOL";
        Object completionCandidates$iv = null;
        void $this$convert$iv$iv = $this$convert_u24default$iv;
        boolean $i$f$convert = false;
        void var6_6 = $this$convert$iv$iv;
        Function1 metavar$iv$iv$iv = (Function1)new /* Unavailable Anonymous Inner Class!! */;
        boolean $i$f$convert2 = false;
        Function2 valueTransform$iv$iv$iv = (Function2)new special$$inlined$convert$default$2((OptionWithValues)$this$convert$iv$iv$iv);
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
        this.enableDataFlow$delegate = OptionWithValuesKt.help((OptionWithValues)OptionWithValuesKt.required((OptionWithValues)OptionWithValues.DefaultImpls.copy$default((OptionWithValues)$this$convert$iv$iv$iv, (Function2)valueTransform$iv$iv$iv, (Function2)function2, (Function2)function22, (Function2)function23, null, (Function1)function1, null, null, (boolean)false, null, null, null, null, (CompletionCandidates)completionCandidates, null, (boolean)false, (boolean)false, (boolean)false, (int)253904, null)), (String)"Set if the DataFlow engine shall be enabled").provideDelegate((ParameterHolder)this, $$delegatedProperties[0]);
        this.enableCoverage$delegate = OptionWithValuesKt.help((OptionWithValues)FlagOptionKt.flag$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)510, null), (String[])new String[0], (boolean)false, null, (int)6, null), (String)"Turn on static analysis code coverage reporting with Jacoco").provideDelegate((ParameterHolder)this, $$delegatedProperties[1]);
        this.factor1$delegate = IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])new String[0], null, null, (boolean)false, null, null, null, null, (boolean)false, (int)502, null), (boolean)false, (int)1, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[2]);
        String[] stringArray2 = new String[]{"--call-timeout"};
        stringArray = stringArray2;
        this.dataFlowInterProceduralCalleeTimeOut$delegate = IntKt.int$default((OptionWithValues)OptionWithValuesKt.option$default((ParameterHolder)((ParameterHolder)this), (String[])stringArray, (String)"TimeOut for data flow analysis interProcedural call TimeoutMillis (ms).", null, (boolean)true, null, null, null, null, (boolean)false, (int)500, null), (boolean)false, (int)1, null).provideDelegate((ParameterHolder)this, $$delegatedProperties[3]);
    }

    public final boolean getEnableDataFlow() {
        return (Boolean)this.enableDataFlow$delegate.getValue((Object)this, $$delegatedProperties[0]);
    }

    public final boolean getEnableCoverage() {
        return (Boolean)this.enableCoverage$delegate.getValue((Object)this, $$delegatedProperties[1]);
    }

    @Nullable
    public final Integer getFactor1() {
        return (Integer)this.factor1$delegate.getValue((Object)this, $$delegatedProperties[2]);
    }

    @Nullable
    public final Integer getDataFlowInterProceduralCalleeTimeOut() {
        return (Integer)this.dataFlowInterProceduralCalleeTimeOut$delegate.getValue((Object)this, $$delegatedProperties[3]);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(DataFlowOptions.class, "enableDataFlow", "getEnableDataFlow()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(DataFlowOptions.class, "enableCoverage", "getEnableCoverage()Z", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(DataFlowOptions.class, "factor1", "getFactor1()Ljava/lang/Integer;", 0))), Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(DataFlowOptions.class, "dataFlowInterProceduralCalleeTimeOut", "getDataFlowInterProceduralCalleeTimeOut()Ljava/lang/Integer;", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}

