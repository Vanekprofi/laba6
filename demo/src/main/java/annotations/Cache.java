package annotations;

import java.lang.annotation.*;

/**
 * <summary>
 * Аннотация для указания кешируемых областей класса.
 * </summary>
 * <remarks>
 * <para>Цель: тип</para>
 * <para>Время жизни: время выполнения (RUNTIME)</para>
 * <para>Свойство: <c>value</c> - массив имён кешируемых областей (по умолчанию пустой)</para>
 * </remarks>
 * <example>
 * <code>
 * &#64;Cache({"students", "groups", "schedule"})
 * public class DataManager { }
 * 
 * &#64;Cache // Пустой массив по умолчанию
 * public class EmptyCache { }
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Cache {
    
    /**
     * <summary>
     * Возвращает массив имён кешируемых областей.
     * </summary>
     * <returns>Массив строк с именами кешей (по умолчанию пустой)</returns>
     */
    String[] value() default {};
}