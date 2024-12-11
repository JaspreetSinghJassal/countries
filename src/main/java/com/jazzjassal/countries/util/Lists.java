package com.jazzjassal.countries.util;

import java.util.List;
import java.util.stream.Stream;

public class Lists {

    public static <T> List<T> mergeLists(List<T> coll1, List<T> coll2) {
        return Stream.concat(coll1.stream(), coll2.stream()).toList();
    }
}
