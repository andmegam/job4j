package ru.job4j.loop;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Класс FactorialTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {

    /**
     * Тестирование метода подсчета факториала 5.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }

    /**
     * Тестирование метода подсчета факториала 0.
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }
}
