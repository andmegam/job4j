package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Тестирование расстояния между точками.
 */
public class PointTest {

    /**
     * Тестирование расстояния между точками. Разные точки
     */
    @Test
    public void whenX0Y5distanceToX5Y5Then5() {
        Point a = new Point(0, 5);
        Point b = new Point(5, 5);

        double distance = a.distanceTo(b);
        assertThat(distance, closeTo(5.0, 0.1));
    }

    /**
     * Тестирование расстояния между точками. Расстоянием "между собой"
     */
    @Test
    public void whenX0Y5distanceToX0Y0Then0() {
        Point a = new Point(0, 5);
        double distance = a.distanceTo(a);
        assertThat(distance, closeTo(0.0, 0.1));
    }

}