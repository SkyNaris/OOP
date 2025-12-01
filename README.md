# Design Project Simulation

Цей проєкт демонструє використання Dependency Injection (Google Guice) та роботу з базою даних SQLite.

## Структура
- `src/main/java/com/design/Customer.java` - Головний клас сутності.
- `src/main/java/com/design/Brief.java` - Клас-залежність (частина композиції).
- `src/main/java/com/design/DesignModule.java` - Налаштування Guice (DI).
- `src/main/java/com/design/DesignService.java` - Сервіс для запису в БД.
- `src/main/java/com/design/Main.java` - Точка входу.

## Як зібрати
mvn clean install

## Як запустити
mvn exec:java -Dexec.mainClass="com.design.Main"