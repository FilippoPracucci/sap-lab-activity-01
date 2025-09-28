package mvc;

import java.util.Timer;
import java.util.TimerTask;

public class AutonomousController {

    private static final int PERIOD_IN_MS = 1000;

    public AutonomousController(final Model model) {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                model.update();
            }
        }, 0, PERIOD_IN_MS);
    }

}
