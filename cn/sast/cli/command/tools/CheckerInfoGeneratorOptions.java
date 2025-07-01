package cn.sast.cli.command.tools;

import cn.sast.api.config.CheckerInfoGenResult;
import cn.sast.framework.plugin.ConfigPluginLoader;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.OptionWithValuesKt;
import com.github.ajalt.clikt.parameters.types.BooleanKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class CheckerInfoGeneratorOptions extends OptionGroup {
    private static final Logger logger = LoggerFactory.getLogger(CheckerInfoGeneratorOptions.class);
    
    private final boolean genCheckerInfoJson;
    private final List<String> language;

    public CheckerInfoGeneratorOptions() {
        super("Generate checker_info.json for CoraxServer Options");
        
        ParameterHolder parameterHolder = this;
        String[] genCheckerInfoFlags = {"--gen-checker-info"};
        String[] pathComponents = {"CoraxUnCompressDir", "Corax", "Plugins", "Canary"};
        String pathSeparator = File.pathSeparator;
        String pathDescription = String.join(pathSeparator, pathComponents);
        
        this.genCheckerInfoJson = BooleanKt.boolean(
            OptionWithValuesKt.option(parameterHolder, genCheckerInfoFlags,
                "Generate checker_info.json from Corax/Corax/Plugins/Canary/analysis-config",
                "the \"" + pathDescription + "\" directory path",
                false
            )
        ).required().getValue();

        String[] languageFlags = {"--info-lang"};
        this.language = OptionWithValuesKt.multiple(
            OptionWithValuesKt.option(parameterHolder, languageFlags, "", null, false),
            List.of("zh-CN", "en-US"),
            false
        ).getValue();
    }

    public void run(@NotNull ConfigPluginLoader pl, @Nullable Set<String> rules) {
        if (pl == null) throw new NullPointerException("pl cannot be null");
        
        if (genCheckerInfoJson) {
            CheckerInfoGenerator generator = CheckerInfoGenerator.create(pl, language, false);
            if (generator == null) {
                System.exit(2);
                return;
            }
            
            CheckerInfoGenResult checkerInfo = generator.getCheckerInfo(false);
            generator.dumpCheckerInfoJson(checkerInfo, true);
            generator.dumpRuleAndRuleMappingDB(checkerInfo, rules);
        }
        
        System.exit(0);
    }

    private static final class Companion {
        private Companion() {}
    }
}