package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CanceledState implements State {

    private ServiceOrder serviceOrder;

    public CanceledState(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Override
    public void successInPaying() {
        try {
            throw new Exception("Operation not supported - Service Order Canceled");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void dispatchOrder() {
        try {
            throw new Exception("Operation not supported - Service Order Canceled");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void cancelOrder() {
        try {
            throw new Exception("Operation not supported - Service Order Canceled");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
