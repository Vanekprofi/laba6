package annotations;

import java.lang.annotation.*;

/**
 * <summary>
 * Аннотация для автоматического вызова методов через обработчик.
 * </summary>
 * <remarks>
 * <para>Цель: только методы</para>
 * <para>Время жизни: время выполнения (RUNTIME)</para>
 * <para>Свойства: отсутствуют</para>
 * </remarks>
 * <example>
 * <code>
 * public class MyClass {
 *     &#64;Invoke
 *     public void myMethod() {
 *         System.out.println("Вызван автоматически");
 *     }
 * }
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Invoke {
}