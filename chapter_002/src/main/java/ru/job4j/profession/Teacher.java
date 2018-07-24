package ru.job4j.profession;

/**
 * Класс Teacher.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    /**
     * Конструктор.
     *
     * @param profession наименование профессии.
     * @param surname    фамилия специалиста.
     */
    public Teacher(String profession, String surname) {
        super(profession, surname);
    }

    /**
     * Возвращает статус сдачи экзамена (true/false).
     *
     *
     * @param student студент.
     * @return bool признак.
     */
    public boolean learn(Student student) {

        return student.isExam();
    }
}
