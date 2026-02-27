package annotations;

import java.lang.annotation.*;

/**
 * <summary>
 * Аннотация для указания списка типов классов, подлежащих валидации.
 * </summary>
 * <remarks>
 * <para>Цель: тип или аннотация</para>
 * <para>Время жизни: время выполнения (RUNTIME)</para>
 * <para>Свойство: <c>value</c> - массив типов Class для проверки</para>
 * </remarks>
 * <example>
 * <code>
 * &#64;Validate({String.class, Integer.class, ArrayList.class})
 * public class DataValidator { }
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface Validate {
    
    /**
     * <summary>
     * Возвращает массив типов классов для валидации.
     * </summary>
     * <returns>Массив классов, указанных для проверки</returns>
     */
    Class<?>[] value();
}