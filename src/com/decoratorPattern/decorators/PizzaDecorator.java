package com.decoratorPattern.decorators;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public abstract class PizzaDecorator implements DiyPizzaOrder {
    protected final DiyPizzaOrder pizza;

    public PizzaDecorator(DiyPizzaOrder pizza) {
        this.pizza = pizza;
    }

    public void addSuggestions(List<String> suggestions) {
        this.pizza.addSuggestions(suggestions);
    }

    public String getSuggestions() {
        return this.pizza.getSuggestions();
    }

    public void addItemToOrder(String item) {
        this.pizza.addItemToOrder(item);
    }

    public abstract BigDecimal calculatePrice();

    public String getOrder() {
        return this.pizza.getOrder();
    }

    public void removeFromOrder(String item) {
        this.pizza.removeFromOrder(item);
    }

    public void clearOrder() {
        this.pizza.clearOrder();
    }

    public void makeOrderFromSuggestions(Set<Integer> ingredientIndices) {
        this.pizza.makeOrderFromSuggestions(ingredientIndices);
    }
}
