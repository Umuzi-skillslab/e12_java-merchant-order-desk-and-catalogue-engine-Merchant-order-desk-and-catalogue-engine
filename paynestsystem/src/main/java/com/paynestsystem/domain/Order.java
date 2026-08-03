package com.paynestsystem.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;                 
    private Customer customer;      
    private List<OrderItem> items;  

    
    public Order(int id, Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("An order belongs to a customer");
        }
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    
    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items; 
    }

    
    public void addItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        items.add(new OrderItem(product, quantity));
    }


    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : items) {
            total = total.add(item.calculateTotal());
        }
        return total;
    }


    public void printSummary() {
        new com.paynestsystem.service.OrderSummary().printSummary(this);
    }
}
