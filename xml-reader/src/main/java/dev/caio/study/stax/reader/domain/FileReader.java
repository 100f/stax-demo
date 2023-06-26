package dev.caio.study.stax.reader.domain;

import java.io.IOException;

public interface FileReader {
    void read(String filePath) throws IOException;
}
