package ru.job4j.max;

/**
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /**
     * Возвращает максимальное число.
     *
     * @param first первое сичло.
     * @param second второе число.
     * @return максимальное число
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
