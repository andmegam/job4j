package ru.job4j.tracker;

/**
 * Класс MenuOutException.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuOutException extends RuntimeException {
    /**
     * Конструктор.
     *
     * @param msg сообщение об ошибке.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
