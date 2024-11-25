package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private boolean required;
    private int minLength;
    private String subStringContains;
    private List<Predicate<String>> conditions = new ArrayList<>();

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

    public final boolean isValid(String value) {
        for (Predicate<String> c : conditions) {
            if (!c.test(value)) {
                return false;
            }
        }
        return true;
    }

}
