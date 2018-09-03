package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс MenuTracker.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();
    /**
     * Флаг для выхода из программы.
     */
    private boolean exit;

    /**
     * Конструктор.
     *
     * @param input   ввод данных.
     * @param tracker трекер.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.exit = false;
    }

    /**
     *
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "0. Add new Item"));
        this.actions.add(new ShowItems(1, "1. Show all items"));
        this.actions.add(new EditItem(2, "2. Edit item"));
        this.actions.add(new DeleteItem(3, "3. Delete item"));
        this.actions.add(new FindItemById(4, "4. Find item by Id"));
        this.actions.add(new FindItemsByName(5, "5. Find items by name"));
        this.actions.add(new ExitProgram(6, "6. Exit Program"));
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод в зависимости от указанного ключа,
     * выполняет соотвествующие действие.
     *
     * @param key ключ операции.
     */
    public void select(int key) {
        if (key >= 0 && key < this.getActionsLength()) {
            actions.get(key).execute(this.input, this.tracker);
        } else {
            System.out.println("Пункта меню: " + String.valueOf(key) + " не существует.");
        }
    }

    /**
     * Класс для добавления заявки.
     */
    private class AddItem implements UserAction {
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

    /**
     * Класс для отображение всех завок.
     */
    private class ShowItems implements UserAction {

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
            Item[] allItems = tracker.findAll();
            for (int i = 0; i < allItems.length; i++) {
                System.out.println(tracker.findAll()[i].toString());
            }
        }
    }

    /**
     * Класс для изменения заявки.
     */
    private class EditItem implements UserAction {
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
        EditItem(int key, String menuName) {
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
            System.out.println("------------ Изменение реквизитов заявки --------------");
            String name = input.ask("Введите имя новой заявки:");
            String desc = input.ask("Введите описание новой заявки:");
            Item item = new Item(name, desc);
            String id = input.ask("Введите ключ заявки, которую хотите изменить:");
            if (tracker.replace(id, item)) {
                System.out.println("Реквизиты заявки изменены.");
            } else {
                System.out.println("Заявка с id = " + id + " не найдена.");
            }
        }
    }

    /**
     * Класс для удаления заявки.
     */
    private class DeleteItem implements UserAction {
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
        DeleteItem(int key, String menuName) {
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
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ключ заявки:");
            if (tracker.delete(id)) {
                System.out.println("Заявка с id = " + id + " удалена.");
            } else {
                System.out.println("Заявка с id = " + id + " не найдена.");
            }
        }
    }

    /**
     * Класс для поиска заявки по id.
     */
    private class FindItemById implements UserAction {
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
        FindItemById(int key, String menuName) {
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
            System.out.println("------------ Поиск заявки по ключу --------------");
            String id = input.ask("Введите ключ заявки:");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("По ключу " + id + " была найдена заявка:");
                System.out.println(item.toString());
            } else {
                System.out.println("По ключу " + id + " заявки не найдено.");
            }
        }


    }

    /**
     * Класс для отображения массива заявок, наименование которых содержит определенный фрагмент текста.
     */
    private class FindItemsByName implements UserAction {
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
        FindItemsByName(int key, String menuName) {
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
            System.out.println("------------ Поиск заявок по наименованию --------------");
            String fName = input.ask("Введите фрагмент поиска (по наименованию):");
            Item[] allItems = tracker.findByName(fName);
            if (allItems.length > 0) {
                System.out.println("Список всех найденных заявок:");
                for (int i = 0; i < allItems.length; i++) {
                    System.out.println(allItems[i].toString());
                }
            } else {
                System.out.println("Заявок, в наименовании которых  содержится \"" + fName + "\" не найдено.");
            }
        }
    }

    /**
     * Класс для выхода из программы.
     */
    private class ExitProgram implements UserAction {

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
        ExitProgram(int key, String menuName) {
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
            System.out.println("Завершение работы программы.");
            exit = true;
        }
    }

    /**
     * @return флаг завершения работы программы.
     */
    public boolean isExit() {
        return exit;
    }
}
