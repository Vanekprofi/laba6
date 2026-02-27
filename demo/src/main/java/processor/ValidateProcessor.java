package processor;

import annotations.Validate;
import java.lang.reflect.*;

/**
 * <summary>
 * Обработчик аннотации @Validate.
 * </summary>
 * <remarks>
 * Выводит список всех типов классов, указанных в аннотации @Validate.
 * </remarks>
 * <example>
 * <code>
 * ValidateProcessor.process(ValidateDemo.class);
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Validate"/>
 */
public class ValidateProcessor {
    
    /**
     * <summary>
     * Обрабатывает класс и выводит список типов для валидации из аннотации @Validate.
     * </summary>
     * <param name="clazz">Класс для обработки</param>
     * <exception cref="IllegalArgumentException">Выбрасывается, если класс равен null</exception>
     */
    public static void process(Class<?> clazz) {
        // Проверка входных данных
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не может быть null");
        }
        
        System.out.println("  [ValidateProcessor] Анализ аннотации @Validate...");
        
        // Проверяем наличие аннотации @Validate
        if (clazz.isAnnotationPresent(Validate.class)) {
            Validate annotation = clazz.getAnnotation(Validate.class);
            Class<?>[] classes = annotation.value();
            
            if (classes.length == 0) {
                System.out.println("  ⚠ Список типов для валидации пуст");
            } else {
                System.out.println("  → Найдено " + classes.length + " тип(ов) для валидации:");
                for (int i = 0; i < classes.length; i++) {
                    System.out.println("    " + (i + 1) + ". " + classes[i].getName());
                }
            }
        } else {
            System.out.println("  ⚠ Класс не имеет аннотации @Validate");
        }
    }
}