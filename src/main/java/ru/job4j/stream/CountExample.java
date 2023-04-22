package ru.job4j.stream;

import java.util.*;

public class CountExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        long sum = nums.stream()
                .filter(el -> el % 2 == 0)
                .count(); //возвращает число элементов в потоке
        System.out.println(sum); //В данном примере из потока отбираются только четные числа, и подсчитывается их количество.
    }
}