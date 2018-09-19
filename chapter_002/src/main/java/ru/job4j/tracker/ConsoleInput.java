package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * Класс ConsoleInput.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {

    /**
     * Сканер для ввода данных с консоли.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод ask.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Метод ask.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value: range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Введите значение из диапазона меню.");
        }
        return key;
    }

}
