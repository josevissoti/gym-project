package com.project.services.strategy.orderfreight;

import com.project.domains.ServiceOrder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FreightService {

    private final Map<String, Freight> mapFreight = Map.of(
            "landFreight", new LandFreight(),
            "airFreight", new AirFreight()
    );

    public void setMapFreight(ServiceOrder serviceOrder){
        Freight freightStrategy = mapFreight.get(serviceOrder.getFreightType());
        if (freightStrategy == null) {
            throw new IllegalArgumentException("Invalid freight type: " + serviceOrder.getFreightType());
        }
        serviceOrder.setFreight(freightStrategy);
    }

}
