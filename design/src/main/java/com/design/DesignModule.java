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

public class DesignModule extends AbstractModule {

    @Override
    protected void configure() {
        // Прив'язуємо рядок підключення
        bind(String.class)
            .annotatedWith(Names.named("JDBC URL"))
            .toInstance("jdbc:sqlite:target/design.db"); // Файл бази буде тут
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
        // Створюємо таблицю briefs для збереження даних з класу Brief
        String createTableSQL = "CREATE TABLE IF NOT EXISTS briefs (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "title TEXT NOT NULL, " +
                                "description TEXT NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Database and table initialized.");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }
}