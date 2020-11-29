package com.extensionsObjectsPattern.extensions;

import java.math.BigDecimal;
import java.util.List;

public class Salad implements DiyExtension {
    private boolean sticker;

    public void addHealthySticker() {
        sticker = true;
    }

    @Override
    public BigDecimal modifyPrice(BigDecimal price) {
        return price.add(new BigDecimal(1));
    }

    @Override
    public List<String> getSuggestions() {
        return List.of("iceberg salad", "pickles", "tomatoes");
    }

    @Override
    public void modifyOrder(List<String> order){
        if (sticker) order.add("\n🥦");
    }
}
