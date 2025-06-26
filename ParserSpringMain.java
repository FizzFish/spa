/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ParserSpringMain
 *  analysis.Config
 *  analysis.CreateEdge
 *  analysis.ForwardTransformer
 *  com.google.common.io.MoreFiles
 *  com.google.common.io.RecursiveDeleteOption
 *  soot.Body
 *  soot.G
 *  soot.Pack
 *  soot.PackManager
 *  soot.PhaseOptions
 *  soot.Scene
 *  soot.SootClass
 *  soot.SootMethod
 *  soot.Transform
 *  soot.Transformer
 *  soot.options.Options
 *  utils.GenJimpleUtil
 */
import analysis.Config;
import analysis.CreateEdge;
import analysis.ForwardTransformer;
import com.google.common.io.MoreFiles;
import com.google.common.io.RecursiveDeleteOption;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import soot.Body;
import soot.G;
import soot.Pack;
import soot.PackManager;
import soot.PhaseOptions;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Transform;
import soot.Transformer;
import soot.options.Options;
import utils.GenJimpleUtil;

/*
 * Exception performing whole class analysis ignored.
 */
public class ParserSpringMain {
    public static String sourceDirectory = System.getProperty("user.dir") + File.separator + "../" + File.separator + "classes";
    public static String beanXml = System.getProperty("user.dir") + File.separator + "../" + File.separator + "classes" + File.separator + "bean.xml";
    public static String dependencyDirectory = System.getProperty("user.dir") + File.separator + "BOOT-INF" + File.separator + "lib";

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        ParserSpringMain.initializeSoot((String)sourceDirectory);
        Config.linkMainAndController = false;
        Config.linkSpringCGLIB_CallEntrySyntheticAndRequestMappingMethods = false;
        CreateEdge createEdge = new CreateEdge();
        String path = "config.properties";
        Config config = new Config();
        HashSet<String> bean_xml_paths = new HashSet<String>();
        bean_xml_paths.add(beanXml);
        config.bean_xml_paths.addAll(bean_xml_paths);
        createEdge.initCallGraph(config);
        Iterator iterator2 = Scene.v().getApplicationClasses().snapshotIterator();
        while (iterator2.hasNext()) {
            SootClass applicationClass = (SootClass)iterator2.next();
            for (SootMethod method : applicationClass.getMethods()) {
                if (method.isAbstract() || method.isNative()) continue;
                if (!method.hasActiveBody()) {
                    method.retrieveActiveBody();
                }
                Body body = method.getActiveBody();
                try {
                    method.setActiveBody(body);
                }
                catch (Exception e) {
                    System.err.println(method);
                    System.err.println(body);
                    System.err.println(e);
                }
            }
            GenJimpleUtil.write((SootClass)applicationClass);
        }
        List sync = Scene.v().getApplicationClasses().stream().flatMap(x -> x.getMethods().stream()).filter(x -> x.getName().contains("callEntry_synthetic")).collect(Collectors.toList());
        sync.addAll(Scene.v().getEntryPoints());
        Scene.v().setEntryPoints(sync);
        Pack pack = PackManager.v().getPack("cg");
        pack.apply();
        pack = PackManager.v().getPack("wjtp");
        pack.add(new Transform("wjtp.ForwardTrans", (Transformer)new ForwardTransformer(sourceDirectory)));
        pack.apply();
        long endTime = System.currentTimeMillis();
        System.out.println("run time: " + (double)(endTime - startTime) / 1000.0 + "s");
        Options.v().set_output_format(14);
        String opt = "sootOutput";
        if (new File(opt).exists()) {
            MoreFiles.deleteRecursively((Path)Paths.get(opt, new String[0]), (RecursiveDeleteOption[])new RecursiveDeleteOption[]{RecursiveDeleteOption.ALLOW_INSECURE});
        }
        Options.v().set_output_dir(opt);
        PackManager.v().writeOutput();
    }

    public static void initializeSoot(String sourceDirectory) {
        G.reset();
        ArrayList<String> dir = new ArrayList<String>();
        dir.add(sourceDirectory);
        System.out.println(dir);
        Options.v().set_process_dir(dir);
        Options.v().setPhaseOption("cg.spark", "on");
        Options.v().setPhaseOption("cg.spark", "verbose:true");
        Options.v().setPhaseOption("cg.spark", "enabled:true");
        Options.v().setPhaseOption("cg.spark", "propagator:worklist");
        Options.v().setPhaseOption("cg.spark", "simple-edges-bidirectional:false");
        Options.v().setPhaseOption("cg.spark", "on-fly-cg:true");
        Options.v().setPhaseOption("cg.spark", "double-set-old:hybrid");
        Options.v().setPhaseOption("cg.spark", "double-set-new:hybrid");
        Options.v().setPhaseOption("cg.spark", "set-impl:double");
        Options.v().setPhaseOption("cg.spark", "apponly:true");
        Options.v().setPhaseOption("cg.spark", "simple-edges-bidirectional:false");
        Options.v().set_verbose(true);
        Options.v().set_whole_program(true);
        Options.v().set_src_prec(1);
        Options.v().set_exclude(ParserSpringMain.excludedPackages());
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_no_bodies_for_excluded(true);
        Options.v().set_keep_line_number(true);
        Options.v().set_soot_classpath(ParserSpringMain.getSootClassPath());
        Options.v().set_output_format(1);
        Scene.v().loadNecessaryClasses();
        PhaseOptions.v().setPhaseOption("jb", "use-original-names:true");
    }

    private static String getSootClassPath() {
        String userdir = System.getProperty("user.dir");
        String javaHome = System.getProperty("java.home");
        if (javaHome == null || javaHome.equals("")) {
            throw new RuntimeException("Could not get property java.home!");
        }
        String sootCp = javaHome + File.separator + "lib" + File.separator + "rt.jar";
        sootCp = sootCp + File.pathSeparator + javaHome + File.separator + "lib" + File.separator + "jce.jar";
        File file = new File(dependencyDirectory);
        File[] fs = file.listFiles();
        if (fs != null) {
            for (File f : Objects.requireNonNull(fs)) {
                if (f.isDirectory()) continue;
                sootCp = sootCp + File.pathSeparator + dependencyDirectory + File.separator + f.getName();
            }
        }
        return sootCp;
    }

    private static List<String> excludedPackages() {
        ArrayList<String> excludedPackages = new ArrayList<String>();
        excludedPackages.add("javax.swing.*");
        excludedPackages.add("java.awt.*");
        excludedPackages.add("sun.awt.*");
        excludedPackages.add("com.sun.java.swing.*");
        excludedPackages.add("reactor.*");
        excludedPackages.add("net.sf.cglib.*");
        excludedPackages.add("org.springframework.*");
        excludedPackages.add("org.apache.poi.*");
        excludedPackages.add("com.mysql.*");
        excludedPackages.add("org.ehcache.impl.internal.*");
        excludedPackages.add("ch.qos.*");
        excludedPackages.add("org.apache.*");
        excludedPackages.add("org.eclipse.*");
        excludedPackages.add("java.util.*");
        return excludedPackages;
    }
}

