package com.project.services.state.orderstate;

import com.project.domains.ServiceOrder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StateService {

    private final Map<String, State> states = new HashMap<>();

    public StateService() {
        registerState(new AwaitingPaymentState());
        registerState(new PaidState());
        registerState(new SentState());
        registerState(new CanceledState());
    }

    private void registerState(State state) {
        states.put(state.getType(), state);
    }

    public State getState(String type) {
        State state = states.get(type);
        if (state == null) {
            throw new IllegalArgumentException("Unknown state type: " + type);
        }
        return state;
    }

}
