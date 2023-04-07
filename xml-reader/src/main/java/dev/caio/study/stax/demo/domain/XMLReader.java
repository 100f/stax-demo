package dev.caio.study.stax.demo.domain;

import java.util.List;

public abstract class XMLReader implements FileReader {
    protected final XMLReaderListener readerListener;

    public XMLReader(XMLReaderListener readerListener) {
        this.readerListener = readerListener;
    }

}
