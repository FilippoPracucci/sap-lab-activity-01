package bbom.controller;

import java.awt.event.ActionListener;

public interface Controller extends ActionListener {
    int getStateValue();
    void incrementStateValue();
}
