package com.extensionsObjectsPattern;

import com.extensionsObjectsPattern.extensions.Poultry;
import com.extensionsObjectsPattern.extensions.Salad;

import java.util.Set;

public class Maine {
    public static void main(String[] args) {
        ExtendablePizzaOrder pizza = new ExtendablePizzaOrder();

        pizza.makeOrderFromSuggestions(Set.of(1, 4));

        pizza.addExtension(new Poultry());
        pizza.addExtension(new Salad());

        System.out.println(pizza.getSuggestions());

        pizza.getExtension(Poultry.class).ifPresentOrElse(Poultry::addPoultrySauce, () -> System.out.println("Please add poultry to your pizza to add poultry sauce."));
        pizza.getExtension(Salad.class).ifPresentOrElse(Salad::addHealthySticker, () -> System.out.println("Please add salad to your pizza to get green sticker."));


        System.out.println(pizza.getOrder());
        System.out.println("Price: " + pizza.calculatePrice());
    }
}
