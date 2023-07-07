package dev.caio.study;

import dev.caio.study.domain.reader.providers.XMLReaderAppBlockClassesMetadataProvider;
import dev.caio.study.stax.reader.domain.listeners.XMLReaderListener;
import dev.caio.study.stax.reader.domain.listeners.impl.XMLUnmarshallingReaderListener;
import dev.caio.study.stax.reader.domain.providers.XMLMetadataProvider;
import dev.caio.study.stax.reader.domain.providers.XMLSchemaClassesProvider;
import dev.caio.study.stax.reader.infra.impl.StaxXMLReader;
import dev.caio.study.stax.reader.infra.impl.XMLSchemaClassesReflectionProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLReaderImplApplicationTests {
    @Test
    public void testXMLReader() {
        XMLMetadataProvider metadataProvider = new XMLReaderAppBlockClassesMetadataProvider();
        XMLReaderListener unmarshallingXMLReaderListener = new XMLUnmarshallingReaderListener(metadataProvider);
        StaxXMLReader xmlReader = new StaxXMLReader(unmarshallingXMLReaderListener);
    }

    @Test
    public void testSchemaClassesProviderUsingReflectionLib() {
        XMLSchemaClassesProvider schemaClassesProvider = new XMLSchemaClassesReflectionProvider("dev.caio.study.stax.schema");
        assertEquals(3, schemaClassesProvider.get().size());
    }
}
