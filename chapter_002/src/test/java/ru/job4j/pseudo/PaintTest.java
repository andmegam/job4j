package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс PaintTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {

    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Выполняет метод, до запуска теста.
     */
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Выполняет метод, до после теста.
     */
    @After
    public void backOutput() {
        //System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Тестирование отрисовки квадрата.
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append("++++")
                        .append("+     +")
                        .append("+     +")
                        .append("++++")
                        .append(System.lineSeparator())
                        .toString())
        );
    }

    /**
     * Тестирование отрисовки треугольника.
     */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append("    +    ")
                        .append("  +   +  ")
                        .append(" +     + ")
                        .append("+++++++++")
                        .append(System.lineSeparator())
                        .toString())
        );
    }
}
