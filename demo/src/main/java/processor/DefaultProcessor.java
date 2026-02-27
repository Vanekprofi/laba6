package processor;

import annotations.Default;
import java.lang.reflect.*;

/**
 * <summary>
 * Обработчик аннотации @Default.
 * </summary>
 * <remarks>
 * Выводит имя класса по умолчанию, указанного в аннотации @Default для класса или поля.
 * </remarks>
 * <example>
 * <code>
 * DefaultProcessor.process(DefaultDemo.class);
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Default"/>
 */
public class DefaultProcessor {
    
    /**
     * <summary>
     * Обрабатывает класс и выводит тип по умолчанию из аннотации @Default.
     * </summary>
     * <param name="clazz">Класс для обработки</param>
     * <exception cref="IllegalArgumentException">Выбрасывается, если класс равен null</exception>
     */
    public static void process(Class<?> clazz) {
        // Проверка входных данных
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не может быть null");
        }
        
        System.out.println("  [DefaultProcessor] Анализ аннотации @Default...");
        
        // Проверяем аннотацию на уровне класса
        if (clazz.isAnnotationPresent(Default.class)) {
            Default annotation = clazz.getAnnotation(Default.class);
            Class<?> defaultValue = annotation.value();
            System.out.println("  → Тип по умолчанию для класса: " + defaultValue.getName());
        } else {
            System.out.println("  ⚠ Класс не имеет аннотации @Default");
        }
        
        // Проверяем аннотации на уровне полей
        System.out.println("  [DefaultProcessor] Анализ полей с аннотацией @Default...");
        Field[] fields = clazz.getDeclaredFields();
        int fieldCount = 0;
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                Class<?> defaultValue = annotation.value();
                System.out.println("  → Поле '" + field.getName() + 
                                 "' имеет тип по умолчанию: " + defaultValue.getSimpleName());
                fieldCount++;
            }
        }
        
        if (fieldCount == 0) {
            System.out.println("  ⚠ Нет полей с аннотацией @Default");
        } else {
            System.out.println("  ✓ Найдено " + fieldCount + " поле(й) с аннотацией @Default");
        }
    }
}