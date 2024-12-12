package com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "placeOrder")
public class PlaceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private int orderId;

    @Column(name = "customername", length = 50)
    private String customerName;

    @Column(name = "qunatity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Menu menu;

    @Column(name ="Bill Amount")
    private int billAmount;

    // Getters and setters
    public int getBillAmount() {
        return billAmount;
    }
    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public PlaceOrder(int orderId, String customerName, int billAmount,int quantity, Menu menu) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.billAmount = billAmount;
        this.quantity = quantity;
        this.menu = menu;
    }

    public PlaceOrder() {
    }
}
