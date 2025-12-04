package com.design;

import com.google.inject.Guice;
import com.google.inject.Injector;
// Додаємо імпорт для веб-сервера
import com.design.webserver.WebServer;

/**
 * Головний клас програми
 */
public class Main {
    public static void main(String[] args) {
        // --- НАЛАШТУВАННЯ GUICE ---
        // Створюємо інжектор на основі нашого модуля (DesignModule)
        Injector injector = Guice.createInjector(new DesignModule());

        // --- КОНСОЛЬНА ЧАСТИНА (Ваш старий код) ---
        // Отримуємо екземпляр Customer через інжектор
        Customer customer = injector.getInstance(Customer.class);
        
        customer.setName("Іван"); 

        Designer designer = new Designer("Марія");
        
        // Демонстрація процесу
        Brief brief = customer.fillBrief(); 
        
        System.out.println("Деталі брифу: " + brief.getTitle()); 
        
        designer.sendConcepts();
        customer.acceptConcepts();
        customer.approveEdits();
        
        designer.sendFinalFiles();
        Guideline guideline = designer.createGuideline();
        guideline.download();
        
        Person.finalizeContract();

        // --- ВЕБ ЧАСТИНА (Нове завдання 2.6) ---
        System.out.println("--- Запуск веб-сервера ---");
        runWebMode(injector);
    }

    // Метод для запуску веб-сервера
    private static void runWebMode(Injector injector) {
        // 1. Отримуємо наш веб-сервер (Javalin) з інжектора
        WebServer server = injector.getInstance(WebServer.class);

        // 2. Отримуємо наше відображення (View), яке малює HTML-таблицю
        PayrollWebView view = injector.getInstance(PayrollWebView.class);

        // 3. Налаштовуємо: коли заходимо на головну сторінку "/", показуємо наш view
        server.configure("/", view);

        // 4. Запускаємо сервер на порту 8080
        server.start(8080);
    }
}