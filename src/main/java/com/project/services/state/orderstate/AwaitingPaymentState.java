package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AwaitingPaymentState implements State {

    private ServiceOrder serviceOrder;

    public AwaitingPaymentState(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Override
    public void successInPaying() {
        this.serviceOrder.setCurrentState(new PaidState(serviceOrder));
    }

    @Override
    public void dispatchOrder() {
        try {
            throw new Exception("Operation not supported - Service Order not Paid");
        } catch (Exception e) {
            Logger.getLogger(AwaitingPaymentState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void cancelOrder() {
        this.serviceOrder.setCurrentState(new CanceledState(serviceOrder));
    }
}
