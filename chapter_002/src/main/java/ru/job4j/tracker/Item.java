package ru.job4j.tracker;

/**
 * Класс Item.
 * Описание заявки.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    /**
     * Идентификатор заявки.
     */
    private String id;

    /**
     * Наименование заявки.
     */
    private String name;
    /**
     * Описание заявки.
     */
    private String description;
    /**
     * Дата создания заявки.
     */
    private long created;

    /**
     * Конструрктор заявки.
     *
     * @param id      Идентификатор заявки.
     * @param name    Наименование заявки.
     * @param created Дата создания заявки.
     */
    public Item(String id, String name, long created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
    }

    /**
     * Устанавливает уникальный ключ заявки.
     *
     * @param id Уникальный ключ заявки.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Возвращает уникальный ключ заявки.
     *
     * @return уникальный ключ заявки.
     */
    public String getId() {
        return id;
    }

    /**
     * Возвращает наименование заявки.
     *
     * @return наименование заявки.
     */
    public String getName() {
        return name;
    }
}
