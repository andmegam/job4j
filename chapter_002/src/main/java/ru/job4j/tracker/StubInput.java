package ru.job4j.tracker;

/**
 * Класс StartUITest.
 *
 * @author Mashkov Andrey (mailto:andmmm@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {
    /**
     * Последовательность ответов пользователя.
     */
    private final String[] answers;
    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    /**
     * Конструктор.
     *
     * @param answers список команд для трекера.
     */
    public StubInput(final String[] answers) {
        this.answers = answers;
    }

    /**
     * Метод ask.
     *
     * @param question - вопрос для пользователя.
     * @return то, что пользователь ввел с консоли.
     */
    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }
}
