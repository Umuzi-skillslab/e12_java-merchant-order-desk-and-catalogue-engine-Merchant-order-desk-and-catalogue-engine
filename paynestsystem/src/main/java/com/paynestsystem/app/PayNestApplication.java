package com.paynestsystem.app;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import com.paynestsystem.service.OrderService;
import com.paynestsystem.service.OrderSummary;

public class PayNestApplication {

    public static void main(String[] args) {

        Product hammer = new Product(1, "Hammer", 150);
        Product drill = new Product(2, "Electric Drill", 2000);
        Product nails = new Product(3, "Box of Nails", 120);
        Customer customer = new Customer(1, "Tshifhiwa Makherana", "Fifi@example.org");

        Order order =new Order (35, customer);

        order.addItem(hammer, 1);
        order.addItem(drill, 1);
        order.addItem(nails, 3);

       
         OrderSummary orderSummary = new OrderSummary();
        orderSummary.printSummary(order);
    }
}

