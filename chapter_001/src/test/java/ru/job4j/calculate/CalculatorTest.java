package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса Calculator.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru.ru)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * Тестирование метода сложения.
     */
    @Test
    public void whenAdd1On1Then2() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }


    /**
     * Тестирование метода вычетания.
     */
    @Test
    public void whenSubtract9On3Then6() {
        Calculator calc = new Calculator();
        calc.subtract(9D, 3D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }

    /**
     * Тестирование метода деления.
     */
    @Test
    public void whenDiv9On3Then3() {
        Calculator calc = new Calculator();
        calc.div(9D, 3D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }


    /**
     * Тестирование метода умножения.
     */
    @Test
    public void whenMultiple4On2Then8() {
        Calculator calc = new Calculator();
        calc.multiple(4D, 2D);
        double result = calc.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }
}