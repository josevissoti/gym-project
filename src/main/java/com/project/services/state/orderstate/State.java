package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;

public interface State {

    String getType();

    void successInPaying(ServiceOrder serviceOrder);

    void dispatchOrder(ServiceOrder serviceOrder);

    void cancelOrder(ServiceOrder serviceOrder);

}
