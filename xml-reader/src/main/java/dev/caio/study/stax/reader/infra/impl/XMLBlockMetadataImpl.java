package dev.caio.study.stax.reader.infra.impl;

import dev.caio.study.stax.reader.domain.metadata.XMLBlockMetadata;
import dev.caio.study.stax.reader.domain.metadata.XMLFieldMetadata;
import dev.caio.study.xml.commons.definitions.XMLBlockClass;

import java.util.Collection;
import java.util.Map;

public class XMLBlockMetadataImpl implements XMLBlockMetadata {
    private final String elementName;

    private final Map<String, XMLFieldMetadata> fieldsMetadata;

    private final Class<? extends XMLBlockClass> blockClass;

    public XMLBlockMetadataImpl(Class<? extends XMLBlockClass> blockClass, String blockName, Map<String, XMLFieldMetadata> fieldsMetadataMap) {
        this.blockClass = blockClass;
        this.elementName = blockName;
        this.fieldsMetadata = fieldsMetadataMap;
    }

    @Override
    public String getElementName() {
        return this.elementName;
    }

    @Override
    public Collection<? extends XMLFieldMetadata> getFieldsMetadata() {
        return this.fieldsMetadata.values();
    }

    @Override
    public XMLFieldMetadata getFieldMetadata(String fieldName) {
        return this.fieldsMetadata.get(fieldName);
    }

    @Override
    public Class<? extends XMLBlockClass> getBlockClass() {
        return this.blockClass;
    }
}
