package com.herokuapp.the_internet.core.utils;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SingleCollector {
    public static <T> Collector<T, ?, T> toSingleton(final String element) {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException(element);
                    }
                    return list.get(0);
                }
        );
    }
}
