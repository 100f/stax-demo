package dev.caio.study.stax.reader.domain.adapters;

import dev.caio.study.stax.reader.domain.ElementPosition;

import javax.xml.stream.Location;

public class StaxPositionAdapter extends ElementPosition {
    public StaxPositionAdapter(final Location location) {
        super((long) location.getLineNumber(), (long) location.getColumnNumber());
    }
}
