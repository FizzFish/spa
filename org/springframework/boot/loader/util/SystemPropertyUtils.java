/*
 * Decompiled with CFR 0.152.
 */
package org.springframework.boot.loader.util;

import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

public abstract class SystemPropertyUtils {
    public static final String PLACEHOLDER_PREFIX = "${";
    public static final String PLACEHOLDER_SUFFIX = "}";
    public static final String VALUE_SEPARATOR = ":";
    private static final String SIMPLE_PREFIX = "${".substring(1);

    public static String resolvePlaceholders(String text2) {
        if (text2 == null) {
            return text2;
        }
        return SystemPropertyUtils.parseStringValue(null, text2, text2, new HashSet<String>());
    }

    public static String resolvePlaceholders(Properties properties, String text2) {
        if (text2 == null) {
            return text2;
        }
        return SystemPropertyUtils.parseStringValue(properties, text2, text2, new HashSet<String>());
    }

    private static String parseStringValue(Properties properties, String value, String current, Set<String> visitedPlaceholders) {
        StringBuilder buf = new StringBuilder(current);
        int startIndex = current.indexOf(PLACEHOLDER_PREFIX);
        while (startIndex != -1) {
            int endIndex = SystemPropertyUtils.findPlaceholderEndIndex(buf, startIndex);
            if (endIndex != -1) {
                int separatorIndex;
                String placeholder = buf.substring(startIndex + PLACEHOLDER_PREFIX.length(), endIndex);
                String originalPlaceholder = placeholder;
                if (!visitedPlaceholders.add(originalPlaceholder)) {
                    throw new IllegalArgumentException("Circular placeholder reference '" + originalPlaceholder + "' in property definitions");
                }
                String propVal = SystemPropertyUtils.resolvePlaceholder(properties, value, placeholder = SystemPropertyUtils.parseStringValue(properties, value, placeholder, visitedPlaceholders));
                if (propVal == null && (separatorIndex = placeholder.indexOf(VALUE_SEPARATOR)) != -1) {
                    String actualPlaceholder = placeholder.substring(0, separatorIndex);
                    String defaultValue = placeholder.substring(separatorIndex + VALUE_SEPARATOR.length());
                    propVal = SystemPropertyUtils.resolvePlaceholder(properties, value, actualPlaceholder);
                    if (propVal == null) {
                        propVal = defaultValue;
                    }
                }
                if (propVal != null) {
                    propVal = SystemPropertyUtils.parseStringValue(properties, value, propVal, visitedPlaceholders);
                    buf.replace(startIndex, endIndex + PLACEHOLDER_SUFFIX.length(), propVal);
                    startIndex = buf.indexOf(PLACEHOLDER_PREFIX, startIndex + propVal.length());
                } else {
                    startIndex = buf.indexOf(PLACEHOLDER_PREFIX, endIndex + PLACEHOLDER_SUFFIX.length());
                }
                visitedPlaceholders.remove(originalPlaceholder);
                continue;
            }
            startIndex = -1;
        }
        return buf.toString();
    }

    private static String resolvePlaceholder(Properties properties, String text2, String placeholderName) {
        String propVal = SystemPropertyUtils.getProperty(placeholderName, null, text2);
        if (propVal != null) {
            return propVal;
        }
        return properties != null ? properties.getProperty(placeholderName) : null;
    }

    public static String getProperty(String key2) {
        return SystemPropertyUtils.getProperty(key2, null, "");
    }

    public static String getProperty(String key2, String defaultValue) {
        return SystemPropertyUtils.getProperty(key2, defaultValue, "");
    }

    public static String getProperty(String key2, String defaultValue, String text2) {
        try {
            String name;
            String propVal = System.getProperty(key2);
            if (propVal == null) {
                propVal = System.getenv(key2);
            }
            if (propVal == null) {
                name = key2.replace('.', '_');
                propVal = System.getenv(name);
            }
            if (propVal == null) {
                name = key2.toUpperCase(Locale.ENGLISH).replace('.', '_');
                propVal = System.getenv(name);
            }
            if (propVal != null) {
                return propVal;
            }
        }
        catch (Throwable ex) {
            System.err.println("Could not resolve key '" + key2 + "' in '" + text2 + "' as system property or in environment: " + ex);
        }
        return defaultValue;
    }

    private static int findPlaceholderEndIndex(CharSequence buf, int startIndex) {
        int index = startIndex + PLACEHOLDER_PREFIX.length();
        int withinNestedPlaceholder = 0;
        while (index < buf.length()) {
            if (SystemPropertyUtils.substringMatch(buf, index, PLACEHOLDER_SUFFIX)) {
                if (withinNestedPlaceholder > 0) {
                    --withinNestedPlaceholder;
                    index += PLACEHOLDER_SUFFIX.length();
                    continue;
                }
                return index;
            }
            if (SystemPropertyUtils.substringMatch(buf, index, SIMPLE_PREFIX)) {
                ++withinNestedPlaceholder;
                index += SIMPLE_PREFIX.length();
                continue;
            }
            ++index;
        }
        return -1;
    }

    private static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        for (int j = 0; j < substring.length(); ++j) {
            int i = index + j;
            if (i < str.length() && str.charAt(i) == substring.charAt(j)) continue;
            return false;
        }
        return true;
    }
}

