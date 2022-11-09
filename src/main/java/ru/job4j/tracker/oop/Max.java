package ru.job4j.tracker.oop;

public class Max {

    public int max(int left, int right) {
        return left > right ? left : right;
    }

    public int max(int left, int right, int top) {
        return max(left, max(right, top));
    }

    public int max(int left, int right, int top, int bottom) {
        return max(left, max(right, top, bottom));
    }
}
