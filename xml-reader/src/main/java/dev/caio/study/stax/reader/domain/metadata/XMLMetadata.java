package dev.caio.study.stax.reader.domain.metadata;

import java.util.Collection;

/**
 * Contrato dos elementos que terão os metadados sobre as estruturas bases que compõem um arquivo XML, os blocos
 * (não há informação sobre os campos pois um bloco pode conter N campos, logo, essa informação não pertence a esse contrato,
 * mas sim ao contrato de bloco).
 */
public interface XMLMetadata {
    public Collection<? extends XMLBlockMetadata> getBlocksMetadata();
    public XMLBlockMetadata getBlockMetadata(String id);
}
