package ru.job4j.pseudo;

/**
 * Класс Triangle.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    /**
     * Метод draw. Отрисовка треугольника.
     *
     * @return фигура.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("    +    ");
        pic.append("  +   +  ");
        pic.append(" +     + ");
        pic.append("+++++++++");
        return pic.toString();
    }
}
