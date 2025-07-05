package models;

import interfaces.Expirable;
import interfaces.Shippable;

public class Biscuits extends Product implements Expirable, Shippable {
    private double weight;

    public Biscuits(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return true;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
