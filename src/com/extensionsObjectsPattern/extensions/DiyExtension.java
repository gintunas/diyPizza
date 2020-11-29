package com.extensionsObjectsPattern.extensions;

import java.math.BigDecimal;
import java.util.List;

public interface DiyExtension {

    BigDecimal modifyPrice(BigDecimal price);

    List<String> getSuggestions();

    void modifyOrder(List<String> order);

}
