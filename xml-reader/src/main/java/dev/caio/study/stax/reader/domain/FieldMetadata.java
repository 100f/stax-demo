package dev.caio.study.stax.reader.domain;

import dev.caio.study.xml.commons.schema.formatter.exception.FieldFormattingException;

import java.lang.reflect.Method;

public interface FieldMetadata extends ElementMetadata {
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
     * @throws FieldFormattingException erro lançado ao falhar na conversão, normalmente definido pelo {@link dev.caio.study.xml.commons.schema.formatter.FieldFormatter}.
     */
    public Object parseContent(String content) throws FieldFormattingException;
}
