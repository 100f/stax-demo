package dev.caio.study.stax.reader.infra.impl;

import dev.caio.study.stax.reader.domain.XMLReader;
import dev.caio.study.stax.reader.domain.listeners.XMLReaderListener;
import dev.caio.study.stax.reader.infra.adapters.StaxPositionAdapter;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
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
                    StaxPositionAdapter startElementPosition = new StaxPositionAdapter(startElement.getLocation());
                    readerListener.onXmlElementReadStart(startElement.getName().getLocalPart(), startElementPosition);
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    StaxPositionAdapter endElementPosition = new StaxPositionAdapter(endElement.getLocation());
                    readerListener.onXmlElementReadFinish(endElement.getName().toString(), endElementPosition);
                }
                if (nextEvent.isCharacters()) {
                    Characters characters = nextEvent.asCharacters();
                    StaxPositionAdapter charactersPosition = new StaxPositionAdapter(characters.getLocation());
                    readerListener.characters(characters.getData(), charactersPosition);
                }
            }
            reader.close();
        } catch (XMLStreamException e) {
            throw new IOException(e);
        }
    }
}
