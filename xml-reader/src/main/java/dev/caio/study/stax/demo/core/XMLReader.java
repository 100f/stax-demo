package dev.caio.study.stax.demo.core;

public abstract class XMLReader implements FileReader {
    protected final XMLReaderListener readerListener;

    public XMLReader(XMLReaderListener readerListener) {
        this.readerListener = readerListener;
    }

}
