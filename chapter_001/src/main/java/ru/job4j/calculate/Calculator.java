package ru.job4j.calculate;

/**
 * Class Calculator.
 *
 * @author Mashkov Andrey
 * @version 1.0
 * @since 27.06.2018
 */
public class Calculator {
    /**
     * Переменная, содержащая резкльтат вычисления.
     *
     */
    private double result;

    /**
     * Метод сложения двух чисел.
     *
     * @param first  первое значение.
     * @param second первое значение.
     *
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод вычитания одного числа из другого.
     *
     * @param first  первое значение.
     * @param second первое значение.
     *
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    /**
     * Метод вычитания одного числа из другого.
     *
     * @param first  первое значение.
     * @param second первое значение.
     *
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Метод перемножения чисел.
     *
     * @param first  первое значение.
     * @param second первое значение.
     *
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Возвращает результат.
     *
     * @return result.
     *
     */
    public double getResult() {
        return this.result;
    }
}