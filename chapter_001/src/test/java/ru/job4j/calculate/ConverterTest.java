package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование корвертора валют.
 */
public class ConverterTest {
    /**
     * Тестирование перевода рублей в доллары.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int rub = 60;
        int result = converter.rubleToDollar(rub);
        int expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Тестирование перевода рублей в евро.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int rub = 70;
        int result = converter.rubleToEuro(rub);
        int expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Тестирование перевода евро в рубли.
     */
    @Test
    public void when3EuroToRoubleThen210() {
        Converter converter = new Converter();
        int euro = 3;
        int result = converter.euroToRouble(euro);
        int expected = 210;
        assertThat(result, is(expected));
    }

    /**
     * Тестирование перевода долларов в рубли.
     */
    @Test
    public void when3DollarToRoubleThen180() {
        Converter converter = new Converter();
        int dollar = 3;
        int result = converter.dollarToRouble(dollar);
        int expected = 180;
        assertThat(result, is(expected));
    }
}
