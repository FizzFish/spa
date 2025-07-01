package cn.sast.framework.report.sarif;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class ToolComponent {
    @NotNull private final String name;
    @NotNull private final String organization;
    @NotNull private final String version;
    @NotNull private final List<Rule> rules;

    public ToolComponent(@NotNull String name, @NotNull String organization, 
                        @NotNull String version, @NotNull List<Rule> rules) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (organization == null) throw new IllegalArgumentException("organization cannot be null");
        if (version == null) throw new IllegalArgumentException("version cannot be null");
        if (rules == null) throw new IllegalArgumentException("rules cannot be null");
        
        this.name = name;
        this.organization = organization;
        this.version = version;
        this.rules = rules;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getOrganization() {
        return organization;
    }

    @NotNull
    public String getVersion() {
        return version;
    }

    @NotNull
    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ToolComponent)) return false;
        
        ToolComponent that = (ToolComponent) other;
        return name.equals(that.name) &&
               organization.equals(that.organization) &&
               version.equals(that.version) &&
               rules.equals(that.rules);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + organization.hashCode();
        result = 31 * result + version.hashCode();
        result = 31 * result + rules.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ToolComponent(name=" + name + 
               ", organization=" + organization + 
               ", version=" + version + 
               ", rules=" + rules + ")";
    }

    public ToolComponent copy(@NotNull String name, @NotNull String organization, 
                            @NotNull String version, @NotNull List<Rule> rules) {
        return new ToolComponent(name, organization, version, rules);
    }
}