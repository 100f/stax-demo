package dev.caio.study.stax.reader.domain.metadata;

import dev.caio.study.xml.commons.enums.FieldFormat;
import dev.caio.study.xml.commons.formatter.FieldFormatter;
import dev.caio.study.xml.commons.formatter.exception.FieldFormattingException;

import java.lang.reflect.Method;

public interface FieldMetadata extends ElementMetadata {
    public FieldFormat getFormat();

    /**
     *
     * @return {@link Method} método do bloco pai para obter o valor desse campo.
     */
    public Method getter();

    /**
     *
     * @return {@link Method} método do bloco pai para atribuir o valor desse campo.
     */
    public Method setter();

    /**
     *
     * @param content {@link String} conteúdo lido que deverá passar pelo processo de formatação para ser armazenado.
     * @return Valor formatado, pode ser qualquer tipo.
     * @throws FieldFormattingException erro lançado ao falhar na conversão, normalmente definido pelo {@link FieldFormatter}.
     */
    public Object parseContent(String content) throws FieldFormattingException;

}
