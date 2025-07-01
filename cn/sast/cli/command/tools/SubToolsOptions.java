package cn.sast.cli.command.tools;

import cn.sast.cli.command.tools.CheckerInfoGeneratorKt;
import cn.sast.framework.plugin.ConfigPluginLoader;
import cn.sast.framework.plugin.PluginDefinitions;
import com.feysh.corax.config.api.CheckType;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.FlagOption;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.boolean;
import com.github.ajalt.clikt.parameters.options.option;
import com.github.ajalt.clikt.parameters.options.required;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import mu.KLogger;
import mu.KotlinLogging;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class SubToolsOptions extends OptionGroup {
    private static final KLogger logger = KotlinLogging.INSTANCE.logger(SubToolsOptions.class);
    private static final Json jsonFormat = Json.Default.copy(builder -> {
        builder.setUseArrayPolymorphism(true);
        builder.setPrettyPrint(true);
    });

    private final boolean subtools;
    private final boolean listRules;
    private final boolean listCheckTypes;

    public SubToolsOptions() {
        super("Sub tools Options");
        this.subtools = option("--subtools")
            .boolean()
            .required();
        this.listRules = option("--list-rules")
            .flag();
        this.listCheckTypes = option("--list-check-types")
            .flag();
    }

    public void run(@NotNull ConfigPluginLoader pl, @Nullable Set<String> rules) {
        if (!subtools) {
            System.exit(0);
            return;
        }

        PluginDefinitions pluginDefinitions = PluginDefinitions.Companion.load(pl.getPluginManager());
        List<CheckType> checkTypes = pluginDefinitions.getCheckTypeDefinition(CheckType.class)
            .stream()
            .map(PluginDefinitions.CheckTypeDefinition::getSingleton)
            .sorted(Comparator.comparing(CheckType::toString))
            .collect(Collectors.toList());

        if (listRules) {
            List<String> ruleIds = checkTypes.stream()
                .map(CheckerInfoGeneratorKt::getId)
                .collect(Collectors.toList());
            System.out.println(jsonFormat.encodeToString(ruleIds));
        }

        if (listCheckTypes) {
            List<String> checkTypeStrings = checkTypes.stream()
                .map(CheckType::toString)
                .collect(Collectors.toList());
            System.out.println(jsonFormat.encodeToString(checkTypeStrings));
        }

        System.exit(0);
    }
}
