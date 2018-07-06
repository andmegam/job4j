package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Класс BubbleSortTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSortTest {

    /**
     * Проверка сортировки массива.
     */
    @Test
    public void testingBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[]{1, 10, 5, 8, 2, 4};
        int[] result = bubbleSort.sort(input);
        int[] expect = new int[]{1, 2, 4, 5, 8, 10};
        assertThat(result, is(expect));
    }
}
