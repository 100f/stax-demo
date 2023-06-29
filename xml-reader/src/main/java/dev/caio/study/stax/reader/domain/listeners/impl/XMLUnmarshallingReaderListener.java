package dev.caio.study.stax.reader.domain.listeners.impl;

import dev.caio.study.stax.reader.domain.ElementPosition;
import dev.caio.study.stax.reader.domain.XMLElement;
import dev.caio.study.stax.reader.domain.XMLFieldElement;
import dev.caio.study.stax.reader.domain.providers.XMLMetadataProvider;
import dev.caio.study.stax.reader.domain.listeners.XMLReaderListener;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class XMLUnmarshallingReaderListener implements XMLReaderListener {
    private final Deque<XMLElement> readElementsStack;
    private final XMLMetadataProvider xmlMetadataProvider;
    private String currentReadTextContent;

    /**
     * Ouvinte de leitura que deve gerar instâncias de classes que representam nós XML. Para tal, utiliza um provedor de metadados dedicado como dependência.
     * @param xmlMetadataProvider {@link XMLMetadataProvider} Provedor de metadados das classes destino que representam nós XML.
     */
    public XMLUnmarshallingReaderListener(final XMLMetadataProvider xmlMetadataProvider) {
        this.xmlMetadataProvider = xmlMetadataProvider;
        this.readElementsStack = new LinkedBlockingDeque<>();
    }
    @Override
    public void onReadStart() {
    }

    @Override
    public void onReadFinish() {
        readElementsStack.clear();
    }

    @Override
    public void onXmlElementReadStart(String startTagName, ElementPosition position) {
        clearCurrentReadTextContent();
        XMLElement latest = retrieveLatestReadElement();
        //criar
        this.readElementsStack.add(latest);
    }

    @Override
    public void onXmlElementReadFinish(String endTagName, ElementPosition position) {
        final XMLElement latest = retrieveLatestReadElement();
        if (latest.isField()) {
            XMLFieldElement latestFieldElement = (XMLFieldElement) latest;
            latestFieldElement.setFieldContent(currentReadTextContent);
        }
    }

    @Override
    public void characters(String content, ElementPosition position) {
        this.currentReadTextContent = content;
    }

    private void clearCurrentReadTextContent() {
        currentReadTextContent = null;
    }
    private XMLElement retrieveLatestReadElement() {
        return readElementsStack.peekFirst();
    }
}
