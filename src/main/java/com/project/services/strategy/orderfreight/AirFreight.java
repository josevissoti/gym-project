package com.project.services.strategy.orderfreight;

import com.project.domains.OrderItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class AirFreight implements Freight {

    @Override
    public BigDecimal freightCalcule(List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal sum = BigDecimal.ZERO;
        for (OrderItem item : items) {
            BigDecimal itemValue = item.getProduct().getProductValue()
                    .multiply(BigDecimal.valueOf(item.getQuantity()));
            sum = sum.add(itemValue);
        }
        return sum.multiply(BigDecimal.valueOf(0.1));
    }
}
