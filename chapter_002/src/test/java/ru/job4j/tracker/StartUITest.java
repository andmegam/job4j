package ru.job4j.tracker;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс StartUITest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    /**
     * Терекер.
     */
    private Tracker tracker;
    /**
     * Объект заявки №1.
     */
    private Item item1;
    /**
     * Объект заявки №2.
     */
    private Item item2;
    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Выполняет метод, до запуска теста.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
        this.tracker = new Tracker();
        item1 = tracker.add(new Item("test name1", "desc1"));
        item2 = tracker.add(new Item("test name2", "desc2"));
    }

    /**
     * Тестирование метода добавления заявки.
     */
    @Test
    public void testCreateItem() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[2].getName(), is("test name"));
    }

    /**
     * Тестирование метода изменения заявки.
     */
    @Test
    public void testReplace() {
        Input input = new StubInput(new String[]{"2", "test replace", "заменили заявку", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item1.getId()).getName(), is("test replace"));
    }

    /**
     * Тестирование метода удаления заявки.
     */
    @Test
    public void testDelete() {
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
    }

    /**
     * Тестирование метода поиска заявки.
     */
    @Test
    public void testFindById() {
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item2.getId()).getName(), is("test name2"));
    }

    /**
     * Тестирование метода вывода всех заявок.
     */
    @Test
    public void testShowAll() {
        Input input = new StubInput(new String[]{"1", "6"});
        String resultString = new StringJoiner(
                System.lineSeparator(), "",
                System.lineSeparator())
                .add("Меню.")
                .add("0. Add new Item")
                .add("1. Show all items")
                .add("2. Edit item")
                .add("3. Delete item")
                .add("4. Find item by Id")
                .add("5. Find items by name")
                .add("6. Exit Program")
                .add("------------ Список всех заявок --------------")
                .add(item1.toString())
                .add(item2.toString())
                .add("Меню.")
                .add("0. Add new Item")
                .add("1. Show all items")
                .add("2. Edit item")
                .add("3. Delete item")
                .add("4. Find item by Id")
                .add("5. Find items by name")
                .add("6. Exit Program")
                .add("Завершение работы программы.")
                .toString();
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(resultString));
    }

    /**
     * Тестирование метода поиска заявки по наименованию.
     */
    @Test
    public void testFindByName() {
        Input input = new StubInput(new String[]{"5", "name1", "6"});
        String resultString = new StringJoiner(
                System.lineSeparator(), "",
                System.lineSeparator())
                .add("Меню.")
                .add("0. Add new Item")
                .add("1. Show all items")
                .add("2. Edit item")
                .add("3. Delete item")
                .add("4. Find item by Id")
                .add("5. Find items by name")
                .add("6. Exit Program")
                .add("------------ Поиск заявок по наименованию --------------")
                .add("Список всех найденных заявок:")
                .add(item1.toString())
                .add("Меню.")
                .add("0. Add new Item")
                .add("1. Show all items")
                .add("2. Edit item")
                .add("3. Delete item")
                .add("4. Find item by Id")
                .add("5. Find items by name")
                .add("6. Exit Program")
                .add("Завершение работы программы.")
                .toString();
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(resultString));
    }
}
