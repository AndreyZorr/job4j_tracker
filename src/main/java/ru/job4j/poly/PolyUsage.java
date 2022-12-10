package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle yacht = new Yacht();
        Vehicle[] vehicles = new Vehicle[]{airplane, train, bus, yacht};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
