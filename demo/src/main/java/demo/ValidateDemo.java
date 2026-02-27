package demo;

import annotations.Validate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <summary>
 * Демонстрационный класс для аннотации @Validate.
 * </summary>
 * <remarks>
 * Класс помечен аннотацией @Validate с указанием списка типов для валидации.
 * Обработчик выведет все указанные типы.
 * </remarks>
 * <example>
 * <code>
 * ValidateProcessor.process(ValidateDemo.class);
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Validate"/>
 * <see cref="processor.ValidateProcessor"/>
 */
@Validate({String.class, Integer.class, ArrayList.class, HashMap.class})
public class ValidateDemo {
    
    /**
     * <summary>
     * Имя для валидации.
     * </summary>
     */
    private String name = "Шулепов";
    
    /**
     * <summary>
     * Курс для валидации.
     * </summary>
     */
    private int course = 2;
    
    /**
     * <summary>
     * Список предметов для валидации.
     * </summary>
     */
    private List<String> subjects = new ArrayList<>();
    
    /**
     * <summary>
     * Получает имя.
     * </summary>
     * <returns>Имя</returns>
     */
    public String getName() {
        return name;
    }
    
    /**
     * <summary>
     * Получает курс.
     * </summary>
     * <returns>Курс</returns>
     */
    public int getCourse() {
        return course;
    }
}