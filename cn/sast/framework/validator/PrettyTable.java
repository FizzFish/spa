package cn.sast.framework.validator;

import java.io.Closeable;
import java.io.Flushable;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class PrettyTable implements Closeable, Flushable {
    private final PrintWriter out;
    private final List<List<String>> table;
    private final int columns;
    private List<Integer> blockSize;

    public PrettyTable(PrintWriter out, List<String> head) {
        if (out == null) throw new IllegalArgumentException("out cannot be null");
        if (head == null) throw new IllegalArgumentException("head cannot be null");
        
        this.out = out;
        this.table = new ArrayList<>();
        this.table.add(new ArrayList<>(head));
        this.columns = head.size();
        this.blockSize = head.stream()
            .map(String::length)
            .collect(Collectors.toList());
    }

    public void addLine(List<?> line) {
        if (line == null) throw new IllegalArgumentException("line cannot be null");
        if (line.size() != columns) throw new AssertionError("Line size must match columns");

        List<String> lineStr = line.stream()
            .map(obj -> obj != null ? obj.toString() : "")
            .collect(Collectors.toList());

        table.add(lineStr);

        blockSize = IntStream.range(0, columns)
            .map(i -> Math.max(blockSize.get(i), lineStr.get(i).length()))
            .boxed()
            .collect(Collectors.toList());
    }

    public void dump() {
        int lines = table.size();
        String normalBar = createBar("-");
        String doubleBar = createBar("=");

        out.println(normalBar);
        printLine(out, table.get(0));
        out.println(doubleBar);

        for (int i = 1; i < lines; i++) {
            printLine(out, table.get(i));
            out.println(normalBar);
        }
    }

    @Override
    public void flush() {
        out.flush();
    }

    @Override
    public void close() {
        out.close();
    }

    private String createBar(String fillChar) {
        return "+" + blockSize.stream()
            .map(size -> fillChar.repeat(size + 2))
            .collect(Collectors.joining("+")) + "+";
    }

    private void printLine(PrintWriter writer, List<String> line) {
        String formattedLine = IntStream.range(0, line.size())
            .mapToObj(i -> {
                String block = line.get(i);
                int totalSize = blockSize.get(i) - block.length() + 2;
                int leftSize = totalSize / 2;
                int rightSize = totalSize - leftSize;
                return " ".repeat(leftSize) + block + " ".repeat(rightSize);
            })
            .collect(Collectors.joining("|", "|", "|"));

        writer.println(formattedLine);
    }
}
