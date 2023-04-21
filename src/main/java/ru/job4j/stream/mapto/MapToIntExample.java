package ru.job4j.stream.mapto;

import java.util.Arrays;
import java.util.List;

public class MapToIntExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.stream()
                .filter(e -> e.getAge() > 18)
                .mapToInt(Person::getAge) //метод flatMapToInt() преобразует каждый элемент потока (массив) в поток примитивных чисел int
                .peek(System.out::println)
                .sum(); //суммируем элементы полученного числового потока
        System.out.println("Сумма: " + sum);
    }
}