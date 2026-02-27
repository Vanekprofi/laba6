package annotations;

import java.lang.annotation.*;

/**
 * <summary>
 * Аннотация для управления включением полей в строковое представление объекта.
 * </summary>
 * <remarks>
 * <para>Цель: тип или поле</para>
 * <para>Время жизни: время выполнения (RUNTIME)</para>
 * <para>Свойство: <c>value</c> - режим отображения (по умолчанию YES)</para>
 * </remarks>
 * <example>
 * <code>
 * &#64;ToString
 * public class Person {
 *     &#64;ToString(Mode.YES)
 *     private String name;
 *     
 *     &#64;ToString(Mode.NO)
 *     private String password;
 * }
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {
    
    /**
     * <summary>
     * Режим отображения поля в строковом представлении.
     * </summary>
     */
    enum Mode {
        /**
         * <summary>
         * Поле включается в строковое представление.
         * </summary>
         */
        YES,
        
        /**
         * <summary>
         * Поле исключается из строкового представления.
         * </summary>
         */
        NO
    }
    
    /**
     * <summary>
     * Возвращает режим отображения поля.
     * </summary>
     * <returns>Режим отображения (по умолчанию YES)</returns>
     */
    Mode value() default Mode.YES;
}