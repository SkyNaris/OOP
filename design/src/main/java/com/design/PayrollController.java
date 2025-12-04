package com.design;

import com.google.inject.Inject;
import java.util.List;

public class PayrollController {
    private final PaymentService paymentService;

    @Inject
    public PayrollController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public List<Paycheck> getAllPaychecks() {
        return paymentService.getAllPaychecks();
    }
}