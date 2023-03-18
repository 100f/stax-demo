package dev.caio.study.stax.demo.impl;

import dev.caio.study.stax.demo.domain.XMLReaderListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintingXMLReaderListener implements XMLReaderListener {
    @Override
    public void onReadStart() {
        log.info("Leitura iniciada...");
    }

    @Override
    public void onReadFinish() {
        log.info("Leitura finalizada...");
    }

    @Override
    public void onXmlElementReadStart(String startTagName) {
        log.info("Abertura de bloco: " + startTagName);
    }

    @Override
    public void onXmlElementReadFinish(String endTagName) {
        log.info("Fechamento de bloco: " + endTagName);
    }

    @Override
    public void characters(String content) {
        log.info("Conteúdo lido: " + content);
    }
}
