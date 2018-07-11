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
        int counDuplicate = 0;
        int currentLines = array.length;
        for (int n = 0; n < currentLines; n++) {
            for (int i = n + 1; i < currentLines; i++) {
                if (array[n].equals(array[i])) {
                    counDuplicate++;
                    currentLines--;
                    String tmp = array[i];
                    for (int j = i; j < (array.length - 1); j++) {
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                    }
                    i--;
                }
            }
        }
        return Arrays.copyOf(array, array.length - counDuplicate);
    }
}
