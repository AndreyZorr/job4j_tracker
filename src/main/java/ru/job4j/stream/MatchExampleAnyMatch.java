package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExampleAnyMatch {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean rsl = strings
                .stream()
                .anyMatch(e -> e.endsWith("ь")); //проверка, что хотя бы одно значение потока
        // оканчивается на мягкий знак
        System.out.println(rsl);
    }
}