package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

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


}
