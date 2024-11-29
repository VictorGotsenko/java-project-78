### Hexlet tests and linter status:
[![Actions Status](https://github.com/VictorGotsenko/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/VictorGotsenko/java-project-78/actions)
[![Data-Validator](https://github.com/VictorGotsenko/java-project-78/actions/workflows/Data-Validator.yml/badge.svg)](https://github.com/VictorGotsenko/java-project-78/actions/workflows/Data-Validator.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/816a66e17a812dadd31f/maintainability)](https://codeclimate.com/github/VictorGotsenko/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/816a66e17a812dadd31f/test_coverage)](https://codeclimate.com/github/VictorGotsenko/java-project-78/test_coverage)
## Description
Data-Validator is a library that can be used to check the correctness of input data for the following types: String, Integer and Map.

Это библиотека, с помощью которой можно проверять корректность вводимых данных для следующих типов: String, Integer and Map.
Для каждого типа данных определены наборы проверок:

For each data type, of checks defined:
1. String: required(),  minLength(), contains()
2. Integer: required(), positive(), range()
3. Map: required(), sizeof(), shape()


### 1.String:
* required() — Makes the data mandatory, disallowing the use of an _empty_ _string_ or _null_ as a value. (Обязательное поле, запрещено использовать _пустую_ _строку_ или _null_ ).
* minLength(N) — Limits the minimum length of the string. The string must be equal to or longer than the specified number (Ограничивает минимальную длину строки. Она должна быть равна или длиннее указанного числа).
* contains(subString) — Limits by string content. The string must contain a certain substring (Ограничивает по содержимому строки. Она должна содержать определённую подстроку).
#### Example of using
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

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
### 2.Integer
* required() — Prohibits using _null_ as a value (Запрещает использовать _null_ в качестве значения).
* positive() — Adds a restriction on the sign of the number. The number must be _positive_ (Добавляет ограничение на знак числа. Число должно быть положительным).
* range() — Adds a valid range that the number value must fall within, including its boundaries (Добавляет допустимый диапазон, в который должно попадать значение числа включая границы).
#### Example of using
```java
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

var v = new Validator();
var schema = v.number();
schema.isValid(5); // true

// Пока не вызван метод required(), null считается валидным
schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10); // true

// Потому что ранее мы вызвали метод positive()
schema.isValid(-10); // false
//  Ноль — не положительное число
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
````
### 3.Map
* required() — Adds a restriction to the schema that does not allow _null_ as a value. Requires Map data type (Добавляет в схему ограничение, которое не позволяет использовать _null_ в качестве значения. Требуется тип данных Map).
* sizeof() — Adds a limitation on the size of the map. The number of key-value pairs in the Map object must be equal to the specified number (Добавляет ограничение на размер мапы. Количество пар ключ-значений в объекте Map должно быть равно заданному).
* shape() - Used to define the properties of a Map object and create a schema to validate their values. Each property of a Map object is assigned its own set of constraints (its own schema), which allows for more precise control over the data (Используется для определения свойств объекта Map и создания схемы для валидации их значений. Каждому свойству объекта Map привязывается свой набор ограничений (своя схема), что позволяет более точно контролировать данные).
#### Example of using
```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

var v = new Validator();
var schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(new HashMap<>()); // true
var data = new HashMap<String, String>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true

// shape позволяет описывать валидацию для значений каждого ключа объекта Map
// Создаем набор схем для проверки каждого ключа проверяемого объекта
// Для значения каждого ключа - своя схема
Map<String, BaseSchema<String>> schemas = new HashMap<>();

// Определяем схемы валидации для значений свойств "firstName" и "lastName"
// Имя должно быть строкой, обязательно для заполнения
schemas.put("firstName", v.string().required());
// Фамилия обязательна для заполнения и должна содержать не менее 2 символов
schemas.put("lastName", v.string().required().minLength(2));

// Настраиваем схему `MapSchema`
// Передаем созданный набор схем в метод shape()
schema.shape(schemas);

// Проверяем объекты
Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", null);
schema.isValid(human2); // false

Map<String, String> human3 = new HashMap<>();
human3.put("firstName", "Anna");
human3.put("lastName", "B");
schema.isValid(human3); // false

````
#### _It`s all ;-)_
