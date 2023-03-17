package dev.caio.study.stax.demo.domain;

import java.io.IOException;

public interface FileReader {
    void read(String filePath) throws IOException;
}
