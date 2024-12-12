package com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booktable")
public class BookTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tableid")
    private int tableId;

    @Column(name = "customername", length = 50)
    private String customerName;

    @Column(name = "noofpeople", nullable = false)
    private int noOfPeople;

    // Getters and setters

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public BookTable(int tableId, String customerName, int noOfPeople) {
        this.tableId = tableId;
        this.customerName = customerName;
        this.noOfPeople = noOfPeople;
    }

    public BookTable() {
    }
}
