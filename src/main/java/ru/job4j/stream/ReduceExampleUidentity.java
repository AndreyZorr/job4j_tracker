package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;
import java.util.Arrays;
import java.util.List;

public class ReduceExampleUidentity {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.stream()
                .reduce(
                        0, // задаем первый параметр метода reduce() - identity, равный 0, так как суммировать будем с нуля
                        (a, b) -> { // этом шаге будет создан новый поток
                            if (b.getAge() > 25) { // // с отобранными по условию числами 35, 26 и 29
                                return a + b.getAge();
                            } else {
                                return a;
                            }
                        },
                        (a, b) -> a + b //выполняем бинарную операцию
                        // по суммированию всех элементов.
                        // На этом шаге складываются числа из предыдущего шага:
                );
        System.out.println(sum);
    }
}