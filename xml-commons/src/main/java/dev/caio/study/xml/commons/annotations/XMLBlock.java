package dev.caio.study.xml.commons.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marcador que deve ser utilizado para que o leitor de XML saiba qual nó (bloco) XML dada classe representa.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface XMLBlock {
    /**
     * Atributo obrigatório que define o nome exato do bloco dentro do arquivo XML que a classe representará.
     * @return {@link String} nome do bloco XML correspondente.
     */
    public String blockName();
}
