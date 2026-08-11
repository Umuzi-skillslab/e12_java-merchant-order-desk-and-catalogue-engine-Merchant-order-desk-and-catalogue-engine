package com.paynestsystem.app;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import com.paynestsystem.service.OrderService;

import java.math.BigDecimal;

public class PayNestApplication {

    public static void main(String[] args) {

        Product hammer = new Product(1, "Hammer", BigDecimal.valueOf(150));
        Product drill = new Product(2, "Electric Drill", BigDecimal.valueOf(2000));
        Product nails = new Product(3, "Box of Nails", BigDecimal.valueOf(120));
        Customer customer = new Customer(1, "Tshifhiwa Makherana", "Fifi@example.org");

        OrderService orderService = new OrderService();
        Order order = orderService.createOrder(35, customer);

        orderService.addItem(order, hammer, 1);
        orderService.addItem(order, drill, 1);
        orderService.addItem(order, nails, 3);

        orderService.printInvoice(order);
    }
}
