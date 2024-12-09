package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, ?>> {

    public final MapSchema required() {
        super.isRequired = true;
        setConditions("required", inspectedMap -> inspectedMap != null);
        return this;
    }

    public final MapSchema sizeof(int mapLimit) {
        setConditions("sizeof", inspectedMap -> inspectedMap.size() == mapLimit);
        return this;
    }

    public final <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        setConditions("shape", map -> {
            return schemas.entrySet().stream().allMatch(e -> {
                var v = map.get(e.getKey());
                var schema = e.getValue();
                return schema.isValid((T) v);
            });
        });
        return this;
    }
}
