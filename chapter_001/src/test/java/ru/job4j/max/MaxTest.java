package ru.job4j.max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {

    /**
     * Тестирование метода сравнения двух чисел.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тестирование метода сравнения трех чисел.
     */
    @Test
    public void comapreFirstSecondThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 6);
        assertThat(result, is(6));
    }
}
