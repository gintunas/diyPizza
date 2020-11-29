package com.extensionsObjectsPattern;

import com.decoratorPattern.PizzaOrder;
import com.extensionsObjectsPattern.extensions.DiyExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.decoratorPattern.PizzaBase.suggestionsToString;

public class ExtendablePizzaOrder implements PizzaOrder {
    private final BigDecimal totalPrice = new BigDecimal("0.5");
    private final List<String> orderItems = new ArrayList<>(List.of("pizza dough"));
    private final List<String> suggestions = new ArrayList<>();

    private final List<DiyExtension> extensions = new ArrayList<>();

    public void addExtension(DiyExtension extension) {
        this.extensions.add(extension);
    }

    public <T extends DiyExtension> Optional<T> getExtension(Class<T> tClass) {
        Optional<T> neededExtension = Optional.empty();
        for (DiyExtension extension : extensions){
            if(tClass.isInstance(extension)) neededExtension =  Optional.of(tClass.cast(extension));
        }
        return neededExtension;
    }

    public String getSuggestions() {
        fillSuggestions();
        return suggestionsToString(suggestions);
    }

    private void fillSuggestions() {
        for (DiyExtension extension : extensions) {
            suggestions.addAll(extension.getSuggestions());
        }
    }

    public void makeOrderFromSuggestions(Set<Integer> ingredientIndices) {
        for (int index : ingredientIndices) {
            try {
                orderItems.add(this.suggestions.get(index));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid ingredient indices or no suggestions formulated.");
            }
        }
    }

    @Override
    public void addItemToOrder(String item) {
        this.orderItems.add(item);
    }

    @Override
    public String getOrder() {
        modifyOrder();
        return "\nOrder items: " + this.orderItems.toString();
    }

    private void modifyOrder() {
        for (DiyExtension extension : extensions) {
            extension.modifyOrder(orderItems);
        }
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
    public BigDecimal calculatePrice() {
        BigDecimal price = this.totalPrice;
        for (DiyExtension extension : extensions) {
            price = extension.modifyPrice(price);
        }
        return price;
    }
}
