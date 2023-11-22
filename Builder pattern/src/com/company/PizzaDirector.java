package com.company;

public class PizzaDirector {
    public Pizza constructPizza(PizzaBuilder pizzaBuilder) {
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
        return pizzaBuilder.getPizza();
    }
}
