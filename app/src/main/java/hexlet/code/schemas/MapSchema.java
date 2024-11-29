package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, ?>> {


    public final MapSchema required() {
        setConditions("required", inspectedMap -> inspectedMap != null);
        return this;
    }

    public final MapSchema sizeof(int mapLimit) {
        setConditions("sizeof", inspectedMap -> inspectedMap.size() == mapLimit);
        return this;
    }

    public final <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        for (String key : schemas.keySet()) {
            BaseSchema<T> schemaForField = schemas.get(key);
            setConditions(key, inspectedMap -> schemaForField.isValid((T) inspectedMap.get(key)));
        }
        return this;
    }
}
