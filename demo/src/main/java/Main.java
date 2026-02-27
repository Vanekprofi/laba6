import demo.*;
import processor.*;
import annotations.*;

/**
 * <summary>
 * Главный класс лабораторной работы №6.
 * </summary>
 * <remarks>
 * Демонстрирует работу всех аннотаций и их обработчиков.
 * Содержит дружелюбный интерфейс для демонстрации функциональности.
 * </remarks>
 * <example>
 * <code>
 * java Main
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Invoke"/>
 * <see cref="annotations.Default"/>
 * <see cref="annotations.ToString"/>
 * <see cref="annotations.Validate"/>
 * <see cref="annotations.Two"/>
 * <see cref="annotations.Cache"/>
 */
public class Main {
    
    /**
     * <summary>
     * Главный метод программы.
     * </summary>
     * <param name="args">Аргументы командной строки (не используются)</param>
     */
    public static void main(String[] args) {
        // Выводим заголовок
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║         ЛАБОРАТОРНАЯ РАБОТА №6 - АННОТАЦИИ В JAVA           ║");
        System.out.println("║              Студент: Шулепов Иван, группа Ит-2              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        // Задание 1.1 - @Invoke
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│ ЗАДАНИЕ 1.1: Аннотация @Invoke                               │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        try {
            InvokeDemo invokeDemo = new InvokeDemo();
            InvokeProcessor.process(invokeDemo);
        } catch (Exception e) {
            System.out.println("  ✗ Ошибка: " + e.getMessage());
        }
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        // Задание 1.2 - @Default
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│ ЗАДАНИЕ 1.2: Аннотация @Default                              │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        try {
            DefaultProcessor.process(DefaultDemo.class);
        } catch (Exception e) {
            System.out.println("  ✗ Ошибка: " + e.getMessage());
        }
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        // Задание 1.3 - @ToString
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│ ЗАДАНИЕ 1.3: Аннотация @ToString                             │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        try {
            ToStringDemo ts = new ToStringDemo();
            String result = ToStringProcessor.build(ts);
            System.out.println("  Результат:\n" + result);
        } catch (Exception e) {
            System.out.println("  ✗ Ошибка: " + e.getMessage());
        }
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        // Задание 1.4 - @Validate
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│ ЗАДАНИЕ 1.4: Аннотация @Validate                             │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        try {
            ValidateProcessor.process(ValidateDemo.class);
        } catch (Exception e) {
            System.out.println("  ✗ Ошибка: " + e.getMessage());
        }
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        // Задание 1.5 - @Two
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│ ЗАДАНИЕ 1.5: Аннотация @Two                                  │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        try {
            TwoProcessor.process(TwoDemo.class);
        } catch (Exception e) {
            System.out.println("  ✗ Ошибка: " + e.getMessage());
        }
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        // Задание 1.6 - @Cache
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│ ЗАДАНИЕ 1.6: Аннотация @Cache                                │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        try {
            String[] caches = CacheProcessor.getCaches(CacheDemo.class);
            
            if (caches.length == 0) {
                System.out.println("  ⚠ Кешируемые области отсутствуют");
            } else {
                System.out.println("  → Найдено " + caches.length + " кешируемая(их) область(и):");
                for (int i = 0; i < caches.length; i++) {
                    System.out.println("    " + (i + 1) + ". " + caches[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("  ✗ Ошибка: " + e.getMessage());
        }
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        // Итоги
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}