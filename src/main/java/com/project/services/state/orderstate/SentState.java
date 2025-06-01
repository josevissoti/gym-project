package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SentState implements State {

    @Override
    public String getType() {
        return "Sent";
    }

    @Override
    public void successInPaying(ServiceOrder serviceOrder) {
        try {
            throw new Exception("Operation not supported - Service already Sent");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void dispatchOrder(ServiceOrder serviceOrder) {
        try {
            throw new Exception("Operation not supported - Service already Sent");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void cancelOrder(ServiceOrder serviceOrder) {
        try {
            throw new Exception("Operation not supported - Service already Sent");
        } catch (Exception e) {
            Logger.getLogger(CanceledState.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
