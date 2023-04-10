package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        String[] st = {
                "image 11",
                "image 3",
                "image 2",
        };
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Arrays.sort(st, cmpText);
        for (String string : st) {
            System.out.println(string);
        }
        System.out.println();
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(left.length(), right.length());
                Arrays.sort(st, cmpDescSize);
        for (String string : st) {
            System.out.println(string);
        }
    }
}