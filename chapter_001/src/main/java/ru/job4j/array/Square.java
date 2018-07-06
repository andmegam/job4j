package ru.job4j.array;

/**
 * Класс Square.
 *
 * @author Andrey
 */
public class Square {

    /**
     * Method calculate.
     *
     * @param bound размерность массива
     * @return массив с числами возведенными в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}
