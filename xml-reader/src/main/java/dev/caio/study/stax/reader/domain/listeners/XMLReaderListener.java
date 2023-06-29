package dev.caio.study.stax.reader.domain.listeners;


import dev.caio.study.stax.reader.domain.ElementPosition;
import dev.caio.study.stax.reader.domain.listeners.ReaderListener;

public interface XMLReaderListener extends ReaderListener {
    void onXmlElementReadStart(String startTagName, ElementPosition position);
    void onXmlElementReadFinish(String endTagName, ElementPosition position);
    void characters(String content, ElementPosition position);
}
