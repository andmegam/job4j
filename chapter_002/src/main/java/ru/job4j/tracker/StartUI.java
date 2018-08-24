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
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отображения списка всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для замены заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DEL = "3";
    /**
     * Константа меню поиска заявки по id.
     */
    private static final String FBI = "4";
    /**
     * Константа меню поиска заявки по id.
     */
    private static final String FBN = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

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
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.replace();
            } else if (DEL.equals(answer)) {
                this.delete();
            } else if (FBI.equals(answer)) {
                this.findById();
            } else if (FBN.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                System.out.println("Завершение работы программы.");
                exit = true;
            }
        }
    }

    /**
     * Метод для отображения меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод для отображения всех заявок из трекера.
     */
    private void showAll() {
        System.out.println("------------ Список всех заявок --------------");
        Item[] allItems = this.tracker.findAll();
        for (int i = 0; i < allItems.length; i++) {
            System.out.println(this.tracker.findAll()[i].toString());
        }
    }

    /**
     * Метод замены заявки.
     */
    private void replace() {
        System.out.println("------------ Изменение реквизитов заявки --------------");
        String name = this.input.ask("Введите имя новой заявки:");
        String desc = this.input.ask("Введите описание новой заявки:");
        Item item = new Item(name, desc);
        String id = this.input.ask("Введите ключ заявки, которую хотите изменить:");
        if (tracker.replace(id, item)) {
            System.out.println("Реквизиты заявки изменены.");
        } else {
            System.out.println("Заявка с id = " + id + " не найдена.");
        }
    }

    /**
     * Метод удаления заявки.
     */
    private void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ключ заявки:");
        if (tracker.delete(id)) {
            System.out.println("Заявка с id = " + id + " удалена.");
        } else {
            System.out.println("Заявка с id = " + id + " не найдена.");
        }

    }

    /**
     * Метод поиска заявки по ключу.
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по ключу --------------");
        String id = this.input.ask("Введите ключ заявки:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("По ключу " + id + " была найдена заявка:");
            System.out.println(item.toString());
        } else {
            System.out.println("По ключу " + id + " заявки не найдено.");
        }
    }

    /**
     * Возвращает массив заявок, наименование которых содержит определенный фрагмент текста.
     */
    private void findByName() {
        System.out.println("------------ Поиск заявок по наименованию --------------");
        String fName = this.input.ask("Введите фрагмент поиска (по наименованию):");
        Item[] allItems = this.tracker.findByName(fName);
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
