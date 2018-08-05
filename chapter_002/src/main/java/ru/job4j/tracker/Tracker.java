package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс Tracker.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Random число для создания Id.
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     *
     * @param item новая заявка.
     * @return заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание.
     * Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextLong());
    }


    /**
     * Посик заявки по уникальному ключу.
     *
     * @param id уникальный ключ заявки.
     * @return завка.
     */
    public Item findById(String id) {
        Item returnItem = null;
        for (Item currItem : this.items) {
            if (currItem != null && currItem.getId().equals(id)) {
                returnItem = currItem;
                break;
            }
        }
        return returnItem;
    }

    /**
     * Замена ячейки в массиве.
     *
     * @param id   уникальный ключ заявки.
     * @param item заявка.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Удаление заявки из массива.
     *
     * @param id ключ заявки.
     */
    public void delete(String id) {
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                position--;
                break;
            }
        }
    }

    /**
     * Возвращает копию массива this.items без null элементов.
     *
     * @return массив заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Возвращает массив заявок, наименование которых содержит определенный фрагмент текста.
     *
     * @param key фрагмент поиска.
     * @return массив заявок.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int resultPos = 0;
        for (int i = 0; i < items.length; i++) {
            Item currItem = items[i];
            if (currItem != null && currItem.getName().toLowerCase().contains(key.toLowerCase())) {
                result[resultPos] = currItem;
                resultPos++;
            }
        }
        return Arrays.copyOf(result, resultPos);
    }
}
