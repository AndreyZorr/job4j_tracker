package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean rsl = strings
                .stream()
                .noneMatch("Шесть"::contains); // производится проверка, что значение "Шесть" отсутствует
        // в листе
        System.out.println(rsl);
    }
}