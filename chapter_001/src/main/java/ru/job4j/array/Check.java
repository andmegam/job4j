package ru.job4j.array;

/**
 * Класс Check.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Check {

    /**
     * Метод mono.
     *
     * @param data входной массив.
     * @return возвращает true если все элементы массива = true или false
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {

            if (!data[i]) {
                result = false;
                break;
            }

        }
        return result;
    }
}
