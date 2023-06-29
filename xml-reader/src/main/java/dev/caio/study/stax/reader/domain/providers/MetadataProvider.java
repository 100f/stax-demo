package dev.caio.study.stax.reader.domain.providers;

public interface MetadataProvider<T> {
    public abstract T provide();
}
