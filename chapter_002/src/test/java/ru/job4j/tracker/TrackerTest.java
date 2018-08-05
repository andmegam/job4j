package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Класс TrackerTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {


    /**
     * Тестирование метода добавления заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testName", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Тестирование метода поиска заявки по уникальному ключу.
     */
    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testName", 123L);
        Item item2 = new Item("test2", "testName2", 1234L);
        Item item3 = new Item("test3", "testName3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item3.getId()), is(item3));
    }

    /**
     * Тестирование метода замены заявки.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testName1", 123L);
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testName2", 1234L);
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(next.getId()).getName(), is("testName2"));
    }

    /**
     * Тестирование метода удаления заявки.
     */
    @Test
    public void testingDelete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testName1", 123L);
        Item item2 = new Item("test2", "testName2", 1234L);
        Item item3 = new Item("test3", "testName3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        assertThat(tracker.findAll()[1], is(item3));
    }

    /**
     * Тестирование метода, который возвращает все ненулевые элементы массива заявок.
     */
    @Test
    public void testingFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testName1", 123L);
        Item item2 = new Item("test2", "testName2", 1234L);
        Item item3 = new Item("test3", "testName3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findAll().length, is(3));
    }

    /**
     * Тестирование метода, который возвращает массив заявок, содержащих определенный фрагмент текста.
     */
    @Test
    public void testingFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testName1 - Саратов", 123L);
        Item item2 = new Item("test2", "testName2 - Москва", 1234L);
        Item item3 = new Item("test3", "testName3 - Саратов", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("Саратов").length, is(2));
        assertThat(tracker.findByName("Краснодар").length, is(0));
    }
}