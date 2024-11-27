package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public final MapSchema required() {
        conditions.add(value -> value != null);
        return this;
    }

    public final MapSchema sizeof(int mapLimit) {
        conditions.add(value -> value.size() == mapLimit);
        return this;
    }


}
