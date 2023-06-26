package dev.caio.study.stax.reader.impl;

import dev.caio.study.stax.reader.domain.XMLElement;
import dev.caio.study.stax.reader.domain.XMLReaderListener;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class XMLUnmarshallingReaderListener implements XMLReaderListener {
    private final Deque<XMLElement> readElementsStack;
    private String currentReadTextContent;

    public XMLUnmarshallingReaderListener() {
        readElementsStack = new LinkedBlockingDeque<>();
    }
    @Override
    public void onReadStart() {

    }

    @Override
    public void onReadFinish() {
        readElementsStack.clear();
    }

    @Override
    public void onXmlElementReadStart(String startTagName) {
        clearCurrentReadTextContent();
    }

    @Override
    public void onXmlElementReadFinish(String endTagName) {

    }

    @Override
    public void characters(String content) {
        this.currentReadTextContent = content;
    }

    private void clearCurrentReadTextContent() {
        currentReadTextContent = null;
    }
}
