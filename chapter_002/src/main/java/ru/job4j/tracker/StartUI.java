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
        // добавить остальные пункты меню.
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
        for (int i = 0; i < this.tracker.findAll().length; i++) {
            System.out.println(this.tracker.findAll()[i].toString());
        }
    }

    /**
     * Метод замены заявки.
     */
    private void replace() {
        System.out.println("------------ Изменение реквизитов заявки --------------");
        String name = this.input.ask("Введите имя заявки:");
        String desc = this.input.ask("Введите описание заявки:");
        Item item = new Item(name, desc);
        String id = this.input.ask("Введите ключ заявки, которую хотите изменить:");
        tracker.replace(id, item);
    }

    /**
     * Метод удаления заявки.
     */
    private void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ключ заявки:");
        tracker.delete(id);
        System.out.println("Заявка с ключем " + id + " была удалена");
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
        for (int i = 0; i < this.tracker.findByName(fName).length; i++) {
            System.out.println(this.tracker.findAll()[i].toString());
        }
    }

}
