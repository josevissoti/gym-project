package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CanceledState implements State {

    @Override
    public String getType() {
        return "Canceled";
    }

    @Override
    public void successInPaying(ServiceOrder serviceOrder) {
        try {
            throw new Exception("Operation not supported - Service Order Canceled");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void dispatchOrder(ServiceOrder serviceOrder) {
        try {
            throw new Exception("Operation not supported - Service Order Canceled");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void cancelOrder(ServiceOrder serviceOrder) {
        try {
            throw new Exception("Operation not supported - Service Order Canceled");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
