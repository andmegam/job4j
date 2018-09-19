package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Класс ValidateInputTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    /**
     *
     */
    private final PrintStream out = System.out;

    /**
     * Выполняет метод, до запуска теста.
     */
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Выполняет метод, после запуска теста.
     */
    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Метод тестирования валидатора.
     * Проверка ввода числовых значений.
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "1"}));
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Enter", range);
        assertThat(this.mem.toString(), is(String.format("Введите корректные данные.\r\n")));
    }

    /**
     * Метод тестирования валидатора.
     * Провекра пункта меню.
     */
    @Test
    public void whenNoFromMenuRangeInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"12", "1"}));
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Enter", range);
        assertThat(this.mem.toString(), is(String.format("Введите значение из диапазона меню.\r\n")));
    }
}
