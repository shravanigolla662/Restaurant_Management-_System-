package com.ServiceImpl;

import com.Service.PaymentService;
import com.entity.Payment;
import com.entity.PlaceOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class PaymentImpl implements PaymentService {
    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;

    @Override
    public void makepayment(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();

        try {
            System.out.print("Enter your order id: ");
            int oid = sc.nextInt();

            PlaceOrder order1 = s.get(PlaceOrder.class, oid);
            if (order1 == null) {
                System.out.println("Order not found with the given ID.");
                return;
            }

            System.out.println("Your bill is: " + order1.getBillAmount());

            Payment payment = new Payment();
            System.out.print("\n1. CASH\n2. ONLINE\n3. CREDIT/DEBIT\nEnter your payment method: ");
            int paymentMethod = sc.nextInt();
            Payment.PaymentType paymentType = null;

            // Convert input to PaymentType
            switch (paymentMethod) {
                case 1:
                    paymentType = Payment.PaymentType.CASH;
                    break;
                case 2:
                    paymentType = Payment.PaymentType.ONLINE;
                    break;
                case 3:
                    paymentType = Payment.PaymentType.CREDIT_DEBIT;
                    break;
                default:
                    System.out.println("Invalid payment method selected.");
                    return;
            }
            payment.setPaymentType(paymentType);

            System.out.print("Enter amount to pay: ");
            int pay = sc.nextInt();

            if (pay == order1.getBillAmount()) {
                payment.setAmount(pay);
                System.out.println("You paid the bill.");
                s.save(payment);
            } else if (pay > order1.getBillAmount()) {
                int remain = pay - order1.getBillAmount();
                System.out.println("You paid more: " + remain + "\n");
                System.out.print("Would you like to have the change or make it as a tip?\n1. Change\n2. Tip\nYour choice: ");
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("Here is your change: " + remain);
                } else {
                    System.out.println("Thank you for the tip.");
                }
                payment.setAmount(order1.getBillAmount());
                s.save(payment);
            } else if (pay < order1.getBillAmount()) {
                int remaining = order1.getBillAmount() - pay;
                System.out.println("You need to pay more: " + remaining);
            } else {
                System.out.println("Payment unsuccessful.");
            }

            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            s.close();
        }
    }
}
