package ru.job4j.profession;

/**
 * Класс Engineer.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Engineer extends Profession {
    /**
     * Конструктор.
     *
     * @param profession наименование профессии.
     * @param surname    фамилия специалиста.
     */
    public Engineer(String profession, String surname) {
        super(profession, surname);
    }

    /**
     * Возвращает кол-во этажей построенного дома.
     *
     * @param home дом.
     * @return name кол-во этажей.
     */
    public int build(Home home) {
        return home.getCountFloors();
    }
}
