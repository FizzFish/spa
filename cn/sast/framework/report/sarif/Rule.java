package cn.sast.framework.report.sarif;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Rule {
    @NotNull
    private final String id;
    @NotNull
    private final String name;
    @NotNull
    private final MessageStrings messageStrings;

    public Rule(@NotNull String id, @NotNull String name, @NotNull MessageStrings messageStrings) {
        if (id == null) throw new IllegalArgumentException("id cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (messageStrings == null) throw new IllegalArgumentException("messageStrings cannot be null");
        this.id = id;
        this.name = name;
        this.messageStrings = messageStrings;
    }

    @NotNull
    public String getId() {
        return id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public MessageStrings getMessageStrings() {
        return messageStrings;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Rule)) return false;
        Rule rule = (Rule) other;
        return id.equals(rule.id) && 
               name.equals(rule.name) && 
               messageStrings.equals(rule.messageStrings);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + messageStrings.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Rule(id=" + id + ", name=" + name + ", messageStrings=" + messageStrings + ")";
    }

    @NotNull
    public Rule copy(@NotNull String id, @NotNull String name, @NotNull MessageStrings messageStrings) {
        return new Rule(id, name, messageStrings);
    }
}