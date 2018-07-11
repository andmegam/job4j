package ru.job4j.array;

/**
 * Класс MatrixCheck.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {

    /**
     * Метод создания двумерного массива.
     *
     * @param data двумерный массив.
     * @return все элементы по диагоналям равны true или false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
            }
            if (data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                result = false;
            }
        }

        return result;
    }

}
