package dev.caio.study.stax.reader.domain.providers;

import dev.caio.study.stax.reader.domain.metadata.XMLMetadata;

import java.util.function.Supplier;

/**
 * Provedor de metadados obtidos das classes que correspondem aos nós XML de um arquivo.
 */
public interface XMLMetadataProvider extends Supplier<XMLMetadata> {
}
