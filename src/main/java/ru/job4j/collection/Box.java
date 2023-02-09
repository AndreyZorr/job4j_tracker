package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class Box {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
}
