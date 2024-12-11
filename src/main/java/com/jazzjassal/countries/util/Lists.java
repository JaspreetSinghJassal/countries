package com.jazzjassal.countries.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lists {

    /**
     * Merge content of two lists
     */
    public static <T> List<T> mergeLists(List<T> list1, List<T> list2) {
        return Stream.concat(list1.stream(), list2.stream()).toList();
    }

    /**
     * One-liner to sort a list of Strings
     */
    public static List<String> sort(List<String> list) {
        Collections.sort(list);
        return list;
    }
}
