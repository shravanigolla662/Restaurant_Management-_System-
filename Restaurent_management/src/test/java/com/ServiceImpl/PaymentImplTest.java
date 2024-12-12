package com.ServiceImpl;

import com.entity.Payment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentImplTest {

    @Test
    void makePayment() {
        Payment payment = new Payment(1, Payment.PaymentType.CASH, 180);
        assertEquals(1, payment.getPaymentId());
        assertEquals(Payment.PaymentType.CASH, payment.getPaymentType());
        assertEquals(180, payment.getAmount());
    }
}
