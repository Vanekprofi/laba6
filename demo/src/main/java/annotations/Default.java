package annotations;

import java.lang.annotation.*;

/**
 * <summary>
 * Аннотация для указания типа по умолчанию для класса или поля.
 * </summary>
 * <remarks>
 * <para>Цель: тип или поле</para>
 * <para>Время жизни: время выполнения (RUNTIME)</para>
 * <para>Свойство: <c>value</c> - обязательный тип Class</para>
 * </remarks>
 * <example>
 * <code>
 * &#64;Default(ArrayList.class)
 * public class MyClass { }
 * 
 * public class AnotherClass {
 *     &#64;Default(String.class)
 *     private String name;
 * }
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Default {
    
    /**
     * <summary>
     * Возвращает тип класса по умолчанию.
     * </summary>
     * <returns>Тип класса, указанный в аннотации</returns>
     */
    Class<?> value();
}