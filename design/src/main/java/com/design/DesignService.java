package com.design;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DesignService {
    private final Connection connection;

    @Inject
    public DesignService(Connection connection) {
        this.connection = connection;
    }

    // Метод для збереження Брифу в базу
    public void saveBrief(Brief brief) {
        String sql = "INSERT INTO briefs (title, description) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, brief.getTitle());
            statement.setString(2, brief.getDescription());
            statement.executeUpdate();
            System.out.println("Brief saved to database: " + brief.getTitle());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save brief", e);
        }
    }
}