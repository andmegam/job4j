package ru.job4j.condition;

/**
 * Класс, описываеющий точку в системе координат.
 */
public class Point {
    /**
     * Координата X.
     */
    private int x;
    /**
     * Координата Y.
     */
    private int y;

    /**
     * Конструктор.
     *
     * @param x координата X
     * @param y координата Y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расчет расстояния между точками.
     *
     * @param that экземпляр объекта Point.
     * @return расстояние между точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

}