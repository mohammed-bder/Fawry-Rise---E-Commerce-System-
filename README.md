# E-Commerce System (Java - OOP)

This project is a console-based e-commerce system built in **Java** using **OOP principles**, created as a solution to the Fawry Rise Journey Full Stack Internship Challenge.

## 🚀 Features

- Define products with `name`, `price`, and `quantity`
- Handle **expirable** products (like Cheese, Biscuits)
- Handle **shippable** products with `weight` (like Cheese, TV)
- Allow adding items to a cart with specific quantity (not exceeding available quantity)
- Handle cart checkout process with:
  - Subtotal
  - Shipping cost
  - Total amount
  - Customer balance after payment
  - Error handling for empty cart or insufficient balance

## 🧱 Project Structure

```
src/
├── interfaces/
│   ├── Expirable.java
│   └── Shippable.java
├── models/
│   ├── Product.java (abstract)
│   ├── Cheese.java
│   ├── Biscuits.java
│   ├── TV.java
│   └── ScratchCard.java
├── cart/
│   ├── CartItem.java
│   └── Cart.java
├── customer/
│   └── Customer.java
└── Main.java
```

## ✅ Example Use Case

```java
Customer customer = new Customer("Mohammed", 1000);

Product cheese = new Cheese("Cheese", 100, 10, 0.2);     // 200g each
Product biscuits = new Biscuits("Biscuits", 150, 5, 0.7); // 700g each
Product tv = new TV("TV", 300, 3, 2.5);                   // 2.5kg
Product scratchCard = new ScratchCard("Scratch Card", 50, 20);

Cart cart = new Cart();
cart.add(cheese, 2);
cart.add(biscuits, 1);
cart.add(scratchCard, 1);

cart.checkout(customer);
```

## 🖨 Sample Output

```
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
Total package weight 1.10kg
** Checkout receipt **
2x Cheese 200.00
1x Biscuits 150.00
1x Scratch Card 50.00
----------------------
Subtotal 400.00
Shipping 33.00
Amount 433.00
Remaining Balance: 567.00
END.
```

## ⚙️ Technologies Used

- Java 17+
- OOP principles (Encapsulation, Inheritance, Abstraction, Polymorphism)

## 📌 Notes

- `Product` is an abstract class containing shared logic and fields
- `Shippable` and `Expirable` are implemented as interfaces
- Shipping cost is calculated as `30 * total weight (kg)`
- Each shippable product prints its total weight in grams

## 🧠 Author
**Mohammed Hassan**  
[LinkedIn](https://www.linkedin.com/in/mohammed-bder)
