package cn.sast.framework.report.sqldelight;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Note {
    private final long id;
    @NotNull
    private final String kind;
    @NotNull
    private final String displayHint;
    private final long fileId;
    @NotNull
    private final String fileAbsPath;
    private final long line;
    @Nullable
    private final Long column;
    @NotNull
    private final String messageEn;
    @NotNull
    private final String messageZh;
    @Nullable
    private final Long noticesRegionId;
    @Nullable
    private final Long funcRegionId;

    public Note(long id, @NotNull String kind, @NotNull String displayHint, long fileId, 
                @NotNull String fileAbsPath, long line, @Nullable Long column, 
                @NotNull String messageEn, @NotNull String messageZh, 
                @Nullable Long noticesRegionId, @Nullable Long funcRegionId) {
        if (kind == null) throw new IllegalArgumentException("kind cannot be null");
        if (displayHint == null) throw new IllegalArgumentException("displayHint cannot be null");
        if (fileAbsPath == null) throw new IllegalArgumentException("fileAbsPath cannot be null");
        if (messageEn == null) throw new IllegalArgumentException("messageEn cannot be null");
        if (messageZh == null) throw new IllegalArgumentException("messageZh cannot be null");

        this.id = id;
        this.kind = kind;
        this.displayHint = displayHint;
        this.fileId = fileId;
        this.fileAbsPath = fileAbsPath;
        this.line = line;
        this.column = column;
        this.messageEn = messageEn;
        this.messageZh = messageZh;
        this.noticesRegionId = noticesRegionId;
        this.funcRegionId = funcRegionId;
    }

    public long getId() {
        return id;
    }

    @NotNull
    public String getKind() {
        return kind;
    }

    @NotNull
    public String getDisplayHint() {
        return displayHint;
    }

    public long getFileId() {
        return fileId;
    }

    @NotNull
    public String getFileAbsPath() {
        return fileAbsPath;
    }

    public long getLine() {
        return line;
    }

    @Nullable
    public Long getColumn() {
        return column;
    }

    @NotNull
    public String getMessageEn() {
        return messageEn;
    }

    @NotNull
    public String getMessageZh() {
        return messageZh;
    }

    @Nullable
    public Long getNoticesRegionId() {
        return noticesRegionId;
    }

    @Nullable
    public Long getFuncRegionId() {
        return funcRegionId;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) return true;
        if (!(other instanceof Note)) return false;
        
        Note note = (Note) other;
        return id == note.id &&
               line == note.line &&
               fileId == note.fileId &&
               kind.equals(note.kind) &&
               displayHint.equals(note.displayHint) &&
               fileAbsPath.equals(note.fileAbsPath) &&
               messageEn.equals(note.messageEn) &&
               messageZh.equals(note.messageZh) &&
               (column == null ? note.column == null : column.equals(note.column)) &&
               (noticesRegionId == null ? note.noticesRegionId == null : noticesRegionId.equals(note.noticesRegionId)) &&
               (funcRegionId == null ? note.funcRegionId == null : funcRegionId.equals(note.funcRegionId));
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + kind.hashCode();
        result = 31 * result + displayHint.hashCode();
        result = 31 * result + Long.hashCode(fileId);
        result = 31 * result + fileAbsPath.hashCode();
        result = 31 * result + Long.hashCode(line);
        result = 31 * result + (column != null ? column.hashCode() : 0);
        result = 31 * result + messageEn.hashCode();
        result = 31 * result + messageZh.hashCode();
        result = 31 * result + (noticesRegionId != null ? noticesRegionId.hashCode() : 0);
        result = 31 * result + (funcRegionId != null ? funcRegionId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note(id=" + id + 
               ", kind=" + kind + 
               ", displayHint=" + displayHint + 
               ", fileId=" + fileId + 
               ", fileAbsPath=" + fileAbsPath + 
               ", line=" + line + 
               ", column=" + column + 
               ", messageEn=" + messageEn + 
               ", messageZh=" + messageZh + 
               ", noticesRegionId=" + noticesRegionId + 
               ", funcRegionId=" + funcRegionId + ")";
    }

    @NotNull
    public Note copy(long id, @NotNull String kind, @NotNull String displayHint, long fileId,
                    @NotNull String fileAbsPath, long line, @Nullable Long column,
                    @NotNull String messageEn, @NotNull String messageZh,
                    @Nullable Long noticesRegionId, @Nullable Long funcRegionId) {
        return new Note(id, kind, displayHint, fileId, fileAbsPath, line, column, 
                       messageEn, messageZh, noticesRegionId, funcRegionId);
    }
}