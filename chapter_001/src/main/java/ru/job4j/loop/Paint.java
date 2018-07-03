package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Класс Paint.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     * Метод построения левосторонней пирамиды в псевдографике.
     *
     * @param height высота пирамиды.
     * @return пирамида в псевдографике.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );

    }

    /**
     * Метод построения правосторонней пирамиды в псевдографике.
     *
     * @param height высота пирамиды.
     * @return пирамида в псевдографике.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Метод построения двусторонней пирамиды в псевдографике.
     *
     * @param height высота пирамиды.
     * @return пирамида в псевдографике.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Метод построения пирамиды в псевдографике.
     *
     * @param height высота пирамиды.
     * @param weight ширина пирамиды.
     * @param predict predict.
     * @return пирамида в псевдографике.
     */
    public String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
