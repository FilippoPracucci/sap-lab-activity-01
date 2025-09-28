package mvc;

public class ControllerInput implements Controller {

    private final Model model;

    public ControllerInput(final Model model) {
        this.model = model;
    }

    @Override
    public void changeState() {
        this.model.update();
    }
}
