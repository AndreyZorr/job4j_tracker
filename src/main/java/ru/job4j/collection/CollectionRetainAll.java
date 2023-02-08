package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionRetainAll {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        Collection<String> list = new ArrayList<>();
        list.add("two");
        for (String str : collection) {
            System.out.println(str);
        }
        collection.retainAll(list);
        System.out.println("Вывод содержимого коллекции после вызова retainAll");
        for (String str : collection) {
            System.out.println(str);
        }
    }
}
