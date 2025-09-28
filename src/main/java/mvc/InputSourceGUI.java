package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class InputSourceGUI extends JFrame implements InputSource, ActionListener {

    private final List<Controller> controllers;

    public InputSourceGUI() {
        super("My BBoM App");
        this.controllers = new ArrayList<>();
        final JButton updateButton = new JButton("Update");
        final JPanel panel = new JPanel();
        updateButton.addActionListener(this);
        panel.add(updateButton);

        this.setSize(300, 70);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(panel,BorderLayout.NORTH);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent ev) {
                System.exit(-1);
            }
        });

        try {
            SwingUtilities.invokeAndWait(() -> this.setVisible(true));
        } catch (final InterruptedException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        this.controllers.forEach(Controller::changeState);
    }

    @Override
    public void attachController(final Controller controller) {
        this.controllers.add(controller);
    }

    @Override
    public void detachController(final Controller controller) {
        this.controllers.remove(controller);
    }
}
