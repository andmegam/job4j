package ru.job4j.profession;

/**
 * Класс Profession.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Profession {
    /**
     * Наименование профессии.
     */
    private String profession;
    /**
     * Фамилия специалиста.
     */
    private String surname;

    /**
     * Конструктор.
     *
     * @param profession наименование профессии.
     * @param surname    фамилия специалиста.
     */
    public Profession(String profession, String surname) {
        this.profession = profession;
        this.surname = surname;
    }

    /**
     * Возвращает наименование профессии.
     *
     * @return profession.
     */
    public String getProfession() {
        return profession;
    }

    /**
     * Возвращает фамилию специалиста.
     *
     * @return surname.
     */
    public String getSurname() {
        return surname;
    }
}