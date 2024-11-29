package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        setConditions("required", value -> value != null);
        return this;
    }

    public final NumberSchema positive() {
        setConditions("positive", value -> value == null || value > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        setConditions("range", value -> value == null || value >= min && value <= max);
        return this;
    }
}
