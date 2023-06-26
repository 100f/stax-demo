package dev.caio.study.stax.reader.domain;


public interface XMLReaderListener extends ReaderListener {
    void onXmlElementReadStart(String startTagName, ElementPosition position);
    void onXmlElementReadFinish(String endTagName, ElementPosition position);
    void characters(String content, ElementPosition position);
}
