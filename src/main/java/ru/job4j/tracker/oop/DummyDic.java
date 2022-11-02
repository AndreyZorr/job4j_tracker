package ru.job4j.tracker.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String voice = "Неизвестное слово," + eng;
        return voice;
    }

    public static void main(String[] args) {
        DummyDic sanni = new DummyDic();
        String word = sanni.engToRus("гапаксы.");
        System.out.println(word);
    }
}
