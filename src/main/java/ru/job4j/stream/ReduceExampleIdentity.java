package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class ReduceExampleIdentity {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        int sum = nums.stream()
                .reduce(2, (a, b) -> a + b);
        System.out.println(sum);
    }
}
// Последовательность операций:
// 2(identity) + 1 = 3
//3 + 2 = 5
//5 + 3 = 8
//8 + 4 = 12
//Вывод: 12;