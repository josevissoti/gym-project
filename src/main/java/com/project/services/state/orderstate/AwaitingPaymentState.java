package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;
import com.project.services.exceptions.IllegalOrderStateException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AwaitingPaymentState implements State {

    @Override
    public String getType() {
        return "Awaiting Payment";
    }

    @Override
    public void successInPaying(ServiceOrder serviceOrder) {
        serviceOrder.setState(new PaidState());
    }

    @Override
    public void dispatchOrder(ServiceOrder serviceOrder) {
        throw new IllegalOrderStateException("Operation not supported - Service Order not Paid");
    }

    @Override
    public void cancelOrder(ServiceOrder serviceOrder) {
        serviceOrder.setState(new CanceledState());
    }
}
