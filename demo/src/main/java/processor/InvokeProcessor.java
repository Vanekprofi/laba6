package processor;

import annotations.Invoke;
import java.lang.reflect.*;

/**
 * <summary>
 * Обработчик аннотации @Invoke.
 * </summary>
 * <remarks>
 * Находит все методы объекта, помеченные аннотацией @Invoke, и вызывает их автоматически.
 * </remarks>
 * <example>
 * <code>
 * InvokeDemo demo = new InvokeDemo();
 * InvokeProcessor.process(demo);
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Invoke"/>
 */
public class InvokeProcessor {
    
    /**
     * <summary>
     * Обрабатывает объект и вызывает все методы с аннотацией @Invoke.
     * </summary>
     * <param name="obj">Объект для обработки</param>
     * <exception cref="IllegalArgumentException">Выбрасывается, если объект равен null</exception>
     * <exception cref="IllegalAccessException">Выбрасывается при недоступности метода</exception>
     * <exception cref="InvocationTargetException">Выбрасывается при ошибке вызова метода</exception>
     */
    public static void process(Object obj) throws IllegalAccessException, InvocationTargetException {
        // Проверка входных данных
        if (obj == null) {
            throw new IllegalArgumentException("Объект не может быть null");
        }
        
        System.out.println("  [InvokeProcessor] Поиск методов с аннотацией @Invoke...");
        
        // Получаем все методы класса
        Method[] methods = obj.getClass().getDeclaredMethods();
        
        int invokedCount = 0;
        
        // Проходим по всем методам
        for (Method method : methods) {
            // Проверяем наличие аннотации @Invoke
            if (method.isAnnotationPresent(Invoke.class)) {
                System.out.println("  → Вызов метода: " + method.getName() + "()");
                
                // Делаем метод доступным (даже если он приватный)
                method.setAccessible(true);
                
                // Вызываем метод
                method.invoke(obj);
                invokedCount++;
            }
        }
        
        if (invokedCount == 0) {
            System.out.println("  ⚠ Нет методов с аннотацией @Invoke");
        } else {
            System.out.println("  ✓ Найдено и вызвано " + invokedCount + " метод(ов)");
        }
    }
}