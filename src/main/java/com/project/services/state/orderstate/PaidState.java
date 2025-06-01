package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PaidState implements State {

    @Override
    public String getType() {
        return "Paid";
    }

    @Override
    public void successInPaying(ServiceOrder serviceOrder) {
        try {
            throw new Exception("Operation not supported - Service already Paid");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
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
