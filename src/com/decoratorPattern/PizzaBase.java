package com.decoratorPattern;

import com.decoratorPattern.decorators.DiyPizzaOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PizzaBase implements DiyPizzaOrder {
    private final List<String> suggestions = new ArrayList<>();
    private final List<String> orderItems = new ArrayList<>(List.of("pizza dough"));
    private final BigDecimal totalPrice = new BigDecimal("0.5");

    @Override
    public void addSuggestions(List<String> suggestions) {
        this.suggestions.addAll(suggestions);
    }

    @Override
    public String getSuggestions() {
        return suggestionsToString(suggestions);
    }

    public static String suggestionsToString(List<String> suggestions) {
        StringBuilder builder = new StringBuilder();
        builder.append("\nSuggestions:\n------------------------------------------------------------------\n");
        for (int i = 0; i < suggestions.size(); i++) {
            builder.append(i).append(": ").append(suggestions.get(i)).append("\n");
        }
        builder.append("------------------------------------------------------------------\n");
        return builder.toString();
    }

    @Override
    public void addItemToOrder(String item) {
        this.orderItems.add(item);
    }

    @Override
    public void removeFromOrder(String item) {
        this.orderItems.remove(item);
    }

    @Override
    public void clearOrder() {
        this.orderItems.clear();
        this.orderItems.add("pizza dough");
    }

    @Override
    public String getOrder() {
        return "\nOrder items: " +
                this.orderItems.toString();
    }

    @Override
    public void makeOrderFromSuggestions(Set<Integer> ingredientIndices) {
        for (int index : ingredientIndices) {
            try {
                orderItems.add(this.suggestions.get(index));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid ingredient indices");
            }
        }
    }

    @Override
    public BigDecimal calculatePrice() {
        return this.totalPrice;
    }
}
