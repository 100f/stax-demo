package dev.caio.study.stax.demo.domain;

import java.util.List;

public abstract class XMLReader implements FileReader {
    protected final List<XMLReaderListener> readerListeners;

    public XMLReader(List<XMLReaderListener> readerListeners) {
        this.readerListeners = readerListeners;
    }

}
