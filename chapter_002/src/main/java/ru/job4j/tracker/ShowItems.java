package ru.job4j.tracker;

/**
 * Класс для отображение всех завок.
 */
public class ShowItems implements UserAction {

    /**
     * ключ операции.
     */
    private final int key;
    /**
     * Пункт меню.
     */
    private final String menuName;

    /**
     * Конструктор.
     *
     * @param key      ключ операции.
     * @param menuName пункт меню.
     */
    ShowItems(int key, String menuName) {
        this.key = key;
        this.menuName = menuName;
    }

    /**
     * @return ключ.
     */
    @Override
    public int key() {
        return key;
    }

    /**
     * Возвращает пункт меню.
     *
     * @return пункт меню.
     */
    @Override
    public String info() {
        return menuName;
    }

    /**
     * Выполнение операции.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Список всех заявок --------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
    }
}
