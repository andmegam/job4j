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
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Конструктор.
     *
     * @param input ввода данных от пользователя.
     */
    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * Метод ask.
     *
     * @param question вопрос.
     * @param range    массив пунктов меню.
     * @return выбранный пункт меню.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;

            } catch (NumberFormatException nfe) {
                System.out.println("Необходимо ввести корректные данные.");
            } catch (MenuOutException moe) {
                System.out.println("Введите значение из диаппазона меню.");
            }

        } while (invalid);
        return value;
    }
}
