package cart;

import customer.Customer;
import models.Product;

import java.util.*;

public class Cart {
    List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()){
            throw new IllegalArgumentException("Quantity exceeds available stock for " + product.getName());
        }
        items.add(new CartItem(product, quantity));
        product.reduceQuantity(quantity);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public double getShippingCost() {
        return getTotalWeight() * 30; // 30 per kg
    }

    public double getTotalWeight() {
        return items.stream().mapToDouble(CartItem::getTotalWeight).sum();
    }

    public void checkout(Customer customer) {
        if (isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        double subtotal = getSubtotal();
        double shipping = getShippingCost();
        double total = subtotal + shipping;

        if (!customer.canAfford(total)) {
            throw new IllegalStateException("Insufficient balance");
        }

        System.out.println("** Shipment notice **");
        for (CartItem item : items) {
            if (item.getProduct().isShippable()) {
                double totalGrams = item.getProduct().getWeight() * item.getQuantity() * 1000;
                System.out.printf("%dx %s %.0fg\n", item.getQuantity(), item.getProduct().getName(), totalGrams);
            }
        }
        System.out.printf("Total package weight %.1fkg\n", getTotalWeight());

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shipping);
        System.out.println("Amount " + total);
        customer.pay(total);
        customer.printBalance();
        System.out.println("END.");
    }
}
