package com.design;

/**
 * Клас технічного завдання (Бриф)
 */
public class Brief {
    private String title;
    private String description;

    /**
     * Конструктор
     * @param title Назва проєкту
     */
    public Brief(String title) {
        this.title = title;
        // Оскільки у Customer.java ви передаєте тільки один параметр,
        // заповнимо опис значенням за замовчуванням, щоб не було помилок в БД
        this.description = "Опис проєкту: " + title;
    }

    /**
     * Конструктор з двома параметрами (на майбутнє)
     */
    public Brief(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Геттер для заголовка (потрібен для DesignService)
    public String getTitle() {
        return title;
    }

    // Геттер для опису (потрібен для DesignService)
    public String getDescription() {
        return description;
    }
    
    // Метод для сумісності, якщо десь використовується getDetails
    public String getDetails() {
        return description;
    }
}