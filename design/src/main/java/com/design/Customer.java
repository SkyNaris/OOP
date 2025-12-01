package com.design;

import com.google.inject.Inject;

public class Customer extends Person {
    private Brief brief;
    private DesignService designService; 
    
    // 3.1. Змінюємо конструктор:
    // Прибираємо @Inject і прибираємо DesignService з параметрів.
    // Тепер це звичайний конструктор.
    public Customer() {
        super("Замовник"); 
    }
    
    // 3.2. Додаємо Setter Method для впровадження залежності
    // Guice знайде цей метод завдяки @Inject і викличе його одразу після створення об'єкта
    @Inject
    public void setDesignService(DesignService designService) {
        this.designService = designService;
    }
    
    public Brief fillBrief() {
        System.out.println("Замовник " + getName() + " заповнює бриф");
        brief = new Brief("Деталі проєкту");
        
        // Перевірка на null, про всяк випадок (хоча Guice гарантує впровадження)
        if (designService != null) {
            designService.saveBrief(brief);
        }
        
        return brief;
    }
    
    public void acceptConcepts() {
        System.out.println("Замовник " + getName() + " приймає концепти");
    }
    
    public void approveEdits() {
        System.out.println("Замовник " + getName() + " погоджує правки");
    }
}