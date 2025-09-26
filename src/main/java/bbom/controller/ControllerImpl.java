package bbom.controller;

import bbom.model.State;
import bbom.model.StateImpl;
import bbom.view.UpdateStateView;

import java.awt.event.ActionEvent;

public class ControllerImpl implements Controller {

    private final State state;
    private final UpdateStateView view;

    public ControllerImpl() {
        this.state = new StateImpl();
        this.view = new UpdateStateView(this);
        this.logStateValue();
    }

    @Override
    public int getStateValue() {
        return this.state.getValue();
    }

    @Override
    public void incrementStateValue() {
        this.state.update();
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        this.state.update();
        this.logStateValue();
    }

    private void logStateValue() {
        this.view.log("State value: " + this.state.getValue());
    }
}
