package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    public void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when14to28then12dot04() {
        double expected = 12.04;
        Point a = new Point(1, 4);
        Point b = new Point(2, 8);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when35to68then13dot34() {
        double expected = 13.34;
        Point a = new Point(3, 5);
        Point b = new Point(6, 8);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }
}