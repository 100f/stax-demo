package dev.caio.study.stax.reader.infra.impl;

import dev.caio.study.stax.reader.domain.metadata.XMLMetadata;
import dev.caio.study.stax.reader.domain.providers.XMLMetadataProvider;
import dev.caio.study.stax.reader.domain.providers.XMLSchemaClassesProvider;
import dev.caio.study.xml.commons.annotations.XMLBlock;
import dev.caio.study.xml.commons.definitions.XMLBlockClass;

import java.util.IdentityHashMap;
import java.util.Map;

public class XMLSchemaClassesMetadataProvider implements XMLMetadataProvider {
    private final XMLSchemaClassesProvider schemaClassesProvider;

    /**
     * Mapa de metadados dos blocos XML a serem retornados dentro da implementação de {@link XMLMetadata} cuja chave
     * é o identificador obtido da da anotação {@link XMLBlock} e o valor é uma implementação de {@link dev.caio.study.stax.reader.domain.metadata.XMLBlockMetadata}.
     */
    private final Map<String, XMLBlockMetadataImpl> blockMetadataMap;

    public XMLSchemaClassesMetadataProvider(XMLSchemaClassesProvider schemaClassesProvider) {
        this.schemaClassesProvider = schemaClassesProvider;
        this.blockMetadataMap = new IdentityHashMap<>();
    }

    @Override
    public XMLMetadata get() {
        schemaClassesProvider.get().forEach(xmlSchemaClass -> {
            validateSchemaClass(xmlSchemaClass);
            addNewXMLBlockMetadataFrom(xmlSchemaClass);
        });
        return new XMLMetadataImpl(blockMetadataMap);
    }

    private void validateSchemaClass(Class<? extends XMLBlockClass> xmlSchemaClass) {
        XMLBlock xmlBlockAnnotation = xmlSchemaClass.getAnnotation(XMLBlock.class);
        if (xmlBlockAnnotation == null) {
            throw new IllegalStateException("Anotação obrigatória " + XMLBlock.class.getName() + " não encontrada na classe de schema" + xmlSchemaClass.getName() + " herdeira de " + XMLBlockClass.class.getName() + ".");
        }
        if (xmlBlockAnnotation.id() == null || xmlBlockAnnotation.id().isEmpty()) {
            throw new IllegalStateException("A classe de schema " + xmlSchemaClass.getName() + " não pode possuir um identificador vazio em sua anotação " + xmlBlockAnnotation.getClass().getName() + ".");
        }
        if (xmlBlockAnnotation.blockName() == null || xmlBlockAnnotation.blockName().isEmpty()) {
            throw new IllegalStateException("A classe de schema " + xmlSchemaClass.getName() + " não pode possuir um nome de bloco vazio em sua anotação " + xmlBlockAnnotation.getClass().getName() + ".");
        }
        if (blockMetadataMap.containsKey(xmlBlockAnnotation.id())) {
            throw new IllegalStateException("A classe de schema " + xmlSchemaClass.getName() + " possui um identificador já utilizado em sua anotação " + xmlBlockAnnotation.getClass().getName() + ". Identificador: " + xmlBlockAnnotation.id() + ".");
        }
    }

    private void addNewXMLBlockMetadataFrom(Class<? extends XMLBlockClass> xmlSchemaClass) {

    }
}
