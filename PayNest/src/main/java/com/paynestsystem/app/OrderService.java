package com.paynestsystem.app;

public class OrderService {
    public void printSummary(Order order) {
        if (order == null) {
            System.out.println("No order summary available.");
            return;
        }
        System.out.println("PayNest Invoice Summary");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Customer : " + order.getCustomer().getName());
        System.out.println("Email  : " + order.getCustomer().getEmail());
        System.out.println("Items Ordered:");
        for (OrderItem item: order.getItems()) {
            System.out.println("- " + item.getProduct().getName() + " x " + item.getQuantity() + " @ R" + item.getProduct().getPrice());}
        System.out.println("Total Amount: R" + order.calculateTotal());
    }
}
    

