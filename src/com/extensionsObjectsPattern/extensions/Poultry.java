package com.extensionsObjectsPattern.extensions;

import java.math.BigDecimal;
import java.util.List;

public class Poultry implements DiyExtension {
    private boolean sauce;

    public void addPoultrySauce() {
        sauce = true;
    }

    @Override
    public BigDecimal modifyPrice(BigDecimal price) {
        BigDecimal poultryPrice = sauce ? new BigDecimal(3) : new BigDecimal(2);
        return price.add(poultryPrice);
    }

    @Override
    public List<String> getSuggestions() {
        return List.of("chicken tenders", "chicken nuggets", "chicken rolls");
    }

    @Override
    public void modifyOrder(List<String> order) {
        if (sauce) order.add("poultry sauce");
    }
}
