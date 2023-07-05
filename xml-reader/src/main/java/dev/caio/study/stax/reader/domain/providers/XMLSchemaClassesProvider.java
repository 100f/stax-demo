package dev.caio.study.stax.reader.domain.providers;

import dev.caio.study.xml.commons.definitions.XMLBlockClass;

import java.util.Set;
import java.util.function.Supplier;

/**
 * Provedor de classes que herdam de {@link XMLBlockClass}, utilizado posteriormente por um {@link XMLMetadataProvider} para prover os metadados dessas
 * classes.
 */
public interface XMLSchemaClassesProvider extends Supplier<Set<Class<? extends XMLBlockClass>>> {
}
