package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PaidState implements State {

    private ServiceOrder serviceOrder;

    public PaidState(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Override
    public void successInPaying() {
        try {
            throw new Exception("Operation not supported - Service already Paid");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void dispatchOrder() {
        this.serviceOrder.setCurrentState(new SentState(serviceOrder));
    }

    @Override
    public void cancelOrder() {
        this.serviceOrder.setCurrentState(new CanceledState(serviceOrder));
    }
}
