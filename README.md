# OOP Project

## Компіляція та запуск

1. Перейдіть в каталог з вихідним кодом:
```bash
cd pr_2/src
```

2. Скомпілюйте всі Java файли:
```bash
javac *.java
```

3. Запустіть програму:
```bash
java Main
```

## Структура проєкту

- `src/` - каталог з вихідним кодом
  - `ILogoProcess.java` - інтерфейс процесу розробки логотипу
  - `Person.java` - абстрактний клас особи
  - `Designer.java` - клас дизайнера
  - `Customer.java` - клас замовника
  - `Brief.java` - клас брифу
  - `Logo.java` - клас логотипу
  - `Guideline.java` - клас гайдлайну
  - `Main.java` - головний клас програми

- `docs/` - каталог з документацією
  - `requirements.md` - вимоги до програми
  - `usecase.puml` - UML-діаграма варіантів використання
  - `class.puml` - UML-діаграма класів
  - `sequence.puml` - UML-діаграма послідовності
  - `state.puml` - UML-діаграма станів