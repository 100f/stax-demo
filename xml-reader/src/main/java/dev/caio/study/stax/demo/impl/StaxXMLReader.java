package dev.caio.study.stax.demo.impl;

import dev.caio.study.stax.demo.core.XMLReader;
import dev.caio.study.stax.demo.core.XMLReaderListener;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class StaxXMLReader extends XMLReader {
    public StaxXMLReader(XMLReaderListener readerListener) {
        super(readerListener);
    }

    @Override
    public void read(String filePath) throws IOException {
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filePath));

            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();

                if (nextEvent.isStartDocument()) {
                    readerListener.onReadStart();
                }
                if (nextEvent.isEndDocument()) {
                    readerListener.onReadFinish();
                }
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    readerListener.onXmlElementReadStart(startElement.getName().getLocalPart());
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    readerListener.onXmlElementReadFinish(endElement.getName().toString());
                }
                if (nextEvent.isCharacters()) {
                    Characters characters = nextEvent.asCharacters();
                    readerListener.characters(characters.getData());
                }
            }
        } catch (XMLStreamException e) {
            throw new IOException(e);
        }
    }
}
