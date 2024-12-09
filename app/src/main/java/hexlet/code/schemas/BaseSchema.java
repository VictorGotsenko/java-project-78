package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean isRequired = false;
    private Map<String, Predicate<T>> conditions = new LinkedHashMap<>();

    BaseSchema() {
        setConditions("isValueNull", Objects::nonNull);
    }

    public final void setConditions(String key, Predicate<T> value) {
        this.conditions.put(key, value);
    }

    public final boolean isValid(T value) {

        if (!isRequired) {
            var checkNull = conditions.get("isValueNull");
            if (!checkNull.test(value)) {
                return true;
            }
        }

        for (String r : conditions.keySet()) {
            if (!conditions.get(r).test(value)) {
                return false;
            }
        }
        return true;
    }
}
