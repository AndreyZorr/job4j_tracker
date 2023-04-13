package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> testName = (Person person) -> person.getName().equals(key);
        Predicate<Person> testSurname = (Person person) -> person.getSurname().equals(key);
        Predicate<Person> testPhone = (Person person) -> person.getPhone().equals(key);
        Predicate<Person> testAddress = (Person person) -> person.getAddress().equals(key);
        Predicate<Person> combine = testName.or(testSurname.or(testPhone.or(testAddress)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}