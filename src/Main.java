import cart.Cart;
import customer.Customer;
import models.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Mohammed", 1000);

        Product cheese = new Cheese("Cheese", 100, 10, 0.2); // 200g
        Product biscuits = new Biscuits("Biscuits", 150, 5, 0.7); // 700g
        Product tv = new TV("TV", 300, 3, 2.5); // 2.5kg
        Product scratchCard = new ScratchCard("Scratch Card", 50, 20);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 2);
        cart.add(scratchCard, 1);

        cart.checkout(customer);
    }
}
