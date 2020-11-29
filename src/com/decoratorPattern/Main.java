package com.decoratorPattern;

import com.decoratorPattern.decorators.*;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DiyPizzaOrder pizza = new PizzaWithPoultry(new PizzaWithSalad(new PizzaBase()));

        System.out.println(pizza.getSuggestions());

        pizza.makeOrderFromSuggestions(Set.of(2, 3, 5));

        System.out.println(pizza.getOrder());
        System.out.println("Price: " + pizza.calculatePrice());

        System.out.println(
                "\n===========================================================================\n" +
                "(Add sticker and poultry sauce)" +
                "\n===========================================================================\n"
        );

        Optional<PizzaWithSalad> pS = RoleFinder.getRole((PizzaDecorator) pizza, PizzaWithSalad.class);

        pS.ifPresentOrElse(PizzaWithSalad::addHealthySticker, () -> System.out.println("Please add salad to your pizza to get green sticker."));

        Optional<PizzaWithPoultry> pP = RoleFinder.getRole((PizzaDecorator) pizza, PizzaWithPoultry.class);

        pP.ifPresentOrElse(PizzaWithPoultry::addPoultrySauce, () -> System.out.println("Please add poultry to your pizza to add poultry sauce."));

        System.out.println(pizza.getOrder());
        System.out.println("Price: " + pizza.calculatePrice());
    }
}
