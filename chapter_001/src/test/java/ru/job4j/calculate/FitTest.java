package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;


/**
 * Тестирование программы расчета идеального веса.
 */
public class FitTest {
    /**
     * Тетсирование метода расчета идеального веса для мужчин.
     */
    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Тетсирование метода расчета идеального веса для мужчин.
     */
    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}