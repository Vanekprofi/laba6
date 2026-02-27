package demo;

import annotations.ToString;
import annotations.ToString.Mode;

/**
 * <summary>
 * Демонстрационный класс для аннотации @ToString.
 * </summary>
 * <remarks>
 * Поля класса помечены аннотацией @ToString с разными режимами отображения.
 * Поля с Mode.YES будут включены в строковое представление, с Mode.NO - исключены.
 * </remarks>
 * <example>
 * <code>
 * ToStringDemo obj = new ToStringDemo();
 * String result = ToStringProcessor.build(obj);
 * System.out.println(result); // Покажет только поля с @ToString(Mode.YES)
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.ToString"/>
 * <see cref="processor.ToStringProcessor"/>
 */
@ToString
public class ToStringDemo {
    
    /**
     * <summary>
     * Имя студента, включается в строковое представление.
     * </summary>
     */
    @ToString(Mode.YES)
    private String studentName = "Иван Шулепов";
    
    /**
     * <summary>
     * Номер группы, включается в строковое представление.
     * </summary>
     */
    @ToString(Mode.YES)
    private String group = "Ит-2";
    
    /**
     * <summary>
     * Внутренний идентификатор, исключается из строкового представления.
     * </summary>
     */
    @ToString(Mode.NO)
    private long internalId = 123456789L;
    
    /**
     * <summary>
     * Поле без аннотации, поведение зависит от реализации обработчика.
     * </summary>
     */
    private String course = "Программирование";
    
    /**
     * <summary>
     * Год поступления, включается в строковое представление.
     * </summary>
     */
    @ToString(Mode.YES)
    private int year = 2024;
    
    /**
     * <summary>
     * Конфиденциальная информация, исключается из строкового представления.
     * </summary>
     */
    @ToString(Mode.NO)
    private String passwordHash = "secret123";
    
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
    public String getGroup() {
        return group;
    }
}