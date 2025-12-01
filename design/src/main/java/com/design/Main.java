package com.design;

import com.google.inject.Guice;     // Імпорт Guice
import com.google.inject.Injector;  // Імпорт Injector

/**
 * Головний клас програми
 */
public class Main {
    public static void main(String[] args) {
        // --- НАЛАШТУВАННЯ GUICE ---
        // Створюємо інжектор на основі нашого модуля (DesignModule)
        Injector injector = Guice.createInjector(new DesignModule());

        // Отримуємо екземпляр Customer через інжектор (замість new)
        Customer customer = injector.getInstance(Customer.class);
        
        // Оскільки ми змінили конструктор, встановлюємо ім'я окремо (якщо у Person є setName)
        // Якщо у Person немає setName, то ім'я залишиться "Замовник" з конструктора
        customer.setName("Іван"); 
        // --------------------------

        // Designer поки що залишаємо як є, або теж можна перевести на Guice, якщо для нього є логіка
        Designer designer = new Designer("Марія");
        
        // Демонстрація процесу
        // (Тут при виклику fillBrief автоматично спрацює збереження в БД)
        Brief brief = customer.fillBrief(); 
        
        // Перевірка (якщо у Brief є метод getDetails, або getTitle як ми робили раніше)
        // Припускаємо, що у вашому Brief є getDetails(), якщо ні - змініть на getTitle()
        System.out.println("Деталі брифу: " + brief.getTitle()); 
        
        designer.sendConcepts();
        customer.acceptConcepts();
        customer.approveEdits();
        
        designer.sendFinalFiles();
        Guideline guideline = designer.createGuideline();
        guideline.download();
        
        // Завершення контракту
        Person.finalizeContract();
    }
}