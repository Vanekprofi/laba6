package demo;

import annotations.Cache;

/**
 * <summary>
 * Демонстрационный класс для аннотации @Cache.
 * </summary>
 * <remarks>
 * Класс помечен аннотацией @Cache с указанием нескольких кешируемых областей.
 * Обработчик выведет список всех указанных областей.
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
 * <see cref="processor.CacheProcessor"/>
 */
@Cache({"students", "groups", "schedule", "teachers"})
public class CacheDemo {
    
    /**
     * <summary>
     * Пример данных для кеширования.
     * </summary>
     */
    private String labData = "Данные лабораторной работы №6";
    
    /**
     * <summary>
     * Получает данные лабораторной работы.
     * </summary>
     * <returns>Данные лабораторной работы</returns>
     */
    public String getLabData() {
        return labData;
    }
}