package ru.job4j.tracker.oop;

public class Max {

    public int max(int left, int right) {
        return left > right ? left : right;
    }

    public int max(int left, int right, int first) {
        return max(left, max(right, first));
    }

    public int max(int left, int right, int first, int second) {
        int tmp = max(right, first, second);
        return max(left, tmp);
    }
}
