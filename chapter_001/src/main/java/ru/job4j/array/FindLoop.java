package ru.job4j.array;

/**
 * Класс FindLoop.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {

    /**
     * Метод поиска индекса элемента массива.
     *
     * @param data массив данных.
     * @param el искомый элемент массива.
     * @return индекс искомого элемента массива.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.

        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
