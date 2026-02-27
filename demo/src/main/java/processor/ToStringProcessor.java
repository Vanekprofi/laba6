package processor;

import annotations.ToString;
import annotations.ToString.Mode;
import java.lang.reflect.*;

/**
 * <summary>
 * Обработчик аннотации @ToString.
 * </summary>
 * <remarks>
 * Формирует строковое представление объекта, включая только поля с @ToString(Mode.YES).
 * Поля с @ToString(Mode.NO) исключаются из вывода.
 * </remarks>
 * <example>
 * <code>
 * ToStringDemo obj = new ToStringDemo();
 * String result = ToStringProcessor.build(obj);
 * System.out.println(result);
 * </code>
 * </example>
 * <author>Иван Шулепов, Ит-2</author>
 * <see cref="annotations.ToString"/>
 */
public class ToStringProcessor {
    
    /**
     * <summary>
     * Формирует строковое представление объекта на основе аннотации @ToString.
     * </summary>
     * <param name="obj">Объект для преобразования в строку</param>
     * <returns>Строковое представление объекта</returns>
     * <exception cref="IllegalArgumentException">Выбрасывается, если объект равен null</exception>
     */
    public static String build(Object obj) {
        // Проверка входных данных
        if (obj == null) {
            throw new IllegalArgumentException("Объект не может быть null");
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getSimpleName()).append(" {\n");
        
        // Получаем все поля класса
        Field[] fields = obj.getClass().getDeclaredFields();
        int includedCount = 0;
        int excludedCount = 0;
        
        for (Field field : fields) {
            // Делаем поле доступным
            field.setAccessible(true);
            
            // Проверяем наличие аннотации @ToString
            if (field.isAnnotationPresent(ToString.class)) {
                ToString annotation = field.getAnnotation(ToString.class);
                Mode mode = annotation.value();
                
                // Включаем только поля с Mode.YES
                if (mode == Mode.YES) {
                    try {
                        Object value = field.get(obj);
                        sb.append("    ").append(field.getName())
                          .append(" = ").append(value).append("\n");
                        includedCount++;
                    } catch (IllegalAccessException e) {
                        sb.append("    ").append(field.getName())
                          .append(" = [доступ запрещён]\n");
                    }
                } else if (mode == Mode.NO) {
                    excludedCount++;
                }
            }
        }
        
        sb.append("}");
        
        // Добавляем информацию о статистике
        sb.append(" // Включено: ").append(includedCount)
          .append(", Исключено: ").append(excludedCount);
        
        return sb.toString();
    }
}