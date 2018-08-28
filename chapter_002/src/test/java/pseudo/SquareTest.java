package pseudo;

import org.junit.Test;
import ru.job4j.pseudo.Square;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс SquareTest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {

    /**
     * Тестирование отрисовки квадрата.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(
                new StringBuilder()
                        .append("++++")
                        .append("+     +")
                        .append("+     +")
                        .append("++++")
                        .toString())
        );
    }
}
