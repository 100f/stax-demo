package dev.caio.study.stax.reader.infra.impl;

import dev.caio.study.stax.reader.domain.XMLMetadata;
import dev.caio.study.stax.reader.domain.providers.XMLMetadataProvider;
import dev.caio.study.xml.commons.schema.annotations.XMLBlock;
import dev.caio.study.xml.commons.schema.definitions.XMLBlockClass;

import java.util.Set;
import java.util.function.Supplier;

public class XMLConcreteExampleMetadataProvider implements XMLMetadataProvider {
    private static final String XML_SCHEMA_CLASSES_PACKAGE = "dev.caio.study.stack.schema";
    private final Supplier<Set<Class<? extends XMLBlockClass>>> xmlSchemaClassesListProvider;

    public XMLConcreteExampleMetadataProvider(Supplier<Set<Class<? extends XMLBlockClass>>> xmlSchemaClassesListProvider) {
        this.xmlSchemaClassesListProvider = xmlSchemaClassesListProvider;
    }

    @Override
    public XMLMetadata provide() {
        xmlSchemaClassesListProvider.get().forEach(xmlSchemaClass -> {
            XMLBlock xmlBlockAnnotation = xmlSchemaClass.getAnnotation(XMLBlock.class);
            if (xmlBlockAnnotation == null) {
                throw new IllegalStateException("Anotação obrigatória " + XMLBlock.class.getName() + " não encontrada na classe " + xmlSchemaClass.getName() + ".");
            }
        });
    }
}
