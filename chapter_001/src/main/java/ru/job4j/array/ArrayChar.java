package ru.job4j.array;

/**
 * Класс ArrayChar.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayChar {

    /**
     * Исходная строка преобразованная в массив элементов char[].
     */
    private final char[] data;

    /**
     * Конструктор.
     *
     * @param line строка.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинаеться с префикса.
     */
    public boolean startWith(String prefix) {
        boolean result = true;

        char[] value = prefix.toCharArray();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < value.length; j++) {
                if (data[i] != value[j] && i == j) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
