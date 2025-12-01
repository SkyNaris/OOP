package com.design;

/**
 * Базовий клас Людина
 */
public class Person {
    private String name;

    /**
     * Конструктор
     * @param name ім'я
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Отримати ім'я
     */
    public String getName() {
        return name;
    }

    /**
     * Встановити нове ім'я (ЦЕЙ МЕТОД БУВ ВІДСУТНІЙ)
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Статичний метод для завершення контракту
     */
    public static void finalizeContract() {
        System.out.println("Контракт завершено. Всі сторони задоволені.");
    }
}