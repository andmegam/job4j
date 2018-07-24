package ru.job4j.profession;

/**
 * Класс Home.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Home {
    /**
     * Тип строения.
     */
    private String name;
    /**
     * Количество этажей.
     */
    private int countFloors;


    /**
     * Возвращает тип строения.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает количество этажей.
     *
     * @return countFloors.
     */
    public int getCountFloors() {
        return countFloors;
    }
}
