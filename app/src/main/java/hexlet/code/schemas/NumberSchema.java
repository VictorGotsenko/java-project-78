package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    private boolean required;

    // required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения
    public final NumberSchema required() {
        this.required = true;
        conditions.add(value -> value != null);
        return this;

    }

    // positive() — добавляет ограничение на знак числа. Число должно быть положительным
    public final NumberSchema positive() {
        conditions.add(value -> value == null || value > 0);
        return this;
    }

    // range() — добавляет допустимый диапазон, в который должно попадать значение числа включая границы
    public final NumberSchema range(int min, int max) {
        conditions.add(value -> value == null || value >= min && value <= max);
        return this;
    }
}
