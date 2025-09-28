package mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputSourceStdIn implements InputSource {

    private final List<Controller> controllers;
    private final BufferedReader reader;

    public InputSourceStdIn() {
        this.controllers = new ArrayList<>();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        new Thread(() -> {
            while (true) {
                try {
                    this.reader.readLine();
                    this.controllers.forEach(Controller::changeState);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
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
