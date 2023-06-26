package dev.caio.study.stax.reader.domain;

public class ElementPosition {
    private Long line;
    private Long column;

    public ElementPosition(Long line, Long column) {
        this.line = line;
        this.column = column;
    }

    public Long getLine() {
        return line;
    }

    public Long getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "[" + line + ", " + column + "]";
    }
}
