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
            String enteredUser = this.input.ask(question);

            if (!checkNumber(enteredUser)) {
                throw new MenuOutException("Необходимо ввести корректные данные.");
            }

            value = Integer.valueOf(enteredUser);

            if (!checkExistsRange(value, range)) {
                throw new MenuOutException("Введите значение из диаппазона меню.");
            }

            invalid = false;
        } while (invalid);
        return value;
    }

    /**
     * Метод проверки введенных пользователем данных.
     * Проверка на число.
     *
     * @param enteredMenuItem что ввел пользователь.
     * @return флаг, является ли введенный текст числом.
     */
    private boolean checkNumber(String enteredMenuItem) {
        boolean number = true;
        if (!enteredMenuItem.matches("[-+]?\\d+")) {
            number = false;
        }
        return number;
    }

    /**
     * Метод проверки введенных пользователем данных.
     * Проверка наличия введенного пункта меню в списке меню.
     *
     * @param key   какой пункт меню ввел пользователь.
     * @param range список пунктов меню.
     * @return флаг, существует ли пункт меню в списке.
     */
    private boolean checkExistsRange(int key, List<Integer> range) {
        boolean existsRange = false;
        for (int menuItem : range) {
            if (menuItem == key) {
                existsRange = true;
                break;
            }
        }
        return existsRange;
    }
}
