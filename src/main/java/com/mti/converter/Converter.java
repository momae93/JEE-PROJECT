package com.mti.converter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter Interface
 */
public interface Converter<FROM_CLASS, TO_CLASS> {

    /**
     * Convert FROM_CLASS to TO_CLASS
     * @param from Convert from
     * @return Return from to TO_CLASS
     */
    TO_CLASS convert(final FROM_CLASS from);

    /**
     * Convert a list of FROM_CLASS TO a list of TO_CLASS
     * @param fromList Convert list of fromList
     * @return Return list of from to a list of TO_CLASS
     */
    default List<TO_CLASS> convert(final List<FROM_CLASS> fromList) {
        return fromList.stream().map(this::convert).collect(Collectors.toList());
    }
}

