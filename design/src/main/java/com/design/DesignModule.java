package com.design;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import java.sql.*;
import com.design.webserver.JavalinWebServer;
import com.design.webserver.WebServer;

public class DesignModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("JDBC URL")).toInstance("jdbc:sqlite:target/design.db");
    }

    @Provides @Singleton
    WebServer provideWebServer() { return new JavalinWebServer(); }

    @Provides @Singleton
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
            // Створюємо таблицю briefs
            String createBriefsSQL = "CREATE TABLE IF NOT EXISTS briefs (" +
                                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                     "title TEXT NOT NULL, " +
                                     "description TEXT NOT NULL)";
            statement.execute(createBriefsSQL);

            // Додаємо тестові дані, якщо таблиця порожня
            String insertDataSQL = "INSERT INTO briefs (title, description) " +
                                   "SELECT 'Логотип Кав''ярні', 'Розробити логотип у коричневих тонах' " +
                                   "WHERE NOT EXISTS (SELECT 1 FROM briefs)";
            statement.execute(insertDataSQL);
            
            System.out.println("Database initialized: table 'briefs' checked/created.");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create tables", e);
        }
    }
}