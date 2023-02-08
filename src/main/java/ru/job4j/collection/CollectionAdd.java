package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionAdd {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        for (String str : collection) {
            System.out.println(str);
        }
    }
}
