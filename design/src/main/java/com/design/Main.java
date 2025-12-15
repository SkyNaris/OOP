package com.design;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.design.webserver.WebServer;

public class Main {

    public static void main(String[] args) {
        // 1. Ініціалізація Guice
        Injector injector = Guice.createInjector(new DesignModule());

        // --- КОНСОЛЬНА ЧАСТИНА (Імітація бізнес-процесу) ---
        
        // Створюємо дійових осіб
        Customer customer = injector.getInstance(Customer.class);
        customer.setName("Іван Петренко");
        System.out.println("Створено особу: " + customer.getName());

        Designer designer = new Designer("Марія Коваленко");
        System.out.println("Створено особу: " + designer.getName());

        System.out.println("\nІнформація про учасників проєкту:");
        System.out.println("Замовник: " + customer.getName());
        System.out.println("Дизайнер: " + designer.getName());

        // Імітація процесу
        System.out.println("Обробка дизайн-процесу...");
        
        // Створення брифу (це запише дані в БД через Service)
        Brief brief = customer.fillBrief(); 
        
        System.out.println("Створено бриф: " + brief.getTitle());
        System.out.println("Бриф оброблено для: " + customer.getName());
        
        System.out.println("Деталі Брифу:");
        System.out.println("Назва: " + brief.getTitle());
        System.out.println("Опис: " + brief.getDescription());

        // --- ВЕБ ЧАСТИНА ---
        runWebMode(injector);
    }

    private static void runWebMode(Injector injector) {
        WebServer server = injector.getInstance(WebServer.class);
        BriefWebView view = injector.getInstance(BriefWebView.class);

        server.configure("/", view);
        server.start(8080);

        // --- КРАСИВИЙ БАНЕР (Як у прикладі) ---
        System.out.println("──────────────────────────────────────────────");
        System.out.println("Design Web Server запущено!");
        System.out.println("");
        System.out.println("REST API: http://localhost:8080");
        System.out.println("");
        System.out.println("Відкрийте src/main/resources/index.html");
        System.out.println("за допомогою Live Server (VS Code extension)");
        System.out.println("");
        System.out.println("Endpoint:");
        System.out.println("   GET  /api/briefs - перегляд брифів");
        System.out.println("──────────────────────────────────────────────");
    }
}