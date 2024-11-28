### Hexlet tests and linter status:
[![Actions Status](https://github.com/VictorGotsenko/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/VictorGotsenko/java-project-78/actions)
[![Data-Validator](https://github.com/VictorGotsenko/java-project-78/actions/workflows/Data-Validator.yml/badge.svg)](https://github.com/VictorGotsenko/java-project-78/actions/workflows/Data-Validator.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/816a66e17a812dadd31f/maintainability)](https://codeclimate.com/github/VictorGotsenko/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/816a66e17a812dadd31f/test_coverage)](https://codeclimate.com/github/VictorGotsenko/java-project-78/test_coverage)
## Description
Data-Validator is a library that can be used to check the correctness of input data for the following types: String, Integer and Map.
For each data type, of checks defined:
***
Data-Validator – библиотека, с помощью которой можно проверять корректность вводимых данных для следующих типов: String, Integer and Map.
Для каждого типа данных определены наборы проверок:

### 1.String:
* required() — делает данные обязательными для заполнения, запрещая использовать _пустую_ _строку_ или _null_ в качестве значения.
* minLength(N) — ограничивает минимальную длину строки. Строка должна быть равна или длиннее указанного числа.
* contains(subString) — ограничивает по содержимому строки. Строка должна содержать определённую подстроку.
#### Пример использования
```java
var v = new Validator();
var schema = v.string();
// Пока не вызван метод required(), null и пустая строка считаются валидным
schema.isValid(""); // true
schema.isValid(null); // true

schema.required();
schema.isValid(""); // false
schema.isValid("Hello world!"); // true

schema.contains("el");
schema.isValid("Hello world!"); // true

schema1.minLength(4).isValid("Hello"); // true
````
