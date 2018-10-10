package ru.job4j.tracker;

/**
 * Класс для добавления заявки.
 */
public class AddItem extends BaseAction {

    /**
     * Конструктор.
     *
     * @param key      ключ операции.
     * @param menuName пункт меню.
     */
    AddItem(int key, String menuName) {
        super(key, menuName);
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
