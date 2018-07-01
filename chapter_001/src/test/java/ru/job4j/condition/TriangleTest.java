package ru.job4j.condition;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {

    /**
     * Тетсирование площади треугольника.
     */
    @Test
    public void manWeight() {
        Point a = new Point(0, 3);
        Point b = new Point(4, 0);
        Point c = new Point(0, 0);
        Triangle area = new Triangle(a, b, c);
        double weight = area.area();
        assertThat(weight, closeTo(6, 0.1));
    }
}
