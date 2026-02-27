package processor;

import annotations.Cache;
import java.lang.reflect.*;

/**
 * <summary>
 * Обработчик аннотации @Cache.
 * </summary>
 * <remarks>
 * Возвращает список всех кешируемых областей из аннотации @Cache.
 * Если массив пуст, возвращает пустой массив.
 * </remarks>
 * <example>
 * <code>
 * String[] caches = CacheProcessor.getCaches(CacheDemo.class);
 * for (String cache : caches) {
 *     System.out.println(cache);
 * }
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Cache"/>
 */
public class CacheProcessor {
    
    /**
     * <summary>
     * Получает список кешируемых областей из аннотации @Cache.
     * </summary>
     * <param name="clazz">Класс для обработки</param>
     * <returns>Массив имён кешируемых областей</returns>
     * <exception cref="IllegalArgumentException">Выбрасывается, если класс равен null</exception>
     */
    public static String[] getCaches(Class<?> clazz) {
        // Проверка входных данных
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не может быть null");
        }
        
        // Проверяем наличие аннотации @Cache
        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache annotation = clazz.getAnnotation(Cache.class);
            return annotation.value();
        }
        
        // Если аннотация отсутствует, возвращаем пустой массив
        return new String[0];
    }
    
    /**
     * <summary>
     * Проверяет, есть ли кешируемые области в аннотации @Cache.
     * </summary>
     * <param name="clazz">Класс для проверки</param>
     * <returns>true, если есть хотя бы одна кешируемая область; иначе false</returns>
     * <exception cref="IllegalArgumentException">Выбрасывается, если класс равен null</exception>
     */
    public static boolean hasCaches(Class<?> clazz) {
        String[] caches = getCaches(clazz);
        return caches.length > 0;
    }
}