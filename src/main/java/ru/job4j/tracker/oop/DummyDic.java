package ru.job4j.tracker.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово," + eng;
    }

    public static void main(String[] args) {
        DummyDic sanni = new DummyDic();
        String word = sanni.engToRus("гапаксы.");
        System.out.println(word);
    }
}
