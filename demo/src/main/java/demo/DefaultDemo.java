package demo;

import annotations.Default;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <summary>
 * Демонстрационный класс для аннотации @Default.
 * </summary>
 * <remarks>
 * Класс и его поля помечены аннотацией @Default с указанием типов по умолчанию.
 * </remarks>
 * <example>
 * <code>
 * DefaultProcessor.process(DefaultDemo.class);
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.Default"/>
 * <see cref="processor.DefaultProcessor"/>
 */
@Default(ArrayList.class)
public class DefaultDemo {
    
    /**
     * <summary>
     * Поле с аннотацией @Default, указывающей тип String.
     * </summary>
     */
    @Default(String.class)
    private String studentName = "Иван Шулепов";
    
    /**
     * <summary>
     * Поле с аннотацией @Default, указывающей тип Integer.
     * </summary>
     */
    @Default(Integer.class)
    private int groupNumber = 2;
    
    /**
     * <summary>
     * Поле с аннотацией @Default, указывающей тип HashMap.
     * </summary>
     */
    @Default(HashMap.class)
    private java.util.Map<String, Object> additionalInfo = new HashMap<>();
    
    /**
     * <summary>
     * Получает имя студента.
     * </summary>
     * <returns>Имя студента</returns>
     */
    public String getStudentName() {
        return studentName;
    }
    
    /**
     * <summary>
     * Получает номер группы.
     * </summary>
     * <returns>Номер группы</returns>
     */
    public int getGroupNumber() {
        return groupNumber;
    }
}