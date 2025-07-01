package cn.sast.cli.command.tools;

import cn.sast.api.config.CheckerInfo;
import cn.sast.cli.command.tools.CheckerInfoGenerator;
import cn.sast.common.IResFile;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JvmStreamsKt;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class CheckerInfoCompare {
    private static final Logger logger = LoggerFactory.getLogger(CheckerInfoCompare.class);
    private static final Json jsonFormat = CheckerInfoGenerator.getJsonFormat();
    private static final KSerializer<List<CheckerInfo>> infoSerializer = CheckerInfoGenerator.getInfoSerializer();

    public void compareWith(@NotNull Path output, @NotNull IResFile left, @NotNull IResFile right) throws IOException {
        List<CheckerInfo> checkerInfoList = readCheckerInfo(right);
        List<CheckerInfo> compareChecks = readCheckerInfo(left);

        Path out = output.resolve("compare-" + left.getName().replaceFirst("\\.\\w+$", ""));
        Files.createDirectories(out);

        logger.info("The computed diff between '{}' and '{}' yields the following result: {}", left, right, out);

        List<CheckerInfo> filteredCheckerInfo = checkerInfoList.stream()
                .filter(info -> "Java(canary)".equals(info.getAnalyzer()))
                .collect(Collectors.toList());

        List<String> checkIds = filteredCheckerInfo.stream()
                .map(CheckerInfo::getChecker_id)
                .collect(Collectors.toList());

        List<CheckerInfo> filteredCompareChecks = compareChecks.stream()
                .filter(info -> "Java(canary)".equals(info.getAnalyzer()))
                .collect(Collectors.toList());

        List<CheckerInfo> deleted = filteredCompareChecks.stream()
                .filter(info -> !checkIds.contains(info.getChecker_id()))
                .collect(Collectors.toList());

        writeDeletedInfo(out, deleted);
        writeCheckerNameMapping(out, deleted);

        Set<String> checkerIdAll = filteredCompareChecks.stream()
                .map(CheckerInfo::getChecker_id)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        List<String> newCheckers = checkIds.stream()
                .filter(id -> !checkerIdAll.contains(id))
                .collect(Collectors.toList());

        writeNewCheckers(out, newCheckers);
    }

    private List<CheckerInfo> readCheckerInfo(IResFile file) throws IOException {
        try (InputStream inputStream = Files.newInputStream(file.getPath())) {
            return JvmStreamsKt.decodeFromStream(jsonFormat, infoSerializer, inputStream);
        }
    }

    private void writeDeletedInfo(Path out, List<CheckerInfo> deleted) throws IOException {
        List<String> deletedIds = deleted.stream()
                .map(CheckerInfo::getChecker_id)
                .collect(Collectors.toList());

        logger.warn("[-] Deleted {} checker ids. [\n\t{}\n]", deletedIds.size(), 
                String.join("\n\t", deletedIds));

        Path deletedIdsPath = out.resolve("deleted-checker-ids.json");
        try (OutputStream outputStream = Files.newOutputStream(deletedIdsPath)) {
            JvmStreamsKt.encodeToStream(jsonFormat, 
                    BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.getStringSerializer()), 
                    deletedIds, outputStream);
        }

        Path deletedPath = out.resolve("deleted.json");
        try (OutputStream outputStream = Files.newOutputStream(deletedPath)) {
            JvmStreamsKt.encodeToStream(jsonFormat, infoSerializer, deleted, outputStream);
        }
    }

    private void writeCheckerNameMapping(Path out, List<CheckerInfo> deleted) throws IOException {
        Map<String, String> mapping = new LinkedHashMap<>();
        for (CheckerInfo info : deleted) {
            mapping.put(info.getChecker_id(), "");
        }

        Path mappingPath = out.resolve("checker_name_mapping.json");
        try (OutputStream outputStream = Files.newOutputStream(mappingPath)) {
            JvmStreamsKt.encodeToStream(jsonFormat, 
                    BuiltinSerializersKt.MapSerializer(
                            BuiltinSerializersKt.getStringSerializer(), 
                            BuiltinSerializersKt.getStringSerializer()), 
                    mapping, outputStream);
        }
    }

    private void writeNewCheckers(Path out, List<String> newCheckers) throws IOException {
        logger.info("[+] New {} checker ids: [\n\t{}\n]", newCheckers.size(), 
                String.join("\n\t", newCheckers));

        Path newPath = out.resolve("new.json");
        try (OutputStream outputStream = Files.newOutputStream(newPath)) {
            JvmStreamsKt.encodeToStream(jsonFormat, 
                    BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.getStringSerializer()), 
                    newCheckers, outputStream);
        }
    }
}
