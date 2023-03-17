package dev.caio.study.stax.demo;

import dev.caio.study.stax.demo.domain.StaxXMLReader;
import dev.caio.study.stax.demo.domain.XMLReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class StAxReaderDemoApplication {

	public static void main(String[] args) {
		XMLReader reader = new StaxXMLReader(Collections.emptyList());
	}

}
