package cn.sast.cli.command;

import com.github.ajalt.clikt.completion.CompletionCandidates;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.FlagOption;
import com.github.ajalt.clikt.parameters.options.Option;
import com.github.ajalt.clikt.parameters.options.option;
import com.github.ajalt.clikt.parameters.options.required;
import com.github.ajalt.clikt.parameters.types.intType;
import org.jetbrains.annotations.Nullable;

public final class DataFlowOptions extends OptionGroup {
    private final Option<Boolean> enableDataFlow;
    private final Option<Boolean> enableCoverage;
    private final Option<Integer> factor1;
    private final Option<Integer> dataFlowInterProceduralCalleeTimeOut;

    public DataFlowOptions() {
        super("Data Flow Options");
        
        this.enableDataFlow = option("--enable-data-flow")
            .help("Set if the DataFlow engine shall be enabled")
            .required();
            
        this.enableCoverage = option("--enable-coverage")
            .flag()
            .help("Turn on static analysis code coverage reporting with Jacoco");
            
        this.factor1 = option("--factor1")
            .intType()
            .defaultValue(1);
            
        this.dataFlowInterProceduralCalleeTimeOut = option("--call-timeout")
            .help("TimeOut for data flow analysis interProcedural call TimeoutMillis (ms).")
            .intType()
            .defaultValue(1);
    }

    public boolean getEnableDataFlow() {
        return enableDataFlow.getValue();
    }

    public boolean getEnableCoverage() {
        return enableCoverage.getValue();
    }

    @Nullable
    public Integer getFactor1() {
        return factor1.getValue();
    }

    @Nullable
    public Integer getDataFlowInterProceduralCalleeTimeOut() {
        return dataFlowInterProceduralCalleeTimeOut.getValue();
    }
}