package bbom.view;

import bbom.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

public class UpdateStateView extends JFrame {

    public UpdateStateView(final Controller controller) {
        super("My BBoM App");
        final JButton updateButton = new JButton("Update");
        final JPanel panel = new JPanel();
        updateButton.addActionListener(controller);
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

    public void log(final String msg) {
        System.out.println("[Output] " + msg);
    }

}
