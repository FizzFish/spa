/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  soot.Printer
 *  soot.SootClass
 *  soot.SourceLocator
 *  utils.GenJimpleUtil
 */
package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.Printer;
import soot.SootClass;
import soot.SourceLocator;

public class GenJimpleUtil {
    private static final Logger logger = LoggerFactory.getLogger(GenJimpleUtil.class);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void write(SootClass sClass) {
        OutputStream streamOut = null;
        try {
            File file3;
            File file2;
            String filename = SourceLocator.v().getFileNameFor(sClass, 3);
            String processProjectName = "PointerAnalysis";
            filename = "ShimpleResult" + File.separator + processProjectName + File.separator + filename;
            int i = filename.lastIndexOf(File.separator);
            String f1 = filename.substring(0, i);
            File file1 = new File(f1);
            if (!file1.exists()) {
                file1.mkdirs();
            }
            if (!(file2 = new File(filename)).exists()) {
                file2.createNewFile();
            }
            if ((file3 = new File("sootOutput")).exists()) {
                file3.delete();
            }
            streamOut = new FileOutputStream(filename);
            PrintWriter writerOut = new PrintWriter(new OutputStreamWriter(streamOut));
            Printer.v().printTo(sClass, writerOut);
            writerOut.flush();
            writerOut.close();
        }
        catch (Exception e) {
            logger.warn(e.getMessage());
        }
        finally {
            if (streamOut != null) {
                try {
                    streamOut.close();
                }
                catch (IOException e) {
                    logger.warn(e.getMessage());
                }
            }
        }
    }
}

