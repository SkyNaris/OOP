package com.design;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private final Connection connection;

    @Inject
    public PaymentService(Connection connection) {
        this.connection = connection;
    }

    public List<Paycheck> getAllPaychecks() {
        List<Paycheck> paychecks = new ArrayList<>();
        String query = "SELECT id, amount, payDate FROM paychecks";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                paychecks.add(new Paycheck(
                    resultSet.getInt("id"),
                    resultSet.getDouble("amount"),
                    resultSet.getString("payDate")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error reading paychecks from DB", e);
        }
        return paychecks;
    }
}