package dev.caio.study.stax.demo.domain;


public interface XMLReaderListener extends ReaderListener {
    void onXmlElementReadStart(String startTagName);
    void onXmlElementReadFinish(String endTagName);
    void characters(String content);
}
