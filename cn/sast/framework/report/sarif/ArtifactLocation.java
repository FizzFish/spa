package cn.sast.framework.report.sarif;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ArtifactLocation {
    @NotNull
    private final String uri;
    @NotNull
    private final String uriBaseId;

    public ArtifactLocation(@NotNull String uri, @NotNull String uriBaseId) {
        if (uri == null) {
            throw new IllegalArgumentException("uri cannot be null");
        }
        if (uriBaseId == null) {
            throw new IllegalArgumentException("uriBaseId cannot be null");
        }
        this.uri = uri;
        this.uriBaseId = uriBaseId;
    }

    public ArtifactLocation(@NotNull String uri) {
        this(uri, "");
    }

    @NotNull
    public String getUri() {
        return uri;
    }

    @NotNull
    public String getUriBaseId() {
        return uriBaseId;
    }

    @NotNull
    public ArtifactLocation copy(@NotNull String uri, @NotNull String uriBaseId) {
        if (uri == null) {
            throw new IllegalArgumentException("uri cannot be null");
        }
        if (uriBaseId == null) {
            throw new IllegalArgumentException("uriBaseId cannot be null");
        }
        return new ArtifactLocation(uri, uriBaseId);
    }

    @Override
    public String toString() {
        return "ArtifactLocation(uri=" + uri + ", uriBaseId=" + uriBaseId + ")";
    }

    @Override
    public int hashCode() {
        int result = uri.hashCode();
        result = 31 * result + uriBaseId.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactLocation)) {
            return false;
        }
        ArtifactLocation that = (ArtifactLocation) other;
        return uri.equals(that.uri) && uriBaseId.equals(that.uriBaseId);
    }
}