package dev.caio.study.stax.demo;

import dev.caio.study.stax.demo.domain.XMLReaderListener;
import dev.caio.study.stax.demo.impl.PrintingXMLReaderListener;
import dev.caio.study.stax.demo.impl.StaxXMLReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Collections;

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
