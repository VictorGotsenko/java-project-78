package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private int minLength;
    private String subStringContains;

    public final StringSchema required() {
        conditions.put("required", value -> value != null && !value.isEmpty());
        return this;
    }

    public final StringSchema minLength(int length) {
        this.minLength = length;
        conditions.put("minLength", value -> value == null || value.length() >= minLength);
        return this;
    }

    public final StringSchema contains(String substring) {
        this.subStringContains = substring;
        conditions.put("contains", value -> value == null || value.contains(subStringContains));
        return this;
    }
}
