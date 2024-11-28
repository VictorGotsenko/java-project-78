package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {

    @Test
    public void mapSchemaNoRequired() {
        var v = new Validator();
        var schema = v.map();
        assertTrue(schema.isValid(null)); // true
    }

    @Test
    public void mapSchemaRequired() {
        var v = new Validator();
        var schema = v.map();
        schema.required();
        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(new HashMap<>())); // true
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data)); // true
    }

    @Test
    public void mapSchemaSizeof() {
        var v = new Validator();
        var schema = v.map();
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        schema.sizeof(2);
        assertFalse(schema.isValid(data)); // false
        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); // true
    }
    @Test
    public void mapSchemaShape() {
        var v = new Validator();
        var schema = v.map();

        // Метод shape - позволяет описывать валидацию для значений каждого ключа объекта Map
        // Создаю набор схем для проверки каждого ключа проверяемого объекта
        // Для значения каждого ключа - своя схема
        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        // Определяю схемы валидации для значений свойств "firstName" и "lastName"
        // Имя должно быть строкой, обязательно для заполнения
        schemas.put("firstName", v.string().required());
        // Фамилия обязательна для заполнения и должна содержать не менее 2 символов
        schemas.put("lastName", v.string().required().minLength(2));
        // Настраиваю схему `MapSchema` и передаю созданный набор схем в метод shape()
        schema.shape(schemas);

        // Проверяем объекты
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1)); // true

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2)); // false

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3)); // false
    }




}
