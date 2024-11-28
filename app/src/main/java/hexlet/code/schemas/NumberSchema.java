package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        conditions.put("required", value -> value != null);
        return this;
    }

    public final NumberSchema positive() {
        conditions.put("positive", value -> value == null || value > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        conditions.put("range", value -> value == null || value >= min && value <= max);
        return this;
    }
}
