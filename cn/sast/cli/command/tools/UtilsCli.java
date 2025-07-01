package cn.sast.cli.command.tools;

import cn.sast.cli.ApplicationKt;
import com.github.ajalt.clikt.core.CliktCommand;
import com.github.ajalt.clikt.core.Context;
import com.github.ajalt.clikt.output.MordantHelpFormatter;
import com.github.ajalt.clikt.parameters.options.option;
import com.github.ajalt.clikt.parameters.options.required;
import com.github.ajalt.clikt.parameters.types.file;
import com.github.doyaaaaaken.kotlincsv.client.CsvReader;
import com.github.doyaaaaaken.kotlincsv.client.CsvWriter;
import com.github.doyaaaaaken.kotlincsv.client.ICsvFileWriter;
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader;
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class UtilsCli extends CliktCommand {
    private final File input;
    private final File output;
    private final List<String> csvDeleteColumns;

    public UtilsCli() {
        super("Utils");
        context { ctx -> ctx.helpFormatter = new MordantHelpFormatter(ctx, null, true, true); }
        
        versionOption(ApplicationKt.getVersion(), "--version", "Show the version and exit");
        
        input = option("-i").file().required().value();
        output = option("-o").file().required().value();
        csvDeleteColumns = option("--csv-d-c").multiple().value();
    }

    @Override
    public void run() {
        if (!csvDeleteColumns.isEmpty()) {
            List<String> columnNames = csvDeleteColumns.stream()
                .flatMap(s -> List.of(s.split(",")).stream())
                .collect(Collectors.toList());
            
            if (columnNames.stream().anyMatch(String::isEmpty)) {
                throw new IllegalStateException(columnNames + " has an empty string element");
            }
            
            if (input == null) throw new IllegalStateException("input is required");
            if (output == null) throw new IllegalStateException("output is required");
            
            CsvReader csvReader = csvReader();
            List<List<String>> rows = csvReader.readAll(input);
            List<String> header = rows.get(0);
            
            Set<Integer> columnIndices = new LinkedHashSet<>();
            for (String col : columnNames) {
                int idx = header.indexOf(col);
                if (idx == -1) {
                    throw new IllegalStateException(col + " not exists in header: " + header);
                }
                columnIndices.add(idx);
            }
            
            List<Integer> sortedIndices = new ArrayList<>(columnIndices);
            Collections.sort(sortedIndices);
            Collections.reverse(sortedIndices);
            
            CsvWriter csvWriter = csvWriter();
            csvWriter.open(output, false, writer -> {
                for (List<String> row : rows) {
                    List<String> newRow = new ArrayList<>(row);
                    for (int idx : sortedIndices) {
                        newRow.remove(idx);
                    }
                    writer.writeRow(newRow);
                }
            });
        }
    }
}
