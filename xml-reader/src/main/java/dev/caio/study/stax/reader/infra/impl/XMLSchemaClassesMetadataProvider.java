package dev.caio.study.stax.reader.infra.impl;

import dev.caio.study.stax.reader.domain.metadata.XMLMetadata;
import dev.caio.study.stax.reader.domain.providers.XMLMetadataProvider;
import dev.caio.study.stax.reader.domain.providers.XMLSchemaClassesProvider;
import dev.caio.study.xml.commons.annotations.XMLBlock;
import dev.caio.study.xml.commons.definitions.XMLBlockClass;

public class XMLSchemaClassesMetadataProvider implements XMLMetadataProvider {
    private final XMLSchemaClassesProvider schemaClassesProvider;

    public XMLSchemaClassesMetadataProvider(XMLSchemaClassesProvider schemaClassesProvider) {
        this.schemaClassesProvider = schemaClassesProvider;
    }

    @Override
    public XMLMetadata get() {
        schemaClassesProvider.get().forEach(xmlSchemaClass -> {
            XMLBlock xmlBlockAnnotation = xmlSchemaClass.getAnnotation(XMLBlock.class);
            if (xmlBlockAnnotation == null) {
                throw new IllegalStateException("Anotação obrigatória " + XMLBlock.class.getName() + " não encontrada na classe herdeira de " + XMLBlockClass.class.getName() + " :" + xmlSchemaClass.getName() + ".");
            }
        });
        return null;
    }
}
