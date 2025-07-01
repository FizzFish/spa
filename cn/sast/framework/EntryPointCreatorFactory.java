package cn.sast.framework;

import cn.sast.api.util.OthersKt;
import cn.sast.common.IResource;
import cn.sast.common.Resource;
import com.feysh.corax.config.api.IMethodMatch;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SourceLocator;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public final class EntryPointCreatorFactory {
    private static final Logger logger = LoggerFactory.getLogger(EntryPointCreatorFactory.class);
    public static final EntryPointCreatorFactory INSTANCE = new EntryPointCreatorFactory();

    private EntryPointCreatorFactory() {
    }

    private void lookFromDir(Set<SootClass> res, IResource direction) {
        Scene scene = Scene.v();
        for (String cl : SourceLocator.v().getClassesUnder(direction.getAbsolutePath())) {
            SootClass theClass = scene.loadClass(cl, 2);
            res.add(theClass);
        }
    }

    private void loadClass(String className) {
        Scene.v().forceResolve(className, 3);
        Scene.v().loadClassAndSupport(className);
    }

    @NotNull
    public Supplier<Set<SootMethod>> getEntryPointFromArgs(@NotNull List<String> args) {
        if (args == null) {
            throw new IllegalArgumentException("args cannot be null");
        }
        return () -> createEntryPoints(args);
    }

    private static Set<SootMethod> createEntryPoints(List<String> args) {
        Set<SootMethod> methodSet = new LinkedHashSet<>();
        for (String arg : args) {
            IMethodMatch match = OthersKt.methodSignatureToMatcher(arg);
            if (match != null) {
                Scene scene = Scene.v();
                List<SootMethod> methods = match.matched(scene);
                if (methods.isEmpty()) {
                    throw new IllegalStateException("method: " + match + " not exists");
                }
                methodSet.addAll(methods);
                continue;
            }

            IResource res = Resource.INSTANCE.of(arg);
            if (!res.getExists()) {
                throw new IllegalStateException("invalidate " + arg);
            }
            if (!res.isFile()) {
                continue;
            }

            try (InputStreamReader isr = new InputStreamReader(
                    Files.newInputStream(res.getPath()), StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(isr)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("-")) {
                        continue;
                    }
                    String className = Scene.signatureToClass(line);
                    INSTANCE.loadClass(className);
                    SootMethod method = Scene.v().grabMethod(line);
                    if (method == null) {
                        throw new IllegalStateException("soot method: " + line + " not exists");
                    }
                    methodSet.add(method);
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to read file: " + arg, e);
            }
        }
        return methodSet;
    }
}
