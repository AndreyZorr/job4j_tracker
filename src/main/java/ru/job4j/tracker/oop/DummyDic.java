package ru.job4j.tracker.oop;

public class DummyDic {

    public String engToRus() {
        String voice = "гапаксы.";
        return voice;
    }

    public static void main(String[] args) {
        DummyDic sanni = new DummyDic();
        String say = sanni.engToRus();
        System.out.println("Неизвестное слово, " + say);
    }
}
