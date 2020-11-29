package com.decoratorPattern;

import java.math.BigDecimal;

public interface PizzaOrder {
    void addItemToOrder(String item);

    String getOrder();

    void removeFromOrder(String item);

    void clearOrder();

    BigDecimal calculatePrice();
}
