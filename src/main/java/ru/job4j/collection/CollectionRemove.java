package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionRemove {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        for (String str : collection) {
            System.out.println(str);
        }
        collection.remove("two");
        System.out.println("Вывод содержимого коллекции после удаления");
        for (String str : collection) {
            System.out.println(str);
        }
    }
}

