package dev.caio.study.stax.reader.domain.metadata;

import dev.caio.study.xml.commons.definitions.XMLBlockClass;

import java.util.Collection;

public interface XMLBlockMetadata extends ElementMetadata {
    public Collection<? extends XMLFieldMetadata> getFieldsMetadata();

    public XMLFieldMetadata getFieldMetadata(String fieldName);

    public Class<? extends XMLBlockClass> getBlockClass();
}
