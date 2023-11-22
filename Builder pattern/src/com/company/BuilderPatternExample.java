package com.company;
//The Builder pattern separates the construction of a complex object from its representation,
// allowing the same construction process to create different representations.
public class BuilderPatternExample {
    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector();

        PizzaBuilder margheritaBuilder = new MargheritaPizzaBuilder();
        Pizza margheritaPizza = director.constructPizza(margheritaBuilder);
        margheritaPizza.describePizza(); // Output: Pizza with Thin crust dough, Tomato sauce, and Mozzarella cheese topping.

        PizzaBuilder pepperoniBuilder = new PepperoniPizzaBuilder();
        Pizza pepperoniPizza = director.constructPizza(pepperoniBuilder);
        pepperoniPizza.describePizza(); // Output: Pizza with Pan crust dough, Spicy tomato sauce, and Pepperoni and cheese topping.
    }
}
