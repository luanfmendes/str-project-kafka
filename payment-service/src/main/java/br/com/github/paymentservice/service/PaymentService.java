package br.com.github.paymentservice.service;

import br.com.github.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
