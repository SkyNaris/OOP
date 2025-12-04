package com.design;

public class Paycheck {
    private int id;
    private double amount;
    private String payDate;

    public Paycheck(int id, double amount, String payDate) {
        this.id = id;
        this.amount = amount;
        this.payDate = payDate;
    }

    // Геттери
    public double getAmount() { return amount; }
    public String getPayDate() { return payDate; }
    public int getId() { return id; }
}