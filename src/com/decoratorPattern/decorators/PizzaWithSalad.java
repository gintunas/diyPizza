package com.decoratorPattern.decorators;
import java.math.BigDecimal;
import java.util.List;

public class PizzaWithSalad extends PizzaDecorator implements DiyPizzaOrder {
    public PizzaWithSalad(DiyPizzaOrder pizza) {
        super(pizza);
    }

    public void addHealthySticker() {
        this.pizza.addItemToOrder("\n🥦");
    }

    @Override
    public String getSuggestions() {
        this.pizza.addSuggestions(List.of("iceberg salad", "pickles", "tomatoes"));
        return super.getSuggestions();
    }

    @Override
    public BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal(1);
        return price.add(this.pizza.calculatePrice());
    }

}
