package com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private int paymentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentType")
    private PaymentType paymentType;

    @Column(name = "amount", nullable = false)
    private int amount;

    public enum PaymentType {
        CASH, ONLINE, CREDIT_DEBIT
    }

    // Getters and setters

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Payment(int paymentId, PaymentType paymentType, int amount) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public Payment() {
    }
}
