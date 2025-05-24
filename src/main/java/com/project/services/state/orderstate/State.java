package com.project.services.state.orderstate;

public interface State {

    void successInPaying();

    void dispatchOrder();

    void cancelOrder();

}
