package ru.job4j.loop;

/**
 * Класс Factorial.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {

    /**
     * Метод, подсчитывающий факториал числа.
     *
     * @param n "эн факториал"
     * @return факториал числа.
     */
    public int calc(int n) {
        int factorial = 1;

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                factorial = factorial * i;
            }
        }
        return factorial;
    }
}
