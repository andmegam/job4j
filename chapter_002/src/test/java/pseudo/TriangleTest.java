package pseudo;

import org.junit.Test;
import ru.job4j.pseudo.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс TriangleTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    /**
     * Тестирование отрисовки треугольника.
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(
                new StringBuilder()
                        .append("    +    ")
                        .append("  +   +  ")
                        .append(" +     + ")
                        .append("+++++++++")
                        .toString())
        );
    }
}