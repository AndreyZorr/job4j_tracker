package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenMax5To2Then5() {
        int left = 5;
        int right = 2;
        int expected = 5;
        int out = new Max().max(left, right);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenMax5To2To2Then5() {
        int left = 5;
        int right = 2;
        int top = 2;
        int expected = 5;
        int out = new Max().max(left, right, top);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenMax5To2To2To6Then6() {
        int left = 5;
        int right = 2;
        int top = 2;
        int bottom = 6;
        int expected = 6;
        int out = new Max().max(left, right, top, bottom);
        Assert.assertEquals(expected, out);
    }
}