package br.com.github.paymentservice.service.impl;

import br.com.github.paymentservice.model.Payment;
import br.com.github.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;
    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Payment Received {}", payment);
        Thread.sleep(1000);

        log.info("Send payment...");
        kafkaTemplate.send("payment-topic", payment);

    }
}
