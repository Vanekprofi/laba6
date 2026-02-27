package demo;

import annotations.Invoke;

/**
 * <summary>
 * Демонстрационный класс для аннотации @Invoke.
 * </summary>
 * <remarks>
 * Содержит несколько методов, из которых только один помечен аннотацией @Invoke.
 * Обработчик автоматически найдёт и вызовет этот метод.
 * </remarks>
 * <example>
 * <code>
 * InvokeDemo demo = new InvokeDemo();
 * InvokeProcessor.process(demo); // Вызовет только метод с @Invoke
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Invoke"/>
 * <see cref="processor.InvokeProcessor"/>
 */
public class InvokeDemo {
    
    /**
     * <summary>
     * Метод, который будет автоматически вызван обработчиком аннотации.
     * </summary>
     * <remarks>
     * Помечен аннотацией @Invoke, поэтому будет найден и выполнен.
     * </remarks>
     */
    @Invoke
    public void greetStudent() {
        System.out.println("Привет! Меня зовут Иван Шулепов, группа Ит-2.");
    }
    
    /**
     * <summary>
     * Обычный метод без аннотации, не будет вызван автоматически.
     * </summary>
     * <remarks>
     * Этот метод не помечен @Invoke, поэтому обработчик его проигнорирует.
     * </remarks>
     */
    public void privateMethod() {
        System.out.println("Этот метод не аннотирован и не будет вызван");
    }
    
    /**
     * <summary>
     * Ещё один метод с аннотацией @Invoke для демонстрации множественных вызовов.
     * </summary>
     * <remarks>
     * Обработчик вызовет все методы, помеченные @Invoke.
     * </remarks>
     */
    @Invoke
    public void showLabInfo() {
        System.out.println("Лабораторная работа №6 по программированию на Java");
    }
}