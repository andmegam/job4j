package ru.job4j.tracker;

/**
 * Класс StartUI.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Меню трекера.
     */
    private final MenuTracker menu;

    /**
     * Запускт программы.
     *
     * @param args входящие параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.menu = new MenuTracker(input, tracker);
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        menu.fillActions();
        menu.fillMenuRange();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Выберите пункт меню:", menu.getMenuRange())));
        } while (!menu.isExit());
    }
}