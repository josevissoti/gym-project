package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SentState implements State {

    private ServiceOrder serviceOrder;

    public SentState(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Override
    public void successInPaying() {
        try {
            throw new Exception("Operation not supported - Service already Sent");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void dispatchOrder() {
        try {
            throw new Exception("Operation not supported - Service already Sent");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void cancelOrder() {
        try {
            throw new Exception("Operation not supported - Service already Sent");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
