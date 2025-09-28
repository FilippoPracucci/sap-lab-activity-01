package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

public class ViewGUI extends JFrame implements Observer<Integer> {

    private final JTextPane text = new JTextPane();

    public ViewGUI() {
        super("My BBoM App");
        final JPanel panel = new JPanel();
        this.text.setText("State value: " + 0);
        panel.add(this.text);

        this.setSize(300, 70);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.NORTH);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent ev) {
                System.exit(-1);
            }
        });
        this.text.setSize(this.getWidth(), Double.valueOf(this.getHeight() * 0.6).intValue());

        try {
            SwingUtilities.invokeAndWait(() -> this.setVisible(true));
        } catch (final InterruptedException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onChange(final Integer value) {
        this.text.setText("State value: " + value);
    }
}
