package ru.job4j.profession;

/**
 * Класс Doctor.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {
    /**
     * Конструктор.
     *
     * @param profession наименование профессии.
     * @param surname    фамилия специалиста.
     */
    public Doctor(String profession, String surname) {
        super(profession, surname);
    }

    /**
     * Возвращает диагноз пациента.
     *
     * @param patient пациент.
     * @return name диагноз.
     */
    public Diagnose heal(Patient patient) {

        return null;
    }
}
