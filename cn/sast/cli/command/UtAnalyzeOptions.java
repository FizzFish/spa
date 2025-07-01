package cn.sast.cli.command;

import com.github.ajalt.clikt.completion.CompletionCandidates;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.Option;
import com.github.ajalt.clikt.parameters.options.option;
import com.github.ajalt.clikt.parameters.options.required;

public final class UtAnalyzeOptions extends OptionGroup {
    private final Option<Boolean> enableUtAnalyzeOption;

    public UtAnalyzeOptions() {
        super("UtAnalyze Options");
        this.enableUtAnalyzeOption = option("--enable-ut-analyze")
            .required()
            .help("Set if the UtAnalyze engine shall be enabled");
    }

    public boolean getEnableUtAnalyze() {
        return enableUtAnalyzeOption.getValue();
    }
}