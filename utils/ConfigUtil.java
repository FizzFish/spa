/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  utils.ConfigUtil
 */
package utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    public static Properties getProperties(String configPath) {
        Properties p = null;
        if (configPath == null || "".equals(configPath)) {
            return p;
        }
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(configPath));
            p = new Properties();
            p.load(in);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}

