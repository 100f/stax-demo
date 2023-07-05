package dev.caio.study.xml.commons.formatter;

import dev.caio.study.xml.commons.formatter.exception.FieldFormattingException;

public interface FieldFormatter<T> {
    public T format(String fieldValue) throws FieldFormattingException;
}
