package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ArrayDuplicateTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    /**
     * В массиве есть элементы false.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] inputArray = {"Мир", "Привет", "Мир", "Привет", "Привет", "Мир", "Супер", "Мир"};
        String[] expectArray = {"Мир", "Привет", "Супер"};
        String[] resultArray = arrayDuplicate.remove(inputArray);
        assertThat(resultArray, is(expectArray));
    }
}
