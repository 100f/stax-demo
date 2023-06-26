package dev.caio.study.stax.reader.domain;

public class LineColumn {
    private Long line;
    private Long column;

    public LineColumn(Long line, Long column) {
        this.line = line;
        this.column = column;
    }

    public Long getLine() {
        return line;
    }

    public Long getColumn() {
        return column;
    }
}
