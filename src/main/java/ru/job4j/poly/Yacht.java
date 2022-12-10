package ru.job4j.poly;

public class Yacht implements Vehicle  {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - плавает по воде.");
    }
}
