package ru.job4j.profession;

/**
 * Класс Student.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Student {
    /**
     * Фамилия студента.
     */
    private String surname;
    /**
     * Наименование экзамена.
     */
    private String nameExam;
    /**
     * Признак того, что экзамен сдан.
     */
    private boolean exam;

    /**
     * Конструктор.
     *
     * @param surname  фамилия специалиста.
     * @param nameExam наименование экзамена.
     */
    public Student(String surname, String nameExam) {
        this.surname = surname;
        this.nameExam = nameExam;
        this.exam = false;
    }

    /**
     * Возвращает фамилию студента.
     *
     * @return surname фамилия студента.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Возвращает наименование экзамена.
     *
     * @return nameExam наименование экзамена.
     */
    public String getNameExam() {
        return nameExam;
    }

    /**
     * Возвращает признак сдачи экзамена.
     *
     * @return exam признак сдачи экзамена.
     */
    public boolean isExam() {
        return exam;
    }
}
