package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;

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
        try {
            throw new Exception("Operation not supported - Service Order not Paid");
        } catch (Exception e) {
            Logger.getLogger(AwaitingPaymentState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void cancelOrder(ServiceOrder serviceOrder) {
        serviceOrder.setState(new CanceledState());
    }
}
