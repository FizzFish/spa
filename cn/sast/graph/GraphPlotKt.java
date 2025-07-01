package cn.sast.graph;

import cn.sast.common.IResFile;
import soot.util.dot.DotGraph;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class GraphPlotKt {
    public static void dump(DotGraph graph, IResFile output) throws IOException {
        if (graph == null) {
            throw new IllegalArgumentException("Graph cannot be null");
        }
        if (output == null) {
            throw new IllegalArgumentException("Output file cannot be null");
        }

        Path path = output.getPath();
        try (OutputStream out = Files.newOutputStream(path)) {
            graph.render(out, 0);
        }
    }
}