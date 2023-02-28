package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sergo@gmail.com", "Kuzmin Sergei Pavlovich");
        map.put("alpatoV_a_a@mail.ru", "Alpatov Andrey Anatolvech");
        map.put("peran@@yandex.ru", "Semin Pavel Ivanovich");
        map.put("sergo@gmail.com", "Kuzmin Sergei Pavlovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
