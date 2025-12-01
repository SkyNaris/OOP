package com.design;

import com.google.inject.Inject; // Додаємо імпорт для Guice

/**
 * Клас замовника
 */
public class Customer extends Person {
    private Brief brief;
    private final DesignService designService; // Поле для сервісу БД
    
    /**
     * Конструктор класу Customer з ін'єкцією залежностей
     * @param designService сервіс для роботи з БД (надає Guice)
     */
    @Inject
    public Customer(DesignService designService) {
        super("Замовник"); // Тимчасове ім'я, справжнє встановимо в Main через setName
        this.designService = designService;
    }
    
    /**
     * Метод заповнення брифу
     * @return заповнений бриф
     */
    public Brief fillBrief() {
        // Оскільки ім'я тепер може бути змінене через сетер, беремо актуальне
        System.out.println("Замовник " + getName() + " заповнює бриф");
        
        brief = new Brief("Деталі проєкту");
        
        // --- ЗБЕРЕЖЕННЯ В БД ---
        // Викликаємо метод сервісу, щоб зберегти створений бриф
        designService.saveBrief(brief);
        // -----------------------
        
        return brief;
    }
    
    /**
     * Метод прийняття концептів
     */
    public void acceptConcepts() {
        System.out.println("Замовник " + getName() + " приймає концепти");
    }
    
    /**
     * Метод погодження правок
     */
    public void approveEdits() {
        System.out.println("Замовник " + getName() + " погоджує правки");
    }
}