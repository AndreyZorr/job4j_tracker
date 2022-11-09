package ru.job4j.tracker.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {
    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl).isCloseTo(8, offset(0.1));
    }

    @Test
    public void when95and77and21Then11() {
        Point a = new Point(9, 5);
        Point b = new Point(7, 7);
        Point c = new Point(2, 1);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl).isCloseTo(11, offset(0.1));
    }
}
