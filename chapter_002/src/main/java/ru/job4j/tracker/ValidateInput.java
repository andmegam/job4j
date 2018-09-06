package ru.job4j.tracker;

import java.util.List;

/**
 * Класс ValidateInput.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Метод ask.
     *
     * @param question вопрос.
     * @param range    массив пунктов меню.
     * @return выбранный пункт меню.
     */
    public int ask(String question, List<Integer> range) {
        int value = -1;
        boolean invalid = false;
        do {
            try {
                value = super.ask(question, range);
                invalid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Необходимо ввести корректные данные.");
            } catch (MenuOutException ex) {
                System.out.println("Необходимо ввести пункт меню с 0 до " + String.valueOf(range.size() - 2));
            }
        } while (!invalid);
        return value;
    }
}
