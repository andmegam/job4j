package ru.job4j.loop;

/**
 * Класс Counter.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {

    /**
     * Метод, подсчитывающий сумму четных чисел из диапазона.
     *
     * @param start начальное значение диапазона
     * @param finish конечное значение диапазона
     * @return сумма
     */
    public int add(int start, int finish) {
        int returnSum = 0;

        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                returnSum = returnSum + i;
            }

        }
        return returnSum;
    }
}
