package com.design;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Імпорти для веб-сервера
import com.design.webserver.JavalinWebServer;
import com.design.webserver.WebServer;

public class DesignModule extends AbstractModule {

    @Override
    protected void configure() {
        // Прив'язуємо рядок підключення
        bind(String.class)
            .annotatedWith(Names.named("JDBC URL"))
            .toInstance("jdbc:sqlite:target/design.db");
    }

    @Provides
    @Singleton
    WebServer provideWebServer() {
        return new JavalinWebServer();
    }

    @Provides
    @Singleton
    Connection provideConnection(@Named("JDBC URL") String url) {
        try {
            Connection connection = DriverManager.getConnection(url);
            createTableIfNotExists(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database connection", e);
        }
    }

    private void createTableIfNotExists(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            
            // 1. ПОВЕРТАЄМО таблицю 'briefs' (щоб не ламалася логіка Customer/DesignService)
            String createBriefsSQL = "CREATE TABLE IF NOT EXISTS briefs (" +
                                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                     "title TEXT NOT NULL, " +
                                     "description TEXT NOT NULL)";
            statement.execute(createBriefsSQL);

            // 2. ЗАЛИШАЄМО таблицю 'paychecks' (для нового завдання з веб-сервером)
            String createPaychecksSQL = "CREATE TABLE IF NOT EXISTS paychecks (" +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "amount REAL NOT NULL, " +
                                        "payDate TEXT NOT NULL)";
            statement.execute(createPaychecksSQL);
            
            // Додаємо тестові дані для зарплати
            String insertDataSQL = "INSERT INTO paychecks (amount, payDate) " +
                                   "SELECT 1500.50, '2023-12-01' " +
                                   "WHERE NOT EXISTS (SELECT 1 FROM paychecks)";
            statement.execute(insertDataSQL);

            System.out.println("Database initialized: tables 'briefs' and 'paychecks' created.");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create tables", e);
        }
    }
}