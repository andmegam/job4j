package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс MatrixCheckTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheckTest {
    /**
     * Test mono. Диагонали равны.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test mono. Диагонали не равны.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test mono. Нет общих элементов на диагоналях.
     */
    @Test
    public void whenNoCommonElements() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {false, true},
                {true, false}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
