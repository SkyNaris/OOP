package com.design;

public class Brief {
    private int id; // Додаємо ID для бази даних
    private String title;
    private String description;

    // Конструктор для створення нового брифу (без ID)
    public Brief(String title) {
        this.title = title;
        this.description = "Опис проєкту: " + title;
    }

    public Brief(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Конструктор для витягування з БД (з ID)
    public Brief(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDetails() { return description; }
}