package com.design;

public class Person {
    protected String name;

    // Конструктор за замовчуванням
    public Person() {
    }

    // Конструктор з ім'ям
    public Person(String name) {
        this.name = name;
    }

    // Геттер (вирішує помилку cannot find symbol method getName)
    public String getName() {
        return name;
    }

    // Сеттер (вирішує помилку cannot find symbol method setName)
    public void setName(String name) {
        this.name = name;
    }

    // Цей метод викликається у вас в Main.java
    public static void finalizeContract() {
        System.out.println("Договір офіційно підписано та завірено.");
    }
}