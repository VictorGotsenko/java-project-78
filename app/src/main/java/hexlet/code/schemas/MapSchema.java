package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, ?>> {


    public final MapSchema required() {
        conditions.put("required", inspectedMap -> inspectedMap != null);
        return this;
    }

    public final MapSchema sizeof(int mapLimit) {
        conditions.put("sizeof", inspectedMap -> inspectedMap.size() == mapLimit);
        return this;
    }

    public final <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        for (String key : schemas.keySet()) {
            BaseSchema<T> schemaForField = schemas.get(key);
            conditions.put(key, inspectedMap -> schemaForField.isValid((T) inspectedMap.get(key)));
        }
        return this;
    }
}
