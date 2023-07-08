package dev.caio.study.stax.reader.infra.impl;

import dev.caio.study.stax.reader.domain.metadata.XMLBlockMetadata;
import dev.caio.study.stax.reader.domain.metadata.XMLMetadata;

import java.util.Collection;
import java.util.Map;

public class XMLMetadataImpl implements XMLMetadata {

    private final Map<String, XMLBlockMetadataImpl> xmlBlocksMetadata;

    public XMLMetadataImpl(Map<String, XMLBlockMetadataImpl> xmlBlocksMetadata) {
        this.xmlBlocksMetadata = xmlBlocksMetadata;
    }

    @Override
    public Collection<? extends XMLBlockMetadata> getBlocksMetadata() {
        return this.xmlBlocksMetadata.values();
    }

    @Override
    public XMLBlockMetadata getBlockMetadata(String id) {
        return this.xmlBlocksMetadata.get(id);
    }
}
