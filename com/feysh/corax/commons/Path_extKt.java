package com.feysh.corax.commons;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public final class PathExt {
    private PathExt() {}

    public static String linesMatch(Path path, int max, Predicate<String> predicate) throws IOException {
        Objects.requireNonNull(path, "path cannot be null");
        Objects.requireNonNull(predicate, "predicate cannot be null");

        try (InputStream inputStream = Files.newInputStream(path, new OpenOption[0]);
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            int count = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (max > 0 && ++count > max) {
                    return null;
                }
                if (predicate.test(line)) {
                    return line;
                }
            }
        }
        return null;
    }
}