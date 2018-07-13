package com.mti.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<FROM_CLASS, TO_CLASS> {

    TO_CLASS convert(final FROM_CLASS from);

    default List<TO_CLASS> convert(final List<FROM_CLASS> fromList) {
        return fromList.stream().map(this::convert).collect(Collectors.toList());
    }
}

