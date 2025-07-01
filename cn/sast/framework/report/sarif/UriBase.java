package cn.sast.framework.report.sarif;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UriBase {
    @NotNull
    private final String uri;
    @Nullable
    private final Description description;

    public UriBase(@NotNull String uri, @Nullable Description description) {
        if (uri == null) {
            throw new IllegalArgumentException("uri cannot be null");
        }
        this.uri = uri;
        this.description = description;
    }

    public UriBase(@NotNull String uri) {
        this(uri, null);
    }

    @NotNull
    public String getUri() {
        return uri;
    }

    @Nullable
    public Description getDescription() {
        return description;
    }

    @NotNull
    public UriBase copy(@NotNull String uri, @Nullable Description description) {
        if (uri == null) {
            throw new IllegalArgumentException("uri cannot be null");
        }
        return new UriBase(uri, description);
    }

    @Override
    public String toString() {
        return "UriBase(uri=" + uri + ", description=" + description + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UriBase)) return false;
        UriBase uriBase = (UriBase) o;
        if (!uri.equals(uriBase.uri)) return false;
        return description != null ? description.equals(uriBase.description) : uriBase.description == null;
    }

    @Override
    public int hashCode() {
        int result = uri.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}