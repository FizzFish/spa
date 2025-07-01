package cn.sast.framework.report.sarif;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PhysicalLocation {
    @NotNull
    private final ArtifactLocation artifactLocation;
    @NotNull
    private final Region region;

    public PhysicalLocation(@NotNull ArtifactLocation artifactLocation, @NotNull Region region) {
        if (artifactLocation == null) {
            throw new IllegalArgumentException("artifactLocation cannot be null");
        }
        if (region == null) {
            throw new IllegalArgumentException("region cannot be null");
        }
        this.artifactLocation = artifactLocation;
        this.region = region;
    }

    @NotNull
    public ArtifactLocation getArtifactLocation() {
        return artifactLocation;
    }

    @NotNull
    public Region getRegion() {
        return region;
    }

    @NotNull
    public PhysicalLocation copy(@NotNull ArtifactLocation artifactLocation, @NotNull Region region) {
        if (artifactLocation == null) {
            throw new IllegalArgumentException("artifactLocation cannot be null");
        }
        if (region == null) {
            throw new IllegalArgumentException("region cannot be null");
        }
        return new PhysicalLocation(artifactLocation, region);
    }

    @Override
    public String toString() {
        return "PhysicalLocation(artifactLocation=" + artifactLocation + ", region=" + region + ")";
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof PhysicalLocation)) return false;
        PhysicalLocation that = (PhysicalLocation) other;
        return artifactLocation.equals(that.artifactLocation) && 
               region.equals(that.region);
    }

    @Override
    public int hashCode() {
        int result = artifactLocation.hashCode();
        result = 31 * result + region.hashCode();
        return result;
    }
}