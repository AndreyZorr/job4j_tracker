package ru.job4j.tracker.oop;

public class Cat {

    private String name;

    public void show() {
        System.out.println(this.name);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("Garage.");
        Cat garage = new Cat();
        garage.giveNick("Garage, ate food.");
        garage.show();

    }

}