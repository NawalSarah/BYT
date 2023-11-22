package com.company;

public class MargheritaPizzaBuilder implements PizzaBuilder {
    private final Pizza pizza = new Pizza();

    public void buildDough() {
        pizza.setDough("Thin crust");
    }

    public void buildSauce() {
        pizza.setSauce("Tomato sauce");
    }

    public void buildTopping() {
        pizza.setTopping("Mozzarella cheese");
    }

    public Pizza getPizza() {
        return pizza;
    }
}
