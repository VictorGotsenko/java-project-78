package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {

    @Test
    public void stringSchemaTestNoRequired() {
        var v = new Validator();
        var schema = v.string();
        // Пока не вызван метод required(), null и пустая строка считаются валидным
        assertTrue(schema.isValid("")); // true
        assertTrue(schema.isValid(null)); // true
    }

    @Test
    public void stringSchemaTestRequired() {
        var v = new Validator();
        var schema = v.string();
        schema.required();

        // Вызван метод required(), null и пустая строка считаются false
        assertFalse(schema.isValid("")); // false
        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid("what does the fox say")); // true
        assertTrue(schema.isValid("hexlet")); // true

    }

    @Test
    public void stringSchemaTestContains() {
        var v = new Validator();
        var schema = v.string();
        schema.contains("wh");

        assertTrue(schema.isValid("what does the fox say")); // true
        schema.contains("what");
        assertTrue(schema.isValid("what does the fox say")); // true
        schema.contains("whatthe");
        assertFalse(schema.isValid("what does the fox say")); // false
    }
    @Test
    public void stringSchemaTestAddChecks() {
        var v = new Validator();
        var schema = v.string().required().minLength(5).contains("xle");
        assertFalse(schema.isValid("what does the fox say")); // false
        assertTrue(schema.isValid("Hexlet"));
        var schema1 = v.string();
        assertTrue(schema1.minLength(10).minLength(4).isValid("Hexlet")); // true
    }
}
