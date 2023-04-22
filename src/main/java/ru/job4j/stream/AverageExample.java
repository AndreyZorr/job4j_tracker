package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.*;

public class AverageExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        OptionalDouble average = people.stream()
                .mapToInt(Person::getAge) //поток объектов Person преобразовывается в поток int
                .average(); //возвращает среднее арифметическое всех элементов потока
        double avg = average.getAsDouble(); //Метод average() возвращает OptionalDouble, из которого мы получаем значение
        System.out.println(avg);
    }
}