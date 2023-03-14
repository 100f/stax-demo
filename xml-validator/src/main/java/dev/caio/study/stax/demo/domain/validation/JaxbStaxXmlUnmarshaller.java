package dev.caio.study.stax.demo.domain.validation;

import dev.caio.study.stax.demo.domain.exception.UnmarshallingException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class JaxbStaxXmlUnmarshaller implements Unmarshaller {
    @Override
    public <T> T unmarshal(String content, Class<T> clazz) throws UnmarshallingException {
        return jaxbStaxUnmarshal(new StringReader(content), clazz);
    }

    @Override
    public <T> T unmarshal(File xmlFile, Class<T> clazz) throws UnmarshallingException {
        try {
            return jaxbStaxUnmarshal(new FileReader(xmlFile), clazz);
        } catch (FileNotFoundException e) {
            throw new UnmarshallingException("Arquivo não encontrado para conversão.");
        }
    }

    private <T> T jaxbStaxUnmarshal(Reader reader, Class<T> clazz) throws UnmarshallingException {
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            JAXBElement<T> unmarshalledElement = jaxbContext.createUnmarshaller().unmarshal(xmlStreamReader, clazz);
            return unmarshalledElement.getValue();
        } catch (Exception e) {
            throw new UnmarshallingException(e);
        }
    }
}
