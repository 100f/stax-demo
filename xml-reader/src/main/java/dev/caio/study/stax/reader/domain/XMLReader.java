package dev.caio.study.stax.reader.domain;

public abstract class XMLReader implements FileReader {
    protected final XMLReaderListener readerListener;

    public XMLReader(XMLReaderListener readerListener) {
        this.readerListener = readerListener;
    }

}
