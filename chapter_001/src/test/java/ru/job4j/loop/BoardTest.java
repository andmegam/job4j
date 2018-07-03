package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс BoardTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BoardTest {

    /**
     * Символ пробела в текущей ОС.
     */
    private final String line = System.getProperty("line.separator");

    /**
     * Тестирование построения шахматной доски в псевдографике 3x3.
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String expected = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(result, is(expected));
    }

    /**
     * Тестирование построения шахматной доски в псевдографике 5x4.
     */
    @Test
    public void whenPaintBoard5x4() {
        Board board = new Board();
        String result = board.paint(5, 4);
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(result, is(expected));
    }
}
