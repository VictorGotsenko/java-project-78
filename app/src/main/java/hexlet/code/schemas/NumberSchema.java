package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        conditions.add(value -> value != null);
        return this;

    }

    public final NumberSchema positive() {
        conditions.add(value -> value == null || value > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        conditions.add(value -> value == null || value >= min && value <= max);
        return this;
    }
}
