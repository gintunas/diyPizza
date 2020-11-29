package com.decoratorPattern.decorators;

import java.util.Optional;

public class RoleFinder {
    public static <T extends PizzaDecorator> Optional<T> getRole(PizzaDecorator decoratorComp, Class<T> classToFind) {
        if (classToFind.isInstance(decoratorComp)) return Optional.of(classToFind.cast(decoratorComp));
        try{
            return getRole((PizzaDecorator) decoratorComp.pizza, classToFind);
        }
        catch (ClassCastException e){
            return Optional.empty();
        }
    }
}
