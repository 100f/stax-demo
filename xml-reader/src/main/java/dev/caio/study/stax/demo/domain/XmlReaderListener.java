package dev.caio.study.stax.demo.domain;

import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public interface XmlReaderListener extends ReaderListener {
    void onXmlElementReadStart(String startTagName);
    void onXmlElementReadFinish(String endTagName);
    void characters();
}
