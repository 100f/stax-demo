package dev.caio.study.stax.reader.listeners.impl;

import dev.caio.study.stax.reader.domain.ElementPosition;
import dev.caio.study.stax.reader.domain.listeners.XMLReaderListener;
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
    public void onXmlElementReadStart(String startTagName, ElementPosition position) {
        log.info(position + " - Abertura de bloco: " + startTagName);
    }

    @Override
    public void onXmlElementReadFinish(String endTagName, ElementPosition position) {
        log.info(position + " - Fechamento de bloco: " + endTagName);
    }

    @Override
    public void characters(String content, ElementPosition position) {
        log.info(position + " - Conteúdo lido: " + content);
    }
}
