package com.project.services.strategy.orderfreight;

import com.project.domains.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class LandFreight implements Freight {
    @Override
    public BigDecimal freightCalcule(List<OrderItem> itens) {
        BigDecimal sum = new BigDecimal(0);
        for (OrderItem item : itens) {
            sum = sum.add(item.getProduct().getProductValue().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return sum.multiply(BigDecimal.valueOf(0.05));
    }
}
