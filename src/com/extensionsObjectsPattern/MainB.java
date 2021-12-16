package com.extensionsObjectsPattern;

import com.extensionsObjectsPattern.extensions.Poultry;
import com.extensionsObjectsPattern.extensions.Salad;

import java.util.HashSet;
import java.util.Set;

public class MainB {
    public static void main(String[] args) {
        ExtendablePizzaOrder pizza = new ExtendablePizzaOrder();
        Set<Integer> orderItems = new HashSet<>();

        String addSaladMessage = "Please add salad to your pizza to get green sticker.";
        pizza.getExtension(Salad.class).ifPresentOrElse(Salad::addHealthySticker, () -> System.out.println(addSaladMessage));

        pizza.addExtension(new Salad());
        System.out.println(pizza.getSuggestions());
        orderItems.add(1);

        String addPoultryMessage = "Please add poultry to your pizza to add poultry sauce.";
        pizza.getExtension(Poultry.class).ifPresentOrElse(Poultry::addPoultrySauce, () -> System.out.println(addPoultryMessage));

        pizza.addExtension(new Poultry());
        System.out.println(pizza.getSuggestions());
        orderItems.add(7);

        pizza.makeOrderFromSuggestions(orderItems);
        pizza.getExtension(Poultry.class).ifPresentOrElse(Poultry::addPoultrySauce, () -> System.out.println(addPoultryMessage));
        pizza.getExtension(Salad.class).ifPresentOrElse(Salad::addHealthySticker, () -> System.out.println(addSaladMessage));

        System.out.println(pizza.getOrder());
        System.out.println("Price: " + pizza.calculatePrice());
    }
}
