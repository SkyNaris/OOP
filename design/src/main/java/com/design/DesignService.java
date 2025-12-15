package com.design;

import com.google.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DesignService {
    private final Connection connection;

    @Inject
    public DesignService(Connection connection) {
        this.connection = connection;
    }

    public void saveBrief(Brief brief) {
        String sql = "INSERT INTO briefs (title, description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, brief.getTitle());
            statement.setString(2, brief.getDescription());
            statement.executeUpdate();
            // Цей лог буде видно при створенні
            System.out.println(">>> БД: Бриф збережено успішно."); 
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save brief", e);
        }
    }

    public List<Brief> getAllBriefs() {
        List<Brief> briefs = new ArrayList<>();
        String sql = "SELECT * FROM briefs";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Brief b = new Brief(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description")
                );
                briefs.add(b);
                
                // --- ДОДАНО ЛОГ ---
                // Цей текст буде виводитись кожного разу, коли веб-сторінка запитує дані
                System.out.println("Зчитано бриф з БД: " + b.getTitle() + " (ID: " + b.getId() + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return briefs;
    }
}