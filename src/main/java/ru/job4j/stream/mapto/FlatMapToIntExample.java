package ru.job4j.stream.mapto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapToIntExample {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] array3 = {7, 8, 9};
        List<Integer> list = Stream.of(array1, array2, array3)//мы запускаем поток, состоящий из 3 массивов
                .flatMapToInt(Arrays::stream) //метод flatMapToInt() преобразует каждый элемент потока (массив) в поток примитивных чисел int
                .boxed()// чтобы собрать в List наш поток элементов типа int, нужно обернуть их в тип Integer. Это можно сделать с помощью метода boxed()
                .collect(Collectors.toList());
        System.out.println(list);
    }
}