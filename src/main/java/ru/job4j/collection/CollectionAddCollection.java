package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionAddCollection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        Collection<String> list = new ArrayList<>();
        list.addAll(collection);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
