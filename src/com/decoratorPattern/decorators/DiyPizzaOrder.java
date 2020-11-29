package com.decoratorPattern.decorators;

import com.decoratorPattern.PizzaOrder;

import java.util.List;
import java.util.Set;

public interface DiyPizzaOrder extends PizzaOrder {
    void addSuggestions(List<String> suggestions);
    String getSuggestions();
    void makeOrderFromSuggestions(Set<Integer> ingredientIndices);
}
