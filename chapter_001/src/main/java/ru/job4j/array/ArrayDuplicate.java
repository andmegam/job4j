package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс ArrayDuplicate.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {

    /**
     * Метод remove. Возвращает массив с уникальными значениями.
     *
     * @param array входящий массив.
     * @return массив с уникальными значениями.
     */
    public String[] remove(String[] array) {
        int currentLines = array.length;
        for (int i = 0; i < currentLines; i++) {
            for (int j = i + 1; j < currentLines; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[currentLines - j];
                    currentLines--;
                    j--;
                }
            }
        }
        int vi1 = Integer.valueOf("123");
        return Arrays.copyOf(array, currentLines);
    }
}
