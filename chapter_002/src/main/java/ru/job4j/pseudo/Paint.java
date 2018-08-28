package ru.job4j.pseudo;

/**
 * Класс Paint.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     * Метод draw. Отрисовка фигуры.
     *
     * @param shape фигура
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
