package demo;

import annotations.Two;

/**
 * <summary>
 * Демонстрационный класс для аннотации @Two.
 * </summary>
 * <remarks>
 * Класс помечен аннотацией @Two с двумя свойствами: строкой и целым числом.
 * Обработчик считывает и выводит эти значения.
 * </remarks>
 * <example>
 * <code>
 * TwoProcessor.process(TwoDemo.class);
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Two"/>
 * <see cref="processor.TwoProcessor"/>
 */
@Two(first = "Шулепов Иван Ит-2", second = 2026)
public class TwoDemo {
    
    /**
     * <summary>
     * Пример данных класса.
     * </summary>
     */
    private String data = "Лабораторная работа №6";
    
    /**
     * <summary>
     * Получает данные.
     * </summary>
     * <returns>Данные класса</returns>
     */
    public String getData() {
        return data;
    }
}