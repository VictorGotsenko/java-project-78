package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        super.isRequired = true;
        return this;
    }

    public final NumberSchema positive() {
        setConditions("positive", value -> value > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        setConditions("range", value -> value >= min && value <= max);
        return this;
    }
}
