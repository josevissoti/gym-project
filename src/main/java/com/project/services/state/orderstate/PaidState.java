package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;
import com.project.services.exceptions.IllegalOrderStateException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PaidState implements State {

    @Override
    public String getType() {
        return "Paid";
    }

    @Override
    public void successInPaying(ServiceOrder serviceOrder) {
        throw new IllegalOrderStateException("Operation not supported - Service already Paid");
    }

    @Override
    public void dispatchOrder(ServiceOrder serviceOrder) {
        serviceOrder.setState(new SentState());
    }

    @Override
    public void cancelOrder(ServiceOrder serviceOrder) {
        serviceOrder.setState(new CanceledState());
    }
}
