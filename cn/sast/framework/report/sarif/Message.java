package cn.sast.framework.report.sarif;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Message {
    @NotNull
    private final String text;
    @NotNull
    private final String markdown;

    public Message(@NotNull String text, @NotNull String markdown) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (markdown == null) {
            throw new IllegalArgumentException("markdown cannot be null");
        }
        this.text = text;
        this.markdown = markdown;
    }

    public Message(@NotNull String text) {
        this(text, "");
    }

    @NotNull
    public String getText() {
        return text;
    }

    @NotNull
    public String getMarkdown() {
        return markdown;
    }

    @NotNull
    public Message copy(@NotNull String text, @NotNull String markdown) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (markdown == null) {
            throw new IllegalArgumentException("markdown cannot be null");
        }
        return new Message(text, markdown);
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return text.equals(message.text) && markdown.equals(message.markdown);
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + markdown.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message(text=" + text + ", markdown=" + markdown + ")";
    }
}