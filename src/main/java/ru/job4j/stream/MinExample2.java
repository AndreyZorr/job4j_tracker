package ru.job4j.stream;

import java.util.*;
import java.util.stream.IntStream;

public class MinExample2 {
    public static void main(String[] args) {
        OptionalInt min = IntStream
                .rangeClosed(1, 5) //запустили поток примитивных чисел типа int
                .min(); //нашли минимальный из без передачи компаратора
        System.out.println(min.getAsInt()); //из этой обертки мы получаем само значение с помощью метода getAsInt()
    }
}
