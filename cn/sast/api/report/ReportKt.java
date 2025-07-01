package cn.sast.api.report;

import cn.sast.api.config.MainConfig;
import com.feysh.corax.config.api.BugMessage;
import com.feysh.corax.config.api.CheckType;
import com.feysh.corax.config.api.Language;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

public final class ReportKt {
    @NotNull
    public static byte[] md5(@NotNull String str) {
        Objects.requireNonNull(str, "str");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return messageDigest.digest(str.getBytes("UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException("MD5 calculation failed", e);
        }
    }

    @NotNull
    public static String toHex(@NotNull byte[] bytes) {
        Objects.requireNonNull(bytes, "bytes");
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static int xor2Int(@NotNull byte[] bytes) {
        Objects.requireNonNull(bytes, "bytes");
        int result = 123;
        for (byte b : bytes) {
            result = (result << 8) ^ b;
        }
        return result;
    }

    @NotNull
    public static String bugMessage(@NotNull CheckType checkType, @NotNull Language lang, @NotNull BugMessage.Env env) {
        Objects.requireNonNull(checkType, "checkType");
        Objects.requireNonNull(lang, "lang");
        Objects.requireNonNull(env, "env");

        BugMessage bugMessage = checkType.getBugMessage().get(lang);
        if (bugMessage != null) {
            String msg = bugMessage.getMsg();
            if (msg != null) {
                return msg;
            }
        }
        return lang + " not exists of checkType: " + checkType;
    }

    @NotNull
    public static Map<Language, String> bugMessage(@NotNull CheckType checkType, @NotNull BugMessage.Env env) {
        Objects.requireNonNull(checkType, "checkType");
        Objects.requireNonNull(env, "env");

        Map<Language, String> result = new LinkedHashMap<>();
        for (Language lang : Language.values()) {
            result.put(lang, bugMessage(checkType, lang, env));
        }
        return result;
    }

    @NotNull
    public static String getPerfectName(@NotNull CheckType checkType) {
        Objects.requireNonNull(checkType, "checkType");
        return checkType.getChecker().getClass().getSimpleName() + "." + checkType.getClass().getSimpleName();
    }

    public static <T> T preferredMessage(@NotNull Map<Language, ? extends T> messages, @NotNull Function<Void, ? extends T> defaultValue) {
        Objects.requireNonNull(messages, "messages");
        Objects.requireNonNull(defaultValue, "defaultValue");

        for (Language lang : MainConfig.getPreferredLanguages()) {
            T message = messages.get(lang);
            if (message != null) {
                return message;
            }
        }
        return defaultValue.apply(null);
    }
}