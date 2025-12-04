package com.design;

import java.util.List;

public class Payroll {
    private List<Paycheck> paychecks;

    public Payroll(List<Paycheck> paychecks) {
        this.paychecks = paychecks;
    }

    public List<Paycheck> getPaychecks() {
        return paychecks;
    }
}