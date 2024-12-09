package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public final StringSchema required() {
        super.isRequired = true;
        setConditions("required", value -> !value.isEmpty());
        return this;
    }

    public final StringSchema minLength(int minLength) {
        setConditions("minLength", value -> value.length() >= minLength);
        return this;
    }

    public final StringSchema contains(String substring) {
        setConditions("contains", value -> value.contains(substring));
        return this;
    }
}
