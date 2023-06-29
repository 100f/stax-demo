package dev.caio.study.stax.reader;

import dev.caio.study.stax.reader.domain.listeners.XMLReaderListener;
import dev.caio.study.stax.reader.listeners.impl.PrintingXMLReaderListener;
import dev.caio.study.stax.reader.infra.impl.StaxXMLReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
class StAxFileReaderDemoApplicationTests {
	@Value("classpath:random.xml")
	Resource xmlFile;

	@Test
	void logToConsoleXmlReaderTest() throws IOException {
		XMLReaderListener printListener = new PrintingXMLReaderListener();
		StaxXMLReader reader = new StaxXMLReader(printListener);
		reader.read(xmlFile.getURI().getPath());
	}

}
