package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

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
     * Хранилище заявок.
     */
    private final Tracker tracker;
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.menu = new MenuTracker(input, tracker);
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Выберите пункт меню:")));
        } while (!menu.isExit());
    }
}