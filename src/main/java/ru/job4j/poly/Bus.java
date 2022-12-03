package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Маршрут");

    }

    @Override
    public void passengers(int numbers) {
        System.out.println("Число пассажиров " + numbers);

    }

    @Override
    public int refuel(int quantity) {
        return quantity * 50;
    }
}
