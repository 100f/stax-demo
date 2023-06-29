package dev.caio.study.stax.reader.domain;

import dev.caio.study.stax.reader.domain.listeners.XMLReaderListener;

public abstract class XMLReader implements FileReader {
    protected final XMLReaderListener readerListener;

    public XMLReader(XMLReaderListener readerListener) {
        this.readerListener = readerListener;
    }

}
