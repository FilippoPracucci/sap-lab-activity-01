package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

public class ViewGUI extends JFrame implements Observer<Integer> {

    private final JTextField field = new JTextField("State value: " + 0);

    public ViewGUI() {
        super("My BBoM App");
        final JPanel panel = new JPanel();
        panel.add(this.field);

        this.setSize(300, 70);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.NORTH);
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
    public void onChange(final Integer value) {
        this.field.setText("State value: " + value);
    }
}
