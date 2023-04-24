package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExampleAllMatch {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Трижды", "Три", "Триста", "Три тысячи");
        boolean rsl = strings
                .stream()
                .allMatch(e -> e.startsWith("Три")); //производится проверка, что все элементы потока
        // начинаются с "Три"
        System.out.println(rsl);
    }
}
