package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private boolean required;
    private int minLength;
    private String subStringContains;

    public final StringSchema required() {
        this.required = true;
        conditions.add(value -> value != null && !value.isEmpty());
        return this;
    }

    public final StringSchema minLength(int length) {
        this.minLength = length;
        conditions.add(value -> value == null || value.length() >= minLength);
        return this;
    }

    public final StringSchema contains(String substring) {
        this.subStringContains = substring;
        conditions.add(value -> value == null || value.contains(subStringContains));
        return this;
    }
}
