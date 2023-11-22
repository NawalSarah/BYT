package com.company;

public class PepperoniPizzaBuilder implements PizzaBuilder {
    private final Pizza pizza = new Pizza();

    public void buildDough() {
        pizza.setDough("Pan crust");
    }

    public void buildSauce() {
        pizza.setSauce("Spicy tomato sauce");
    }

    public void buildTopping() {
        pizza.setTopping("Pepperoni and cheese");
    }

    public Pizza getPizza() {
        return pizza;
    }
}
