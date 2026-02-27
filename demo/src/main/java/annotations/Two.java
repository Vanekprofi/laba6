package annotations;

import java.lang.annotation.*;

/**
 * <summary>
 * Аннотация для хранения двух свойств разного типа: строки и целого числа.
 * </summary>
 * <remarks>
 * <para>Цель: тип</para>
 * <para>Время жизни: время выполнения (RUNTIME)</para>
 * <para>Свойства: <c>first</c> (String) и <c>second</c> (int) - оба обязательные</para>
 * </remarks>
 * <example>
 * <code>
 * &#64;Two(first = "Shulepov Ivan", second = 2026)
 * public class StudentInfo { }
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Two {
    
    /**
     * <summary>
     * Возвращает первое свойство - строковое значение.
     * </summary>
     * <returns>Строковое значение</returns>
     */
    String first();
    
    /**
     * <summary>
     * Возвращает второе свойство - целочисленное значение.
     * </summary>
     * <returns>Целочисленное значение</returns>
     */
    int second();
}