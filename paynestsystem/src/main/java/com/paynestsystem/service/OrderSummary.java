package com.paynestsystem.service;

import com.paynestsystem.domain.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class OrderSummary {

    public void printSummary(Order order) {
        if (order == null) {
            System.out.println("No order details available.");
            return;
        }

        System.out.println("=======================================");
        System.out.println("************* PAYMENT INVOICE *********");
        System.out.println("=======================================");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Email: " + order.getCustomer().getEmail());
        System.out.println("=======================================");
        System.out.printf("%-20s %-10s %s%n", "Product", "Qty", "Subtotal");
        System.out.println("=======================================");

        for (OrderItem item : order.getItems()) {
            System.out.printf("%-20s %-10d %s%n",
                item.getProduct().getName(),
                item.getQuantity(),
                formatAmount(item.calculateTotal()));
        }

        System.out.println("=======================================");
        System.out.printf("%-31s %s%n", "Total Amount:", formatAmount(order.calculateTotal()));
        System.out.println("=======================================.");
    }

    private String formatAmount(BigDecimal amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ROOT);
        symbols.setDecimalSeparator(',');
        return new DecimalFormat("0.00", symbols).format(amount);
    }
}
