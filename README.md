# PayNest Merchant Order Desk and Catalogue Engine

# Overview

PayNest is a lightweight commerce kernel built in plain Java 21. It manages customers, products, and orders with clear domain objects and demonstrates solid Object‑Oriented Programming (OOP) principles. The design emphasizes separation of concerns: domain classes handle data and rules, while the service layer manages presentation and formatting.

# Project Structure

- app - Contains the main application class.
- domain - Contains Customer, Product, Order, and OrderItem classes.
- service- Contains business logic such as printing order details.

# Features

- Create customers
- Create products
- Create orders
- Add items to orders
- Print order information

# Technologies

- Java
- Maven
- VS Code

## Running the Application:

1. clone repo to your local machine: https://github.com/Umuzi-skillslab/merchant-order-desk-and-catalogue-engine-Tshifhiwa13.git 

# Running in the terminal:

1. On Git bash run these commands :

cd merchant-order-desk-and-catalogue-engine-Tshifhiwa13
cd paynestsystem 
mvn clean compile
mvn test
mvn exec:java


# mvn test output 

```text
Tests run: 6
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```
expected outcome

=======================================
************* PAYMENT INVOICE *********
=======================================
Order ID: 35
Customer: Tshifhiwa Makherana
Email: Fifi@example.org
=======================================
Product              Qty        Subtotal
=======================================
Hammer               1          150,00
Electric Drill       1          2000,00
Box of Nails         3          360,00
=======================================
Total Amount:                   2510,00
=======================================.
## classes
### Product
Stores the product ID, name, and price.

 ### Customer 
 Stores the customer ID, name, and email address.

 ### OrderItem 
 Stores a product and its quantity. It also calculates the total price for that product 

 ### Order 
 It never exposes its mutable list.** `getItems()` returns `Collections.unmodifiableList(...)`, so the only way to change an order's contents is `addItem(Product, int)`, which validates quantity > 0.

## Service: 
OrderService 
OrderSummary

-PayNestApplication  demonstrates the full flow: create products, create a customer, create an order, add products, and print a summary.

## Validation

The application checks that the quantity entered for an order item is greater than zero.

If the quantity is zero or negative, an IllegalArgumentException is thrown to prevent invalid orders.

---

Project Structure


MERCHANT-ORDER-DESK-AND-CATALOGUE-ENGINE
└── paynestsystem
    ├── src
    │   ├── main/java/com/paynestsystem
    │   │   ├── app
    │   │   │   └── PayNestApplication.java
    │   │   ├── domain
    │   │   │   ├── Customer.java
    │   │   │   ├── Order.java
    │   │   │   ├── OrderItem.java
    │   │   │   └── Product.java
    │   │   └── service
    │   │       └── OrderService.java
    │   └── test/java/com/paynestsystem
    │       └── OrderItemTest.java
    ├── target
    ├── pom.xml
    └── README.md

## Author

Tshifhiwa Makherana 
