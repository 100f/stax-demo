package dev.caio.study.stax.schema;

import dev.caio.study.xml.commons.annotations.XMLBlock;
import dev.caio.study.xml.commons.annotations.XMLField;
import dev.caio.study.xml.commons.definitions.XMLBlockClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@XMLBlock(blockName = "root")
public class Root extends XMLBlockClass {
    @XMLField(name = "frozen")
    private Optional<String> frozen;
    @XMLField(name = "city")
    private Optional<String> city;
    @XMLField(name = "let")
    private Optional<String> let;
    @XMLField(name = "window")
    private Optional<String> window;
    @XMLField(name = "path")
    private Optional<Long> path;
}
