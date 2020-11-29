package com.decoratorPattern.decorators;

import java.math.BigDecimal;
import java.util.List;

public class PizzaWithPoultry extends PizzaDecorator implements DiyPizzaOrder {
    private boolean sauce;

    public PizzaWithPoultry(DiyPizzaOrder pizza) {
        super(pizza);
        pizza.addSuggestions(List.of("chicken tenders", "chicken nuggets", "chicken rolls"));
    }

    public void addPoultrySauce(){
        this.pizza.addItemToOrder("poultry sauce");
        sauce = true;
    }

    @Override
    public BigDecimal calculatePrice() {
        BigDecimal price = sauce ? new BigDecimal(3) : new BigDecimal(2);
        return price.add(this.pizza.calculatePrice());
    }
}
