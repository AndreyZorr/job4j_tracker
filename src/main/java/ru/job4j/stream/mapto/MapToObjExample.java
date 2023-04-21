package ru.job4j.stream.mapto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapToObjExample {
    public static void main(String[] args) {
        List<String> list = IntStream.rangeClosed(1, 5) //создается поток из примитивных чисел int от 1 до 5 включительно
                .mapToObj(String::valueOf) // метод mapToObj() преобразует все элементы потока примитивного тип int в строки типа String
                .collect(Collectors.toList()); //
        System.out.println(list);
    }
}