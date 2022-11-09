package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    public void when11to11then0() {
        double expected = 0;
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when56to78then2dot82() {
        double expected = 2.82;
        Point a = new Point(5, 6);
        Point b = new Point(7, 8);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when59to68then1dot41() {
        double expected = 1.41;
        Point a = new Point(5, 9);
        Point b = new Point(6, 8);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when796to280then1dot41() {
        double expected = 5.09;
        Point a = new Point(7, 9, 6);
        Point b = new Point(2, 8, 0);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when993to387then1dot41() {
        double expected = 6.08;
        Point a = new Point(9, 9, 3);
        Point b = new Point(3, 8, 7);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }
}