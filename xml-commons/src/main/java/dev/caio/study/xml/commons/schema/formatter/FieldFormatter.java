package dev.caio.study.xml.commons.schema.formatter;

import dev.caio.study.xml.commons.schema.formatter.exception.FieldFormattingException;

public interface FieldFormatter<T> {
    public T format(String fieldValue) throws FieldFormattingException;
}
