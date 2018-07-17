package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ArrayMergeTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayMergeTest {
    /**
     * Проверка слияния массивов.
     */
    @Test
    public void checkMergeArray() {
        ArrayMerge mArray = new ArrayMerge();
        int[] a = new int[]{1, 3, 5};
        int[] b = new int[]{2, 4, 6};
        int[] result = mArray.merge(a, b);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6};
        assertThat(result, is(expect));
    }
}
