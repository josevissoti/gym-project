package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;
import com.project.services.exceptions.IllegalOrderStateException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SentState implements State {

    @Override
    public String getType() {
        return "Sent";
    }

    @Override
    public void successInPaying(ServiceOrder serviceOrder) {
        throw new IllegalOrderStateException("Operation not supported - Service already Sent");
    }

    @Override
    public void dispatchOrder(ServiceOrder serviceOrder) {
        throw new IllegalOrderStateException("Operation not supported - Service already Sent");
    }

    @Override
    public void cancelOrder(ServiceOrder serviceOrder) {
        throw new IllegalOrderStateException("Operation not supported - Service already Sent");
    }
}
