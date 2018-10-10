package ru.job4j.tracker;

import java.util.List;

/**
 * Класс Input.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    /**
     * Метод ask.
     *
     * @param question - вопрос для пользователя.
     * @return то, что пользователь ввел с консоли.
     */
    String ask(String question);

    /**
     * Метод ask.
     *
     * @param question - вопрос для пользователя.
     * @param range    - массив из меню.
     * @return то, что пользователь ввел с консоли.
     */
    int ask(String question, List<Integer> range);

}
