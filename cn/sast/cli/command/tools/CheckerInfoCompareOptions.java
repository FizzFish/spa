package cn.sast.cli.command.tools;

import cn.sast.common.IResFile;
import cn.sast.common.Resource;
import com.github.ajalt.clikt.core.ParameterHolder;
import com.github.ajalt.clikt.parameters.groups.OptionGroup;
import com.github.ajalt.clikt.parameters.options.OptionWithValues;
import com.github.ajalt.clikt.parameters.options.required;
import com.github.ajalt.clikt.parameters.types.file;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;

public final class CheckerInfoCompareOptions extends OptionGroup {
    private static final Logger logger = LoggerFactory.getLogger(CheckerInfoCompareOptions.class);
    
    private final File compareRight;
    private final File compareLeft;

    public CheckerInfoCompareOptions() {
        super("Compare checker_info.json Options");
        this.compareRight = params().option("--compare-right")
                .help("Compare and diff an other checker_info.json")
                .file()
                .required();
        this.compareLeft = params().option("--compare-left")
                .help("Compare and diff an other checker_info.json")
                .file()
                .required();
    }

    private File getCompareRight() {
        return compareRight;
    }

    private File getCompareLeft() {
        return compareLeft;
    }

    public void run() {
        Path outputPath = prepareOutputPath();
        CheckerInfoCompare checkerInfoCompare = new CheckerInfoCompare();
        
        IResFile leftFile = Resource.INSTANCE.fileOf(getCompareLeft().getPath());
        IResFile rightFile = Resource.INSTANCE.fileOf(getCompareRight().getPath());
        
        checkerInfoCompare.compareWith(outputPath, leftFile, rightFile);
        System.exit(0);
    }

    private Path prepareOutputPath() {
        Path path = getCompareLeft().toPath().getParent().resolve("compare-result");
        
        if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            Files.createDirectories(path);
        }
        
        path = path.normalize();
        logger.info("The compare output path is: {}", path);
        return path;
    }
}