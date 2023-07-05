package dev.caio.study.stax.reader.infra.impl;

import dev.caio.study.stax.reader.domain.XMLFieldMetadata;
import dev.caio.study.xml.commons.definitions.XMLBlockClass;
import dev.caio.study.xml.commons.enums.FieldFormat;
import dev.caio.study.xml.commons.formatter.FieldFormatter;
import dev.caio.study.xml.commons.formatter.exception.FieldFormattingException;

import java.lang.reflect.Method;

public class XMLFieldMetadataImpl implements XMLFieldMetadata {

    private final FieldFormat fieldFormat;

    private final FieldFormatter<?> fieldFormatter;

    private final String fieldName;

    public XMLFieldMetadataImpl(String fieldName,
                                FieldFormat fieldFormat,
                                Class<? extends XMLBlockClass> parentBlockClass) {
        this.fieldName = fieldName;
        this.fieldFormat = fieldFormat;
        this.fieldFormatter = fieldFormat.getFormatter();
    }

    @Override
    public String getElementName() {
        return this.fieldName;
    }


    @Override
    public Method getter() {
        return null;
    }

    @Override
    public Method setter() {
        return null;
    }

    @Override
    public Object parseContent(String content) throws FieldFormattingException {
        return this.fieldFormatter.format(content);
    }


    @Override
    public FieldFormat getFormat() {
        return this.fieldFormat;
    }
}
