package ru.job4j.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ru.job4j.stream.mapto.Person;

public class MinExampleMain {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        Optional<Person> youngestPerson = people.stream()
                .min(Comparator.comparing(Person::getAge)); //передаем в метод min() компаратор, который задает принцип поиска по значению поля age
        int age = youngestPerson.get().getAge(); //Метод min() возвращает значение типа Optional, поэтому в следующей строке мы получаем объект Person из обертки Optional и далее получаем его возраст
        System.out.println(age); //
    }
}