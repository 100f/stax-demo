package dev.caio.study.stax.demo.domain;

import java.util.List;

public abstract class XMLReader implements FileReader {
    protected final List<XmlReaderListener> readerListeners;

    public XMLReader(List<XmlReaderListener> readerListeners) {
        this.readerListeners = readerListeners;
    }

}
