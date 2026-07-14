# PayNest — Merchant Order Desk & Catalogue Engine

A Java application for managing merchant orders, customers, and product catalogues.

## Overview

PayNest models a simplified order management system, handling customers, products, and orders (including individual order line items) through a service layer.

## Tech Stack

- **Language:** Java
- **Build Tool:** Apache Maven
- **Package:** `com.paynestsystem.app`

## Project Structure

PayNest/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── paynestsystem/
                    └── app/
                        ├── PayNestApplication.java
                        ├── Customer.java
                        ├── Product.java
                        ├── Order.java
                        ├── OrderItem.java
                        └── OrderService.java

## Prerequisites

- Java JDK 17+
- Apache Maven 3.9+

## Getting Started

1. Clone the repository:
   `bash
   git clone C:\Users\Tshepo Sekobile\OneDrive\Attachments\Documents\Desktop\Capstone 1\merchant-order-desk-and-catalogue-engine-WhatAreWe77
   cd PayNest
   `

2. Compile the project:
   `bash
   mvn compile
   `

3. Run tests:
   `bash
   mvn test
   `

4. Run the application:
   `bash
   mvn exec:java
   `

## Expected Output

    `
    PayNest Invoice Summary
    Order ID: 1
    Customer : Rele-Mbokazi Mkhize
    Email  : mbokazimkhize@yahoo.co.za
    Items Ordered:
    - Samsung Galaxy S26 Ultra x 1 @ R27999.99
    - Samsung Galaxy Watch 6 Classic x 3 @ R4999.99
    Total Amount: R42999.96
    `

## Features

- Customer management
- Product catalogue
- Order creation and tracking
- Order item / line item handling
- Order service layer for business logic

## Author

Tshepo Sekobile

## License

This project is for educational purposes as part of a capstone.
