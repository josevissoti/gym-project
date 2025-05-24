package com.project.services.strategy.orderfreight;

import com.project.domains.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public interface Freight {

    BigDecimal freightCalcule(List<OrderItem> itens);

}
