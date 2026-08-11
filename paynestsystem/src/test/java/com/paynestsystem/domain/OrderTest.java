package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

class OrderTest {
    @Test
    void calculateTotalAddsAllLineSubtotals() {
        Customer customer = new Customer(1, "Tshifhiwa Makherana", "Fifi@example.org");
        Product hammer = new Product(1, "Hammer", BigDecimal.valueOf(150));
        Product drill = new Product(2, "Electric Drill", BigDecimal.valueOf(2000));
        Product nails = new Product(3, "Box of Nails", BigDecimal.valueOf(120));
       Order order =new Order (35, customer);

        order.addItem(hammer, 1);
        order.addItem(drill, 1);
        order.addItem(nails, 3);

        BigDecimal expectedTotal = BigDecimal.valueOf(150 + 2000 + 360);
        assertEquals(0, order.calculateTotal().compareTo(expectedTotal));
    }

    @Test
    void addItemRejectsInvalidQuantity() {
        Customer customer = new Customer(1, "Tshifhiwa Makherana", "Fifi@example.org");
        Product hammer = new Product(1, "Hammer", BigDecimal.valueOf(150));
        Order order = new Order(35, customer);

        assertThrows(IllegalArgumentException.class, () -> order.addItem(hammer, 0));
    }

    @Test
    void getItemsReturnsUnmodifiableList() {
        Customer customer = new Customer(1, "Tshifhiwa Makherana", "Fifi@example.org");
        Product hammer = new Product(1, "Hammer", BigDecimal.valueOf(150));
        Order order = new Order(35, customer);
        order.addItem(hammer, 1);

        List<OrderItem> items = order.getItems();

        assertThrows(UnsupportedOperationException.class, () -> items.add(new OrderItem(hammer, 1)));
    }

    @Test
    void printSummaryShowsInvoiceDetails() {
        Customer customer = new Customer(1, "Tshifhiwa Makherana", "Fifi@example.org");
        Product hammer = new Product(1, "Hammer", BigDecimal.valueOf(150));
        Order order = new Order(35, customer);
        order.addItem(hammer, 1);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            new com.paynestsystem.service.OrderSummary().printSummary(order);
        } finally {
            System.setOut(originalOut);
        }

        String summary = output.toString();
        assertTrue(summary.contains("PAYMENT INVOICE"));
        assertTrue(summary.contains("Hammer"));
        assertTrue(summary.contains("Total Amount:"));
    }
}
