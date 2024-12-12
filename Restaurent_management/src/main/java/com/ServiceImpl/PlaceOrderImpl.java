package com.ServiceImpl;

import com.Service.PlaceOrderService;
import com.entity.Menu;
import com.entity.PlaceOrder;
import com.exceptions.ItemNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class PlaceOrderImpl implements PlaceOrderService {

    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;

    @Override
    public void makeOrder(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();

        PlaceOrder placeOrder = new PlaceOrder();
        System.out.print("Enter customer name: ");
        placeOrder.setCustomerName(sc.next());
        System.out.print("Enter item id: ");
        int mid = sc.nextInt();
        Menu menu = s.get(Menu.class, mid);

        if (menu == null || mid != menu.getItemId()) {
            t.rollback();
            s.close();
            throw new ItemNotFoundException("No item with the id " + mid);
        }

        placeOrder.setMenu(menu);
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        placeOrder.setQuantity(quantity);

        int bill = menu.getPrice() * quantity;
        placeOrder.setBillAmount(bill);

        s.save(placeOrder);
        t.commit();
        s.close();

        System.out.println(
                "Order placed successfully\nYour order id is: " + placeOrder.getOrderId() + "\nYour bill is " + bill);
    }

    @Override
    public void cancelOrder(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        System.out.print("Enter order id: ");
        int oid = sc.nextInt();
        PlaceOrder order = s.get(PlaceOrder.class, oid);
        if (order == null) {
            System.out.println("Order not found with the given ID.");
        } else {
            s.delete(order);
            t.commit();
            System.out.println("Your order cancelled.");
        }
        s.close();
    }

    @Override
    public void getOrderdetails(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();

        System.out.print("Enter your order id: ");
        int oid = sc.nextInt();

        PlaceOrder order = s.get(PlaceOrder.class, oid);
        if (order == null) {
            System.out.println("No order found with the id " + oid);
        } else {
            System.out.println("Your order details:");
            System.out.println("Customer Name: " + order.getCustomerName());
            System.out.println("Item Name: " + order.getMenu().getItemName());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("Bill Amount: " + order.getBillAmount());
        }

        s.close();
    }
}
