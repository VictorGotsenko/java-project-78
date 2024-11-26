package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

abstract class BaseSchema<T> {

    List<Predicate<T>> conditions = new ArrayList<>();

    public final boolean isValid(T value) {
        for (Predicate<T> c : conditions) {
            if (!c.test(value)) {
                return false;
            }
        }
        return true;
    }
}
