package ru.job4j.tracker;

/**
 * Класс для отображение всех завок.
 */
public class ShowItems extends BaseAction {
    /**
     * Конструктор.
     *
     * @param key      ключ операции.
     * @param menuName пункт меню.
     */
    ShowItems(int key, String menuName) {
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
        System.out.println("------------ Список всех заявок --------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
    }
}
