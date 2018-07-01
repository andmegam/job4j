package ru.job4j.condition;

/**
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {

    /**
     * Точка а.
     */
    private final Point a;
    /**
     * Точка b.
     */
    private final Point b;
    /**
     * Точка c.
     */
    private final Point c;

    /**
     * Конструктор, принимающий три точки треугольника.
     *
     * @param a Точка а.
     * @param b Точка b.
     * @param c Точка c.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если
     * треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return полупериметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) * 0.5;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return признак существования треугольника.
     */
    private boolean exist(double ab, double ac, double bc) {
        boolean existTriangle = false;
        if (ab > 0 && ac > 0 && bc > 0) {
            existTriangle = true;
        }
        return existTriangle;
    }

}
