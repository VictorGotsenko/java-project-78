package hexlet.code;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    @Test
    void numberSchemaNoRequiredTest() {
        var v = new Validator();
        var schema = v.number();

        assertTrue(schema.isValid(5)); // true

    // Пока не вызван метод required(), null считается валидным
        assertTrue(schema.isValid(null)); // true
        assertTrue(schema.positive().isValid(null)); // true
    }

    @Test
    void numberSchemaRequiredTest() {
        var v = new Validator();
        var schema = v.number();

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
    }

    @Test
    void numberSchemaPositiveTest() {
        var v = new Validator();
        var schema = v.number();

        schema.positive();
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
    }

    @Test
    void numberSchemaRange() {
        var v = new Validator();
        var schema = v.number();

        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(11));
    }


}
