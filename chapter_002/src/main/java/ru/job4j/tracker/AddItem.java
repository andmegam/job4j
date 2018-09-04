package ru.job4j.tracker;

/**
 * Класс для добавления заявки.
 */
public class AddItem implements UserAction {
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
    AddItem(int key, String menuName) {
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
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки:");
        String desc = input.ask("Введите описание заявки:");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
}
