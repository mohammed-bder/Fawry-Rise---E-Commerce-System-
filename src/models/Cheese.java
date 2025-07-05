package models;

import interfaces.Expirable;
import interfaces.Shippable;

public class Cheese extends Product implements Expirable, Shippable {
    private double weight;

    public Cheese(String name, double price, int quantity, double weight) {
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