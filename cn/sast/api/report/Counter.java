package cn.sast.api.report;

import cn.sast.common.IResFile;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class Counter<T> {
    private final ConcurrentHashMap<T, AtomicInteger> statistics = new ConcurrentHashMap<>();

    public void count(T item, Map<T, AtomicInteger> map) {
        if (map == null) throw new NullPointerException("map");
        
        AtomicInteger ai = map.computeIfAbsent(item, k -> new AtomicInteger());
        ai.incrementAndGet();
    }

    public void count(T item) {
        count(item, statistics);
    }

    public int get(T item) {
        AtomicInteger counter = statistics.get(item);
        return counter != null ? counter.get() : 0;
    }

    private Map<T, Integer> sortMap(Map<T, ? extends AtomicInteger> input) {
        Map<T, Integer> tempMap = new LinkedHashMap<>();
        input.forEach((k, v) -> tempMap.put(k, v.get()));
        
        Map<T, Integer> result = new LinkedHashMap<>();
        tempMap.entrySet().stream()
            .sorted(Map.Entry.<T, Integer>comparingByValue().reversed())
            .forEachOrdered(entry -> result.put(entry.getKey(), entry.getValue()));
        
        return result;
    }

    public void writeResults(IResFile file) throws IOException {
        if (file == null) throw new NullPointerException("file");
        
        Map<T, Integer> sortedStats = sortMap(statistics);
        if (sortedStats.isEmpty()) return;
        
        file.mkdirs();
        Path path = file.getPath();
        
        try (OutputStreamWriter writer = new OutputStreamWriter(
            Files.newOutputStream(path), StandardCharsets.UTF_8)) {
            
            writer.write("--------sort--------\n");
            sortedStats.keySet().stream()
                .sorted()
                .forEach(item -> {
                    try {
                        writer.write(item + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            
            writer.write("\n--------frequency--------\n");
            for (Map.Entry<T, Integer> entry : sortedStats.entrySet()) {
                writer.write(entry.getValue() + " " + entry.getKey() + "\n");
            }
        }
    }

    public boolean isNotEmpty() {
        return !statistics.isEmpty();
    }

    public void clear() {
        statistics.clear();
    }

    public int size() {
        return statistics.size();
    }
}