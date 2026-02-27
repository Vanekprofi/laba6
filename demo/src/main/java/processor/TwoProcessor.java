package processor;

import annotations.Two;
import java.lang.reflect.*;

/**
 * <summary>
 * Обработчик аннотации @Two.
 * </summary>
 * <remarks>
 * Считывает и выводит значения свойств <c>first</c> (String) и <c>second</c> (int) 
 * из аннотации @Two.
 * </remarks>
 * <example>
 * <code>
 * TwoProcessor.process(TwoDemo.class);
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Two"/>
 */
public class TwoProcessor {
    
    /**
     * <summary>
     * Обрабатывает класс и выводит значения свойств аннотации @Two.
     * </summary>
     * <param name="clazz">Класс для обработки</param>
     * <exception cref="IllegalArgumentException">Выбрасывается, если класс равен null</exception>
     */
    public static void process(Class<?> clazz) {
        // Проверка входных данных
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не может быть null");
        }
        
        System.out.println("  [TwoProcessor] Анализ аннотации @Two...");
        
        // Проверяем наличие аннотации @Two
        if (clazz.isAnnotationPresent(Two.class)) {
            Two annotation = clazz.getAnnotation(Two.class);
            
            String firstValue = annotation.first();
            int secondValue = annotation.second();
            
            System.out.println("  → Свойство 'first': " + firstValue);
            System.out.println("  → Свойство 'second': " + secondValue);
            System.out.println("  ✓ Данные успешно считаны");
        } else {
            System.out.println("  ⚠ Класс не имеет аннотации @Two");
        }
    }
}