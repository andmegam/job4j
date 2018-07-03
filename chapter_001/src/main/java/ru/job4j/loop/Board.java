package ru.job4j.loop;

/**
 * Класс Board.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {

    /**
     * Метод построения шахматной доски в псевдографике.
     *
     * @param width ширина доски.
     * @param height высота доски.
     * @return шахматная доска в псевдографике.
     */
    public static String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        for (int h = 1; h <= height; h++) {
            for (int w = 1; w <= width; w++) {
                if ((h + w) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }

        return screen.toString();
    }

    /**
     * тест sdf.
     *
     * @param args sdfsdfsd.
     */
    public static void main(String[] args) {
        String sd = paint(5, 4);
        System.out.println(sd);
    }
}
