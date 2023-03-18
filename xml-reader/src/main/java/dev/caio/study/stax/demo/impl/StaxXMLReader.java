package dev.caio.study.stax.demo.impl;

import dev.caio.study.stax.demo.domain.XMLReader;
import dev.caio.study.stax.demo.domain.XMLReaderListener;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class StaxXMLReader extends XMLReader {
    public StaxXMLReader(List<XMLReaderListener> readerListeners) {
        super(readerListeners);
    }

    @Override
    public void read(String filePath) throws IOException {
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filePath));

            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();

                if (nextEvent.isStartDocument()) {
                    readerListeners.forEach(XMLReaderListener::onReadStart);
                }
                if (nextEvent.isEndDocument()) {
                    readerListeners.forEach(XMLReaderListener::onReadFinish);
                }
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    readerListeners.forEach(readerListener -> readerListener.onXmlElementReadStart(startElement.getName().toString()));
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    readerListeners.forEach(readerListener -> readerListener.onXmlElementReadFinish(endElement.getName().toString()));
                }
                if (nextEvent.isCharacters()) {
                    Characters characters = nextEvent.asCharacters();
                    readerListeners.forEach(readerListener -> readerListener.characters(characters.getData()));
                }
            }
        } catch (XMLStreamException e) {
            throw new IOException(e);
        }
    }
}
