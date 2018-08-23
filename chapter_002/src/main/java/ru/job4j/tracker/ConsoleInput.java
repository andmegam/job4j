package ru.job4j.tracker;

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
}
