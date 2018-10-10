package ru.job4j.tracker;

/**
 * Класс BaseAction.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public abstract class BaseAction implements UserAction {
    /**
     * Ключ операции.
     */
    private final int key;
    /**
     * Пункт меню.
     */
    private final String menuName;

    /**
     * Конструктор.
     *
     * @param key  - Ключ операции.
     * @param menuName - Наименование операции.
     */
    protected BaseAction(final int key, final String menuName) {
        this.key = key;
        this.menuName = menuName;
    }

    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.menuName);
    }
}
