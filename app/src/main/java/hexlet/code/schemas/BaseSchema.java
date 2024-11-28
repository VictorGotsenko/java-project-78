package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    Map<String, Predicate<T>> conditions = new HashMap<>();

    public final boolean isValid(T value) {
        for (String r : conditions.keySet()) {
            if (!conditions.get(r).test(value)) {
                return false;
            }
        }
        return true;
    }
}
