/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  utils.ConfigUtil
 *  utils.FileUtils
 */
package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import utils.ConfigUtil;

public class FileUtils {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void writeFile(String filePath, String filename, String sets) {
        OutputStreamWriter fw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(filePath + filename, true);
            out = new PrintWriter(fw);
            out.write(sets);
            out.println();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert (fw != null);
                fw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            assert (out != null);
            out.close();
        }
    }

    public static Set<String> getBeanXmlPaths(String configPath, String keyname) {
        LinkedHashSet<String> res = new LinkedHashSet<String>();
        if (configPath == null || "".equals(configPath)) {
            return res;
        }
        String property = ConfigUtil.getProperties((String)configPath).getProperty(keyname);
        if (property != null) {
            String[] split = property.split(",");
            Collections.addAll(res, split);
        }
        return res;
    }

    public static String getApplicationMain(String configPath, String keyname) {
        return ConfigUtil.getProperties((String)configPath).getProperty(keyname);
    }
}

