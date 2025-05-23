package com.project.services.strategy.orderfreight;

public class AirFreight implements Freight {
    @Override
    public double freightCalcule(double serviceOrderValue) {
        return serviceOrderValue * 0.1;
    }
}
