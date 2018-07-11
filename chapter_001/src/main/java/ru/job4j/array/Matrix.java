package ru.job4j.array;

/**
 * Класс Matrix.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {

    /**
     * Метод создания двумерного массива.
     *
     * @param size размерность массива.
     * @return двумерный массив.
     */
    public int[][] multiple(int size) {

        int[][] table = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        return table;
    }
}
